package de.darkatra.bfme2.ini.model.draw

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.`object`.MappedImage
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.ParticleSysBone
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.TextureFile
import de.darkatra.bfme2.ini.model.value.Untyped

open class ModelConditionState(
    open val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Model") open val model: List<String> = emptyList(),
    @SageIniName("Skeleton") open val skeleton: Untyped? = null,
    @SageIniName("Flags") open val flags: Untyped? = null,
    @SageIniName("TransitionKey") open val transitionKey: Untyped? = null,
    @SageIniName("WaitForStateToFinishIfPossible") open val waitForStateToFinishIfPossible: Untyped? = null,
    @SageIniName("ParticleSysBone") open val particleSysBone: List<ParticleSysBone> = emptyList(),
    @SageIniName("WeaponLaunchBone") open val weaponLaunchBone: List<Untyped> = emptyList(),
    @SageIniName("WeaponFireFXBone") open val weaponFireFXBone: List<Untyped> = emptyList(),
    @SageIniName("FXEvent") open val fXEvent: List<Untyped> = emptyList(),
    @SageIniName("Texture") open val texture: List<TextureFile> = emptyList(),
    @SageIniName("RetainSubObjects") open val retainSubObjects: Boolean = false,
    @SageIniName("ModelAnimationPrefix") open val modelAnimationPrefix: String = "",
    @SageIniName("PortraitImageName") open val portraitImageName: String = "",
    @SageIniName("ButtonImageName") open val buttonImageName: SageReference<MappedImage>? = null,
    @SageIniName("OverrideTooltip") open val overrideTooltip: Untyped? = null,
    @SageIniName("Turret") open val turret: Opaque? = null,
    @SageIniName("TurretArtAngle") open val turretArtAngle: Double = 0.0,
    @SageIniName("Shadow") open val shadow: Untyped? = null,
    @SageIniName("ShadowSizeX") open val shadowSizeX: Int = 0,
    @SageIniName("ShadowSizeY") open val shadowSizeY: Int = 0,
    @SageIniName("ShadowTexture") open val shadowTexture: Opaque? = null,
    @SageIniName("ShadowMaxHeight") open val shadowMaxHeight: Double = 0.0,
    @SageIniName("ShadowOverrideLODVisibility") open val shadowOverrideLODVisibility: Boolean = false,
    @SageIniName("ShadowOpacityStart") open val shadowOpacityStart: Int = 0,
    @SageIniName("ShadowOpacityPeak") open val shadowOpacityPeak: Int = 0,
    @SageIniName("ShadowOpacityEnd") open val shadowOpacityEnd: Int = 0,
    @SageIniName("ShadowOpacityFadeInTime") open val shadowOpacityFadeInTime: Int = 0,
    @SageIniName("ShadowOpacityFadeOutTime") open val shadowOpacityFadeOutTime: Int = 0,
    @SageIniName("AltTurret") open val altTurret: Opaque? = null,
    @SageIniName("AltTurretPitch") open val altTurretPitch: Opaque? = null,
    @SageIniName("StateName") open val stateName: String = "",
    @SageIniName("TurretPitch") open val turretPitch: Opaque? = null,
    @SageIniName("WeaponHideShowBone") open val weaponHideShowBone: Opaque? = null,
    @SageIniName("WeaponMuzzleFlash") open val weaponMuzzleFlash: Opaque? = null,
    @SageIniName("WeaponRecoilBone") open val weaponRecoilBone: Opaque? = null,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<ModelConditionState>(
        name = "ModelConditionState",
        keyedByLabel = true,
        properties = {
            property("Model", ListValue(StringValue)) { it.model }
            property("Skeleton", Untyped.type) { it.skeleton }
            property("Flags", Untyped.type) { it.flags }
            property("TransitionKey", Untyped.type) { it.transitionKey }
            property("WaitForStateToFinishIfPossible", Untyped.type) { it.waitForStateToFinishIfPossible }
            property("ParticleSysBone", ListValue(ParticleSysBone.type)) { it.particleSysBone }
            property("WeaponLaunchBone", ListValue(Untyped.type)) { it.weaponLaunchBone }
            property("WeaponFireFXBone", ListValue(Untyped.type)) { it.weaponFireFXBone }
            property("FXEvent", ListValue(Untyped.type)) { it.fXEvent }
            property("Texture", ListValue(TextureFile.type)) { it.texture }
            property("RetainSubObjects", BooleanValue) { it.retainSubObjects }
            property("ModelAnimationPrefix", StringValue) { it.modelAnimationPrefix }
            property("PortraitImageName", StringValue) { it.portraitImageName }
            property("ButtonImageName", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.buttonImageName }
            property("OverrideTooltip", Untyped.type) { it.overrideTooltip }
            property("Turret", Opaque.type) { it.turret }
            property("TurretArtAngle", FloatValue) { it.turretArtAngle }
            property("Shadow", Untyped.type) { it.shadow }
            property("ShadowSizeX", IntValue) { it.shadowSizeX }
            property("ShadowSizeY", IntValue) { it.shadowSizeY }
            property("ShadowTexture", Opaque.type) { it.shadowTexture }
            property("ShadowMaxHeight", FloatValue) { it.shadowMaxHeight }
            property("ShadowOverrideLODVisibility", BooleanValue) { it.shadowOverrideLODVisibility }
            property("ShadowOpacityStart", IntValue) { it.shadowOpacityStart }
            property("ShadowOpacityPeak", IntValue) { it.shadowOpacityPeak }
            property("ShadowOpacityEnd", IntValue) { it.shadowOpacityEnd }
            property("ShadowOpacityFadeInTime", IntValue) { it.shadowOpacityFadeInTime }
            property("ShadowOpacityFadeOutTime", IntValue) { it.shadowOpacityFadeOutTime }
            property("AltTurret", Opaque.type) { it.altTurret }
            property("AltTurretPitch", Opaque.type) { it.altTurretPitch }
            property("StateName", StringValue) { it.stateName }
            property("TurretPitch", Opaque.type) { it.turretPitch }
            property("WeaponHideShowBone", Opaque.type) { it.weaponHideShowBone }
            property("WeaponMuzzleFlash", Opaque.type) { it.weaponMuzzleFlash }
            property("WeaponRecoilBone", Opaque.type) { it.weaponRecoilBone }
        },
    )
}
