package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Untyped

data class MoveArmy(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ArmyScriptingName") val armyScriptingName: Untyped? = null,
    @SageIniName("TargetRegionName") val targetRegionName: Untyped? = null,
    @SageIniName("DefaultArmyMoveSpeed") val defaultArmyMoveSpeed: Double = 0.0,
    @SageIniName("DelayFromActStart") val delayFromActStart: Double = 0.0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<MoveArmy>(
        name = "MoveArmy",
        properties = {
            property("ArmyScriptingName", Untyped.type) { it.armyScriptingName }
            property("TargetRegionName", Untyped.type) { it.targetRegionName }
            property("DefaultArmyMoveSpeed", FloatValue) { it.defaultArmyMoveSpeed }
            property("DelayFromActStart", FloatValue) { it.delayFromActStart }
        },
    )
}
