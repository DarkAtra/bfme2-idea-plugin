package de.darkatra.bfme2.ini.formatting

import com.intellij.formatting.Alignment
import com.intellij.formatting.Block
import com.intellij.formatting.ChildAttributes
import com.intellij.formatting.Indent
import com.intellij.formatting.Spacing
import com.intellij.formatting.Spacing.createSpacing
import com.intellij.formatting.Wrap
import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.TokenType
import com.intellij.psi.codeStyle.CodeStyleSettings
import com.intellij.psi.tree.IElementType
import de.darkatra.bfme2.ini.psi.SageEngineIniElementTypes
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

class SageEngineIniFormattingBlock(
    private val node: ASTNode,
    private val codeStyleSettings: CodeStyleSettings,
    private val indent: Indent,
    private val alignment: Alignment?,
    private val spacingAfter: Spacing? = null,
) : Block {

    private var children: List<Block>? = null

    override fun getTextRange(): TextRange {
        return node.textRange
    }

    override fun getSubBlocks(): List<Block> {
        if (isLeaf) {
            return emptyList()
        }
        return children ?: buildSubBlocks().also { children = it }
    }

    override fun getWrap(): Wrap? {
        return null
    }

    override fun getIndent(): Indent {
        return indent
    }

    override fun getAlignment(): Alignment? {
        return alignment
    }

    override fun getSpacing(child1: Block?, child2: Block): Spacing? {

        val left = child1 as? SageEngineIniFormattingBlock
            ?: return null
        val right = child2 as? SageEngineIniFormattingBlock
            ?: return null

        if (left.spacingAfter != null && !SageEngineDocumentUtil.hasLineBreakBetween(left.node.psi, right.node.psi)) {
            return left.spacingAfter
        }

        if (right.node.elementType == SageEngineIniTokenTypes.COMMENT_START && !SageEngineDocumentUtil.hasLineBreakBetween(left.node.psi, right.node.psi)) {
            return createSpacing(1, 1, 0, false, 0)
        }

        if (left.node.elementType == SageEngineIniTokenTypes.COMMENT_START &&
            right.node.elementType == SageEngineIniTokenTypes.COMMENT_SPACER
        ) {
            return createSpacing(0, 0, 0, false, 0)
        }

        if (left.node.elementType == SageEngineIniTokenTypes.COMMENT_SPACER &&
            right.node.elementType == SageEngineIniTokenTypes.COMMENT_SPACER
        ) {
            return createSpacing(0, 0, 0, false, 0)
        }

        if (left.node.elementType == SageEngineIniTokenTypes.COMMENT_WORD &&
            right.node.elementType == SageEngineIniTokenTypes.COMMENT_WORD
        ) {
            return createSpacing(1, 1, 0, false, 0)
        }

        if (
            (left.node.elementType == SageEngineIniTokenTypes.COMMENT_WORD &&
                right.node.elementType == SageEngineIniTokenTypes.COMMENT_SPACER)
            || (left.node.elementType == SageEngineIniTokenTypes.COMMENT_START &&
                right.node.elementType == SageEngineIniTokenTypes.COMMENT_WORD)
        ) {
            return createSpacing(1, 1, 0, false, 0)
        }

        if (left.node.elementType == SageEngineIniTokenTypes.COMMENT_SPACER &&
            right.node.elementType == SageEngineIniTokenTypes.COMMENT_WORD
        ) {
            return createSpacing(1, 1, 0, false, 0)
        }

        if (!SageEngineDocumentUtil.hasLineBreakBetween(left.node.psi, right.node.psi)) {
            macroSpacing(left.node, right.node)?.let { return it }
        }

        if (right.node.elementType != SageEngineIniTokenTypes.EQUALS && left.node.elementType != SageEngineIniTokenTypes.EQUALS) {
            if (isValuePart(left.node) && isValuePart(right.node) && !SageEngineDocumentUtil.hasLineBreakBetween(left.node.psi, right.node.psi)) {
                return createSpacing(1, 1, 0, false, 0)
            }
            return null
        }

        if (SageEngineDocumentUtil.hasLineBreakBetween(left.node.psi, right.node.psi)) {
            return createSpacing(0, Int.MAX_VALUE, 1, true, 1)
        }

        return createSpacing(1, 1, 0, false, 0)
    }

    override fun getChildAttributes(newChildIndex: Int): ChildAttributes {
        val previousChild = subBlocks.take(newChildIndex).lastOrNull() as? SageEngineIniFormattingBlock

        if (previousChild?.node?.elementType != null && previousChild.node.elementType != TokenType.WHITE_SPACE) {
            val previousChildIndent = when {
                previousChild.node.elementType == SageEngineIniTokenTypes.BLOCK_START && SageEngineDocumentUtil.isAtLineStart(previousChild.node.psi) -> {
                    Indent.getSpaceIndent(
                        SageEngineDocumentUtil.getLineIndent(
                            previousChild.node.psi,
                            codeStyleSettings.indentOptions.INDENT_SIZE
                        ) + codeStyleSettings.indentOptions.INDENT_SIZE
                    )
                }

                else -> previousChild.indent
            }

            return ChildAttributes(previousChildIndent, null)
        }

        return ChildAttributes(Indent.getNormalIndent(), null)
    }

    override fun isIncomplete(): Boolean {
        return false
    }

    override fun isLeaf(): Boolean {
        return node.firstChildNode == null
    }

    private fun buildSubBlocks(): List<Block> {

        val blocks = mutableListOf<Block>()
        val alignments = mutableMapOf<Int, Alignment>()
        val defineAlignments = mutableMapOf<Int, Alignment>()
        var defineTokensOnLine = 0
        var defineKeywordLength = 0
        var directives = SageEngineIniFormatterDirectives()
        val text = node.text
        val children = flattenedFormattingChildren(node)
        var previousSignificantChild: ASTNode? = null
        var blockDepth = 0
        var scriptBodyBaseIndent: Int? = null

        for (child in children) {
            // only adjacent properties of the same block have aligned values, so blank lines, nested blocks and block ends start a new group
            if ((child.elementType == TokenType.WHITE_SPACE && SageEngineDocumentUtil.containsBlankLine(child.text)) ||
                ((child.elementType == SageEngineIniTokenTypes.BLOCK_START || child.elementType == SageEngineIniTokenTypes.BLOCK_END) &&
                    SageEngineDocumentUtil.isAtLineStart(child.psi))
            ) {
                alignments.clear()
                if (!directives.alignAllDefines) {
                    defineAlignments.clear()
                }
            }

            // comments like `; @formatter:align=all` change the formatting of the lines below them
            if (child.elementType == SageEngineIniTokenTypes.COMMENT_START) {
                val commentStart = child.startOffset - node.startOffset
                val commentEnd = text.indexOf('\n', commentStart).takeIf { it >= 0 } ?: text.length
                directives.applying(text.substring(commentStart, commentEnd))?.let {
                    directives = it
                    defineAlignments.clear()
                }
            }

            // counts the tokens of a `#define NAME VALUE` line to find its value
            if (child.elementType == TokenType.WHITE_SPACE && child.textContains('\n')) {
                defineTokensOnLine = 0
            } else if (child.elementType != TokenType.WHITE_SPACE) {
                defineTokensOnLine = if (isDefine(child)) 1 else if (defineTokensOnLine > 0) defineTokensOnLine + 1 else 0
                if (isDefine(child)) {
                    defineKeywordLength = child.textLength
                }
            }

            // align property values
            if (child.elementType != TokenType.WHITE_SPACE) {
                val childIndent = when (child.elementType) {
                    SageEngineIniTokenTypes.BLOCK_END if SageEngineDocumentUtil.isAtLineStart(child.psi) -> (blockDepth - 1).coerceAtLeast(0)
                    SageEngineIniTokenTypes.SCRIPT_BODY -> {
                        val scriptBodyIndent = SageEngineDocumentUtil.getLineIndent(
                            child.psi,
                            codeStyleSettings.indentOptions.INDENT_SIZE
                        ) / codeStyleSettings.indentOptions.INDENT_SIZE
                        val baseIndent = scriptBodyBaseIndent ?: scriptBodyIndent.also { scriptBodyBaseIndent = it }
                        blockDepth + (scriptBodyIndent - baseIndent).coerceAtLeast(0)
                    }

                    else -> blockDepth
                }

                blocks += SageEngineIniFormattingBlock(
                    child,
                    codeStyleSettings,
                    Indent.getSpaceIndent(childIndent * codeStyleSettings.indentOptions.INDENT_SIZE),
                    when {
                        child.elementType == SageEngineIniTokenTypes.EQUALS && previousSignificantChild?.elementType == SageEngineIniTokenTypes.PROPERTY -> {
                            alignments.getOrPut(childIndent) { Alignment.createAlignment(true) }
                        }

                        // the values of consecutive defines line up, e.g. `#define DEFAULT_REGION_ARMY_BONUS_GOOD   20`
                        defineTokensOnLine == DEFINE_VALUE_POSITION -> {
                            defineAlignments.getOrPut(childIndent) { Alignment.createAlignment(true) }
                        }

                        else -> null
                    },
                    if (defineTokensOnLine == DEFINE_NAME_POSITION) defineValueSpacing(directives, childIndent, defineKeywordLength, child) else null,
                )

                previousSignificantChild = child
            }

            // keep track of block indentation level
            if (child.elementType == SageEngineIniTokenTypes.BLOCK_START && SageEngineDocumentUtil.isAtLineStart(child.psi)) {
                blockDepth++
            }
            if (child.elementType == SageEngineIniTokenTypes.BLOCK_END && SageEngineDocumentUtil.isAtLineStart(child.psi)) {
                blockDepth = (blockDepth - 1).coerceAtLeast(0)
                if (child.text.equals("EndScript", true)) {
                    scriptBodyBaseIndent = null
                }
            }
        }

        return blocks
    }

    private fun flattenedFormattingChildren(parent: ASTNode): List<ASTNode> {
        val children = mutableListOf<ASTNode>()
        var child = parent.firstChildNode
        while (child != null) {
            if (isStructuredElement(child)) {
                children += flattenedFormattingChildren(child)
            } else if (child.textLength > 0) {
                children += child
            }
            child = child.treeNext
        }
        return children
    }

    private fun isStructuredElement(node: ASTNode): Boolean {
        return node.elementType == SageEngineIniElementTypes.BLOCK ||
            node.elementType == SageEngineIniElementTypes.PROPERTY_ASSIGNMENT ||
            node.elementType == SageEngineIniElementTypes.MACRO_STATEMENT ||
            node.elementType == SageEngineIniElementTypes.SCRIPT_BLOCK
    }

    // `#define NAME VALUE`, `#include "file"` and expressions like `#ADD( BASE_DAMAGE 25 )`
    private fun macroSpacing(left: ASTNode, right: ASTNode): Spacing? {
        val singleSpace = createSpacing(1, 1, 0, false, 0)
        return when {
            left.elementType == SageEngineIniTokenTypes.MACRO && right.elementType == SageEngineIniTokenTypes.LPAREN -> createSpacing(0, 0, 0, false, 0)
            left.elementType == SageEngineIniTokenTypes.MACRO -> singleSpace
            isExpressionParenthesis(left, SageEngineIniTokenTypes.LPAREN) || isExpressionParenthesis(right, SageEngineIniTokenTypes.RPAREN) -> singleSpace
            isExpressionParenthesis(left, SageEngineIniTokenTypes.RPAREN) && (isValuePart(right) || right.elementType == SageEngineIniTokenTypes.MACRO) -> singleSpace
            isDefineName(left) -> singleSpace
            isValuePart(left) && right.elementType == SageEngineIniTokenTypes.MACRO -> singleSpace
            else -> null
        }
    }

    // only the parentheses of expressions, names like `MGAmonH_Aragorn030(b)` keep theirs
    private fun isExpressionParenthesis(node: ASTNode, type: IElementType): Boolean {
        return node.elementType == type && node.treeParent?.elementType == SageEngineIniElementTypes.MACRO_STATEMENT
    }

    // the spaces after the name of a define that let its value start at the column a comment asks for
    private fun defineValueSpacing(directives: SageEngineIniFormatterDirectives, indent: Int, keywordLength: Int, name: ASTNode): Spacing? {
        if (directives.defineValueColumn <= 1) {
            return null
        }
        val nameEnd = indent * codeStyleSettings.indentOptions.INDENT_SIZE + keywordLength + 1 + name.textLength
        val spaces = (directives.defineValueColumn - 1 - nameEnd).coerceAtLeast(1)
        return createSpacing(spaces, spaces, 0, false, 0)
    }

    private fun isDefine(node: ASTNode): Boolean {
        return node.elementType == SageEngineIniTokenTypes.MACRO && node.text.equals("#define", ignoreCase = true)
    }

    private fun isDefineName(node: ASTNode): Boolean {
        var previous = node.treePrev
        while (previous != null && previous.elementType == TokenType.WHITE_SPACE && !previous.textContains('\n')) {
            previous = previous.treePrev
        }
        return previous != null && isDefine(previous)
    }

    private fun isValuePart(node: ASTNode): Boolean {
        return node.elementType == SageEngineIniTokenTypes.VALUE ||
            node.elementType == SageEngineIniTokenTypes.NUMBER ||
            node.elementType == SageEngineIniTokenTypes.STRING ||
            node.elementType == SageEngineIniTokenTypes.BLOCK_START
    }

    private companion object {

        // `#define` is the first token of the line, the name the second and the value the third
        const val DEFINE_NAME_POSITION = 2
        const val DEFINE_VALUE_POSITION = 3
    }
}
