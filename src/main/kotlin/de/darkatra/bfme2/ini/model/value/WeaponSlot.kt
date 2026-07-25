package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue
import de.darkatra.bfme2.ini.model.`object`.Weapon

data class WeaponSlot(val slot: SlotTypes? = null, val weapon: SageReference<Weapon>? = null) {

    companion object {

        val type: SageIniValueType<WeaponSlot> = StructValue("WeaponSlot") {
            component("Slot", SlotTypes.type) { it.slot }
            component("Weapon", ReferenceValue<Weapon> { listOf(Weapon) }) { it.weapon }
        }
    }
}
