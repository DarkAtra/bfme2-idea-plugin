package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.MapValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.`object`.Science
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.`object`.UpgradeTrigger
import de.darkatra.bfme2.ini.model.`object`.Weapon
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class FireWeaponWhenDamagedBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("StartsActive") val startsActive: Boolean = false,
    @SageIniName("ReactionWeaponPristine") val reactionWeaponPristine: SageReference<Weapon>? = null,
    @SageIniName("ReactionWeaponDamaged") val reactionWeaponDamaged: SageReference<Weapon>? = null,
    @SageIniName("ReactionWeaponReallyDamaged") val reactionWeaponReallyDamaged: SageReference<Weapon>? = null,
    @SageIniName("ReactionWeaponRubble") val reactionWeaponRubble: SageReference<Weapon>? = null,
    @SageIniName("ContinuousWeaponPristine") val continuousWeaponPristine: SageReference<Weapon>? = null,
    @SageIniName("ContinuousWeaponDamaged") val continuousWeaponDamaged: SageReference<Weapon>? = null,
    @SageIniName("ContinuousWeaponReallyDamaged") val continuousWeaponReallyDamaged: SageReference<Weapon>? = null,
    @SageIniName("ContinuousWeaponRubble") val continuousWeaponRubble: SageReference<Weapon>? = null,
    @SageIniName("DamageTypes") val damageTypes: SageFilter? = null,
    @SageIniName("DamageAmount") val damageAmount: Double = 0.0,
    @SageIniName("TriggeredBy") val triggeredBy: List<SageReference<UpgradeTrigger>> = emptyList(),
    @SageIniName("ConflictsWith") val conflictsWith: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("RequiresAllTriggers") val requiresAllTriggers: Boolean = false,
    @SageIniName("RequiresAllConflictingTriggers") val requiresAllConflictingTriggers: Boolean = false,
    @SageIniName("Permanent") val permanent: Boolean = false,
    @SageIniName("CustomAnimAndDuration") val customAnimAndDuration: Map<String, String> = emptyMap(),
) : SageBehavior {

    companion object : SageIniBlockDescriptor<FireWeaponWhenDamagedBehavior>(
        name = "FireWeaponWhenDamagedBehavior",
        properties = {
            property("StartsActive", BooleanValue) { it.startsActive }
            property("ReactionWeaponPristine", ReferenceValue<Weapon> { listOf(Weapon) }) { it.reactionWeaponPristine }
            property("ReactionWeaponDamaged", ReferenceValue<Weapon> { listOf(Weapon) }) { it.reactionWeaponDamaged }
            property("ReactionWeaponReallyDamaged", ReferenceValue<Weapon> { listOf(Weapon) }) { it.reactionWeaponReallyDamaged }
            property("ReactionWeaponRubble", ReferenceValue<Weapon> { listOf(Weapon) }) { it.reactionWeaponRubble }
            property("ContinuousWeaponPristine", ReferenceValue<Weapon> { listOf(Weapon) }) { it.continuousWeaponPristine }
            property("ContinuousWeaponDamaged", ReferenceValue<Weapon> { listOf(Weapon) }) { it.continuousWeaponDamaged }
            property("ContinuousWeaponReallyDamaged", ReferenceValue<Weapon> { listOf(Weapon) }) { it.continuousWeaponReallyDamaged }
            property("ContinuousWeaponRubble", ReferenceValue<Weapon> { listOf(Weapon) }) { it.continuousWeaponRubble }
            property("DamageTypes", SageFilter.type) { it.damageTypes }
            property("DamageAmount", FloatValue) { it.damageAmount }
            property("TriggeredBy", ListValue(ReferenceValue<UpgradeTrigger> { listOf(Upgrade, Science) })) { it.triggeredBy }
            property("ConflictsWith", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.conflictsWith }
            property("RequiresAllTriggers", BooleanValue) { it.requiresAllTriggers }
            property("RequiresAllConflictingTriggers", BooleanValue) { it.requiresAllConflictingTriggers }
            property("Permanent", BooleanValue) { it.permanent }
            property("CustomAnimAndDuration", MapValue(StringValue, StringValue)) { it.customAnimAndDuration }
        },
    )
}
