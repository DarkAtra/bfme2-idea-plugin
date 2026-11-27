package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.SpecialPower
import de.darkatra.bfme2.ini.model.`object`.Weapon
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.SageReference

data class FlingPassengerSpecialAbilityUpdate(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialPowerTemplate") override val specialPowerTemplate: SageReference<SpecialPower>? = null,
    @SageIniName("UnpackTime") override val unpackTime: Int = 0,
    @SageIniName("FlingPassengerVelocity") val flingPassengerVelocity: Coords? = null,
    @SageIniName("FlingPassengerLandingWarhead") val flingPassengerLandingWarhead: SageReference<Weapon>? = null,
    @SageIniName("PackTime") override val packTime: Int = 0,
    @SageIniName("CustomAnimAndDuration") override val customAnimAndDuration: Map<String, String> = emptyMap(),
    @SageIniName("MustFinishAbility") override val mustFinishAbility: Boolean = false,
) : SpecialAbilityUpdate() {

    companion object : SageIniBlockDescriptor<FlingPassengerSpecialAbilityUpdate>(
        name = "FlingPassengerSpecialAbilityUpdate",
        parent = SpecialAbilityUpdate,
        properties = {
            property("FlingPassengerVelocity", Coords.type) { it.flingPassengerVelocity }
            property("FlingPassengerLandingWarhead", ReferenceValue<Weapon> { listOf(Weapon) }) { it.flingPassengerLandingWarhead }
        },
    )
}
