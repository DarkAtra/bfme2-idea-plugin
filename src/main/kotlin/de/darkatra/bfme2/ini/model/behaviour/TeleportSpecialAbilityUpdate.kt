package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.Weapon
import de.darkatra.bfme2.ini.model.value.SageReference

data class TeleportSpecialAbilityUpdate(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("BusyForDuration") val busyForDuration: Int = 0,
    @SageIniName("DestinationWeaponName") val destinationWeaponName: SageReference<Weapon>? = null,
    @SageIniName("SourceWeaponName") val sourceWeaponName: SageReference<Weapon>? = null,
    @SageIniName("MaxDistance") val maxDistance: Double = 0.0,
) : SpecialAbilityUpdate() {

    companion object : SageIniBlockDescriptor<TeleportSpecialAbilityUpdate>(
        name = "TeleportSpecialAbilityUpdate",
        parent = SpecialAbilityUpdate,
        properties = {
            property("BusyForDuration", IntValue) { it.busyForDuration }
            property("DestinationWeaponName", ReferenceValue<Weapon> { listOf(Weapon) }) { it.destinationWeaponName }
            property("SourceWeaponName", ReferenceValue<Weapon> { listOf(Weapon) }) { it.sourceWeaponName }
            property("MaxDistance", FloatValue) { it.maxDistance }
        },
    )
}
