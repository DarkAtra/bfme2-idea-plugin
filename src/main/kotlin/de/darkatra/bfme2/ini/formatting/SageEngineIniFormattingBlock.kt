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
import com.intellij.psi.PsiElement
import com.intellij.psi.TokenType
import com.intellij.psi.codeStyle.CodeStyleSettings
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

class SageEngineIniFormattingBlock(
    private val node: ASTNode,
    private val codeStyleSettings: CodeStyleSettings,
    private val indent: Indent,
    private val alignment: Alignment?,
) : Block {

    private val children: List<Block> by lazy { buildSubBlocks() }

    override fun getTextRange(): TextRange {
        return node.textRange
    }

    override fun getSubBlocks(): List<Block> {
        return children
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

        if (right.node.elementType != SageEngineIniTokenTypes.EQUALS && left.node.elementType != SageEngineIniTokenTypes.EQUALS) {
            return null
        }

        return createSpacing(1, 1, 0, false, 0)
    }

    override fun getChildAttributes(newChildIndex: Int): ChildAttributes {
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
        var child = node.firstChildNode
        var previousSignificantChild: ASTNode? = null
        var blockDepth = 0

        while (child != null) {

            // reset indentation when encountering a blank line - this ensures that only adjacent properties have aligned values
            if (child.elementType == TokenType.WHITE_SPACE && containsBlankLine(child.text)) {
                alignments.clear()
            }

            // align property values
            if (child.elementType != TokenType.WHITE_SPACE) {
                val childIndent = when {
                    child.elementType == SageEngineIniTokenTypes.BLOCK_END && isAtLineStart(child.psi) -> (blockDepth - 1).coerceAtLeast(0)
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
            if (child.elementType == SageEngineIniTokenTypes.BLOCK_START && isAtLineStart(child.psi)) {
                blockDepth++
            }
            if (child.elementType == SageEngineIniTokenTypes.BLOCK_END && isAtLineStart(child.psi)) {
                blockDepth = (blockDepth - 1).coerceAtLeast(0)
            }

            child = child.treeNext
        }

        return blocks
    }

    private fun containsBlankLine(text: String): Boolean {
        return text.count { it == '\n' } >= 2
    }

    private fun isAtLineStart(element: PsiElement): Boolean {
        val text = element.containingFile.text
        var offset = element.textRange.startOffset - 1
        while (offset >= 0) {
            val char = text[offset]
            if (char == '\n' || char == '\r') {
                return true
            }
            if (!Character.isWhitespace(char)) {
                return false
            }
            offset--
        }
        return true
    }
}
