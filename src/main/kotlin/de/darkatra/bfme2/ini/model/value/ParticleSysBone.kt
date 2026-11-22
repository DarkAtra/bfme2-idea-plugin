package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.`object`.ParticleSystemDefinition
import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.MapValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue
import de.darkatra.bfme2.ini.model.`object`.FXParticleSystem
import de.darkatra.bfme2.ini.model.common.SageParticleSystem

data class ParticleSysBone(
    val bone: Opaque? = null,
    val particleSystem: SageReference<SageParticleSystem>? = null,
    val options: Map<String, String> = emptyMap(),
) {

    companion object {

        val type: SageIniValueType<ParticleSysBone> = StructValue("ParticleSysBone") {
            component("Bone", Opaque.type) { it.bone }
            component("ParticleSystem", ReferenceValue<SageParticleSystem> { listOf(FXParticleSystem, ParticleSystemDefinition) }) { it.particleSystem }
            component("Options", MapValue(StringValue, StringValue)) { it.options }
        }
    }
}
