package de.darkatra.bfme2.ini.validation

import com.intellij.codeInspection.LocalQuickFix
import com.intellij.codeInspection.ProblemDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiWhiteSpace
import com.intellij.util.text.EditDistance

/**
 * Finds known names that are likely meant by a misspelled [name], closest first. Matching ignores case like the engine does.
 */
fun similarNames(name: String, candidates: Iterable<String>, limit: Int = 3): List<String> {
    return candidates.asSequence()
        .distinctBy { it.lowercase() }
        .filterNot { it.equals(name, ignoreCase = true) }
        .map { it to similarity(name, it) }
        .filter { (_, similarity) -> similarity >= MIN_SIMILARITY }
        .sortedByDescending { (_, similarity) -> similarity }
        .take(limit)
        .map { (candidate, _) -> candidate }
        .toList()
}

// high on purpose: a misleading suggestion is worse than none
private const val MIN_SIMILARITY = 0.8

private fun similarity(a: String, b: String): Double {
    val distance = EditDistance.optimalAlignment(a, b, false)
    return 1.0 - distance.toDouble() / maxOf(a.length, b.length)
}

fun replaceWithSimilarNameFixes(name: String, candidates: Iterable<String>, prefix: String = ""): Array<LocalQuickFix> {
    return similarNames(name, candidates)
        .map { SageEngineIniReplaceTextQuickFix(prefix + it) }
        .toTypedArray()
}

/**
 * Replaces the highlighted range of a problem with [replacement].
 */
class SageEngineIniReplaceTextQuickFix(private val replacement: String) : LocalQuickFix {

    override fun getName(): String = "Change to '$replacement'"

    override fun getFamilyName(): String = "Change to similar name"

    override fun applyFix(project: Project, descriptor: ProblemDescriptor) {
        val element = descriptor.psiElement ?: return
        val range = (descriptor.textRangeInElement ?: TextRange(0, element.textLength)).shiftRight(element.textRange.startOffset)
        element.editDocument(project) { it.replaceString(range.startOffset, range.endOffset, replacement) }
    }
}

/**
 * Removes the line of a property assignment that is overridden by a later assignment of the same property.
 */
class SageEngineIniRemoveAssignmentQuickFix : LocalQuickFix {

    override fun getFamilyName(): String = "Remove overridden assignment"

    override fun applyFix(project: Project, descriptor: ProblemDescriptor) {
        val assignment = descriptor.psiElement?.parent ?: return
        assignment.editDocument(project) { document ->
            val range = assignment.textRange
            val line = document.getLineNumber(range.startOffset)
            val lineStart = document.getLineStartOffset(line)
            val lineEnd = document.getLineEndOffset(line)

            // the assignment can follow another statement on the same line, e.g. `End StateName = Sword`
            if (document.getText(TextRange(lineStart, range.startOffset)).isNotBlank()) {
                document.deleteString(range.startOffset, range.endOffset)
            } else {
                document.deleteString(lineStart, minOf(lineEnd + 1, document.textLength))
            }
        }
    }
}

/**
 * Removes the `=` of a block header that the engine ignores, e.g. `ThreatBreakdown = Tag`.
 */
class SageEngineIniRemoveEqualsQuickFix : LocalQuickFix {

    override fun getFamilyName(): String = "Remove '='"

    override fun applyFix(project: Project, descriptor: ProblemDescriptor) {
        val equals = descriptor.psiElement ?: return
        val end = (equals.nextSibling as? PsiWhiteSpace)?.textRange?.endOffset ?: equals.textRange.endOffset
        equals.editDocument(project) { it.deleteString(equals.textRange.startOffset, end) }
    }
}

private fun PsiElement.editDocument(project: Project, edit: (Document) -> Unit) {
    val documentManager = PsiDocumentManager.getInstance(project)
    val document = documentManager.getDocument(containingFile) ?: return
    edit(document)
    documentManager.commitDocument(document)
}
