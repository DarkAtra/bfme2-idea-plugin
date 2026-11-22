package de.darkatra.bfme2.ini.injection

import com.intellij.lang.Language
import com.intellij.lang.injection.MultiHostInjector
import com.intellij.lang.injection.MultiHostRegistrar
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import de.darkatra.bfme2.ini.psi.SageEngineIniScriptContent

// the language comes from whichever Lua plugin is installed, without one script blocks stay plain text
class SageEngineIniScriptLanguageInjector internal constructor(
    private val findScriptLanguage: () -> Language?,
) : MultiHostInjector, DumbAware {

    constructor() : this({ Language.getRegisteredLanguages().firstOrNull { it.id.equals(LUA_LANGUAGE_ID, ignoreCase = true) } })

    override fun getLanguagesToInject(registrar: MultiHostRegistrar, context: PsiElement) {
        if (context !is SageEngineIniScriptContent || !context.isValidHost) {
            return
        }
        val language = findScriptLanguage() ?: return
        registrar.startInjecting(language)
            .addPlace(null, null, context, TextRange(0, context.textLength))
            .doneInjecting()
    }

    override fun elementsToInjectIn(): List<Class<out PsiElement>> {
        return listOf(SageEngineIniScriptContent::class.java)
    }

    private companion object {

        const val LUA_LANGUAGE_ID = "Lua"
    }
}
