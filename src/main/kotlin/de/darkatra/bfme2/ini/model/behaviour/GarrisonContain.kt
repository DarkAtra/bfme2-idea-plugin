package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.value.KindOf
import de.darkatra.bfme2.ini.model.value.ObjectCount
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

open class GarrisonContain(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("AllowInsideKindOf") override val allowInsideKindOf: List<KindOf> = emptyList(),
    @SageIniName("ForbidInsideKindOf") override val forbidInsideKindOf: List<KindOf> = emptyList(),
    @SageIniName("ContainMax") override val containMax: Int = 0,
    @SageIniName("EnterSound") override val enterSound: SageReference<AudioEvent>? = null,
    @SageIniName("ExitSound") override val exitSound: SageReference<AudioEvent>? = null,
    @SageIniName("DamagePercentToUnits") override val damagePercentToUnits: Double = 0.0,
    @SageIniName("PassengersInTurret") override val passengersInTurret: Boolean = false,
    @SageIniName("AllowAlliesInside") override val allowAlliesInside: Boolean = false,
    @SageIniName("AllowNeutralInside") override val allowNeutralInside: Boolean = false,
    @SageIniName("AllowEnemiesInside") override val allowEnemiesInside: Boolean = false,
    @SageIniName("ShouldDrawPips") override val shouldDrawPips: Boolean = false,
    @SageIniName("MobileGarrison") open val mobileGarrison: Boolean = false,
    @SageIniName("InitialRoster") open val initialRoster: ObjectCount? = null,
    @SageIniName("ImmuneToClearBuildingAttacks") open val immuneToClearBuildingAttacks: Boolean = false,
    @SageIniName("IsEnclosingContainer") open val isEnclosingContainer: Boolean = false,
    @SageIniName("ObjectStatusOfContained") open val objectStatusOfContained: List<ObjectStatus> = emptyList(),
    @SageIniName("PassengerFilter") open val passengerFilter: SageFilter? = null,
) : OpenContain() {

    companion object : SageIniBlockDescriptor<GarrisonContain>(
        name = "GarrisonContain",
        parent = OpenContain,
        properties = {
            property("MobileGarrison", BooleanValue) { it.mobileGarrison }
            property("InitialRoster", ObjectCount.type) { it.initialRoster }
            property("ImmuneToClearBuildingAttacks", BooleanValue) { it.immuneToClearBuildingAttacks }
            property("IsEnclosingContainer", BooleanValue) { it.isEnclosingContainer }
            property("ObjectStatusOfContained", ListValue(ObjectStatus.type)) { it.objectStatusOfContained }
            property("PassengerFilter", SageFilter.type) { it.passengerFilter }
        },
    )
}
