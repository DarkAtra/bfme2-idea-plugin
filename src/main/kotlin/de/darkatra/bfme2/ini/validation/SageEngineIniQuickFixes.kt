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
import de.darkatra.bfme2.ini.psi.SageEngineIniPropertyAssignment
import kotlin.math.abs

/**
 * Finds known names that are likely meant by a misspelled [name], closest first. The similarity ignores case, so a name that only differs in
 * casing is suggested first.
 */
fun similarNames(name: String, candidates: Iterable<String>, limit: Int = 3): List<String> {
    return candidates.asSequence()
        .distinct()
        .filterNot { it == name }
        .mapNotNull { candidate -> similarity(name, candidate)?.let { candidate to it } }
        .sortedByDescending { (_, similarity) -> similarity }
        .take(limit)
        .map { (candidate, _) -> candidate }
        .toList()
}

// high on purpose: a misleading suggestion is worse than none
private const val MIN_SIMILARITY = 0.8

// `null` if the names are less similar than MIN_SIMILARITY
private fun similarity(a: String, b: String): Double? {
    val length = maxOf(a.length, b.length)
    val distance = boundedDistance(a, b, ((1 - MIN_SIMILARITY) * length + 1e-9).toInt()) ?: return null
    return 1.0 - distance.toDouble() / length
}

/**
 * The edit distance of [a] and [b] ignoring case, counting swapped neighbours as one edit like [EditDistance.optimalAlignment], or `null` if
 * it exceeds [max]. Only a band of width [max] around the diagonal can stay within [max], so comparing a name with thousands of
 * candidates stays cheap.
 */
internal fun boundedDistance(a: String, b: String, max: Int): Int? {
    if (abs(a.length - b.length) > max) {
        return null
    }
    val outOfBounds = max + 1
    var previousPrevious = IntArray(b.length + 1) { outOfBounds }
    var previous = IntArray(b.length + 1) { if (it <= max) it else outOfBounds }
    var current = IntArray(b.length + 1)
    for (i in 1..a.length) {
        current.fill(outOfBounds)
        current[0] = if (i <= max) i else outOfBounds
        var rowMinimum = current[0]
        for (j in maxOf(1, i - max)..minOf(b.length, i + max)) {
            val cost = if (a[i - 1].equals(b[j - 1], ignoreCase = true)) 0 else 1
            var distance = minOf(previous[j] + 1, current[j - 1] + 1, previous[j - 1] + cost)
            if (i > 1 && j > 1 && a[i - 1].equals(b[j - 2], ignoreCase = true) && a[i - 2].equals(b[j - 1], ignoreCase = true)) {
                distance = minOf(distance, previousPrevious[j - 2] + 1)
            }
            current[j] = minOf(distance, outOfBounds)
            rowMinimum = minOf(rowMinimum, current[j])
        }
        if (rowMinimum > max) {
            return null
        }
        val recycled = previousPrevious
        previousPrevious = previous
        previous = current
        current = recycled
    }
    return previous[b.length].takeIf { it <= max }
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
 * Removes the line of a property assignment, e.g. one that is overridden by a later assignment of the same property, or of the statement a
 * problem element is part of, e.g. an `#include`.
 */
class SageEngineIniRemoveAssignmentQuickFix(
    private val familyName: String = "Remove overridden assignment"
) : LocalQuickFix {

    override fun getFamilyName(): String = familyName

    override fun applyFix(project: Project, descriptor: ProblemDescriptor) {
        val problemElement = descriptor.psiElement ?: return
        val assignment = problemElement as? SageEngineIniPropertyAssignment ?: problemElement.parent ?: return
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
 * Removes an `=` that doesn't belong there, e.g. in the block header `ThreatBreakdown = Tag` or in `RemoveModule = ModuleTag_Death`.
 */
class SageEngineIniRemoveEqualsQuickFix : LocalQuickFix {

    override fun getFamilyName(): String = "Remove '='"

    override fun applyFix(project: Project, descriptor: ProblemDescriptor) {
        val equals = descriptor.psiElement ?: return
        val end = (equals.nextSibling as? PsiWhiteSpace)?.textRange?.endOffset ?: equals.textRange.endOffset
        equals.editDocument(project) { it.deleteString(equals.textRange.startOffset, end) }
    }
}

/**
 * Inserts the `=` after a property name, e.g. for `CommandSet Foo` inside an `Object`.
 */
class SageEngineIniInsertEqualsQuickFix : LocalQuickFix {

    override fun getFamilyName(): String = "Insert '='"

    override fun applyFix(project: Project, descriptor: ProblemDescriptor) {
        val propertyName = descriptor.psiElement ?: return
        propertyName.editDocument(project) { it.insertString(propertyName.textRange.endOffset, " =") }
    }
}

private fun PsiElement.editDocument(project: Project, edit: (Document) -> Unit) {
    val documentManager = PsiDocumentManager.getInstance(project)
    val document = documentManager.getDocument(containingFile) ?: return
    edit(document)
    documentManager.commitDocument(document)
}
