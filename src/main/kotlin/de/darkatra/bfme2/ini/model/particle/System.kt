package de.darkatra.bfme2.ini.model.particle

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.ParticleSystemType
import de.darkatra.bfme2.ini.model.value.TextureFile
import de.darkatra.bfme2.ini.model.value.Untyped

data class System(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Priority") val priority: Untyped? = null,
    @SageIniName("Shader") val shader: Untyped? = null,
    @SageIniName("Type") val type: ParticleSystemType? = null,
    @SageIniName("ParticleName") val particleName: TextureFile? = null,
    @SageIniName("SystemLifetime") val systemLifetime: Int = 0,
    @SageIniName("SortLevel") val sortLevel: Int = 0,
    @SageIniName("IsOneShot") val isOneShot: Boolean = false,
    @SageIniName("IsGroundAligned") val isGroundAligned: Boolean = false,
    @SageIniName("Lifetime") val lifetime: List<Int> = emptyList(),
    @SageIniName("Size") val size: List<Double> = emptyList(),
    @SageIniName("StartSizeRate") val startSizeRate: List<Double> = emptyList(),
    @SageIniName("BurstDelay") val burstDelay: List<Double> = emptyList(),
    @SageIniName("BurstCount") val burstCount: List<Int> = emptyList(),
    @SageIniName("InitialDelay") val initialDelay: List<Int> = emptyList(),
    @SageIniName("Gravity") val gravity: Double = 0.0,
    @SageIniName("IsEmitAboveGroundOnly") val isEmitAboveGroundOnly: Boolean = false,
    @SageIniName("IsParticleUpTowardsEmitter") val isParticleUpTowardsEmitter: Boolean = false,
    @SageIniName("UseMaximumHeight") val useMaximumHeight: Boolean = false,
    @SageIniName("ShroudEmitter") val shroudEmitter: Boolean = false,
    @SageIniName("PerParticleAttachedSystem") val perParticleAttachedSystem: Opaque? = null,
    @SageIniName("SlaveSystem") val slaveSystem: Opaque? = null,
    @SageIniName("SlavePosOffset") val slavePosOffset: Coords? = null,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<System>(
        name = "System",
        keyedByLabel = true,
        properties = {
            property("Priority", Untyped.type) { it.priority }
            property("Shader", Untyped.type) { it.shader }
            property("Type", ParticleSystemType.type) { it.type }
            property("ParticleName", TextureFile.type) { it.particleName }
            property("SystemLifetime", IntValue) { it.systemLifetime }
            property("SortLevel", IntValue) { it.sortLevel }
            property("IsOneShot", BooleanValue) { it.isOneShot }
            property("IsGroundAligned", BooleanValue) { it.isGroundAligned }
            property("Lifetime", ListValue(IntValue)) { it.lifetime }
            property("Size", ListValue(FloatValue)) { it.size }
            property("StartSizeRate", ListValue(FloatValue)) { it.startSizeRate }
            property("BurstDelay", ListValue(FloatValue)) { it.burstDelay }
            property("BurstCount", ListValue(IntValue)) { it.burstCount }
            property("InitialDelay", ListValue(IntValue)) { it.initialDelay }
            property("Gravity", FloatValue) { it.gravity }
            property("IsEmitAboveGroundOnly", BooleanValue) { it.isEmitAboveGroundOnly }
            property("IsParticleUpTowardsEmitter", BooleanValue) { it.isParticleUpTowardsEmitter }
            property("UseMaximumHeight", BooleanValue) { it.useMaximumHeight }
            property("ShroudEmitter", BooleanValue) { it.shroudEmitter }
            property("PerParticleAttachedSystem", Opaque.type) { it.perParticleAttachedSystem }
            property("SlaveSystem", Opaque.type) { it.slaveSystem }
            property("SlavePosOffset", Coords.type) { it.slavePosOffset }
        },
    )
}
