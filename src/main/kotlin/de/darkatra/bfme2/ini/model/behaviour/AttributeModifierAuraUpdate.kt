package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.ModifierList
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.`object`.UpgradeTrigger
import de.darkatra.bfme2.ini.model.value.AModAuraCondition
import de.darkatra.bfme2.ini.model.value.ModifierCategories
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class AttributeModifierAuraUpdate(
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
    @SageIniName("BonusName") val bonusName: SageReference<ModifierList>? = null,
    @SageIniName("RefreshDelay") val refreshDelay: Int = 0,
    @SageIniName("Range") val range: Double = 0.0,
    @SageIniName("TargetEnemy") val targetEnemy: Boolean = false,
    @SageIniName("ObjectFilter") val objectFilter: SageFilter? = null,
    @SageIniName("RunWhileDead") val runWhileDead: Boolean = false,
    @SageIniName("RequiredConditions") val requiredConditions: AModAuraCondition? = null,
    @SageIniName("AntiCategory") val antiCategory: List<ModifierCategories> = emptyList(),
    @SageIniName("AntiFX") val antiFX: SageReference<FXList>? = null,
    @SageIniName("AllowSelf") val allowSelf: Boolean = false,
    @SageIniName("AllowPowerWhenAttacking") val allowPowerWhenAttacking: Boolean = false,
    @SageIniName("MaxActiveRank") val maxActiveRank: Int = 0,
    @SageIniName("AffectContainedOnly") val affectContainedOnly: Boolean = false,
    @SageIniName("AffectGood") val affectGood: Boolean = false,
    @SageIniName("AffectEvil") val affectEvil: Boolean = false,
) : UpgradeBehavior() {

    companion object : SageIniBlockDescriptor<AttributeModifierAuraUpdate>(
        name = "AttributeModifierAuraUpdate",
        parent = UpgradeBehavior,
        properties = {
            property("BonusName", ReferenceValue<ModifierList> { listOf(ModifierList) }) { it.bonusName }
            property("RefreshDelay", IntValue) { it.refreshDelay }
            property("Range", FloatValue) { it.range }
            property("TargetEnemy", BooleanValue) { it.targetEnemy }
            property("ObjectFilter", SageFilter.type) { it.objectFilter }
            property("RunWhileDead", BooleanValue) { it.runWhileDead }
            property("RequiredConditions", AModAuraCondition.type) { it.requiredConditions }
            property("AntiCategory", ListValue(ModifierCategories.type)) { it.antiCategory }
            property("AntiFX", ReferenceValue<FXList> { listOf(FXList) }) { it.antiFX }
            property("AllowSelf", BooleanValue) { it.allowSelf }
            property("AllowPowerWhenAttacking", BooleanValue) { it.allowPowerWhenAttacking }
            property("MaxActiveRank", IntValue) { it.maxActiveRank }
            property("AffectContainedOnly", BooleanValue) { it.affectContainedOnly }
            property("AffectGood", BooleanValue) { it.affectGood }
            property("AffectEvil", BooleanValue) { it.affectEvil }
        },
    )
}
