package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.FXParticleSystem
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageReference

data class LaserUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("MuzzleParticleSystem") val muzzleParticleSystem: SageReference<FXParticleSystem>? = null,
    @SageIniName("ParentFireBoneName") val parentFireBoneName: Opaque? = null,
    @SageIniName("ParentFireBoneOnTurret") val parentFireBoneOnTurret: Boolean = false,
    @SageIniName("TargetParticleSystem") val targetParticleSystem: SageReference<FXParticleSystem>? = null,
    @SageIniName("PunchThroughScalar") val punchThroughScalar: Double = 0.0,
    @SageIniName("LaserLifetime") val laserLifetime: Double = 0.0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<LaserUpdate>(
        name = "LaserUpdate",
        properties = {
            property("MuzzleParticleSystem", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.muzzleParticleSystem }
            property("ParentFireBoneName", Opaque.type) { it.parentFireBoneName }
            property("ParentFireBoneOnTurret", BooleanValue) { it.parentFireBoneOnTurret }
            property("TargetParticleSystem", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.targetParticleSystem }
            property("PunchThroughScalar", FloatValue) { it.punchThroughScalar }
            property("LaserLifetime", FloatValue) { it.laserLifetime }
        },
    )
}
