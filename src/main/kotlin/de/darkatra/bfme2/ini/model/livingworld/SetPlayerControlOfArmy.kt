package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Untyped

data class SetPlayerControlOfArmy(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ArmyScriptingName") val armyScriptingName: Untyped? = null,
    @SageIniName("IsControllableByOwner") val isControllableByOwner: Boolean = false,
    @SageIniName("DelayFromActStart") val delayFromActStart: Double = 0.0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<SetPlayerControlOfArmy>(
        name = "SetPlayerControlOfArmy",
        properties = {
            property("ArmyScriptingName", Untyped.type) { it.armyScriptingName }
            property("IsControllableByOwner", BooleanValue) { it.isControllableByOwner }
            property("DelayFromActStart", FloatValue) { it.delayFromActStart }
        },
    )
}
