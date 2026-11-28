package de.darkatra.bfme2.ini.declarations

import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.util.CachedValueProvider
import com.intellij.psi.util.CachedValuesManager
import com.intellij.psi.util.PsiModificationTracker
import com.intellij.psi.util.PsiTreeUtil
import de.darkatra.bfme2.ini.model.SageIniModel
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniProperty
import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.elementType
import de.darkatra.bfme2.ini.psi.SageEngineIniBlock
import de.darkatra.bfme2.ini.psi.SageEngineIniPropertyAssignment
import de.darkatra.bfme2.ini.validation.SageEngineIniValueWord
import de.darkatra.bfme2.ini.validation.valueWords

/**
 * A value token that references a declaration of one of the [kinds], or a faction side if [factionSides] is `true`. The name is the [range] of
 * the token, e.g. without the `RiderOCL:` of `RiderOCL:OCL_RohirrimSpawnDeadRider`.
 */
data class SageEngineIniValueReference(val kinds: Set<String>, val range: TextRange, val factionSides: Boolean = false) {

    fun name(value: PsiElement): String = range.substring(value.text)
}

/**
 * Maps PSI blocks and properties to the descriptors of the [SageIniModel].
 */
object SageEngineIniModelResolver {

    fun descriptor(block: SageEngineIniBlock): SageIniBlockDescriptor<*>? {
        return CachedValuesManager.getCachedValue(block) {
            CachedValueProvider.Result.create(resolveDescriptor(block), PsiModificationTracker.MODIFICATION_COUNT)
        }
    }

    private fun resolveDescriptor(block: SageEngineIniBlock): SageIniBlockDescriptor<*>? {

        val kind = block.declarationKind ?: return null
        val parentBlock = block.parent as? SageEngineIniBlock
            ?: return topLevelDescriptor(block, kind)

        val parentDescriptor = descriptor(parentBlock) ?: return null
        val candidates = childBlockCandidates(parentDescriptor, kind)

        // module slots are typed by the first token after the `=`, e.g. `Behavior = AutoHealBehavior ModuleTag_Heal`
        val typeToken = block.name
        return candidates.firstOrNull { typeToken != null && it.name == typeToken }
            ?: candidates.firstOrNull { it.name == kind }
            ?: candidates.singleOrNull()
    }

    // `.inc` files are included into other blocks, so their top level blocks can be modules of an `Object`, e.g. `Body = RespawnBody ...`
    private fun topLevelDescriptor(block: SageEngineIniBlock, kind: String): SageIniBlockDescriptor<*>? {
        if (block.containingFile.name.endsWith(".inc", ignoreCase = true)) {
            val modules = SageIniModel.block("Object")?.let { childBlockCandidates(it, kind) }.orEmpty()
            modules.firstOrNull { it.name == block.name }?.let { return it }
        }
        return SageIniModel.block(kind)
    }

    fun property(assignment: SageEngineIniPropertyAssignment): SageIniProperty<*, *>? {
        val propertyName = assignment.propertyName ?: return null
        return enclosingDescriptor(assignment)?.property(propertyName)
    }

    /**
     * The descriptor of the block the [assignment] is part of, or of the file if it consists of properties only, e.g. `Options.ini`.
     */
    fun enclosingDescriptor(assignment: SageEngineIniPropertyAssignment): SageIniBlockDescriptor<*>? {
        return when (val parent = assignment.parent) {
            is SageEngineIniBlock -> descriptor(parent)
            is PsiFile -> SageIniModel.fileDescriptor(parent.name)
            else -> null
        }
    }

    /**
     * The length of the prefix and the declaration kinds the rest of a prefixed property name references, e.g. `WildAzog` in
     * `VoiceAttackUnitWildAzog` inside `UnitSpecificSounds`.
     */
    fun prefixedNameReference(propertyName: PsiElement): Pair<Int, Set<String>>? {
        val assignment = propertyName.parent as? SageEngineIniPropertyAssignment ?: return null
        if (assignment.firstChild != propertyName) {
            return null
        }
        val block = assignment.parent as? SageEngineIniBlock ?: return null
        val prefixed = descriptor(block)?.prefixedProperty(propertyName.text) ?: return null
        return prefixed.prefix.length to SageEngineIniDeclarationSchema.referencedKinds(prefixed.suffix)
    }

    /**
     * The declaration kinds the [value] token of a property can reference.
     */
    fun expectedDeclarationKinds(value: PsiElement): Set<String> {
        return valueReference(value)?.kinds.orEmpty()
    }

    /**
     * The declaration the [value] token of a property references, if any. Falls back to the properties with the same name in any block if
     * the property isn't part of the model.
     */
    fun valueReference(value: PsiElement): SageEngineIniValueReference? {
        val assignment = PsiTreeUtil.getParentOfType(value, SageEngineIniPropertyAssignment::class.java) ?: return null
        val tokenRange = value.textRange.shiftLeft(assignment.textRange.startOffset)
        val (words, references) = wordReferences(assignment)
        val wordIndex = words.indexOfFirst { it.range.contains(tokenRange) }
        val reference = references.getOrNull(wordIndex) ?: return null

        val nameStart = words[wordIndex].range.startOffset + reference.nameOffset - tokenRange.startOffset
        if (nameStart !in 0 until value.textLength) {
            return null
        }
        return SageEngineIniValueReference(reference.kinds, TextRange(nameStart, value.textLength), reference.factionSides)
    }

    private fun wordReferences(
        assignment: SageEngineIniPropertyAssignment
    ): Pair<List<SageEngineIniValueWord>, List<SageEngineIniDeclarationSchema.WordReference?>> {
        return CachedValuesManager.getCachedValue(assignment) {
            val words = assignment.valueWords()
            val property = property(assignment)
            val references = if (property != null) {
                SageEngineIniDeclarationSchema.wordReferences(property.type, words.map { it.text })
            } else {
                words.map { word ->
                    SageEngineIniDeclarationSchema.expectedKindsForPropertyValue(assignment.propertyName, word.text)
                        .takeIf { it.isNotEmpty() }
                        ?.let { SageEngineIniDeclarationSchema.WordReference(it) }
                }
            }
            CachedValueProvider.Result.create(words to references, PsiModificationTracker.MODIFICATION_COUNT)
        }
    }

    /**
     * The blocks that a line starting with [name] can open inside a block described by [parent]. Module slots like `Behavior` have
     * several candidates that are distinguished by the first token after the `=`.
     */
    fun childBlockCandidates(parent: SageIniBlockDescriptor<*>, name: String): List<SageIniBlockDescriptor<*>> {

        val slot = parent.property(name)?.type?.elementType() as? SageIniValueType.BlockValue<*>
        if (slot != null) {
            return slot.candidates
        }

        // groups such as the `Nuggets` of a `Weapon` contain blocks named after their type
        val groupMembers = parent.properties.asSequence()
            .mapNotNull { it.type.elementType() as? SageIniValueType.BlockValue<*> }
            .filter { it.group }
            .flatMap { it.candidates }
            .filter { it.name == name }
            .distinct()
            .toList()
        if (groupMembers.isNotEmpty()) {
            return groupMembers
        }

        // blocks keyed by their label are typed by their own name, e.g. `AddEmotion = OVERRIDE Taunt_Base` inside an `EmotionTrackerUpdate`
        return listOfNotNull(SageIniModel.block(name)?.takeIf { it.keyedByLabel })
    }
}
