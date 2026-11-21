package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.`object`.SpecialPower
import de.darkatra.bfme2.ini.model.value.SageReference

data class ToggleMountedSpecialAbilityUpdate(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("OpacityTarget") val opacityTarget: Double = 0.0,
    @SageIniName("TriggerInstantlyOnCreate") val triggerInstantlyOnCreate: Boolean = false,
    @SageIniName("CancelDisguiseWhenDismounting") val cancelDisguiseWhenDismounting: Boolean = false,
    @SageIniName("MountedTemplate") val mountedTemplate: SageReference<Object>? = null,
    @SageIniName("SynchronizeTimerOnSpecialPower") val synchronizeTimerOnSpecialPower: List<SageReference<SpecialPower>> = emptyList(),
) : SpecialAbilityUpdate() {

    companion object : SageIniBlockDescriptor<ToggleMountedSpecialAbilityUpdate>(
        name = "ToggleMountedSpecialAbilityUpdate",
        parent = SpecialAbilityUpdate,
        properties = {
            property("OpacityTarget", FloatValue) { it.opacityTarget }
            property("TriggerInstantlyOnCreate", BooleanValue) { it.triggerInstantlyOnCreate }
            property("CancelDisguiseWhenDismounting", BooleanValue) { it.cancelDisguiseWhenDismounting }
            property("MountedTemplate", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.mountedTemplate }
            property("SynchronizeTimerOnSpecialPower", ListValue(ReferenceValue<SpecialPower> { listOf(SpecialPower) })) { it.synchronizeTimerOnSpecialPower }
        },
    )
}
