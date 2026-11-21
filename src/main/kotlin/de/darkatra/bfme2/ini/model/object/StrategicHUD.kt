package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.ui.ArmyDetailsPanel
import de.darkatra.bfme2.ini.model.ui.BattleResolver
import de.darkatra.bfme2.ini.model.ui.BuildQueueDetailsPanel
import de.darkatra.bfme2.ini.model.ui.Checklist
import de.darkatra.bfme2.ini.model.ui.DynamicAutoResolveDialog
import de.darkatra.bfme2.ini.model.ui.RegionDetailsPanelStructuresPage
import de.darkatra.bfme2.ini.model.ui.RegionDisplay
import de.darkatra.bfme2.ini.model.ui.StatsDisplay
import de.darkatra.bfme2.ini.model.ui.StrategicHUDButton
import de.darkatra.bfme2.ini.model.ui.TypeImages

data class StrategicHUD(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ArmyDetailsPanel") val armyDetailsPanel: ArmyDetailsPanel? = null,
    @SageIniName("BattleResolver") val battleResolver: BattleResolver? = null,
    @SageIniName("BuildQueueDetailsPanel") val buildQueueDetailsPanel: BuildQueueDetailsPanel? = null,
    @SageIniName("CancelArmyMemberMoveButton") val cancelArmyMemberMoveButton: StrategicHUDButton? = null,
    @SageIniName("CancelArmyMoveButton") val cancelArmyMoveButton: StrategicHUDButton? = null,
    @SageIniName("CancelBuildingConstructionButton") val cancelBuildingConstructionButton: StrategicHUDButton? = null,
    @SageIniName("Checklist") val checklist: Checklist? = null,
    @SageIniName("DestroyBuildingButton") val destroyBuildingButton: StrategicHUDButton? = null,
    @SageIniName("DisbandArmyButton") val disbandArmyButton: StrategicHUDButton? = null,
    @SageIniName("DisbandArmyMemberButton") val disbandArmyMemberButton: StrategicHUDButton? = null,
    @SageIniName("DynamicAutoResolveDialog") val dynamicAutoResolveDialog: DynamicAutoResolveDialog? = null,
    @SageIniName("ObjectivesButton") val objectivesButton: StrategicHUDButton? = null,
    @SageIniName("OptionsButton") val optionsButton: StrategicHUDButton? = null,
    @SageIniName("RegionDetailsPanelStructuresPage") val regionDetailsPanelStructuresPage: RegionDetailsPanelStructuresPage? = null,
    @SageIniName("RegionDisplay") val regionDisplay: RegionDisplay? = null,
    @SageIniName("StatsDisplay") val statsDisplay: StatsDisplay? = null,
    @SageIniName("ToggleSelectionDetailsButton") val toggleSelectionDetailsButton: StrategicHUDButton? = null,
    @SageIniName("TypeImages") val typeImages: TypeImages? = null,
    @SageIniName("UpgradeUnitButton") val upgradeUnitButton: StrategicHUDButton? = null,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<StrategicHUD>(
        name = "StrategicHUD",
        tableKey = "strategichuds",
        properties = {
            property("ArmyDetailsPanel", BlockValue<ArmyDetailsPanel> { listOf(ArmyDetailsPanel) }) { it.armyDetailsPanel }
            property("BattleResolver", BlockValue<BattleResolver> { listOf(BattleResolver) }) { it.battleResolver }
            property("BuildQueueDetailsPanel", BlockValue<BuildQueueDetailsPanel> { listOf(BuildQueueDetailsPanel) }) { it.buildQueueDetailsPanel }
            property("CancelArmyMemberMoveButton", BlockValue<StrategicHUDButton> { listOf(StrategicHUDButton) }) { it.cancelArmyMemberMoveButton }
            property("CancelArmyMoveButton", BlockValue<StrategicHUDButton> { listOf(StrategicHUDButton) }) { it.cancelArmyMoveButton }
            property("CancelBuildingConstructionButton", BlockValue<StrategicHUDButton> { listOf(StrategicHUDButton) }) { it.cancelBuildingConstructionButton }
            property("Checklist", BlockValue<Checklist> { listOf(Checklist) }) { it.checklist }
            property("DestroyBuildingButton", BlockValue<StrategicHUDButton> { listOf(StrategicHUDButton) }) { it.destroyBuildingButton }
            property("DisbandArmyButton", BlockValue<StrategicHUDButton> { listOf(StrategicHUDButton) }) { it.disbandArmyButton }
            property("DisbandArmyMemberButton", BlockValue<StrategicHUDButton> { listOf(StrategicHUDButton) }) { it.disbandArmyMemberButton }
            property("DynamicAutoResolveDialog", BlockValue<DynamicAutoResolveDialog> { listOf(DynamicAutoResolveDialog) }) { it.dynamicAutoResolveDialog }
            property("ObjectivesButton", BlockValue<StrategicHUDButton> { listOf(StrategicHUDButton) }) { it.objectivesButton }
            property("OptionsButton", BlockValue<StrategicHUDButton> { listOf(StrategicHUDButton) }) { it.optionsButton }
            property("RegionDetailsPanelStructuresPage", BlockValue<RegionDetailsPanelStructuresPage> { listOf(RegionDetailsPanelStructuresPage) }) { it.regionDetailsPanelStructuresPage }
            property("RegionDisplay", BlockValue<RegionDisplay> { listOf(RegionDisplay) }) { it.regionDisplay }
            property("StatsDisplay", BlockValue<StatsDisplay> { listOf(StatsDisplay) }) { it.statsDisplay }
            property("ToggleSelectionDetailsButton", BlockValue<StrategicHUDButton> { listOf(StrategicHUDButton) }) { it.toggleSelectionDetailsButton }
            property("TypeImages", BlockValue<TypeImages> { listOf(TypeImages) }) { it.typeImages }
            property("UpgradeUnitButton", BlockValue<StrategicHUDButton> { listOf(StrategicHUDButton) }) { it.upgradeUnitButton }
        },
    )
}
