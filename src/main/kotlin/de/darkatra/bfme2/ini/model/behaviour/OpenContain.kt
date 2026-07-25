package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.value.KindOf
import de.darkatra.bfme2.ini.model.value.SageReference

open class OpenContain(
    open val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("AllowInsideKindOf") open val allowInsideKindOf: List<KindOf> = emptyList(),
    @SageIniName("ForbidInsideKindOf") open val forbidInsideKindOf: List<KindOf> = emptyList(),
    @SageIniName("ContainMax") open val containMax: Int = 0,
    @SageIniName("EnterSound") open val enterSound: SageReference<AudioEvent>? = null,
    @SageIniName("ExitSound") open val exitSound: SageReference<AudioEvent>? = null,
    @SageIniName("DamagePercentToUnits") open val damagePercentToUnits: Double = 0.0,
    @SageIniName("PassengersInTurret") open val passengersInTurret: Boolean = false,
    @SageIniName("AllowAlliesInside") open val allowAlliesInside: Boolean = false,
    @SageIniName("AllowNeutralInside") open val allowNeutralInside: Boolean = false,
    @SageIniName("AllowEnemiesInside") open val allowEnemiesInside: Boolean = false,
    @SageIniName("ShouldDrawPips") open val shouldDrawPips: Boolean = false,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<OpenContain>(
        name = "OpenContain",
        properties = {
            property("AllowInsideKindOf", ListValue(KindOf.type)) { it.allowInsideKindOf }
            property("ForbidInsideKindOf", ListValue(KindOf.type)) { it.forbidInsideKindOf }
            property("ContainMax", IntValue) { it.containMax }
            property("EnterSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.enterSound }
            property("ExitSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.exitSound }
            property("DamagePercentToUnits", FloatValue) { it.damagePercentToUnits }
            property("PassengersInTurret", BooleanValue) { it.passengersInTurret }
            property("AllowAlliesInside", BooleanValue) { it.allowAlliesInside }
            property("AllowNeutralInside", BooleanValue) { it.allowNeutralInside }
            property("AllowEnemiesInside", BooleanValue) { it.allowEnemiesInside }
            property("ShouldDrawPips", BooleanValue) { it.shouldDrawPips }
        },
    )
}
