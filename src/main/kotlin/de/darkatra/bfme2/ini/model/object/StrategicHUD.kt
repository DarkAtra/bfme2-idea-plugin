package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.value.Opaque

data class StrategicHUD(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ArmyDetailsPanel") val armyDetailsPanel: Opaque? = null,
    @SageIniName("BattleResolver") val battleResolver: Opaque? = null,
    @SageIniName("BuildQueueDetailsPanel") val buildQueueDetailsPanel: Opaque? = null,
    @SageIniName("CancelArmyMemberMoveButton") val cancelArmyMemberMoveButton: Opaque? = null,
    @SageIniName("CancelArmyMoveButton") val cancelArmyMoveButton: Opaque? = null,
    @SageIniName("CancelBuildingConstructionButton") val cancelBuildingConstructionButton: Opaque? = null,
    @SageIniName("Checklist") val checklist: Opaque? = null,
    @SageIniName("DestroyBuildingButton") val destroyBuildingButton: Opaque? = null,
    @SageIniName("DisbandArmyButton") val disbandArmyButton: Opaque? = null,
    @SageIniName("DisbandArmyMemberButton") val disbandArmyMemberButton: Opaque? = null,
    @SageIniName("DynamicAutoResolveDialog") val dynamicAutoResolveDialog: Opaque? = null,
    @SageIniName("ObjectivesButton") val objectivesButton: Opaque? = null,
    @SageIniName("OptionsButton") val optionsButton: Opaque? = null,
    @SageIniName("RegionDetailsPanelStructuresPage") val regionDetailsPanelStructuresPage: Opaque? = null,
    @SageIniName("RegionDisplay") val regionDisplay: Opaque? = null,
    @SageIniName("StatsDisplay") val statsDisplay: Opaque? = null,
    @SageIniName("ToggleSelectionDetailsButton") val toggleSelectionDetailsButton: Opaque? = null,
    @SageIniName("TypeImages") val typeImages: Opaque? = null,
    @SageIniName("UpgradeUnitButton") val upgradeUnitButton: Opaque? = null,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<StrategicHUD>(
        name = "StrategicHUD",
        tableKey = "strategichuds",
        properties = {
            property("ArmyDetailsPanel", Opaque.type) { it.armyDetailsPanel }
            property("BattleResolver", Opaque.type) { it.battleResolver }
            property("BuildQueueDetailsPanel", Opaque.type) { it.buildQueueDetailsPanel }
            property("CancelArmyMemberMoveButton", Opaque.type) { it.cancelArmyMemberMoveButton }
            property("CancelArmyMoveButton", Opaque.type) { it.cancelArmyMoveButton }
            property("CancelBuildingConstructionButton", Opaque.type) { it.cancelBuildingConstructionButton }
            property("Checklist", Opaque.type) { it.checklist }
            property("DestroyBuildingButton", Opaque.type) { it.destroyBuildingButton }
            property("DisbandArmyButton", Opaque.type) { it.disbandArmyButton }
            property("DisbandArmyMemberButton", Opaque.type) { it.disbandArmyMemberButton }
            property("DynamicAutoResolveDialog", Opaque.type) { it.dynamicAutoResolveDialog }
            property("ObjectivesButton", Opaque.type) { it.objectivesButton }
            property("OptionsButton", Opaque.type) { it.optionsButton }
            property("RegionDetailsPanelStructuresPage", Opaque.type) { it.regionDetailsPanelStructuresPage }
            property("RegionDisplay", Opaque.type) { it.regionDisplay }
            property("StatsDisplay", Opaque.type) { it.statsDisplay }
            property("ToggleSelectionDetailsButton", Opaque.type) { it.toggleSelectionDetailsButton }
            property("TypeImages", Opaque.type) { it.typeImages }
            property("UpgradeUnitButton", Opaque.type) { it.upgradeUnitButton }
        },
    )
}
