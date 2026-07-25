package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.Science
import de.darkatra.bfme2.ini.model.value.SageReference

data class SupplyCenterDockUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("GrantTemporaryStealth") val grantTemporaryStealth: Int = 0,
    @SageIniName("BonusScience") val bonusScience: SageReference<Science>? = null,
    @SageIniName("BonusScienceMultiplier") val bonusScienceMultiplier: Double = 0.0,
    @SageIniName("ValueMultiplier") val valueMultiplier: Double = 0.0,
    @SageIniName("NumberApproachPositions") val numberApproachPositions: Int = 0,
    @SageIniName("AllowsPassthrough") val allowsPassthrough: Boolean = false,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<SupplyCenterDockUpdate>(
        name = "SupplyCenterDockUpdate",
        properties = {
            property("GrantTemporaryStealth", IntValue) { it.grantTemporaryStealth }
            property("BonusScience", ReferenceValue<Science> { listOf(Science) }) { it.bonusScience }
            property("BonusScienceMultiplier", FloatValue) { it.bonusScienceMultiplier }
            property("ValueMultiplier", FloatValue) { it.valueMultiplier }
            property("NumberApproachPositions", IntValue) { it.numberApproachPositions }
            property("AllowsPassthrough", BooleanValue) { it.allowsPassthrough }
        },
    )
}
