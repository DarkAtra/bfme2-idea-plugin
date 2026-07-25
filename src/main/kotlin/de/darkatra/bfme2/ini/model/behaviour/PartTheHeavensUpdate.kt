package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.FCurve
import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.MappedImage
import de.darkatra.bfme2.ini.model.value.Rgba
import de.darkatra.bfme2.ini.model.value.SageReference

data class PartTheHeavensUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Texture") val texture: SageReference<MappedImage>? = null,
    @SageIniName("Color") val color: Rgba? = null,
    @SageIniName("Radius") val radius: List<FCurve> = emptyList(),
    @SageIniName("Opacity") val opacity: List<FCurve> = emptyList(),
    @SageIniName("Angle") val angle: List<FCurve> = emptyList(),
) : SageBehavior {

    companion object : SageIniBlockDescriptor<PartTheHeavensUpdate>(
        name = "PartTheHeavensUpdate",
        properties = {
            property("Texture", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.texture }
            property("Color", Rgba.type) { it.color }
            property("Radius", ListValue(BlockValue<FCurve> { listOf(FCurve) })) { it.radius }
            property("Opacity", ListValue(BlockValue<FCurve> { listOf(FCurve) })) { it.opacity }
            property("Angle", ListValue(BlockValue<FCurve> { listOf(FCurve) })) { it.angle }
        },
    )
}
