package de.darkatra.bfme2.ini.formatting

import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiDocumentManager

object SageEngineDocumentUtil {

    private fun getDocument(project: Project, psiFile: PsiFile): Document? =
        PsiDocumentManager.getInstance(project).getDocument(psiFile)

    fun hasLineBreakBetween(leftPsi: PsiElement, rightPsi: PsiElement): Boolean {
        val project = leftPsi.project
        val psiFile = leftPsi.containingFile ?: return false
        val doc = getDocument(project, psiFile) ?: return false
        return doc.getLineNumber(leftPsi.textRange.startOffset) !=
            doc.getLineNumber(rightPsi.textRange.startOffset)
    }

    fun getLineIndent(element: PsiElement, tabWidth: Int): Int {
        val psiFile = element.containingFile ?: return 0
        val project = element.project
        val doc = getDocument(project, psiFile) ?: return 0
        val lineNumber = doc.getLineNumber(element.textRange.startOffset)
        val lineStart = doc.getLineStartOffset(lineNumber)
        var indent = 0
        for (offset in lineStart until element.textRange.startOffset) {
            val ch = doc.charsSequence[offset]
            if (ch == '\t') indent += tabWidth
            else if (ch == ' ') indent++
        }
        return indent
    }

    fun isAtLineStart(element: PsiElement): Boolean {
        val psiFile = element.containingFile ?: return true
        val project = element.project
        val doc = getDocument(project, psiFile) ?: return true
        val lineNumber = doc.getLineNumber(element.textRange.startOffset)
        val lineStart = doc.getLineStartOffset(lineNumber)
        for (offset in lineStart until element.textRange.startOffset) {
            val ch = doc.charsSequence[offset]
            if (!Character.isWhitespace(ch)) return false
        }
        return true
    }

    fun containsBlankLine(text: String): Boolean {
        var lineBreaks = 0
        for (char in text) {
            if (char == '\n' && ++lineBreaks == 2) return true
        }
        return false
    }
}
