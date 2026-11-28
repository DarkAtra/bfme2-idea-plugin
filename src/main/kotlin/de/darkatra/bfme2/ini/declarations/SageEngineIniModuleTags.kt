package de.darkatra.bfme2.ini.declarations

import com.intellij.openapi.util.TextRange
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
import de.darkatra.bfme2.ini.psi.SageEngineIniPropertyAssignment
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes
import de.darkatra.bfme2.ini.validation.valueWords

/**
 * The module tags of objects, e.g. `ModuleTag_Heal` in `Behavior = AutoHealBehavior ModuleTag_Heal`, including the modules of included
 * files and of the objects a `ChildObject` or `ObjectReskin` inherits from.
 */
object SageEngineIniModuleTags {

    /**
     * A change of the module tags of an object: a module that adds a tag, or a `RemoveModule` or `ReplaceModule` that removes one.
     */
    sealed interface TagChange {
        val name: String
        val offset: Int
    }

    /**
     * A module tag of an object. The [anchor] is the element of the object's own file that adds it: the tag itself or the `#include` the
     * module is part of.
     */
    data class Tag(override val name: String, val type: String?, val anchor: PsiElement) : TagChange {
        override val offset: Int get() = anchor.textRange.startOffset
    }

    /**
     * A module tag that a `RemoveModule` or the header of a [replaceModule] removes, the [range] of the [element].
     */
    data class TagRemoval(
        override val name: String,
        val element: PsiElement,
        val range: TextRange,
        val replaceModule: SageEngineIniBlock? = null,
    ) : TagChange {
        override val offset: Int get() = element.textRange.startOffset + range.startOffset
    }

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
     * The tags that [objectBlock] adds and removes itself, in the order the engine reads them, `null` if an included file can't be resolved.
     */
    fun ownTagChanges(objectBlock: SageEngineIniBlock): List<TagChange>? {
        val ownTags = ownTags(objectBlock).takeIf { it.complete } ?: return null
        return (ownTags.tags + tagRemovals(objectBlock)).sortedBy { it.offset }
    }

    /**
     * The tags that a `ChildObject` or `ObjectReskin` inherits from its parent objects with the types of their modules, i.e. those the
     * parents have after their own modules and removals, `null` if they can't be determined completely, e.g. because a parent object or an
     * included file can't be resolved.
     */
    fun parentTags(objectBlock: SageEngineIniBlock): Map<String, String?>? {
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
     * The modules directly inside [container], e.g. the module of a `ReplaceModule`.
     */
    fun modules(container: SageEngineIniBlock): List<SageEngineIniBlock> {
        return generateSequence(container.firstChild) { it.nextSibling }
            .filterIsInstance<SageEngineIniBlock>()
            .filter { it.declarationKind in moduleKinds }
            .toList()
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

    private fun parentTags(objectBlock: SageEngineIniBlock, visited: MutableSet<SageEngineIniBlock>): Map<String, String?>? {
        val parentName = parentName(objectBlock) ?: return null
        val parents = SageEngineIniDeclarationLookup.findDeclarations(objectBlock.project, parentName, objectKinds).filter { it.parent is PsiFile }
        if (parents.isEmpty()) {
            return null
        }
        val names = mutableMapOf<String, String?>()
        parents.forEach { parent ->
            if (!visited.add(parent)) {
                return null
            }
            val inherited = if (parent.declarationKind in inheritingKinds) parentTags(parent, visited) ?: return null else emptyMap()
            val changes = ownTagChanges(parent) ?: return null
            names += changes.fold(inherited) { tags, change ->
                when (change) {
                    is Tag -> tags + (change.name to change.type)
                    is TagRemoval -> tags - change.name
                }
            }
        }
        return names
    }

    // e.g. `RemoveModule ModuleTag_Death` and `ReplaceModule ModuleTag_Draw`
    private fun tagRemovals(objectBlock: SageEngineIniBlock): List<TagRemoval> {
        return generateSequence(objectBlock.firstChild) { it.nextSibling }.flatMap { child ->
            when {
                child is SageEngineIniPropertyAssignment && child.propertyName == "RemoveModule" -> {
                    child.valueWords().map { TagRemoval(it.text, child, it.range) }
                }

                child is SageEngineIniBlock && child.declarationKind == "ReplaceModule" -> {
                    headerValues(child).take(1).map { TagRemoval(it.text, it, TextRange(0, it.textLength), child) }
                }

                else -> emptyList()
            }
        }.toList()
    }

    private fun collect(container: PsiElement, anchor: PsiElement?, includeStack: Set<PsiFile>, tags: MutableList<Tag>): Boolean {
        var complete = true
        generateSequence(container.firstChild) { it.nextSibling }.forEach { child ->
            when {
                child is SageEngineIniBlock && child.declarationKind in moduleKinds -> {
                    val header = headerValues(child)
                    header.getOrNull(1)?.let { tag -> tags += Tag(tag.text, header.first().text, anchor ?: tag) }
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
