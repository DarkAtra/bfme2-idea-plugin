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
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class SpellRechargeModifierUpgrade(
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
    @SageIniName("ObjectFilter") val objectFilter: SageFilter? = null,
    @SageIniName("UpgradeDiscount") val upgradeDiscount: Boolean = false,
    @SageIniName("ApplyToTheseUpgrades") val applyToTheseUpgrades: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("Slaughter") val slaughter: Boolean = false,
    @SageIniName("Percentage") val percentage: Double = 0.0,
    @SageIniName("Float") val float: Double = 0.0,
) : UpgradeBehavior() {

    companion object : SageIniBlockDescriptor<SpellRechargeModifierUpgrade>(
        name = "SpellRechargeModifierUpgrade",
        parent = UpgradeBehavior,
        properties = {
            property("LabelForPalantirString", StringValue) { it.labelForPalantirString }
            property("ObjectFilter", SageFilter.type) { it.objectFilter }
            property("UpgradeDiscount", BooleanValue) { it.upgradeDiscount }
            property("ApplyToTheseUpgrades", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.applyToTheseUpgrades }
            property("Slaughter", BooleanValue) { it.slaughter }
            property("Percentage", FloatValue) { it.percentage }
            property("Float", FloatValue) { it.float }
        },
    )
}
