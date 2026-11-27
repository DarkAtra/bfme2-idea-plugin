package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.ui.ImagePart
import de.darkatra.bfme2.ini.model.value.Coord2DInt
import de.darkatra.bfme2.ini.model.value.FakeToken
import de.darkatra.bfme2.ini.model.value.Rgba
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class ControlBarScheme(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ScreenCreationRes") val screenCreationRes: Untyped? = null,
    @SageIniName("Side") val side: FakeToken? = null,
    @SageIniName("CommandBarBorderColor") val commandBarBorderColor: Rgba? = null,
    @SageIniName("BuildUpClockColor") val buildUpClockColor: Rgba? = null,
    @SageIniName("ButtonBorderBuildColor") val buttonBorderBuildColor: Rgba? = null,
    @SageIniName("ButtonBorderActionColor") val buttonBorderActionColor: Rgba? = null,
    @SageIniName("ButtonBorderUpgradeColor") val buttonBorderUpgradeColor: Rgba? = null,
    @SageIniName("ButtonBorderSystemColor") val buttonBorderSystemColor: Rgba? = null,
    @SageIniName("ButtonBorderAlteredColor") val buttonBorderAlteredColor: Rgba? = null,
    @SageIniName("BeaconButtonDisabled") val beaconButtonDisabled: SageReference<MappedImage>? = null,
    @SageIniName("BeaconButtonEnable") val beaconButtonEnable: SageReference<MappedImage>? = null,
    @SageIniName("BeaconButtonHightlited") val beaconButtonHightlited: SageReference<MappedImage>? = null,
    @SageIniName("BeaconButtonPushed") val beaconButtonPushed: SageReference<MappedImage>? = null,
    @SageIniName("BeaconLR") val beaconLR: Coord2DInt? = null,
    @SageIniName("BeaconUL") val beaconUL: Coord2DInt? = null,
    @SageIniName("BuddyButtonDisabled") val buddyButtonDisabled: SageReference<MappedImage>? = null,
    @SageIniName("BuddyButtonEnable") val buddyButtonEnable: SageReference<MappedImage>? = null,
    @SageIniName("BuddyButtonHightlited") val buddyButtonHightlited: SageReference<MappedImage>? = null,
    @SageIniName("BuddyButtonPushed") val buddyButtonPushed: SageReference<MappedImage>? = null,
    @SageIniName("ChatLR") val chatLR: Coord2DInt? = null,
    @SageIniName("ChatUL") val chatUL: Coord2DInt? = null,
    @SageIniName("CommandMarkerImage") val commandMarkerImage: SageReference<MappedImage>? = null,
    @SageIniName("ExpBarForegroundImage") val expBarForegroundImage: SageReference<MappedImage>? = null,
    @SageIniName("GenArrow") val genArrow: SageReference<MappedImage>? = null,
    @SageIniName("GenBarButtonIn") val genBarButtonIn: SageReference<MappedImage>? = null,
    @SageIniName("GenBarButtonOn") val genBarButtonOn: SageReference<MappedImage>? = null,
    @SageIniName("GeneralButtonDisabled") val generalButtonDisabled: SageReference<MappedImage>? = null,
    @SageIniName("GeneralButtonEnable") val generalButtonEnable: SageReference<MappedImage>? = null,
    @SageIniName("GeneralButtonHightlited") val generalButtonHightlited: SageReference<MappedImage>? = null,
    @SageIniName("GeneralButtonPushed") val generalButtonPushed: SageReference<MappedImage>? = null,
    @SageIniName("GeneralLR") val generalLR: Coord2DInt? = null,
    @SageIniName("GeneralUL") val generalUL: Coord2DInt? = null,
    @SageIniName("IdleWorkerButtonDisabled") val idleWorkerButtonDisabled: SageReference<MappedImage>? = null,
    @SageIniName("IdleWorkerButtonEnable") val idleWorkerButtonEnable: SageReference<MappedImage>? = null,
    @SageIniName("IdleWorkerButtonHightlited") val idleWorkerButtonHightlited: SageReference<MappedImage>? = null,
    @SageIniName("IdleWorkerButtonPushed") val idleWorkerButtonPushed: SageReference<MappedImage>? = null,
    @SageIniName("MinMaxButtonEnable") val minMaxButtonEnable: SageReference<MappedImage>? = null,
    @SageIniName("MinMaxButtonHightlited") val minMaxButtonHightlited: SageReference<MappedImage>? = null,
    @SageIniName("MinMaxButtonPushed") val minMaxButtonPushed: SageReference<MappedImage>? = null,
    @SageIniName("MinMaxLR") val minMaxLR: Coord2DInt? = null,
    @SageIniName("MinMaxUL") val minMaxUL: Coord2DInt? = null,
    @SageIniName("MoneyLR") val moneyLR: Coord2DInt? = null,
    @SageIniName("MoneyUL") val moneyUL: Coord2DInt? = null,
    @SageIniName("OptionsButtonDisabled") val optionsButtonDisabled: SageReference<MappedImage>? = null,
    @SageIniName("OptionsButtonEnable") val optionsButtonEnable: SageReference<MappedImage>? = null,
    @SageIniName("OptionsButtonHightlited") val optionsButtonHightlited: SageReference<MappedImage>? = null,
    @SageIniName("OptionsButtonPushed") val optionsButtonPushed: SageReference<MappedImage>? = null,
    @SageIniName("OptionsLR") val optionsLR: Coord2DInt? = null,
    @SageIniName("OptionsUL") val optionsUL: Coord2DInt? = null,
    @SageIniName("PowerBarLR") val powerBarLR: Coord2DInt? = null,
    @SageIniName("PowerBarUL") val powerBarUL: Coord2DInt? = null,
    @SageIniName("PowerPurchaseImage") val powerPurchaseImage: SageReference<MappedImage>? = null,
    @SageIniName("QueueButtonImage") val queueButtonImage: SageReference<MappedImage>? = null,
    @SageIniName("RightHUDImage") val rightHUDImage: SageReference<MappedImage>? = null,
    @SageIniName("ToggleButtonDownIn") val toggleButtonDownIn: SageReference<MappedImage>? = null,
    @SageIniName("ToggleButtonDownOn") val toggleButtonDownOn: SageReference<MappedImage>? = null,
    @SageIniName("ToggleButtonDownPushed") val toggleButtonDownPushed: SageReference<MappedImage>? = null,
    @SageIniName("ToggleButtonUpIn") val toggleButtonUpIn: SageReference<MappedImage>? = null,
    @SageIniName("ToggleButtonUpOn") val toggleButtonUpOn: SageReference<MappedImage>? = null,
    @SageIniName("ToggleButtonUpPushed") val toggleButtonUpPushed: SageReference<MappedImage>? = null,
    @SageIniName("UAttackButtonEnable") val uAttackButtonEnable: SageReference<MappedImage>? = null,
    @SageIniName("UAttackButtonHightlited") val uAttackButtonHightlited: SageReference<MappedImage>? = null,
    @SageIniName("UAttackButtonPushed") val uAttackButtonPushed: SageReference<MappedImage>? = null,
    @SageIniName("UAttackLR") val uAttackLR: Coord2DInt? = null,
    @SageIniName("UAttackUL") val uAttackUL: Coord2DInt? = null,
    @SageIniName("WorkerLR") val workerLR: Coord2DInt? = null,
    @SageIniName("WorkerUL") val workerUL: Coord2DInt? = null,
    @SageIniName("ImagePart") val imagePart: List<ImagePart> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<ControlBarScheme>(
        name = "ControlBarScheme",
        tableKey = "controlbarschemes",
        properties = {
            property("ScreenCreationRes", Untyped.type) { it.screenCreationRes }
            property("Side", FakeToken.type) { it.side }
            property("CommandBarBorderColor", Rgba.type) { it.commandBarBorderColor }
            property("BuildUpClockColor", Rgba.type) { it.buildUpClockColor }
            property("ButtonBorderBuildColor", Rgba.type) { it.buttonBorderBuildColor }
            property("ButtonBorderActionColor", Rgba.type) { it.buttonBorderActionColor }
            property("ButtonBorderUpgradeColor", Rgba.type) { it.buttonBorderUpgradeColor }
            property("ButtonBorderSystemColor", Rgba.type) { it.buttonBorderSystemColor }
            property("ButtonBorderAlteredColor", Rgba.type) { it.buttonBorderAlteredColor }
            property("BeaconButtonDisabled", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.beaconButtonDisabled }
            property("BeaconButtonEnable", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.beaconButtonEnable }
            property("BeaconButtonHightlited", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.beaconButtonHightlited }
            property("BeaconButtonPushed", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.beaconButtonPushed }
            property("BeaconLR", Coord2DInt.type) { it.beaconLR }
            property("BeaconUL", Coord2DInt.type) { it.beaconUL }
            property("BuddyButtonDisabled", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.buddyButtonDisabled }
            property("BuddyButtonEnable", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.buddyButtonEnable }
            property("BuddyButtonHightlited", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.buddyButtonHightlited }
            property("BuddyButtonPushed", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.buddyButtonPushed }
            property("ChatLR", Coord2DInt.type) { it.chatLR }
            property("ChatUL", Coord2DInt.type) { it.chatUL }
            property("CommandMarkerImage", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.commandMarkerImage }
            property("ExpBarForegroundImage", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.expBarForegroundImage }
            property("GenArrow", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.genArrow }
            property("GenBarButtonIn", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.genBarButtonIn }
            property("GenBarButtonOn", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.genBarButtonOn }
            property("GeneralButtonDisabled", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.generalButtonDisabled }
            property("GeneralButtonEnable", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.generalButtonEnable }
            property("GeneralButtonHightlited", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.generalButtonHightlited }
            property("GeneralButtonPushed", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.generalButtonPushed }
            property("GeneralLR", Coord2DInt.type) { it.generalLR }
            property("GeneralUL", Coord2DInt.type) { it.generalUL }
            property("IdleWorkerButtonDisabled", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.idleWorkerButtonDisabled }
            property("IdleWorkerButtonEnable", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.idleWorkerButtonEnable }
            property("IdleWorkerButtonHightlited", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.idleWorkerButtonHightlited }
            property("IdleWorkerButtonPushed", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.idleWorkerButtonPushed }
            property("MinMaxButtonEnable", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.minMaxButtonEnable }
            property("MinMaxButtonHightlited", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.minMaxButtonHightlited }
            property("MinMaxButtonPushed", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.minMaxButtonPushed }
            property("MinMaxLR", Coord2DInt.type) { it.minMaxLR }
            property("MinMaxUL", Coord2DInt.type) { it.minMaxUL }
            property("MoneyLR", Coord2DInt.type) { it.moneyLR }
            property("MoneyUL", Coord2DInt.type) { it.moneyUL }
            property("OptionsButtonDisabled", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.optionsButtonDisabled }
            property("OptionsButtonEnable", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.optionsButtonEnable }
            property("OptionsButtonHightlited", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.optionsButtonHightlited }
            property("OptionsButtonPushed", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.optionsButtonPushed }
            property("OptionsLR", Coord2DInt.type) { it.optionsLR }
            property("OptionsUL", Coord2DInt.type) { it.optionsUL }
            property("PowerBarLR", Coord2DInt.type) { it.powerBarLR }
            property("PowerBarUL", Coord2DInt.type) { it.powerBarUL }
            property("PowerPurchaseImage", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.powerPurchaseImage }
            property("QueueButtonImage", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.queueButtonImage }
            property("RightHUDImage", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.rightHUDImage }
            property("ToggleButtonDownIn", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.toggleButtonDownIn }
            property("ToggleButtonDownOn", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.toggleButtonDownOn }
            property("ToggleButtonDownPushed", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.toggleButtonDownPushed }
            property("ToggleButtonUpIn", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.toggleButtonUpIn }
            property("ToggleButtonUpOn", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.toggleButtonUpOn }
            property("ToggleButtonUpPushed", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.toggleButtonUpPushed }
            property("UAttackButtonEnable", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.uAttackButtonEnable }
            property("UAttackButtonHightlited", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.uAttackButtonHightlited }
            property("UAttackButtonPushed", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.uAttackButtonPushed }
            property("UAttackLR", Coord2DInt.type) { it.uAttackLR }
            property("UAttackUL", Coord2DInt.type) { it.uAttackUL }
            property("WorkerLR", Coord2DInt.type) { it.workerLR }
            property("WorkerUL", Coord2DInt.type) { it.workerUL }
            property("ImagePart", ListValue(BlockValue<ImagePart> { listOf(ImagePart) })) { it.imagePart }
        },
    )
}
