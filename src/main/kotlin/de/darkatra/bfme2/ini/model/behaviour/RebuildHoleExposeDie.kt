package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class RebuildHoleExposeDie(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DeathType") override val deathType: SageFilter? = null,
    @SageIniName("DeathTypes") override val deathTypes: SageFilter? = null,
    @SageIniName("ExemptStatus") override val exemptStatus: ObjectStatus? = null,
    @SageIniName("RequiredStatus") override val requiredStatus: ObjectStatus? = null,
    @SageIniName("DamageAmountRequired") override val damageAmountRequired: Double = 0.0,
    @SageIniName("MinKillerAngle") override val minKillerAngle: Int = 0,
    @SageIniName("MaxKillerAngle") override val maxKillerAngle: Int = 0,
    @SageIniName("HoleName") val holeName: SageReference<Object>? = null,
    @SageIniName("HoleMaxHealth") val holeMaxHealth: Double = 0.0,
    @SageIniName("TransferAttackers") val transferAttackers: Boolean = false,
    @SageIniName("FadeInTimeSeconds") val fadeInTimeSeconds: Double = 0.0,
) : DieBehavior() {

    companion object : SageIniBlockDescriptor<RebuildHoleExposeDie>(
        name = "RebuildHoleExposeDie",
        parent = DieBehavior,
        properties = {
            property("HoleName", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.holeName }
            property("HoleMaxHealth", FloatValue) { it.holeMaxHealth }
            property("TransferAttackers", BooleanValue) { it.transferAttackers }
            property("FadeInTimeSeconds", FloatValue) { it.fadeInTimeSeconds }
        },
    )
}
