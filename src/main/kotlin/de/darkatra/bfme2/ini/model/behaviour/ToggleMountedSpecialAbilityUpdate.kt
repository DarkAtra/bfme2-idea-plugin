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
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.`object`.SpecialPower
import de.darkatra.bfme2.ini.model.value.SageReference

data class ToggleMountedSpecialAbilityUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialPowerTemplate") val specialPowerTemplate: SageReference<SpecialPower>? = null,
    @SageIniName("UnpackTime") val unpackTime: Int = 0,
    @SageIniName("PreparationTime") val preparationTime: Int = 0,
    @SageIniName("PersistentPrepTime") val persistentPrepTime: Int = 0,
    @SageIniName("PackTime") val packTime: Int = 0,
    @SageIniName("AwardXPForTriggering") val awardXPForTriggering: Int = 0,
    @SageIniName("OpacityTarget") val opacityTarget: Double = 0.0,
    @SageIniName("TriggerInstantlyOnCreate") val triggerInstantlyOnCreate: Boolean = false,
    @SageIniName("CancelDisguiseWhenDismounting") val cancelDisguiseWhenDismounting: Boolean = false,
    @SageIniName("StartAbilityRange") val startAbilityRange: Double = 0.0,
    @SageIniName("MountedTemplate") val mountedTemplate: SageReference<Object>? = null,
    @SageIniName("SynchronizeTimerOnSpecialPower") val synchronizeTimerOnSpecialPower: List<SageReference<SpecialPower>> = emptyList(),
    @SageIniName("IgnoreFacingCheck") val ignoreFacingCheck: Boolean = false,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<ToggleMountedSpecialAbilityUpdate>(
        name = "ToggleMountedSpecialAbilityUpdate",
        properties = {
            property("SpecialPowerTemplate", ReferenceValue<SpecialPower> { listOf(SpecialPower) }) { it.specialPowerTemplate }
            property("UnpackTime", IntValue) { it.unpackTime }
            property("PreparationTime", IntValue) { it.preparationTime }
            property("PersistentPrepTime", IntValue) { it.persistentPrepTime }
            property("PackTime", IntValue) { it.packTime }
            property("AwardXPForTriggering", IntValue) { it.awardXPForTriggering }
            property("OpacityTarget", FloatValue) { it.opacityTarget }
            property("TriggerInstantlyOnCreate", BooleanValue) { it.triggerInstantlyOnCreate }
            property("CancelDisguiseWhenDismounting", BooleanValue) { it.cancelDisguiseWhenDismounting }
            property("StartAbilityRange", FloatValue) { it.startAbilityRange }
            property("MountedTemplate", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.mountedTemplate }
            property("SynchronizeTimerOnSpecialPower", ListValue(ReferenceValue<SpecialPower> { listOf(SpecialPower) })) { it.synchronizeTimerOnSpecialPower }
            property("IgnoreFacingCheck", BooleanValue) { it.ignoreFacingCheck }
        },
    )
}
