package de.darkatra.bfme2.ini.declarations

object SageEngineIniDeclarationSchema {

    private val weaponSlotValues = setOf("PRIMARY", "SECONDARY", "TERTIARY")

    private val declarationProperties = mapOf(
        "Armor" to setOf("Armor"),
        "AudioEvent" to setOf("InitiateAtLocationSound"),
        "CommandButton" to setOf("CommandButton"),
        "CommandSet" to setOf("CommandSet", "WeaponToggleCommandSet"),
        "ExperienceLevel" to emptySet(),
        "FXList" to setOf(
            "AntiFX",
            "AttributeModifierFX",
            "BannerMorphFX",
            "BecomeStealthedFX",
            "BurningDeathFX",
            "CursedFX",
            "DeathFX",
            "DominatedFX",
            "EnteringStateFX",
            "ExitStealthFX",
            "FireFX",
            "FX",
            "GrabFX",
            "GroundBounceFX",
            "GroundHitFX",
            "HealFX",
            "InitialSpawnFX",
            "LargeFXList",
            "MediumFXList",
            "PreAttackFX",
            "RespawnFX",
            "SmallFXList",
            "TaintFX",
            "TriggerFX",
            "UnitHealPulseFX",
            "UnitSpawnFX",
            "UpgradeFX",
        ),
        "FXParticleSystem" to setOf("ParticleSysBone"),
        "Locomotor" to setOf("Locomotor"),
        "MappedImage" to setOf("ButtonImage"),
        "ModifierList" to setOf("AttributeModifiers", "AttributeModifier", "BonusName", "ModifierList", "TriggerAttributeModifier"),
        "NewEvaEvent" to setOf("EvaEventOwner", "EvaEventDieOwner"),
        "Object" to setOf("Object", "ObjectNames", "ProjectileTemplateName", "TargetNames"),
        "ObjectCreationList" to setOf("LevelUpOCL", "OCL"),
        "RadiusCursorTemplate" to setOf("RadiusCursorType"),
        "Science" to setOf("RequiredScience", "Science", "TriggeredBy"),
        "SpecialPower" to setOf("SpecialAbility", "SpecialPower", "SpecialPowerTemplate"),
        "Upgrade" to setOf(
            "ConflictsWith",
            "ExcludedUpgrades",
            "ForbiddenUpgradeNames",
            "GrantUpgrade",
            "RequiredUpgradeNames",
            "RequiredUpgrades",
            "TriggeredBy",
            "Upgrade",
            "Upgrades",
            "UpgradeToGrant",
            "UseObjectTemplateForCostDiscount",
            "WorldMapArmoryUpgradesAllowed",
        ),
        "Weapon" to setOf("DeathWeapon", "WarheadTemplateName", "Weapon"),
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
