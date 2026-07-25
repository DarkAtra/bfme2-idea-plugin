package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class UpgradeTypes(override val token: String) : SageIniEnum {
    OBJECT("OBJECT"),
    PLAYER("PLAYER");

    companion object {

        val type: EnumValue<UpgradeTypes> = EnumValue("UpgradeTypes", entries)
    }
}
