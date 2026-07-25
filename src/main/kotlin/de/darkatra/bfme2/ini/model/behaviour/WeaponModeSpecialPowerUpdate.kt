package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.ModifierList
import de.darkatra.bfme2.ini.model.`object`.SpecialPower
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.SlotTypes
import de.darkatra.bfme2.ini.model.value.WeaponSetConditions

data class WeaponModeSpecialPowerUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialPowerTemplate") val specialPowerTemplate: SageReference<SpecialPower>? = null,
    @SageIniName("StartsPaused") val startsPaused: Boolean = false,
    @SageIniName("Duration") val duration: Int = 0,
    @SageIniName("AttributeModifier") val attributeModifier: SageReference<ModifierList>? = null,
    @SageIniName("LockWeaponSlot") val lockWeaponSlot: SlotTypes? = null,
    @SageIniName("WeaponSetFlags") val weaponSetFlags: WeaponSetConditions? = null,
    @SageIniName("InitiateSound") val initiateSound: SageReference<AudioEvent>? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<WeaponModeSpecialPowerUpdate>(
        name = "WeaponModeSpecialPowerUpdate",
        properties = {
            property("SpecialPowerTemplate", ReferenceValue<SpecialPower> { listOf(SpecialPower) }) { it.specialPowerTemplate }
            property("StartsPaused", BooleanValue) { it.startsPaused }
            property("Duration", IntValue) { it.duration }
            property("AttributeModifier", ReferenceValue<ModifierList> { listOf(ModifierList) }) { it.attributeModifier }
            property("LockWeaponSlot", SlotTypes.type) { it.lockWeaponSlot }
            property("WeaponSetFlags", WeaponSetConditions.type) { it.weaponSetFlags }
            property("InitiateSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.initiateSound }
        },
    )
}
