package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class Attribute(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("GroupName") val groupName: Untyped? = null,
    @SageIniName("MinValueUpgrade") val minValueUpgrade: SageReference<Upgrade>? = null,
    @SageIniName("MaxValueUpgrade") val maxValueUpgrade: SageReference<Upgrade>? = null,
    @SageIniName("DefaultValueUpgrade") val defaultValueUpgrade: SageReference<Upgrade>? = null,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<Attribute>(
        name = "Attribute",
        properties = {
            property("GroupName", Untyped.type) { it.groupName }
            property("MinValueUpgrade", ReferenceValue<Upgrade> { listOf(Upgrade) }) { it.minValueUpgrade }
            property("MaxValueUpgrade", ReferenceValue<Upgrade> { listOf(Upgrade) }) { it.maxValueUpgrade }
            property("DefaultValueUpgrade", ReferenceValue<Upgrade> { listOf(Upgrade) }) { it.defaultValueUpgrade }
        },
    )
}
