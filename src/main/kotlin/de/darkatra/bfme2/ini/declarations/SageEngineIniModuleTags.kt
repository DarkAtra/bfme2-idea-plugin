package de.darkatra.bfme2.ini.declarations

import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.tree.TokenSet
import com.intellij.psi.util.CachedValueProvider
import com.intellij.psi.util.CachedValuesManager
import com.intellij.psi.util.PsiModificationTracker
import com.intellij.psi.util.elementType
import de.darkatra.bfme2.ini.navigation.includePath
import de.darkatra.bfme2.ini.navigation.resolveIncludeFile
import de.darkatra.bfme2.ini.psi.SageEngineIniBlock
import de.darkatra.bfme2.ini.psi.SageEngineIniMacroStatement
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

/**
 * The module tags of objects, e.g. `ModuleTag_Heal` in `Behavior = AutoHealBehavior ModuleTag_Heal`, including the modules of included
 * files and of the objects a `ChildObject` or `ObjectReskin` inherits from.
 */
object SageEngineIniModuleTags {

    /**
     * A module tag of an object. The [anchor] is the element of the object's own file that adds it: the tag itself or the `#include` the
     * module is part of.
     */
    data class Tag(val name: String, val anchor: PsiElement)

    /**
     * @param complete `false` if an included file can't be resolved, so that the object can have more tags
     */
    data class Tags(val tags: List<Tag>, val complete: Boolean)

    val objectKinds: Set<String> = setOf("Object", "ChildObject", "ObjectReskin")

    val inheritingKinds: Set<String> = setOf("ChildObject", "ObjectReskin")

    private val moduleKinds = setOf("Behavior", "Body", "ClientBehavior", "ClientUpdate", "Draw")

    // blocks that contain modules, the header of a `ReplaceModule` names the tag it replaces
    private val wrapperKinds = setOf("AddModule", "InheritableModule", "ReplaceModule")

    private val headerTokens = TokenSet.create(SageEngineIniTokenTypes.VALUE, SageEngineIniTokenTypes.NUMBER, SageEngineIniTokenTypes.STRING)

    /**
     * The tags of the modules that [objectBlock] declares itself, in the order the engine reads them.
     */
    fun ownTags(objectBlock: SageEngineIniBlock): Tags {
        return CachedValuesManager.getCachedValue(objectBlock) {
            val tags = mutableListOf<Tag>()
            val complete = collect(objectBlock, null, emptySet(), tags)
            CachedValueProvider.Result.create(Tags(tags, complete), PsiModificationTracker.MODIFICATION_COUNT)
        }
    }

    /**
     * The lowercased tags that a `ChildObject` or `ObjectReskin` inherits from its parent objects, `null` if they can't be determined
     * completely, e.g. because a parent object or an included file can't be resolved.
     */
    fun parentTags(objectBlock: SageEngineIniBlock): Set<String>? {
        return parentTags(objectBlock, mutableSetOf(objectBlock))
    }

    /**
     * The name of the object a `ChildObject` or `ObjectReskin` inherits from, e.g. `Bar` in `ChildObject Foo Bar`.
     */
    fun parentName(objectBlock: SageEngineIniBlock): String? {
        if (objectBlock.declarationKind !in inheritingKinds) {
            return null
        }
        return headerValues(objectBlock).getOrNull(1)?.text?.let(SageEngineIniBlock::declarationName)
    }

    /**
     * The tokens after the keyword and `=` of a block header, e.g. `AutoHealBehavior` and `ModuleTag_Heal`.
     */
    fun headerValues(block: SageEngineIniBlock): List<PsiElement> {
        return generateSequence(block.firstChild) { it.nextSibling }
            .takeWhile { !(it is PsiWhiteSpace && it.textContains('\n')) && it.firstChild == null }
            .filter { it.elementType in headerTokens }
            .toList()
    }

    private fun parentTags(objectBlock: SageEngineIniBlock, visited: MutableSet<SageEngineIniBlock>): Set<String>? {
        val parentName = parentName(objectBlock) ?: return null
        val parents = SageEngineIniDeclarationLookup.findDeclarations(objectBlock.project, parentName, objectKinds).filter { it.parent is PsiFile }
        if (parents.isEmpty()) {
            return null
        }
        val names = mutableSetOf<String>()
        parents.forEach { parent ->
            if (!visited.add(parent)) {
                return null
            }
            names += ownTags(parent).takeIf { it.complete }?.tags?.map { it.name.lowercase() } ?: return null
            if (parent.declarationKind in inheritingKinds) {
                names += parentTags(parent, visited) ?: return null
            }
        }
        return names
    }

    private fun collect(container: PsiElement, anchor: PsiElement?, includeStack: Set<PsiFile>, tags: MutableList<Tag>): Boolean {
        var complete = true
        generateSequence(container.firstChild) { it.nextSibling }.forEach { child ->
            when {
                child is SageEngineIniBlock && child.declarationKind in moduleKinds -> {
                    headerValues(child).getOrNull(1)?.let { tag -> tags += Tag(tag.text, anchor ?: tag) }
                }

                child is SageEngineIniBlock && child.declarationKind in wrapperKinds -> {
                    complete = collect(child, anchor, includeStack, tags) && complete
                }

                child is SageEngineIniMacroStatement -> {
                    val path = child.includePath() ?: return@forEach
                    val file = path.resolveIncludeFile()
                    complete = if (file == null || file in includeStack) {
                        false
                    } else {
                        collect(file, anchor ?: path, includeStack + file, tags) && complete
                    }
                }
            }
        }
        return complete
    }
}
