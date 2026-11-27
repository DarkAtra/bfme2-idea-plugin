package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.ui.DeliveryDecal
import de.darkatra.bfme2.ini.model.value.SlotTypes

data class Attack(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("NumberOfShots") val numberOfShots: Int = 0,
    @SageIniName("WeaponSlot") val weaponSlot: SlotTypes? = null,
    @SageIniName("DeliveryDecal") val deliveryDecal: DeliveryDecal? = null,
    @SageIniName("DeliveryDecalRadius") val deliveryDecalRadius: Double = 0.0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<Attack>(
        name = "Attack",
        properties = {
            property("NumberOfShots", IntValue) { it.numberOfShots }
            property("WeaponSlot", SlotTypes.type) { it.weaponSlot }
            property("DeliveryDecal", BlockValue<DeliveryDecal> { listOf(DeliveryDecal) }) { it.deliveryDecal }
            property("DeliveryDecalRadius", FloatValue) { it.deliveryDecalRadius }
        },
    )
}
