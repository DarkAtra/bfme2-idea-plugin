package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.`object`.SpecialPower
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageReference

data class AutoAbilityBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialAbility") val specialAbility: SageReference<SpecialPower>? = null,
    @SageIniName("MaxScanRange") val maxScanRange: Double = 0.0,
    @SageIniName("MinScanRange") val minScanRange: Double = 0.0,
    @SageIniName("WorkingRadius") val workingRadius: Double = 0.0,
    @SageIniName("StartsActive") val startsActive: Boolean = false,
    @SageIniName("BaseMaxRangeFromStartPos") val baseMaxRangeFromStartPos: Boolean = false,
    @SageIniName("AdjustAttackMeleePosition") val adjustAttackMeleePosition: Boolean = false,
    @SageIniName("Query") val query: List<List<String>> = emptyList(),
    @SageIniName("AllowSelf") val allowSelf: Boolean = false,
    @SageIniName("IdleTimeSeconds") val idleTimeSeconds: Double = 0.0,
    @SageIniName("ForbiddenStatus") val forbiddenStatus: ObjectStatus? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<AutoAbilityBehavior>(
        name = "AutoAbilityBehavior",
        properties = {
            property("SpecialAbility", ReferenceValue<SpecialPower> { listOf(SpecialPower) }) { it.specialAbility }
            property("MaxScanRange", FloatValue) { it.maxScanRange }
            property("MinScanRange", FloatValue) { it.minScanRange }
            property("WorkingRadius", FloatValue) { it.workingRadius }
            property("StartsActive", BooleanValue) { it.startsActive }
            property("BaseMaxRangeFromStartPos", BooleanValue) { it.baseMaxRangeFromStartPos }
            property("AdjustAttackMeleePosition", BooleanValue) { it.adjustAttackMeleePosition }
            property("Query", ListValue(ListValue(StringValue))) { it.query }
            property("AllowSelf", BooleanValue) { it.allowSelf }
            property("IdleTimeSeconds", FloatValue) { it.idleTimeSeconds }
            property("ForbiddenStatus", ObjectStatus.type) { it.forbiddenStatus }
        },
    )
}
