package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.MapValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.`object`.SpecialPower
import de.darkatra.bfme2.ini.model.`object`.Weapon
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.SageReference

data class FlingPassengerSpecialAbilityUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialPowerTemplate") val specialPowerTemplate: SageReference<SpecialPower>? = null,
    @SageIniName("UnpackTime") val unpackTime: Int = 0,
    @SageIniName("FlingPassengerVelocity") val flingPassengerVelocity: Coords? = null,
    @SageIniName("FlingPassengerLandingWarhead") val flingPassengerLandingWarhead: SageReference<Weapon>? = null,
    @SageIniName("PackTime") val packTime: Int = 0,
    @SageIniName("CustomAnimAndDuration") val customAnimAndDuration: Map<String, String> = emptyMap(),
    @SageIniName("MustFinishAbility") val mustFinishAbility: Boolean = false,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<FlingPassengerSpecialAbilityUpdate>(
        name = "FlingPassengerSpecialAbilityUpdate",
        properties = {
            property("SpecialPowerTemplate", ReferenceValue<SpecialPower> { listOf(SpecialPower) }) { it.specialPowerTemplate }
            property("UnpackTime", IntValue) { it.unpackTime }
            property("FlingPassengerVelocity", Coords.type) { it.flingPassengerVelocity }
            property("FlingPassengerLandingWarhead", ReferenceValue<Weapon> { listOf(Weapon) }) { it.flingPassengerLandingWarhead }
            property("PackTime", IntValue) { it.packTime }
            property("CustomAnimAndDuration", MapValue(StringValue, StringValue)) { it.customAnimAndDuration }
            property("MustFinishAbility", BooleanValue) { it.mustFinishAbility }
        },
    )
}
