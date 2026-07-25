package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.value.FakeToken
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped
import de.darkatra.bfme2.ini.model.value.UpgradeTypes

data class Upgrade(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Type") val type: UpgradeTypes? = null,
    @SageIniName("GroupName") val groupName: String = "",
    @SageIniName("GroupOrder") val groupOrder: Int = 0,
    @SageIniName("UpgradeFX") val upgradeFX: SageReference<FXList>? = null,
    @SageIniName("UnitSpecificSound") val unitSpecificSound: Untyped? = null,
    @SageIniName("DisplayName") val displayName: String = "",
    @SageIniName("BuildTime") val buildTime: Int = 0,
    @SageIniName("BuildCost") val buildCost: Int = 0,
    @SageIniName("ButtonImage") val buttonImage: SageReference<MappedImage>? = null,
    @SageIniName("Tooltip") val tooltip: String = "",
    @SageIniName("Cursor") val cursor: SageReference<MouseCursor>? = null,
    @SageIniName("PersistsInCampaign") val persistsInCampaign: Boolean = false,
    @SageIniName("LocalPlayerGainsUpgradeEvaEvent") val localPlayerGainsUpgradeEvaEvent: SageReference<EvaEventBase>? = null,
    @SageIniName("LocalPlayerLosesUpgradeEvaEvent") val localPlayerLosesUpgradeEvaEvent: SageReference<EvaEventBase>? = null,
    @SageIniName("AlliedPlayerGainsUpgradeEvaEvent") val alliedPlayerGainsUpgradeEvaEvent: SageReference<EvaEventBase>? = null,
    @SageIniName("EnemyPlayerGainsUpgradeEvaEvent") val enemyPlayerGainsUpgradeEvaEvent: SageReference<EvaEventBase>? = null,
    @SageIniName("AlliedPlayerLosesUpgradeEvaEvent") val alliedPlayerLosesUpgradeEvaEvent: SageReference<EvaEventBase>? = null,
    @SageIniName("EnemyPlayerLosesUpgradeEvaEvent") val enemyPlayerLosesUpgradeEvaEvent: SageReference<EvaEventBase>? = null,
    @SageIniName("AcademyClassify") val academyClassify: FakeToken? = null,
    @SageIniName("NoUpgradeDiscount") val noUpgradeDiscount: Boolean = false,
    @SageIniName("UseObjectTemplateForCostDiscount") val useObjectTemplateForCostDiscount: SageReference<Object>? = null,
    @SageIniName("SkirmishAIHeuristic") val skirmishAIHeuristic: FakeToken? = null,
    @SageIniName("ResearchCompleteEvaEvent") val researchCompleteEvaEvent: SageReference<EvaEventBase>? = null,
    @SageIniName("ResearchSound") val researchSound: SageReference<AudioEvent>? = null,
    @SageIniName("RequiredObjectFilter") val requiredObjectFilter: SageFilter? = null,
    @SageIniName("StrategicIcon") val strategicIcon: SageReference<MappedImage>? = null,
    @SageIniName("SubUpgradeTemplateNames") val subUpgradeTemplateNames: List<SageReference<Upgrade>> = emptyList(),
) : SageIniObject, UpgradeTrigger {

    companion object : SageIniBlockDescriptor<Upgrade>(
        name = "Upgrade",
        tableKey = "upgrades",
        properties = {
            property("Type", UpgradeTypes.type) { it.type }
            property("GroupName", StringValue) { it.groupName }
            property("GroupOrder", IntValue) { it.groupOrder }
            property("UpgradeFX", ReferenceValue<FXList> { listOf(FXList) }) { it.upgradeFX }
            property("UnitSpecificSound", Untyped.type) { it.unitSpecificSound }
            property("DisplayName", StringValue) { it.displayName }
            property("BuildTime", IntValue) { it.buildTime }
            property("BuildCost", IntValue) { it.buildCost }
            property("ButtonImage", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.buttonImage }
            property("Tooltip", StringValue) { it.tooltip }
            property("Cursor", ReferenceValue<MouseCursor> { listOf(MouseCursor) }) { it.cursor }
            property("PersistsInCampaign", BooleanValue) { it.persistsInCampaign }
            property(
                "LocalPlayerGainsUpgradeEvaEvent",
                ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.localPlayerGainsUpgradeEvaEvent }
            property(
                "LocalPlayerLosesUpgradeEvaEvent",
                ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.localPlayerLosesUpgradeEvaEvent }
            property(
                "AlliedPlayerGainsUpgradeEvaEvent",
                ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.alliedPlayerGainsUpgradeEvaEvent }
            property(
                "EnemyPlayerGainsUpgradeEvaEvent",
                ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.enemyPlayerGainsUpgradeEvaEvent }
            property(
                "AlliedPlayerLosesUpgradeEvaEvent",
                ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.alliedPlayerLosesUpgradeEvaEvent }
            property(
                "EnemyPlayerLosesUpgradeEvaEvent",
                ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.enemyPlayerLosesUpgradeEvaEvent }
            property("AcademyClassify", FakeToken.type) { it.academyClassify }
            property("NoUpgradeDiscount", BooleanValue) { it.noUpgradeDiscount }
            property(
                "UseObjectTemplateForCostDiscount",
                ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.useObjectTemplateForCostDiscount }
            property("SkirmishAIHeuristic", FakeToken.type) { it.skirmishAIHeuristic }
            property("ResearchCompleteEvaEvent", ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.researchCompleteEvaEvent }
            property("ResearchSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.researchSound }
            property("RequiredObjectFilter", SageFilter.type) { it.requiredObjectFilter }
            property("StrategicIcon", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.strategicIcon }
            property("SubUpgradeTemplateNames", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.subUpgradeTemplateNames }
        },
    )
}
