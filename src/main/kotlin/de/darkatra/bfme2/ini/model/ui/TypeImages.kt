package de.darkatra.bfme2.ini.model.ui

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.`object`.MappedImage
import de.darkatra.bfme2.ini.model.value.SageReference

data class TypeImages(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("BuildingFortress") val buildingFortress: SageReference<MappedImage>? = null,
    @SageIniName("BuildingArmory") val buildingArmory: SageReference<MappedImage>? = null,
    @SageIniName("BuildingResource") val buildingResource: SageReference<MappedImage>? = null,
    @SageIniName("BuildingBarracks") val buildingBarracks: SageReference<MappedImage>? = null,
    @SageIniName("UnitSoldier") val unitSoldier: SageReference<MappedImage>? = null,
    @SageIniName("UnitArcher") val unitArcher: SageReference<MappedImage>? = null,
    @SageIniName("UnitPikemen") val unitPikemen: SageReference<MappedImage>? = null,
    @SageIniName("UnitCavalry") val unitCavalry: SageReference<MappedImage>? = null,
    @SageIniName("UnitHero") val unitHero: SageReference<MappedImage>? = null,
    @SageIniName("UnitFortress") val unitFortress: SageReference<MappedImage>? = null,
    @SageIniName("UnitSiege") val unitSiege: SageReference<MappedImage>? = null,
    @SageIniName("UnitSupport") val unitSupport: SageReference<MappedImage>? = null,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<TypeImages>(
        name = "TypeImages",
        properties = {
            property("BuildingFortress", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.buildingFortress }
            property("BuildingArmory", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.buildingArmory }
            property("BuildingResource", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.buildingResource }
            property("BuildingBarracks", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.buildingBarracks }
            property("UnitSoldier", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.unitSoldier }
            property("UnitArcher", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.unitArcher }
            property("UnitPikemen", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.unitPikemen }
            property("UnitCavalry", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.unitCavalry }
            property("UnitHero", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.unitHero }
            property("UnitFortress", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.unitFortress }
            property("UnitSiege", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.unitSiege }
            property("UnitSupport", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.unitSupport }
        },
    )
}
