package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.SpecialPower
import de.darkatra.bfme2.ini.model.value.SageReference

data class GiveUpgradeUpdate(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialPowerTemplate") override val specialPowerTemplate: SageReference<SpecialPower>? = null,
    @SageIniName("StartAbilityRange") override val startAbilityRange: Double = 0.0,
    @SageIniName("UnpackTime") override val unpackTime: Int = 0,
    @SageIniName("PreparationTime") override val preparationTime: Int = 0,
    @SageIniName("PersistentPrepTime") override val persistentPrepTime: Int = 0,
    @SageIniName("PackTime") override val packTime: Int = 0,
    @SageIniName("ApproachRequiresLOS") override val approachRequiresLOS: Boolean = false,
    @SageIniName("SpawnOutFX") val spawnOutFX: SageReference<FXList>? = null,
    @SageIniName("DeliverUpgrade") val deliverUpgrade: Boolean = false,
    @SageIniName("FadeOutSpeed") val fadeOutSpeed: Double = 0.0,
    @SageIniName("GiveUpgradeEffect") val giveUpgradeEffect: SageReference<FXList>? = null,
) : SpecialAbilityUpdate() {

    companion object : SageIniBlockDescriptor<GiveUpgradeUpdate>(
        name = "GiveUpgradeUpdate",
        parent = SpecialAbilityUpdate,
        properties = {
            property("SpawnOutFX", ReferenceValue<FXList> { listOf(FXList) }) { it.spawnOutFX }
            property("DeliverUpgrade", BooleanValue) { it.deliverUpgrade }
            property("FadeOutSpeed", FloatValue) { it.fadeOutSpeed }
            property("GiveUpgradeEffect", ReferenceValue<FXList> { listOf(FXList) }) { it.giveUpgradeEffect }
        },
    )
}
