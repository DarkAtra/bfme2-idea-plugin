package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.MapValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.ModifierList
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.DamageCreation
import de.darkatra.bfme2.ini.model.value.SageReference

data class FreeLifeBody(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("MaxHealth") override val maxHealth: Double = 0.0,
    @SageIniName("InitialHealth") override val initialHealth: Double = 0.0,
    @SageIniName("MaxHealthDamaged") override val maxHealthDamaged: Double = 0.0,
    @SageIniName("MaxHealthReallyDamaged") override val maxHealthReallyDamaged: Double = 0.0,
    @SageIniName("RecoveryTime") override val recoveryTime: Double = 0.0,
    @SageIniName("SubdualDamageCap") override val subdualDamageCap: Double = 0.0,
    @SageIniName("SubdualDamageHealRate") override val subdualDamageHealRate: Int = 0,
    @SageIniName("SubdualDamageHealAmount") override val subdualDamageHealAmount: Double = 0.0,
    @SageIniName("GrabObject") override val grabObject: SageReference<Object>? = null,
    @SageIniName("GrabOffset") override val grabOffset: Coords? = null,
    @SageIniName("DamageCreationList") override val damageCreationList: List<DamageCreation> = emptyList(),
    @SageIniName("GrabFX") override val grabFX: SageReference<FXList>? = null,
    @SageIniName("GrabDamage") override val grabDamage: Double = 0.0,
    @SageIniName("CheerRadius") override val cheerRadius: Double = 0.0,
    @SageIniName("DodgePercent") override val dodgePercent: Double = 0.0,
    @SageIniName("UseDefaultDamageSettings") override val useDefaultDamageSettings: Boolean = false,
    @SageIniName("EnteringDamagedTransitionTime") override val enteringDamagedTransitionTime: Int = 0,
    @SageIniName("HealingBuffFx") override val healingBuffFx: SageReference<FXList>? = null,
    @SageIniName("BurningDeathBehavior") override val burningDeathBehavior: Boolean = false,
    @SageIniName("BurningDeathFX") override val burningDeathFX: SageReference<FXList>? = null,
    @SageIniName("DamagedAttributeModifier") override val damagedAttributeModifier: SageReference<ModifierList>? = null,
    @SageIniName("ReallyDamagedAttributeModifier") override val reallyDamagedAttributeModifier: SageReference<ModifierList>? = null,
    @SageIniName("FreeLifeHealthPercent") val freeLifeHealthPercent: Double = 0.0,
    @SageIniName("FreeLifeTime") val freeLifeTime: Int = 0,
    @SageIniName("FreeLifeInvincible") val freeLifeInvincible: Boolean = false,
    @SageIniName("FreeLifePrerequisiteUpgrade") val freeLifePrerequisiteUpgrade: SageReference<Upgrade>? = null,
    @SageIniName("FreeLifeAnimAndDuration") val freeLifeAnimAndDuration: Map<String, String> = emptyMap(),
) : ActiveBody() {

    companion object : SageIniBlockDescriptor<FreeLifeBody>(
        name = "FreeLifeBody",
        parent = ActiveBody,
        properties = {
            property("FreeLifeHealthPercent", FloatValue) { it.freeLifeHealthPercent }
            property("FreeLifeTime", IntValue) { it.freeLifeTime }
            property("FreeLifeInvincible", BooleanValue) { it.freeLifeInvincible }
            property("FreeLifePrerequisiteUpgrade", ReferenceValue<Upgrade> { listOf(Upgrade) }) { it.freeLifePrerequisiteUpgrade }
            property("FreeLifeAnimAndDuration", MapValue(StringValue, StringValue)) { it.freeLifeAnimAndDuration }
        },
    )
}
