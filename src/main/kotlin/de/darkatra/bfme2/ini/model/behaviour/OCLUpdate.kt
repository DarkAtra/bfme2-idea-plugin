package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.ObjectCreationList
import de.darkatra.bfme2.ini.model.value.SageReference

data class OCLUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("OCL") val oCL: SageReference<ObjectCreationList>? = null,
    @SageIniName("MinDelay") val minDelay: Int = 0,
    @SageIniName("MaxDelay") val maxDelay: Int = 0,
    @SageIniName("CreateAtEdge") val createAtEdge: Boolean = false,
    @SageIniName("FactionTriggered") val factionTriggered: Boolean = false,
    @SageIniName("FactionOCL") val factionOCL: SageReference<ObjectCreationList>? = null,
    @SageIniName("Amount") val amount: Int = 0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<OCLUpdate>(
        name = "OCLUpdate",
        properties = {
            property("OCL", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.oCL }
            property("MinDelay", IntValue) { it.minDelay }
            property("MaxDelay", IntValue) { it.maxDelay }
            property("CreateAtEdge", BooleanValue) { it.createAtEdge }
            property("FactionTriggered", BooleanValue) { it.factionTriggered }
            property("FactionOCL", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.factionOCL }
            property("Amount", IntValue) { it.amount }
        },
    )
}
