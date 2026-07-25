package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.nugget.FireWeaponNugget
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.`object`.Weapon
import de.darkatra.bfme2.ini.model.value.SageReference

data class OilSpillUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("BreadcrumbName") val breadcrumbName: SageReference<Object>? = null,
    @SageIniName("IgnitionWeaponSpacing") val ignitionWeaponSpacing: Double = 0.0,
    @SageIniName("AliveOnly") val aliveOnly: Boolean = false,
    @SageIniName("OilSpillFX") val oilSpillFX: SageReference<FXList>? = null,
    @SageIniName("HeroModeTrigger") val heroModeTrigger: Boolean = false,
    @SageIniName("ChargingModeTrigger") val chargingModeTrigger: Boolean = false,
    @SageIniName("IgnitionWeaponName") val ignitionWeaponName: SageReference<Weapon>? = null,
    @SageIniName("FireWeaponNugget") val fireWeaponNugget: List<FireWeaponNugget> = emptyList(),
) : SageBehavior {

    companion object : SageIniBlockDescriptor<OilSpillUpdate>(
        name = "OilSpillUpdate",
        properties = {
            property("BreadcrumbName", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.breadcrumbName }
            property("IgnitionWeaponSpacing", FloatValue) { it.ignitionWeaponSpacing }
            property("AliveOnly", BooleanValue) { it.aliveOnly }
            property("OilSpillFX", ReferenceValue<FXList> { listOf(FXList) }) { it.oilSpillFX }
            property("HeroModeTrigger", BooleanValue) { it.heroModeTrigger }
            property("ChargingModeTrigger", BooleanValue) { it.chargingModeTrigger }
            property("IgnitionWeaponName", ReferenceValue<Weapon> { listOf(Weapon) }) { it.ignitionWeaponName }
            property("FireWeaponNugget", ListValue(BlockValue<FireWeaponNugget> { listOf(FireWeaponNugget) })) { it.fireWeaponNugget }
        },
    )
}
