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
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class RubbleRiseUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("MinRubbleRiseDelay") val minRubbleRiseDelay: Int = 0,
    @SageIniName("MaxRubbleRiseDelay") val maxRubbleRiseDelay: Int = 0,
    @SageIniName("RubbleRiseDamping") val rubbleRiseDamping: Double = 0.0,
    @SageIniName("RubbleHeight") val rubbleHeight: Double = 0.0,
    @SageIniName("MaxShudder") val maxShudder: Double = 0.0,
    @SageIniName("MinBurstDelay") val minBurstDelay: Int = 0,
    @SageIniName("MaxBurstDelay") val maxBurstDelay: Int = 0,
    @SageIniName("BigBurstFrequency") val bigBurstFrequency: Int = 0,
    @SageIniName("FXList") val fXList: SageReference<FXList>? = null,
    @SageIniName("OCL") val oCL: SageReference<ObjectCreationList>? = null,
    @SageIniName("DeathType") val deathType: SageFilter? = null,
    @SageIniName("ExemptStatus") val exemptStatus: ObjectStatus? = null,
    @SageIniName("RequiredStatus") val requiredStatus: ObjectStatus? = null,
    @SageIniName("DamageAmountRequired") val damageAmountRequired: Double = 0.0,
    @SageIniName("MinKillerAngle") val minKillerAngle: Int = 0,
    @SageIniName("MaxKillerAngle") val maxKillerAngle: Int = 0,
    @SageIniName("DeathTypes") val deathTypes: SageFilter? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<RubbleRiseUpdate>(
        name = "RubbleRiseUpdate",
        properties = {
            property("MinRubbleRiseDelay", IntValue) { it.minRubbleRiseDelay }
            property("MaxRubbleRiseDelay", IntValue) { it.maxRubbleRiseDelay }
            property("RubbleRiseDamping", FloatValue) { it.rubbleRiseDamping }
            property("RubbleHeight", FloatValue) { it.rubbleHeight }
            property("MaxShudder", FloatValue) { it.maxShudder }
            property("MinBurstDelay", IntValue) { it.minBurstDelay }
            property("MaxBurstDelay", IntValue) { it.maxBurstDelay }
            property("BigBurstFrequency", IntValue) { it.bigBurstFrequency }
            property("FXList", ReferenceValue<FXList> { listOf(FXList) }) { it.fXList }
            property("OCL", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.oCL }
            property("DeathType", SageFilter.type) { it.deathType }
            property("ExemptStatus", ObjectStatus.type) { it.exemptStatus }
            property("RequiredStatus", ObjectStatus.type) { it.requiredStatus }
            property("DamageAmountRequired", FloatValue) { it.damageAmountRequired }
            property("MinKillerAngle", IntValue) { it.minKillerAngle }
            property("MaxKillerAngle", IntValue) { it.maxKillerAngle }
            property("DeathTypes", SageFilter.type) { it.deathTypes }
        },
    )
}
