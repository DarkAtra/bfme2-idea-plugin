package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.value.KindOf
import de.darkatra.bfme2.ini.model.value.SageReference

data class ParachuteContain(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("PitchRateMax") val pitchRateMax: Int = 0,
    @SageIniName("RollRateMax") val rollRateMax: Int = 0,
    @SageIniName("LowAltitudeDamping") val lowAltitudeDamping: Double = 0.0,
    @SageIniName("ParachuteOpenDist") val parachuteOpenDist: Double = 0.0,
    @SageIniName("AllowInsideKindOf") val allowInsideKindOf: List<KindOf> = emptyList(),
    @SageIniName("ParachuteOpenSound") val parachuteOpenSound: SageReference<AudioEvent>? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<ParachuteContain>(
        name = "ParachuteContain",
        properties = {
            property("PitchRateMax", IntValue) { it.pitchRateMax }
            property("RollRateMax", IntValue) { it.rollRateMax }
            property("LowAltitudeDamping", FloatValue) { it.lowAltitudeDamping }
            property("ParachuteOpenDist", FloatValue) { it.parachuteOpenDist }
            property("AllowInsideKindOf", ListValue(KindOf.type)) { it.allowInsideKindOf }
            property("ParachuteOpenSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.parachuteOpenSound }
        },
    )
}
