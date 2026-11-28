package de.darkatra.bfme2.ini.declarations

import com.intellij.openapi.project.Project
import com.intellij.psi.util.CachedValueProvider
import com.intellij.psi.util.CachedValuesManager
import com.intellij.psi.util.PsiModificationTracker
import de.darkatra.bfme2.ini.psi.SageEngineIniPropertyAssignment
import de.darkatra.bfme2.ini.validation.valueWords

/**
 * The faction sides, i.e. the `Side` values of all `PlayerTemplate` declarations such as `Men` or `Mordor`. Mods can add their own.
 */
object SageEngineIniFactionSides {

    fun isDefined(project: Project, name: String): Boolean {
        return names(project).any { it.equals(name, ignoreCase = true) }
    }

    private fun names(project: Project): Set<String> {
        return CachedValuesManager.getManager(project).getCachedValue(project) {
            val names = SageEngineIniDeclarationLookup.allDeclarationNames(project, setOf(PLAYER_TEMPLATE))
                .flatMap { SageEngineIniDeclarationLookup.findDeclarations(project, it, setOf(PLAYER_TEMPLATE)) }
                .flatMap { playerTemplate -> playerTemplate.children.filterIsInstance<SageEngineIniPropertyAssignment>() }
                .filter { it.propertyName == "Side" }
                .mapNotNull { it.valueWords().firstOrNull()?.text }
                .toSet()
            CachedValueProvider.Result.create(names, PsiModificationTracker.MODIFICATION_COUNT)
        }
    }

    private const val PLAYER_TEMPLATE = "PlayerTemplate"
}
