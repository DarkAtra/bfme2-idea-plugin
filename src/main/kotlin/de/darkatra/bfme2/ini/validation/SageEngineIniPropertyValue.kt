package de.darkatra.bfme2.ini.validation

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.util.elementType
import de.darkatra.bfme2.ini.psi.SageEngineIniMacroStatement
import de.darkatra.bfme2.ini.psi.SageEngineIniPropertyAssignment
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

/**
 * A whitespace separated word of a property value, e.g. `50%`, `+FORCE` or `X:1.5`. The lexer splits these into several tokens.
 *
 * @param range the range of the word relative to the property assignment
 */
data class SageEngineIniValueWord(val text: String, val range: TextRange)

/**
 * The words after the `=` (or after the property name of bare `Key Value` lines).
 */
fun SageEngineIniPropertyAssignment.valueWords(): List<SageEngineIniValueWord> {

    val leaves = generateSequence(firstChild) { it.nextSibling }.toList()
    val valueStart = leaves.indexOfFirst { it.elementType == SageEngineIniTokenTypes.EQUALS }
        .takeIf { it >= 0 }
        ?: leaves.indexOfFirst { it.elementType == SageEngineIniTokenTypes.PROPERTY }

    val words = mutableListOf<SageEngineIniValueWord>()
    var wordStart = -1
    var wordEnd = -1
    leaves.drop(valueStart + 1).forEach { leaf ->
        if (leaf is PsiWhiteSpace) {
            if (wordStart >= 0) {
                words += SageEngineIniValueWord(text.substring(wordStart, wordEnd), TextRange(wordStart, wordEnd))
                wordStart = -1
            }
        } else {
            if (wordStart < 0) {
                wordStart = leaf.startOffsetInParent
            }
            wordEnd = leaf.startOffsetInParent + leaf.textLength
        }
    }
    if (wordStart >= 0) {
        words += SageEngineIniValueWord(text.substring(wordStart, wordEnd), TextRange(wordStart, wordEnd))
    }
    return words
}

/**
 * Whether the value is an arithmetic expression such as `#MULTIPLY( HERO_DAMAGE 2 )`, which the parser represents as a macro statement
 * following the property assignment on the same line.
 */
fun SageEngineIniPropertyAssignment.hasExpressionValue(): Boolean {
    var sibling = nextSibling
    while (sibling is PsiWhiteSpace && !sibling.textContains('\n')) {
        sibling = sibling.nextSibling
    }
    return sibling is SageEngineIniMacroStatement
}
