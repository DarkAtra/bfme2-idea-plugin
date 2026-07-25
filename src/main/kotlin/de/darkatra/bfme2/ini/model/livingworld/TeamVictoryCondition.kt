package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.value.Untyped

data class TeamVictoryCondition(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Teams") override val teams: Untyped? = null,
    @SageIniName("NumControlledRegionsGreaterOrEqualTo") override val numControlledRegionsGreaterOrEqualTo: Int = 0,
    @SageIniName("ControlledRegions") override val controlledRegions: List<Untyped> = emptyList(),
) : VictoryCondition() {

    companion object : SageIniBlockDescriptor<TeamVictoryCondition>(
        name = "TeamVictoryCondition",
        parent = VictoryCondition,
    )
}
