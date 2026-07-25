package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.SageIniModel
import de.darkatra.bfme2.ini.model.common.Event
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageDraw
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.particle.Alpha
import de.darkatra.bfme2.ini.model.particle.Color
import de.darkatra.bfme2.ini.model.particle.EmissionVelocity
import de.darkatra.bfme2.ini.model.particle.EmissionVolume
import de.darkatra.bfme2.ini.model.particle.Emitter
import de.darkatra.bfme2.ini.model.particle.Physics
import de.darkatra.bfme2.ini.model.particle.System
import de.darkatra.bfme2.ini.model.particle.Update
import de.darkatra.bfme2.ini.model.particle.Wind
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.ParticleSystemPriority
import de.darkatra.bfme2.ini.model.value.ParticleSystemShader
import de.darkatra.bfme2.ini.model.value.ParticleSystemType
import de.darkatra.bfme2.ini.model.value.RandomVariable
import de.darkatra.bfme2.ini.model.value.TextureFile

data class FXParticleSystem(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("BurstCount") val burstCount: RandomVariable? = null,
    @SageIniName("BurstDelay") val burstDelay: RandomVariable? = null,
    @SageIniName("InitialDelay") val initialDelay: RandomVariable? = null,
    @SageIniName("IsEmitAboveGroundOnly") val isEmitAboveGroundOnly: Boolean = false,
    @SageIniName("IsGroundAligned") val isGroundAligned: Boolean = false,
    @SageIniName("IsOneShot") val isOneShot: Boolean = false,
    @SageIniName("IsParticleUpTowardsEmitter") val isParticleUpTowardsEmitter: Boolean = false,
    @SageIniName("Lifetime") val lifetime: RandomVariable? = null,
    @SageIniName("ParticleName") val particleName: TextureFile? = null,
    @SageIniName("PerParticleAttachedSystem") val perParticleAttachedSystem: Opaque? = null,
    @SageIniName("Priority") val priority: ParticleSystemPriority? = null,
    @SageIniName("Shader") val shader: ParticleSystemShader? = null,
    @SageIniName("ShroudEmitter") val shroudEmitter: Boolean = false,
    @SageIniName("Size") val size: RandomVariable? = null,
    @SageIniName("SlavePosOffset") val slavePosOffset: Coords? = null,
    @SageIniName("SlaveSystem") val slaveSystem: Opaque? = null,
    @SageIniName("SortLevel") val sortLevel: Int = 0,
    @SageIniName("StartSizeRate") val startSizeRate: RandomVariable? = null,
    @SageIniName("SystemLifetime") val systemLifetime: Int = 0,
    @SageIniName("Type") val type: ParticleSystemType? = null,
    @SageIniName("UseMaximumHeight") val useMaximumHeight: Boolean = false,
    @SageIniName("System") val system: List<System> = emptyList(),
    @SageIniName("Color") val color: List<Color> = emptyList(),
    @SageIniName("Alpha") val alpha: List<Alpha> = emptyList(),
    @SageIniName("Update") val update: List<Update> = emptyList(),
    @SageIniName("Physics") val physics: List<Physics> = emptyList(),
    @SageIniName("EmissionVelocity") val emissionVelocity: List<EmissionVelocity> = emptyList(),
    @SageIniName("EmissionVolume") val emissionVolume: List<EmissionVolume> = emptyList(),
    @SageIniName("Wind") val wind: List<Wind> = emptyList(),
    @SageIniName("Draw") val draw: List<SageDraw> = emptyList(),
    @SageIniName("Event") val event: List<Event> = emptyList(),
    @SageIniName("Emitter") val emitter: List<Emitter> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<FXParticleSystem>(
        name = "FXParticleSystem",
        tableKey = "particlesystems",
        properties = {
            property("BurstCount", RandomVariable.type) { it.burstCount }
            property("BurstDelay", RandomVariable.type) { it.burstDelay }
            property("InitialDelay", RandomVariable.type) { it.initialDelay }
            property("IsEmitAboveGroundOnly", BooleanValue) { it.isEmitAboveGroundOnly }
            property("IsGroundAligned", BooleanValue) { it.isGroundAligned }
            property("IsOneShot", BooleanValue) { it.isOneShot }
            property("IsParticleUpTowardsEmitter", BooleanValue) { it.isParticleUpTowardsEmitter }
            property("Lifetime", RandomVariable.type) { it.lifetime }
            property("ParticleName", TextureFile.type) { it.particleName }
            property("PerParticleAttachedSystem", Opaque.type) { it.perParticleAttachedSystem }
            property("Priority", ParticleSystemPriority.type) { it.priority }
            property("Shader", ParticleSystemShader.type) { it.shader }
            property("ShroudEmitter", BooleanValue) { it.shroudEmitter }
            property("Size", RandomVariable.type) { it.size }
            property("SlavePosOffset", Coords.type) { it.slavePosOffset }
            property("SlaveSystem", Opaque.type) { it.slaveSystem }
            property("SortLevel", IntValue) { it.sortLevel }
            property("StartSizeRate", RandomVariable.type) { it.startSizeRate }
            property("SystemLifetime", IntValue) { it.systemLifetime }
            property("Type", ParticleSystemType.type) { it.type }
            property("UseMaximumHeight", BooleanValue) { it.useMaximumHeight }
            property("System", ListValue(BlockValue<System> { listOf(System) })) { it.system }
            property("Color", ListValue(BlockValue<Color> { listOf(Color) })) { it.color }
            property("Alpha", ListValue(BlockValue<Alpha> { listOf(Alpha) })) { it.alpha }
            property("Update", ListValue(BlockValue<Update> { listOf(Update) })) { it.update }
            property("Physics", ListValue(BlockValue<Physics> { listOf(Physics) })) { it.physics }
            property("EmissionVelocity", ListValue(BlockValue<EmissionVelocity> { listOf(EmissionVelocity) })) { it.emissionVelocity }
            property("EmissionVolume", ListValue(BlockValue<EmissionVolume> { listOf(EmissionVolume) })) { it.emissionVolume }
            property("Wind", ListValue(BlockValue<Wind> { listOf(Wind) })) { it.wind }
            property("Draw", ListValue(BlockValue<SageDraw> { SageIniModel.draws })) { it.draw }
            property("Event", ListValue(BlockValue<Event> { listOf(Event) })) { it.event }
            property("Emitter", ListValue(BlockValue<Emitter> { listOf(Emitter) })) { it.emitter }
        },
    )
}
