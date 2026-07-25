package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class DeathFlags(override val token: String) : SageIniEnum {
    DEATH_1("DEATH_1"),
    DEATH_2("DEATH_2"),
    DEATH_3("DEATH_3"),
    DEATH_4("DEATH_4"),
    DEATH_5("DEATH_5");

    companion object {

        val type: EnumValue<DeathFlags> = EnumValue("DeathFlags", entries)
    }
}
