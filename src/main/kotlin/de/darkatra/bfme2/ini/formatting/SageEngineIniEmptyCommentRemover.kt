package de.darkatra.bfme2.ini.formatting

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiRecursiveElementWalkingVisitor
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

object SageEngineIniEmptyCommentRemover {

    fun removeEmptyCommentsAtEndOfLine(file: PsiFile, range: TextRange): TextRange {

        val fileText = file.text
        val commentsToDelete = mutableListOf<PsiElement>()

        file.accept(object : PsiRecursiveElementWalkingVisitor() {
            override fun visitElement(e: PsiElement) {
                val elementRange = e.textRange
                if (e !== file && !elementRange.intersects(range) && !elementRange.contains(range)) {
                    return
                }

                val node = e.node

                if (
                    node?.elementType == SageEngineIniTokenTypes.COMMENT_START &&
                    elementRange.intersects(range) &&
                    lineBeforeCommentContainsNonWhitespaceNode(fileText, elementRange.startOffset) &&
                    hasOnlyWhitespaceUntilLineEnd(fileText, elementRange.endOffset)
                ) {
                    commentsToDelete += e
                    return
                }

                super.visitElement(e)
            }
        })

        if (commentsToDelete.isEmpty()) {
            return range
        }

        var removedBeforeRangeEnd = 0

        for (commentStart in commentsToDelete.sortedByDescending { it.textRange.startOffset }) {
            if (!commentStart.isValid) continue

            val oldRange = commentStart.textRange
            val removedLength = oldRange.length

            commentStart.delete()

            if (oldRange.startOffset < range.endOffset) {
                removedBeforeRangeEnd += minOf(removedLength, range.endOffset - oldRange.startOffset)
            }
        }

        return TextRange(
            range.startOffset,
            (range.endOffset - removedBeforeRangeEnd).coerceAtLeast(range.startOffset)
        )
    }

    private fun lineBeforeCommentContainsNonWhitespaceNode(text: String, commentStartOffset: Int): Boolean {
        var offset = commentStartOffset - 1
        while (offset >= 0) {
            val char = text[offset]
            if (char == '\n' || char == '\r') {
                return false
            }
            if (!char.isWhitespace()) {
                return true
            }
            offset--
        }

        return false
    }

    private fun hasOnlyWhitespaceUntilLineEnd(text: String, fromOffset: Int): Boolean {

        var i = fromOffset
        while (i < text.length) {
            when (val c = text[i]) {
                '\n', '\r' -> return true
                else -> {
                    if (!c.isWhitespace()) return false
                }
            }

            i++
        }

        return true
    }
}
