package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.Untyped

data class TeamDefeatCondition(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Teams") override val teams: Untyped? = null,
    @SageIniName("LoseIfCapitalLost") override val loseIfCapitalLost: Boolean = false,
    @SageIniName("NumControlledRegionsLessOrEqualTo") override val numControlledRegionsLessOrEqualTo: Int = 0,
    @SageIniName("ControlledRegions") override val controlledRegions: Opaque? = null,
    @SageIniName("ControlledRegionsHeldForTurns") override val controlledRegionsHeldForTurns: Int = 0,
    @SageIniName("NumControlledRegionsGreaterOrEqualTo") override val numControlledRegionsGreaterOrEqualTo: Int = 0,
) : DefeatCondition() {

    companion object : SageIniBlockDescriptor<TeamDefeatCondition>(
        name = "TeamDefeatCondition",
        parent = DefeatCondition,
    )
}
