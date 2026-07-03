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
        "NewEvaEvent",
        "Object",
        "ObjectCreationList",
        "RadiusCursorTemplate",
        "Science",
        "SpecialPower",
        "Upgrade",
        "Weapon",
    )

    private val propertyReferenceRules = mapOf(
        "Armor" to setOf("Armor"),
        "AttributeModifiers" to setOf("ModifierList"),
        "AttributeModifier" to setOf("ModifierList"),
        "BonusName" to setOf("ModifierList"),
        "CommandButton" to setOf("CommandButton"),
        "CommandSet" to setOf("CommandSet"),
        "ConflictsWith" to setOf("Upgrade"),
        "EvaEventOwner" to setOf("NewEvaEvent"),
        "EvaEventDieOwner" to setOf("NewEvaEvent"),
        "FireFX" to setOf("FXList"),
        "ForbiddenUpgradeNames" to setOf("Upgrade"),
        "FX" to setOf("FXList"),
        "InitialSpawnFX" to setOf("FXList"),
        "LevelUpOCL" to setOf("ObjectCreationList"),
        "Locomotor" to setOf("Locomotor"),
        "ModifierList" to setOf("ModifierList"),
        "Object" to setOf("Object"),
        "ObjectNames" to setOf("Object"),
        "OCL" to setOf("ObjectCreationList"),
        "ParticleSysBone" to setOf("FXParticleSystem"),
        "RequiredScience" to setOf("Science"),
        "RequiredUpgradeNames" to setOf("Upgrade"),
        "RadiusCursorType" to setOf("RadiusCursorTemplate"),
        "Science" to setOf("Science"),
        "SpecialAbility" to setOf("SpecialPower"),
        "SpecialPower" to setOf("SpecialPower"),
        "SpecialPowerTemplate" to setOf("SpecialPower"),
        "TargetNames" to setOf("Object"),
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
