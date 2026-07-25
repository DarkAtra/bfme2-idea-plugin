package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue

data class RespawnRule(val autoSpawn: Boolean = false, val cost: Int = 0, val time: Int = 0, val health: Double = 0.0) {

    companion object {

        val type: SageIniValueType<RespawnRule> = StructValue("RespawnRule") {
            component("AutoSpawn", BooleanValue) { it.autoSpawn }
            component("Cost", IntValue) { it.cost }
            component("Time", IntValue) { it.time }
            component("Health", FloatValue) { it.health }
        }
    }
}
