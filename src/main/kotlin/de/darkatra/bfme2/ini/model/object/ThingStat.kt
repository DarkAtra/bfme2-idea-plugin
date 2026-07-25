package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.KindOf
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class ThingStat(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("StatName") val statName: Untyped? = null,
    @SageIniName("NameTag") val nameTag: Untyped? = null,
    @SageIniName("DescriptionTag") val descriptionTag: String = "",
    @SageIniName("ThingTemplateNames") val thingTemplateNames: List<SageReference<Object>> = emptyList(),
    @SageIniName("KindOf") val kindOf: List<KindOf> = emptyList(),
    @SageIniName("ExcludedKindOf") val excludedKindOf: List<KindOf> = emptyList(),
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<ThingStat>(
        name = "ThingStat",
        properties = {
            property("StatName", Untyped.type) { it.statName }
            property("NameTag", Untyped.type) { it.nameTag }
            property("DescriptionTag", StringValue) { it.descriptionTag }
            property("ThingTemplateNames", ListValue(ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) })) { it.thingTemplateNames }
            property("KindOf", ListValue(KindOf.type)) { it.kindOf }
            property("ExcludedKindOf", ListValue(KindOf.type)) { it.excludedKindOf }
        },
    )
}
