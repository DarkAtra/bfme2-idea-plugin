package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.Weapon
import de.darkatra.bfme2.ini.model.value.SageReference

data class StrafeAreaUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("WeaponName") val weaponName: SageReference<Weapon>? = null,
    @SageIniName("StrafeAreaRadius") val strafeAreaRadius: Double = 0.0,
    @SageIniName("Sweepfrequency") val sweepfrequency: Double = 0.0,
    @SageIniName("SweepAmplitude") val sweepAmplitude: Double = 0.0,
    @SageIniName("Slope") val slope: Double = 0.0,
    @SageIniName("InitialSweepPhase") val initialSweepPhase: Double = 0.0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<StrafeAreaUpdate>(
        name = "StrafeAreaUpdate",
        properties = {
            property("WeaponName", ReferenceValue<Weapon> { listOf(Weapon) }) { it.weaponName }
            property("StrafeAreaRadius", FloatValue) { it.strafeAreaRadius }
            property("Sweepfrequency", FloatValue) { it.sweepfrequency }
            property("SweepAmplitude", FloatValue) { it.sweepAmplitude }
            property("Slope", FloatValue) { it.slope }
            property("InitialSweepPhase", FloatValue) { it.initialSweepPhase }
        },
    )
}
