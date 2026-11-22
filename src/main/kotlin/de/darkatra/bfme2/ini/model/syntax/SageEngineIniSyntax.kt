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

    // properties of these blocks are always written with `=`, bare lines of them are only parsed as properties to avoid opening a block
    val equalsRequiringBlocks: Set<String> = setOf("Object")
    val equalsForbiddenKeys: Map<String, Set<String>> = mapOf("Object" to setOf("RemoveModule"))

    // directives that are written as a bare key without any value
    val valuelessKeys: Map<String, Set<String>> = mapOf("Credits" to setOf("Blank"))

    // statements that the engine reads outside of any block
    val topLevelKeys: Set<String> = setOf("AudioLowMHz", "BenchProfile", "EvaEventForwardReference", "LODPreset", "ReallyLowMHz")

    // files that only consist of properties, even keys that open a block elsewhere, e.g. `StaticGameLOD = High` in `Options.ini`
    val blocklessFiles: Set<String> = setOf("options.ini")

    // `ChildObject` and `ObjectReskin` share the body of an `Object`, so they also share its contextual rules
    private val parentAliases: Map<String, String> = mapOf(
        "ChildObject" to "Object",
        "ObjectReskin" to "Object",
    )

    // keywords are case-sensitive, values such as `FCurve` aren't
    private val openerValueTokenLookup = sortedSetOf(String.CASE_INSENSITIVE_ORDER).apply { addAll(openerValueTokens) }

    /**
     * Whether a line starting with [key] opens a block regardless of its parent. [valueHead] is the first token after the key with `=` ignored.
     */
    fun isBlockOpener(key: String, valueHead: String?): Boolean {
        return key in unconditionalBlockOpeners ||
            (valueHead != null && valueHead in openerValueTokenLookup) ||
            (valueHead != null && conditionalValueOpeners[key].equals(valueHead, ignoreCase = true))
    }

    /**
     * Whether a line starting with [key] and no `=` is a value line instead of a block header.
     */
    fun isBareValueKey(key: String): Boolean {
        return key in bareValueKeys
    }

    fun isContextualBlockOpener(parent: String?, key: String): Boolean {
        return parent != null && contextualBlockOpeners[resolveParent(parent)]?.contains(key) == true
    }

    fun isContextualBareValueKey(parent: String?, key: String): Boolean {
        return parent != null && contextualBareValueKeys[resolveParent(parent)]?.contains(key) == true
    }

    fun isBareValueKeyInAnyBlock(key: String): Boolean {
        return key in bareValueKeys || contextualBareValueKeys.values.any { key in it }
    }

    fun requiresEquals(parent: String?, key: String): Boolean {
        return parent != null && resolveParent(parent) in equalsRequiringBlocks && !forbidsEquals(parent, key)
    }

    fun forbidsEquals(parent: String?, key: String): Boolean {
        return parent != null && equalsForbiddenKeys[resolveParent(parent)]?.contains(key) == true
    }

    fun isValuelessKey(parent: String?, key: String): Boolean {
        return parent != null && valuelessKeys[resolveParent(parent)]?.contains(key) == true
    }

    fun isTopLevelKey(key: String): Boolean {
        return key in topLevelKeys
    }

    fun isBlocklessFile(fileName: String?): Boolean {
        return fileName != null && fileName.lowercase() in blocklessFiles
    }

    private fun resolveParent(parent: String): String {
        return parentAliases[parent] ?: parent
    }
}
