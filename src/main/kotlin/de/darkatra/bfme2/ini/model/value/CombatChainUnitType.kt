package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class CombatChainUnitType(override val token: String) : SageIniEnum {
    INFANTRY("INFANTRY"),
    ARCHER("ARCHER"),
    CAVALRY("CAVALRY"),
    PIKEMAN("PIKEMAN"),
    SIEGEWEAPON("SIEGEWEAPON"),
    HERO("HERO"),
    CREEP("CREEP"),
    STRUCTURE("STRUCTURE"),
    WALL("WALL"),
    BATTLE_TOWER("BATTLE_TOWER"),
    SHIP_BATTLESHIP("SHIP_BATTLESHIP"),
    SHIP_BOMBARD("SHIP_BOMBARD"),
    SHIP_SUICIDE("SHIP_SUICIDE");

    companion object {

        val type: EnumValue<CombatChainUnitType> = EnumValue("CombatChainUnitType", entries)
    }
}
