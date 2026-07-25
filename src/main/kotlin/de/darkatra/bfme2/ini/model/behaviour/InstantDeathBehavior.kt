package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.ObjectCreationList
import de.darkatra.bfme2.ini.model.`object`.Weapon
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class InstantDeathBehavior(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DeathType") override val deathType: SageFilter? = null,
    @SageIniName("DeathTypes") override val deathTypes: SageFilter? = null,
    @SageIniName("ExemptStatus") override val exemptStatus: ObjectStatus? = null,
    @SageIniName("RequiredStatus") override val requiredStatus: ObjectStatus? = null,
    @SageIniName("DamageAmountRequired") override val damageAmountRequired: Double = 0.0,
    @SageIniName("MinKillerAngle") override val minKillerAngle: Int = 0,
    @SageIniName("MaxKillerAngle") override val maxKillerAngle: Int = 0,
    @SageIniName("OCL") val oCL: SageReference<ObjectCreationList>? = null,
    @SageIniName("Weapon") val weapon: SageReference<Weapon>? = null,
    @SageIniName("FX") val fX: SageReference<FXList>? = null,
    @SageIniName("Sound") val sound: SageReference<AudioEvent>? = null,
) : DieBehavior() {

    companion object : SageIniBlockDescriptor<InstantDeathBehavior>(
        name = "InstantDeathBehavior",
        parent = DieBehavior,
        properties = {
            property("OCL", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.oCL }
            property("Weapon", ReferenceValue<Weapon> { listOf(Weapon) }) { it.weapon }
            property("FX", ReferenceValue<FXList> { listOf(FXList) }) { it.fX }
            property("Sound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.sound }
        },
    )
}
