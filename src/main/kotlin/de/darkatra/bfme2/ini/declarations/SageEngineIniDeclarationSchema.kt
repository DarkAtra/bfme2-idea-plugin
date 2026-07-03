package de.darkatra.bfme2.ini.declarations

object SageEngineIniDeclarationSchema {

    val declarationKinds = setOf(
        "Armor",
        "AudioEvent",
        "CommandButton",
        "CommandSet",
        "ExperienceLevel",
        "FXList",
        "FXParticleSystem",
        "Locomotor",
        "ModifierList",
        "Object",
        "ObjectCreationList",
        "Science",
        "SpecialPower",
        "Upgrade",
        "Weapon",
    )

    private val propertyReferenceRules = mapOf(
        "Armor" to setOf("Armor"),
        "CommandButton" to setOf("CommandButton"),
        "CommandSet" to setOf("CommandSet"),
        "FireFX" to setOf("FXList"),
        "FX" to setOf("FXList"),
        "Locomotor" to setOf("Locomotor"),
        "ModifierList" to setOf("ModifierList"),
        "Object" to setOf("Object"),
        "ObjectCreationList" to setOf("ObjectCreationList"),
        "RequiredScience" to setOf("Science"),
        "Science" to setOf("Science"),
        "SpecialAbility" to setOf("SpecialPower"),
        "SpecialPower" to setOf("SpecialPower"),
        "SpecialPowerTemplate" to setOf("SpecialPower"),
        "TriggeredBy" to setOf("Upgrade", "Science"),
        "Upgrade" to setOf("Upgrade"),
        "Weapon" to setOf("Weapon"),
    )

    fun isDeclarationKind(kind: String?): Boolean {
        return kind in declarationKinds
    }

    fun expectedKindsForProperty(propertyName: String?): Set<String> {
        return propertyReferenceRules[propertyName].orEmpty()
    }
}
