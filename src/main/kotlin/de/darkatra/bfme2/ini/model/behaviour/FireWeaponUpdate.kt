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
import de.darkatra.bfme2.ini.model.`object`.Weapon
import de.darkatra.bfme2.ini.model.value.SageReference

data class FireWeaponUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Weapon") val weapon: SageReference<Weapon>? = null,
    @SageIniName("ExclusiveWeaponDelay") val exclusiveWeaponDelay: Int = 0,
    @SageIniName("InitialDelay") val initialDelay: Int = 0,
    @SageIniName("ChargingModeTrigger") val chargingModeTrigger: Boolean = false,
    @SageIniName("AliveOnly") val aliveOnly: Boolean = false,
    @SageIniName("HeroModeTrigger") val heroModeTrigger: Boolean = false,
    @SageIniName("FireWeaponNugget") val fireWeaponNugget: List<FireWeaponNugget> = emptyList(),
) : SageBehavior {

    companion object : SageIniBlockDescriptor<FireWeaponUpdate>(
        name = "FireWeaponUpdate",
        properties = {
            property("Weapon", ReferenceValue<Weapon> { listOf(Weapon) }) { it.weapon }
            property("ExclusiveWeaponDelay", IntValue) { it.exclusiveWeaponDelay }
            property("InitialDelay", IntValue) { it.initialDelay }
            property("ChargingModeTrigger", BooleanValue) { it.chargingModeTrigger }
            property("AliveOnly", BooleanValue) { it.aliveOnly }
            property("HeroModeTrigger", BooleanValue) { it.heroModeTrigger }
            property("FireWeaponNugget", ListValue(BlockValue<FireWeaponNugget> { listOf(FireWeaponNugget) })) { it.fireWeaponNugget }
        },
    )
}
