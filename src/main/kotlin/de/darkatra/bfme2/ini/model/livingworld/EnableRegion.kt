package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Untyped

data class EnableRegion(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Region") val region: Untyped? = null,
    @SageIniName("ArmyScriptingName") val armyScriptingName: Untyped? = null,
    @SageIniName("DelayFromActStart") val delayFromActStart: Double = 0.0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<EnableRegion>(
        name = "EnableRegion",
        properties = {
            property("Region", Untyped.type) { it.region }
            property("ArmyScriptingName", Untyped.type) { it.armyScriptingName }
            property("DelayFromActStart", FloatValue) { it.delayFromActStart }
        },
    )
}
