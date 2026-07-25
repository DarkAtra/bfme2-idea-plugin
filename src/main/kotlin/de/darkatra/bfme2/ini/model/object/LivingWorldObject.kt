package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.value.LivingWorldObjectType

data class LivingWorldObject(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ObjectType") val objectType: LivingWorldObjectType? = null,
    @SageIniName("DefaultFlashValue") val defaultFlashValue: Double = 0.0,
    @SageIniName("FlashVariation") val flashVariation: Double = 0.0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<LivingWorldObject>(
        name = "LivingWorldObject",
        tableKey = "livingworldobjects",
        properties = {
            property("ObjectType", LivingWorldObjectType.type) { it.objectType }
            property("DefaultFlashValue", FloatValue) { it.defaultFlashValue }
            property("FlashVariation", FloatValue) { it.flashVariation }
        },
    )
}
