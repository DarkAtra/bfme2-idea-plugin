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
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.ObjectCreationList
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.PhasedReferences
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.StructureCollapsePhase

data class StructureCollapseUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("MinCollapseDelay") val minCollapseDelay: Int = 0,
    @SageIniName("MaxCollapseDelay") val maxCollapseDelay: Int = 0,
    @SageIniName("CollapseDamping") val collapseDamping: Double = 0.0,
    @SageIniName("MaxShudder") val maxShudder: Double = 0.0,
    @SageIniName("MinBurstDelay") val minBurstDelay: Int = 0,
    @SageIniName("MaxBurstDelay") val maxBurstDelay: Int = 0,
    @SageIniName("BigBurstFrequency") val bigBurstFrequency: Int = 0,
    @SageIniName("OCL") val oCL: List<PhasedReferences<StructureCollapsePhase, ObjectCreationList>> = emptyList(),
    @SageIniName("FXList") val fXList: List<PhasedReferences<StructureCollapsePhase, FXList>> = emptyList(),
    @SageIniName("DestroyObjectWhenDone") val destroyObjectWhenDone: Boolean = false,
    @SageIniName("CollapseHeight") val collapseHeight: Double = 0.0,
    @SageIniName("DeathType") val deathType: SageFilter? = null,
    @SageIniName("ExemptStatus") val exemptStatus: ObjectStatus? = null,
    @SageIniName("RequiredStatus") val requiredStatus: ObjectStatus? = null,
    @SageIniName("DamageAmountRequired") val damageAmountRequired: Double = 0.0,
    @SageIniName("MinKillerAngle") val minKillerAngle: Int = 0,
    @SageIniName("MaxKillerAngle") val maxKillerAngle: Int = 0,
    @SageIniName("DeathTypes") val deathTypes: SageFilter? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<StructureCollapseUpdate>(
        name = "StructureCollapseUpdate",
        properties = {
            property("MinCollapseDelay", IntValue) { it.minCollapseDelay }
            property("MaxCollapseDelay", IntValue) { it.maxCollapseDelay }
            property("CollapseDamping", FloatValue) { it.collapseDamping }
            property("MaxShudder", FloatValue) { it.maxShudder }
            property("MinBurstDelay", IntValue) { it.minBurstDelay }
            property("MaxBurstDelay", IntValue) { it.maxBurstDelay }
            property("BigBurstFrequency", IntValue) { it.bigBurstFrequency }
            property(
                "OCL",
                ListValue(PhasedReferences.type(StructureCollapsePhase.type, ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }))
            ) { it.oCL }
            property("FXList", ListValue(PhasedReferences.type(StructureCollapsePhase.type, ReferenceValue<FXList> { listOf(FXList) }))) { it.fXList }
            property("DestroyObjectWhenDone", BooleanValue) { it.destroyObjectWhenDone }
            property("CollapseHeight", FloatValue) { it.collapseHeight }
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
