package de.darkatra.bfme2.ini.model

import de.darkatra.bfme2.ini.model.audio.SideSound
import de.darkatra.bfme2.ini.model.audio.SoundSet
import de.darkatra.bfme2.ini.model.audio.SoundUpgrade
import de.darkatra.bfme2.ini.model.behaviour.AIGateUpdate
import de.darkatra.bfme2.ini.model.behaviour.AISpecialPowerUpdate
import de.darkatra.bfme2.ini.model.behaviour.AIUpdateBehavior
import de.darkatra.bfme2.ini.model.behaviour.AIUpdateInterface
import de.darkatra.bfme2.ini.model.behaviour.AODCrushCollide
import de.darkatra.bfme2.ini.model.behaviour.AODHordeContain
import de.darkatra.bfme2.ini.model.behaviour.ActivateModuleSpecialPower
import de.darkatra.bfme2.ini.model.behaviour.ActiveBody
import de.darkatra.bfme2.ini.model.behaviour.AimWeaponBehavior
import de.darkatra.bfme2.ini.model.behaviour.AllowBannerSpawnUpgrade
import de.darkatra.bfme2.ini.model.behaviour.AnimalAIUpdate
import de.darkatra.bfme2.ini.model.behaviour.AnimatedParticleSysBoneClientUpdate
import de.darkatra.bfme2.ini.model.behaviour.AnimationSoundClientBehavior
import de.darkatra.bfme2.ini.model.behaviour.AnnounceBirthAndDeathBehavior
import de.darkatra.bfme2.ini.model.behaviour.ArmorUpgrade
import de.darkatra.bfme2.ini.model.behaviour.ArrowStormUpdate
import de.darkatra.bfme2.ini.model.behaviour.AssaultTransportAIUpdate
import de.darkatra.bfme2.ini.model.behaviour.AssistedTargetingUpdate
import de.darkatra.bfme2.ini.model.behaviour.AttachUpdate
import de.darkatra.bfme2.ini.model.behaviour.AttributeModifierAuraUpdate
import de.darkatra.bfme2.ini.model.behaviour.AttributeModifierPoolUpdate
import de.darkatra.bfme2.ini.model.behaviour.AttributeModifierUpgrade
import de.darkatra.bfme2.ini.model.behaviour.AudioLoopUpgrade
import de.darkatra.bfme2.ini.model.behaviour.AutoAbilityBehavior
import de.darkatra.bfme2.ini.model.behaviour.AutoDepositUpdate
import de.darkatra.bfme2.ini.model.behaviour.AutoFindHealingUpdate
import de.darkatra.bfme2.ini.model.behaviour.AutoHealBehavior
import de.darkatra.bfme2.ini.model.behaviour.AutoPickUpUpdate
import de.darkatra.bfme2.ini.model.behaviour.BannerCarrierUpdate
import de.darkatra.bfme2.ini.model.behaviour.BaseUpgrade
import de.darkatra.bfme2.ini.model.behaviour.BattleBusSlowDeathBehavior
import de.darkatra.bfme2.ini.model.behaviour.BattlePlanUpdate
import de.darkatra.bfme2.ini.model.behaviour.BeaconClientUpdate
import de.darkatra.bfme2.ini.model.behaviour.BezierProjectileBehavior
import de.darkatra.bfme2.ini.model.behaviour.BloodthirstyUpdate
import de.darkatra.bfme2.ini.model.behaviour.Body
import de.darkatra.bfme2.ini.model.behaviour.BoneFXDamage
import de.darkatra.bfme2.ini.model.behaviour.BoneFXUpdate
import de.darkatra.bfme2.ini.model.behaviour.BoredUpdate
import de.darkatra.bfme2.ini.model.behaviour.BridgeBehavior
import de.darkatra.bfme2.ini.model.behaviour.BridgeScaffoldBehavior
import de.darkatra.bfme2.ini.model.behaviour.BridgeTowerBehavior
import de.darkatra.bfme2.ini.model.behaviour.BroadcastStealthUpdate
import de.darkatra.bfme2.ini.model.behaviour.BuildableHeroListUpgrade
import de.darkatra.bfme2.ini.model.behaviour.BuildingBehavior
import de.darkatra.bfme2.ini.model.behaviour.CallHelpOnDamage
import de.darkatra.bfme2.ini.model.behaviour.CashHackSpecialPower
import de.darkatra.bfme2.ini.model.behaviour.CastleBehavior
import de.darkatra.bfme2.ini.model.behaviour.CastleMemberBehavior
import de.darkatra.bfme2.ini.model.behaviour.CastleUpgrade
import de.darkatra.bfme2.ini.model.behaviour.CaveContain
import de.darkatra.bfme2.ini.model.behaviour.ChinookAIUpdate
import de.darkatra.bfme2.ini.model.behaviour.CitadelSlaughterHordeContain
import de.darkatra.bfme2.ini.model.behaviour.CivilianSpawnCollide
import de.darkatra.bfme2.ini.model.behaviour.CivilianSpawnUpdate
import de.darkatra.bfme2.ini.model.behaviour.ClearanceTestingSlowDeathBehavior
import de.darkatra.bfme2.ini.model.behaviour.ClickReactionBehavior
import de.darkatra.bfme2.ini.model.behaviour.CloudBreakSpecialPower
import de.darkatra.bfme2.ini.model.behaviour.CombineHordeSpecialPower
import de.darkatra.bfme2.ini.model.behaviour.CommandButtonHuntUpdate
import de.darkatra.bfme2.ini.model.behaviour.CommandPointsUpgrade
import de.darkatra.bfme2.ini.model.behaviour.CommandSetUpgrade
import de.darkatra.bfme2.ini.model.behaviour.ContainBehavior
import de.darkatra.bfme2.ini.model.behaviour.ConvertToCarBombCrateCollide
import de.darkatra.bfme2.ini.model.behaviour.ConvertToHijackedVehicleCrateCollide
import de.darkatra.bfme2.ini.model.behaviour.CostModifierUpgrade
import de.darkatra.bfme2.ini.model.behaviour.CrateCollide
import de.darkatra.bfme2.ini.model.behaviour.CreateCrateDie
import de.darkatra.bfme2.ini.model.behaviour.CreateObjectDie
import de.darkatra.bfme2.ini.model.behaviour.CreateObjectDieBehavior
import de.darkatra.bfme2.ini.model.behaviour.CreateObjectDieIfEldestKindof
import de.darkatra.bfme2.ini.model.behaviour.CritterEmitterUpdate
import de.darkatra.bfme2.ini.model.behaviour.CrushDie
import de.darkatra.bfme2.ini.model.behaviour.CurseSpecialPower
import de.darkatra.bfme2.ini.model.behaviour.DamDie
import de.darkatra.bfme2.ini.model.behaviour.DamageFieldUpdate
import de.darkatra.bfme2.ini.model.behaviour.DamageFilteredCreateObjectDie
import de.darkatra.bfme2.ini.model.behaviour.DarknessSpecialPower
import de.darkatra.bfme2.ini.model.behaviour.DefaultProductionExitUpdate
import de.darkatra.bfme2.ini.model.behaviour.DefectorSpecialPower
import de.darkatra.bfme2.ini.model.behaviour.DeflectSpecialPower
import de.darkatra.bfme2.ini.model.behaviour.DelayedDeathBody
import de.darkatra.bfme2.ini.model.behaviour.DelayedLuaEventUpdate
import de.darkatra.bfme2.ini.model.behaviour.DelayedUpgrade
import de.darkatra.bfme2.ini.model.behaviour.DelayedWeaponSetUpgradeUpdate
import de.darkatra.bfme2.ini.model.behaviour.DeletionUpdate
import de.darkatra.bfme2.ini.model.behaviour.DeliverPayloadAIUpdate
import de.darkatra.bfme2.ini.model.behaviour.DemoTrapUpdate
import de.darkatra.bfme2.ini.model.behaviour.DeployStyleAIUpdate
import de.darkatra.bfme2.ini.model.behaviour.DestroyDie
import de.darkatra.bfme2.ini.model.behaviour.DestroyEnvironmentUpdate
import de.darkatra.bfme2.ini.model.behaviour.DetachableRiderBody
import de.darkatra.bfme2.ini.model.behaviour.DetachableRiderUpdate
import de.darkatra.bfme2.ini.model.behaviour.DevastateSpecialPower
import de.darkatra.bfme2.ini.model.behaviour.DieBehavior
import de.darkatra.bfme2.ini.model.behaviour.DoCommandUpgrade
import de.darkatra.bfme2.ini.model.behaviour.DominateEnemySpecialPower
import de.darkatra.bfme2.ini.model.behaviour.DozerAIUpdate
import de.darkatra.bfme2.ini.model.behaviour.DualWeaponBehavior
import de.darkatra.bfme2.ini.model.behaviour.DynamicPortalBehaviour
import de.darkatra.bfme2.ini.model.behaviour.DynamicShroudClearingRangeUpdate
import de.darkatra.bfme2.ini.model.behaviour.EjectPilotDie
import de.darkatra.bfme2.ini.model.behaviour.ElvenWoodSpecialPower
import de.darkatra.bfme2.ini.model.behaviour.EmotionTrackerUpdate
import de.darkatra.bfme2.ini.model.behaviour.EnragedBehavior
import de.darkatra.bfme2.ini.model.behaviour.EntEnragedUpdate
import de.darkatra.bfme2.ini.model.behaviour.EvaAnnounceClientCreate
import de.darkatra.bfme2.ini.model.behaviour.EvacuateDamage
import de.darkatra.bfme2.ini.model.behaviour.EvacuateGarrisonSpecialPower
import de.darkatra.bfme2.ini.model.behaviour.ExperienceLevelCreate
import de.darkatra.bfme2.ini.model.behaviour.ExperienceScalarUpgrade
import de.darkatra.bfme2.ini.model.behaviour.FXListDie
import de.darkatra.bfme2.ini.model.behaviour.FadeAndDieOrnamentUpdate
import de.darkatra.bfme2.ini.model.behaviour.FakePathfindPortalBehaviour
import de.darkatra.bfme2.ini.model.behaviour.FellBeastSwoopPower
import de.darkatra.bfme2.ini.model.behaviour.FireSpreadUpdate
import de.darkatra.bfme2.ini.model.behaviour.FireWeaponCollide
import de.darkatra.bfme2.ini.model.behaviour.FireWeaponUpdate
import de.darkatra.bfme2.ini.model.behaviour.FireWeaponWhenDamagedBehavior
import de.darkatra.bfme2.ini.model.behaviour.FireWeaponWhenDeadBehavior
import de.darkatra.bfme2.ini.model.behaviour.FlammableUpdate
import de.darkatra.bfme2.ini.model.behaviour.FlingPassengerSpecialAbilityUpdate
import de.darkatra.bfme2.ini.model.behaviour.FloatUpdate
import de.darkatra.bfme2.ini.model.behaviour.FloodUpdate
import de.darkatra.bfme2.ini.model.behaviour.FoundationAIUpdate
import de.darkatra.bfme2.ini.model.behaviour.FreeLifeBody
import de.darkatra.bfme2.ini.model.behaviour.FreezingRainSpecialPower
import de.darkatra.bfme2.ini.model.behaviour.GarrisonContain
import de.darkatra.bfme2.ini.model.behaviour.GarrisonUpgrade
import de.darkatra.bfme2.ini.model.behaviour.GateBehavior
import de.darkatra.bfme2.ini.model.behaviour.GateOpenAndCloseBehavior
import de.darkatra.bfme2.ini.model.behaviour.GateProxyBehavior
import de.darkatra.bfme2.ini.model.behaviour.GeometryUpgrade
import de.darkatra.bfme2.ini.model.behaviour.GettingBuiltBehavior
import de.darkatra.bfme2.ini.model.behaviour.GiantBirdAIUpdate
import de.darkatra.bfme2.ini.model.behaviour.GiantBirdSlowDeathBehavior
import de.darkatra.bfme2.ini.model.behaviour.GiveOrRestoreUpgradeSpecialPower
import de.darkatra.bfme2.ini.model.behaviour.GiveUpgradeUpdate
import de.darkatra.bfme2.ini.model.behaviour.GloriousChargeUpdate
import de.darkatra.bfme2.ini.model.behaviour.GrabPassengerSpecialPower
import de.darkatra.bfme2.ini.model.behaviour.GrantUpgradeCreate
import de.darkatra.bfme2.ini.model.behaviour.HackInternetAIUpdate
import de.darkatra.bfme2.ini.model.behaviour.HealContain
import de.darkatra.bfme2.ini.model.behaviour.HealCrateCollide
import de.darkatra.bfme2.ini.model.behaviour.HeightDieUpdate
import de.darkatra.bfme2.ini.model.behaviour.HelicopterSlowDeathBehavior
import de.darkatra.bfme2.ini.model.behaviour.HelixContain
import de.darkatra.bfme2.ini.model.behaviour.HeroDie
import de.darkatra.bfme2.ini.model.behaviour.HeroModeSpecialAbilityUpdate
import de.darkatra.bfme2.ini.model.behaviour.HighlanderBody
import de.darkatra.bfme2.ini.model.behaviour.HijackerUpdate
import de.darkatra.bfme2.ini.model.behaviour.HitReactionBehavior
import de.darkatra.bfme2.ini.model.behaviour.HiveStructureBody
import de.darkatra.bfme2.ini.model.behaviour.HordeAIUpdate
import de.darkatra.bfme2.ini.model.behaviour.HordeContain
import de.darkatra.bfme2.ini.model.behaviour.HordeDispatchSpecialPower
import de.darkatra.bfme2.ini.model.behaviour.HordeGarrisonContain
import de.darkatra.bfme2.ini.model.behaviour.HordeMemberCollide
import de.darkatra.bfme2.ini.model.behaviour.HordeNotifyTargetsOfImminentProbableCrushingUpdate
import de.darkatra.bfme2.ini.model.behaviour.HordeSiegeEngineContain
import de.darkatra.bfme2.ini.model.behaviour.HordeTransportContain
import de.darkatra.bfme2.ini.model.behaviour.HordeTransportContainDamage
import de.darkatra.bfme2.ini.model.behaviour.HordeWorkerAIUpdate
import de.darkatra.bfme2.ini.model.behaviour.HorseHordeContain
import de.darkatra.bfme2.ini.model.behaviour.ImmortalBody
import de.darkatra.bfme2.ini.model.behaviour.InactiveBody
import de.darkatra.bfme2.ini.model.behaviour.InheritUpgradeCreate
import de.darkatra.bfme2.ini.model.behaviour.InstantDeathBehavior
import de.darkatra.bfme2.ini.model.behaviour.InternetHackContain
import de.darkatra.bfme2.ini.model.behaviour.InvisibilitySpecialPower
import de.darkatra.bfme2.ini.model.behaviour.InvisibilityUpdate
import de.darkatra.bfme2.ini.model.behaviour.JetAIUpdate
import de.darkatra.bfme2.ini.model.behaviour.JetSlowDeathBehavior
import de.darkatra.bfme2.ini.model.behaviour.KeepObjectDie
import de.darkatra.bfme2.ini.model.behaviour.LargeGroupAudioUpdate
import de.darkatra.bfme2.ini.model.behaviour.LargeGroupBonusUpdate
import de.darkatra.bfme2.ini.model.behaviour.LaserUpdate
import de.darkatra.bfme2.ini.model.behaviour.LevelGrantSpecialPower
import de.darkatra.bfme2.ini.model.behaviour.LevelUpUpgrade
import de.darkatra.bfme2.ini.model.behaviour.LifetimeUpdate
import de.darkatra.bfme2.ini.model.behaviour.ListUpgradeoundSelectorClientBehavior
import de.darkatra.bfme2.ini.model.behaviour.LockWeaponCreate
import de.darkatra.bfme2.ini.model.behaviour.LocomotorSetUpgrade
import de.darkatra.bfme2.ini.model.behaviour.ManTheWallsSpecialPower
import de.darkatra.bfme2.ini.model.behaviour.MaxHealthUpgrade
import de.darkatra.bfme2.ini.model.behaviour.MeleeBehavior
import de.darkatra.bfme2.ini.model.behaviour.MineshaftPortalBehaviour
import de.darkatra.bfme2.ini.model.behaviour.MissileAIUpdate
import de.darkatra.bfme2.ini.model.behaviour.MissileUpdate
import de.darkatra.bfme2.ini.model.behaviour.ModelConditionAudioLoopClientBehavior
import de.darkatra.bfme2.ini.model.behaviour.ModelConditionSoundSelectorClientBehavior
import de.darkatra.bfme2.ini.model.behaviour.ModelConditionSpecialAbilityUpdate
import de.darkatra.bfme2.ini.model.behaviour.ModelConditionUpgrade
import de.darkatra.bfme2.ini.model.behaviour.MoneyCrateCollide
import de.darkatra.bfme2.ini.model.behaviour.MonitorConditionUpdate
import de.darkatra.bfme2.ini.model.behaviour.MonsterDockUpdate
import de.darkatra.bfme2.ini.model.behaviour.NeutronMissileSlowDeathBehavior
import de.darkatra.bfme2.ini.model.behaviour.NotifyTargetsOfImminentProbableCrushingUpdate
import de.darkatra.bfme2.ini.model.behaviour.OCLSpecialPower
import de.darkatra.bfme2.ini.model.behaviour.OCLUpdate
import de.darkatra.bfme2.ini.model.behaviour.OathbreakerBody
import de.darkatra.bfme2.ini.model.behaviour.OathbreakersFadeAwayBehavior
import de.darkatra.bfme2.ini.model.behaviour.ObjectCreationUpgrade
import de.darkatra.bfme2.ini.model.behaviour.OilSpillUpdate
import de.darkatra.bfme2.ini.model.behaviour.OneRingPenaltyUpdate
import de.darkatra.bfme2.ini.model.behaviour.OpenContain
import de.darkatra.bfme2.ini.model.behaviour.OverlordContain
import de.darkatra.bfme2.ini.model.behaviour.ParachuteContain
import de.darkatra.bfme2.ini.model.behaviour.PartTheHeavensUpdate
import de.darkatra.bfme2.ini.model.behaviour.PassiveAreaEffectBehavior
import de.darkatra.bfme2.ini.model.behaviour.PhysicsBehavior
import de.darkatra.bfme2.ini.model.behaviour.PickupStuffUpdate
import de.darkatra.bfme2.ini.model.behaviour.PillageModule
import de.darkatra.bfme2.ini.model.behaviour.PlayerHealSpecialPower
import de.darkatra.bfme2.ini.model.behaviour.PlayerUpgradeSpecialPower
import de.darkatra.bfme2.ini.model.behaviour.PoisonedBehavior
import de.darkatra.bfme2.ini.model.behaviour.PorcupineFormationBodyModule
import de.darkatra.bfme2.ini.model.behaviour.PreorderCreate
import de.darkatra.bfme2.ini.model.behaviour.ProductionQueueHordeContain
import de.darkatra.bfme2.ini.model.behaviour.ProductionSpeedBonus
import de.darkatra.bfme2.ini.model.behaviour.ProductionUpdate
import de.darkatra.bfme2.ini.model.behaviour.ProjectileStreamUpdate
import de.darkatra.bfme2.ini.model.behaviour.ProneUpdate
import de.darkatra.bfme2.ini.model.behaviour.PropagandaTowerBehavior
import de.darkatra.bfme2.ini.model.behaviour.QueueProductionExitUpdate
import de.darkatra.bfme2.ini.model.behaviour.RadarMarkerClientUpdate
import de.darkatra.bfme2.ini.model.behaviour.RadarUpdate
import de.darkatra.bfme2.ini.model.behaviour.RadarUpgrade
import de.darkatra.bfme2.ini.model.behaviour.RadiateFearUpdate
import de.darkatra.bfme2.ini.model.behaviour.RadiusDecalUpdate
import de.darkatra.bfme2.ini.model.behaviour.RailedTransportAIUpdate
import de.darkatra.bfme2.ini.model.behaviour.RailedTransportContain
import de.darkatra.bfme2.ini.model.behaviour.RainOfFireUpdate
import de.darkatra.bfme2.ini.model.behaviour.RampageBehavior
import de.darkatra.bfme2.ini.model.behaviour.RandomSoundSelectorClientBehavior
import de.darkatra.bfme2.ini.model.behaviour.RebuildHoleBehavior
import de.darkatra.bfme2.ini.model.behaviour.RebuildHoleExposeDie
import de.darkatra.bfme2.ini.model.behaviour.ReflectDamage
import de.darkatra.bfme2.ini.model.behaviour.RefundDie
import de.darkatra.bfme2.ini.model.behaviour.RemoveUpgradeUpgrade
import de.darkatra.bfme2.ini.model.behaviour.RepairDockUpdate
import de.darkatra.bfme2.ini.model.behaviour.RepairSpecialPower
import de.darkatra.bfme2.ini.model.behaviour.ReplaceObjectUpdate
import de.darkatra.bfme2.ini.model.behaviour.ReplaceSelfUpgrade
import de.darkatra.bfme2.ini.model.behaviour.ReplenishUnitsBehavior
import de.darkatra.bfme2.ini.model.behaviour.RespawnBody
import de.darkatra.bfme2.ini.model.behaviour.RespawnUpdate
import de.darkatra.bfme2.ini.model.behaviour.RiderChangeContain
import de.darkatra.bfme2.ini.model.behaviour.RousingSpeechUpdate
import de.darkatra.bfme2.ini.model.behaviour.RubbleRiseUpdate
import de.darkatra.bfme2.ini.model.behaviour.RunOffMapBehavior
import de.darkatra.bfme2.ini.model.behaviour.SabotageCommandCenterCrateCollide
import de.darkatra.bfme2.ini.model.behaviour.SabotageFakeBuildingCrateCollide
import de.darkatra.bfme2.ini.model.behaviour.SabotageInternetCenterCrateCollide
import de.darkatra.bfme2.ini.model.behaviour.SabotageMilitaryFactoryCrateCollide
import de.darkatra.bfme2.ini.model.behaviour.SabotagePowerPlantCrateCollide
import de.darkatra.bfme2.ini.model.behaviour.SabotageSuperweaponCrateCollide
import de.darkatra.bfme2.ini.model.behaviour.SabotageSupplyCenterCrateCollide
import de.darkatra.bfme2.ini.model.behaviour.SalvageCrateCollide
import de.darkatra.bfme2.ini.model.behaviour.ScaleWallSpecialAbilityUpdate
import de.darkatra.bfme2.ini.model.behaviour.ScavengerSpecialPower
import de.darkatra.bfme2.ini.model.behaviour.ShareExperienceBehavior
import de.darkatra.bfme2.ini.model.behaviour.ShipSlowDeathBehavior
import de.darkatra.bfme2.ini.model.behaviour.ShroudCrateCollide
import de.darkatra.bfme2.ini.model.behaviour.SiegeAIUpdate
import de.darkatra.bfme2.ini.model.behaviour.SiegeDeployHordeSpecialPower
import de.darkatra.bfme2.ini.model.behaviour.SiegeDeploySpecialPower
import de.darkatra.bfme2.ini.model.behaviour.SiegeDockingBehavior
import de.darkatra.bfme2.ini.model.behaviour.SiegeEngineContain
import de.darkatra.bfme2.ini.model.behaviour.SlaughterHordeContain
import de.darkatra.bfme2.ini.model.behaviour.SlaveWatcherBehavior
import de.darkatra.bfme2.ini.model.behaviour.SlavedUpdate
import de.darkatra.bfme2.ini.model.behaviour.SlowDeathBehavior
import de.darkatra.bfme2.ini.model.behaviour.SpawnBehavior
import de.darkatra.bfme2.ini.model.behaviour.SpawnPointProductionExitUpdate
import de.darkatra.bfme2.ini.model.behaviour.SpawnUnitBehavior
import de.darkatra.bfme2.ini.model.behaviour.SpecialAbilityUpdate
import de.darkatra.bfme2.ini.model.behaviour.SpecialDisguiseUpdate
import de.darkatra.bfme2.ini.model.behaviour.SpecialEnemySenseUpdate
import de.darkatra.bfme2.ini.model.behaviour.SpecialPowerBehavior
import de.darkatra.bfme2.ini.model.behaviour.SpecialPowerCompletionDie
import de.darkatra.bfme2.ini.model.behaviour.SpecialPowerCreate
import de.darkatra.bfme2.ini.model.behaviour.SpecialPowerModule
import de.darkatra.bfme2.ini.model.behaviour.SpecialPowerModuleBehavior
import de.darkatra.bfme2.ini.model.behaviour.SpecialPowerTimerRefreshSpecialPower
import de.darkatra.bfme2.ini.model.behaviour.SpellRechargeModifierUpgrade
import de.darkatra.bfme2.ini.model.behaviour.SplitHordeSpecialPower
import de.darkatra.bfme2.ini.model.behaviour.SquishCollide
import de.darkatra.bfme2.ini.model.behaviour.StancesBehavior
import de.darkatra.bfme2.ini.model.behaviour.StatusBitsUpgrade
import de.darkatra.bfme2.ini.model.behaviour.StatusBitsUpgradeIfEldestKindof
import de.darkatra.bfme2.ini.model.behaviour.StealthDetectorUpdate
import de.darkatra.bfme2.ini.model.behaviour.StealthUpdate
import de.darkatra.bfme2.ini.model.behaviour.StealthUpgrade
import de.darkatra.bfme2.ini.model.behaviour.StopSpecialPower
import de.darkatra.bfme2.ini.model.behaviour.StoreObjectsSpecialPower
import de.darkatra.bfme2.ini.model.behaviour.StrafeAreaUpdate
import de.darkatra.bfme2.ini.model.behaviour.StructureBody
import de.darkatra.bfme2.ini.model.behaviour.StructureCollapseUpdate
import de.darkatra.bfme2.ini.model.behaviour.StructureToppleUpdate
import de.darkatra.bfme2.ini.model.behaviour.SubObjectsUpgrade
import de.darkatra.bfme2.ini.model.behaviour.SummonReplacementSpecialAbilityUpdate
import de.darkatra.bfme2.ini.model.behaviour.SupplyAIUpdate
import de.darkatra.bfme2.ini.model.behaviour.SupplyCenterCreate
import de.darkatra.bfme2.ini.model.behaviour.SupplyCenterDockUpdate
import de.darkatra.bfme2.ini.model.behaviour.SupplyCenterProductionExitUpdate
import de.darkatra.bfme2.ini.model.behaviour.SupplyTruckAIUpdate
import de.darkatra.bfme2.ini.model.behaviour.SupplyWarehouseCreate
import de.darkatra.bfme2.ini.model.behaviour.SupplyWarehouseCripplingBehavior
import de.darkatra.bfme2.ini.model.behaviour.SupplyWarehouseDockUpdate
import de.darkatra.bfme2.ini.model.behaviour.SwayClientUpdate
import de.darkatra.bfme2.ini.model.behaviour.SymbioticStructuresBody
import de.darkatra.bfme2.ini.model.behaviour.TaintSpecialPower
import de.darkatra.bfme2.ini.model.behaviour.TeleportSpecialAbilityUpdate
import de.darkatra.bfme2.ini.model.behaviour.TeleportToCasterSpecialPower
import de.darkatra.bfme2.ini.model.behaviour.TemporarilyDefectUpdate
import de.darkatra.bfme2.ini.model.behaviour.TerrainResourceBehavior
import de.darkatra.bfme2.ini.model.behaviour.TerrainResourceClientBehavior
import de.darkatra.bfme2.ini.model.behaviour.ThreatFinderUpdate
import de.darkatra.bfme2.ini.model.behaviour.ToggleDeploySpecialAbilityUpdate
import de.darkatra.bfme2.ini.model.behaviour.ToggleHiddenSpecialAbilityUpdate
import de.darkatra.bfme2.ini.model.behaviour.ToggleMountedSpecialAbilityUpdate
import de.darkatra.bfme2.ini.model.behaviour.TooltipUpgrade
import de.darkatra.bfme2.ini.model.behaviour.ToppleUpdate
import de.darkatra.bfme2.ini.model.behaviour.TransitionDamageFX
import de.darkatra.bfme2.ini.model.behaviour.TransportAIUpdate
import de.darkatra.bfme2.ini.model.behaviour.TransportContain
import de.darkatra.bfme2.ini.model.behaviour.TunnelContain
import de.darkatra.bfme2.ini.model.behaviour.UndeadBody
import de.darkatra.bfme2.ini.model.behaviour.UnitCrateCollide
import de.darkatra.bfme2.ini.model.behaviour.UnleashSpecialPower
import de.darkatra.bfme2.ini.model.behaviour.UnpauseSpecialPowerUpgrade
import de.darkatra.bfme2.ini.model.behaviour.UntamedAllegianceSpecialPower
import de.darkatra.bfme2.ini.model.behaviour.UpgradeBehavior
import de.darkatra.bfme2.ini.model.behaviour.UpgradeDie
import de.darkatra.bfme2.ini.model.behaviour.UpgradeSoundSelectorClientBehavior
import de.darkatra.bfme2.ini.model.behaviour.VeterancyCrateCollide
import de.darkatra.bfme2.ini.model.behaviour.WallHubBehavior
import de.darkatra.bfme2.ini.model.behaviour.WallUpgradeUpdate
import de.darkatra.bfme2.ini.model.behaviour.WanderAIUpdate
import de.darkatra.bfme2.ini.model.behaviour.WargBehavior
import de.darkatra.bfme2.ini.model.behaviour.WeaponBonusUpgrade
import de.darkatra.bfme2.ini.model.behaviour.WeaponChangeSpecialPowerModule
import de.darkatra.bfme2.ini.model.behaviour.WeaponFireSpecialAbilityUpdate
import de.darkatra.bfme2.ini.model.behaviour.WeaponModeSpecialPowerUpdate
import de.darkatra.bfme2.ini.model.behaviour.WeaponSetSpecialAbilityUpdate
import de.darkatra.bfme2.ini.model.behaviour.WeaponSetUpgrade
import de.darkatra.bfme2.ini.model.behaviour.WorkerAIUpdate
import de.darkatra.bfme2.ini.model.behaviour.WoundArrowUpdate
import de.darkatra.bfme2.ini.model.common.Event
import de.darkatra.bfme2.ini.model.common.FCurve
import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageDraw
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageNugget
import de.darkatra.bfme2.ini.model.draw.Animation
import de.darkatra.bfme2.ini.model.draw.AnimationState
import de.darkatra.bfme2.ini.model.draw.ButterflyDraw
import de.darkatra.bfme2.ini.model.draw.DefaultAnimationState
import de.darkatra.bfme2.ini.model.draw.DefaultDraw
import de.darkatra.bfme2.ini.model.draw.DefaultModelConditionState
import de.darkatra.bfme2.ini.model.draw.Draw
import de.darkatra.bfme2.ini.model.draw.GpuDraw
import de.darkatra.bfme2.ini.model.draw.IdleAnimationState
import de.darkatra.bfme2.ini.model.draw.LightningDraw
import de.darkatra.bfme2.ini.model.draw.LodOptions
import de.darkatra.bfme2.ini.model.draw.ModelConditionState
import de.darkatra.bfme2.ini.model.draw.QuadDraw
import de.darkatra.bfme2.ini.model.draw.RenderObjectDraw
import de.darkatra.bfme2.ini.model.draw.SoundState
import de.darkatra.bfme2.ini.model.draw.StreakDraw
import de.darkatra.bfme2.ini.model.draw.TransitionState
import de.darkatra.bfme2.ini.model.draw.W3DBoatWakeModelDraw
import de.darkatra.bfme2.ini.model.draw.W3DBuffDraw
import de.darkatra.bfme2.ini.model.draw.W3DDebrisDraw
import de.darkatra.bfme2.ini.model.draw.W3DDefaultDraw
import de.darkatra.bfme2.ini.model.draw.W3DDependencyModelDraw
import de.darkatra.bfme2.ini.model.draw.W3DFloorDraw
import de.darkatra.bfme2.ini.model.draw.W3DHordeModelDraw
import de.darkatra.bfme2.ini.model.draw.W3DLaserDraw
import de.darkatra.bfme2.ini.model.draw.W3DLightDraw
import de.darkatra.bfme2.ini.model.draw.W3DModelDraw
import de.darkatra.bfme2.ini.model.draw.W3DOverlordTankDraw
import de.darkatra.bfme2.ini.model.draw.W3DOverlordTruckDraw
import de.darkatra.bfme2.ini.model.draw.W3DPoliceCarDraw
import de.darkatra.bfme2.ini.model.draw.W3DProjectileStreamDraw
import de.darkatra.bfme2.ini.model.draw.W3DPropDraw
import de.darkatra.bfme2.ini.model.draw.W3DQuadrupedDraw
import de.darkatra.bfme2.ini.model.draw.W3DRopeDraw
import de.darkatra.bfme2.ini.model.draw.W3DSailModelDraw
import de.darkatra.bfme2.ini.model.draw.W3DScienceModelDraw
import de.darkatra.bfme2.ini.model.draw.W3DScriptedModelDraw
import de.darkatra.bfme2.ini.model.draw.W3DStreakDraw
import de.darkatra.bfme2.ini.model.draw.W3DSupplyDraw
import de.darkatra.bfme2.ini.model.draw.W3DTankDraw
import de.darkatra.bfme2.ini.model.draw.W3DTankTruckDraw
import de.darkatra.bfme2.ini.model.draw.W3DTornadoDraw
import de.darkatra.bfme2.ini.model.draw.W3DTracerDraw
import de.darkatra.bfme2.ini.model.draw.W3DTreeDraw
import de.darkatra.bfme2.ini.model.draw.W3DTruckDraw
import de.darkatra.bfme2.ini.model.fx.ApplyRandomForce
import de.darkatra.bfme2.ini.model.fx.AttachedModel
import de.darkatra.bfme2.ini.model.fx.BuffNugget
import de.darkatra.bfme2.ini.model.fx.CameraShakerVolume
import de.darkatra.bfme2.ini.model.fx.CreateDebris
import de.darkatra.bfme2.ini.model.fx.DynamicDecal
import de.darkatra.bfme2.ini.model.fx.EvaEvent
import de.darkatra.bfme2.ini.model.fx.FXListAtBonePos
import de.darkatra.bfme2.ini.model.fx.FireWeapon
import de.darkatra.bfme2.ini.model.fx.LightPulse
import de.darkatra.bfme2.ini.model.fx.Sound
import de.darkatra.bfme2.ini.model.fx.TerrainScorch
import de.darkatra.bfme2.ini.model.fx.TintDrawable
import de.darkatra.bfme2.ini.model.fx.ViewShake
import de.darkatra.bfme2.ini.model.livingworld.Act
import de.darkatra.bfme2.ini.model.livingworld.AddPlayer
import de.darkatra.bfme2.ini.model.livingworld.ArmyEntry
import de.darkatra.bfme2.ini.model.livingworld.ArmyMemberDefinition
import de.darkatra.bfme2.ini.model.livingworld.ArmyToSpawn
import de.darkatra.bfme2.ini.model.livingworld.Bonus
import de.darkatra.bfme2.ini.model.livingworld.BonusForLevel
import de.darkatra.bfme2.ini.model.livingworld.BordersEffect
import de.darkatra.bfme2.ini.model.livingworld.BrutalDifficultyCheats
import de.darkatra.bfme2.ini.model.livingworld.BuildingNugget
import de.darkatra.bfme2.ini.model.livingworld.ColorIntensityControlPoint
import de.darkatra.bfme2.ini.model.livingworld.Connection
import de.darkatra.bfme2.ini.model.livingworld.DefeatCondition
import de.darkatra.bfme2.ini.model.livingworld.DifficultyTuning
import de.darkatra.bfme2.ini.model.livingworld.EnableRegion
import de.darkatra.bfme2.ini.model.livingworld.EyeTower
import de.darkatra.bfme2.ini.model.livingworld.EyeTowerPoints
import de.darkatra.bfme2.ini.model.livingworld.FilledOwnershipEffect
import de.darkatra.bfme2.ini.model.livingworld.HomeRegionHighlight
import de.darkatra.bfme2.ini.model.livingworld.LivingWorldIconObject
import de.darkatra.bfme2.ini.model.livingworld.Mission
import de.darkatra.bfme2.ini.model.livingworld.MouseoverEffectFlareup
import de.darkatra.bfme2.ini.model.livingworld.MoveArmy
import de.darkatra.bfme2.ini.model.livingworld.MoveCamera
import de.darkatra.bfme2.ini.model.livingworld.OwnershipSet
import de.darkatra.bfme2.ini.model.livingworld.PlayerDefeatCondition
import de.darkatra.bfme2.ini.model.livingworld.PlayerVictoryCondition
import de.darkatra.bfme2.ini.model.livingworld.Region
import de.darkatra.bfme2.ini.model.livingworld.RegionEffect
import de.darkatra.bfme2.ini.model.livingworld.RegionSelectionEffect
import de.darkatra.bfme2.ini.model.livingworld.RestrictBuildings
import de.darkatra.bfme2.ini.model.livingworld.Scenario
import de.darkatra.bfme2.ini.model.livingworld.SetPlayerControlOfArmy
import de.darkatra.bfme2.ini.model.livingworld.SideInfo
import de.darkatra.bfme2.ini.model.livingworld.SkirmishBuildList
import de.darkatra.bfme2.ini.model.livingworld.SpawnArmies
import de.darkatra.bfme2.ini.model.livingworld.SpawnBuildings
import de.darkatra.bfme2.ini.model.livingworld.StartingRestriction
import de.darkatra.bfme2.ini.model.livingworld.TeamDefeatCondition
import de.darkatra.bfme2.ini.model.livingworld.TeamVictoryCondition
import de.darkatra.bfme2.ini.model.livingworld.UnifiedEffect
import de.darkatra.bfme2.ini.model.livingworld.VictoryCondition
import de.darkatra.bfme2.ini.model.livingworld.WorldText
import de.darkatra.bfme2.ini.model.nugget.AttributeModifierNugget
import de.darkatra.bfme2.ini.model.nugget.ClearNuggets
import de.darkatra.bfme2.ini.model.nugget.DOTNugget
import de.darkatra.bfme2.ini.model.nugget.DamageContainedNugget
import de.darkatra.bfme2.ini.model.nugget.DamageFieldNugget
import de.darkatra.bfme2.ini.model.nugget.DamageNugget
import de.darkatra.bfme2.ini.model.nugget.EmotionWeaponNugget
import de.darkatra.bfme2.ini.model.nugget.FireLogicNugget
import de.darkatra.bfme2.ini.model.nugget.FireWeaponNugget
import de.darkatra.bfme2.ini.model.nugget.GrabNugget
import de.darkatra.bfme2.ini.model.nugget.HordeAttackNugget
import de.darkatra.bfme2.ini.model.nugget.InvisibilityNugget
import de.darkatra.bfme2.ini.model.nugget.LuaEventNugget
import de.darkatra.bfme2.ini.model.nugget.MetaImpactNugget
import de.darkatra.bfme2.ini.model.nugget.OpenGateNugget
import de.darkatra.bfme2.ini.model.nugget.ParalyzeNugget
import de.darkatra.bfme2.ini.model.nugget.ProjectileNugget
import de.darkatra.bfme2.ini.model.nugget.SlaveAttackNugget
import de.darkatra.bfme2.ini.model.nugget.SpawnAndFadeNugget
import de.darkatra.bfme2.ini.model.nugget.SpecialModelConditionNugget
import de.darkatra.bfme2.ini.model.nugget.StealMoneyNugget
import de.darkatra.bfme2.ini.model.nugget.WeaponEffectNugget
import de.darkatra.bfme2.ini.model.nugget.WeaponOCLNugget
import de.darkatra.bfme2.ini.model.`object`.AIBase
import de.darkatra.bfme2.ini.model.`object`.AIData
import de.darkatra.bfme2.ini.model.`object`.AIDozerAssignment
import de.darkatra.bfme2.ini.model.`object`.AIEconomyAssigment
import de.darkatra.bfme2.ini.model.`object`.AIWallNodeAssignment
import de.darkatra.bfme2.ini.model.`object`.AddEmotion
import de.darkatra.bfme2.ini.model.`object`.AddModule
import de.darkatra.bfme2.ini.model.`object`.AmbientStream
import de.darkatra.bfme2.ini.model.`object`.AnimationSoundClientBehaviorGlobalSetting
import de.darkatra.bfme2.ini.model.`object`.AptButtonTooltipMap
import de.darkatra.bfme2.ini.model.`object`.Armor
import de.darkatra.bfme2.ini.model.`object`.ArmorSet
import de.darkatra.bfme2.ini.model.`object`.ArmyDefinition
import de.darkatra.bfme2.ini.model.`object`.ArmySummaryDescription
import de.darkatra.bfme2.ini.model.`object`.Attack
import de.darkatra.bfme2.ini.model.`object`.AttackPriority
import de.darkatra.bfme2.ini.model.`object`.Attribute
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.AudioLOD
import de.darkatra.bfme2.ini.model.`object`.AudioSettings
import de.darkatra.bfme2.ini.model.`object`.AutoResolveArmor
import de.darkatra.bfme2.ini.model.`object`.AutoResolveBody
import de.darkatra.bfme2.ini.model.`object`.AutoResolveCombatChain
import de.darkatra.bfme2.ini.model.`object`.AutoResolveHandicapLevel
import de.darkatra.bfme2.ini.model.`object`.AutoResolveLeadership
import de.darkatra.bfme2.ini.model.`object`.AutoResolveReinforcementSchedule
import de.darkatra.bfme2.ini.model.`object`.AutoResolveWeapon
import de.darkatra.bfme2.ini.model.`object`.AwardSystem
import de.darkatra.bfme2.ini.model.`object`.BannerType
import de.darkatra.bfme2.ini.model.`object`.Bridge
import de.darkatra.bfme2.ini.model.`object`.ButtonSet
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.CloudEffect
import de.darkatra.bfme2.ini.model.`object`.CombatChainDefinition
import de.darkatra.bfme2.ini.model.`object`.CommandButton
import de.darkatra.bfme2.ini.model.`object`.CommandMap
import de.darkatra.bfme2.ini.model.`object`.CommandSet
import de.darkatra.bfme2.ini.model.`object`.ConcurrentRegionBonus
import de.darkatra.bfme2.ini.model.`object`.ControlBarResizer
import de.darkatra.bfme2.ini.model.`object`.ControlBarScheme
import de.darkatra.bfme2.ini.model.`object`.CrateData
import de.darkatra.bfme2.ini.model.`object`.CreateAHeroBling
import de.darkatra.bfme2.ini.model.`object`.CreateAHeroBlingBinder
import de.darkatra.bfme2.ini.model.`object`.CreateAHeroClass
import de.darkatra.bfme2.ini.model.`object`.CreateAHeroSystem
import de.darkatra.bfme2.ini.model.`object`.CreateObject
import de.darkatra.bfme2.ini.model.`object`.Credits
import de.darkatra.bfme2.ini.model.`object`.CrowdResponse
import de.darkatra.bfme2.ini.model.`object`.DamageFX
import de.darkatra.bfme2.ini.model.`object`.DebugCommandMap
import de.darkatra.bfme2.ini.model.`object`.DeliverPayload
import de.darkatra.bfme2.ini.model.`object`.DialogEvent
import de.darkatra.bfme2.ini.model.`object`.DrawGroupInfo
import de.darkatra.bfme2.ini.model.`object`.DynamicGameLOD
import de.darkatra.bfme2.ini.model.`object`.EmotionNugget
import de.darkatra.bfme2.ini.model.`object`.EvaEventBase
import de.darkatra.bfme2.ini.model.`object`.ExperienceLevel
import de.darkatra.bfme2.ini.model.`object`.ExperienceScalarTable
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.FXParticleSystem
import de.darkatra.bfme2.ini.model.`object`.FactionVictoryData
import de.darkatra.bfme2.ini.model.`object`.Fire
import de.darkatra.bfme2.ini.model.`object`.FireEffect
import de.darkatra.bfme2.ini.model.`object`.FireLogicSystem
import de.darkatra.bfme2.ini.model.`object`.Flammability
import de.darkatra.bfme2.ini.model.`object`.FloodMember
import de.darkatra.bfme2.ini.model.`object`.FontDefaultSettings
import de.darkatra.bfme2.ini.model.`object`.FontSubstitution
import de.darkatra.bfme2.ini.model.`object`.FormationAssistant
import de.darkatra.bfme2.ini.model.`object`.FormationPreviewDecal
import de.darkatra.bfme2.ini.model.`object`.FormationPreviewItemDecal
import de.darkatra.bfme2.ini.model.`object`.FormationSelection
import de.darkatra.bfme2.ini.model.`object`.FormationTemplate
import de.darkatra.bfme2.ini.model.`object`.GameData
import de.darkatra.bfme2.ini.model.`object`.GeometryShape
import de.darkatra.bfme2.ini.model.`object`.GlowEffect
import de.darkatra.bfme2.ini.model.`object`.HouseColor
import de.darkatra.bfme2.ini.model.`object`.InGameNotificationBox
import de.darkatra.bfme2.ini.model.`object`.InGameUI
import de.darkatra.bfme2.ini.model.`object`.InheritableModule
import de.darkatra.bfme2.ini.model.`object`.LargeGroupAudioMap
import de.darkatra.bfme2.ini.model.`object`.LargeGroupAudioUnusedKnownKeys
import de.darkatra.bfme2.ini.model.`object`.LightPointLevel
import de.darkatra.bfme2.ini.model.`object`.LinearCampaign
import de.darkatra.bfme2.ini.model.`object`.LivingWorldAITemplate
import de.darkatra.bfme2.ini.model.`object`.LivingWorldAnimObject
import de.darkatra.bfme2.ini.model.`object`.LivingWorldArmyIcon
import de.darkatra.bfme2.ini.model.`object`.LivingWorldAutoResolveResourceBonus
import de.darkatra.bfme2.ini.model.`object`.LivingWorldAutoResolveSciencePurchasePointBonus
import de.darkatra.bfme2.ini.model.`object`.LivingWorldBuildPlotIcon
import de.darkatra.bfme2.ini.model.`object`.LivingWorldBuilding
import de.darkatra.bfme2.ini.model.`object`.LivingWorldBuildingIcon
import de.darkatra.bfme2.ini.model.`object`.LivingWorldCampaign
import de.darkatra.bfme2.ini.model.`object`.LivingWorldMapInfo
import de.darkatra.bfme2.ini.model.`object`.LivingWorldObject
import de.darkatra.bfme2.ini.model.`object`.LivingWorldPlayerArmy
import de.darkatra.bfme2.ini.model.`object`.LivingWorldPlayerTemplate
import de.darkatra.bfme2.ini.model.`object`.LivingWorldRegionCampaign
import de.darkatra.bfme2.ini.model.`object`.LivingWorldRegionEffects
import de.darkatra.bfme2.ini.model.`object`.LivingWorldSound
import de.darkatra.bfme2.ini.model.`object`.LoadSubsystem
import de.darkatra.bfme2.ini.model.`object`.Locomotor
import de.darkatra.bfme2.ini.model.`object`.LocomotorSet
import de.darkatra.bfme2.ini.model.`object`.MappedImage
import de.darkatra.bfme2.ini.model.`object`.MiscAudio
import de.darkatra.bfme2.ini.model.`object`.MiscEvaData
import de.darkatra.bfme2.ini.model.`object`.ModifierList
import de.darkatra.bfme2.ini.model.`object`.Mouse
import de.darkatra.bfme2.ini.model.`object`.MouseCursor
import de.darkatra.bfme2.ini.model.`object`.MultiplayerColor
import de.darkatra.bfme2.ini.model.`object`.MultiplayerSettings
import de.darkatra.bfme2.ini.model.`object`.Multisound
import de.darkatra.bfme2.ini.model.`object`.MusicTrack
import de.darkatra.bfme2.ini.model.`object`.NewEvaEvent
import de.darkatra.bfme2.ini.model.`object`.NotificationType
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectAward
import de.darkatra.bfme2.ini.model.`object`.ObjectCreationList
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.`object`.OnlineChatColors
import de.darkatra.bfme2.ini.model.`object`.OptionGroup
import de.darkatra.bfme2.ini.model.`object`.Pathfinder
import de.darkatra.bfme2.ini.model.`object`.PlayerAIType
import de.darkatra.bfme2.ini.model.`object`.PlayerTemplate
import de.darkatra.bfme2.ini.model.`object`.PredefinedEvaEvent
import de.darkatra.bfme2.ini.model.`object`.ProductionModifier
import de.darkatra.bfme2.ini.model.`object`.Rank
import de.darkatra.bfme2.ini.model.`object`.RegionCampain
import de.darkatra.bfme2.ini.model.`object`.ReplaceModule
import de.darkatra.bfme2.ini.model.`object`.ReplaceObject
import de.darkatra.bfme2.ini.model.`object`.RingEffect
import de.darkatra.bfme2.ini.model.`object`.Road
import de.darkatra.bfme2.ini.model.`object`.Rows
import de.darkatra.bfme2.ini.model.`object`.Science
import de.darkatra.bfme2.ini.model.`object`.ScoredKillEvaAnnouncer
import de.darkatra.bfme2.ini.model.`object`.SelectionDecal
import de.darkatra.bfme2.ini.model.`object`.ShadowMap
import de.darkatra.bfme2.ini.model.`object`.ShellMenuScheme
import de.darkatra.bfme2.ini.model.`object`.SkirmishAIData
import de.darkatra.bfme2.ini.model.`object`.SkyboxTextureSet
import de.darkatra.bfme2.ini.model.`object`.SpawnArmy
import de.darkatra.bfme2.ini.model.`object`.SpecialPower
import de.darkatra.bfme2.ini.model.`object`.Stance
import de.darkatra.bfme2.ini.model.`object`.StanceTemplate
import de.darkatra.bfme2.ini.model.`object`.StaticGameLOD
import de.darkatra.bfme2.ini.model.`object`.StrategicHUD
import de.darkatra.bfme2.ini.model.`object`.StreamedSound
import de.darkatra.bfme2.ini.model.`object`.Structure
import de.darkatra.bfme2.ini.model.`object`.SubClass
import de.darkatra.bfme2.ini.model.`object`.Terrain
import de.darkatra.bfme2.ini.model.`object`.TerrainCellType
import de.darkatra.bfme2.ini.model.`object`.ThingStat
import de.darkatra.bfme2.ini.model.`object`.ThreatBreakdown
import de.darkatra.bfme2.ini.model.`object`.Threshold
import de.darkatra.bfme2.ini.model.`object`.Trigger
import de.darkatra.bfme2.ini.model.`object`.Turret
import de.darkatra.bfme2.ini.model.`object`.TurretModule
import de.darkatra.bfme2.ini.model.`object`.UnitCategory
import de.darkatra.bfme2.ini.model.`object`.UnitDefinition
import de.darkatra.bfme2.ini.model.`object`.UnitSpecificSounds
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.`object`.VictorySystemData
import de.darkatra.bfme2.ini.model.`object`.Video
import de.darkatra.bfme2.ini.model.`object`.ViewInfo
import de.darkatra.bfme2.ini.model.`object`.WaterSet
import de.darkatra.bfme2.ini.model.`object`.WaterTextureList
import de.darkatra.bfme2.ini.model.`object`.WaterTransparency
import de.darkatra.bfme2.ini.model.`object`.Weapon
import de.darkatra.bfme2.ini.model.`object`.WeaponSet
import de.darkatra.bfme2.ini.model.`object`.WeatherData
import de.darkatra.bfme2.ini.model.`object`.WebpageURL
import de.darkatra.bfme2.ini.model.`object`.WindowTransition
import de.darkatra.bfme2.ini.model.particle.Alpha
import de.darkatra.bfme2.ini.model.particle.Color
import de.darkatra.bfme2.ini.model.particle.EmissionVelocity
import de.darkatra.bfme2.ini.model.particle.EmissionVolume
import de.darkatra.bfme2.ini.model.particle.Emitter
import de.darkatra.bfme2.ini.model.particle.ParticleSystem
import de.darkatra.bfme2.ini.model.particle.Physics
import de.darkatra.bfme2.ini.model.particle.System
import de.darkatra.bfme2.ini.model.particle.Update
import de.darkatra.bfme2.ini.model.particle.Wind
import de.darkatra.bfme2.ini.model.ui.DecalTemplate
import de.darkatra.bfme2.ini.model.ui.GridDecalTemplate
import de.darkatra.bfme2.ini.model.ui.ImagePart
import de.darkatra.bfme2.ini.model.ui.RadiusCursorTemplate
import de.darkatra.bfme2.ini.model.ui.Transition
import de.darkatra.bfme2.ini.model.ui.Window

/**
 * Entry point to the descriptors of all blocks that can appear in INI files.
 */
object SageIniModel {

    val blocks: List<SageIniBlockDescriptor<*>> by lazy {
        listOf(
            SideSound,
            SoundSet,
            SoundUpgrade,
            AIGateUpdate,
            AISpecialPowerUpdate,
            AIUpdateBehavior,
            AIUpdateInterface,
            AODCrushCollide,
            AODHordeContain,
            ActivateModuleSpecialPower,
            ActiveBody,
            AimWeaponBehavior,
            AllowBannerSpawnUpgrade,
            AnimalAIUpdate,
            AnimatedParticleSysBoneClientUpdate,
            AnimationSoundClientBehavior,
            AnnounceBirthAndDeathBehavior,
            ArmorUpgrade,
            ArrowStormUpdate,
            AssaultTransportAIUpdate,
            AssistedTargetingUpdate,
            AttachUpdate,
            AttributeModifierAuraUpdate,
            AttributeModifierPoolUpdate,
            AttributeModifierUpgrade,
            AudioLoopUpgrade,
            AutoAbilityBehavior,
            AutoDepositUpdate,
            AutoFindHealingUpdate,
            AutoHealBehavior,
            AutoPickUpUpdate,
            BannerCarrierUpdate,
            BaseUpgrade,
            BattleBusSlowDeathBehavior,
            BattlePlanUpdate,
            BeaconClientUpdate,
            BezierProjectileBehavior,
            BloodthirstyUpdate,
            Body,
            BoneFXDamage,
            BoneFXUpdate,
            BoredUpdate,
            BridgeBehavior,
            BridgeScaffoldBehavior,
            BridgeTowerBehavior,
            BroadcastStealthUpdate,
            BuildableHeroListUpgrade,
            BuildingBehavior,
            CallHelpOnDamage,
            CashHackSpecialPower,
            CastleBehavior,
            CastleMemberBehavior,
            CastleUpgrade,
            CaveContain,
            ChinookAIUpdate,
            CitadelSlaughterHordeContain,
            CivilianSpawnCollide,
            CivilianSpawnUpdate,
            ClearanceTestingSlowDeathBehavior,
            ClickReactionBehavior,
            CloudBreakSpecialPower,
            CombineHordeSpecialPower,
            CommandButtonHuntUpdate,
            CommandPointsUpgrade,
            CommandSetUpgrade,
            ContainBehavior,
            ConvertToCarBombCrateCollide,
            ConvertToHijackedVehicleCrateCollide,
            CostModifierUpgrade,
            CrateCollide,
            CreateCrateDie,
            CreateObjectDie,
            CreateObjectDieBehavior,
            CreateObjectDieIfEldestKindof,
            CritterEmitterUpdate,
            CrushDie,
            CurseSpecialPower,
            DamDie,
            DamageFieldUpdate,
            DamageFilteredCreateObjectDie,
            DarknessSpecialPower,
            DefaultProductionExitUpdate,
            DefectorSpecialPower,
            DeflectSpecialPower,
            DelayedDeathBody,
            DelayedLuaEventUpdate,
            DelayedUpgrade,
            DelayedWeaponSetUpgradeUpdate,
            DeletionUpdate,
            DeliverPayloadAIUpdate,
            DemoTrapUpdate,
            DeployStyleAIUpdate,
            DestroyDie,
            DestroyEnvironmentUpdate,
            DetachableRiderBody,
            DetachableRiderUpdate,
            DevastateSpecialPower,
            DieBehavior,
            DoCommandUpgrade,
            DominateEnemySpecialPower,
            DozerAIUpdate,
            DualWeaponBehavior,
            DynamicPortalBehaviour,
            DynamicShroudClearingRangeUpdate,
            EjectPilotDie,
            ElvenWoodSpecialPower,
            EmotionTrackerUpdate,
            EnragedBehavior,
            EntEnragedUpdate,
            EvaAnnounceClientCreate,
            EvacuateDamage,
            EvacuateGarrisonSpecialPower,
            ExperienceLevelCreate,
            ExperienceScalarUpgrade,
            FXListDie,
            FadeAndDieOrnamentUpdate,
            FakePathfindPortalBehaviour,
            FellBeastSwoopPower,
            FireSpreadUpdate,
            FireWeaponCollide,
            FireWeaponUpdate,
            FireWeaponWhenDamagedBehavior,
            FireWeaponWhenDeadBehavior,
            FlammableUpdate,
            FlingPassengerSpecialAbilityUpdate,
            FloatUpdate,
            FloodUpdate,
            FoundationAIUpdate,
            FreeLifeBody,
            FreezingRainSpecialPower,
            GarrisonContain,
            GarrisonUpgrade,
            GateBehavior,
            GateOpenAndCloseBehavior,
            GateProxyBehavior,
            GeometryUpgrade,
            GettingBuiltBehavior,
            GiantBirdAIUpdate,
            GiantBirdSlowDeathBehavior,
            GiveOrRestoreUpgradeSpecialPower,
            GiveUpgradeUpdate,
            GloriousChargeUpdate,
            GrabPassengerSpecialPower,
            GrantUpgradeCreate,
            HackInternetAIUpdate,
            HealContain,
            HealCrateCollide,
            HeightDieUpdate,
            HelicopterSlowDeathBehavior,
            HelixContain,
            HeroDie,
            HeroModeSpecialAbilityUpdate,
            HighlanderBody,
            HijackerUpdate,
            HitReactionBehavior,
            HiveStructureBody,
            HordeAIUpdate,
            HordeContain,
            HordeDispatchSpecialPower,
            HordeGarrisonContain,
            HordeMemberCollide,
            HordeNotifyTargetsOfImminentProbableCrushingUpdate,
            HordeSiegeEngineContain,
            HordeTransportContain,
            HordeTransportContainDamage,
            HordeWorkerAIUpdate,
            HorseHordeContain,
            ImmortalBody,
            InactiveBody,
            InheritUpgradeCreate,
            InstantDeathBehavior,
            InternetHackContain,
            InvisibilitySpecialPower,
            InvisibilityUpdate,
            JetAIUpdate,
            JetSlowDeathBehavior,
            KeepObjectDie,
            LargeGroupAudioUpdate,
            LargeGroupBonusUpdate,
            LaserUpdate,
            LevelGrantSpecialPower,
            LevelUpUpgrade,
            LifetimeUpdate,
            ListUpgradeoundSelectorClientBehavior,
            LockWeaponCreate,
            LocomotorSetUpgrade,
            ManTheWallsSpecialPower,
            MaxHealthUpgrade,
            MeleeBehavior,
            MineshaftPortalBehaviour,
            MissileAIUpdate,
            MissileUpdate,
            ModelConditionAudioLoopClientBehavior,
            ModelConditionSoundSelectorClientBehavior,
            ModelConditionSpecialAbilityUpdate,
            ModelConditionUpgrade,
            MoneyCrateCollide,
            MonitorConditionUpdate,
            MonsterDockUpdate,
            NeutronMissileSlowDeathBehavior,
            NotifyTargetsOfImminentProbableCrushingUpdate,
            OCLSpecialPower,
            OCLUpdate,
            OathbreakerBody,
            OathbreakersFadeAwayBehavior,
            ObjectCreationUpgrade,
            OilSpillUpdate,
            OneRingPenaltyUpdate,
            OpenContain,
            OverlordContain,
            ParachuteContain,
            PartTheHeavensUpdate,
            PassiveAreaEffectBehavior,
            PhysicsBehavior,
            PickupStuffUpdate,
            PillageModule,
            PlayerHealSpecialPower,
            PlayerUpgradeSpecialPower,
            PoisonedBehavior,
            PorcupineFormationBodyModule,
            PreorderCreate,
            ProductionQueueHordeContain,
            ProductionSpeedBonus,
            ProductionUpdate,
            ProjectileStreamUpdate,
            ProneUpdate,
            PropagandaTowerBehavior,
            QueueProductionExitUpdate,
            RadarMarkerClientUpdate,
            RadarUpdate,
            RadarUpgrade,
            RadiateFearUpdate,
            RadiusDecalUpdate,
            RailedTransportAIUpdate,
            RailedTransportContain,
            RainOfFireUpdate,
            RampageBehavior,
            RandomSoundSelectorClientBehavior,
            RebuildHoleBehavior,
            RebuildHoleExposeDie,
            ReflectDamage,
            RefundDie,
            RemoveUpgradeUpgrade,
            RepairDockUpdate,
            RepairSpecialPower,
            ReplaceObjectUpdate,
            ReplaceSelfUpgrade,
            ReplenishUnitsBehavior,
            RespawnBody,
            RespawnUpdate,
            RiderChangeContain,
            RousingSpeechUpdate,
            RubbleRiseUpdate,
            RunOffMapBehavior,
            SabotageCommandCenterCrateCollide,
            SabotageFakeBuildingCrateCollide,
            SabotageInternetCenterCrateCollide,
            SabotageMilitaryFactoryCrateCollide,
            SabotagePowerPlantCrateCollide,
            SabotageSuperweaponCrateCollide,
            SabotageSupplyCenterCrateCollide,
            SalvageCrateCollide,
            ScaleWallSpecialAbilityUpdate,
            ScavengerSpecialPower,
            ShareExperienceBehavior,
            ShipSlowDeathBehavior,
            ShroudCrateCollide,
            SiegeAIUpdate,
            SiegeDeployHordeSpecialPower,
            SiegeDeploySpecialPower,
            SiegeDockingBehavior,
            SiegeEngineContain,
            SlaughterHordeContain,
            SlaveWatcherBehavior,
            SlavedUpdate,
            SlowDeathBehavior,
            SpawnBehavior,
            SpawnPointProductionExitUpdate,
            SpawnUnitBehavior,
            SpecialAbilityUpdate,
            SpecialDisguiseUpdate,
            SpecialEnemySenseUpdate,
            SpecialPowerBehavior,
            SpecialPowerCompletionDie,
            SpecialPowerCreate,
            SpecialPowerModule,
            SpecialPowerModuleBehavior,
            SpecialPowerTimerRefreshSpecialPower,
            SpellRechargeModifierUpgrade,
            SplitHordeSpecialPower,
            SquishCollide,
            StancesBehavior,
            StatusBitsUpgrade,
            StatusBitsUpgradeIfEldestKindof,
            StealthDetectorUpdate,
            StealthUpdate,
            StealthUpgrade,
            StopSpecialPower,
            StoreObjectsSpecialPower,
            StrafeAreaUpdate,
            StructureBody,
            StructureCollapseUpdate,
            StructureToppleUpdate,
            SubObjectsUpgrade,
            SummonReplacementSpecialAbilityUpdate,
            SupplyAIUpdate,
            SupplyCenterCreate,
            SupplyCenterDockUpdate,
            SupplyCenterProductionExitUpdate,
            SupplyTruckAIUpdate,
            SupplyWarehouseCreate,
            SupplyWarehouseCripplingBehavior,
            SupplyWarehouseDockUpdate,
            SwayClientUpdate,
            SymbioticStructuresBody,
            TaintSpecialPower,
            TeleportSpecialAbilityUpdate,
            TeleportToCasterSpecialPower,
            TemporarilyDefectUpdate,
            TerrainResourceBehavior,
            TerrainResourceClientBehavior,
            ThreatFinderUpdate,
            ToggleDeploySpecialAbilityUpdate,
            ToggleHiddenSpecialAbilityUpdate,
            ToggleMountedSpecialAbilityUpdate,
            TooltipUpgrade,
            ToppleUpdate,
            TransitionDamageFX,
            TransportAIUpdate,
            TransportContain,
            TunnelContain,
            UndeadBody,
            UnitCrateCollide,
            UnleashSpecialPower,
            UnpauseSpecialPowerUpgrade,
            UntamedAllegianceSpecialPower,
            UpgradeBehavior,
            UpgradeDie,
            UpgradeSoundSelectorClientBehavior,
            VeterancyCrateCollide,
            WallHubBehavior,
            WallUpgradeUpdate,
            WanderAIUpdate,
            WargBehavior,
            WeaponBonusUpgrade,
            WeaponChangeSpecialPowerModule,
            WeaponFireSpecialAbilityUpdate,
            WeaponModeSpecialPowerUpdate,
            WeaponSetSpecialAbilityUpdate,
            WeaponSetUpgrade,
            WorkerAIUpdate,
            WoundArrowUpdate,
            Event,
            FCurve,
            SageBlockHeader,
            Animation,
            AnimationState,
            ButterflyDraw,
            DefaultAnimationState,
            DefaultDraw,
            DefaultModelConditionState,
            Draw,
            GpuDraw,
            IdleAnimationState,
            LightningDraw,
            LodOptions,
            ModelConditionState,
            QuadDraw,
            RenderObjectDraw,
            SoundState,
            StreakDraw,
            TransitionState,
            W3DBoatWakeModelDraw,
            W3DBuffDraw,
            W3DDebrisDraw,
            W3DDefaultDraw,
            W3DDependencyModelDraw,
            W3DFloorDraw,
            W3DHordeModelDraw,
            W3DLaserDraw,
            W3DLightDraw,
            W3DModelDraw,
            W3DOverlordTankDraw,
            W3DOverlordTruckDraw,
            W3DPoliceCarDraw,
            W3DProjectileStreamDraw,
            W3DPropDraw,
            W3DQuadrupedDraw,
            W3DRopeDraw,
            W3DSailModelDraw,
            W3DScienceModelDraw,
            W3DScriptedModelDraw,
            W3DStreakDraw,
            W3DSupplyDraw,
            W3DTankDraw,
            W3DTankTruckDraw,
            W3DTornadoDraw,
            W3DTracerDraw,
            W3DTreeDraw,
            W3DTruckDraw,
            ApplyRandomForce,
            AttachedModel,
            BuffNugget,
            CameraShakerVolume,
            CreateDebris,
            DynamicDecal,
            EvaEvent,
            FXListAtBonePos,
            FireWeapon,
            LightPulse,
            Sound,
            TerrainScorch,
            TintDrawable,
            ViewShake,
            Act,
            AddPlayer,
            ArmyEntry,
            ArmyMemberDefinition,
            ArmyToSpawn,
            Bonus,
            BonusForLevel,
            BordersEffect,
            BrutalDifficultyCheats,
            BuildingNugget,
            ColorIntensityControlPoint,
            Connection,
            DefeatCondition,
            DifficultyTuning,
            EnableRegion,
            EyeTower,
            EyeTowerPoints,
            FilledOwnershipEffect,
            HomeRegionHighlight,
            LivingWorldIconObject,
            Mission,
            MouseoverEffectFlareup,
            MoveArmy,
            MoveCamera,
            OwnershipSet,
            PlayerDefeatCondition,
            PlayerVictoryCondition,
            Region,
            RegionEffect,
            RegionSelectionEffect,
            RestrictBuildings,
            Scenario,
            SetPlayerControlOfArmy,
            SideInfo,
            SkirmishBuildList,
            SpawnArmies,
            SpawnBuildings,
            StartingRestriction,
            TeamDefeatCondition,
            TeamVictoryCondition,
            UnifiedEffect,
            VictoryCondition,
            WorldText,
            AttributeModifierNugget,
            ClearNuggets,
            DOTNugget,
            DamageContainedNugget,
            DamageFieldNugget,
            DamageNugget,
            EmotionWeaponNugget,
            FireLogicNugget,
            FireWeaponNugget,
            GrabNugget,
            HordeAttackNugget,
            InvisibilityNugget,
            LuaEventNugget,
            MetaImpactNugget,
            OpenGateNugget,
            ParalyzeNugget,
            ProjectileNugget,
            SlaveAttackNugget,
            SpawnAndFadeNugget,
            SpecialModelConditionNugget,
            StealMoneyNugget,
            WeaponEffectNugget,
            WeaponOCLNugget,
            AIBase,
            AIData,
            AIDozerAssignment,
            AIEconomyAssigment,
            AIWallNodeAssignment,
            AddEmotion,
            AddModule,
            AmbientStream,
            AnimationSoundClientBehaviorGlobalSetting,
            AptButtonTooltipMap,
            Armor,
            ArmorSet,
            ArmyDefinition,
            ArmySummaryDescription,
            Attack,
            AttackPriority,
            Attribute,
            AudioEvent,
            AudioLOD,
            AudioSettings,
            AutoResolveArmor,
            AutoResolveBody,
            AutoResolveCombatChain,
            AutoResolveHandicapLevel,
            AutoResolveLeadership,
            AutoResolveReinforcementSchedule,
            AutoResolveWeapon,
            AwardSystem,
            BannerType,
            Bridge,
            ButtonSet,
            ChildObject,
            CloudEffect,
            CombatChainDefinition,
            CommandButton,
            CommandMap,
            CommandSet,
            ConcurrentRegionBonus,
            ControlBarResizer,
            ControlBarScheme,
            CrateData,
            CreateAHeroBling,
            CreateAHeroBlingBinder,
            CreateAHeroClass,
            CreateAHeroSystem,
            CreateObject,
            Credits,
            CrowdResponse,
            DamageFX,
            DebugCommandMap,
            DeliverPayload,
            DialogEvent,
            DrawGroupInfo,
            DynamicGameLOD,
            EmotionNugget,
            EvaEventBase,
            ExperienceLevel,
            ExperienceScalarTable,
            FXList,
            FXParticleSystem,
            FactionVictoryData,
            Fire,
            FireEffect,
            FireLogicSystem,
            Flammability,
            FloodMember,
            FontDefaultSettings,
            FontSubstitution,
            FormationAssistant,
            FormationPreviewDecal,
            FormationPreviewItemDecal,
            FormationSelection,
            FormationTemplate,
            GameData,
            GeometryShape,
            GlowEffect,
            HouseColor,
            InGameNotificationBox,
            InGameUI,
            InheritableModule,
            LargeGroupAudioMap,
            LargeGroupAudioUnusedKnownKeys,
            LightPointLevel,
            LinearCampaign,
            LivingWorldAITemplate,
            LivingWorldAnimObject,
            LivingWorldArmyIcon,
            LivingWorldAutoResolveResourceBonus,
            LivingWorldAutoResolveSciencePurchasePointBonus,
            LivingWorldBuildPlotIcon,
            LivingWorldBuilding,
            LivingWorldBuildingIcon,
            LivingWorldCampaign,
            LivingWorldMapInfo,
            LivingWorldObject,
            LivingWorldPlayerArmy,
            LivingWorldPlayerTemplate,
            LivingWorldRegionCampaign,
            LivingWorldRegionEffects,
            LivingWorldSound,
            LoadSubsystem,
            Locomotor,
            LocomotorSet,
            MappedImage,
            MiscAudio,
            MiscEvaData,
            ModifierList,
            Mouse,
            MouseCursor,
            MultiplayerColor,
            MultiplayerSettings,
            Multisound,
            MusicTrack,
            NewEvaEvent,
            NotificationType,
            Object,
            ObjectAward,
            ObjectCreationList,
            ObjectReskin,
            OnlineChatColors,
            OptionGroup,
            Pathfinder,
            PlayerAIType,
            PlayerTemplate,
            PredefinedEvaEvent,
            ProductionModifier,
            Rank,
            RegionCampain,
            ReplaceModule,
            ReplaceObject,
            RingEffect,
            Road,
            Rows,
            Science,
            ScoredKillEvaAnnouncer,
            SelectionDecal,
            ShadowMap,
            ShellMenuScheme,
            SkirmishAIData,
            SkyboxTextureSet,
            SpawnArmy,
            SpecialPower,
            Stance,
            StanceTemplate,
            StaticGameLOD,
            StrategicHUD,
            StreamedSound,
            Structure,
            SubClass,
            Terrain,
            TerrainCellType,
            ThingStat,
            ThreatBreakdown,
            Threshold,
            Trigger,
            Turret,
            TurretModule,
            UnitCategory,
            UnitDefinition,
            UnitSpecificSounds,
            Upgrade,
            VictorySystemData,
            Video,
            ViewInfo,
            WaterSet,
            WaterTextureList,
            WaterTransparency,
            Weapon,
            WeaponSet,
            WeatherData,
            WebpageURL,
            WindowTransition,
            Alpha,
            Color,
            EmissionVelocity,
            EmissionVolume,
            Emitter,
            ParticleSystem,
            Physics,
            System,
            Update,
            Wind,
            DecalTemplate,
            GridDecalTemplate,
            ImagePart,
            RadiusCursorTemplate,
            Transition,
            Window,
        )
    }

    val behaviors: List<SageIniBlockDescriptor<out SageBehavior>> by lazy {
        listOf(
            AIGateUpdate,
            AISpecialPowerUpdate,
            AIUpdateBehavior,
            AIUpdateInterface,
            AODCrushCollide,
            AODHordeContain,
            ActivateModuleSpecialPower,
            ActiveBody,
            AimWeaponBehavior,
            AllowBannerSpawnUpgrade,
            AnimalAIUpdate,
            AnimatedParticleSysBoneClientUpdate,
            AnimationSoundClientBehavior,
            AnnounceBirthAndDeathBehavior,
            ArmorUpgrade,
            ArrowStormUpdate,
            AssaultTransportAIUpdate,
            AssistedTargetingUpdate,
            AttachUpdate,
            AttributeModifierAuraUpdate,
            AttributeModifierPoolUpdate,
            AttributeModifierUpgrade,
            AudioLoopUpgrade,
            AutoAbilityBehavior,
            AutoDepositUpdate,
            AutoFindHealingUpdate,
            AutoHealBehavior,
            AutoPickUpUpdate,
            BannerCarrierUpdate,
            BaseUpgrade,
            BattleBusSlowDeathBehavior,
            BattlePlanUpdate,
            BeaconClientUpdate,
            BezierProjectileBehavior,
            BloodthirstyUpdate,
            Body,
            BoneFXDamage,
            BoneFXUpdate,
            BoredUpdate,
            BridgeBehavior,
            BridgeScaffoldBehavior,
            BridgeTowerBehavior,
            BroadcastStealthUpdate,
            BuildableHeroListUpgrade,
            BuildingBehavior,
            CallHelpOnDamage,
            CashHackSpecialPower,
            CastleBehavior,
            CastleMemberBehavior,
            CastleUpgrade,
            CaveContain,
            ChinookAIUpdate,
            CitadelSlaughterHordeContain,
            CivilianSpawnCollide,
            CivilianSpawnUpdate,
            ClearanceTestingSlowDeathBehavior,
            ClickReactionBehavior,
            CloudBreakSpecialPower,
            CombineHordeSpecialPower,
            CommandButtonHuntUpdate,
            CommandPointsUpgrade,
            CommandSetUpgrade,
            ContainBehavior,
            ConvertToCarBombCrateCollide,
            ConvertToHijackedVehicleCrateCollide,
            CostModifierUpgrade,
            CrateCollide,
            CreateCrateDie,
            CreateObjectDie,
            CreateObjectDieBehavior,
            CreateObjectDieIfEldestKindof,
            CritterEmitterUpdate,
            CrushDie,
            CurseSpecialPower,
            DamDie,
            DamageFieldUpdate,
            DamageFilteredCreateObjectDie,
            DarknessSpecialPower,
            DefaultProductionExitUpdate,
            DefectorSpecialPower,
            DeflectSpecialPower,
            DelayedDeathBody,
            DelayedLuaEventUpdate,
            DelayedUpgrade,
            DelayedWeaponSetUpgradeUpdate,
            DeletionUpdate,
            DeliverPayloadAIUpdate,
            DemoTrapUpdate,
            DeployStyleAIUpdate,
            DestroyDie,
            DestroyEnvironmentUpdate,
            DetachableRiderBody,
            DetachableRiderUpdate,
            DevastateSpecialPower,
            DieBehavior,
            DoCommandUpgrade,
            DominateEnemySpecialPower,
            DozerAIUpdate,
            DualWeaponBehavior,
            DynamicPortalBehaviour,
            DynamicShroudClearingRangeUpdate,
            EjectPilotDie,
            ElvenWoodSpecialPower,
            EmotionTrackerUpdate,
            EnragedBehavior,
            EntEnragedUpdate,
            EvaAnnounceClientCreate,
            EvacuateDamage,
            EvacuateGarrisonSpecialPower,
            ExperienceLevelCreate,
            ExperienceScalarUpgrade,
            FXListDie,
            FadeAndDieOrnamentUpdate,
            FakePathfindPortalBehaviour,
            FellBeastSwoopPower,
            FireSpreadUpdate,
            FireWeaponCollide,
            FireWeaponUpdate,
            FireWeaponWhenDamagedBehavior,
            FireWeaponWhenDeadBehavior,
            FlammableUpdate,
            FlingPassengerSpecialAbilityUpdate,
            FloatUpdate,
            FloodUpdate,
            FoundationAIUpdate,
            FreeLifeBody,
            FreezingRainSpecialPower,
            GarrisonContain,
            GarrisonUpgrade,
            GateBehavior,
            GateOpenAndCloseBehavior,
            GateProxyBehavior,
            GeometryUpgrade,
            GettingBuiltBehavior,
            GiantBirdAIUpdate,
            GiantBirdSlowDeathBehavior,
            GiveOrRestoreUpgradeSpecialPower,
            GiveUpgradeUpdate,
            GloriousChargeUpdate,
            GrabPassengerSpecialPower,
            GrantUpgradeCreate,
            HackInternetAIUpdate,
            HealContain,
            HealCrateCollide,
            HeightDieUpdate,
            HelicopterSlowDeathBehavior,
            HelixContain,
            HeroDie,
            HeroModeSpecialAbilityUpdate,
            HighlanderBody,
            HijackerUpdate,
            HitReactionBehavior,
            HiveStructureBody,
            HordeAIUpdate,
            HordeContain,
            HordeDispatchSpecialPower,
            HordeGarrisonContain,
            HordeMemberCollide,
            HordeNotifyTargetsOfImminentProbableCrushingUpdate,
            HordeSiegeEngineContain,
            HordeTransportContain,
            HordeTransportContainDamage,
            HordeWorkerAIUpdate,
            HorseHordeContain,
            ImmortalBody,
            InactiveBody,
            InheritUpgradeCreate,
            InstantDeathBehavior,
            InternetHackContain,
            InvisibilitySpecialPower,
            InvisibilityUpdate,
            JetAIUpdate,
            JetSlowDeathBehavior,
            KeepObjectDie,
            LargeGroupAudioUpdate,
            LargeGroupBonusUpdate,
            LaserUpdate,
            LevelGrantSpecialPower,
            LevelUpUpgrade,
            LifetimeUpdate,
            ListUpgradeoundSelectorClientBehavior,
            LockWeaponCreate,
            LocomotorSetUpgrade,
            ManTheWallsSpecialPower,
            MaxHealthUpgrade,
            MineshaftPortalBehaviour,
            MissileAIUpdate,
            MissileUpdate,
            ModelConditionAudioLoopClientBehavior,
            ModelConditionSoundSelectorClientBehavior,
            ModelConditionSpecialAbilityUpdate,
            ModelConditionUpgrade,
            MoneyCrateCollide,
            MonitorConditionUpdate,
            MonsterDockUpdate,
            NeutronMissileSlowDeathBehavior,
            NotifyTargetsOfImminentProbableCrushingUpdate,
            OCLSpecialPower,
            OCLUpdate,
            OathbreakerBody,
            OathbreakersFadeAwayBehavior,
            ObjectCreationUpgrade,
            OilSpillUpdate,
            OneRingPenaltyUpdate,
            OpenContain,
            OverlordContain,
            ParachuteContain,
            PartTheHeavensUpdate,
            PassiveAreaEffectBehavior,
            PhysicsBehavior,
            PickupStuffUpdate,
            PillageModule,
            PlayerHealSpecialPower,
            PlayerUpgradeSpecialPower,
            PoisonedBehavior,
            PorcupineFormationBodyModule,
            PreorderCreate,
            ProductionQueueHordeContain,
            ProductionSpeedBonus,
            ProductionUpdate,
            ProjectileStreamUpdate,
            ProneUpdate,
            PropagandaTowerBehavior,
            QueueProductionExitUpdate,
            RadarMarkerClientUpdate,
            RadarUpdate,
            RadarUpgrade,
            RadiateFearUpdate,
            RadiusDecalUpdate,
            RailedTransportAIUpdate,
            RailedTransportContain,
            RainOfFireUpdate,
            RampageBehavior,
            RandomSoundSelectorClientBehavior,
            RebuildHoleBehavior,
            RebuildHoleExposeDie,
            ReflectDamage,
            RefundDie,
            RemoveUpgradeUpgrade,
            RepairDockUpdate,
            RepairSpecialPower,
            ReplaceObjectUpdate,
            ReplaceSelfUpgrade,
            ReplenishUnitsBehavior,
            RespawnBody,
            RespawnUpdate,
            RiderChangeContain,
            RousingSpeechUpdate,
            RubbleRiseUpdate,
            RunOffMapBehavior,
            SabotageCommandCenterCrateCollide,
            SabotageFakeBuildingCrateCollide,
            SabotageInternetCenterCrateCollide,
            SabotageMilitaryFactoryCrateCollide,
            SabotagePowerPlantCrateCollide,
            SabotageSuperweaponCrateCollide,
            SabotageSupplyCenterCrateCollide,
            SalvageCrateCollide,
            ScaleWallSpecialAbilityUpdate,
            ScavengerSpecialPower,
            ShareExperienceBehavior,
            ShipSlowDeathBehavior,
            ShroudCrateCollide,
            SiegeAIUpdate,
            SiegeDeployHordeSpecialPower,
            SiegeDeploySpecialPower,
            SiegeDockingBehavior,
            SiegeEngineContain,
            SlaughterHordeContain,
            SlaveWatcherBehavior,
            SlavedUpdate,
            SlowDeathBehavior,
            SpawnBehavior,
            SpawnPointProductionExitUpdate,
            SpawnUnitBehavior,
            SpecialAbilityUpdate,
            SpecialDisguiseUpdate,
            SpecialEnemySenseUpdate,
            SpecialPowerBehavior,
            SpecialPowerCompletionDie,
            SpecialPowerCreate,
            SpecialPowerModule,
            SpecialPowerModuleBehavior,
            SpecialPowerTimerRefreshSpecialPower,
            SpellRechargeModifierUpgrade,
            SplitHordeSpecialPower,
            SquishCollide,
            StancesBehavior,
            StatusBitsUpgrade,
            StatusBitsUpgradeIfEldestKindof,
            StealthDetectorUpdate,
            StealthUpdate,
            StealthUpgrade,
            StopSpecialPower,
            StoreObjectsSpecialPower,
            StrafeAreaUpdate,
            StructureBody,
            StructureCollapseUpdate,
            StructureToppleUpdate,
            SubObjectsUpgrade,
            SummonReplacementSpecialAbilityUpdate,
            SupplyAIUpdate,
            SupplyCenterCreate,
            SupplyCenterDockUpdate,
            SupplyCenterProductionExitUpdate,
            SupplyTruckAIUpdate,
            SupplyWarehouseCreate,
            SupplyWarehouseCripplingBehavior,
            SupplyWarehouseDockUpdate,
            SwayClientUpdate,
            SymbioticStructuresBody,
            TaintSpecialPower,
            TeleportSpecialAbilityUpdate,
            TeleportToCasterSpecialPower,
            TemporarilyDefectUpdate,
            TerrainResourceBehavior,
            TerrainResourceClientBehavior,
            ThreatFinderUpdate,
            ToggleDeploySpecialAbilityUpdate,
            ToggleHiddenSpecialAbilityUpdate,
            ToggleMountedSpecialAbilityUpdate,
            TooltipUpgrade,
            ToppleUpdate,
            TransitionDamageFX,
            TransportAIUpdate,
            TransportContain,
            TunnelContain,
            UndeadBody,
            UnitCrateCollide,
            UnleashSpecialPower,
            UnpauseSpecialPowerUpgrade,
            UntamedAllegianceSpecialPower,
            UpgradeBehavior,
            UpgradeDie,
            UpgradeSoundSelectorClientBehavior,
            VeterancyCrateCollide,
            WallHubBehavior,
            WallUpgradeUpdate,
            WanderAIUpdate,
            WargBehavior,
            WeaponBonusUpgrade,
            WeaponChangeSpecialPowerModule,
            WeaponFireSpecialAbilityUpdate,
            WeaponModeSpecialPowerUpdate,
            WeaponSetSpecialAbilityUpdate,
            WeaponSetUpgrade,
            WorkerAIUpdate,
            WoundArrowUpdate,
        )
    }

    val draws: List<SageIniBlockDescriptor<out SageDraw>> by lazy {
        listOf(
            ButterflyDraw,
            DefaultDraw,
            GpuDraw,
            LightningDraw,
            QuadDraw,
            RenderObjectDraw,
            StreakDraw,
            W3DBoatWakeModelDraw,
            W3DBuffDraw,
            W3DDebrisDraw,
            W3DDefaultDraw,
            W3DDependencyModelDraw,
            W3DFloorDraw,
            W3DHordeModelDraw,
            W3DLaserDraw,
            W3DLightDraw,
            W3DModelDraw,
            W3DOverlordTankDraw,
            W3DOverlordTruckDraw,
            W3DPoliceCarDraw,
            W3DProjectileStreamDraw,
            W3DPropDraw,
            W3DQuadrupedDraw,
            W3DRopeDraw,
            W3DSailModelDraw,
            W3DScienceModelDraw,
            W3DScriptedModelDraw,
            W3DStreakDraw,
            W3DSupplyDraw,
            W3DTankDraw,
            W3DTankTruckDraw,
            W3DTornadoDraw,
            W3DTracerDraw,
            W3DTreeDraw,
            W3DTruckDraw,
        )
    }

    val nuggets: List<SageIniBlockDescriptor<out SageNugget>> by lazy {
        listOf(
            AttributeModifierNugget,
            ClearNuggets,
            DOTNugget,
            DamageContainedNugget,
            DamageFieldNugget,
            DamageNugget,
            EmotionWeaponNugget,
            FireLogicNugget,
            FireWeaponNugget,
            GrabNugget,
            HordeAttackNugget,
            InvisibilityNugget,
            LuaEventNugget,
            MetaImpactNugget,
            OpenGateNugget,
            ParalyzeNugget,
            ProjectileNugget,
            SlaveAttackNugget,
            SpawnAndFadeNugget,
            SpecialModelConditionNugget,
            StealMoneyNugget,
            WeaponEffectNugget,
            WeaponOCLNugget,
        )
    }

    /**
     * Blocks that register named declarations in a global table, e.g. `Object`, `Weapon` or `Upgrade`.
     */
    val declarations: List<SageIniBlockDescriptor<*>> by lazy {
        blocks.filter { it.effectiveTableKey != null && !it.isAbstract }
    }

    private val blocksByName: Map<String, SageIniBlockDescriptor<*>> by lazy {
        blocks.filterNot { it.isAbstract }.associateBy { it.name.lowercase() }
    }

    /**
     * Finds a block by its INI name, case-insensitively.
     */
    fun block(name: String): SageIniBlockDescriptor<*>? {
        return blocksByName[name.lowercase()]
    }
}
