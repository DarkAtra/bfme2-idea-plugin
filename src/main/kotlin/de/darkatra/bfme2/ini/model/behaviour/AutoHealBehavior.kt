package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.`object`.UpgradeTrigger
import de.darkatra.bfme2.ini.model.value.KindOf
import de.darkatra.bfme2.ini.model.value.SageReference

data class AutoHealBehavior(
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
    @SageIniName("ForbiddenKindOf") val forbiddenKindOf: List<KindOf> = emptyList(),
    @SageIniName("SkipSelfForHealing") val skipSelfForHealing: Boolean = false,
    @SageIniName("ButtonTriggered") val buttonTriggered: Boolean = false,
    @SageIniName("SingleBurst") val singleBurst: Boolean = false,
    @SageIniName("HealingAmount") val healingAmount: Int = 0,
    @SageIniName("HealingDelay") val healingDelay: Int = 0,
    @SageIniName("Radius") val radius: Int = 0,
    @SageIniName("KindOf") val kindOf: List<KindOf> = emptyList(),
    @SageIniName("StartHealingDelay") val startHealingDelay: Int = 0,
    @SageIniName("AffectsWholePlayer") val affectsWholePlayer: Boolean = false,
    @SageIniName("AffectsContained") val affectsContained: Boolean = false,
    @SageIniName("HealOnlyIfNotUnderAttack") val healOnlyIfNotUnderAttack: Boolean = false,
    @SageIniName("HealOnlyIfNotInCombat") val healOnlyIfNotInCombat: Boolean = false,
    @SageIniName("HealOnlyOthers") val healOnlyOthers: Boolean = false,
    @SageIniName("NonStackable") val nonStackable: Boolean = false,
    @SageIniName("RespawnNearbyHordeMembers") val respawnNearbyHordeMembers: Boolean = false,
    @SageIniName("RespawnMinimumDelay") val respawnMinimumDelay: Int = 0,
    @SageIniName("UnitHealPulseFX") val unitHealPulseFX: SageReference<FXList>? = null,
    @SageIniName("RespawnFXList") val respawnFXList: SageReference<FXList>? = null,
) : UpgradeBehavior() {

    companion object : SageIniBlockDescriptor<AutoHealBehavior>(
        name = "AutoHealBehavior",
        parent = UpgradeBehavior,
        properties = {
            property("ForbiddenKindOf", ListValue(KindOf.type)) { it.forbiddenKindOf }
            property("SkipSelfForHealing", BooleanValue) { it.skipSelfForHealing }
            property("ButtonTriggered", BooleanValue) { it.buttonTriggered }
            property("SingleBurst", BooleanValue) { it.singleBurst }
            property("HealingAmount", IntValue) { it.healingAmount }
            property("HealingDelay", IntValue) { it.healingDelay }
            property("Radius", IntValue) { it.radius }
            property("KindOf", ListValue(KindOf.type)) { it.kindOf }
            property("StartHealingDelay", IntValue) { it.startHealingDelay }
            property("AffectsWholePlayer", BooleanValue) { it.affectsWholePlayer }
            property("AffectsContained", BooleanValue) { it.affectsContained }
            property("HealOnlyIfNotUnderAttack", BooleanValue) { it.healOnlyIfNotUnderAttack }
            property("HealOnlyIfNotInCombat", BooleanValue) { it.healOnlyIfNotInCombat }
            property("HealOnlyOthers", BooleanValue) { it.healOnlyOthers }
            property("NonStackable", BooleanValue) { it.nonStackable }
            property("RespawnNearbyHordeMembers", BooleanValue) { it.respawnNearbyHordeMembers }
            property("RespawnMinimumDelay", IntValue) { it.respawnMinimumDelay }
            property("UnitHealPulseFX", ReferenceValue<FXList> { listOf(FXList) }) { it.unitHealPulseFX }
            property("RespawnFXList", ReferenceValue<FXList> { listOf(FXList) }) { it.respawnFXList }
        },
    )
}
