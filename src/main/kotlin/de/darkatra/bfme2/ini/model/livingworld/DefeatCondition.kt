package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.Untyped

@SageIniName("_DefeatCondition")
open class DefeatCondition(
    open val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Teams") open val teams: Untyped? = null,
    @SageIniName("LoseIfCapitalLost") open val loseIfCapitalLost: Boolean = false,
    @SageIniName("NumControlledRegionsLessOrEqualTo") open val numControlledRegionsLessOrEqualTo: Int = 0,
    @SageIniName("ControlledRegions") open val controlledRegions: Opaque? = null,
    @SageIniName("ControlledRegionsHeldForTurns") open val controlledRegionsHeldForTurns: Int = 0,
    @SageIniName("NumControlledRegionsGreaterOrEqualTo") open val numControlledRegionsGreaterOrEqualTo: Int = 0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<DefeatCondition>(
        name = "_DefeatCondition",
        properties = {
            property("Teams", Untyped.type) { it.teams }
            property("LoseIfCapitalLost", BooleanValue) { it.loseIfCapitalLost }
            property("NumControlledRegionsLessOrEqualTo", IntValue) { it.numControlledRegionsLessOrEqualTo }
            property("ControlledRegions", Opaque.type) { it.controlledRegions }
            property("ControlledRegionsHeldForTurns", IntValue) { it.controlledRegionsHeldForTurns }
            property("NumControlledRegionsGreaterOrEqualTo", IntValue) { it.numControlledRegionsGreaterOrEqualTo }
        },
    )
}
