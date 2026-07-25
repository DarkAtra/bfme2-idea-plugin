package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.value.SageReference

data class ArmyMemberDefinition(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Unit") val unit: SageReference<Object>? = null,
    @SageIniName("PercentageOfArmyPhase1") val percentageOfArmyPhase1: Double = 0.0,
    @SageIniName("PercentageOfArmyPhase2") val percentageOfArmyPhase2: Double = 0.0,
    @SageIniName("PercentageOfArmyPhase3") val percentageOfArmyPhase3: Double = 0.0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<ArmyMemberDefinition>(
        name = "ArmyMemberDefinition",
        properties = {
            property("Unit", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.unit }
            property("PercentageOfArmyPhase1", FloatValue) { it.percentageOfArmyPhase1 }
            property("PercentageOfArmyPhase2", FloatValue) { it.percentageOfArmyPhase2 }
            property("PercentageOfArmyPhase3", FloatValue) { it.percentageOfArmyPhase3 }
        },
    )
}
