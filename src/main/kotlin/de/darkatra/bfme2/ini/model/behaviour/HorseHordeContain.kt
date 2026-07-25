package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.`object`.ModifierList
import de.darkatra.bfme2.ini.model.`object`.Object
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

data class HorseHordeContain(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ObjectStatusOfContained") override val objectStatusOfContained: List<ObjectStatus> = emptyList(),
    @SageIniName("InitialPayload") override val initialPayload: List<ObjectCount> = emptyList(),
    @SageIniName("Slots") override val slots: Int = 0,
    @SageIniName("PassengerFilter") override val passengerFilter: SageFilter? = null,
    @SageIniName("ShowPips") override val showPips: Boolean = false,
    @SageIniName("ThisFormationIsTheMainFormation") override val thisFormationIsTheMainFormation: Boolean = false,
    @SageIniName("BannerCarriersAllowed") override val bannerCarriersAllowed: List<SageReference<Object>> = emptyList(),
    @SageIniName("BannerCarrierPosition") override val bannerCarrierPosition: List<BannerCarrierPosition> = emptyList(),
    @SageIniName("RankInfo") override val rankInfo: List<RankInfo> = emptyList(),
    @SageIniName("RanksToReleaseWhenAttacking") override val ranksToReleaseWhenAttacking: List<Int> = emptyList(),
    @SageIniName("ComboHordes") override val comboHordes: List<ComboHorde> = emptyList(),
    @SageIniName("ComboHorde") override val comboHorde: List<ComboHorde> = emptyList(),
    @SageIniName("UseSlowHordeMovement") override val useSlowHordeMovement: Boolean = false,
    @SageIniName("MeleeAttackLeashDistance") override val meleeAttackLeashDistance: Int = 0,
    @SageIniName("MachineAllowed") override val machineAllowed: Boolean = false,
    @SageIniName("MachineType") override val machineType: SageReference<Object>? = null,
    @SageIniName("AlternateFormation") override val alternateFormation: SageReference<Object>? = null,
    @SageIniName("BackUpMinDelayTime") override val backUpMinDelayTime: Int = 0,
    @SageIniName("BackUpMaxDelayTime") override val backUpMaxDelayTime: Int = 0,
    @SageIniName("BackUpMinDistance") override val backUpMinDistance: Int = 0,
    @SageIniName("BackUpMaxDistance") override val backUpMaxDistance: Int = 0,
    @SageIniName("BackupPercentage") override val backupPercentage: Double = 0.0,
    @SageIniName("AttributeModifiers") override val attributeModifiers: List<SageReference<ModifierList>> = emptyList(),
    @SageIniName("RanksThatStopAdvance") override val ranksThatStopAdvance: List<Int> = emptyList(),
    @SageIniName("RanksToJustFreeWhenAttacking") override val ranksToJustFreeWhenAttacking: List<Int> = emptyList(),
    @SageIniName("NotComboFormation") override val notComboFormation: Boolean = false,
    @SageIniName("UsePorcupineBody") override val usePorcupineBody: Boolean = false,
    @SageIniName("SplitHorde") override val splitHorde: List<Map<String, String>> = emptyList(),
    @SageIniName("UseMarchingAnims") override val useMarchingAnims: Boolean = false,
    @SageIniName("ForcedLocomotorSet") override val forcedLocomotorSet: LocomotorSetType? = null,
    @SageIniName("UpdateWeaponSetFlagsOnHordeToo") override val updateWeaponSetFlagsOnHordeToo: Boolean = false,
    @SageIniName("RankSplit") override val rankSplit: Boolean = false,
    @SageIniName("SplitHordeNumber") override val splitHordeNumber: Int = 0,
    @SageIniName("FrontAngle") override val frontAngle: Double = 0.0,
    @SageIniName("FlankedDelay") override val flankedDelay: Int = 0,
    @SageIniName("IsPorcupineFormation") override val isPorcupineFormation: Boolean = false,
    @SageIniName("MinimumHordeSize") override val minimumHordeSize: Int = 0,
    @SageIniName("VisionRearOverride") override val visionRearOverride: Double = 0.0,
    @SageIniName("VisionSideOverride") override val visionSideOverride: Double = 0.0,
    @SageIniName("BannerCarrierMinLevel") override val bannerCarrierMinLevel: Int = 0,
    @SageIniName("BannerCarrierDestroyHordeOnDeath") override val bannerCarrierDestroyHordeOnDeath: Boolean = false,
    @SageIniName("BannerCarrierHordeDeathType") override val bannerCarrierHordeDeathType: SageFilter? = null,
    @SageIniName("LivingWorldOverloadTemplate") override val livingWorldOverloadTemplate: SageReference<Object>? = null,
    @SageIniName("ConditionForEntry") override val conditionForEntry: ContainCondition? = null,
    @SageIniName("RandomOffset") override val randomOffset: Coords? = null,
    @SageIniName("MeleeBehavior") override val meleeBehavior: List<MeleeBehavior> = emptyList(),
) : HordeContain() {

    companion object : SageIniBlockDescriptor<HorseHordeContain>(
        name = "HorseHordeContain",
        parent = HordeContain,
    )
}
