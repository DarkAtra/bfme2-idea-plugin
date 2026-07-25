package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageReference

data class CreateAHeroSystem(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("CreateAHeroMapModeUpgradeName") val createAHeroMapModeUpgradeName: SageReference<Upgrade>? = null,
    @SageIniName("CreateAHeroGameModeUpgradeName") val createAHeroGameModeUpgradeName: SageReference<Upgrade>? = null,
    @SageIniName("CanBuildCreateAHeroUpgradeName") val canBuildCreateAHeroUpgradeName: SageReference<Upgrade>? = null,
    @SageIniName("CommandSetTemplate") val commandSetTemplate: SageReference<CommandSet>? = null,
    @SageIniName("WeaponGroupName") val weaponGroupName: String = "",
    @SageIniName("StratigicDefeatStatName") val stratigicDefeatStatName: String = "",
    @SageIniName("StratigicVictoryStatName") val stratigicVictoryStatName: String = "",
    @SageIniName("StratigicMPDefeatStatName") val stratigicMPDefeatStatName: String = "",
    @SageIniName("StratigicMPVictoryStatName") val stratigicMPVictoryStatName: String = "",
    @SageIniName("SkirmishDefeatStatName") val skirmishDefeatStatName: String = "",
    @SageIniName("SkirmishVictoryStatName") val skirmishVictoryStatName: String = "",
    @SageIniName("OpenPlayDefeatStatName") val openPlayDefeatStatName: String = "",
    @SageIniName("OpenPlayVictoryStatName") val openPlayVictoryStatName: String = "",
    @SageIniName("StratigicCampainVictoryStatName") val stratigicCampainVictoryStatName: String = "",
    @SageIniName("SelectedCheerAninName") val selectedCheerAninName: String = "",
    @SageIniName("ExamineWeaponAninName") val examineWeaponAninName: String = "",
    @SageIniName("ExamineSelfAninName") val examineSelfAninName: String = "",
    @SageIniName("SpecialAnimPercentChance") val specialAnimPercentChance: Double = 0.0,
    @SageIniName("CreateAHeroClass") val createAHeroClass: Opaque? = null,
    @SageIniName("ExamineAnimTweakValue") val examineAnimTweakValue: Int = 0,
    @SageIniName("HeroRevivalDiscount") val heroRevivalDiscount: Double = 0.0,
    @SageIniName("SpecialPowerDiscountPerLevel") val specialPowerDiscountPerLevel: Double = 0.0,
    @SageIniName("CreateAHeroBling") val createAHeroBling: List<CreateAHeroBling> = emptyList(),
    @SageIniName("CreateAHeroBlingBinder") val createAHeroBlingBinder: List<CreateAHeroBlingBinder> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<CreateAHeroSystem>(
        name = "CreateAHeroSystem",
        tableKey = "createaherosystems",
        properties = {
            property("CreateAHeroMapModeUpgradeName", ReferenceValue<Upgrade> { listOf(Upgrade) }) { it.createAHeroMapModeUpgradeName }
            property("CreateAHeroGameModeUpgradeName", ReferenceValue<Upgrade> { listOf(Upgrade) }) { it.createAHeroGameModeUpgradeName }
            property("CanBuildCreateAHeroUpgradeName", ReferenceValue<Upgrade> { listOf(Upgrade) }) { it.canBuildCreateAHeroUpgradeName }
            property("CommandSetTemplate", ReferenceValue<CommandSet> { listOf(CommandSet) }) { it.commandSetTemplate }
            property("WeaponGroupName", StringValue) { it.weaponGroupName }
            property("StratigicDefeatStatName", StringValue) { it.stratigicDefeatStatName }
            property("StratigicVictoryStatName", StringValue) { it.stratigicVictoryStatName }
            property("StratigicMPDefeatStatName", StringValue) { it.stratigicMPDefeatStatName }
            property("StratigicMPVictoryStatName", StringValue) { it.stratigicMPVictoryStatName }
            property("SkirmishDefeatStatName", StringValue) { it.skirmishDefeatStatName }
            property("SkirmishVictoryStatName", StringValue) { it.skirmishVictoryStatName }
            property("OpenPlayDefeatStatName", StringValue) { it.openPlayDefeatStatName }
            property("OpenPlayVictoryStatName", StringValue) { it.openPlayVictoryStatName }
            property("StratigicCampainVictoryStatName", StringValue) { it.stratigicCampainVictoryStatName }
            property("SelectedCheerAninName", StringValue) { it.selectedCheerAninName }
            property("ExamineWeaponAninName", StringValue) { it.examineWeaponAninName }
            property("ExamineSelfAninName", StringValue) { it.examineSelfAninName }
            property("SpecialAnimPercentChance", FloatValue) { it.specialAnimPercentChance }
            property("CreateAHeroClass", Opaque.type) { it.createAHeroClass }
            property("ExamineAnimTweakValue", IntValue) { it.examineAnimTweakValue }
            property("HeroRevivalDiscount", FloatValue) { it.heroRevivalDiscount }
            property("SpecialPowerDiscountPerLevel", FloatValue) { it.specialPowerDiscountPerLevel }
            property("CreateAHeroBling", ListValue(BlockValue<CreateAHeroBling> { listOf(CreateAHeroBling) })) { it.createAHeroBling }
            property("CreateAHeroBlingBinder", ListValue(BlockValue<CreateAHeroBlingBinder> { listOf(CreateAHeroBlingBinder) })) { it.createAHeroBlingBinder }
        },
    )
}
