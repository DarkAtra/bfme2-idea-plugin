package de.darkatra.bfme2.ini.model.draw

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.value.TextureFile

data class W3DProjectileStreamDraw(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Texture") val texture: TextureFile? = null,
    @SageIniName("Width") val width: Double = 0.0,
    @SageIniName("TileFactor") val tileFactor: Double = 0.0,
    @SageIniName("ScrollRate") val scrollRate: Double = 0.0,
    @SageIniName("MaxSegments") val maxSegments: Int = 0,
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

    companion object : SageIniBlockDescriptor<W3DProjectileStreamDraw>(
        name = "W3DProjectileStreamDraw",
        parent = Draw,
        properties = {
            property("Texture", TextureFile.type) { it.texture }
            property("Width", FloatValue) { it.width }
            property("TileFactor", FloatValue) { it.tileFactor }
            property("ScrollRate", FloatValue) { it.scrollRate }
            property("MaxSegments", IntValue) { it.maxSegments }
        },
    )
}
