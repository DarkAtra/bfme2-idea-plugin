package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.ObjectCreationList
import de.darkatra.bfme2.ini.model.value.SageReference

data class FireSpreadUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("OCLEmbers") val oCLEmbers: SageReference<ObjectCreationList>? = null,
    @SageIniName("MinSpreadDelay") val minSpreadDelay: Int = 0,
    @SageIniName("MaxSpreadDelay") val maxSpreadDelay: Int = 0,
    @SageIniName("SpreadTryRange") val spreadTryRange: Double = 0.0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<FireSpreadUpdate>(
        name = "FireSpreadUpdate",
        properties = {
            property("OCLEmbers", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.oCLEmbers }
            property("MinSpreadDelay", IntValue) { it.minSpreadDelay }
            property("MaxSpreadDelay", IntValue) { it.maxSpreadDelay }
            property("SpreadTryRange", FloatValue) { it.spreadTryRange }
        },
    )
}
