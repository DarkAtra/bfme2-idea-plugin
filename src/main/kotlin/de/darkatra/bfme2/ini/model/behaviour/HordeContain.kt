package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.MapValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.ModifierList
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.value.BannerCarrierPosition
import de.darkatra.bfme2.ini.model.value.ComboHorde
import de.darkatra.bfme2.ini.model.value.ContainCondition
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.LocomotorSetType
import de.darkatra.bfme2.ini.model.value.ObjectCount
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.RankInfo
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

open class HordeContain(
    open val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ObjectStatusOfContained") open val objectStatusOfContained: List<ObjectStatus> = emptyList(),
    @SageIniName("InitialPayload") open val initialPayload: List<ObjectCount> = emptyList(),
    @SageIniName("Slots") open val slots: Int = 0,
    @SageIniName("PassengerFilter") open val passengerFilter: SageFilter? = null,
    @SageIniName("ShowPips") open val showPips: Boolean = false,
    @SageIniName("ThisFormationIsTheMainFormation") open val thisFormationIsTheMainFormation: Boolean = false,
    @SageIniName("BannerCarriersAllowed") open val bannerCarriersAllowed: List<SageReference<Object>> = emptyList(),
    @SageIniName("BannerCarrierPosition") open val bannerCarrierPosition: List<BannerCarrierPosition> = emptyList(),
    @SageIniName("RankInfo") open val rankInfo: List<RankInfo> = emptyList(),
    @SageIniName("RanksToReleaseWhenAttacking") open val ranksToReleaseWhenAttacking: List<Int> = emptyList(),
    @SageIniName("ComboHordes") open val comboHordes: List<ComboHorde> = emptyList(),
    @SageIniName("ComboHorde") open val comboHorde: List<ComboHorde> = emptyList(),
    @SageIniName("UseSlowHordeMovement") open val useSlowHordeMovement: Boolean = false,
    @SageIniName("MeleeAttackLeashDistance") open val meleeAttackLeashDistance: Int = 0,
    @SageIniName("MachineAllowed") open val machineAllowed: Boolean = false,
    @SageIniName("MachineType") open val machineType: SageReference<Object>? = null,
    @SageIniName("AlternateFormation") open val alternateFormation: SageReference<Object>? = null,
    @SageIniName("BackUpMinDelayTime") open val backUpMinDelayTime: Int = 0,
    @SageIniName("BackUpMaxDelayTime") open val backUpMaxDelayTime: Int = 0,
    @SageIniName("BackUpMinDistance") open val backUpMinDistance: Int = 0,
    @SageIniName("BackUpMaxDistance") open val backUpMaxDistance: Int = 0,
    @SageIniName("BackupPercentage") open val backupPercentage: Double = 0.0,
    @SageIniName("AttributeModifiers") open val attributeModifiers: List<SageReference<ModifierList>> = emptyList(),
    @SageIniName("RanksThatStopAdvance") open val ranksThatStopAdvance: List<Int> = emptyList(),
    @SageIniName("RanksToJustFreeWhenAttacking") open val ranksToJustFreeWhenAttacking: List<Int> = emptyList(),
    @SageIniName("NotComboFormation") open val notComboFormation: Boolean = false,
    @SageIniName("UsePorcupineBody") open val usePorcupineBody: Boolean = false,
    @SageIniName("SplitHorde") open val splitHorde: List<Map<String, String>> = emptyList(),
    @SageIniName("UseMarchingAnims") open val useMarchingAnims: Boolean = false,
    @SageIniName("ForcedLocomotorSet") open val forcedLocomotorSet: LocomotorSetType? = null,
    @SageIniName("UpdateWeaponSetFlagsOnHordeToo") open val updateWeaponSetFlagsOnHordeToo: Boolean = false,
    @SageIniName("RankSplit") open val rankSplit: Boolean = false,
    @SageIniName("SplitHordeNumber") open val splitHordeNumber: Int = 0,
    @SageIniName("FrontAngle") open val frontAngle: Double = 0.0,
    @SageIniName("FlankedDelay") open val flankedDelay: Int = 0,
    @SageIniName("IsPorcupineFormation") open val isPorcupineFormation: Boolean = false,
    @SageIniName("MinimumHordeSize") open val minimumHordeSize: Int = 0,
    @SageIniName("VisionRearOverride") open val visionRearOverride: Double = 0.0,
    @SageIniName("VisionSideOverride") open val visionSideOverride: Double = 0.0,
    @SageIniName("BannerCarrierMinLevel") open val bannerCarrierMinLevel: Int = 0,
    @SageIniName("BannerCarrierDestroyHordeOnDeath") open val bannerCarrierDestroyHordeOnDeath: Boolean = false,
    @SageIniName("BannerCarrierHordeDeathType") open val bannerCarrierHordeDeathType: SageFilter? = null,
    @SageIniName("LivingWorldOverloadTemplate") open val livingWorldOverloadTemplate: SageReference<Object>? = null,
    @SageIniName("ConditionForEntry") open val conditionForEntry: ContainCondition? = null,
    @SageIniName("RandomOffset") open val randomOffset: Coords? = null,
    @SageIniName("MeleeBehavior") open val meleeBehavior: List<MeleeBehavior> = emptyList(),
) : SageBehavior {

    companion object : SageIniBlockDescriptor<HordeContain>(
        name = "HordeContain",
        properties = {
            property("ObjectStatusOfContained", ListValue(ObjectStatus.type)) { it.objectStatusOfContained }
            property("InitialPayload", ListValue(ObjectCount.type)) { it.initialPayload }
            property("Slots", IntValue) { it.slots }
            property("PassengerFilter", SageFilter.type) { it.passengerFilter }
            property("ShowPips", BooleanValue) { it.showPips }
            property("ThisFormationIsTheMainFormation", BooleanValue) { it.thisFormationIsTheMainFormation }
            property("BannerCarriersAllowed", ListValue(ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) })) { it.bannerCarriersAllowed }
            property("BannerCarrierPosition", ListValue(BannerCarrierPosition.type)) { it.bannerCarrierPosition }
            property("RankInfo", ListValue(RankInfo.type)) { it.rankInfo }
            property("RanksToReleaseWhenAttacking", ListValue(IntValue)) { it.ranksToReleaseWhenAttacking }
            property("ComboHordes", ListValue(ComboHorde.type)) { it.comboHordes }
            property("ComboHorde", ListValue(ComboHorde.type)) { it.comboHorde }
            property("UseSlowHordeMovement", BooleanValue) { it.useSlowHordeMovement }
            property("MeleeAttackLeashDistance", IntValue) { it.meleeAttackLeashDistance }
            property("MachineAllowed", BooleanValue) { it.machineAllowed }
            property("MachineType", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.machineType }
            property("AlternateFormation", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.alternateFormation }
            property("BackUpMinDelayTime", IntValue) { it.backUpMinDelayTime }
            property("BackUpMaxDelayTime", IntValue) { it.backUpMaxDelayTime }
            property("BackUpMinDistance", IntValue) { it.backUpMinDistance }
            property("BackUpMaxDistance", IntValue) { it.backUpMaxDistance }
            property("BackupPercentage", FloatValue) { it.backupPercentage }
            property("AttributeModifiers", ListValue(ReferenceValue<ModifierList> { listOf(ModifierList) })) { it.attributeModifiers }
            property("RanksThatStopAdvance", ListValue(IntValue)) { it.ranksThatStopAdvance }
            property("RanksToJustFreeWhenAttacking", ListValue(IntValue)) { it.ranksToJustFreeWhenAttacking }
            property("NotComboFormation", BooleanValue) { it.notComboFormation }
            property("UsePorcupineBody", BooleanValue) { it.usePorcupineBody }
            property("SplitHorde", ListValue(MapValue(StringValue, StringValue))) { it.splitHorde }
            property("UseMarchingAnims", BooleanValue) { it.useMarchingAnims }
            property("ForcedLocomotorSet", LocomotorSetType.type) { it.forcedLocomotorSet }
            property("UpdateWeaponSetFlagsOnHordeToo", BooleanValue) { it.updateWeaponSetFlagsOnHordeToo }
            property("RankSplit", BooleanValue) { it.rankSplit }
            property("SplitHordeNumber", IntValue) { it.splitHordeNumber }
            property("FrontAngle", FloatValue) { it.frontAngle }
            property("FlankedDelay", IntValue) { it.flankedDelay }
            property("IsPorcupineFormation", BooleanValue) { it.isPorcupineFormation }
            property("MinimumHordeSize", IntValue) { it.minimumHordeSize }
            property("VisionRearOverride", FloatValue) { it.visionRearOverride }
            property("VisionSideOverride", FloatValue) { it.visionSideOverride }
            property("BannerCarrierMinLevel", IntValue) { it.bannerCarrierMinLevel }
            property("BannerCarrierDestroyHordeOnDeath", BooleanValue) { it.bannerCarrierDestroyHordeOnDeath }
            property("BannerCarrierHordeDeathType", SageFilter.type) { it.bannerCarrierHordeDeathType }
            property("LivingWorldOverloadTemplate", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.livingWorldOverloadTemplate }
            property("ConditionForEntry", ContainCondition.type) { it.conditionForEntry }
            property("RandomOffset", Coords.type) { it.randomOffset }
            property("MeleeBehavior", ListValue(BlockValue<MeleeBehavior> { listOf(MeleeBehavior) })) { it.meleeBehavior }
        },
    )
}
