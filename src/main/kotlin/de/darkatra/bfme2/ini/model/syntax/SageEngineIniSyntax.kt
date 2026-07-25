package de.darkatra.bfme2.ini.model.syntax

object SageEngineIniSyntax {
    val unconditionalBlockOpeners: Set<String> = setOf(
        "Animation",
        "AnimationState",
        "AudioLOD",
        "Behavior",
        "Body",
        "ClientBehavior",
        "ClientUpdate",
        "ConditionState",
        "Draw",
        "DynamicGameLOD",
        "LodOptions",
        "MeleeBehavior",
        "ModelConditionState",
        "RadiusCursorTemplate",
        "SoundState",
        "SoundUpgrade",
        "SpawnArmies",
        "StaticGameLOD",
        "ThreatBreakdown",
        "TransitionState",
    )
    val contextualBlockOpeners: Map<String, Set<String>> = mapOf(
        "FXParticleSystem" to setOf("Alpha", "Color", "Emitter", "EmissionVelocity", "EmissionVolume", "Event", "Physics", "Update", "Wind"),
        "Window" to setOf("Transition"),
    )
    val openerValueTokens: Set<String> = setOf("FCurve")
    val conditionalValueOpeners: Map<String, String> = mapOf("AddEmotion" to "OVERRIDE")
    val bareValueKeys: Set<String> = setOf(
        "AnimationSpeedFactorRange",
        "AttributeModifier",
        "Blank",
        "BoneSpecificConditionState",
        "BuildUpClockColor",
        "ButtonBorderActionColor",
        "ButtonBorderAlteredColor",
        "ButtonBorderBuildColor",
        "ButtonBorderSystemColor",
        "ButtonBorderUpgradeColor",
        "ClearNuggets",
        "CommandBarBorderColor",
        "ConflictsWith",
        "CrewPrepareInterval",
        "DamagedHideSubObject",
        "DamagedShowSubObject",
        "Delay",
        "EvaEventForwardReference",
        "Geometry",
        "GeometryContactPoint",
        "GeometryName",
        "ImageName",
        "Intensity",
        "Layer",
        "ParticleSysBone",
        "Position",
        "PristineHideSubObject",
        "PristineShowSubObject",
        "ReallyDamagedHideSubObject",
        "ReallyDamagedShowSubObject",
        "RemoveModule",
        "RubbleNeighbor",
        "Scale",
        "ScreenCreationRes",
        "ShadowColor",
        "Side",
        "Size",
        "StateName",
        "Time",
        "WeaponFireFXBone",
        "WeatherTexture",
    )
    val contextualBareValueKeys: Map<String, Set<String>> = mapOf("Object" to setOf("CommandSet"))

    // `ChildObject` and `ObjectReskin` share the body of an `Object`, so they also share its contextual rules
    private val parentAliases: Map<String, String> = caseInsensitiveMapOf(
        listOf(
            "ChildObject" to "Object",
            "ObjectReskin" to "Object",
        )
    )

    private val unconditionalBlockOpenerLookup = caseInsensitiveSetOf(unconditionalBlockOpeners)
    private val openerValueTokenLookup = caseInsensitiveSetOf(openerValueTokens)
    private val conditionalValueOpenerLookup = caseInsensitiveMapOf(conditionalValueOpeners.toList())
    private val bareValueKeyLookup = caseInsensitiveSetOf(bareValueKeys)
    private val contextualBlockOpenerLookup = caseInsensitiveMapOf(contextualBlockOpeners.mapValues { caseInsensitiveSetOf(it.value) }.toList())
    private val contextualBareValueKeyLookup = caseInsensitiveMapOf(contextualBareValueKeys.mapValues { caseInsensitiveSetOf(it.value) }.toList())

    /**
     * Whether a line starting with [key] opens a block regardless of its parent. [valueHead] is the first token after the key with `=` ignored.
     */
    fun isBlockOpener(key: String, valueHead: String?): Boolean {
        return key in unconditionalBlockOpenerLookup ||
            (valueHead != null && valueHead in openerValueTokenLookup) ||
            (valueHead != null && conditionalValueOpenerLookup[key].equals(valueHead, ignoreCase = true))
    }

    /**
     * Whether a line starting with [key] and no `=` is a value line instead of a block header.
     */
    fun isBareValueKey(key: String): Boolean {
        return key in bareValueKeyLookup
    }

    fun isContextualBlockOpener(parent: String?, key: String): Boolean {
        return parent != null && contextualBlockOpenerLookup[resolveParent(parent)]?.contains(key) == true
    }

    fun isContextualBareValueKey(parent: String?, key: String): Boolean {
        return parent != null && contextualBareValueKeyLookup[resolveParent(parent)]?.contains(key) == true
    }

    private fun resolveParent(parent: String): String {
        return parentAliases[parent] ?: parent
    }

    private fun caseInsensitiveSetOf(values: Collection<String>): Set<String> {
        return sortedSetOf(String.CASE_INSENSITIVE_ORDER).apply { addAll(values) }
    }

    private fun <V> caseInsensitiveMapOf(entries: List<Pair<String, V>>): Map<String, V> {
        return sortedMapOf<String, V>(String.CASE_INSENSITIVE_ORDER).apply { putAll(entries) }
    }
}
