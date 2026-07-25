package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Untyped

data class StartingRestriction(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Teams") val teams: Untyped? = null,
    @SageIniName("Regions") val regions: Untyped? = null,
    @SageIniName("Factions") val factions: Untyped? = null,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<StartingRestriction>(
        name = "StartingRestriction",
        properties = {
            property("Teams", Untyped.type) { it.teams }
            property("Regions", Untyped.type) { it.regions }
            property("Factions", Untyped.type) { it.factions }
        },
    )
}
