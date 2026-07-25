package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.nugget.FireWeaponNugget
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class DamageFieldUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Radius") val radius: Int = 0,
    @SageIniName("ObjectFilter") val objectFilter: SageFilter? = null,
    @SageIniName("RequiredUpgrade") val requiredUpgrade: SageReference<Upgrade>? = null,
    @SageIniName("HeroModeTrigger") val heroModeTrigger: Boolean = false,
    @SageIniName("ChargingModeTrigger") val chargingModeTrigger: Boolean = false,
    @SageIniName("AliveOnly") val aliveOnly: Boolean = false,
    @SageIniName("FireWeaponNugget") val fireWeaponNugget: List<FireWeaponNugget> = emptyList(),
) : SageBehavior {

    companion object : SageIniBlockDescriptor<DamageFieldUpdate>(
        name = "DamageFieldUpdate",
        properties = {
            property("Radius", IntValue) { it.radius }
            property("ObjectFilter", SageFilter.type) { it.objectFilter }
            property("RequiredUpgrade", ReferenceValue<Upgrade> { listOf(Upgrade) }) { it.requiredUpgrade }
            property("HeroModeTrigger", BooleanValue) { it.heroModeTrigger }
            property("ChargingModeTrigger", BooleanValue) { it.chargingModeTrigger }
            property("AliveOnly", BooleanValue) { it.aliveOnly }
            property("FireWeaponNugget", ListValue(BlockValue<FireWeaponNugget> { listOf(FireWeaponNugget) })) { it.fireWeaponNugget }
        },
    )
}
