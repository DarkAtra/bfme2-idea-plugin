package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.value.EmotionTypes
import de.darkatra.bfme2.ini.model.value.Rgb
import de.darkatra.bfme2.ini.model.value.SageReference

data class ExperienceLevel(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("TargetNames") val targetNames: List<SageReference<Object>> = emptyList(),
    @SageIniName("RequiredExperience") val requiredExperience: Double = 0.0,
    @SageIniName("ExperienceAward") val experienceAward: Double = 0.0,
    @SageIniName("Rank") val rank: Double = 0.0,
    @SageIniName("ExperienceAwardOwnGuysDie") val experienceAwardOwnGuysDie: Double = 0.0,
    @SageIniName("Upgrades") val upgrades: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("InformUpdateModule") val informUpdateModule: Boolean = false,
    @SageIniName("LevelUpTintColor") val levelUpTintColor: Rgb? = null,
    @SageIniName("LevelUpTintPreColorTime") val levelUpTintPreColorTime: Double = 0.0,
    @SageIniName("LevelUpTintPostColorTime") val levelUpTintPostColorTime: Double = 0.0,
    @SageIniName("LevelUpTintSustainColorTime") val levelUpTintSustainColorTime: Double = 0.0,
    @SageIniName("AttributeModifiers") val attributeModifiers: List<SageReference<ModifierList>> = emptyList(),
    @SageIniName("LevelUpFx") val levelUpFx: SageReference<FXList>? = null,
    @SageIniName("ShowLevelUpTint") val showLevelUpTint: Boolean = false,
    @SageIniName("EmotionType") val emotionType: EmotionTypes? = null,
    @SageIniName("SelectionDecal") val selectionDecal: List<SelectionDecal> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<ExperienceLevel>(
        name = "ExperienceLevel",
        tableKey = "levels",
        properties = {
            property("TargetNames", ListValue(ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) })) { it.targetNames }
            property("RequiredExperience", FloatValue) { it.requiredExperience }
            property("ExperienceAward", FloatValue) { it.experienceAward }
            property("Rank", FloatValue) { it.rank }
            property("ExperienceAwardOwnGuysDie", FloatValue) { it.experienceAwardOwnGuysDie }
            property("Upgrades", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.upgrades }
            property("InformUpdateModule", BooleanValue) { it.informUpdateModule }
            property("LevelUpTintColor", Rgb.type) { it.levelUpTintColor }
            property("LevelUpTintPreColorTime", FloatValue) { it.levelUpTintPreColorTime }
            property("LevelUpTintPostColorTime", FloatValue) { it.levelUpTintPostColorTime }
            property("LevelUpTintSustainColorTime", FloatValue) { it.levelUpTintSustainColorTime }
            property("AttributeModifiers", ListValue(ReferenceValue<ModifierList> { listOf(ModifierList) })) { it.attributeModifiers }
            property("LevelUpFx", ReferenceValue<FXList> { listOf(FXList) }) { it.levelUpFx }
            property("ShowLevelUpTint", BooleanValue) { it.showLevelUpTint }
            property("EmotionType", EmotionTypes.type) { it.emotionType }
            property("SelectionDecal", ListValue(BlockValue<SelectionDecal> { listOf(SelectionDecal) })) { it.selectionDecal }
        },
    )
}
