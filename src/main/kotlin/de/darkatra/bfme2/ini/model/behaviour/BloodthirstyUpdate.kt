package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class BloodthirstyUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SacrificeFilter") val sacrificeFilter: SageFilter? = null,
    @SageIniName("NumToSacrifice") val numToSacrifice: Int = 0,
    @SageIniName("InitiateVoice") val initiateVoice: SageReference<AudioEvent>? = null,
    @SageIniName("InitiateVoice2") val initiateVoice2: Opaque? = null,
    @SageIniName("ExperienceModifier") val experienceModifier: Double = 0.0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<BloodthirstyUpdate>(
        name = "BloodthirstyUpdate",
        properties = {
            property("SacrificeFilter", SageFilter.type) { it.sacrificeFilter }
            property("NumToSacrifice", IntValue) { it.numToSacrifice }
            property("InitiateVoice", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.initiateVoice }
            property("InitiateVoice2", Opaque.type) { it.initiateVoice2 }
            property("ExperienceModifier", FloatValue) { it.experienceModifier }
        },
    )
}
