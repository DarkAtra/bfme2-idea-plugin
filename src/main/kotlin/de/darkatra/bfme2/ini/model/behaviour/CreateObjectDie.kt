package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectCreationList
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

open class CreateObjectDie(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DeathType") override val deathType: SageFilter? = null,
    @SageIniName("DeathTypes") override val deathTypes: SageFilter? = null,
    @SageIniName("ExemptStatus") override val exemptStatus: ObjectStatus? = null,
    @SageIniName("RequiredStatus") override val requiredStatus: ObjectStatus? = null,
    @SageIniName("DamageAmountRequired") override val damageAmountRequired: Double = 0.0,
    @SageIniName("MinKillerAngle") override val minKillerAngle: Int = 0,
    @SageIniName("MaxKillerAngle") override val maxKillerAngle: Int = 0,
    @SageIniName("CreationList") override val creationList: SageReference<ObjectCreationList>? = null,
    @SageIniName("UpgradeRequired") open val upgradeRequired: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("DebrisPortionOfSelf") open val debrisPortionOfSelf: SageReference<Object>? = null,
    @SageIniName("TransferPreviousHealth") open val transferPreviousHealth: Boolean = false,
) : CreateObjectDieBehavior() {

    companion object : SageIniBlockDescriptor<CreateObjectDie>(
        name = "CreateObjectDie",
        parent = CreateObjectDieBehavior,
        properties = {
            property("UpgradeRequired", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.upgradeRequired }
            property("DebrisPortionOfSelf", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.debrisPortionOfSelf }
            property("TransferPreviousHealth", BooleanValue) { it.transferPreviousHealth }
        },
    )
}
