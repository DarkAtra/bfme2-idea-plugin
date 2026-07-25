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
import de.darkatra.bfme2.ini.model.ui.RadiusCursorTemplate
import de.darkatra.bfme2.ini.model.value.ButtonBorderTypes
import de.darkatra.bfme2.ini.model.value.CommandTypes
import de.darkatra.bfme2.ini.model.value.FakeToken
import de.darkatra.bfme2.ini.model.value.KindOf
import de.darkatra.bfme2.ini.model.value.ModelCondition
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.Options
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.SlotTypes

data class CommandButton(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ButtonBorderType") val buttonBorderType: ButtonBorderTypes? = null,
    @SageIniName("CommandTrigger") val commandTrigger: SageReference<CommandButton>? = null,
    @SageIniName("ToggleButtonName") val toggleButtonName: SageReference<CommandButton>? = null,
    @SageIniName("Command") val command: CommandTypes? = null,
    @SageIniName("CursorName") val cursorName: SageReference<MouseCursor>? = null,
    @SageIniName("InvalidCursorName") val invalidCursorName: SageReference<MouseCursor>? = null,
    @SageIniName("RadiusCursorType") val radiusCursorType: SageReference<RadiusCursorTemplate>? = null,
    @SageIniName("FlagsUsedForToggle") val flagsUsedForToggle: List<ModelCondition> = emptyList(),
    @SageIniName("ButtonImage") val buttonImage: List<SageReference<MappedImage>> = emptyList(),
    @SageIniName("AffectsKindOf") val affectsKindOf: List<KindOf> = emptyList(),
    @SageIniName("Options") val options: List<Options> = emptyList(),
    @SageIniName("Stances") val stances: List<FakeToken> = emptyList(),
    @SageIniName("CreateAHeroUIAllowableUpgrades") val createAHeroUIAllowableUpgrades: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("AutoAbilityDisallowedOnModelCondition") val autoAbilityDisallowedOnModelCondition: List<ModelCondition> = emptyList(),
    @SageIniName("DisableOnModelCondition") val disableOnModelCondition: List<ModelCondition> = emptyList(),
    @SageIniName("EnableOnModelCondition") val enableOnModelCondition: List<ModelCondition> = emptyList(),
    @SageIniName("Object") val `object`: SageReference<Object>? = null,
    @SageIniName("Science") val science: SageReference<Science>? = null,
    @SageIniName("UnitSpecificSound") val unitSpecificSound: List<SageReference<AudioEvent>> = emptyList(),
    @SageIniName("SetAutoAbilityUnitSound") val setAutoAbilityUnitSound: SageReference<AudioEvent>? = null,
    @SageIniName("SpecialPower") val specialPower: SageReference<SpecialPower>? = null,
    @SageIniName("DescriptLabel") val descriptLabel: List<String> = emptyList(),
    @SageIniName("TextLabel") val textLabel: List<String> = emptyList(),
    @SageIniName("LacksPrerequisiteLabel") val lacksPrerequisiteLabel: String = "",
    @SageIniName("ConflictingLabel") val conflictingLabel: String = "",
    @SageIniName("PurchasedLabel") val purchasedLabel: String = "",
    @SageIniName("CreateAHeroUIPrerequisiteButtonName") val createAHeroUIPrerequisiteButtonName: SageReference<CommandButton>? = null,
    @SageIniName("NeededUpgrade") val neededUpgrade: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("WeaponSlot") val weaponSlot: SlotTypes? = null,
    @SageIniName("WeaponSlotToggle1") val weaponSlotToggle1: SlotTypes? = null,
    @SageIniName("WeaponSlotToggle2") val weaponSlotToggle2: SlotTypes? = null,
    @SageIniName("DoubleClick") val doubleClick: Boolean = false,
    @SageIniName("Radial") val radial: Boolean = false,
    @SageIniName("InPalantir") val inPalantir: Boolean = false,
    @SageIniName("AutoAbility") val autoAbility: Boolean = false,
    @SageIniName("TriggerWhenReady") val triggerWhenReady: Boolean = false,
    @SageIniName("ShowButton") val showButton: Boolean = false,
    @SageIniName("NeedDamagedTarget") val needDamagedTarget: Boolean = false,
    @SageIniName("IsClickable") val isClickable: Boolean = false,
    @SageIniName("ShowProductionCount") val showProductionCount: Boolean = false,
    @SageIniName("NeededUpgradeAny") val neededUpgradeAny: Boolean = false,
    @SageIniName("RequiresValidContainer") val requiresValidContainer: Boolean = false,
    @SageIniName("PresetRange") val presetRange: Double = 0.0,
    @SageIniName("AutoDelay") val autoDelay: Double = 0.0,
    @SageIniName("CommandRangeStart") val commandRangeStart: Int = 0,
    @SageIniName("CommandRangeCount") val commandRangeCount: Int = 0,
    @SageIniName("CreateAHeroUIMinimumLevel") val createAHeroUIMinimumLevel: Int = 0,
    @SageIniName("CreateAHeroUICostIfSelected") val createAHeroUICostIfSelected: Int = 0,
    @SageIniName("Upgrade") val upgrade: SageReference<Upgrade>? = null,
    @SageIniName("AffectsAllies") val affectsAllies: Boolean = false,
    @SageIniName("BuildUpgrades") val buildUpgrades: Opaque? = null,
    @SageIniName("MaxShotsToFire") val maxShotsToFire: Int = 0,
    @SageIniName("UnitSpecificSound2") val unitSpecificSound2: Opaque? = null,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<CommandButton>(
        name = "CommandButton",
        tableKey = "commandbuttons",
        properties = {
            property("ButtonBorderType", ButtonBorderTypes.type) { it.buttonBorderType }
            property("CommandTrigger", ReferenceValue<CommandButton> { listOf(CommandButton) }) { it.commandTrigger }
            property("ToggleButtonName", ReferenceValue<CommandButton> { listOf(CommandButton) }) { it.toggleButtonName }
            property("Command", CommandTypes.type) { it.command }
            property("CursorName", ReferenceValue<MouseCursor> { listOf(MouseCursor) }) { it.cursorName }
            property("InvalidCursorName", ReferenceValue<MouseCursor> { listOf(MouseCursor) }) { it.invalidCursorName }
            property("RadiusCursorType", ReferenceValue<RadiusCursorTemplate> { listOf(RadiusCursorTemplate) }) { it.radiusCursorType }
            property("FlagsUsedForToggle", ListValue(ModelCondition.type)) { it.flagsUsedForToggle }
            property("ButtonImage", ListValue(ReferenceValue<MappedImage> { listOf(MappedImage) })) { it.buttonImage }
            property("AffectsKindOf", ListValue(KindOf.type)) { it.affectsKindOf }
            property("Options", ListValue(Options.type)) { it.options }
            property("Stances", ListValue(FakeToken.type)) { it.stances }
            property("CreateAHeroUIAllowableUpgrades", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.createAHeroUIAllowableUpgrades }
            property("AutoAbilityDisallowedOnModelCondition", ListValue(ModelCondition.type)) { it.autoAbilityDisallowedOnModelCondition }
            property("DisableOnModelCondition", ListValue(ModelCondition.type)) { it.disableOnModelCondition }
            property("EnableOnModelCondition", ListValue(ModelCondition.type)) { it.enableOnModelCondition }
            property("Object", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.`object` }
            property("Science", ReferenceValue<Science> { listOf(Science) }) { it.science }
            property("UnitSpecificSound", ListValue(ReferenceValue<AudioEvent> { listOf(AudioEvent) })) { it.unitSpecificSound }
            property("SetAutoAbilityUnitSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.setAutoAbilityUnitSound }
            property("SpecialPower", ReferenceValue<SpecialPower> { listOf(SpecialPower) }) { it.specialPower }
            property("DescriptLabel", ListValue(StringValue)) { it.descriptLabel }
            property("TextLabel", ListValue(StringValue)) { it.textLabel }
            property("LacksPrerequisiteLabel", StringValue) { it.lacksPrerequisiteLabel }
            property("ConflictingLabel", StringValue) { it.conflictingLabel }
            property("PurchasedLabel", StringValue) { it.purchasedLabel }
            property("CreateAHeroUIPrerequisiteButtonName", ReferenceValue<CommandButton> { listOf(CommandButton) }) { it.createAHeroUIPrerequisiteButtonName }
            property("NeededUpgrade", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.neededUpgrade }
            property("WeaponSlot", SlotTypes.type) { it.weaponSlot }
            property("WeaponSlotToggle1", SlotTypes.type) { it.weaponSlotToggle1 }
            property("WeaponSlotToggle2", SlotTypes.type) { it.weaponSlotToggle2 }
            property("DoubleClick", BooleanValue) { it.doubleClick }
            property("Radial", BooleanValue) { it.radial }
            property("InPalantir", BooleanValue) { it.inPalantir }
            property("AutoAbility", BooleanValue) { it.autoAbility }
            property("TriggerWhenReady", BooleanValue) { it.triggerWhenReady }
            property("ShowButton", BooleanValue) { it.showButton }
            property("NeedDamagedTarget", BooleanValue) { it.needDamagedTarget }
            property("IsClickable", BooleanValue) { it.isClickable }
            property("ShowProductionCount", BooleanValue) { it.showProductionCount }
            property("NeededUpgradeAny", BooleanValue) { it.neededUpgradeAny }
            property("RequiresValidContainer", BooleanValue) { it.requiresValidContainer }
            property("PresetRange", FloatValue) { it.presetRange }
            property("AutoDelay", FloatValue) { it.autoDelay }
            property("CommandRangeStart", IntValue) { it.commandRangeStart }
            property("CommandRangeCount", IntValue) { it.commandRangeCount }
            property("CreateAHeroUIMinimumLevel", IntValue) { it.createAHeroUIMinimumLevel }
            property("CreateAHeroUICostIfSelected", IntValue) { it.createAHeroUICostIfSelected }
            property("Upgrade", ReferenceValue<Upgrade> { listOf(Upgrade) }) { it.upgrade }
            property("AffectsAllies", BooleanValue) { it.affectsAllies }
            property("BuildUpgrades", Opaque.type) { it.buildUpgrades }
            property("MaxShotsToFire", IntValue) { it.maxShotsToFire }
            property("UnitSpecificSound2", Opaque.type) { it.unitSpecificSound2 }
        },
    )
}
