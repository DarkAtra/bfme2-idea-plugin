package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class CreateAHeroBling(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("NameTag") val nameTag: String = "",
    @SageIniName("DescriptionTag") val descriptionTag: String = "",
    @SageIniName("GroupName") val groupName: Untyped? = null,
    @SageIniName("BlingUpgradeName") val blingUpgradeName: SageReference<Upgrade>? = null,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<CreateAHeroBling>(
        name = "CreateAHeroBling",
        properties = {
            property("NameTag", StringValue) { it.nameTag }
            property("DescriptionTag", StringValue) { it.descriptionTag }
            property("GroupName", Untyped.type) { it.groupName }
            property("BlingUpgradeName", ReferenceValue<Upgrade> { listOf(Upgrade) }) { it.blingUpgradeName }
        },
    )
}
