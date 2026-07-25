package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class AutoDepositUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DepositTiming") val depositTiming: Int = 0,
    @SageIniName("DepositAmount") val depositAmount: Int = 0,
    @SageIniName("InitialCaptureBonus") val initialCaptureBonus: Int = 0,
    @SageIniName("ActualMoney") val actualMoney: Boolean = false,
    @SageIniName("UpgradedBoost") val upgradedBoost: Opaque? = null,
    @SageIniName("Upgrade") val upgrade: SageReference<Upgrade>? = null,
    @SageIniName("UpgradeBonusPercent") val upgradeBonusPercent: Double = 0.0,
    @SageIniName("UpgradeMustBePresent") val upgradeMustBePresent: SageFilter? = null,
    @SageIniName("GiveNoXP") val giveNoXP: Boolean = false,
    @SageIniName("OnlyWhenGarrisoned") val onlyWhenGarrisoned: Boolean = false,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<AutoDepositUpdate>(
        name = "AutoDepositUpdate",
        properties = {
            property("DepositTiming", IntValue) { it.depositTiming }
            property("DepositAmount", IntValue) { it.depositAmount }
            property("InitialCaptureBonus", IntValue) { it.initialCaptureBonus }
            property("ActualMoney", BooleanValue) { it.actualMoney }
            property("UpgradedBoost", Opaque.type) { it.upgradedBoost }
            property("Upgrade", ReferenceValue<Upgrade> { listOf(Upgrade) }) { it.upgrade }
            property("UpgradeBonusPercent", FloatValue) { it.upgradeBonusPercent }
            property("UpgradeMustBePresent", SageFilter.type) { it.upgradeMustBePresent }
            property("GiveNoXP", BooleanValue) { it.giveNoXP }
            property("OnlyWhenGarrisoned", BooleanValue) { it.onlyWhenGarrisoned }
        },
    )
}
