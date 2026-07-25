package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class ModifierCategories(override val token: String) : SageIniEnum {
    LEADERSHIP("LEADERSHIP"),
    FORMATION("FORMATION"),
    SPELL("SPELL"),
    WEAPON("WEAPON"),
    STRUCTURE("STRUCTURE"),
    LEVEL("LEVEL"),
    BUFF("BUFF"),
    DEBUFF("DEBUFF"),
    STUN("STUN"),
    INNATE_ARMOR("INNATE_ARMOR"),
    INNATE_DAMAGEMULT("INNATE_DAMAGEMULT"),
    INNATE_VISION("INNATE_VISION"),
    INNATE_AUTOHEAL("INNATE_AUTOHEAL"),
    INNATE_HEALTH("INNATE_HEALTH");

    companion object {

        val type: EnumValue<ModifierCategories> = EnumValue("ModifierCategories", entries)
    }
}
