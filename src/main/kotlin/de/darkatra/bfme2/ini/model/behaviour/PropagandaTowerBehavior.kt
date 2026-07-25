package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.SageReference

data class PropagandaTowerBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("AffectsSelf") val affectsSelf: Boolean = false,
    @SageIniName("Radius") val radius: Double = 0.0,
    @SageIniName("DelayBetweenUpdates") val delayBetweenUpdates: Int = 0,
    @SageIniName("HealPercentEachSecond") val healPercentEachSecond: Double = 0.0,
    @SageIniName("UpgradedHealPercentEachSecond") val upgradedHealPercentEachSecond: Double = 0.0,
    @SageIniName("UpgradeRequired") val upgradeRequired: SageReference<Upgrade>? = null,
    @SageIniName("PulseFX") val pulseFX: SageReference<FXList>? = null,
    @SageIniName("UpgradedPulseFX") val upgradedPulseFX: SageReference<FXList>? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<PropagandaTowerBehavior>(
        name = "PropagandaTowerBehavior",
        properties = {
            property("AffectsSelf", BooleanValue) { it.affectsSelf }
            property("Radius", FloatValue) { it.radius }
            property("DelayBetweenUpdates", IntValue) { it.delayBetweenUpdates }
            property("HealPercentEachSecond", FloatValue) { it.healPercentEachSecond }
            property("UpgradedHealPercentEachSecond", FloatValue) { it.upgradedHealPercentEachSecond }
            property("UpgradeRequired", ReferenceValue<Upgrade> { listOf(Upgrade) }) { it.upgradeRequired }
            property("PulseFX", ReferenceValue<FXList> { listOf(FXList) }) { it.pulseFX }
            property("UpgradedPulseFX", ReferenceValue<FXList> { listOf(FXList) }) { it.upgradedPulseFX }
        },
    )
}
