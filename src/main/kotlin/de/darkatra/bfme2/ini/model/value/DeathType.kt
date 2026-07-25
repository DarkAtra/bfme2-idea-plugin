package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class DeathType(override val token: String) : SageIniEnum {
    NORMAL("NORMAL"),
    NONE("NONE"),
    CRUSHED("CRUSHED"),
    BURNED("BURNED"),
    EXPLODED("EXPLODED"),
    POISONED("POISONED"),
    TOPPLED("TOPPLED"),
    FLOODED("FLOODED"),
    SUICIDED("SUICIDED"),
    LASERED("LASERED"),
    DETONATED("DETONATED"),
    SPLATTED("SPLATTED"),
    POISONED_BETA("POISONED_BETA"),
    EXTRA_2("EXTRA_2"),
    EXTRA_3("EXTRA_3"),
    EXTRA_4("EXTRA_4"),
    EXTRA_5("EXTRA_5"),
    EXTRA_6("EXTRA_6"),
    EXTRA_7("EXTRA_7"),
    EXTRA_8("EXTRA_8"),
    KNOCKBACK("KNOCKBACK"),
    SUPERNATURAL("SUPERNATURAL"),
    FADED("FADED"),
    SLAUGHTERED("SLAUGHTERED");

    companion object {

        val type: EnumValue<DeathType> = EnumValue("DeathType", entries)
    }
}
