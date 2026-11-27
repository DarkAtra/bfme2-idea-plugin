package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.`object`.FXParticleSystem
import de.darkatra.bfme2.ini.model.`object`.ParticleSystemDefinition
import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue
import de.darkatra.bfme2.ini.model.common.SageParticleSystem

/**
 * A particle system attached to a bone of a `BoneFXUpdate`, e.g. `Bone:FIRE01 OnlyOnce:No 0 0 PSys:SmokeStack`.
 */
data class BoneParticleSystem(
    val bone: String = "",
    val onlyOnce: Boolean = false,
    val delayMin: Int = 0,
    val delayMax: Int = 0,
    val particleSystem: SageReference<SageParticleSystem>? = null,
) {

    companion object {

        val type: SageIniValueType<BoneParticleSystem> = StructValue("BoneParticleSystem") {
            component("Bone", StringValue) { it.bone }
            component("OnlyOnce", BooleanValue) { it.onlyOnce }
            component("DelayMin", IntValue) { it.delayMin }
            component("DelayMax", IntValue) { it.delayMax }
            component("PSys", ReferenceValue<SageParticleSystem> { listOf(FXParticleSystem, ParticleSystemDefinition) }) { it.particleSystem }
        }
    }
}
