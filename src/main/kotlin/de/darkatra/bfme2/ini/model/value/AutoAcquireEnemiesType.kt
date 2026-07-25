package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class AutoAcquireEnemiesType(override val token: String) : SageIniEnum {
    YES("YES"),
    NO("NO"),
    ATTACK_BUILDINGS("ATTACK_BUILDINGS"),
    NotWhileAttacking("NotWhileAttacking"),
    STEALTHED("STEALTHED");

    companion object {

        val type: EnumValue<AutoAcquireEnemiesType> = EnumValue("AutoAcquireEnemiesType", entries)
    }
}
