package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.ObjectCreationList
import de.darkatra.bfme2.ini.model.`object`.Weapon
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class StructureToppleUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("MinToppleDelay") val minToppleDelay: Int = 0,
    @SageIniName("MaxToppleDelay") val maxToppleDelay: Int = 0,
    @SageIniName("MinToppleBurstDelay") val minToppleBurstDelay: Int = 0,
    @SageIniName("MaxToppleBurstDelay") val maxToppleBurstDelay: Int = 0,
    @SageIniName("StructuralIntegrity") val structuralIntegrity: Double = 0.0,
    @SageIniName("StructuralDecay") val structuralDecay: Double = 0.0,
    @SageIniName("DamageFXTypes") val damageFXTypes: SageFilter? = null,
    @SageIniName("ToppleStartFX") val toppleStartFX: SageReference<FXList>? = null,
    @SageIniName("ToppleDelayFX") val toppleDelayFX: SageReference<FXList>? = null,
    @SageIniName("CrushingFX") val crushingFX: SageReference<FXList>? = null,
    @SageIniName("AngleFX") val angleFX: SageReference<FXList>? = null,
    @SageIniName("ToppleDoneFX") val toppleDoneFX: SageReference<FXList>? = null,
    @SageIniName("CrushingWeaponName") val crushingWeaponName: SageReference<Weapon>? = null,
    @SageIniName("ToppleAccelerationFactor") val toppleAccelerationFactor: Double = 0.0,
    @SageIniName("ForceToppleAngle") val forceToppleAngle: Double = 0.0,
    @SageIniName("OCL") val oCL: SageReference<ObjectCreationList>? = null,
    @SageIniName("DeathType") val deathType: SageFilter? = null,
    @SageIniName("ExemptStatus") val exemptStatus: ObjectStatus? = null,
    @SageIniName("RequiredStatus") val requiredStatus: ObjectStatus? = null,
    @SageIniName("DamageAmountRequired") val damageAmountRequired: Double = 0.0,
    @SageIniName("MinKillerAngle") val minKillerAngle: Int = 0,
    @SageIniName("MaxKillerAngle") val maxKillerAngle: Int = 0,
    @SageIniName("TopplingFX") val topplingFX: SageReference<FXList>? = null,
    @SageIniName("DeathTypes") val deathTypes: SageFilter? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<StructureToppleUpdate>(
        name = "StructureToppleUpdate",
        properties = {
            property("MinToppleDelay", IntValue) { it.minToppleDelay }
            property("MaxToppleDelay", IntValue) { it.maxToppleDelay }
            property("MinToppleBurstDelay", IntValue) { it.minToppleBurstDelay }
            property("MaxToppleBurstDelay", IntValue) { it.maxToppleBurstDelay }
            property("StructuralIntegrity", FloatValue) { it.structuralIntegrity }
            property("StructuralDecay", FloatValue) { it.structuralDecay }
            property("DamageFXTypes", SageFilter.type) { it.damageFXTypes }
            property("ToppleStartFX", ReferenceValue<FXList> { listOf(FXList) }) { it.toppleStartFX }
            property("ToppleDelayFX", ReferenceValue<FXList> { listOf(FXList) }) { it.toppleDelayFX }
            property("CrushingFX", ReferenceValue<FXList> { listOf(FXList) }) { it.crushingFX }
            property("AngleFX", ReferenceValue<FXList> { listOf(FXList) }) { it.angleFX }
            property("ToppleDoneFX", ReferenceValue<FXList> { listOf(FXList) }) { it.toppleDoneFX }
            property("CrushingWeaponName", ReferenceValue<Weapon> { listOf(Weapon) }) { it.crushingWeaponName }
            property("ToppleAccelerationFactor", FloatValue) { it.toppleAccelerationFactor }
            property("ForceToppleAngle", FloatValue) { it.forceToppleAngle }
            property("OCL", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.oCL }
            property("DeathType", SageFilter.type) { it.deathType }
            property("ExemptStatus", ObjectStatus.type) { it.exemptStatus }
            property("RequiredStatus", ObjectStatus.type) { it.requiredStatus }
            property("DamageAmountRequired", FloatValue) { it.damageAmountRequired }
            property("MinKillerAngle", IntValue) { it.minKillerAngle }
            property("MaxKillerAngle", IntValue) { it.maxKillerAngle }
            property("TopplingFX", ReferenceValue<FXList> { listOf(FXList) }) { it.topplingFX }
            property("DeathTypes", SageFilter.type) { it.deathTypes }
        },
    )
}
