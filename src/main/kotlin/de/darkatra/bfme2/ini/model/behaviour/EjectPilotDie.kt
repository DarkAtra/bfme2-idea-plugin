package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.ObjectCreationList
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class EjectPilotDie(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DeathType") override val deathType: SageFilter? = null,
    @SageIniName("DeathTypes") override val deathTypes: SageFilter? = null,
    @SageIniName("ExemptStatus") override val exemptStatus: ObjectStatus? = null,
    @SageIniName("RequiredStatus") override val requiredStatus: ObjectStatus? = null,
    @SageIniName("DamageAmountRequired") override val damageAmountRequired: Double = 0.0,
    @SageIniName("MinKillerAngle") override val minKillerAngle: Int = 0,
    @SageIniName("MaxKillerAngle") override val maxKillerAngle: Int = 0,
    @SageIniName("GroundCreationList") val groundCreationList: SageReference<ObjectCreationList>? = null,
    @SageIniName("AirCreationList") val airCreationList: SageReference<ObjectCreationList>? = null,
    @SageIniName("VeterancyLevels") val veterancyLevels: List<Untyped> = emptyList(),
) : DieBehavior() {

    companion object : SageIniBlockDescriptor<EjectPilotDie>(
        name = "EjectPilotDie",
        parent = DieBehavior,
        properties = {
            property("GroundCreationList", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.groundCreationList }
            property("AirCreationList", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.airCreationList }
            property("VeterancyLevels", ListValue(Untyped.type)) { it.veterancyLevels }
        },
    )
}
