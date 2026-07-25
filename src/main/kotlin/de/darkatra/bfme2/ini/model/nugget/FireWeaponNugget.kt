package de.darkatra.bfme2.ini.model.nugget

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNugget
import de.darkatra.bfme2.ini.model.`object`.Weapon
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.SageReference

data class FireWeaponNugget(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("WeaponName") val weaponName: SageReference<Weapon>? = null,
    @SageIniName("Offset") val offset: Coords? = null,
    @SageIniName("FireDelay") val fireDelay: Int = 0,
    @SageIniName("OneShot") val oneShot: Boolean = false,
) : SageNugget {

    companion object : SageIniBlockDescriptor<FireWeaponNugget>(
        name = "FireWeaponNugget",
        properties = {
            property("WeaponName", ReferenceValue<Weapon> { listOf(Weapon) }) { it.weaponName }
            property("Offset", Coords.type) { it.offset }
            property("FireDelay", IntValue) { it.fireDelay }
            property("OneShot", BooleanValue) { it.oneShot }
        },
    )
}
