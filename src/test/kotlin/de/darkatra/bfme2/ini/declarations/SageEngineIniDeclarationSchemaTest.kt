package de.darkatra.bfme2.ini.declarations

import de.darkatra.bfme2.ini.declarations.SageEngineIniDeclarationSchema.WordReference
import de.darkatra.bfme2.ini.model.SageIniModel
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SageEngineIniDeclarationSchemaTest {

    @Test
    fun `should return declaration kinds referenced by property`() {

        assertThat(SageEngineIniDeclarationSchema.expectedKindsForProperty("Armor"))
            .containsExactly("Armor")
        assertThat(SageEngineIniDeclarationSchema.expectedKindsForProperty("TriggeredBy"))
            .containsExactlyInAnyOrder("Upgrade", "Science")
    }

    @Test
    fun `should return no declaration kinds for unknown or missing property`() {

        assertThat(SageEngineIniDeclarationSchema.expectedKindsForProperty("UnknownProperty")).isEmpty()
        assertThat(SageEngineIniDeclarationSchema.expectedKindsForProperty(null)).isEmpty()
    }

    @Test
    fun `should recognize declaration kinds`() {

        assertThat(SageEngineIniDeclarationSchema.isDeclarationKind("Weapon")).isTrue()
        assertThat(SageEngineIniDeclarationSchema.isDeclarationKind("Object")).isTrue()
        assertThat(SageEngineIniDeclarationSchema.isDeclarationKind("NotARealDeclarationKind")).isFalse()
    }

    @Test
    fun `should preserve the existing weapon slot value exclusion`() {

        assertThat(SageEngineIniDeclarationSchema.expectedKindsForPropertyValue("Weapon", "PRIMARY")).isEmpty()
        assertThat(SageEngineIniDeclarationSchema.expectedKindsForPropertyValue("Weapon", "SomeWeaponName"))
            .containsExactly("Weapon")
    }

    @Test
    fun `should derive references from the model`() {

        assertThat(SageEngineIniDeclarationSchema.expectedKindsForProperty("ButtonImageName")).containsExactly("MappedImage")
        assertThat(SageEngineIniDeclarationSchema.expectedKindsForProperty("UpgradeObject")).contains("ObjectCreationList")
        assertThat(SageEngineIniDeclarationSchema.expectedKindsForProperty("InitialPayload")).containsExactlyInAnyOrder("Object", "ChildObject", "ObjectReskin")
        assertThat(SageEngineIniDeclarationSchema.expectedKindsForProperty("RadiusCursorType")).containsExactly("RadiusCursorTemplate")
        assertThat(SageEngineIniDeclarationSchema.expectedKindsForProperty("EvaEventDieOwner")).containsExactlyInAnyOrder("NewEvaEvent", "PredefinedEvaEvent")
    }

    @Test
    fun `should reference command buttons from numbered command set slots`() {

        assertThat(SageEngineIniDeclarationSchema.expectedKindsForProperty("1")).containsExactly("CommandButton")
    }

    @Test
    fun `should reference declarations from properties whose values are declaration names in the game files`() {

        mapOf(
            "Transition.FadeImage" to setOf("MappedImage"),
            "Transition.CrossFadeImage" to setOf("MappedImage"),
            "NotificationType.Icon" to setOf("MappedImage"),
            "GameData.BasicTutorialLoadScreenStillImage" to setOf("MappedImage"),
            "GameData.AdvancedTutorialLoadScreenStillImage" to setOf("MappedImage"),
            "Mission.LoadScreenImage" to setOf("MappedImage"),
            "InGameUI.TerrainResourceClaimDecal" to setOf("MappedImage"),
            "InGameUI.PlaceTerrainResourceClaimantDecal" to setOf("MappedImage"),
            "Upgrade.UnitSpecificSound" to setOf("AudioEvent"),
            "LivingWorldPlayerTemplate.AutoResolveLoop" to setOf("AudioEvent"),
            "PlayerTemplate.LoadScreenMusic" to setOf("Multisound"),
            "GameData.BasicTutorialLoadScreenMusicTrack" to setOf("Multisound"),
            "GameData.AdvancedTutorialLoadScreenMusicTrack" to setOf("Multisound"),
            "LivingWorldPlayerTemplate.Music" to setOf("Multisound"),
            "Mission.LoadScreenMusicTrack" to setOf("MusicTrack"),
            "LinearCampaign.OverallCampaignIntroMovie" to setOf("Video"),
            "Mission.IntroMovie" to setOf("Video"),
            "ArmyToSpawn.PalantirMovie" to setOf("Video"),
            "ScoredKillEvaAnnouncer.EvaEvent" to setOf("NewEvaEvent", "PredefinedEvaEvent"),
            "LivingWorldArmyIcon.RetreatTeleportToHomeRegionEvaEvent" to setOf("NewEvaEvent", "PredefinedEvaEvent"),
            "LivingWorldArmyIcon.RetreatTeleportToNonHomeRegionEvaEvent" to setOf("NewEvaEvent", "PredefinedEvaEvent"),
            "CreateObject.ForbiddenUpgrades" to setOf("Upgrade"),
            "CreateObject.ParticleSystem" to setOf("FXParticleSystem", "ParticleSystem"),
            "Fire.TerrainFireSystem" to setOf("FXParticleSystem", "ParticleSystem"),
            "Fire.TerrainSmokeSystem" to setOf("FXParticleSystem", "ParticleSystem"),
            "GameData.AutoFireParticleSmallSystem" to setOf("FXParticleSystem", "ParticleSystem"),
            "GameData.AutoFireParticleMediumSystem" to setOf("FXParticleSystem", "ParticleSystem"),
            "GameData.AutoFireParticleLargeSystem" to setOf("FXParticleSystem", "ParticleSystem"),
            "GameData.AutoSmokeParticleSmallSystem" to setOf("FXParticleSystem", "ParticleSystem"),
            "GameData.AutoSmokeParticleMediumSystem" to setOf("FXParticleSystem", "ParticleSystem"),
            "GameData.AutoSmokeParticleLargeSystem" to setOf("FXParticleSystem", "ParticleSystem"),
            "GameData.AutoAflameParticleSystem" to setOf("FXParticleSystem", "ParticleSystem"),
            "System.SlaveSystem" to setOf("FXParticleSystem", "ParticleSystem"),
            "System.PerParticleAttachedSystem" to setOf("FXParticleSystem", "ParticleSystem"),
            "LivingWorldMapInfo.AnimCloudPartSys" to setOf("FXParticleSystem", "ParticleSystem"),
            "LivingWorldMapInfo.EmbersPartSys" to setOf("FXParticleSystem", "ParticleSystem"),
            "W3DHordeModelDraw.WadingParticleSys" to setOf("FXParticleSystem", "ParticleSystem"),
            "W3DScriptedModelDraw.WadingParticleSys" to setOf("FXParticleSystem", "ParticleSystem"),
            "GameData.DefaultUnitHealingBuffFxList" to setOf("FXList"),
            "GameData.DefaultStructureRepairBuffFxList" to setOf("FXList"),
            "GameData.GenericDamageFieldName" to setOf("Object", "ChildObject", "ObjectReskin"),
            "GameData.SpecialPowerViewObject" to setOf("Object", "ChildObject", "ObjectReskin"),
            "BuffNugget.BuffShipTemplate" to setOf("Object", "ChildObject", "ObjectReskin"),
            "FormationAssistant.FacingArrowHeadTemplate" to setOf("Object", "ChildObject", "ObjectReskin"),
            "FormationAssistant.FacingArrowBodyTemplate" to setOf("Object", "ChildObject", "ObjectReskin"),
            "FormationAssistant.FacingArrowBaseTemplate" to setOf("Object", "ChildObject", "ObjectReskin"),
            "ArmyDefinition.ScavangedResourceBuildings" to setOf("Object", "ChildObject", "ObjectReskin"),
            "AIData.LowLodTreeName" to setOf("Object", "ChildObject", "ObjectReskin"),
            "AIData.LowLodTreeNameNoGrab" to setOf("Object", "ChildObject", "ObjectReskin"),
            "AIData.LowLodTreeNameNoHarvest" to setOf("Object", "ChildObject", "ObjectReskin"),
            "Object.ExperienceScalarTable" to setOf("ExperienceScalarTable"),
            "SpawnArmy.PalantirMovie" to setOf("Video"),
            "SpecialPower.PalantirMovie" to setOf("Video"),
            "FXParticleSystem.SlaveSystem" to setOf("FXParticleSystem", "ParticleSystem"),
            "FXParticleSystem.PerParticleAttachedSystem" to setOf("FXParticleSystem", "ParticleSystem"),
        ).forEach { (blockAndProperty, expectedKinds) ->
            val (blockName, propertyName) = blockAndProperty.split('.')
            val property = SageIniModel.blocks.firstNotNullOf { block -> block.property(propertyName)?.takeIf { block.name == blockName } }

            assertThat(SageEngineIniDeclarationSchema.referencedKinds(property)).describedAs(blockAndProperty).isEqualTo(expectedKinds)
        }
    }

    @Test
    fun `should only reference the audio kinds that the game files use`() {

        mapOf(
            "CommandButton.UnitSpecificSound" to setOf("AudioEvent", "Multisound"),
            "LivingWorldArmyIcon.KickOutReinforcementsSound" to setOf("AudioEvent", "Multisound"),
            "LivingWorldArmyIcon.WelcomeReinforcementsSound" to setOf("AudioEvent", "Multisound"),
            "MiscAudio.CreditsMusic" to setOf("Multisound"),
            "MiscAudio.FullScreenSubMenuMusic" to setOf("Multisound"),
            "MiscAudio.HighLODShellMusic" to setOf("Multisound"),
            "MiscAudio.LowLODShellMusic" to setOf("Multisound"),
            "MiscAudio.SaveFileLoadMusic" to setOf("Multisound"),
            "MiscAudio.ScoreScreenMusic" to setOf("MusicTrack"),
            "MiscAudio.VolumeSampleMovie" to setOf("DialogEvent"),
            "MiscAudio.VolumeSampleMusic" to setOf("MusicTrack"),
            "ModelConditionSpecialAbilityUpdate.TriggerSound" to setOf("AudioEvent", "Multisound"),
            "Multisound.Subsounds" to setOf("AudioEvent", "Multisound", "MusicTrack", "StreamedSound"),
            "Object.SoundAmbient" to setOf("AudioEvent", "Multisound", "AmbientStream"),
            "Object.SoundAmbientReallyDamaged" to setOf("AudioEvent", "Multisound"),
            "Object.SoundMoveLoop" to setOf("AudioEvent", "Multisound"),
            "Object.SoundOnDamaged" to setOf("AudioEvent", "Multisound"),
            "Object.SoundOnReallyDamaged" to setOf("AudioEvent", "Multisound"),
            "Object.VoiceAttack" to setOf("AudioEvent", "Multisound"),
            "Object.VoiceAttackAir" to setOf("AudioEvent", "Multisound"),
            "Object.VoiceAttackCharge" to setOf("AudioEvent", "Multisound"),
            "Object.VoiceAttackMachine" to setOf("AudioEvent", "Multisound"),
            "Object.VoiceAttackStructure" to setOf("AudioEvent", "Multisound"),
            "Object.VoiceCombineWithHorde" to setOf("AudioEvent", "Multisound"),
            "Object.VoiceCreated" to setOf("AudioEvent", "Multisound"),
            "Object.VoiceFear" to setOf("AudioEvent", "Multisound"),
            "Object.VoiceGuard" to setOf("AudioEvent", "Multisound"),
            "Object.VoiceMove" to setOf("AudioEvent", "Multisound"),
            "Object.VoiceMoveToCamp" to setOf("AudioEvent", "Multisound"),
            "Object.VoiceMoveWhileAttacking" to setOf("AudioEvent", "Multisound"),
            "Object.VoiceRetreatToCastle" to setOf("AudioEvent", "Multisound"),
            "Object.VoiceSelect" to setOf("AudioEvent", "Multisound"),
            "Object.VoiceSelectBattle" to setOf("AudioEvent", "Multisound"),
            "SideSound.Sound" to setOf("AudioEvent", "Multisound"),
            "SlowDeathBehavior.Sound" to setOf("AudioEvent", "Multisound"),
            "Sound.Name" to setOf("AudioEvent", "Multisound"),
            "SpecialAbilityUpdate.TriggerSound" to setOf("AudioEvent", "Multisound"),
            "SpecialPower.InitiateAtLocationSound" to setOf("AudioEvent", "Multisound"),
            "SpecialPower.InitiateSound" to setOf("AudioEvent", "Multisound"),
            "SpecialPowerModuleBehavior.InitiateSound" to setOf("AudioEvent", "Multisound"),
            "ToggleDeploySpecialAbilityUpdate.SoundDeploy" to setOf("Multisound"),
            "ToggleDeploySpecialAbilityUpdate.SoundUndeploy" to setOf("Multisound"),
            "UnitSpecificSounds.VoiceEnter" to setOf("AudioEvent", "Multisound"),
            "UnitSpecificSounds.VoiceEnterUnitEvilMenTransportShip" to setOf("AudioEvent", "Multisound"),
            "UnitSpecificSounds.VoiceEnterUnitMordorMumakil" to setOf("AudioEvent", "Multisound"),
            "UnitSpecificSounds.VoiceEnterUnitSlaughterHouse" to setOf("AudioEvent", "Multisound"),
            "UnitSpecificSounds.VoiceEnterUnitTransportShip" to setOf("AudioEvent", "Multisound"),
            "UnitSpecificSounds.VoiceGarrison" to setOf("AudioEvent", "Multisound"),
            "UnitSpecificSounds.VoiceInitiateCaptureBuilding" to setOf("AudioEvent", "Multisound"),
            "UnitSpecificSounds.VoiceSelectIdleWorker" to setOf("AudioEvent", "Multisound"),
            "Upgrade.ResearchSound" to setOf("AudioEvent", "Multisound"),
            "WeaponModeSpecialPowerUpdate.InitiateSound" to setOf("Multisound"),
            "WeatherData.WeatherSound" to setOf("Multisound", "StreamedSound"),
            "_SoundSet.VoiceAttack" to setOf("AudioEvent", "Multisound"),
            "_SoundSet.VoiceAttackCharge" to setOf("AudioEvent", "Multisound"),
            "_SoundSet.VoiceMove" to setOf("AudioEvent", "Multisound"),
            "_SoundSet.VoiceSelect" to setOf("AudioEvent", "Multisound"),
            "_SoundSet.VoiceSelectBattle" to setOf("AudioEvent", "Multisound"),
        ).forEach { (blockAndProperty, expectedKinds) ->
            val (blockName, propertyName) = blockAndProperty.split('.')
            val property = SageIniModel.blocks.firstNotNullOf { block -> block.property(propertyName)?.takeIf { block.name == blockName } }

            assertThat(SageEngineIniDeclarationSchema.referencedKinds(property)).describedAs(blockAndProperty).isEqualTo(expectedKinds)
        }
    }

    @Test
    fun `should only reference declarations at the positions or keys of struct components that are references`() {

        val particleSystem = WordReference(setOf("FXParticleSystem", "ParticleSystem"))
        val objectCreationList = WordReference(setOf("ObjectCreationList"))

        assertThat(wordReferences("ModelConditionState", "ParticleSysBone", "B_SWORDBONE LightningCharge FollowBone:Yes"))
            .containsExactly(null, particleSystem, null)
        assertThat(wordReferences("DetachableRiderUpdate", "DeathEntry", "AnimState:DEATH_2 AnimTime:3000 RiderOCL:OCL_RohirrimSpawnDeadRider"))
            .containsExactly(null, null, objectCreationList.copy(nameOffset = 9))
        assertThat(wordReferences("StructureCollapseUpdate", "OCL", "INITIAL OCL_StructureRubblePileLarge"))
            .containsExactly(null, objectCreationList)
        assertThat(wordReferences("StructureCollapseUpdate", "OCL", "OCL_StructureRubblePileLarge"))
            .containsExactly(objectCreationList)
        assertThat(wordReferences("WeaponSet", "Weapon", "PRIMARY ElvenEliteArcherSword"))
            .containsExactly(null, WordReference(setOf("Weapon")))
    }

    @Test
    fun `should reference declarations with the words the engine reads as references`() {

        val fxList = WordReference(setOf("FXList"))
        val upgrade = WordReference(setOf("Upgrade"))

        assertThat(wordReferences("StructureToppleUpdate", "AngleFX", "20.0 FX_StructureToppleAngle20")).containsExactly(null, fxList)
        assertThat(wordReferences("RubbleRiseUpdate", "FXList", "INITIAL FX_StructureMediumPostCollapse")).containsExactly(null, fxList)
        assertThat(wordReferences("CitadelSlaughterHordeContain", "UpgradeForRingEntry", "Upgrade_RingHero Upgrade_FortressRingHero"))
            .containsExactly(upgrade, upgrade)
        assertThat(wordReferences("ModifierList", "Upgrade", "Upgrade_GenericObjectTypeOn")).containsExactly(upgrade)
        assertThat(wordReferences("ModifierList", "Upgrade", "Upgrade_Drafted Delay:0")).containsExactly(upgrade, null)
        assertThat(wordReferences("W3DTruckDraw", "WadingParticleSys", "EntRipples"))
            .containsExactly(WordReference(setOf("FXParticleSystem", "ParticleSystem")))
    }

    @Test
    fun `should reference eva events with sounds that start with the eva prefix`() {

        assertThat(wordReferences("Object", "VoiceFullyCreated", "EVA:GenericBuildingComplete-Builder"))
            .containsExactly(WordReference(setOf("NewEvaEvent", "PredefinedEvaEvent"), nameOffset = 4))
    }

    @Test
    fun `should reference the audio kinds the game files use`() {

        assertThat(wordReferences("Object", "SoundAmbient", "AmbientShireStream"))
            .containsExactly(WordReference(setOf("AudioEvent", "Multisound", "AmbientStream")))
        assertThat(wordReferences("ModelConditionAudioLoopClientBehavior", "ModelCondition", "Required:FIRING_OR_PREATTACK_A Sound:DragonAllyFirebreathMS"))
            .containsExactly(null, WordReference(setOf("AudioEvent", "Multisound"), nameOffset = 6))
        assertThat(wordReferences("Multisound", "Subsounds", "DarknessStereoLoop"))
            .containsExactly(WordReference(setOf("AudioEvent", "Multisound", "MusicTrack", "StreamedSound")))
        assertThat(wordReferences("WeatherData", "WeatherSound", "RainStereoLoop"))
            .containsExactly(WordReference(setOf("Multisound", "StreamedSound")))
    }

    @Test
    fun `should reference the declaration kinds the game files use`() {

        assertThat(wordReferences("InvisibilityUpdate", "UnitSpecificSoundNameToUseAsVoiceMoveToStealthyArea", "VoiceMoveToTrees")).containsExactly(null)
        assertThat(wordReferences("ReplaceSelfUpgrade", "AndThenAddA", "GondorCastleWallHub"))
            .containsExactly(WordReference(setOf("Object", "ChildObject", "ObjectReskin")))
    }

    @Test
    fun `should not reference declarations with the separators of alternatives`() {

        val science = WordReference(setOf("Science"))

        assertThat(wordReferences("Science", "PrerequisiteSciences", "SCIENCE_GOOD OR SCIENCE_MEN"))
            .containsExactly(science, null, science)
    }

    @Test
    fun `should not reference declarations with words that stand for no value`() {

        assertThat(wordReferences("WeaponSet", "Weapon", "PRIMARY None")).containsExactly(null, null)
        assertThat(wordReferences("ArmorSet", "Armor", "NONE")).containsExactly(null)
        assertThat(wordReferences("CommandButton", "UnitSpecificSound", "NoSound")).containsExactly(null)
    }

    @Test
    fun `should only reference declarations with the first word of single values`() {

        assertThat(wordReferences("CommandButton", "SpecialPower", "SpecialAbilityAragornAthelas Unused"))
            .containsExactly(WordReference(setOf("SpecialPower")), null)
    }

    private fun wordReferences(blockName: String, propertyName: String, value: String): List<WordReference?> {
        val property = SageIniModel.blocks.firstNotNullOf { block -> block.property(propertyName)?.takeIf { block.name == blockName } }
        return SageEngineIniDeclarationSchema.wordReferences(property.type, value.split(' '))
    }

    @Test
    fun `should treat top level particle system definitions as declarations`() {

        assertThat(SageEngineIniDeclarationSchema.isDeclarationKind("ParticleSystem")).isTrue()
    }

    @Test
    fun `should match property names by their exact name`() {

        assertThat(SageEngineIniDeclarationSchema.expectedKindsForProperty("Armor")).containsExactly("Armor")
        assertThat(SageEngineIniDeclarationSchema.expectedKindsForProperty("armor")).isEmpty()
    }

    @Test
    fun `should not reference declarations with enum tokens of structured values`() {

        assertThat(SageEngineIniDeclarationSchema.expectedKindsForPropertyValue("Weapon", "secondary")).isEmpty()
    }

    @Test
    fun `should not treat non-declaration blocks as declaration kinds`() {

        assertThat(SageEngineIniDeclarationSchema.isDeclarationKind("Sound")).isFalse()
        assertThat(SageEngineIniDeclarationSchema.isDeclarationKind("ArmorSet")).isFalse()
        assertThat(SageEngineIniDeclarationSchema.isDeclarationKind("Animation")).isFalse()
        assertThat(SageEngineIniDeclarationSchema.isDeclarationKind("ChildObject")).isTrue()
    }
}
