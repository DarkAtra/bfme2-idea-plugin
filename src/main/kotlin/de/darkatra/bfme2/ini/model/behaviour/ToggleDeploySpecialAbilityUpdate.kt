package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.Multisound
import de.darkatra.bfme2.ini.model.`object`.SpecialPower
import de.darkatra.bfme2.ini.model.value.SageReference

data class ToggleDeploySpecialAbilityUpdate(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialPowerTemplate") override val specialPowerTemplate: SageReference<SpecialPower>? = null,
    @SageIniName("IgnoreFacingCheck") override val ignoreFacingCheck: Boolean = false,
    @SageIniName("SoundDeploy") val soundDeploy: SageReference<Multisound>? = null,
    @SageIniName("SoundUndeploy") val soundUndeploy: SageReference<Multisound>? = null,
) : SpecialAbilityUpdate() {

    companion object : SageIniBlockDescriptor<ToggleDeploySpecialAbilityUpdate>(
        name = "ToggleDeploySpecialAbilityUpdate",
        parent = SpecialAbilityUpdate,
        properties = {
            property("SoundDeploy", ReferenceValue<Multisound> { listOf(Multisound) }) { it.soundDeploy }
            property("SoundUndeploy", ReferenceValue<Multisound> { listOf(Multisound) }) { it.soundUndeploy }
        },
    )
}
