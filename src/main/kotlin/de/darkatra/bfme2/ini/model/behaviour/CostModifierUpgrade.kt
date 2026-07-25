package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.`object`.UpgradeTrigger
import de.darkatra.bfme2.ini.model.value.KindOf
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class CostModifierUpgrade(
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
    @SageIniName("LabelForPalantirString") val labelForPalantirString: String = "",
    @SageIniName("UpgradeDiscount") val upgradeDiscount: Boolean = false,
    @SageIniName("ApplyToTheseUpgrades") val applyToTheseUpgrades: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("EffectKindOf") val effectKindOf: KindOf? = null,
    @SageIniName("Percentage") val percentage: List<Double> = emptyList(),
    @SageIniName("ObjectFilter") val objectFilter: SageFilter? = null,
    @SageIniName("Slaughter") val slaughter: Boolean = false,
) : UpgradeBehavior() {

    companion object : SageIniBlockDescriptor<CostModifierUpgrade>(
        name = "CostModifierUpgrade",
        parent = UpgradeBehavior,
        properties = {
            property("LabelForPalantirString", StringValue) { it.labelForPalantirString }
            property("UpgradeDiscount", BooleanValue) { it.upgradeDiscount }
            property("ApplyToTheseUpgrades", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.applyToTheseUpgrades }
            property("EffectKindOf", KindOf.type) { it.effectKindOf }
            property("Percentage", ListValue(FloatValue)) { it.percentage }
            property("ObjectFilter", SageFilter.type) { it.objectFilter }
            property("Slaughter", BooleanValue) { it.slaughter }
        },
    )
}
