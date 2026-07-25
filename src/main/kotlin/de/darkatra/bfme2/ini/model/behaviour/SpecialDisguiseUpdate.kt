package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.`object`.SpecialPower
import de.darkatra.bfme2.ini.model.value.SageReference

data class SpecialDisguiseUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialPowerTemplate") val specialPowerTemplate: SageReference<SpecialPower>? = null,
    @SageIniName("UnpackTime") val unpackTime: Int = 0,
    @SageIniName("PreparationTime") val preparationTime: Int = 0,
    @SageIniName("PersistentPrepTime") val persistentPrepTime: Int = 0,
    @SageIniName("PackTime") val packTime: Int = 0,
    @SageIniName("OpacityTarget") val opacityTarget: Double = 0.0,
    @SageIniName("AwardXPForTriggering") val awardXPForTriggering: Int = 0,
    @SageIniName("DisguiseAsTemplate") val disguiseAsTemplate: SageReference<Object>? = null,
    @SageIniName("DisguisedAsTemplate_EnemyPerspective") val disguisedAsTemplateEnemyPerspective: SageReference<Object>? = null,
    @SageIniName("DisguiseFX") val disguiseFX: SageReference<FXList>? = null,
    @SageIniName("ForceMountedWhenDisguising") val forceMountedWhenDisguising: Boolean = false,
    @SageIniName("TriggerInstantlyOnCreate") val triggerInstantlyOnCreate: Boolean = false,
    @SageIniName("DisguisedAsTemplate_EnemyPerspec") val disguisedAsTemplateEnemyPerspec: SageReference<Object>? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<SpecialDisguiseUpdate>(
        name = "SpecialDisguiseUpdate",
        properties = {
            property("SpecialPowerTemplate", ReferenceValue<SpecialPower> { listOf(SpecialPower) }) { it.specialPowerTemplate }
            property("UnpackTime", IntValue) { it.unpackTime }
            property("PreparationTime", IntValue) { it.preparationTime }
            property("PersistentPrepTime", IntValue) { it.persistentPrepTime }
            property("PackTime", IntValue) { it.packTime }
            property("OpacityTarget", FloatValue) { it.opacityTarget }
            property("AwardXPForTriggering", IntValue) { it.awardXPForTriggering }
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
