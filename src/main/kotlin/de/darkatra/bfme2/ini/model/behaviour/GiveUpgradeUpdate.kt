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
import de.darkatra.bfme2.ini.model.`object`.SpecialPower
import de.darkatra.bfme2.ini.model.value.SageReference

data class GiveUpgradeUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialPowerTemplate") val specialPowerTemplate: SageReference<SpecialPower>? = null,
    @SageIniName("StartAbilityRange") val startAbilityRange: Double = 0.0,
    @SageIniName("UnpackTime") val unpackTime: Int = 0,
    @SageIniName("PreparationTime") val preparationTime: Int = 0,
    @SageIniName("PersistentPrepTime") val persistentPrepTime: Int = 0,
    @SageIniName("PackTime") val packTime: Int = 0,
    @SageIniName("ApproachRequiresLOS") val approachRequiresLOS: Boolean = false,
    @SageIniName("SpawnOutFX") val spawnOutFX: SageReference<FXList>? = null,
    @SageIniName("DeliverUpgrade") val deliverUpgrade: Boolean = false,
    @SageIniName("FadeOutSpeed") val fadeOutSpeed: Double = 0.0,
    @SageIniName("GiveUpgradeEffect") val giveUpgradeEffect: SageReference<FXList>? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<GiveUpgradeUpdate>(
        name = "GiveUpgradeUpdate",
        properties = {
            property("SpecialPowerTemplate", ReferenceValue<SpecialPower> { listOf(SpecialPower) }) { it.specialPowerTemplate }
            property("StartAbilityRange", FloatValue) { it.startAbilityRange }
            property("UnpackTime", IntValue) { it.unpackTime }
            property("PreparationTime", IntValue) { it.preparationTime }
            property("PersistentPrepTime", IntValue) { it.persistentPrepTime }
            property("PackTime", IntValue) { it.packTime }
            property("ApproachRequiresLOS", BooleanValue) { it.approachRequiresLOS }
            property("SpawnOutFX", ReferenceValue<FXList> { listOf(FXList) }) { it.spawnOutFX }
            property("DeliverUpgrade", BooleanValue) { it.deliverUpgrade }
            property("FadeOutSpeed", FloatValue) { it.fadeOutSpeed }
            property("GiveUpgradeEffect", ReferenceValue<FXList> { listOf(FXList) }) { it.giveUpgradeEffect }
        },
    )
}
