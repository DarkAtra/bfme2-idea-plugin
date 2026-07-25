package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.FXParticleSystem
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageReference

data class SlavedUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("GuardMaxRange") val guardMaxRange: Int = 0,
    @SageIniName("GuardWanderRange") val guardWanderRange: Int = 0,
    @SageIniName("AttackRange") val attackRange: Int = 0,
    @SageIniName("AttackWanderRange") val attackWanderRange: Int = 0,
    @SageIniName("ScoutRange") val scoutRange: Int = 0,
    @SageIniName("ScoutWanderRange") val scoutWanderRange: Int = 0,
    @SageIniName("RepairRange") val repairRange: Int = 0,
    @SageIniName("RepairMinAltitude") val repairMinAltitude: Double = 0.0,
    @SageIniName("RepairMaxAltitude") val repairMaxAltitude: Double = 0.0,
    @SageIniName("RepairRatePerSecond") val repairRatePerSecond: Double = 0.0,
    @SageIniName("RepairMinReadyTime") val repairMinReadyTime: Int = 0,
    @SageIniName("RepairMaxReadyTime") val repairMaxReadyTime: Int = 0,
    @SageIniName("RepairMinWeldTime") val repairMinWeldTime: Int = 0,
    @SageIniName("RepairMaxWeldTime") val repairMaxWeldTime: Int = 0,
    @SageIniName("RepairWeldingSys") val repairWeldingSys: SageReference<FXParticleSystem>? = null,
    @SageIniName("RepairWeldingFXBone") val repairWeldingFXBone: Opaque? = null,
    @SageIniName("DistToTargetToGrantRangeBonus") val distToTargetToGrantRangeBonus: Int = 0,
    @SageIniName("StayOnSameLayerAsMaster") val stayOnSameLayerAsMaster: Boolean = false,
    @SageIniName("LeashRange") val leashRange: Int = 0,
    @SageIniName("UseSlaverAsControlForEvaObjectSightedEvents") val useSlaverAsControlForEvaObjectSightedEvents: Boolean = false,
    @SageIniName("DieOnMastersDeath") val dieOnMastersDeath: Boolean = false,
    @SageIniName("MarkUnselectable") val markUnselectable: Boolean = false,
    @SageIniName("GuardPositionOffset") val guardPositionOffset: Coords? = null,
    @SageIniName("FadeOutRange") val fadeOutRange: Int = 0,
    @SageIniName("FadeTime") val fadeTime: Int = 0,
    @SageIniName("RepairWhenBelowHealth_") val repairWhenBelowHealth: Int = 0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<SlavedUpdate>(
        name = "SlavedUpdate",
        properties = {
            property("GuardMaxRange", IntValue) { it.guardMaxRange }
            property("GuardWanderRange", IntValue) { it.guardWanderRange }
            property("AttackRange", IntValue) { it.attackRange }
            property("AttackWanderRange", IntValue) { it.attackWanderRange }
            property("ScoutRange", IntValue) { it.scoutRange }
            property("ScoutWanderRange", IntValue) { it.scoutWanderRange }
            property("RepairRange", IntValue) { it.repairRange }
            property("RepairMinAltitude", FloatValue) { it.repairMinAltitude }
            property("RepairMaxAltitude", FloatValue) { it.repairMaxAltitude }
            property("RepairRatePerSecond", FloatValue) { it.repairRatePerSecond }
            property("RepairMinReadyTime", IntValue) { it.repairMinReadyTime }
            property("RepairMaxReadyTime", IntValue) { it.repairMaxReadyTime }
            property("RepairMinWeldTime", IntValue) { it.repairMinWeldTime }
            property("RepairMaxWeldTime", IntValue) { it.repairMaxWeldTime }
            property("RepairWeldingSys", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.repairWeldingSys }
            property("RepairWeldingFXBone", Opaque.type) { it.repairWeldingFXBone }
            property("DistToTargetToGrantRangeBonus", IntValue) { it.distToTargetToGrantRangeBonus }
            property("StayOnSameLayerAsMaster", BooleanValue) { it.stayOnSameLayerAsMaster }
            property("LeashRange", IntValue) { it.leashRange }
            property("UseSlaverAsControlForEvaObjectSightedEvents", BooleanValue) { it.useSlaverAsControlForEvaObjectSightedEvents }
            property("DieOnMastersDeath", BooleanValue) { it.dieOnMastersDeath }
            property("MarkUnselectable", BooleanValue) { it.markUnselectable }
            property("GuardPositionOffset", Coords.type) { it.guardPositionOffset }
            property("FadeOutRange", IntValue) { it.fadeOutRange }
            property("FadeTime", IntValue) { it.fadeTime }
            property("RepairWhenBelowHealth_", IntValue) { it.repairWhenBelowHealth }
        },
    )
}
