package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.SlotTypes

data class AssistedTargetingUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("AssistingClipSize") val assistingClipSize: Int = 0,
    @SageIniName("LaserFromAssisted") val laserFromAssisted: SageReference<Object>? = null,
    @SageIniName("LaserToTarget") val laserToTarget: SageReference<Object>? = null,
    @SageIniName("AssistingWeaponSlot") val assistingWeaponSlot: SlotTypes? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<AssistedTargetingUpdate>(
        name = "AssistedTargetingUpdate",
        properties = {
            property("AssistingClipSize", IntValue) { it.assistingClipSize }
            property("LaserFromAssisted", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.laserFromAssisted }
            property("LaserToTarget", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.laserToTarget }
            property("AssistingWeaponSlot", SlotTypes.type) { it.assistingWeaponSlot }
        },
    )
}
