package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.value.ModelCondition
import de.darkatra.bfme2.ini.model.value.ModifierCategories
import de.darkatra.bfme2.ini.model.value.ModifierEntry
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.UpgradeWithDelay

data class ModifierList(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Category") val category: ModifierCategories? = null,
    @SageIniName("EndFX2") val endFX2: SageReference<FXList>? = null,
    @SageIniName("EndFX3") val endFX3: SageReference<FXList>? = null,
    @SageIniName("Duration") val duration: Int = 0,
    @SageIniName("FX") val fX: SageReference<FXList>? = null,
    @SageIniName("ReplaceInCategoryIfLongest") val replaceInCategoryIfLongest: Boolean = false,
    @SageIniName("IgnoreIfAnticategoryActive") val ignoreIfAnticategoryActive: Boolean = false,
    @SageIniName("FX2") val fX2: SageReference<FXList>? = null,
    @SageIniName("FX3") val fX3: SageReference<FXList>? = null,
    @SageIniName("MultiLevelFX") val multiLevelFX: Boolean = false,
    @SageIniName("ClearModelCondition") val clearModelCondition: List<ModelCondition> = emptyList(),
    @SageIniName("ModelCondition") val modelCondition: ModelCondition? = null,
    @SageIniName("Upgrade") val upgrade: UpgradeWithDelay? = null,
    @SageIniName("EndFX") val endFX: SageReference<FXList>? = null,
    @SageIniName("Modifier") val modifier: List<ModifierEntry> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<ModifierList>(
        name = "ModifierList",
        tableKey = "modifiers",
        properties = {
            property("Category", ModifierCategories.type) { it.category }
            property("EndFX2", ReferenceValue<FXList> { listOf(FXList) }) { it.endFX2 }
            property("EndFX3", ReferenceValue<FXList> { listOf(FXList) }) { it.endFX3 }
            property("Duration", IntValue) { it.duration }
            property("FX", ReferenceValue<FXList> { listOf(FXList) }) { it.fX }
            property("ReplaceInCategoryIfLongest", BooleanValue) { it.replaceInCategoryIfLongest }
            property("IgnoreIfAnticategoryActive", BooleanValue) { it.ignoreIfAnticategoryActive }
            property("FX2", ReferenceValue<FXList> { listOf(FXList) }) { it.fX2 }
            property("FX3", ReferenceValue<FXList> { listOf(FXList) }) { it.fX3 }
            property("MultiLevelFX", BooleanValue) { it.multiLevelFX }
            property("ClearModelCondition", ListValue(ModelCondition.type)) { it.clearModelCondition }
            property("ModelCondition", ModelCondition.type) { it.modelCondition }
            property("Upgrade", UpgradeWithDelay.type) { it.upgrade }
            property("EndFX", ReferenceValue<FXList> { listOf(FXList) }) { it.endFX }
            property("Modifier", ListValue(ModifierEntry.type)) { it.modifier }
        },
    )
}
