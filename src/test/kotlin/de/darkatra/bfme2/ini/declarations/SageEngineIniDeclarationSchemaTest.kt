package de.darkatra.bfme2.ini.declarations

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
            "CreateObject.ParticleSystem" to setOf("FXParticleSystem"),
            "Fire.TerrainFireSystem" to setOf("FXParticleSystem"),
            "Fire.TerrainSmokeSystem" to setOf("FXParticleSystem"),
            "GameData.AutoFireParticleSmallSystem" to setOf("FXParticleSystem"),
            "GameData.AutoFireParticleMediumSystem" to setOf("FXParticleSystem"),
            "GameData.AutoFireParticleLargeSystem" to setOf("FXParticleSystem"),
            "GameData.AutoSmokeParticleSmallSystem" to setOf("FXParticleSystem"),
            "GameData.AutoSmokeParticleMediumSystem" to setOf("FXParticleSystem"),
            "GameData.AutoSmokeParticleLargeSystem" to setOf("FXParticleSystem"),
            "GameData.AutoAflameParticleSystem" to setOf("FXParticleSystem"),
            "System.SlaveSystem" to setOf("FXParticleSystem"),
            "System.PerParticleAttachedSystem" to setOf("FXParticleSystem"),
            "LivingWorldMapInfo.AnimCloudPartSys" to setOf("FXParticleSystem"),
            "LivingWorldMapInfo.EmbersPartSys" to setOf("FXParticleSystem"),
            "W3DHordeModelDraw.WadingParticleSys" to setOf("FXParticleSystem"),
            "W3DScriptedModelDraw.WadingParticleSys" to setOf("FXParticleSystem"),
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
            "FXParticleSystem.SlaveSystem" to setOf("FXParticleSystem"),
            "FXParticleSystem.PerParticleAttachedSystem" to setOf("FXParticleSystem"),
        ).forEach { (blockAndProperty, expectedKinds) ->
            val (blockName, propertyName) = blockAndProperty.split('.')
            val property = SageIniModel.blocks.first { it.name == blockName }.property(propertyName)!!

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
            "Multisound.Subsounds" to setOf("AudioEvent", "Multisound", "MusicTrack"),
            "Object.SoundAmbient" to setOf("AudioEvent", "Multisound"),
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
            "WeatherData.WeatherSound" to setOf("Multisound"),
            "_SoundSet.VoiceAttack" to setOf("AudioEvent", "Multisound"),
            "_SoundSet.VoiceAttackCharge" to setOf("AudioEvent", "Multisound"),
            "_SoundSet.VoiceMove" to setOf("AudioEvent", "Multisound"),
            "_SoundSet.VoiceSelect" to setOf("AudioEvent", "Multisound"),
            "_SoundSet.VoiceSelectBattle" to setOf("AudioEvent", "Multisound"),
        ).forEach { (blockAndProperty, expectedKinds) ->
            val (blockName, propertyName) = blockAndProperty.split('.')
            val property = SageIniModel.blocks.first { it.name == blockName }.property(propertyName)!!

            assertThat(SageEngineIniDeclarationSchema.referencedKinds(property)).describedAs(blockAndProperty).isEqualTo(expectedKinds)
        }
    }

    @Test
    fun `should match property names case-insensitively`() {

        assertThat(SageEngineIniDeclarationSchema.expectedKindsForProperty("armor")).containsExactly("Armor")
    }

    @Test
    fun `should not reference declarations with enum tokens of structured values`() {

        assertThat(SageEngineIniDeclarationSchema.expectedKindsForPropertyValue("Weapon", "secondary")).isEmpty()
    }

    @Test
    fun `should not treat non-declaration blocks as declaration kinds`() {

        assertThat(SageEngineIniDeclarationSchema.isDeclarationKind("ParticleSystem")).isFalse()
        assertThat(SageEngineIniDeclarationSchema.isDeclarationKind("Sound")).isFalse()
        assertThat(SageEngineIniDeclarationSchema.isDeclarationKind("ArmorSet")).isFalse()
        assertThat(SageEngineIniDeclarationSchema.isDeclarationKind("Animation")).isFalse()
        assertThat(SageEngineIniDeclarationSchema.isDeclarationKind("ChildObject")).isTrue()
    }
}
