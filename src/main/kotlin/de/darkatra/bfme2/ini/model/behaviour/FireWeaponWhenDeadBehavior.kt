package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.MapValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.`object`.Science
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.`object`.UpgradeTrigger
import de.darkatra.bfme2.ini.model.`object`.Weapon
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class FireWeaponWhenDeadBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("StartsActive") val startsActive: Boolean = false,
    @SageIniName("ActiveDuringConstruction") val activeDuringConstruction: Boolean = false,
    @SageIniName("DelayTime") val delayTime: Int = 0,
    @SageIniName("DeathWeapon") val deathWeapon: SageReference<Weapon>? = null,
    @SageIniName("WeaponOffset") val weaponOffset: Coords? = null,
    @SageIniName("TriggeredBy") val triggeredBy: List<SageReference<UpgradeTrigger>> = emptyList(),
    @SageIniName("ConflictsWith") val conflictsWith: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("RequiresAllTriggers") val requiresAllTriggers: Boolean = false,
    @SageIniName("RequiresAllConflictingTriggers") val requiresAllConflictingTriggers: Boolean = false,
    @SageIniName("Permanent") val permanent: Boolean = false,
    @SageIniName("DeathType") val deathType: SageFilter? = null,
    @SageIniName("ExemptStatus") val exemptStatus: ObjectStatus? = null,
    @SageIniName("RequiredStatus") val requiredStatus: ObjectStatus? = null,
    @SageIniName("DamageAmountRequired") val damageAmountRequired: Double = 0.0,
    @SageIniName("MinKillerAngle") val minKillerAngle: Int = 0,
    @SageIniName("MaxKillerAngle") val maxKillerAngle: Int = 0,
    @SageIniName("CustomAnimAndDuration") val customAnimAndDuration: Map<String, String> = emptyMap(),
    @SageIniName("DeathTypes") val deathTypes: SageFilter? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<FireWeaponWhenDeadBehavior>(
        name = "FireWeaponWhenDeadBehavior",
        properties = {
            property("StartsActive", BooleanValue) { it.startsActive }
            property("ActiveDuringConstruction", BooleanValue) { it.activeDuringConstruction }
            property("DelayTime", IntValue) { it.delayTime }
            property("DeathWeapon", ReferenceValue<Weapon> { listOf(Weapon) }) { it.deathWeapon }
            property("WeaponOffset", Coords.type) { it.weaponOffset }
            property("TriggeredBy", ListValue(ReferenceValue<UpgradeTrigger> { listOf(Upgrade, Science) })) { it.triggeredBy }
            property("ConflictsWith", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.conflictsWith }
            property("RequiresAllTriggers", BooleanValue) { it.requiresAllTriggers }
            property("RequiresAllConflictingTriggers", BooleanValue) { it.requiresAllConflictingTriggers }
            property("Permanent", BooleanValue) { it.permanent }
            property("DeathType", SageFilter.type) { it.deathType }
            property("ExemptStatus", ObjectStatus.type) { it.exemptStatus }
            property("RequiredStatus", ObjectStatus.type) { it.requiredStatus }
            property("DamageAmountRequired", FloatValue) { it.damageAmountRequired }
            property("MinKillerAngle", IntValue) { it.minKillerAngle }
            property("MaxKillerAngle", IntValue) { it.maxKillerAngle }
            property("CustomAnimAndDuration", MapValue(StringValue, StringValue)) { it.customAnimAndDuration }
            property("DeathTypes", SageFilter.type) { it.deathTypes }
        },
    )
}
