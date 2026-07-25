package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class ParticleSystemPriority(override val token: String) : SageIniEnum {
    NONE("NONE"),
    WEAPON_EXPLOSION("WEAPON_EXPLOSION"),
    WEAPON_EXPLSION("WEAPON_EXPLSION"),
    SCORCHMARK("SCORCHMARK"),
    DUST_TRAIL("DUST_TRAIL"),
    BUILDUP("BUILDUP"),
    DEBRIS_TRAIL("DEBRIS_TRAIL"),
    UNIT_DAMAGE_FX("UNIT_DAMAGE_FX"),
    DEATH_EXPLOSION("DEATH_EXPLOSION"),
    SEMI_CONSTANT("SEMI_CONSTANT"),
    CONSTANT("CONSTANT"),
    WEAPON_TRAIL("WEAPON_TRAIL"),
    AREA_EFFECT("AREA_EFFECT"),
    CRITICAL("CRITICAL"),
    ALWAYS_RENDER("ALWAYS_RENDER"),
    ULTRA_HIGH_ONLY("ULTRA_HIGH_ONLY"),
    HIGH_OR_ABOVE("HIGH_OR_ABOVE"),
    MEDIUM_OR_ABOVE("MEDIUM_OR_ABOVE"),
    LOW_OR_ABOVE("LOW_OR_ABOVE"),
    VERY_LOW_OR_ABOVE("VERY_LOW_OR_ABOVE");

    companion object {

        val type: EnumValue<ParticleSystemPriority> = EnumValue("ParticleSystemPriority", entries)
    }
}
