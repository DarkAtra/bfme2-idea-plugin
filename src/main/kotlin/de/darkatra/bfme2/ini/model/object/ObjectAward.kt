package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class ObjectAward(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("AwardName") val awardName: Untyped? = null,
    @SageIniName("ImageName") val imageName: SageReference<MappedImage>? = null,
    @SageIniName("NameTag") val nameTag: Untyped? = null,
    @SageIniName("DescriptionTag") val descriptionTag: Untyped? = null,
    @SageIniName("Trigger") val trigger: List<Trigger> = emptyList(),
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<ObjectAward>(
        name = "ObjectAward",
        properties = {
            property("AwardName", Untyped.type) { it.awardName }
            property("ImageName", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.imageName }
            property("NameTag", Untyped.type) { it.nameTag }
            property("DescriptionTag", Untyped.type) { it.descriptionTag }
            property("Trigger", ListValue(BlockValue<Trigger> { listOf(Trigger) })) { it.trigger }
        },
    )
}
