package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class EmotionNuggetAIState(override val token: String) : SageIniEnum {
    BACK_AWAY("BACK_AWAY"),
    AVOID_SCARER("AVOID_SCARER"),
    IDLE("IDLE"),
    RUN_AWAY_PANIC("RUN_AWAY_PANIC"),
    FACE_OBJECT("FACE_OBJECT"),
    QUARREL("QUARREL");

    companion object {

        val type: EnumValue<EmotionNuggetAIState> = EnumValue("EmotionNuggetAIState", entries)
    }
}
