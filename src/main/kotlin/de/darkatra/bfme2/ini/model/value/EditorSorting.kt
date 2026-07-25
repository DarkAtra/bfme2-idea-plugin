package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class EditorSorting(override val token: String) : SageIniEnum {
    STRUCTURE("STRUCTURE"),
    UNIT("UNIT"),
    MISC_MAN_MADE("MISC_MAN_MADE"),
    MISC_NATURAL("MISC_NATURAL"),
    SHRUBBERY("SHRUBBERY"),
    AUDIO("AUDIO"),
    DEBRIS("DEBRIS"),
    SYSTEM("SYSTEM"),
    OBSOLETE("OBSOLETE"),
    SELECTABLE("SELECTABLE"),
    EMITTERS("EMITTERS");

    companion object {

        val type: EnumValue<EditorSorting> = EnumValue("EditorSorting", entries)
    }
}
