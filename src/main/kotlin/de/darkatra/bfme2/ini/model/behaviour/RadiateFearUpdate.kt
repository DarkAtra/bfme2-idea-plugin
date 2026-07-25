package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.`object`.UpgradeTrigger
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class RadiateFearUpdate(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("TriggeredBy") override val triggeredBy: List<SageReference<UpgradeTrigger>> = emptyList(),
    @SageIniName("ConflictsWith") override val conflictsWith: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("RequiresAllTriggers") override val requiresAllTriggers: Boolean = false,
    @SageIniName("RequiresAllConflictingTriggers") override val requiresAllConflictingTriggers: Boolean = false,
    @SageIniName("StartsActive") override val startsActive: Boolean = false,
    @SageIniName("Description") override val description: String = "",
    @SageIniName("ActiveDuringConstruction") override val activeDuringConstruction: Boolean = false,
    @SageIniName("CustomAnimAndDuration") override val customAnimAndDuration: Map<String, String> = emptyMap(),
    @SageIniName("Permanent") override val permanent: Boolean = false,
    @SageIniName("InitiallyActive") val initiallyActive: Boolean = false,
    @SageIniName("WhichSpecialPower") val whichSpecialPower: Int = 0,
    @SageIniName("GenerateTerror") val generateTerror: Boolean = false,
    @SageIniName("GenerateFear") val generateFear: Boolean = false,
    @SageIniName("EmotionPulseRadius") val emotionPulseRadius: Double = 0.0,
    @SageIniName("EmotionPulseInterval") val emotionPulseInterval: Int = 0,
    @SageIniName("VictimFilter") val victimFilter: SageFilter? = null,
    @SageIniName("GenerateUncontrollableFear") val generateUncontrollableFear: Boolean = false,
    @SageIniName("EmotionPulseRadiusl") val emotionPulseRadiusl: Double = 0.0,
) : UpgradeBehavior() {

    companion object : SageIniBlockDescriptor<RadiateFearUpdate>(
        name = "RadiateFearUpdate",
        parent = UpgradeBehavior,
        properties = {
            property("InitiallyActive", BooleanValue) { it.initiallyActive }
            property("WhichSpecialPower", IntValue) { it.whichSpecialPower }
            property("GenerateTerror", BooleanValue) { it.generateTerror }
            property("GenerateFear", BooleanValue) { it.generateFear }
            property("EmotionPulseRadius", FloatValue) { it.emotionPulseRadius }
            property("EmotionPulseInterval", IntValue) { it.emotionPulseInterval }
            property("VictimFilter", SageFilter.type) { it.victimFilter }
            property("GenerateUncontrollableFear", BooleanValue) { it.generateUncontrollableFear }
            property("EmotionPulseRadiusl", FloatValue) { it.emotionPulseRadiusl }
        },
    )
}
