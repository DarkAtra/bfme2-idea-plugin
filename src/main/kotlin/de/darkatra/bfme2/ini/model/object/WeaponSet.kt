package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.value.Untyped
import de.darkatra.bfme2.ini.model.value.WeaponSetConditions
import de.darkatra.bfme2.ini.model.value.WeaponSlot

data class WeaponSet(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Conditions") val conditions: List<WeaponSetConditions> = emptyList(),
    @SageIniName("Weapon") val weapon: List<WeaponSlot> = emptyList(),
    @SageIniName("ReadyStatusSharedWithinSet") val readyStatusSharedWithinSet: Boolean = false,
    @SageIniName("ShareWeaponReloadTime") val shareWeaponReloadTime: Boolean = false,
    @SageIniName("DefaultWeaponChoiceCritera") val defaultWeaponChoiceCritera: Untyped? = null,
    @SageIniName("AutoChooseSources") val autoChooseSources: List<Untyped> = emptyList(),
    @SageIniName("OnlyAgainst") val onlyAgainst: List<Untyped> = emptyList(),
    @SageIniName("PreferredAgainst") val preferredAgainst: List<Untyped> = emptyList(),
    @SageIniName("OnlyInCondition") val onlyInCondition: List<Untyped> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<WeaponSet>(
        name = "WeaponSet",
        properties = {
            property("Conditions", ListValue(WeaponSetConditions.type)) { it.conditions }
            property("Weapon", ListValue(WeaponSlot.type)) { it.weapon }
            property("ReadyStatusSharedWithinSet", BooleanValue) { it.readyStatusSharedWithinSet }
            property("ShareWeaponReloadTime", BooleanValue) { it.shareWeaponReloadTime }
            property("DefaultWeaponChoiceCritera", Untyped.type) { it.defaultWeaponChoiceCritera }
            property("AutoChooseSources", ListValue(Untyped.type)) { it.autoChooseSources }
            property("OnlyAgainst", ListValue(Untyped.type)) { it.onlyAgainst }
            property("PreferredAgainst", ListValue(Untyped.type)) { it.preferredAgainst }
            property("OnlyInCondition", ListValue(Untyped.type)) { it.onlyInCondition }
        },
    )
}
