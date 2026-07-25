package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Untyped

data class CreateAHeroBlingBinder(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("GroupName") val groupName: Untyped? = null,
    @SageIniName("LabelTag") val labelTag: Untyped? = null,
    @SageIniName("DescriptionTag") val descriptionTag: Untyped? = null,
    @SageIniName("UISlot") val uISlot: Int = 0,
    @SageIniName("BlingType") val blingType: Untyped? = null,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<CreateAHeroBlingBinder>(
        name = "CreateAHeroBlingBinder",
        properties = {
            property("GroupName", Untyped.type) { it.groupName }
            property("LabelTag", Untyped.type) { it.labelTag }
            property("DescriptionTag", Untyped.type) { it.descriptionTag }
            property("UISlot", IntValue) { it.uISlot }
            property("BlingType", Untyped.type) { it.blingType }
        },
    )
}
