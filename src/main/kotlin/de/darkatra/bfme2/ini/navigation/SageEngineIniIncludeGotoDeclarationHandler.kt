package de.darkatra.bfme2.ini.navigation

import com.intellij.codeInsight.navigation.actions.GotoDeclarationHandler
import com.intellij.openapi.editor.Editor
import com.intellij.psi.PsiElement
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

class SageEngineIniIncludeGotoDeclarationHandler : GotoDeclarationHandler {

    override fun getGotoDeclarationTargets(sourceElement: PsiElement?, offset: Int, editor: Editor): Array<PsiElement>? {

        if (sourceElement?.node?.elementType != SageEngineIniTokenTypes.STRING || !sourceElement.isPartOfIncludeMacro()) {
            return null
        }

        val target = sourceElement.resolveIncludeFile()
            ?: return null

        return arrayOf(target)
    }
}
