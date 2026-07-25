package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.value.ScienceRequirements

data class Science(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("PrerequisiteSciences") val prerequisiteSciences: ScienceRequirements? = null,
    @SageIniName("SciencePurchasePointCost") val sciencePurchasePointCost: Int = 0,
    @SageIniName("SciencePurchasePointCostMP") val sciencePurchasePointCostMP: Int = 0,
    @SageIniName("IsGrantable") val isGrantable: Boolean = false,
    @SageIniName("Description") val description: String = "",
    @SageIniName("DisplayName") val displayName: String = "",
) : SageIniObject, UpgradeTrigger {

    companion object : SageIniBlockDescriptor<Science>(
        name = "Science",
        tableKey = "sciences",
        properties = {
            property("PrerequisiteSciences", ScienceRequirements.type) { it.prerequisiteSciences }
            property("SciencePurchasePointCost", IntValue) { it.sciencePurchasePointCost }
            property("SciencePurchasePointCostMP", IntValue) { it.sciencePurchasePointCostMP }
            property("IsGrantable", BooleanValue) { it.isGrantable }
            property("Description", StringValue) { it.description }
            property("DisplayName", StringValue) { it.displayName }
        },
    )
}
