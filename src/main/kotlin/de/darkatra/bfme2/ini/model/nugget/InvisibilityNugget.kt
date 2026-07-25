package de.darkatra.bfme2.ini.model.nugget

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNugget
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.InvisibilityOptions
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped
import de.darkatra.bfme2.ini.model.value.WeaponSetConditions

data class InvisibilityNugget(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ForbiddenWeaponConditions") val forbiddenWeaponConditions: List<WeaponSetConditions> = emptyList(),
    @SageIniName("InvisibilityType") val invisibilityType: Untyped? = null,
    @SageIniName("ForbiddenConditions") val forbiddenConditions: Untyped? = null,
    @SageIniName("Options") val options: InvisibilityOptions? = null,
    @SageIniName("DetectionRange") val detectionRange: Double = 0.0,
    @SageIniName("IgnoreTreeCheckUpgrades") val ignoreTreeCheckUpgrades: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("BecomeStealthedFX") val becomeStealthedFX: SageReference<FXList>? = null,
    @SageIniName("ExitStealthFX") val exitStealthFX: SageReference<FXList>? = null,
    @SageIniName("HintDetectableConditions") val hintDetectableConditions: ObjectStatus? = null,
) : SageNugget {

    companion object : SageIniBlockDescriptor<InvisibilityNugget>(
        name = "InvisibilityNugget",
        properties = {
            property("ForbiddenWeaponConditions", ListValue(WeaponSetConditions.type)) { it.forbiddenWeaponConditions }
            property("InvisibilityType", Untyped.type) { it.invisibilityType }
            property("ForbiddenConditions", Untyped.type) { it.forbiddenConditions }
            property("Options", InvisibilityOptions.type) { it.options }
            property("DetectionRange", FloatValue) { it.detectionRange }
            property("IgnoreTreeCheckUpgrades", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.ignoreTreeCheckUpgrades }
            property("BecomeStealthedFX", ReferenceValue<FXList> { listOf(FXList) }) { it.becomeStealthedFX }
            property("ExitStealthFX", ReferenceValue<FXList> { listOf(FXList) }) { it.exitStealthFX }
            property("HintDetectableConditions", ObjectStatus.type) { it.hintDetectableConditions }
        },
    )
}
