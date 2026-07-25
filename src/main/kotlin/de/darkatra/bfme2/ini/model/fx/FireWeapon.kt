package de.darkatra.bfme2.ini.model.fx

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.`object`.Weapon
import de.darkatra.bfme2.ini.model.value.SageReference

data class FireWeapon(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Weapon") val weapon: SageReference<Weapon>? = null,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<FireWeapon>(
        name = "FireWeapon",
        properties = {
            property("Weapon", ReferenceValue<Weapon> { listOf(Weapon) }) { it.weapon }
        },
    )
}
