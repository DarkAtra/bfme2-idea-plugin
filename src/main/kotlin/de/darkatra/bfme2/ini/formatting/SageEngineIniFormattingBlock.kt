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
import de.darkatra.bfme2.ini.psi.SageEngineIniElementTypes
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

class SageEngineIniFormattingBlock(
    private val node: ASTNode,
    private val codeStyleSettings: CodeStyleSettings,
    private val indent: Indent,
    private val alignment: Alignment?,
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
        val children = flattenedFormattingChildren(node)
        var previousSignificantChild: ASTNode? = null
        var blockDepth = 0
        var scriptBodyBaseIndent: Int? = null

        for (child in children) {
            // reset indentation when encountering a blank line - this ensures that only adjacent properties have aligned values
            if (child.elementType == TokenType.WHITE_SPACE && SageEngineDocumentUtil.containsBlankLine(child.text)) {
                alignments.clear()
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
                    when (child.elementType) {
                        SageEngineIniTokenTypes.EQUALS if previousSignificantChild?.elementType == SageEngineIniTokenTypes.PROPERTY -> {
                            alignments.getOrPut(childIndent) { Alignment.createAlignment(true) }
                        }

                        else -> null
                    },
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
            } else {
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
            node.elementType == SageEngineIniElementTypes.COMMENT ||
            node.elementType == SageEngineIniElementTypes.SCRIPT_BLOCK
    }

    private fun isValuePart(node: ASTNode): Boolean {
        return node.elementType == SageEngineIniTokenTypes.VALUE ||
            node.elementType == SageEngineIniTokenTypes.NUMBER ||
            node.elementType == SageEngineIniTokenTypes.STRING ||
            node.elementType == SageEngineIniTokenTypes.BLOCK_START
    }
}
