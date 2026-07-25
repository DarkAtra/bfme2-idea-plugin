package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class DamageFXType(override val token: String) : SageIniEnum {
    MAGIC("MAGIC"),
    SWORD_SLASH("SWORD_SLASH"),
    EVIL_ARROW_PIERCE("EVIL_ARROW_PIERCE"),
    CLUBBING("CLUBBING"),
    SMALL_ROCK("SMALL_ROCK"),
    BIG_ROCK("BIG_ROCK"),
    FLAME("FLAME"),
    ELECTRIC("ELECTRIC"),
    BALROG_SWORD("BALROG_SWORD"),
    GOOD_ARROW_PIERCE("GOOD_ARROW_PIERCE"),
    REFLECTED("REFLECTED"),
    GIMLI_LEAP("GIMLI_LEAP"),
    WITCH_KING_MORGUL_BLADE("WITCH_KING_MORGUL_BLADE"),
    STRUCTURAL("STRUCTURAL"),
    BALROG_WHIP("BALROG_WHIP"),
    POISON("POISON"),
    BOLT("BOLT"),
    TORNADO("TORNADO"),
    FIRE1("FIRE1"),
    FIRE2("FIRE2"),
    FIRE3("FIRE3"),
    FLOOD_HORSE("FLOOD_HORSE"),
    UNDEFINED("UNDEFINED"),
    NECRO1("NECRO1"),
    NECRO2("NECRO2");

    companion object {

        val type: EnumValue<DamageFXType> = EnumValue("DamageFXType", entries)
    }
}
