package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Untyped

data class WorldText(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("StringTag") val stringTag: Untyped? = null,
    @SageIniName("DelayFromActStart") val delayFromActStart: Double = 0.0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<WorldText>(
        name = "WorldText",
        properties = {
            property("StringTag", Untyped.type) { it.stringTag }
            property("DelayFromActStart", FloatValue) { it.delayFromActStart }
        },
    )
}
