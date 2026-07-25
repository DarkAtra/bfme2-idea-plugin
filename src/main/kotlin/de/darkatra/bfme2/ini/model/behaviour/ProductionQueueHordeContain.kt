package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.MapValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.TemplateWithFilter

data class ProductionQueueHordeContain(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ObjectStatusOfContained") val objectStatusOfContained: List<ObjectStatus> = emptyList(),
    @SageIniName("ContainMax") val containMax: Int = 0,
    @SageIniName("DamagePercentToUnits") val damagePercentToUnits: Double = 0.0,
    @SageIniName("PassengerFilter") val passengerFilter: SageFilter? = null,
    @SageIniName("AllowEnemiesInside") val allowEnemiesInside: Boolean = false,
    @SageIniName("AllowNeutralInside") val allowNeutralInside: Boolean = false,
    @SageIniName("AllowAlliesInside") val allowAlliesInside: Boolean = false,
    @SageIniName("NumberOfExitPaths") val numberOfExitPaths: Int = 0,
    @SageIniName("PassengerBonePrefix") val passengerBonePrefix: List<Map<String, String>> = emptyList(),
    @SageIniName("EntryPosition") val entryPosition: Coords? = null,
    @SageIniName("EntryOffset") val entryOffset: Coords? = null,
    @SageIniName("ExitOffset") val exitOffset: Coords? = null,
    @SageIniName("EnterSound") val enterSound: SageReference<AudioEvent>? = null,
    @SageIniName("DestinationTemplate") val destinationTemplate: TemplateWithFilter? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<ProductionQueueHordeContain>(
        name = "ProductionQueueHordeContain",
        properties = {
            property("ObjectStatusOfContained", ListValue(ObjectStatus.type)) { it.objectStatusOfContained }
            property("ContainMax", IntValue) { it.containMax }
            property("DamagePercentToUnits", FloatValue) { it.damagePercentToUnits }
            property("PassengerFilter", SageFilter.type) { it.passengerFilter }
            property("AllowEnemiesInside", BooleanValue) { it.allowEnemiesInside }
            property("AllowNeutralInside", BooleanValue) { it.allowNeutralInside }
            property("AllowAlliesInside", BooleanValue) { it.allowAlliesInside }
            property("NumberOfExitPaths", IntValue) { it.numberOfExitPaths }
            property("PassengerBonePrefix", ListValue(MapValue(StringValue, StringValue))) { it.passengerBonePrefix }
            property("EntryPosition", Coords.type) { it.entryPosition }
            property("EntryOffset", Coords.type) { it.entryOffset }
            property("ExitOffset", Coords.type) { it.exitOffset }
            property("EnterSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.enterSound }
            property("DestinationTemplate", TemplateWithFilter.type) { it.destinationTemplate }
        },
    )
}
