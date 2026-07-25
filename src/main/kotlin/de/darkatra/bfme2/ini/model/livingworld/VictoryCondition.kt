package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Untyped

@SageIniName("_VictoryCondition")
open class VictoryCondition(
    open val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Teams") open val teams: Untyped? = null,
    @SageIniName("NumControlledRegionsGreaterOrEqualTo") open val numControlledRegionsGreaterOrEqualTo: Int = 0,
    @SageIniName("ControlledRegions") open val controlledRegions: List<Untyped> = emptyList(),
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<VictoryCondition>(
        name = "_VictoryCondition",
        properties = {
            property("Teams", Untyped.type) { it.teams }
            property("NumControlledRegionsGreaterOrEqualTo", IntValue) { it.numControlledRegionsGreaterOrEqualTo }
            property("ControlledRegions", ListValue(Untyped.type)) { it.controlledRegions }
        },
    )
}
