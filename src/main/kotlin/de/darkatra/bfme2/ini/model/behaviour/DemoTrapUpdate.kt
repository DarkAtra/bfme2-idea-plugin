package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.Weapon
import de.darkatra.bfme2.ini.model.value.KindOf
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.SlotTypes

data class DemoTrapUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DefaultProximityMode") val defaultProximityMode: Boolean = false,
    @SageIniName("DetonationWeaponSlot") val detonationWeaponSlot: SlotTypes? = null,
    @SageIniName("ProximityModeWeaponSlot") val proximityModeWeaponSlot: SlotTypes? = null,
    @SageIniName("ManualModeWeaponSlot") val manualModeWeaponSlot: SlotTypes? = null,
    @SageIniName("TriggerDetonationRange") val triggerDetonationRange: Double = 0.0,
    @SageIniName("IgnoreTargetTypes") val ignoreTargetTypes: List<KindOf> = emptyList(),
    @SageIniName("AutoDetonationWithFriendsInvolved") val autoDetonationWithFriendsInvolved: Boolean = false,
    @SageIniName("DetonateWhenKilled") val detonateWhenKilled: Boolean = false,
    @SageIniName("ScanRate") val scanRate: Int = 0,
    @SageIniName("AutoDetonationWithFriendsInvolve") val autoDetonationWithFriendsInvolve: Boolean = false,
    @SageIniName("DetonationWeapon") val detonationWeapon: SageReference<Weapon>? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<DemoTrapUpdate>(
        name = "DemoTrapUpdate",
        properties = {
            property("DefaultProximityMode", BooleanValue) { it.defaultProximityMode }
            property("DetonationWeaponSlot", SlotTypes.type) { it.detonationWeaponSlot }
            property("ProximityModeWeaponSlot", SlotTypes.type) { it.proximityModeWeaponSlot }
            property("ManualModeWeaponSlot", SlotTypes.type) { it.manualModeWeaponSlot }
            property("TriggerDetonationRange", FloatValue) { it.triggerDetonationRange }
            property("IgnoreTargetTypes", ListValue(KindOf.type)) { it.ignoreTargetTypes }
            property("AutoDetonationWithFriendsInvolved", BooleanValue) { it.autoDetonationWithFriendsInvolved }
            property("DetonateWhenKilled", BooleanValue) { it.detonateWhenKilled }
            property("ScanRate", IntValue) { it.scanRate }
            property("AutoDetonationWithFriendsInvolve", BooleanValue) { it.autoDetonationWithFriendsInvolve }
            property("DetonationWeapon", ReferenceValue<Weapon> { listOf(Weapon) }) { it.detonationWeapon }
        },
    )
}
