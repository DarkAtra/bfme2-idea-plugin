package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.value.SageReference

data class PlayerPosition(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Human") val human: Boolean = false,
    @SageIniName("Computer") val computer: Boolean = false,
    @SageIniName("LoadAIScripts") val loadAIScripts: Boolean = false,
    @SageIniName("ForcePlayerTeam") val forcePlayerTeam: Int = 0,
    @SageIniName("AllowedFactions") val allowedFactions: List<SageReference<PlayerTemplate>> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<PlayerPosition>(
        name = "PlayerPosition",
        properties = {
            property("Human", BooleanValue) { it.human }
            property("Computer", BooleanValue) { it.computer }
            property("LoadAIScripts", BooleanValue) { it.loadAIScripts }
            property("ForcePlayerTeam", IntValue) { it.forcePlayerTeam }
            property("AllowedFactions", ListValue(ReferenceValue<PlayerTemplate> { listOf(PlayerTemplate) })) { it.allowedFactions }
        },
    )
}
