package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.SpecialPower
import de.darkatra.bfme2.ini.model.`object`.Weapon
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.SpecialPowerUnpackConditions

data class ArrowStormUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialPowerTemplate") val specialPowerTemplate: SageReference<SpecialPower>? = null,
    @SageIniName("StartAbilityRange") val startAbilityRange: Double = 0.0,
    @SageIniName("UnpackingVariation") val unpackingVariation: Int = 0,
    @SageIniName("UnpackTime") val unpackTime: Int = 0,
    @SageIniName("PreparationTime") val preparationTime: Int = 0,
    @SageIniName("PersistentPrepTime") val persistentPrepTime: Int = 0,
    @SageIniName("PackTime") val packTime: Int = 0,
    @SageIniName("ApproachRequiresLOS") val approachRequiresLOS: Boolean = false,
    @SageIniName("AwardXPForTriggering") val awardXPForTriggering: Int = 0,
    @SageIniName("ActiveLoopSound") val activeLoopSound: SageReference<AudioEvent>? = null,
    @SageIniName("WeaponTemplate") val weaponTemplate: SageReference<Weapon>? = null,
    @SageIniName("TargetRadius") val targetRadius: Double = 0.0,
    @SageIniName("ShotsPerTarget") val shotsPerTarget: Int = 0,
    @SageIniName("ShotsPerBurst") val shotsPerBurst: Int = 0,
    @SageIniName("MaxShots") val maxShots: Int = 0,
    @SageIniName("ParalyzeDurationWhenAborted") val paralyzeDurationWhenAborted: Int = 0,
    @SageIniName("ParalyzeDurationWhenCompleted") val paralyzeDurationWhenCompleted: Int = 0,
    @SageIniName("CanShootEmptyGround") val canShootEmptyGround: Boolean = false,
    @SageIniName("RequiredConditions") val requiredConditions: SpecialPowerUnpackConditions? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<ArrowStormUpdate>(
        name = "ArrowStormUpdate",
        properties = {
            property("SpecialPowerTemplate", ReferenceValue<SpecialPower> { listOf(SpecialPower) }) { it.specialPowerTemplate }
            property("StartAbilityRange", FloatValue) { it.startAbilityRange }
            property("UnpackingVariation", IntValue) { it.unpackingVariation }
            property("UnpackTime", IntValue) { it.unpackTime }
            property("PreparationTime", IntValue) { it.preparationTime }
            property("PersistentPrepTime", IntValue) { it.persistentPrepTime }
            property("PackTime", IntValue) { it.packTime }
            property("ApproachRequiresLOS", BooleanValue) { it.approachRequiresLOS }
            property("AwardXPForTriggering", IntValue) { it.awardXPForTriggering }
            property("ActiveLoopSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.activeLoopSound }
            property("WeaponTemplate", ReferenceValue<Weapon> { listOf(Weapon) }) { it.weaponTemplate }
            property("TargetRadius", FloatValue) { it.targetRadius }
            property("ShotsPerTarget", IntValue) { it.shotsPerTarget }
            property("ShotsPerBurst", IntValue) { it.shotsPerBurst }
            property("MaxShots", IntValue) { it.maxShots }
            property("ParalyzeDurationWhenAborted", IntValue) { it.paralyzeDurationWhenAborted }
            property("ParalyzeDurationWhenCompleted", IntValue) { it.paralyzeDurationWhenCompleted }
            property("CanShootEmptyGround", BooleanValue) { it.canShootEmptyGround }
            property("RequiredConditions", SpecialPowerUnpackConditions.type) { it.requiredConditions }
        },
    )
}
