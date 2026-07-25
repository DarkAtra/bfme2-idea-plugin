package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class DamageType(override val token: String) : SageIniEnum {
    FORCE("FORCE"),
    CRUSH("CRUSH"),
    SLASH("SLASH"),
    PIERCE("PIERCE"),
    SIEGE("SIEGE"),
    STRUCTURAL("STRUCTURAL"),
    FLAME("FLAME"),
    HEALING("HEALING"),
    UNRESISTABLE("UNRESISTABLE"),
    WATER("WATER"),
    PENALTY("PENALTY"),
    FALLING("FALLING"),
    TOPPLING("TOPPLING"),
    REFLECTED("REFLECTED"),
    PASSENGER("PASSENGER"),
    MAGIC("MAGIC"),
    CHOP("CHOP"),
    HERO("HERO"),
    SPECIALIST("SPECIALIST"),
    URUK("URUK"),
    HERO_RANGED("HERO_RANGED"),
    FLY_INTO("FLY_INTO"),
    UNDEFINED("UNDEFINED"),
    LOGICAL_FIRE("LOGICAL_FIRE"),
    CAVALRY("CAVALRY"),
    CAVALRY_RANGED("CAVALRY_RANGED"),
    POISON("POISON"),
    FROST("FROST"),
    GOOD_ARROW_PIERCE("GOOD_ARROW_PIERCE"),
    EVIL_ARROW_PIERCE("EVIL_ARROW_PIERCE"),
    SWORD_SLASH("SWORD_SLASH"),
    WITCH_KING_MORGUL_BLADE("WITCH_KING_MORGUL_BLADE"),
    BALROG_SWORD("BALROG_SWORD"),
    BALROG_WHIP("BALROG_WHIP"),
    ELECTRIC("ELECTRIC"),
    GIMLI_LEAP("GIMLI_LEAP"),
    BIG_ROCK("BIG_ROCK"),
    CLUBBING("CLUBBING"),
    BECOME_UNDEAD("BECOME_UNDEAD"),
    BOLT("BOLT"),
    TORNADO("TORNADO"),
    FLOOD_HORSE("FLOOD_HORSE"),
    FIRE3("FIRE3"),
    BECOME_UNDEAD_ONCE("BECOME_UNDEAD_ONCE"),
    NECRO1("NECRO1"),
    NECRO2("NECRO2"),
    FIRE("FIRE");

    companion object {

        val type: EnumValue<DamageType> = EnumValue("DamageType", entries)
    }
}
