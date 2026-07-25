package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class ParticleSystemType(override val token: String) : SageIniEnum {
    DRAWABLE("DRAWABLE"),
    GPU_PARTICLE("GPU_PARTICLE"),
    STREAK("STREAK"),
    VOLUME_PARTICLE("VOLUME_PARTICLE"),
    SMUDGE("SMUDGE"),
    GPU_TERRAINFIRE("GPU_TERRAINFIRE");

    companion object {

        val type: EnumValue<ParticleSystemType> = EnumValue("ParticleSystemType", entries)
    }
}
