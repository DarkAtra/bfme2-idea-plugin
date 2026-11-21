package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.value.SageReference

data class SpecialDisguiseUpdate(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("OpacityTarget") val opacityTarget: Double = 0.0,
    @SageIniName("DisguiseAsTemplate") val disguiseAsTemplate: SageReference<Object>? = null,
    @SageIniName("DisguisedAsTemplate_EnemyPerspective") val disguisedAsTemplateEnemyPerspective: SageReference<Object>? = null,
    @SageIniName("DisguiseFX") val disguiseFX: SageReference<FXList>? = null,
    @SageIniName("ForceMountedWhenDisguising") val forceMountedWhenDisguising: Boolean = false,
    @SageIniName("TriggerInstantlyOnCreate") val triggerInstantlyOnCreate: Boolean = false,
    @SageIniName("DisguisedAsTemplate_EnemyPerspec") val disguisedAsTemplateEnemyPerspec: SageReference<Object>? = null,
) : SpecialAbilityUpdate() {

    companion object : SageIniBlockDescriptor<SpecialDisguiseUpdate>(
        name = "SpecialDisguiseUpdate",
        parent = SpecialAbilityUpdate,
        properties = {
            property("OpacityTarget", FloatValue) { it.opacityTarget }
            property("DisguiseAsTemplate", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.disguiseAsTemplate }
            property(
                "DisguisedAsTemplate_EnemyPerspective",
                ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.disguisedAsTemplateEnemyPerspective }
            property("DisguiseFX", ReferenceValue<FXList> { listOf(FXList) }) { it.disguiseFX }
            property("ForceMountedWhenDisguising", BooleanValue) { it.forceMountedWhenDisguising }
            property("TriggerInstantlyOnCreate", BooleanValue) { it.triggerInstantlyOnCreate }
            property(
                "DisguisedAsTemplate_EnemyPerspec",
                ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.disguisedAsTemplateEnemyPerspec }
        },
    )
}
