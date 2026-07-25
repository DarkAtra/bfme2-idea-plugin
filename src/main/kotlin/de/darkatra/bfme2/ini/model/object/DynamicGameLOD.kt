package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.value.ParticleSystemPriority

data class DynamicGameLOD(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("MinimumFPS") val minimumFPS: Int = 0,
    @SageIniName("ParticleSkipMask") val particleSkipMask: Int = 0,
    @SageIniName("DebrisSkipMask") val debrisSkipMask: Int = 0,
    @SageIniName("SlowDeathScale") val slowDeathScale: Double = 0.0,
    @SageIniName("MinParticlePriority") val minParticlePriority: ParticleSystemPriority? = null,
    @SageIniName("MinParticleSkipPriority") val minParticleSkipPriority: ParticleSystemPriority? = null,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<DynamicGameLOD>(
        name = "DynamicGameLOD",
        tableKey = "dynamicgamelods",
        properties = {
            property("MinimumFPS", IntValue) { it.minimumFPS }
            property("ParticleSkipMask", IntValue) { it.particleSkipMask }
            property("DebrisSkipMask", IntValue) { it.debrisSkipMask }
            property("SlowDeathScale", FloatValue) { it.slowDeathScale }
            property("MinParticlePriority", ParticleSystemPriority.type) { it.minParticlePriority }
            property("MinParticleSkipPriority", ParticleSystemPriority.type) { it.minParticleSkipPriority }
        },
    )
}
