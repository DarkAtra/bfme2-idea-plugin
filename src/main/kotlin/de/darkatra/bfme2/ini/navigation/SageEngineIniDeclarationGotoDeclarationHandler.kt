package de.darkatra.bfme2.ini.navigation

import com.intellij.codeInsight.navigation.actions.GotoDeclarationHandler
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import de.darkatra.bfme2.ini.declarations.SageEngineIniDeclarationLookup
import de.darkatra.bfme2.ini.declarations.SageEngineIniDeclarationSchema
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

class SageEngineIniDeclarationGotoDeclarationHandler : GotoDeclarationHandler {

    override fun getGotoDeclarationTargets(sourceElement: PsiElement?, offset: Int, editor: Editor): Array<PsiElement>? {
        if (sourceElement?.elementType != SageEngineIniTokenTypes.VALUE) {
            return null
        }

        val expectedKinds = SageEngineIniDeclarationSchema.expectedKindsForPropertyValue(
            sourceElement.propertyAssignmentName(),
            sourceElement.text
        )
        if (expectedKinds.isEmpty()) {
            return null
        }

        return SageEngineIniDeclarationLookup.findDeclarations(sourceElement.project, sourceElement.text, expectedKinds)
            .mapNotNull { it.nameIdentifier }
            .takeIf { it.isNotEmpty() }
            ?.toTypedArray()
    }
}