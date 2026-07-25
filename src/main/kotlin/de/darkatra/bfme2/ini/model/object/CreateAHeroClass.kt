package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class CreateAHeroClass(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("NameTag") val nameTag: Untyped? = null,
    @SageIniName("DescriptionTag") val descriptionTag: Untyped? = null,
    @SageIniName("PowersDescTag") val powersDescTag: String = "",
    @SageIniName("UpgradeName") val upgradeName: SageReference<Upgrade>? = null,
    @SageIniName("IconImage") val iconImage: Opaque? = null,
    @SageIniName("SubClass") val subClass: List<SubClass> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<CreateAHeroClass>(
        name = "CreateAHeroClass",
        tableKey = "createaheroclass",
        properties = {
            property("NameTag", Untyped.type) { it.nameTag }
            property("DescriptionTag", Untyped.type) { it.descriptionTag }
            property("PowersDescTag", StringValue) { it.powersDescTag }
            property("UpgradeName", ReferenceValue<Upgrade> { listOf(Upgrade) }) { it.upgradeName }
            property("IconImage", Opaque.type) { it.iconImage }
            property("SubClass", ListValue(BlockValue<SubClass> { listOf(SubClass) })) { it.subClass }
        },
    )
}
