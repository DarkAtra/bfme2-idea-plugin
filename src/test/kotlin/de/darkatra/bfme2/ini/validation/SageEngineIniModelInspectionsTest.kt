package de.darkatra.bfme2.ini.validation

import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase
import org.junit.Test

class SageEngineIniModelInspectionsTest : LightPlatformCodeInsightFixture4TestCase() {

    @Test
    fun `should report unknown properties of known blocks`() {

        myFixture.enableInspections(SageEngineIniUnknownPropertyInspection())
        myFixture.configureByText(
            "object.ini",
            """
            Object ElvenMallornTree
                BuildCost = 100
                <warning descr="Unknown property 'buildcost' in 'Object'">buildcost</warning> = 100
                <warning descr="Unknown property 'BuildCots' in 'Object'">BuildCots</warning> = 100
                Behavior = AutoHealBehavior ModuleTag_Heal
                    HealingAmount = 5
                    <warning descr="Unknown property 'BuildCost' in 'AutoHealBehavior'">BuildCost</warning> = 5
                End
            End
            CommandSet ElvenMallornTreeCommandSet
                1 = Command_ConstructElvenWarrior
            End
            UnknownBlock Foo
                Whatever = 1
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should report unknown blocks and modules`() {

        myFixture.enableInspections(SageEngineIniUnknownBlockInspection())
        myFixture.configureByText(
            "object.ini",
            """
            Object ElvenMallornTree
                ArmorSet
                    Armor = TreeArmor
                End
                <warning descr="Unknown block 'ArmorSett' in 'Object'">ArmorSett</warning>
                End
                Behavior = AutoHealBehavior ModuleTag_Heal
                End
                Behavior = <warning descr="Unknown module 'AutoHealBehaviour' for 'Behavior'">AutoHealBehaviour</warning> ModuleTag_Heal
                End
                Draw = W3DModelDraw ModuleTag_Draw
                    ModelConditionState = DAMAGED
                    End
                End
            End
            <warning descr="Unknown block 'Objekt'">Objekt</warning> Foo
                Unknown
                End
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should report missing and forbidden equals signs of object properties`() {

        myFixture.enableInspections(SageEngineIniEqualsSignInspection())
        myFixture.configureByText(
            "object.ini",
            """
            Object IsengardUrukCrossbow
                <warning descr="'CommandSet' requires '=' in 'Object'">CommandSet</warning> IsengardUrukCrossbowCommandSet
                <warning descr="'GeometryContactPoint' requires '=' in 'Object'">GeometryContactPoint</warning> X:0 Y:0 Z:112 Swoop
                <warning descr="'Scale' requires '=' in 'Object'">Scale</warning> 1.15
                DisplayName = OBJECT:IsengardArcher
                RemoveModule ModuleTag_Death
                RemoveModule <warning descr="'RemoveModule' must be written without '='">=</warning> ModuleTag_Death
            End
            ChildObject CaveTroll_Huge CaveTroll
                <warning descr="'Scale' requires '=' in 'ChildObject'">Scale</warning> 1.75
                RemoveModule ModuleTag_ConstructionDeath
            End
            StanceTemplate FighterHorde
                Stance Aggressive
                    AttributeModifier FighterHordeStanceAggressive
                End
            End
            ControlBarScheme Mordor
                Side Mordor
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should report properties without value`() {

        myFixture.enableInspections(SageEngineIniMissingValueInspection(), SageEngineIniEqualsSignInspection())
        myFixture.configureByText(
            "object.ini",
            """
            Object AngmarHallOfTwilight
                <warning descr="'GeometryName' has no value">GeometryName</warning>			;= Geom_Orig
                <warning descr="'SelectPortrait' has no value">SelectPortrait</warning> =
                DisplayName = OBJECT:AngmarHallOfTwilight
                KindOf =
            End
            Weapon ElvenBow
                ClearNuggets
            End
            Credits
                Blank
                Text = "CREDITS:DevelopmentTitle1"
            End
            UnknownBlock Foo
                Blank
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should report empty value lists`() {

        myFixture.enableInspections(SageEngineIniEmptyValueListInspection())
        myFixture.configureByText(
            "object.ini",
            """
            Object AngmarHallOfTwilight
                <weak_warning descr="'KindOf' has an empty value list, which has no effect">KindOf =</weak_warning>
                KindOf = STRUCTURE
                SelectPortrait =
            End
            Credits
                Blank
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, true)
    }

    @Test
    fun `should report properties outside of blocks`() {

        myFixture.enableInspections(SageEngineIniPropertyOutsideBlockInspection())
        myFixture.configureByText(
            "credits.ini",
            """
            ;Credits
                <warning descr="'ScrollRate' is outside of a block">ScrollRate</warning> = 1
                <warning descr="'Blank' is outside of a block">Blank</warning>
            BenchProfile = P4 2189 6.108187 15.113676 9.402223
            ReallyLowMHz = 1200
            EvaEventForwardReference DiscoveredRing
            Object ElvenMallornTree
                DisplayName = OBJECT:ElvenMallornTree
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should not report properties at the top level of included files`() {

        myFixture.enableInspections(SageEngineIniPropertyOutsideBlockInspection())
        myFixture.configureByText("productionbuilding.inc", "BuildCost = 100")

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should report block keywords and module types with wrong casing`() {

        myFixture.enableInspections(SageEngineIniUnknownBlockInspection())
        myFixture.configureByText(
            "object.ini",
            """
            <warning descr="Unknown block 'object'">object</warning> ElvenMallornTree
            End
            Object ElvenMallornTree
                Behavior = <warning descr="Unknown module 'autohealbehavior' for 'Behavior'">autohealbehavior</warning> ModuleTag_Heal
                End
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should know the properties of top level particle system definitions`() {

        myFixture.enableInspections(SageEngineIniUnknownPropertyInspection(), SageEngineIniUnknownBlockInspection(), SageEngineIniInvalidValueInspection())
        myFixture.configureByText(
            "particlesystem.ini",
            """
            ParticleSystem StructureFireGlow
                Priority = AREA_EFFECT
                IsOneShot = No
                Shader = ADDITIVE
                Type = PARTICLE
                ParticleName = EXLnzFlar2.tga
                AngleZ = -0.10 0.10
                Gravity = 0.00
                SystemLifetime = 0
                Alpha1 = 0.00 0.00 0
                Color1 = R:96 G:46 B:0 0
                DriftVelocity = X:0.000 Y:0.000 Z:0.000
                VelocityType = OUTWARD
                VolumeType = CYLINDER
                VolCylinderRadius = 8.000
                WindMotion = PingPong
                WindPingPongEndAngleMax = 6.283185
                <warning descr="Unknown property 'AngelZ' in 'ParticleSystem'">AngelZ</warning> = 0.00 0.00
            End
            FXList FX_RainOfFireImpact
                ParticleSystem
                    Name = RainOfFireImpactLight
                    Count = 1
                End
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should know system blocks that are nested or declared without a name`() {

        myFixture.enableInspections(SageEngineIniUnknownBlockInspection(), SageEngineIniUnknownPropertyInspection())
        myFixture.configureByText(
            "system.ini",
            """
            MeshNameMatches GBBarracks_SKN.Spear
                Instances = 10
            End
            Weather
                SnowEnabled = yes
                LightningFactor = 0.5 1.0
                RampSpeed = X:150.0 Y:250.0
            End
            LargeGroupAudioMap SmallFireLoop
                Sound SmallFireLoop
                    Sound = FireSmallAmbientLoop
                    Key = BurningCell
                    <warning descr="Unknown property 'Kye' in 'Sound'">Kye</warning> = BurningCell
                End
                Size = 100
            End
            StrategicHUD
                Checklist
                    ItemNormalColor = R:255 G:255 B:0 A:255
                End
                CancelArmyMoveButton
                    Image = Strategic_CancelMoveBlue
                    Title = STRATEGICHUD:CancelArmyMemberMoveTitle
                End
                TypeImages
                    UnitHero = Archetype_Hero
                End
            End
            AIData
                AttackPriority DefaultAttackPriority
                    Default = 35
                End
            End
            Object Tornado
                Draw = W3DTornadoDraw ModuleTag_TornadoDraw
                    DecalTemplate
                        Texture = EXTornadoGround
                        OpacityMin = 5%
                    End
                End
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should know properties that the base game uses in special powers, sound sets and system blocks`() {

        myFixture.enableInspections(SageEngineIniUnknownPropertyInspection())
        myFixture.configureByText(
            "object.ini",
            """
            Object Azog
                Behavior = LevelGrantSpecialPower ModuleTag_LevelGrant
                    TriggerAttributeModifier = CreateAHeroChargeBonus_Level1
                    AttributeModifierDuration = 20000
                    Instant = Yes
                End
                Behavior = DominateEnemySpecialPower ModuleTag_Dominate
                    PackTime = 233
                End
                Behavior = OCLSpecialPower ModuleTag_OCL
                    IdleWhenStartingPower = Yes
                End
                Behavior = CurseSpecialPower ModuleTag_Curse
                    ApproachRequiresLOS = No
                End
                Behavior = ModelConditionSpecialAbilityUpdate ModuleTag_ModelCondition
                    TriggerAttributeModifier = Rider1Tracker
                    AttributeModifierDuration = 10000
                    FreezeAfterTriggerDuration = 500
                    TriggerModelCondition = ModelConditionState:SPECIAL_POWER_1
                    TriggerModelConditionDuration = 10
                End
                Behavior = TeleportSpecialAbilityUpdate ModuleTag_Teleport
                    TriggerAttributeModifier = NoldorWeaponSong
                    AttributeModifierDuration = 2000
                End
                Behavior = ArrowStormUpdate ModuleTag_ArrowStorm
                    TriggerAttributeModifier = NoldorWeaponSong
                    AttributeModifierDuration = 2000
                End
                Behavior = SpecialDisguiseUpdate ModuleTag_Disguise
                    TriggerAttributeModifier = NoldorWeaponSong
                    AttributeModifierDuration = 2000
                End
                Behavior = AODHordeContain ModuleTag_Contain
                    EvaEventLastMemberDeath = OathbreakerDismiss
                End
                ClientBehavior = UpgradeSoundSelectorClientBehavior ModuleTag_UpgradeSoundSelector
                    SoundUpgrade = Upgrade_DwarvenSiegeHammer
                        VoiceEnterStateAttack = DwarfGuardianVoiceEnterStateAttackHammer
                        VoiceEnterStateAttackMachine = DwarfGuardianVoiceEnterStateAttackHammer
                        VoiceEnterStateAttackStructure = DwarfGuardianVoiceEnterStateAttackHammer
                        VoiceEnterStateRetreatToCastle = DwarfGuardianVoiceEnterStateAttackHammer
                    End
                End
            End
            ButtonSet DefaultButtonSet
                Mode = Queue
                1 = Blank NULL NULL
            End
            AutoResolveReinforcementSchedule Defender
                1 = 0
                2 = 15
                EachRemaining = +1
            End
            OptionGroup UserOptions
                Bool Render.UseCloudMap = No
                Int Render.ParticleFXCount = 21000
                String QuickMatch.IPAddress = 1.2.3.4
                Real SlowDeathScale = 1.0
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should resolve modules at the top level of included files by their type`() {

        myFixture.enableInspections(SageEngineIniUnknownPropertyInspection())
        myFixture.configureByText(
            "createaherorespawn.inc",
            """
            Body = RespawnBody ModuleTag_RespawnBody
                CheerRadius = 100
                MaxHealth = 500
                <warning descr="Unknown property 'MaxHealht' in 'RespawnBody'">MaxHealht</warning> = 500
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should know nested blocks and properties that the updated base game uses`() {

        myFixture.enableInspections(SageEngineIniUnknownBlockInspection(), SageEngineIniUnknownPropertyInspection())
        myFixture.configureByText(
            "object.ini",
            """
            Object Tower
                Behavior = DynamicShroudClearingRangeUpdate ModuleTag_Grid
                    GridDecalTemplate
                        Texture = EXGrid
                        OpacityThrobTime = 500
                    End
                End
                Behavior = LevelGrantSpecialPower ModuleTag_LevelGrant
                    ApproachRequiresLOS = No
                    IgnoreFacingCheck = Yes
                End
            End
            AIData
                SkirmishBuildList Gondor
                    Structure GondorBarracks
                        Location = X:863.19 Y:1151.87
                        Rebuilds = 0
                    END
                End
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should know unit specific voices named after an object`() {

        myFixture.enableInspections(SageEngineIniUnknownPropertyInspection())
        myFixture.configureByText(
            "lugthemauled.ini",
            """
            Object WildLugTheMauled
                UnitSpecificSounds
                    VoiceAttackUnitWildAzog = LugVoiceAttackBolgAzog
                    VoiceEnterUnitMordorMumakil = LugVoiceMoveGarrison
                    VoiceEnterUnitElvenTransportShip = LugVoiceMoveGarrison
                    <warning descr="Unknown property 'VoiceAttackUniWildLugtheMauled' in 'UnitSpecificSounds'">VoiceAttackUniWildLugtheMauled</warning> = LugVoiceAttackLug
                    <warning descr="Unknown property 'VoiceExit' in 'UnitSpecificSounds'">VoiceExit</warning> = LugVoiceAttackLug
                End
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should know the properties that special powers inherit in the engine`() {

        myFixture.enableInspections(SageEngineIniUnknownPropertyInspection())
        myFixture.configureByText(
            "object.ini",
            """
            Object RhunFortress
                Behavior = ActivateModuleSpecialPower ModuleTag_Activate
                    PersistentPrepTime = 0
                    AwardXPForTriggering = 0
                    Instant = Yes
                    TriggerSound = RhunFortressTrigger
                    FreezeAfterTriggerDuration = 1000
                    ParalyzeDurationWhenCompleted = 500
                    NeedCollisionBeforeTrigger = No
                    ApproachUntilMembersInRange = No
                    ApproachRequiresLOS = No
                    MustFinishAbility = Yes
                    RequiredConditions = None
                    TriggerAttributeModifier = NoldorWeaponSong
                    AttributeModifierDuration = 2000
                End
                Behavior = OCLSpecialPower ModuleTag_OCL
                    UseDistanceFromCommandCenter = Yes
                    DistanceFromCommandCenter = 300
                    <warning descr="Unknown property 'TriggerAttributeModifier' in 'OCLSpecialPower'">TriggerAttributeModifier</warning> = NoldorWeaponSong
                End
                Behavior = SpecialPowerModule ModuleTag_Module
                    GiveLevels = 1
                    WeatherDuration = 1000
                End
                Behavior = ModelConditionSpecialAbilityUpdate ModuleTag_ModelCondition
                    PersistentCount = 3
                End
                Behavior = HordeSiegeEngineContain ModuleTag_Contain
                    CrewAllowedToFire = Yes
                    <warning descr="Unknown property 'TransferSelection' in 'HordeSiegeEngineContain'">TransferSelection</warning> = Yes
                End
                Behavior = TransportContain ModuleTag_Transport
                    ShouldThrowOutPassengers = Yes
                End
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should know properties that the engine declares for tank draws, player templates and scenarios`() {

        myFixture.enableInspections(SageEngineIniUnknownPropertyInspection())
        myFixture.configureByText(
            "object.ini",
            """
            Object ElvenNimrodelHorde
                Draw = W3DTankDraw ModuleTag_01
                    StaticModelLODMode = No
                    WadingParticleSys = WaterRipplesTrail
                    DependencySharedModelFlags = None
                    TreadAnimationRate = 1.0
                End
            End
            PlayerTemplate FactionMen
                StartingUnit6 = MenCitadel
                StartingUnitOffset6 = X:1 Y:130 Z:0
                StartingUnit9 = MenCitadel
                StartingUnitOffset9 = X:1 Y:130 Z:0
            End
            LivingWorldCampaign WOTRScenario
                Scenario
                    UseMpRulesVictoryCondition = No
                End
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should know properties that the engine declares for contains, draws and nuggets`() {

        myFixture.enableInspections(SageEngineIniUnknownPropertyInspection())
        myFixture.configureByText(
            "object.ini",
            """
            Object GondorTower
                Behavior = HordeTransportContain ModuleTag_01
                    DeathTypes = ALL
                    ThrowOutPassengersDelay = 100
                End
                Behavior = HordeGarrisonContain ModuleTag_02
                    ShowPips = Yes
                    <warning descr="Unknown property 'Slots' in 'HordeGarrisonContain'">Slots</warning> = 2
                End
                Draw = W3DScriptedModelDraw ModuleTag_03
                    RecoilDamping = 0.4
                End
            End
            FXList FX_GondorTower
                AttachedModel
                    Weather = SNOWY
                    StopIfNuggetPlayed = Yes
                End
            End
            Weapon GondorTowerArrow
                DamageNugget
                    FlankedScalar = 50%
                End
            End
            ObjectCreationList OCL_GondorTower
                CreateObject
                    InheritsVeterancy = Yes
                End
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should know properties that modules inherit from their engine base`() {

        myFixture.enableInspections(SageEngineIniUnknownPropertyInspection())
        myFixture.configureByText(
            "object.ini",
            """
            Object GondorSoldiers
                Behavior = HordeContain ModuleTag_01
                    ThrowOutPassengersDelay = 100
                    LeaderRank = 1
                End
                Behavior = ToggleDeploySpecialAbilityUpdate ModuleTag_02
                    PreparationTime = 100
                End
                Behavior = SlaughterHordeContain ModuleTag_03
                    EntryOffset = X:0 Y:0 Z:0
                End
                Draw = W3DSupplyDraw ModuleTag_04
                    StaticModelLODMode = No
                End
                Body = ActiveBody ModuleTag_05
                    RemoveUpgradesOnDeath = Yes
                End
            End
            ObjectCreationList OCL_GondorSoldiers
                Attack
                    NumberOfShots = 2
                    <warning descr="Unknown property 'AnimationName' in 'Attack'">AnimationName</warning> = Attack
                End
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should recommend declaration names without special characters`() {

        myFixture.enableInspections(SageEngineIniSpecialCharacterNameInspection())
        myFixture.configureByText(
            "heroui.ini",
            """
            MappedImage <weak_warning descr="'HPTheodenKing'sFavor' contains the special character ''', names with only letters, digits, '_' and '-' are easier to work with">HPTheodenKing'sFavor</weak_warning>
            End
            FXList <weak_warning descr="'FX_Furnace&Longhouse+' contains the special characters '&' and '+', names with only letters, digits, '_' and '-' are easier to work with">FX_Furnace&Longhouse+</weak_warning>
            End
            NewEvaEvent GenericBuildingComplete-Builder
            End
            ControlBarResizer ControlBar.wnd:ButtonLarge
            End
            InGameUI
                RadiusCursorTemplate = <weak_warning descr="'Rain(Of)Fire' contains the special characters '(' and ')', names with only letters, digits, '_' and '-' are easier to work with">Rain(Of)Fire</weak_warning>
                End
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(false, false, true)
    }

    @Test
    fun `should accept model condition flags written with their state prefix`() {

        myFixture.enableInspections(SageEngineIniInvalidValueInspection())
        myFixture.configureByText(
            "object.ini",
            """
            Object Sauron
                Behavior = ModelConditionSpecialAbilityUpdate ModuleTag_ModelCondition
                    TriggerModelCondition = ModelConditionState:SPECIAL_WEAPON_THREE
                End
                Behavior = WeaponFireSpecialAbilityUpdate ModuleTag_WeaponFire
                    TriggerModelCondition = ModelConditionState : SPECIAL_POWER_1
                End
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should accept enum values that the base game uses`() {

        myFixture.enableInspections(SageEngineIniInvalidValueInspection())
        myFixture.configureByText(
            "object.ini",
            """
            Object AngmarNecromancer
                WeaponSet
                    Conditions = WEAPONSET_TOGGLE_3
                End
            End
            CombatChainDefinition SupportCombatChain
                Unit = SUPPORT
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should not report top level blocks of included files`() {

        myFixture.enableInspections(SageEngineIniUnknownBlockInspection())
        myFixture.configureByText(
            "productionbuilding.inc",
            """
            Behavior = AutoHealBehavior ModuleTag_Heal
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should not report repeated entries of list properties`() {

        myFixture.enableInspections(SageEngineIniRepeatedPropertyInspection())
        myFixture.configureByText(
            "animation2d.ini",
            """
            Animation DefaultHeal
                Image = SCPCross000
                Image = SCPCross001
            End
            Object GandalfStaffBeam
                <warning descr="'BuildCost' is set again later, only the last value takes effect">BuildCost</warning> = 0
                BuildCost = 10
                Draw = W3DLaserDraw ModuleTag_01
                    Texture = EXGandalfStaffBeam_00001.tga
                    Texture = EXGandalfStaffBeam_00002.tga
                End
            End
            LinearCampaign GOOD_CAMPAIGN
                CarryoverUnit = ElvenGlorfindel
                CarryoverUnit = DwarvenGloin
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should report repeated properties`() {

        myFixture.enableInspections(SageEngineIniRepeatedPropertyInspection())
        myFixture.configureByText(
            "object.ini",
            """
            Object ElvenMallornTree
                <warning descr="'BuildCost' is set again later, only the last value takes effect">BuildCost</warning> = 100
                BuildCost = 200
                KindOf = STRUCTURE
                KindOf = IMMOBILE
                GeometryContactPoint = X:0 Y:0 Z:0 Swoop
                GeometryContactPoint = X:10 Y:0 Z:0 Swoop
                ShadowTexture = ShadowA
                ShadowTexture = ShadowB
                Unknown = 1
                Unknown = 2
                Behavior = AutoHealBehavior ModuleTag_Heal
                    HealingAmount = 5
                End
                Behavior = AutoHealBehavior ModuleTag_Heal2
                    HealingAmount = 5
                End
            End
            CommandSet ElvenMallornTreeCommandSet
                <warning descr="'1' is set again later, only the last value takes effect">1</warning> = Command_ConstructElvenWarrior
                1 = Command_ConstructElvenArcher
                2 = Command_ConstructElvenWarrior
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should report spurious block labels`() {

        myFixture.enableInspections(SageEngineIniSpuriousBlockLabelInspection())
        myFixture.configureByText(
            "object.ini",
            """
            Object ElvenMallornTree
                ThreatBreakdown ElvenMallornTree_ThreatBreakdown
                End
                ThreatBreakdown <warning descr="'ThreatBreakdown' takes a plain header, the engine ignores the '='">=</warning> ElvenMallornTree_ThreatBreakdown
                End
                Draw = W3DModelDraw ModuleTag_Draw
                    ModelConditionState = DAMAGED
                    End
                End
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should report invalid values`() {

        myFixture.enableInspections(SageEngineIniInvalidValueInspection())
        myFixture.configureByText(
            "object.ini",
            """
            #define MALLORN_COST 100
            #define MALLORN_KINDOF STRUCTURE IMMOBILE
            Object ElvenMallornTree
                BuildCost = 100
                BuildCost = -5
                BuildCost = 50%
                BuildCost = 1.5
                BuildCost = 8.07921e+33
                BuildCost = MALLORN_COST
                BuildCost = MACRO_OF_THE_BASE_GAME
                BuildCost = #MULTIPLY( MALLORN_COST 2 )
                BuildCost = <warning descr="Expected a number but found '12abc'">12abc</warning>
                BuildCost = <warning descr="Expected a number but found '1.2.3'">1.2.3</warning>
                KindOf = STRUCTURE IMMOBILE ; a comment
                KindOf = MALLORN_KINDOF SELECTABLE
                KindOf = mallorn_kindof
                KindOf = NONE
                KindOf = STRUCTURE <warning descr="Unknown KindOf 'STRUCTUR'">STRUCTUR</warning>
                Behavior = AutoHealBehavior ModuleTag_Heal
                    SingleBurst = yes
                    SingleBurst = <warning descr="Expected Yes or No but found '1'">1</warning>
                End
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should report command map descriptions written without equals sign`() {

        myFixture.enableInspections(SageEngineIniEqualsSignInspection(), SageEngineIniUnknownBlockInspection(), SageEngineIniUnknownPropertyInspection())
        myFixture.configureByText(
            "commandmap.ini",
            """
            CommandMap VIEW_TEAM0
                Key = KEY_0
                Category = TEAM
                <warning descr="'Description' requires '=' in 'CommandMap'">Description</warning>  GUI:ViewTeam0Description
                DisplayName = GUI:ViewTeam0
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should only allow mission objective lists in map files`() {

        myFixture.enableInspections(SageEngineIniUnknownBlockInspection(), SageEngineIniUnknownPropertyInspection())
        val missionObjectiveList = """
            MissionObjectiveList
                MissionObjectiveTag = SCRIPT:ANGAngmarObjectiveText_01
                MissionObjectiveTag = SCRIPT:ANGAngmarObjectiveText_02
                BonusMissionObjectiveTag = SCRIPT:ANGAngmarBonusObjectiveText_01
            END
            """.trimIndent()

        myFixture.configureByText("map.ini", missionObjectiveList)
        myFixture.checkHighlighting(true, false, false)

        myFixture.configureByText(
            "objects.ini",
            missionObjectiveList.replaceFirst(
                "MissionObjectiveList",
                "<warning descr=\"'MissionObjectiveList' is only allowed in map.ini\">MissionObjectiveList</warning>"
            )
        )
        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should only allow map caches in map cache files`() {

        myFixture.enableInspections(
            SageEngineIniUnknownBlockInspection(),
            SageEngineIniUnknownPropertyInspection(),
            SageEngineIniInvalidValueInspection(),
            SageEngineIniEqualsSignInspection()
        )
        val mapCache = """
            MapCache maps_5Cmap_20wor_20rhun_5Cmap_20wor_20rhun_2Emap
              fileSize = 424138
              fileCRC = 3783827778
              timestampLo = -996901888
              timestampHi = 29802434
              isOfficial = yes
              isMultiplayer = no
              isScenarioMP = no
              numPlayers = 2
              extentMin = X:0.00 Y:0.00 Z:0.00
              extentMax = X:3250.00 Y:2750.00 Z:0.00
              displayName = _24_00M_00a_00p_00
              description = M_00a_00p_00_2F_00D_00e_00s_00c_00
              InitialCameraPosition = X:1035.84 Y:793.99 Z:0.00
              Player_1_Start = X:328.03 Y:1586.99 Z:0.00
              Player_8_Start = X:1719.66 Y:631.15 Z:0.00
              PlayerPosition 1
                Human = Yes
                Computer = No
                LoadAIScripts = No
                ForcePlayerTeam = -1
                AllowedFactions = FactionArnor FactionAngmar
              END
            END
            """.trimIndent()

        myFixture.configureByText("MapCache.ini", mapCache)
        myFixture.checkHighlighting(true, false, false)

        myFixture.configureByText(
            "map.ini",
            mapCache.replaceFirst("MapCache", "<warning descr=\"'MapCache' is only allowed in mapcache.ini\">MapCache</warning>")
        )
        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should check the game settings of options files`() {

        myFixture.enableInspections(
            SageEngineIniUnknownBlockInspection(),
            SageEngineIniUnknownPropertyInspection(),
            SageEngineIniPropertyOutsideBlockInspection(),
            SageEngineIniInvalidValueInspection()
        )
        myFixture.configureByText(
            "Options.ini",
            """
            AllHealthBars = yes
            AmbientVolume = 30.000000
            AnimationLOD = UltraHigh
            AudioLOD = High
            Brightness = 50
            DecalLOD = High
            EffectsLOD = UltraHigh
            FirewallBehavior = 1
            FirewallNeedToRefresh = TRUE
            FirewallPortAllocationDelta = 0
            FlashTutorial = 0
            GameSpyIPAddress = 192.168.2.11
            HasGotOnline = yes
            HasSeenLogoMovies = yes
            IdealStaticGameLOD = VeryLow
            ModelLOD = High
            MovieVolume = 29.000000
            MusicVolume = 0.000000
            SFXVolume = 29.000000
            ScrollFactor = 18
            SendDelay = no
            ShaderLOD = UltraHigh
            ShadowLOD = UltraHigh
            StaticGameLOD = Very Low
            SuppressCahPromo = false
            TerrainLOD = High
            TextureQualityLOD = Medium
            TimesInGame = <warning descr="Expected a number but found '1a'">1a</warning>
            UseEAX3 = no
            VoiceVolume = 41.000000
            WaterLOD = UltraHigh
            Resolution = 1920 1080
            <warning descr="Unknown property 'UnknownSetting' in 'Options.ini'">UnknownSetting</warning> = 1
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should report checksums that are not unsigned integers`() {

        myFixture.enableInspections(SageEngineIniInvalidValueInspection())
        myFixture.configureByText(
            "mapcache.ini",
            """
            MapCache maps_5Cmap_20wor_20rhun_5Cmap_20wor_20rhun_2Emap
              fileCRC = 4294967295
            END
            MapCache maps_5Cmap_20wor_20eriador_5Cmap_20wor_20eriador_2Emap
              fileCRC = <warning descr="Expected an unsigned integer but found '4294967296'">4294967296</warning>
            END
            MapCache maps_5Cmap_20wor_20harad_5Cmap_20wor_20harad_2Emap
              fileCRC = <warning descr="Expected an unsigned integer but found '1.5'">1.5</warning>
            END
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should report negative values of properties the engine reads as unsigned integers`() {

        myFixture.enableInspections(SageEngineIniInvalidValueInspection())
        myFixture.configureByText(
            "object.ini",
            """
            Object GondorTower
                ShadowOpacityStart = 0
                ShadowOpacityPeak = <warning descr="Expected an unsigned integer but found '-1'">-1</warning>
                Behavior = ProductionUpdate ModuleTag_01
                    MaxQueueEntries = 9
                End
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should know the hardware fog and snow drift of the weather in maps`() {

        myFixture.enableInspections(SageEngineIniUnknownPropertyInspection(), SageEngineIniInvalidValueInspection())
        myFixture.configureByText(
            "map.ini",
            """
            Weather
                HardwareFogColor = R:219 G:187 B:164
                HardwareFogEnable = Yes
                HardwareFogStart = 750
                HardwareFogEnd = 4900
                SnowXYSpeed = X:40 Y:25
                HardwareFogEnable = <warning descr="Expected Yes or No but found '1'">1</warning>
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should allow weapons to clear their nuggets`() {

        myFixture.enableInspections(
            SageEngineIniUnknownPropertyInspection(),
            SageEngineIniUnknownBlockInspection(),
            SageEngineIniMissingValueInspection()
        )
        myFixture.configureByText(
            "map.ini",
            """
            Weapon GoblinFighterSword
              ClearNuggets ; Clear all the damage/fx/paralyze etc nuggets so they can be replaced.
              DamageNugget
                Damage = 30
              End
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }
}
