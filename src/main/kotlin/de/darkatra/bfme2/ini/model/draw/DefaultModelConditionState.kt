package de.darkatra.bfme2.ini.model.draw

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.`object`.MappedImage
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.ParticleSysBone
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.TextureFile
import de.darkatra.bfme2.ini.model.value.Untyped

data class DefaultModelConditionState(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Model") override val model: List<String> = emptyList(),
    @SageIniName("Skeleton") override val skeleton: Untyped? = null,
    @SageIniName("Flags") override val flags: Untyped? = null,
    @SageIniName("TransitionKey") override val transitionKey: Untyped? = null,
    @SageIniName("WaitForStateToFinishIfPossible") override val waitForStateToFinishIfPossible: Untyped? = null,
    @SageIniName("ParticleSysBone") override val particleSysBone: List<ParticleSysBone> = emptyList(),
    @SageIniName("WeaponLaunchBone") override val weaponLaunchBone: List<Untyped> = emptyList(),
    @SageIniName("WeaponFireFXBone") override val weaponFireFXBone: List<Untyped> = emptyList(),
    @SageIniName("FXEvent") override val fXEvent: List<Untyped> = emptyList(),
    @SageIniName("Texture") override val texture: List<TextureFile> = emptyList(),
    @SageIniName("RetainSubObjects") override val retainSubObjects: Boolean = false,
    @SageIniName("ModelAnimationPrefix") override val modelAnimationPrefix: String = "",
    @SageIniName("PortraitImageName") override val portraitImageName: String = "",
    @SageIniName("ButtonImageName") override val buttonImageName: SageReference<MappedImage>? = null,
    @SageIniName("OverrideTooltip") override val overrideTooltip: Untyped? = null,
    @SageIniName("Turret") override val turret: Opaque? = null,
    @SageIniName("TurretArtAngle") override val turretArtAngle: Double = 0.0,
    @SageIniName("Shadow") override val shadow: Untyped? = null,
    @SageIniName("ShadowSizeX") override val shadowSizeX: Int = 0,
    @SageIniName("ShadowSizeY") override val shadowSizeY: Int = 0,
    @SageIniName("ShadowTexture") override val shadowTexture: Opaque? = null,
    @SageIniName("ShadowMaxHeight") override val shadowMaxHeight: Double = 0.0,
    @SageIniName("ShadowOverrideLODVisibility") override val shadowOverrideLODVisibility: Boolean = false,
    @SageIniName("ShadowOpacityStart") override val shadowOpacityStart: Int = 0,
    @SageIniName("ShadowOpacityPeak") override val shadowOpacityPeak: Int = 0,
    @SageIniName("ShadowOpacityEnd") override val shadowOpacityEnd: Int = 0,
    @SageIniName("ShadowOpacityFadeInTime") override val shadowOpacityFadeInTime: Int = 0,
    @SageIniName("ShadowOpacityFadeOutTime") override val shadowOpacityFadeOutTime: Int = 0,
    @SageIniName("AltTurret") override val altTurret: Opaque? = null,
    @SageIniName("AltTurretPitch") override val altTurretPitch: Opaque? = null,
    @SageIniName("StateName") override val stateName: String = "",
    @SageIniName("TurretPitch") override val turretPitch: Opaque? = null,
    @SageIniName("WeaponHideShowBone") override val weaponHideShowBone: Opaque? = null,
    @SageIniName("WeaponMuzzleFlash") override val weaponMuzzleFlash: Opaque? = null,
    @SageIniName("WeaponRecoilBone") override val weaponRecoilBone: Opaque? = null,
) : ModelConditionState() {

    companion object : SageIniBlockDescriptor<DefaultModelConditionState>(
        name = "DefaultModelConditionState",
        parent = ModelConditionState,
    )
}
