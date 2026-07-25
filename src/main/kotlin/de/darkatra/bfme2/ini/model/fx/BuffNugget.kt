package de.darkatra.bfme2.ini.model.fx

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.Rgb
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class BuffNugget(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("BuffType") val buffType: Untyped? = null,
    @SageIniName("BuffName") val buffName: Untyped? = null,
    @SageIniName("BuffShipTemplate") val buffShipTemplate: Opaque? = null,
    @SageIniName("BuffLifeTime") val buffLifeTime: Int = 0,
    @SageIniName("IsComplexBuff") val isComplexBuff: Boolean = false,
    @SageIniName("FXList") val fXList: SageReference<FXList>? = null,
    @SageIniName("Color") val color: Rgb? = null,
    @SageIniName("Extrusion") val extrusion: Double = 0.0,
    @SageIniName("BuffInfantryTemplate") val buffInfantryTemplate: SageReference<Object>? = null,
    @SageIniName("BuffCavalryTemplate") val buffCavalryTemplate: SageReference<Object>? = null,
    @SageIniName("BuffTrollTemplate") val buffTrollTemplate: SageReference<Object>? = null,
    @SageIniName("BuffMumakilTemplate") val buffMumakilTemplate: SageReference<Object>? = null,
    @SageIniName("BuffOrcTemplate") val buffOrcTemplate: SageReference<Object>? = null,
    @SageIniName("BuffMonsterTemplate") val buffMonsterTemplate: SageReference<Object>? = null,
    @SageIniName("BuffThingTemplate") val buffThingTemplate: SageReference<Object>? = null,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<BuffNugget>(
        name = "BuffNugget",
        properties = {
            property("BuffType", Untyped.type) { it.buffType }
            property("BuffName", Untyped.type) { it.buffName }
            property("BuffShipTemplate", Opaque.type) { it.buffShipTemplate }
            property("BuffLifeTime", IntValue) { it.buffLifeTime }
            property("IsComplexBuff", BooleanValue) { it.isComplexBuff }
            property("FXList", ReferenceValue<FXList> { listOf(FXList) }) { it.fXList }
            property("Color", Rgb.type) { it.color }
            property("Extrusion", FloatValue) { it.extrusion }
            property("BuffInfantryTemplate", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.buffInfantryTemplate }
            property("BuffCavalryTemplate", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.buffCavalryTemplate }
            property("BuffTrollTemplate", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.buffTrollTemplate }
            property("BuffMumakilTemplate", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.buffMumakilTemplate }
            property("BuffOrcTemplate", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.buffOrcTemplate }
            property("BuffMonsterTemplate", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.buffMonsterTemplate }
            property("BuffThingTemplate", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.buffThingTemplate }
        },
    )
}
