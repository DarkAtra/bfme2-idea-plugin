package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class GeometryType(override val token: String) : SageIniEnum {
    SPHERE("SPHERE"),
    CYLINDER("CYLINDER"),
    BOX("BOX");

    companion object {

        val type: EnumValue<GeometryType> = EnumValue("GeometryType", entries)
    }
}
