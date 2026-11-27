package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Untyped

data class ArmyEntry(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ThingTemplate") val thingTemplate: Untyped? = null,
    @SageIniName("Quantity") val quantity: Int = 0,
    @SageIniName("Default") val default: Boolean = false,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<ArmyEntry>(
        name = "ArmyEntry",
        properties = {
            property("ThingTemplate", Untyped.type) { it.thingTemplate }
            property("Quantity", IntValue) { it.quantity }
            property("Default", BooleanValue) { it.default }
        },
    )
}
