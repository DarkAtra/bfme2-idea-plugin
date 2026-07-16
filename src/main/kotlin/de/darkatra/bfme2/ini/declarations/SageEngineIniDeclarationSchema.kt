package de.darkatra.bfme2.ini.declarations

object SageEngineIniDeclarationSchema {

    private val weaponSlotValues = setOf("PRIMARY", "SECONDARY", "TERTIARY")

    private val declarationProperties = mapOf(
        "Armor" to setOf("Armor"),
        "AudioEvent" to emptySet(),
        "CommandButton" to setOf("CommandButton"),
        "CommandSet" to setOf("CommandSet"),
        "ExperienceLevel" to emptySet(),
        "FXList" to setOf("BurningDeathFX", "EnteringStateFX", "FireFX", "FX", "InitialSpawnFX", "TriggerFX"),
        "FXParticleSystem" to setOf("ParticleSysBone"),
        "Locomotor" to setOf("Locomotor"),
        "ModifierList" to setOf("AttributeModifiers", "AttributeModifier", "BonusName", "ModifierList"),
        "NewEvaEvent" to setOf("EvaEventOwner", "EvaEventDieOwner"),
        "Object" to setOf("Object", "ObjectNames", "TargetNames"),
        "ObjectCreationList" to setOf("LevelUpOCL", "OCL"),
        "RadiusCursorTemplate" to setOf("RadiusCursorType"),
        "Science" to setOf("RequiredScience", "Science", "TriggeredBy"),
        "SpecialPower" to setOf("SpecialAbility", "SpecialPower", "SpecialPowerTemplate"),
        "Upgrade" to setOf(
            "ConflictsWith",
            "ForbiddenUpgradeNames",
            "RequiredUpgradeNames",
            "TriggeredBy",
            "Upgrade",
        ),
        "Weapon" to setOf("Weapon"),
    )

    val declarationKinds = declarationProperties.keys

    private val propertyReferenceRules = buildMap<String, Set<String>> {
        declarationProperties.forEach { (declarationKind, properties) ->
            properties.forEach { property ->
                put(property, get(property).orEmpty() + declarationKind)
            }
        }
    }

    fun isDeclarationKind(kind: String?): Boolean {
        return kind in declarationKinds
    }

    fun expectedKindsForProperty(propertyName: String?): Set<String> {
        return propertyReferenceRules[propertyName].orEmpty()
    }

    fun expectedKindsForPropertyValue(propertyName: String?, propertyValue: String?): Set<String> {
        if (propertyName == "Weapon" && weaponSlotValues.any { it.equals(propertyValue, ignoreCase = true) }) {
            return emptySet()
        }

        return expectedKindsForProperty(propertyName)
    }
}
