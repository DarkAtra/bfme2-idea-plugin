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
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.FakeToken
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.Rgb
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class PlayerTemplate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Side") val side: FakeToken? = null,
    @SageIniName("PlayableSide") val playableSide: Boolean = false,
    @SageIniName("FactionSide") val factionSide: FakeToken? = null,
    @SageIniName("SideIconImage") val sideIconImage: SageReference<MappedImage>? = null,
    @SageIniName("PlayableFactionSide") val playableFactionSide: Boolean = false,
    @SageIniName("StartMoney") val startMoney: Int = 0,
    @SageIniName("PreferredColor") val preferredColor: Rgb? = null,
    @SageIniName("IntrinsicSciences") val intrinsicSciences: List<SageReference<Science>>? = null,
    @SageIniName("DisplayName") val displayName: String = "",
    @SageIniName("ScoreScreenImage") val scoreScreenImage: SageReference<MappedImage>? = null,
    @SageIniName("LoadScreenMusic") val loadScreenMusic: Untyped? = null,
    @SageIniName("IsObserver") val isObserver: Boolean = false,
    @SageIniName("LoadScreenImage") val loadScreenImage: SageReference<MappedImage>? = null,
    @SageIniName("BeaconName") val beaconName: SageReference<Object>? = null,
    @SageIniName("FactionSideIconImage") val factionSideIconImage: SageReference<MappedImage>? = null,
    @SageIniName("Evil") val evil: Boolean = false,
    @SageIniName("MaxLevelMP") val maxLevelMP: Int = 0,
    @SageIniName("MaxLevelSP") val maxLevelSP: Int = 0,
    @SageIniName("StartingUnit1") val startingUnit1: SageReference<Object>? = null,
    @SageIniName("StartingUnitOffset1") val startingUnitOffset1: Coords? = null,
    @SageIniName("StartingUnit0") val startingUnit0: SageReference<Object>? = null,
    @SageIniName("StartingUnitOffset0") val startingUnitOffset0: Coords? = null,
    @SageIniName("StartingUnit2") val startingUnit2: SageReference<Object>? = null,
    @SageIniName("StartingUnitOffset2") val startingUnitOffset2: Coords? = null,
    @SageIniName("StartingUnit3") val startingUnit3: SageReference<Object>? = null,
    @SageIniName("StartingUnitOffset3") val startingUnitOffset3: Coords? = null,
    @SageIniName("StartingUnit4") val startingUnit4: SageReference<Object>? = null,
    @SageIniName("StartingUnitOffset4") val startingUnitOffset4: Coords? = null,
    @SageIniName("StartingUnit5") val startingUnit5: SageReference<Object>? = null,
    @SageIniName("StartingUnitOffset5") val startingUnitOffset5: Coords? = null,
    @SageIniName("StartingUnitTacticalWOTR") val startingUnitTacticalWOTR: List<SageReference<Object>> = emptyList(),
    @SageIniName("IntrinsicSciencesMP") val intrinsicSciencesMP: List<SageReference<Science>>? = null,
    @SageIniName("SpellBook") val spellBook: SageReference<Object>? = null,
    @SageIniName("SpellBookMp") val spellBookMp: SageReference<Object>? = null,
    @SageIniName("PurchaseScienceCommandSet") val purchaseScienceCommandSet: SageReference<CommandSet>? = null,
    @SageIniName("PurchaseScienceCommandSetMP") val purchaseScienceCommandSetMP: SageReference<CommandSet>? = null,
    @SageIniName("DefaultPlayerAIType") val defaultPlayerAIType: SageReference<PlayerAIType>? = null,
    @SageIniName("LightPointsUpSound") val lightPointsUpSound: SageReference<AudioEvent>? = null,
    @SageIniName("ObjectiveAddedSound") val objectiveAddedSound: SageReference<AudioEvent>? = null,
    @SageIniName("ObjectiveCompletedSound") val objectiveCompletedSound: SageReference<AudioEvent>? = null,
    @SageIniName("InitialUpgrades") val initialUpgrades: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("BuildableHeroesMP") val buildableHeroesMP: List<SageReference<Object>> = emptyList(),
    @SageIniName("BuildableRingHeroesMP") val buildableRingHeroesMP: List<SageReference<Object>> = emptyList(),
    @SageIniName("SpellStoreCurrentPowerLabel") val spellStoreCurrentPowerLabel: String = "",
    @SageIniName("SpellStoreMaximumPowerLabel") val spellStoreMaximumPowerLabel: String = "",
    @SageIniName("ResourceModifierObjectFilter") val resourceModifierObjectFilter: SageFilter? = null,
    @SageIniName("ResourceModifierValues") val resourceModifierValues: List<Double> = emptyList(),
    @SageIniName("MultiSelectionPortrait") val multiSelectionPortrait: SageReference<MappedImage>? = null,
    @SageIniName("StartingBuilding") val startingBuilding: SageReference<Object>? = null,
    @SageIniName("BaseSide") val baseSide: Opaque? = null,
    @SageIniName("OldFaction") val oldFaction: Boolean = false,
    @SageIniName("ArmyTooltip") val armyTooltip: String = "",
    @SageIniName("Features") val features: String = "",
    @SageIniName("EnabledImage") val enabledImage: SageReference<MappedImage>? = null,
    @SageIniName("GeneralImage") val generalImage: SageReference<MappedImage>? = null,
    @SageIniName("FlagWaterMark") val flagWaterMark: SageReference<MappedImage>? = null,
    @SageIniName("MedallionRegular") val medallionRegular: SageReference<MappedImage>? = null,
    @SageIniName("MedallionHilite") val medallionHilite: SageReference<MappedImage>? = null,
    @SageIniName("MedallionSelect") val medallionSelect: SageReference<MappedImage>? = null,
    @SageIniName("ScoreScreenMusic") val scoreScreenMusic: Opaque? = null,
    @SageIniName("PurchaseScienceCommandSetRank1") val purchaseScienceCommandSetRank1: SageReference<CommandSet>? = null,
    @SageIniName("PurchaseScienceCommandSetRank3") val purchaseScienceCommandSetRank3: SageReference<CommandSet>? = null,
    @SageIniName("PurchaseScienceCommandSetRank8") val purchaseScienceCommandSetRank8: SageReference<CommandSet>? = null,
    @SageIniName("SpecialPowerShortcutCommandSet") val specialPowerShortcutCommandSet: SageReference<CommandSet>? = null,
    @SageIniName("SpecialPowerShortcutButtonCount") val specialPowerShortcutButtonCount: Int = 0,
    @SageIniName("SpecialPowerShortcutWinName") val specialPowerShortcutWinName: Opaque? = null,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<PlayerTemplate>(
        name = "PlayerTemplate",
        tableKey = "factions",
        properties = {
            property("Side", FakeToken.type) { it.side }
            property("PlayableSide", BooleanValue) { it.playableSide }
            property("FactionSide", FakeToken.type) { it.factionSide }
            property("SideIconImage", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.sideIconImage }
            property("PlayableFactionSide", BooleanValue) { it.playableFactionSide }
            property("StartMoney", IntValue) { it.startMoney }
            property("PreferredColor", Rgb.type) { it.preferredColor }
            property("IntrinsicSciences", ListValue(ReferenceValue<Science> { listOf(Science) })) { it.intrinsicSciences }
            property("DisplayName", StringValue) { it.displayName }
            property("ScoreScreenImage", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.scoreScreenImage }
            property("LoadScreenMusic", Untyped.type) { it.loadScreenMusic }
            property("IsObserver", BooleanValue) { it.isObserver }
            property("LoadScreenImage", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.loadScreenImage }
            property("BeaconName", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.beaconName }
            property("FactionSideIconImage", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.factionSideIconImage }
            property("Evil", BooleanValue) { it.evil }
            property("MaxLevelMP", IntValue) { it.maxLevelMP }
            property("MaxLevelSP", IntValue) { it.maxLevelSP }
            property("StartingUnit1", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.startingUnit1 }
            property("StartingUnitOffset1", Coords.type) { it.startingUnitOffset1 }
            property("StartingUnit0", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.startingUnit0 }
            property("StartingUnitOffset0", Coords.type) { it.startingUnitOffset0 }
            property("StartingUnit2", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.startingUnit2 }
            property("StartingUnitOffset2", Coords.type) { it.startingUnitOffset2 }
            property("StartingUnit3", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.startingUnit3 }
            property("StartingUnitOffset3", Coords.type) { it.startingUnitOffset3 }
            property("StartingUnit4", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.startingUnit4 }
            property("StartingUnitOffset4", Coords.type) { it.startingUnitOffset4 }
            property("StartingUnit5", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.startingUnit5 }
            property("StartingUnitOffset5", Coords.type) { it.startingUnitOffset5 }
            property(
                "StartingUnitTacticalWOTR",
                ListValue(ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) })
            ) { it.startingUnitTacticalWOTR }
            property("IntrinsicSciencesMP", ListValue(ReferenceValue<Science> { listOf(Science) })) { it.intrinsicSciencesMP }
            property("SpellBook", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.spellBook }
            property("SpellBookMp", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.spellBookMp }
            property("PurchaseScienceCommandSet", ReferenceValue<CommandSet> { listOf(CommandSet) }) { it.purchaseScienceCommandSet }
            property("PurchaseScienceCommandSetMP", ReferenceValue<CommandSet> { listOf(CommandSet) }) { it.purchaseScienceCommandSetMP }
            property("DefaultPlayerAIType", ReferenceValue<PlayerAIType> { listOf(PlayerAIType) }) { it.defaultPlayerAIType }
            property("LightPointsUpSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.lightPointsUpSound }
            property("ObjectiveAddedSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.objectiveAddedSound }
            property("ObjectiveCompletedSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.objectiveCompletedSound }
            property("InitialUpgrades", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.initialUpgrades }
            property("BuildableHeroesMP", ListValue(ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) })) { it.buildableHeroesMP }
            property("BuildableRingHeroesMP", ListValue(ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) })) { it.buildableRingHeroesMP }
            property("SpellStoreCurrentPowerLabel", StringValue) { it.spellStoreCurrentPowerLabel }
            property("SpellStoreMaximumPowerLabel", StringValue) { it.spellStoreMaximumPowerLabel }
            property("ResourceModifierObjectFilter", SageFilter.type) { it.resourceModifierObjectFilter }
            property("ResourceModifierValues", ListValue(FloatValue)) { it.resourceModifierValues }
            property("MultiSelectionPortrait", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.multiSelectionPortrait }
            property("StartingBuilding", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.startingBuilding }
            property("BaseSide", Opaque.type) { it.baseSide }
            property("OldFaction", BooleanValue) { it.oldFaction }
            property("ArmyTooltip", StringValue) { it.armyTooltip }
            property("Features", StringValue) { it.features }
            property("EnabledImage", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.enabledImage }
            property("GeneralImage", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.generalImage }
            property("FlagWaterMark", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.flagWaterMark }
            property("MedallionRegular", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.medallionRegular }
            property("MedallionHilite", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.medallionHilite }
            property("MedallionSelect", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.medallionSelect }
            property("ScoreScreenMusic", Opaque.type) { it.scoreScreenMusic }
            property("PurchaseScienceCommandSetRank1", ReferenceValue<CommandSet> { listOf(CommandSet) }) { it.purchaseScienceCommandSetRank1 }
            property("PurchaseScienceCommandSetRank3", ReferenceValue<CommandSet> { listOf(CommandSet) }) { it.purchaseScienceCommandSetRank3 }
            property("PurchaseScienceCommandSetRank8", ReferenceValue<CommandSet> { listOf(CommandSet) }) { it.purchaseScienceCommandSetRank8 }
            property("SpecialPowerShortcutCommandSet", ReferenceValue<CommandSet> { listOf(CommandSet) }) { it.specialPowerShortcutCommandSet }
            property("SpecialPowerShortcutButtonCount", IntValue) { it.specialPowerShortcutButtonCount }
            property("SpecialPowerShortcutWinName", Opaque.type) { it.specialPowerShortcutWinName }
        },
    )
}
