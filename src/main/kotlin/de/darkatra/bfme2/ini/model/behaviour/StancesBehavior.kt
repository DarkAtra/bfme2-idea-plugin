package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.StanceTemplate
import de.darkatra.bfme2.ini.model.value.SageReference

data class StancesBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("StanceTemplate") val stanceTemplate: SageReference<StanceTemplate>? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<StancesBehavior>(
        name = "StancesBehavior",
        properties = {
            property("StanceTemplate", ReferenceValue<StanceTemplate> { listOf(StanceTemplate) }) { it.stanceTemplate }
        },
    )
}
