package de.darkatra.bfme2.ini.validation

import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiTreeUtil
import de.darkatra.bfme2.ini.declarations.SageEngineIniModelResolver
import de.darkatra.bfme2.ini.psi.SageEngineIniPropertyAssignment

/**
 * Whether the [value] token belongs to a property of the model. References of other properties are only guessed from properties with the
 * same name in other blocks, which is good enough for navigation, but not to report them.
 */
fun isModelProperty(value: PsiElement): Boolean {
    val assignment = PsiTreeUtil.getParentOfType(value, SageEngineIniPropertyAssignment::class.java) ?: return false
    return SageEngineIniModelResolver.property(assignment) != null
}
