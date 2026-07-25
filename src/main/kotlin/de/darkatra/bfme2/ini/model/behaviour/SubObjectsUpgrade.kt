package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.`object`.UpgradeTrigger
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageReference

data class SubObjectsUpgrade(
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
    @SageIniName("FXListUpgrade") val fXListUpgrade: SageReference<FXList>? = null,
    @SageIniName("FadeTimeInSeconds") val fadeTimeInSeconds: Double = 0.0,
    @SageIniName("WaitBeforeFadeInSeconds") val waitBeforeFadeInSeconds: Double = 0.0,
    @SageIniName("RecolorHouse") val recolorHouse: Boolean = false,
    @SageIniName("SkipFadeOnCreate") val skipFadeOnCreate: Boolean = false,
    @SageIniName("HideSubObjectsOnRemove") val hideSubObjectsOnRemove: Boolean = false,
    @SageIniName("UnHideSubObjectsOnRemove") val unHideSubObjectsOnRemove: Boolean = false,
    @SageIniName("ShowSubObjects") val showSubObjects: List<Opaque> = emptyList(),
    @SageIniName("HideSubObjects") val hideSubObjects: List<Opaque> = emptyList(),
    @SageIniName("UpgradeTexture") val upgradeTexture: List<List<String>> = emptyList(),
    @SageIniName("ExcludeSubobjects") val excludeSubobjects: List<Opaque> = emptyList(),
) : UpgradeBehavior() {

    companion object : SageIniBlockDescriptor<SubObjectsUpgrade>(
        name = "SubObjectsUpgrade",
        parent = UpgradeBehavior,
        properties = {
            property("FXListUpgrade", ReferenceValue<FXList> { listOf(FXList) }) { it.fXListUpgrade }
            property("FadeTimeInSeconds", FloatValue) { it.fadeTimeInSeconds }
            property("WaitBeforeFadeInSeconds", FloatValue) { it.waitBeforeFadeInSeconds }
            property("RecolorHouse", BooleanValue) { it.recolorHouse }
            property("SkipFadeOnCreate", BooleanValue) { it.skipFadeOnCreate }
            property("HideSubObjectsOnRemove", BooleanValue) { it.hideSubObjectsOnRemove }
            property("UnHideSubObjectsOnRemove", BooleanValue) { it.unHideSubObjectsOnRemove }
            property("ShowSubObjects", ListValue(Opaque.type)) { it.showSubObjects }
            property("HideSubObjects", ListValue(Opaque.type)) { it.hideSubObjects }
            property("UpgradeTexture", ListValue(ListValue(StringValue))) { it.upgradeTexture }
            property("ExcludeSubobjects", ListValue(Opaque.type)) { it.excludeSubobjects }
        },
    )
}
