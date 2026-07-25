package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Rgba
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class SubClass(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("NameTag") val nameTag: Untyped? = null,
    @SageIniName("DescriptionTag") val descriptionTag: Untyped? = null,
    @SageIniName("UpgradeName") val upgradeName: SageReference<Upgrade>? = null,
    @SageIniName("IconImage") val iconImage: Untyped? = null,
    @SageIniName("ButtonImage") val buttonImage: SageReference<MappedImage>? = null,
    @SageIniName("Stats") val stats: List<Untyped> = emptyList(),
    @SageIniName("BlingUpgrades") val blingUpgrades: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("Awards") val awards: List<Untyped> = emptyList(),
    @SageIniName("SpendableAttributePoints") val spendableAttributePoints: Int = 0,
    @SageIniName("UsableFactions") val usableFactions: Untyped? = null,
    @SageIniName("DefaultFaction") val defaultFaction: Untyped? = null,
    @SageIniName("DefaultPrimaryColor") val defaultPrimaryColor: Rgba? = null,
    @SageIniName("DefaultSecondaryColor") val defaultSecondaryColor: Rgba? = null,
    @SageIniName("DefaultTertiaryColor") val defaultTertiaryColor: Rgba? = null,
    @SageIniName("PowersDescTag") val powersDescTag: String = "",
    @SageIniName("Attribute") val attribute: List<Attribute> = emptyList(),
    @SageIniName("ViewInfo") val viewInfo: List<ViewInfo> = emptyList(),
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<SubClass>(
        name = "SubClass",
        properties = {
            property("NameTag", Untyped.type) { it.nameTag }
            property("DescriptionTag", Untyped.type) { it.descriptionTag }
            property("UpgradeName", ReferenceValue<Upgrade> { listOf(Upgrade) }) { it.upgradeName }
            property("IconImage", Untyped.type) { it.iconImage }
            property("ButtonImage", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.buttonImage }
            property("Stats", ListValue(Untyped.type)) { it.stats }
            property("BlingUpgrades", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.blingUpgrades }
            property("Awards", ListValue(Untyped.type)) { it.awards }
            property("SpendableAttributePoints", IntValue) { it.spendableAttributePoints }
            property("UsableFactions", Untyped.type) { it.usableFactions }
            property("DefaultFaction", Untyped.type) { it.defaultFaction }
            property("DefaultPrimaryColor", Rgba.type) { it.defaultPrimaryColor }
            property("DefaultSecondaryColor", Rgba.type) { it.defaultSecondaryColor }
            property("DefaultTertiaryColor", Rgba.type) { it.defaultTertiaryColor }
            property("PowersDescTag", StringValue) { it.powersDescTag }
            property("Attribute", ListValue(BlockValue<Attribute> { listOf(Attribute) })) { it.attribute }
            property("ViewInfo", ListValue(BlockValue<ViewInfo> { listOf(ViewInfo) })) { it.viewInfo }
        },
    )
}
