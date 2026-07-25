package de.darkatra.bfme2.ini.navigation

import com.intellij.codeInsight.navigation.actions.GotoDeclarationHandler
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import de.darkatra.bfme2.ini.declarations.SageEngineIniMacros
import de.darkatra.bfme2.ini.psi.SageEngineIniMacroStatement
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

/**
 * Navigates from macro usages such as `BuildCost = MALLORN_COST` or `#MULTIPLY( MALLORN_COST 2 )` to their `#define`.
 */
class SageEngineIniMacroGotoDeclarationHandler : GotoDeclarationHandler {

    override fun getGotoDeclarationTargets(sourceElement: PsiElement?, offset: Int, editor: Editor): Array<PsiElement>? {
        if (sourceElement?.elementType != SageEngineIniTokenTypes.VALUE) {
            return null
        }

        val statement = sourceElement.parent as? SageEngineIniMacroStatement
        if (statement != null && SageEngineIniMacros.definedName(statement) == sourceElement) {
            return null
        }

        return SageEngineIniMacros.findDefinitions(sourceElement.project, sourceElement.text)
            .takeIf { it.isNotEmpty() }
            ?.toTypedArray()
    }
}
