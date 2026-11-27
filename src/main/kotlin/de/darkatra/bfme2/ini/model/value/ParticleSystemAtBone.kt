package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.`object`.FXParticleSystem
import de.darkatra.bfme2.ini.model.`object`.ParticleSystemDefinition
import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue
import de.darkatra.bfme2.ini.model.common.SageParticleSystem

/**
 * A particle system attached to a bone of a `TransitionDamageFX`, e.g. `Bone:None RandomBone:No PSys:FireBuildingLarge`.
 */
data class ParticleSystemAtBone(
    val bone: String = "",
    val randomBone: Boolean = false,
    val particleSystem: SageReference<SageParticleSystem>? = null,
) {

    companion object {

        val type: SageIniValueType<ParticleSystemAtBone> = StructValue("ParticleSystemAtBone") {
            component("Bone", StringValue) { it.bone }
            component("RandomBone", BooleanValue) { it.randomBone }
            component("PSys", ReferenceValue<SageParticleSystem> { listOf(FXParticleSystem, ParticleSystemDefinition) }) { it.particleSystem }
        }
    }
}
