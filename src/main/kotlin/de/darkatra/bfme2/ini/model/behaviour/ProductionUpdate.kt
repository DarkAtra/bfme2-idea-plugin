package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.`object`.ProductionModifier
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class ProductionUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("NumDoorAnimations") val numDoorAnimations: Int = 0,
    @SageIniName("DoorOpeningTime") val doorOpeningTime: Int = 0,
    @SageIniName("DoorWaitOpenTime") val doorWaitOpenTime: Int = 0,
    @SageIniName("DoorCloseTime") val doorCloseTime: Int = 0,
    @SageIniName("ConstructionCompleteDuration") val constructionCompleteDuration: Int = 0,
    @SageIniName("MaxQueueEntries") val maxQueueEntries: Int = 0,
    @SageIniName("QuantityModifier") val quantityModifier: Opaque? = null,
    @SageIniName("DisabledTypesToProcess") val disabledTypesToProcess: List<Untyped> = emptyList(),
    @SageIniName("VeteranUnitsFromVeteranFactory") val veteranUnitsFromVeteranFactory: Boolean = false,
    @SageIniName("SetBonusModelConditionOnSpeedBonus") val setBonusModelConditionOnSpeedBonus: Boolean = false,
    @SageIniName("BonusForType") val bonusForType: List<SageReference<Object>> = emptyList(),
    @SageIniName("SpeedBonusAudioLoop") val speedBonusAudioLoop: SageReference<AudioEvent>? = null,
    @SageIniName("UnitInvulnerableTime") val unitInvulnerableTime: Int = 0,
    @SageIniName("GiveNoXP") val giveNoXP: Boolean = false,
    @SageIniName("SpecialPrepModelconditionTime") val specialPrepModelconditionTime: Int = 0,
    @SageIniName("SetBonusModelConditionOnSpeedBon") val setBonusModelConditionOnSpeedBon: Boolean = false,
    @SageIniName("SecondaryQueue") val secondaryQueue: Boolean = false,
    @SageIniName("ProductionModifier") val productionModifier: List<ProductionModifier> = emptyList(),
) : SageBehavior {

    companion object : SageIniBlockDescriptor<ProductionUpdate>(
        name = "ProductionUpdate",
        properties = {
            property("NumDoorAnimations", IntValue) { it.numDoorAnimations }
            property("DoorOpeningTime", IntValue) { it.doorOpeningTime }
            property("DoorWaitOpenTime", IntValue) { it.doorWaitOpenTime }
            property("DoorCloseTime", IntValue) { it.doorCloseTime }
            property("ConstructionCompleteDuration", IntValue) { it.constructionCompleteDuration }
            property("MaxQueueEntries", IntValue) { it.maxQueueEntries }
            property("QuantityModifier", Opaque.type) { it.quantityModifier }
            property("DisabledTypesToProcess", ListValue(Untyped.type)) { it.disabledTypesToProcess }
            property("VeteranUnitsFromVeteranFactory", BooleanValue) { it.veteranUnitsFromVeteranFactory }
            property("SetBonusModelConditionOnSpeedBonus", BooleanValue) { it.setBonusModelConditionOnSpeedBonus }
            property("BonusForType", ListValue(ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) })) { it.bonusForType }
            property("SpeedBonusAudioLoop", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.speedBonusAudioLoop }
            property("UnitInvulnerableTime", IntValue) { it.unitInvulnerableTime }
            property("GiveNoXP", BooleanValue) { it.giveNoXP }
            property("SpecialPrepModelconditionTime", IntValue) { it.specialPrepModelconditionTime }
            property("SetBonusModelConditionOnSpeedBon", BooleanValue) { it.setBonusModelConditionOnSpeedBon }
            property("SecondaryQueue", BooleanValue) { it.secondaryQueue }
            property("ProductionModifier", ListValue(BlockValue<ProductionModifier> { listOf(ProductionModifier) })) { it.productionModifier }
        },
    )
}
