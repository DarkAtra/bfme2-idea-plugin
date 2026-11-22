package de.darkatra.bfme2.ini.navigation

import com.intellij.codeInsight.navigation.actions.GotoDeclarationHandler
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import de.darkatra.bfme2.ini.declarations.SageEngineIniDeclarationLookup
import de.darkatra.bfme2.ini.declarations.SageEngineIniModelResolver
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

class SageEngineIniDeclarationGotoDeclarationHandler : GotoDeclarationHandler {

    override fun getGotoDeclarationTargets(sourceElement: PsiElement?, offset: Int, editor: Editor): Array<PsiElement>? {
        if (sourceElement?.elementType != SageEngineIniTokenTypes.VALUE) {
            return null
        }

        val reference = SageEngineIniModelResolver.valueReference(sourceElement) ?: return null

        return SageEngineIniDeclarationLookup.findDeclarations(sourceElement.project, reference.name(sourceElement), reference.kinds)
            .mapNotNull { it.nameIdentifier }
            .takeIf { it.isNotEmpty() }
            ?.toTypedArray()
    }
}