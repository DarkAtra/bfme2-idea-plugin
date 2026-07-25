package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectCreationList
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class CreateObjectDieIfEldestKindof(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DeathType") override val deathType: SageFilter? = null,
    @SageIniName("DeathTypes") override val deathTypes: SageFilter? = null,
    @SageIniName("ExemptStatus") override val exemptStatus: ObjectStatus? = null,
    @SageIniName("RequiredStatus") override val requiredStatus: ObjectStatus? = null,
    @SageIniName("DamageAmountRequired") override val damageAmountRequired: Double = 0.0,
    @SageIniName("MinKillerAngle") override val minKillerAngle: Int = 0,
    @SageIniName("MaxKillerAngle") override val maxKillerAngle: Int = 0,
    @SageIniName("CreationList") override val creationList: SageReference<ObjectCreationList>? = null,
    @SageIniName("UpgradeRequired") override val upgradeRequired: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("DebrisPortionOfSelf") override val debrisPortionOfSelf: SageReference<Object>? = null,
    @SageIniName("TransferPreviousHealth") override val transferPreviousHealth: Boolean = false,
    @SageIniName("ObjectFilter") val objectFilter: SageFilter? = null,
) : CreateObjectDie() {

    companion object : SageIniBlockDescriptor<CreateObjectDieIfEldestKindof>(
        name = "CreateObjectDieIfEldestKindof",
        parent = CreateObjectDie,
        properties = {
            property("ObjectFilter", SageFilter.type) { it.objectFilter }
        },
    )
}
