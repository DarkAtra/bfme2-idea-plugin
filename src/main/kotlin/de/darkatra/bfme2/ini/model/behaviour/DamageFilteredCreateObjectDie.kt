package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.`object`.ObjectCreationList
import de.darkatra.bfme2.ini.model.value.DamageType
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class DamageFilteredCreateObjectDie(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DeathType") override val deathType: SageFilter? = null,
    @SageIniName("DeathTypes") override val deathTypes: SageFilter? = null,
    @SageIniName("ExemptStatus") override val exemptStatus: ObjectStatus? = null,
    @SageIniName("RequiredStatus") override val requiredStatus: ObjectStatus? = null,
    @SageIniName("DamageAmountRequired") override val damageAmountRequired: Double = 0.0,
    @SageIniName("MinKillerAngle") override val minKillerAngle: Int = 0,
    @SageIniName("MaxKillerAngle") override val maxKillerAngle: Int = 0,
    @SageIniName("CreationList") override val creationList: SageReference<ObjectCreationList>? = null,
    @SageIniName("DamageTypeTriggersInstantly") val damageTypeTriggersInstantly: DamageType? = null,
    @SageIniName("DamageTypeTriggersForDuration") val damageTypeTriggersForDuration: DamageType? = null,
    @SageIniName("PostFilterTriggeredDuration") val postFilterTriggeredDuration: Int = 0,
) : CreateObjectDieBehavior() {

    companion object : SageIniBlockDescriptor<DamageFilteredCreateObjectDie>(
        name = "DamageFilteredCreateObjectDie",
        parent = CreateObjectDieBehavior,
        properties = {
            property("DamageTypeTriggersInstantly", DamageType.type) { it.damageTypeTriggersInstantly }
            property("DamageTypeTriggersForDuration", DamageType.type) { it.damageTypeTriggersForDuration }
            property("PostFilterTriggeredDuration", IntValue) { it.postFilterTriggeredDuration }
        },
    )
}
