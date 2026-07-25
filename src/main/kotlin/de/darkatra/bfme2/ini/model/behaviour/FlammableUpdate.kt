package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.MapValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.value.DamageType
import de.darkatra.bfme2.ini.model.value.SageReference

data class FlammableUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("FlameDamageLimit") val flameDamageLimit: Double = 0.0,
    @SageIniName("FlameDamageExpiration") val flameDamageExpiration: Int = 0,
    @SageIniName("AflameDuration") val aflameDuration: Int = 0,
    @SageIniName("AflameDamageAmount") val aflameDamageAmount: Int = 0,
    @SageIniName("AflameDamageDelay") val aflameDamageDelay: Int = 0,
    @SageIniName("BurnedDelay") val burnedDelay: Int = 0,
    @SageIniName("BurningSoundName") val burningSoundName: SageReference<AudioEvent>? = null,
    @SageIniName("BurnContained") val burnContained: Boolean = false,
    @SageIniName("FireFXList") val fireFXList: List<Map<String, String>> = emptyList(),
    @SageIniName("SwapModelWhenAflame") val swapModelWhenAflame: Boolean = false,
    @SageIniName("SwapModelWhenQuenched") val swapModelWhenQuenched: Boolean = false,
    @SageIniName("RunToWater") val runToWater: Boolean = false,
    @SageIniName("RunToWaterDepth") val runToWaterDepth: Double = 0.0,
    @SageIniName("RunToWaterSearchRadius") val runToWaterSearchRadius: Double = 0.0,
    @SageIniName("RunToWaterSearchIncrement") val runToWaterSearchIncrement: Double = 0.0,
    @SageIniName("PanicLocomotorWhileAflame") val panicLocomotorWhileAflame: Boolean = false,
    @SageIniName("CustomAnimAndDuration") val customAnimAndDuration: Map<String, String> = emptyMap(),
    @SageIniName("SetBurnedStatus") val setBurnedStatus: Boolean = false,
    @SageIniName("DamageType") val damageType: DamageType? = null,
    @SageIniName("SwapTextureWhenAflame") val swapTextureWhenAflame: Boolean = false,
    @SageIniName("SwapTextureWhenQuenhed") val swapTextureWhenQuenhed: Boolean = false,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<FlammableUpdate>(
        name = "FlammableUpdate",
        properties = {
            property("FlameDamageLimit", FloatValue) { it.flameDamageLimit }
            property("FlameDamageExpiration", IntValue) { it.flameDamageExpiration }
            property("AflameDuration", IntValue) { it.aflameDuration }
            property("AflameDamageAmount", IntValue) { it.aflameDamageAmount }
            property("AflameDamageDelay", IntValue) { it.aflameDamageDelay }
            property("BurnedDelay", IntValue) { it.burnedDelay }
            property("BurningSoundName", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.burningSoundName }
            property("BurnContained", BooleanValue) { it.burnContained }
            property("FireFXList", ListValue(MapValue(StringValue, StringValue))) { it.fireFXList }
            property("SwapModelWhenAflame", BooleanValue) { it.swapModelWhenAflame }
            property("SwapModelWhenQuenched", BooleanValue) { it.swapModelWhenQuenched }
            property("RunToWater", BooleanValue) { it.runToWater }
            property("RunToWaterDepth", FloatValue) { it.runToWaterDepth }
            property("RunToWaterSearchRadius", FloatValue) { it.runToWaterSearchRadius }
            property("RunToWaterSearchIncrement", FloatValue) { it.runToWaterSearchIncrement }
            property("PanicLocomotorWhileAflame", BooleanValue) { it.panicLocomotorWhileAflame }
            property("CustomAnimAndDuration", MapValue(StringValue, StringValue)) { it.customAnimAndDuration }
            property("SetBurnedStatus", BooleanValue) { it.setBurnedStatus }
            property("DamageType", DamageType.type) { it.damageType }
            property("SwapTextureWhenAflame", BooleanValue) { it.swapTextureWhenAflame }
            property("SwapTextureWhenQuenhed", BooleanValue) { it.swapTextureWhenQuenhed }
        },
    )
}
