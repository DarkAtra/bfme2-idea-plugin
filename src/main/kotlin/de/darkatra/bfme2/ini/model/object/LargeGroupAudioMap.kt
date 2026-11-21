package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.value.Untyped

data class LargeGroupAudioMap(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Size") val size: Int = 0,
    @SageIniName("StartThreshold") val startThreshold: Int = 0,
    @SageIniName("StopThreshold") val stopThreshold: Int = 0,
    @SageIniName("HandOffModeDuration") val handOffModeDuration: Int = 0,
    @SageIniName("MaximumAudioSpeed") val maximumAudioSpeed: Int = 0,
    @SageIniName("ExcludedObjectStatusBits") val excludedObjectStatusBits: Untyped? = null,
    @SageIniName("ExcludedModelConditionFlags") val excludedModelConditionFlags: Untyped? = null,
    @SageIniName("RequiredModelConditionFlags") val requiredModelConditionFlags: Untyped? = null,
    @SageIniName("IgnoreStealthedUnits") val ignoreStealthedUnits: Boolean = false,
    @SageIniName("Sound") val sound: List<LargeGroupAudioMapSound> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<LargeGroupAudioMap>(
        name = "LargeGroupAudioMap",
        tableKey = "largegroupaudiomaps",
        properties = {
            property("Size", IntValue) { it.size }
            property("StartThreshold", IntValue) { it.startThreshold }
            property("StopThreshold", IntValue) { it.stopThreshold }
            property("HandOffModeDuration", IntValue) { it.handOffModeDuration }
            property("MaximumAudioSpeed", IntValue) { it.maximumAudioSpeed }
            property("ExcludedObjectStatusBits", Untyped.type) { it.excludedObjectStatusBits }
            property("ExcludedModelConditionFlags", Untyped.type) { it.excludedModelConditionFlags }
            property("RequiredModelConditionFlags", Untyped.type) { it.requiredModelConditionFlags }
            property("IgnoreStealthedUnits", BooleanValue) { it.ignoreStealthedUnits }
            property("Sound", ListValue(BlockValue<LargeGroupAudioMapSound> { listOf(LargeGroupAudioMapSound) })) { it.sound }
        },
    )
}
