package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageParticleSystem
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.ParticleSystemPriority
import de.darkatra.bfme2.ini.model.value.ParticleSystemShader
import de.darkatra.bfme2.ini.model.value.ParticleSystemType
import de.darkatra.bfme2.ini.model.value.ParticleVelocityType
import de.darkatra.bfme2.ini.model.value.ParticleVolumeType
import de.darkatra.bfme2.ini.model.value.ParticleWindMotion
import de.darkatra.bfme2.ini.model.value.RandomVariable
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.TextureFile
import de.darkatra.bfme2.ini.model.value.Untyped

/**
 * The flat particle system format, declared at the top level as `ParticleSystem Name`, e.g. in `particlesystem.ini`. `ParticleSystem`
 * blocks inside an `FXList` are described by [de.darkatra.bfme2.ini.model.particle.ParticleSystem].
 */
data class ParticleSystemDefinition(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Priority") val priority: ParticleSystemPriority? = null,
    @SageIniName("IsOneShot") val isOneShot: Boolean = false,
    @SageIniName("Shader") val shader: ParticleSystemShader? = null,
    @SageIniName("Type") val type: ParticleSystemType? = null,
    @SageIniName("ParticleName") val particleName: TextureFile? = null,
    @SageIniName("AngleX") val angleX: RandomVariable? = null,
    @SageIniName("AngleY") val angleY: RandomVariable? = null,
    @SageIniName("AngleZ") val angleZ: RandomVariable? = null,
    @SageIniName("AngularRateX") val angularRateX: RandomVariable? = null,
    @SageIniName("AngularRateY") val angularRateY: RandomVariable? = null,
    @SageIniName("AngularRateZ") val angularRateZ: RandomVariable? = null,
    @SageIniName("AngularDamping") val angularDamping: RandomVariable? = null,
    @SageIniName("VelocityDamping") val velocityDamping: RandomVariable? = null,
    @SageIniName("Gravity") val gravity: Double = 0.0,
    @SageIniName("Lifetime") val lifetime: RandomVariable? = null,
    @SageIniName("Size") val size: RandomVariable? = null,
    @SageIniName("StartSizeRate") val startSizeRate: RandomVariable? = null,
    @SageIniName("SizeRate") val sizeRate: RandomVariable? = null,
    @SageIniName("SizeRateDamping") val sizeRateDamping: RandomVariable? = null,
    @SageIniName("SystemLifetime") val systemLifetime: Int = 0,
    @SageIniName("Alpha1") val alpha1: List<Double> = emptyList(),
    @SageIniName("Alpha2") val alpha2: List<Double> = emptyList(),
    @SageIniName("Alpha3") val alpha3: List<Double> = emptyList(),
    @SageIniName("Alpha4") val alpha4: List<Double> = emptyList(),
    @SageIniName("Alpha5") val alpha5: List<Double> = emptyList(),
    @SageIniName("Alpha6") val alpha6: List<Double> = emptyList(),
    @SageIniName("Alpha7") val alpha7: List<Double> = emptyList(),
    @SageIniName("Alpha8") val alpha8: List<Double> = emptyList(),
    @SageIniName("Color1") val color1: Untyped? = null,
    @SageIniName("Color2") val color2: Untyped? = null,
    @SageIniName("Color3") val color3: Untyped? = null,
    @SageIniName("Color4") val color4: Untyped? = null,
    @SageIniName("Color5") val color5: Untyped? = null,
    @SageIniName("Color6") val color6: Untyped? = null,
    @SageIniName("Color7") val color7: Untyped? = null,
    @SageIniName("Color8") val color8: Untyped? = null,
    @SageIniName("ColorScale") val colorScale: RandomVariable? = null,
    @SageIniName("BurstDelay") val burstDelay: RandomVariable? = null,
    @SageIniName("BurstCount") val burstCount: RandomVariable? = null,
    @SageIniName("InitialDelay") val initialDelay: RandomVariable? = null,
    @SageIniName("DriftVelocity") val driftVelocity: Coords? = null,
    @SageIniName("VelocityType") val velocityType: ParticleVelocityType? = null,
    @SageIniName("VelOutward") val velOutward: RandomVariable? = null,
    @SageIniName("VelOutwardOther") val velOutwardOther: RandomVariable? = null,
    @SageIniName("VelOrthoX") val velOrthoX: RandomVariable? = null,
    @SageIniName("VelOrthoY") val velOrthoY: RandomVariable? = null,
    @SageIniName("VelOrthoZ") val velOrthoZ: RandomVariable? = null,
    @SageIniName("VelSpherical") val velSpherical: RandomVariable? = null,
    @SageIniName("VelHemispherical") val velHemispherical: RandomVariable? = null,
    @SageIniName("VelCylindricalRadial") val velCylindricalRadial: RandomVariable? = null,
    @SageIniName("VelCylindricalNormal") val velCylindricalNormal: RandomVariable? = null,
    @SageIniName("VolumeType") val volumeType: ParticleVolumeType? = null,
    @SageIniName("VolLineStart") val volLineStart: Coords? = null,
    @SageIniName("VolLineEnd") val volLineEnd: Coords? = null,
    @SageIniName("VolBoxHalfSize") val volBoxHalfSize: Coords? = null,
    @SageIniName("VolCylinderRadius") val volCylinderRadius: Double = 0.0,
    @SageIniName("VolCylinderLength") val volCylinderLength: Double = 0.0,
    @SageIniName("VolSphereRadius") val volSphereRadius: Double = 0.0,
    @SageIniName("IsHollow") val isHollow: Boolean = false,
    @SageIniName("IsGroundAligned") val isGroundAligned: Boolean = false,
    @SageIniName("IsEmitAboveGroundOnly") val isEmitAboveGroundOnly: Boolean = false,
    @SageIniName("IsParticleUpTowardsEmitter") val isParticleUpTowardsEmitter: Boolean = false,
    @SageIniName("WindMotion") val windMotion: ParticleWindMotion? = null,
    @SageIniName("WindStrength") val windStrength: Double = 0.0,
    @SageIniName("WindFullStrengthDist") val windFullStrengthDist: Double = 0.0,
    @SageIniName("WindZeroStrengthDist") val windZeroStrengthDist: Double = 0.0,
    @SageIniName("WindAngleChangeMin") val windAngleChangeMin: Double = 0.0,
    @SageIniName("WindAngleChangeMax") val windAngleChangeMax: Double = 0.0,
    @SageIniName("WindPingPongStartAngleMin") val windPingPongStartAngleMin: Double = 0.0,
    @SageIniName("WindPingPongStartAngleMax") val windPingPongStartAngleMax: Double = 0.0,
    @SageIniName("WindPingPongEndAngleMin") val windPingPongEndAngleMin: Double = 0.0,
    @SageIniName("WindPingPongEndAngleMax") val windPingPongEndAngleMax: Double = 0.0,
    @SageIniName("SlaveSystem") val slaveSystem: SageReference<FXParticleSystem>? = null,
    @SageIniName("SlavePosOffset") val slavePosOffset: Coords? = null,
    @SageIniName("PerParticleAttachedSystem") val perParticleAttachedSystem: SageReference<SageParticleSystem>? = null,
) : SageParticleSystem {

    companion object : SageIniBlockDescriptor<ParticleSystemDefinition>(
        name = "ParticleSystem",
        tableKey = "particlesystems",
        properties = {
            property("Priority", ParticleSystemPriority.type) { it.priority }
            property("IsOneShot", BooleanValue) { it.isOneShot }
            property("Shader", ParticleSystemShader.type) { it.shader }
            property("Type", ParticleSystemType.type) { it.type }
            property("ParticleName", TextureFile.type) { it.particleName }
            property("AngleX", RandomVariable.type) { it.angleX }
            property("AngleY", RandomVariable.type) { it.angleY }
            property("AngleZ", RandomVariable.type) { it.angleZ }
            property("AngularRateX", RandomVariable.type) { it.angularRateX }
            property("AngularRateY", RandomVariable.type) { it.angularRateY }
            property("AngularRateZ", RandomVariable.type) { it.angularRateZ }
            property("AngularDamping", RandomVariable.type) { it.angularDamping }
            property("VelocityDamping", RandomVariable.type) { it.velocityDamping }
            property("Gravity", FloatValue) { it.gravity }
            property("Lifetime", RandomVariable.type) { it.lifetime }
            property("Size", RandomVariable.type) { it.size }
            property("StartSizeRate", RandomVariable.type) { it.startSizeRate }
            property("SizeRate", RandomVariable.type) { it.sizeRate }
            property("SizeRateDamping", RandomVariable.type) { it.sizeRateDamping }
            property("SystemLifetime", IntValue) { it.systemLifetime }
            property("Alpha1", ListValue(FloatValue)) { it.alpha1 }
            property("Alpha2", ListValue(FloatValue)) { it.alpha2 }
            property("Alpha3", ListValue(FloatValue)) { it.alpha3 }
            property("Alpha4", ListValue(FloatValue)) { it.alpha4 }
            property("Alpha5", ListValue(FloatValue)) { it.alpha5 }
            property("Alpha6", ListValue(FloatValue)) { it.alpha6 }
            property("Alpha7", ListValue(FloatValue)) { it.alpha7 }
            property("Alpha8", ListValue(FloatValue)) { it.alpha8 }
            property("Color1", Untyped.type) { it.color1 }
            property("Color2", Untyped.type) { it.color2 }
            property("Color3", Untyped.type) { it.color3 }
            property("Color4", Untyped.type) { it.color4 }
            property("Color5", Untyped.type) { it.color5 }
            property("Color6", Untyped.type) { it.color6 }
            property("Color7", Untyped.type) { it.color7 }
            property("Color8", Untyped.type) { it.color8 }
            property("ColorScale", RandomVariable.type) { it.colorScale }
            property("BurstDelay", RandomVariable.type) { it.burstDelay }
            property("BurstCount", RandomVariable.type) { it.burstCount }
            property("InitialDelay", RandomVariable.type) { it.initialDelay }
            property("DriftVelocity", Coords.type) { it.driftVelocity }
            property("VelocityType", ParticleVelocityType.type) { it.velocityType }
            property("VelOutward", RandomVariable.type) { it.velOutward }
            property("VelOutwardOther", RandomVariable.type) { it.velOutwardOther }
            property("VelOrthoX", RandomVariable.type) { it.velOrthoX }
            property("VelOrthoY", RandomVariable.type) { it.velOrthoY }
            property("VelOrthoZ", RandomVariable.type) { it.velOrthoZ }
            property("VelSpherical", RandomVariable.type) { it.velSpherical }
            property("VelHemispherical", RandomVariable.type) { it.velHemispherical }
            property("VelCylindricalRadial", RandomVariable.type) { it.velCylindricalRadial }
            property("VelCylindricalNormal", RandomVariable.type) { it.velCylindricalNormal }
            property("VolumeType", ParticleVolumeType.type) { it.volumeType }
            property("VolLineStart", Coords.type) { it.volLineStart }
            property("VolLineEnd", Coords.type) { it.volLineEnd }
            property("VolBoxHalfSize", Coords.type) { it.volBoxHalfSize }
            property("VolCylinderRadius", FloatValue) { it.volCylinderRadius }
            property("VolCylinderLength", FloatValue) { it.volCylinderLength }
            property("VolSphereRadius", FloatValue) { it.volSphereRadius }
            property("IsHollow", BooleanValue) { it.isHollow }
            property("IsGroundAligned", BooleanValue) { it.isGroundAligned }
            property("IsEmitAboveGroundOnly", BooleanValue) { it.isEmitAboveGroundOnly }
            property("IsParticleUpTowardsEmitter", BooleanValue) { it.isParticleUpTowardsEmitter }
            property("WindMotion", ParticleWindMotion.type) { it.windMotion }
            property("WindStrength", FloatValue) { it.windStrength }
            property("WindFullStrengthDist", FloatValue) { it.windFullStrengthDist }
            property("WindZeroStrengthDist", FloatValue) { it.windZeroStrengthDist }
            property("WindAngleChangeMin", FloatValue) { it.windAngleChangeMin }
            property("WindAngleChangeMax", FloatValue) { it.windAngleChangeMax }
            property("WindPingPongStartAngleMin", FloatValue) { it.windPingPongStartAngleMin }
            property("WindPingPongStartAngleMax", FloatValue) { it.windPingPongStartAngleMax }
            property("WindPingPongEndAngleMin", FloatValue) { it.windPingPongEndAngleMin }
            property("WindPingPongEndAngleMax", FloatValue) { it.windPingPongEndAngleMax }
            property("SlaveSystem", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.slaveSystem }
            property("SlavePosOffset", Coords.type) { it.slavePosOffset }
            property("PerParticleAttachedSystem", ReferenceValue<SageParticleSystem> { listOf(FXParticleSystem, ParticleSystemDefinition) }) { it.perParticleAttachedSystem }
        },
    )
}
