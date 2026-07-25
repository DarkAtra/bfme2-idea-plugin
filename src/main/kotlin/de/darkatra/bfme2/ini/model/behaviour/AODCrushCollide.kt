package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.ObjectCreationList
import de.darkatra.bfme2.ini.model.value.DamageType
import de.darkatra.bfme2.ini.model.value.DeathType
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class AODCrushCollide(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SmallObjectCreationList") val smallObjectCreationList: SageReference<ObjectCreationList>? = null,
    @SageIniName("MediumObjectCreationList") val mediumObjectCreationList: SageReference<ObjectCreationList>? = null,
    @SageIniName("LargeObjectCreationList") val largeObjectCreationList: SageReference<ObjectCreationList>? = null,
    @SageIniName("Damage") val damage: Double = 0.0,
    @SageIniName("SpecialDamage") val specialDamage: Double = 0.0,
    @SageIniName("SpecialDamageType") val specialDamageType: DamageType? = null,
    @SageIniName("SpecialDeathType") val specialDeathType: DeathType? = null,
    @SageIniName("SelfDamage") val selfDamage: Double = 0.0,
    @SageIniName("SelfDamageType") val selfDamageType: DamageType? = null,
    @SageIniName("SelfDeathType") val selfDeathType: DeathType? = null,
    @SageIniName("SpecialObject") val specialObject: SageFilter? = null,
    @SageIniName("SmallFXList") val smallFXList: SageReference<FXList>? = null,
    @SageIniName("MediumFXList") val mediumFXList: SageReference<FXList>? = null,
    @SageIniName("LargeFXList") val largeFXList: SageReference<FXList>? = null,
    @SageIniName("DamageType") val damageType: DamageType? = null,
    @SageIniName("DeathType") val deathType: DeathType? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<AODCrushCollide>(
        name = "AODCrushCollide",
        properties = {
            property("SmallObjectCreationList", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.smallObjectCreationList }
            property("MediumObjectCreationList", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.mediumObjectCreationList }
            property("LargeObjectCreationList", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.largeObjectCreationList }
            property("Damage", FloatValue) { it.damage }
            property("SpecialDamage", FloatValue) { it.specialDamage }
            property("SpecialDamageType", DamageType.type) { it.specialDamageType }
            property("SpecialDeathType", DeathType.type) { it.specialDeathType }
            property("SelfDamage", FloatValue) { it.selfDamage }
            property("SelfDamageType", DamageType.type) { it.selfDamageType }
            property("SelfDeathType", DeathType.type) { it.selfDeathType }
            property("SpecialObject", SageFilter.type) { it.specialObject }
            property("SmallFXList", ReferenceValue<FXList> { listOf(FXList) }) { it.smallFXList }
            property("MediumFXList", ReferenceValue<FXList> { listOf(FXList) }) { it.mediumFXList }
            property("LargeFXList", ReferenceValue<FXList> { listOf(FXList) }) { it.largeFXList }
            property("DamageType", DamageType.type) { it.damageType }
            property("DeathType", DeathType.type) { it.deathType }
        },
    )
}
