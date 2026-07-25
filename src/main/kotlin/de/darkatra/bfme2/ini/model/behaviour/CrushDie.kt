package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class CrushDie(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DeathType") override val deathType: SageFilter? = null,
    @SageIniName("DeathTypes") override val deathTypes: SageFilter? = null,
    @SageIniName("ExemptStatus") override val exemptStatus: ObjectStatus? = null,
    @SageIniName("RequiredStatus") override val requiredStatus: ObjectStatus? = null,
    @SageIniName("DamageAmountRequired") override val damageAmountRequired: Double = 0.0,
    @SageIniName("MinKillerAngle") override val minKillerAngle: Int = 0,
    @SageIniName("MaxKillerAngle") override val maxKillerAngle: Int = 0,
    @SageIniName("TotalCrushSoundPercent") val totalCrushSoundPercent: Int = 0,
    @SageIniName("BackEndCrushSoundPercent") val backEndCrushSoundPercent: Int = 0,
    @SageIniName("FrontEndCrushSoundPercent") val frontEndCrushSoundPercent: Int = 0,
    @SageIniName("TotalCrushSound") val totalCrushSound: SageReference<AudioEvent>? = null,
    @SageIniName("BackEndCrushSound") val backEndCrushSound: SageReference<AudioEvent>? = null,
    @SageIniName("FrontEndCrushSound") val frontEndCrushSound: SageReference<AudioEvent>? = null,
) : DieBehavior() {

    companion object : SageIniBlockDescriptor<CrushDie>(
        name = "CrushDie",
        parent = DieBehavior,
        properties = {
            property("TotalCrushSoundPercent", IntValue) { it.totalCrushSoundPercent }
            property("BackEndCrushSoundPercent", IntValue) { it.backEndCrushSoundPercent }
            property("FrontEndCrushSoundPercent", IntValue) { it.frontEndCrushSoundPercent }
            property("TotalCrushSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.totalCrushSound }
            property("BackEndCrushSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.backEndCrushSound }
            property("FrontEndCrushSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.frontEndCrushSound }
        },
    )
}
