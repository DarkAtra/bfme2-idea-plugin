package de.darkatra.bfme2.ini.model.draw

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.value.Rgba
import de.darkatra.bfme2.ini.model.value.TextureFile
import de.darkatra.bfme2.ini.model.value.Untyped

data class W3DLaserDraw(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ArcHeight") val arcHeight: Double = 0.0,
    @SageIniName("Envelope") val envelope: Untyped? = null,
    @SageIniName("Texture") val texture: TextureFile? = null,
    @SageIniName("NumBeams") val numBeams: Int = 0,
    @SageIniName("Segments") val segments: Int = 0,
    @SageIniName("InnerBeamWidth") val innerBeamWidth: Double = 0.0,
    @SageIniName("OuterBeamWidth") val outerBeamWidth: Double = 0.0,
    @SageIniName("SegmentOverlapRatio") val segmentOverlapRatio: Double = 0.0,
    @SageIniName("TilingScalar") val tilingScalar: Double = 0.0,
    @SageIniName("FanWidth") val fanWidth: Double = 0.0,
    @SageIniName("ScrollRate") val scrollRate: Double = 0.0,
    @SageIniName("InnerColor") val innerColor: Rgba? = null,
    @SageIniName("OuterColor") val outerColor: Rgba? = null,
    @SageIniName("Tile") val tile: Boolean = false,
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

    companion object : SageIniBlockDescriptor<W3DLaserDraw>(
        name = "W3DLaserDraw",
        parent = Draw,
        properties = {
            property("ArcHeight", FloatValue) { it.arcHeight }
            property("Envelope", Untyped.type) { it.envelope }
            property("Texture", TextureFile.type) { it.texture }
            property("NumBeams", IntValue) { it.numBeams }
            property("Segments", IntValue) { it.segments }
            property("InnerBeamWidth", FloatValue) { it.innerBeamWidth }
            property("OuterBeamWidth", FloatValue) { it.outerBeamWidth }
            property("SegmentOverlapRatio", FloatValue) { it.segmentOverlapRatio }
            property("TilingScalar", FloatValue) { it.tilingScalar }
            property("FanWidth", FloatValue) { it.fanWidth }
            property("ScrollRate", FloatValue) { it.scrollRate }
            property("InnerColor", Rgba.type) { it.innerColor }
            property("OuterColor", Rgba.type) { it.outerColor }
            property("Tile", BooleanValue) { it.tile }
        },
    )
}
