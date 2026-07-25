package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.value.AcademyType
import de.darkatra.bfme2.ini.model.value.FakeToken
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.ScienceRequirements
import de.darkatra.bfme2.ini.model.value.SpecialPowerType
import de.darkatra.bfme2.ini.model.value.Untyped

data class SpecialPower(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Enum") val enum: SpecialPowerType? = null,
    @SageIniName("InitiateSound") val initiateSound: SageReference<AudioEvent>? = null,
    @SageIniName("PreventActivationConditions") val preventActivationConditions: Untyped? = null,
    @SageIniName("SharedSyncedTimer") val sharedSyncedTimer: Boolean = false,
    @SageIniName("EvaEventToPlayOnSuccess") val evaEventToPlayOnSuccess: SageReference<EvaEventBase>? = null,
    @SageIniName("UnitSpecificSoundToUseAsInitiateIntendToDoVoice") val unitSpecificSoundToUseAsInitiateIntendToDoVoice: Opaque? = null,
    @SageIniName("UnitSpecificSoundToUseAsEnterStateInitiateIntendToDoVoice") val unitSpecificSoundToUseAsEnterStateInitiateIntendToDoVoice: Opaque? = null,
    @SageIniName("ReloadTime") val reloadTime: Int = 0,
    @SageIniName("PublicTimer") val publicTimer: Boolean = false,
    @SageIniName("Flags") val flags: List<FakeToken> = emptyList(),
    @SageIniName("RequiredSciences") val requiredSciences: ScienceRequirements? = null,
    @SageIniName("InitiateAtLocationSound") val initiateAtLocationSound: SageReference<AudioEvent>? = null,
    @SageIniName("ViewObjectDuration") val viewObjectDuration: Double = 0.0,
    @SageIniName("ViewObjectRange") val viewObjectRange: Double = 0.0,
    @SageIniName("RadiusCursorRadius") val radiusCursorRadius: Double = 0.0,
    @SageIniName("MaxCastRange") val maxCastRange: Double = 0.0,
    @SageIniName("ForbiddenObjectFilter") val forbiddenObjectFilter: SageFilter? = null,
    @SageIniName("ForbiddenObjectRange") val forbiddenObjectRange: Double = 0.0,
    @SageIniName("ObjectFilter") val objectFilter: SageFilter? = null,
    @SageIniName("AcademyClassify") val academyClassify: AcademyType? = null,
    @SageIniName("PalantirMovie") val palantirMovie: Opaque? = null,
    @SageIniName("RequiredScience") val requiredScience: SageReference<Science>? = null,
    @SageIniName("ShortcutPower") val shortcutPower: Boolean = false,
    @SageIniName("UnitCost") val unitCost: Int = 0,
    @SageIniName("UnitCostDeathType") val unitCostDeathType: Int = 0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<SpecialPower>(
        name = "SpecialPower",
        tableKey = "specialpowers",
        properties = {
            property("Enum", SpecialPowerType.type) { it.enum }
            property("InitiateSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.initiateSound }
            property("PreventActivationConditions", Untyped.type) { it.preventActivationConditions }
            property("SharedSyncedTimer", BooleanValue) { it.sharedSyncedTimer }
            property("EvaEventToPlayOnSuccess", ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.evaEventToPlayOnSuccess }
            property("UnitSpecificSoundToUseAsInitiateIntendToDoVoice", Opaque.type) { it.unitSpecificSoundToUseAsInitiateIntendToDoVoice }
            property("UnitSpecificSoundToUseAsEnterStateInitiateIntendToDoVoice", Opaque.type) { it.unitSpecificSoundToUseAsEnterStateInitiateIntendToDoVoice }
            property("ReloadTime", IntValue) { it.reloadTime }
            property("PublicTimer", BooleanValue) { it.publicTimer }
            property("Flags", ListValue(FakeToken.type)) { it.flags }
            property("RequiredSciences", ScienceRequirements.type) { it.requiredSciences }
            property("InitiateAtLocationSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.initiateAtLocationSound }
            property("ViewObjectDuration", FloatValue) { it.viewObjectDuration }
            property("ViewObjectRange", FloatValue) { it.viewObjectRange }
            property("RadiusCursorRadius", FloatValue) { it.radiusCursorRadius }
            property("MaxCastRange", FloatValue) { it.maxCastRange }
            property("ForbiddenObjectFilter", SageFilter.type) { it.forbiddenObjectFilter }
            property("ForbiddenObjectRange", FloatValue) { it.forbiddenObjectRange }
            property("ObjectFilter", SageFilter.type) { it.objectFilter }
            property("AcademyClassify", AcademyType.type) { it.academyClassify }
            property("PalantirMovie", Opaque.type) { it.palantirMovie }
            property("RequiredScience", ReferenceValue<Science> { listOf(Science) }) { it.requiredScience }
            property("ShortcutPower", BooleanValue) { it.shortcutPower }
            property("UnitCost", IntValue) { it.unitCost }
            property("UnitCostDeathType", IntValue) { it.unitCostDeathType }
        },
    )
}
