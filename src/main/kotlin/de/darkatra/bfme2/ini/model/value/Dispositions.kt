package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class Dispositions(override val token: String) : SageIniEnum {
    RANDOM_FORCE("RANDOM_FORCE"),
    LIKE_EXISTING("LIKE_EXISTING"),
    INHERIT_VELOCITY("INHERIT_VELOCITY"),
    ON_GROUND_ALIGNED("ON_GROUND_ALIGNED"),
    SEND_IT_FLYING("SEND_IT_FLYING"),
    SEND_IT_OUT("SEND_IT_OUT"),
    SEND_IT_UP("SEND_IT_UP"),
    FLOATING("FLOATING"),
    BUILDING_CHUNKS("BUILDING_CHUNKS"),
    FORWARD_IMPACT("FORWARD_IMPACT"),
    SPAWN_AROUND("SPAWN_AROUND"),
    SET_ANGLE("SET_ANGLE"),
    FADE_AND_DIE_ORNAMENT("FADE_AND_DIE_ORNAMENT"),
    ANIMATED("ANIMATED"),
    RELATIVE_ANGLE("RELATIVE_ANGLE"),
    USE_WATER_SURFACE("USE_WATER_SURFACE"),
    USE_CLIFF("USE_CLIFF"),
    ABSOLUTE_ANGLE("ABSOLUTE_ANGLE");

    companion object {

        val type: EnumValue<Dispositions> = EnumValue("Dispositions", entries)
    }
}
