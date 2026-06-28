package de.darkatra.bfme2.ini.folding

import com.intellij.lang.ASTNode
import com.intellij.lang.folding.FoldingBuilderEx
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiRecursiveElementWalkingVisitor
import de.darkatra.bfme2.ini.psi.SageEngineIniBlock
import de.darkatra.bfme2.ini.psi.SageEngineIniElementTypes
import de.darkatra.bfme2.ini.psi.SageEngineIniScriptBlock

class SageEngineIniFoldingBuilder : FoldingBuilderEx() {

    override fun buildFoldRegions(root: PsiElement, document: Document, quick: Boolean): Array<FoldingDescriptor> {
        val descriptors = mutableListOf<FoldingDescriptor>()

        root.accept(
            object : PsiRecursiveElementWalkingVisitor() {

                override fun visitElement(element: PsiElement) {
                    super.visitElement(element)

                    if (element is SageEngineIniBlock || element is SageEngineIniScriptBlock) {
                        val textRange = element.textRange
                        if (document.getLineNumber(textRange.startOffset) < document.getLineNumber(textRange.endOffset)) {
                            descriptors += FoldingDescriptor(element.node, textRange)
                        }
                    }
                }
            }
        )

        return descriptors.toTypedArray()
    }

    override fun getPlaceholderText(node: ASTNode): String {
        return when (node.elementType) {
            SageEngineIniElementTypes.SCRIPT_BLOCK -> "BeginScript ... EndScript"
            else -> "..."
        }
    }

    override fun isCollapsedByDefault(node: ASTNode): Boolean {
        return false
    }
}