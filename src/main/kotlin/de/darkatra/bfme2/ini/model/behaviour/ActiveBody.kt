package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.ModifierList
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.DamageCreation
import de.darkatra.bfme2.ini.model.value.SageReference

open class ActiveBody(
    open val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("MaxHealth") open val maxHealth: Double = 0.0,
    @SageIniName("InitialHealth") open val initialHealth: Double = 0.0,
    @SageIniName("MaxHealthDamaged") open val maxHealthDamaged: Double = 0.0,
    @SageIniName("MaxHealthReallyDamaged") open val maxHealthReallyDamaged: Double = 0.0,
    @SageIniName("RecoveryTime") open val recoveryTime: Double = 0.0,
    @SageIniName("SubdualDamageCap") open val subdualDamageCap: Double = 0.0,
    @SageIniName("SubdualDamageHealRate") open val subdualDamageHealRate: Int = 0,
    @SageIniName("SubdualDamageHealAmount") open val subdualDamageHealAmount: Double = 0.0,
    @SageIniName("GrabObject") open val grabObject: SageReference<Object>? = null,
    @SageIniName("GrabOffset") open val grabOffset: Coords? = null,
    @SageIniName("DamageCreationList") open val damageCreationList: List<DamageCreation> = emptyList(),
    @SageIniName("GrabFX") open val grabFX: SageReference<FXList>? = null,
    @SageIniName("GrabDamage") open val grabDamage: Double = 0.0,
    @SageIniName("CheerRadius") open val cheerRadius: Double = 0.0,
    @SageIniName("DodgePercent") open val dodgePercent: Double = 0.0,
    @SageIniName("UseDefaultDamageSettings") open val useDefaultDamageSettings: Boolean = false,
    @SageIniName("EnteringDamagedTransitionTime") open val enteringDamagedTransitionTime: Int = 0,
    @SageIniName("HealingBuffFx") open val healingBuffFx: SageReference<FXList>? = null,
    @SageIniName("BurningDeathBehavior") open val burningDeathBehavior: Boolean = false,
    @SageIniName("BurningDeathFX") open val burningDeathFX: SageReference<FXList>? = null,
    @SageIniName("DamagedAttributeModifier") open val damagedAttributeModifier: SageReference<ModifierList>? = null,
    @SageIniName("ReallyDamagedAttributeModifier") open val reallyDamagedAttributeModifier: SageReference<ModifierList>? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<ActiveBody>(
        name = "ActiveBody",
        properties = {
            property("MaxHealth", FloatValue) { it.maxHealth }
            property("InitialHealth", FloatValue) { it.initialHealth }
            property("MaxHealthDamaged", FloatValue) { it.maxHealthDamaged }
            property("MaxHealthReallyDamaged", FloatValue) { it.maxHealthReallyDamaged }
            property("RecoveryTime", FloatValue) { it.recoveryTime }
            property("SubdualDamageCap", FloatValue) { it.subdualDamageCap }
            property("SubdualDamageHealRate", IntValue) { it.subdualDamageHealRate }
            property("SubdualDamageHealAmount", FloatValue) { it.subdualDamageHealAmount }
            property("GrabObject", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.grabObject }
            property("GrabOffset", Coords.type) { it.grabOffset }
            property("DamageCreationList", ListValue(DamageCreation.type)) { it.damageCreationList }
            property("GrabFX", ReferenceValue<FXList> { listOf(FXList) }) { it.grabFX }
            property("GrabDamage", FloatValue) { it.grabDamage }
            property("CheerRadius", FloatValue) { it.cheerRadius }
            property("DodgePercent", FloatValue) { it.dodgePercent }
            property("UseDefaultDamageSettings", BooleanValue) { it.useDefaultDamageSettings }
            property("EnteringDamagedTransitionTime", IntValue) { it.enteringDamagedTransitionTime }
            property("HealingBuffFx", ReferenceValue<FXList> { listOf(FXList) }) { it.healingBuffFx }
            property("BurningDeathBehavior", BooleanValue) { it.burningDeathBehavior }
            property("BurningDeathFX", ReferenceValue<FXList> { listOf(FXList) }) { it.burningDeathFX }
            property("DamagedAttributeModifier", ReferenceValue<ModifierList> { listOf(ModifierList) }) { it.damagedAttributeModifier }
            property("ReallyDamagedAttributeModifier", ReferenceValue<ModifierList> { listOf(ModifierList) }) { it.reallyDamagedAttributeModifier }
        },
    )
}
