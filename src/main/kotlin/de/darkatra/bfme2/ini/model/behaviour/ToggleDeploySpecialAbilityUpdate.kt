package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.Multisound
import de.darkatra.bfme2.ini.model.`object`.SpecialPower
import de.darkatra.bfme2.ini.model.value.SageReference

data class ToggleDeploySpecialAbilityUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialPowerTemplate") val specialPowerTemplate: SageReference<SpecialPower>? = null,
    @SageIniName("IgnoreFacingCheck") val ignoreFacingCheck: Boolean = false,
    @SageIniName("SoundDeploy") val soundDeploy: SageReference<Multisound>? = null,
    @SageIniName("SoundUndeploy") val soundUndeploy: SageReference<Multisound>? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<ToggleDeploySpecialAbilityUpdate>(
        name = "ToggleDeploySpecialAbilityUpdate",
        properties = {
            property("SpecialPowerTemplate", ReferenceValue<SpecialPower> { listOf(SpecialPower) }) { it.specialPowerTemplate }
            property("IgnoreFacingCheck", BooleanValue) { it.ignoreFacingCheck }
            property("SoundDeploy", ReferenceValue<Multisound> { listOf(Multisound) }) { it.soundDeploy }
            property("SoundUndeploy", ReferenceValue<Multisound> { listOf(Multisound) }) { it.soundUndeploy }
        },
    )
}
