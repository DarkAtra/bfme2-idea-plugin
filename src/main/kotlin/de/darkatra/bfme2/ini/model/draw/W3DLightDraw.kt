package de.darkatra.bfme2.ini.model.draw

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.Rgba

data class W3DLightDraw(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Ambient") val ambient: Rgba? = null,
    @SageIniName("Diffuse") val diffuse: Rgba? = null,
    @SageIniName("Radius") val radius: Double = 0.0,
    @SageIniName("Intensity") val intensity: Double = 0.0,
    @SageIniName("AttachToBoneInAnotherModule") val attachToBoneInAnotherModule: Opaque? = null,
    @SageIniName("FlickerAmplitude") val flickerAmplitude: Double = 0.0,
    @SageIniName("FlickerFrequency") val flickerFrequency: Double = 0.0,
    @SageIniName("DefaultModelConditionState") override val defaultModelConditionState: List<DefaultModelConditionState> = emptyList(),
    @SageIniName("ModelConditionState") override val modelConditionState: List<ModelConditionState> = emptyList(),
    @SageIniName("ConditionState") override val conditionState: List<ModelConditionState> = emptyList(),
    @SageIniName("DefaultConditionState") override val defaultConditionState: List<DefaultModelConditionState> = emptyList(),
    @SageIniName("AliasConditionState") override val aliasConditionState: List<ModelConditionState> = emptyList(),
    @SageIniName("DefaultAnimationState") override val defaultAnimationState: List<DefaultAnimationState> = emptyList(),
    @SageIniName("IdleAnimationState") override val idleAnimationState: List<IdleAnimationState> = emptyList(),
    @SageIniName("AnimationState") override val animationState: List<AnimationState> = emptyList(),
    @SageIniName("TransitionState") override val transitionState: List<TransitionState> = emptyList(),
    @SageIniName("LodOptions") override val lodOptions: List<LodOptions> = emptyList(),
) : Draw() {

    companion object : SageIniBlockDescriptor<W3DLightDraw>(
        name = "W3DLightDraw",
        parent = Draw,
        properties = {
            property("Ambient", Rgba.type) { it.ambient }
            property("Diffuse", Rgba.type) { it.diffuse }
            property("Radius", FloatValue) { it.radius }
            property("Intensity", FloatValue) { it.intensity }
            property("AttachToBoneInAnotherModule", Opaque.type) { it.attachToBoneInAnotherModule }
            property("FlickerAmplitude", FloatValue) { it.flickerAmplitude }
            property("FlickerFrequency", FloatValue) { it.flickerFrequency }
        },
    )
}
