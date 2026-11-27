package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.TemplateWithFilter

data class ProductionQueueHordeContain(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ObjectStatusOfContained") override val objectStatusOfContained: List<ObjectStatus> = emptyList(),
    @SageIniName("ContainMax") override val containMax: Int = 0,
    @SageIniName("DamagePercentToUnits") override val damagePercentToUnits: Double = 0.0,
    @SageIniName("PassengerFilter") override val passengerFilter: SageFilter? = null,
    @SageIniName("AllowEnemiesInside") override val allowEnemiesInside: Boolean = false,
    @SageIniName("AllowNeutralInside") override val allowNeutralInside: Boolean = false,
    @SageIniName("AllowAlliesInside") override val allowAlliesInside: Boolean = false,
    @SageIniName("NumberOfExitPaths") override val numberOfExitPaths: Int = 0,
    @SageIniName("PassengerBonePrefix") override val passengerBonePrefix: List<Map<String, String>> = emptyList(),
    @SageIniName("EntryPosition") override val entryPosition: Coords? = null,
    @SageIniName("EntryOffset") override val entryOffset: Coords? = null,
    @SageIniName("ExitOffset") override val exitOffset: Coords? = null,
    @SageIniName("EnterSound") override val enterSound: SageReference<AudioEvent>? = null,
    @SageIniName("DestinationTemplate") val destinationTemplate: TemplateWithFilter? = null,
) : HordeGarrisonContain() {

    companion object : SageIniBlockDescriptor<ProductionQueueHordeContain>(
        name = "ProductionQueueHordeContain",
        parent = HordeGarrisonContain,
        properties = {
            property("DestinationTemplate", TemplateWithFilter.type) { it.destinationTemplate }
        },
    )
}
