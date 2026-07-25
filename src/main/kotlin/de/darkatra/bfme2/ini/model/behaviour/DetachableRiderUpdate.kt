package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.value.DeathEntry
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SlotTypes

data class DetachableRiderUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("RiderSubObjects") val riderSubObjects: List<Opaque> = emptyList(),
    @SageIniName("RiderlessWeaponSlot") val riderlessWeaponSlot: SlotTypes? = null,
    @SageIniName("RiderlessHordeFlees") val riderlessHordeFlees: Boolean = false,
    @SageIniName("DeathEntry") val deathEntry: DeathEntry? = null,
    @SageIniName("RemoveRiderlessFromHorde") val removeRiderlessFromHorde: Boolean = false,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<DetachableRiderUpdate>(
        name = "DetachableRiderUpdate",
        properties = {
            property("RiderSubObjects", ListValue(Opaque.type)) { it.riderSubObjects }
            property("RiderlessWeaponSlot", SlotTypes.type) { it.riderlessWeaponSlot }
            property("RiderlessHordeFlees", BooleanValue) { it.riderlessHordeFlees }
            property("DeathEntry", DeathEntry.type) { it.deathEntry }
            property("RemoveRiderlessFromHorde", BooleanValue) { it.removeRiderlessFromHorde }
        },
    )
}
