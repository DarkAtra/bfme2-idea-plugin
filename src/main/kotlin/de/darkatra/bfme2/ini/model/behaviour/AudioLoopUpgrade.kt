package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.`object`.UpgradeTrigger
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class AudioLoopUpgrade(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("TriggeredBy") override val triggeredBy: List<SageReference<UpgradeTrigger>> = emptyList(),
    @SageIniName("ConflictsWith") override val conflictsWith: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("RequiresAllTriggers") override val requiresAllTriggers: Boolean = false,
    @SageIniName("RequiresAllConflictingTriggers") override val requiresAllConflictingTriggers: Boolean = false,
    @SageIniName("StartsActive") override val startsActive: Boolean = false,
    @SageIniName("Description") override val description: String = "",
    @SageIniName("ActiveDuringConstruction") override val activeDuringConstruction: Boolean = false,
    @SageIniName("CustomAnimAndDuration") override val customAnimAndDuration: Map<String, String> = emptyMap(),
    @SageIniName("Permanent") override val permanent: Boolean = false,
    @SageIniName("DeathType") val deathType: SageFilter? = null,
    @SageIniName("ExemptStatus") val exemptStatus: ObjectStatus? = null,
    @SageIniName("RequiredStatus") val requiredStatus: ObjectStatus? = null,
    @SageIniName("DamageAmountRequired") val damageAmountRequired: Double = 0.0,
    @SageIniName("MinKillerAngle") val minKillerAngle: Int = 0,
    @SageIniName("MaxKillerAngle") val maxKillerAngle: Int = 0,
    @SageIniName("KillAfterMS") val killAfterMS: Int = 0,
    @SageIniName("KillOnDeath") val killOnDeath: Boolean = false,
    @SageIniName("DeathTypes") val deathTypes: SageFilter? = null,
    @SageIniName("SoundToPlay") val soundToPlay: SageReference<AudioEvent>? = null,
) : UpgradeBehavior() {

    companion object : SageIniBlockDescriptor<AudioLoopUpgrade>(
        name = "AudioLoopUpgrade",
        parent = UpgradeBehavior,
        properties = {
            property("DeathType", SageFilter.type) { it.deathType }
            property("ExemptStatus", ObjectStatus.type) { it.exemptStatus }
            property("RequiredStatus", ObjectStatus.type) { it.requiredStatus }
            property("DamageAmountRequired", FloatValue) { it.damageAmountRequired }
            property("MinKillerAngle", IntValue) { it.minKillerAngle }
            property("MaxKillerAngle", IntValue) { it.maxKillerAngle }
            property("KillAfterMS", IntValue) { it.killAfterMS }
            property("KillOnDeath", BooleanValue) { it.killOnDeath }
            property("DeathTypes", SageFilter.type) { it.deathTypes }
            property("SoundToPlay", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.soundToPlay }
        },
    )
}
