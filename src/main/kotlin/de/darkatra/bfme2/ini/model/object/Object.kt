package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.SageIniModel
import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageDraw
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.value.ContactPoint
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.EditorSorting
import de.darkatra.bfme2.ini.model.value.FakeToken
import de.darkatra.bfme2.ini.model.value.GeometryType
import de.darkatra.bfme2.ini.model.value.KindOf
import de.darkatra.bfme2.ini.model.value.ObjectShadowType
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.RadarPriority
import de.darkatra.bfme2.ini.model.value.Rgba
import de.darkatra.bfme2.ini.model.value.Untyped

open class Object(
    open val header: SageBlockHeader = SageBlockHeader(),
    open val section1: ObjectSection1 = ObjectSection1(),
    open val section2: ObjectSection2 = ObjectSection2(),
    open val section3: ObjectSection3 = ObjectSection3(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<Object>(
        name = "Object",
        tableKey = "objects",
        headerArity = 2,
        properties = {
            property("EditorSorting", ListValue(EditorSorting.type)) { it.section1.editorSorting }
            property("BuildCost", IntValue) { it.section1.buildCost }
            property("BuildTime", IntValue) { it.section1.buildTime }
            property("ShockwaveResistance", IntValue) { it.section1.shockwaveResistance }
            property("DisplayMeleeDamage", IntValue) { it.section1.displayMeleeDamage }
            property("HeroSortOrder", IntValue) { it.section1.heroSortOrder }
            property("CommandSet", ReferenceValue<CommandSet> { listOf(CommandSet) }) { it.section1.commandSet }
            property("CommandPoints", IntValue) { it.section1.commandPoints }
            property("DisplayName", StringValue) { it.section1.displayName }
            property("RecruitText", StringValue) { it.section1.recruitText }
            property("ReviveText", StringValue) { it.section1.reviveText }
            property("Hotkey", Untyped.type) { it.section1.hotkey }
            property("VisionRange", FloatValue) { it.section1.visionRange }
            property("RefundValue", IntValue) { it.section1.refundValue }
            property("IsForbidden", BooleanValue) { it.section1.isForbidden }
            property("IsBridge", BooleanValue) { it.section1.isBridge }
            property("IsPrerequisite", BooleanValue) { it.section1.isPrerequisite }
            property("KindOf", ListValue(KindOf.type)) { it.section1.kindOf }
            property("ThingClass", StringValue) { it.section1.thingClass }
            property("Side", FakeToken.type) { it.section1.side }
            property("FactionSide", FakeToken.type) { it.section1.factionSide }
            property("Description", StringValue) { it.section1.description }
            property("SelectPortrait", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.section1.selectPortrait }
            property("ButtonImage", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.section1.buttonImage }
            property("RadarPriority", RadarPriority.type) { it.section1.radarPriority }
            property("ThreatLevel", FloatValue) { it.section1.threatLevel }
            property("BuildCompletion", Opaque.type) { it.section1.buildCompletion }
            property("PlacementViewAngle", IntValue) { it.section1.placementViewAngle }
            property("TransportSlotCount", IntValue) { it.section1.transportSlotCount }
            property("BountyValue", IntValue) { it.section1.bountyValue }
            property("CampnessValue", IntValue) { it.section1.campnessValue }
            property("CrushableLevel", IntValue) { it.section1.crushableLevel }
            property("CrusherLevel", IntValue) { it.section1.crusherLevel }
            property("ShroudClearingRange", IntValue) { it.section1.shroudClearingRange }
            property("IsTrainable", BooleanValue) { it.section1.isTrainable }
            property("CrowdResponseKey", ReferenceValue<CrowdResponse> { listOf(CrowdResponse) }) { it.section1.crowdResponseKey }
            property("EmotionRange", IntValue) { it.section1.emotionRange }
            property("InstanceScaleFuzziness", FloatValue) { it.section1.instanceScaleFuzziness }
            property("GeometryUsedForHealthBox", BooleanValue) { it.section1.geometryUsedForHealthBox }
            property("GeometryRotationAnchorOffset", ListValue(Coords.type)) { it.section1.geometryRotationAnchorOffset }
            property("GeometryContactPoint", ListValue(ContactPoint.type)) { it.section1.geometryContactPoint }
            property("AttackContactPoint", ListValue(ContactPoint.type)) { it.section1.attackContactPoint }
            property("Shadow", ObjectShadowType.type) { it.section1.shadow }
            property("ShadowTexture", Opaque.type) { it.section1.shadowTexture }
            property("ShadowSizeX", IntValue) { it.section1.shadowSizeX }
            property("ShadowSizeY", IntValue) { it.section1.shadowSizeY }
            property("ShadowOffsetX", FloatValue) { it.section1.shadowOffsetX }
            property("ShadowMaxHeight", FloatValue) { it.section1.shadowMaxHeight }
            property("ShadowSunAngle", FloatValue) { it.section1.shadowSunAngle }
            property("ShadowOverrideLODVisibility", BooleanValue) { it.section1.shadowOverrideLODVisibility }
            property("ShadowOpacityStart", IntValue) { it.section1.shadowOpacityStart }
            property("ShadowOpacityPeak", IntValue) { it.section1.shadowOpacityPeak }
            property("ShadowOpacityEnd", IntValue) { it.section1.shadowOpacityEnd }
            property("ShadowOpacityFadeInTime", IntValue) { it.section1.shadowOpacityFadeInTime }
            property("ShadowOpacityFadeOutTime", IntValue) { it.section1.shadowOpacityFadeOutTime }
            property("VisionSide", FloatValue) { it.section1.visionSide }
            property("VisionRear", FloatValue) { it.section1.visionRear }
            property("VisionBonusPercentPerFoot", FloatValue) { it.section1.visionBonusPercentPerFoot }
            property("VisionBonusTestRadius", FloatValue) { it.section1.visionBonusTestRadius }
            property("MaxVisionBonusPercent", FloatValue) { it.section1.maxVisionBonusPercent }
            property("VoicePriority", IntValue) { it.section1.voicePriority }
            property("VoiceSelect", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.voiceSelect }
            property("VoiceSelectBattle", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.voiceSelectBattle }
            property("VoiceSelectUnderConstruction", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.voiceSelectUnderConstruction }
            property("VoiceMove", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.voiceMove }
            property("VoiceMoveToCamp", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.voiceMoveToCamp }
            property("VoiceMoveToHigherGround", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.voiceMoveToHigherGround }
            property("VoiceMoveOverWalls", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.voiceMoveOverWalls }
            property("VoiceMoveWhileAttacking", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.voiceMoveWhileAttacking }
            property("VoiceAttack", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.voiceAttack }
            property("VoiceAttackStructure", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.voiceAttackStructure }
            property("VoiceAttackMachine", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.voiceAttackMachine }
            property("VoiceAttackCharge", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.voiceAttackCharge }
            property("VoiceAttackAir", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.voiceAttackAir }
            property("VoiceGuard", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.voiceGuard }
            property("VoiceFear", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.voiceFear }
            property("VoiceCreated", ListValue(ReferenceValue<AudioEvent> { listOf(AudioEvent) })) { it.section1.voiceCreated }
            property("VoiceFullyCreated", ListValue(ReferenceValue<AudioEvent> { listOf(AudioEvent) })) { it.section1.voiceFullyCreated }
            property("VoiceRetreatToCastle", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.voiceRetreatToCastle }
            property("VoiceCombineWithHorde", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.voiceCombineWithHorde }
            property("VoiceTaskComplete", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.voiceTaskComplete }
            property("VoiceAlert", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.voiceAlert }
            property("VoiceDefect", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.voiceDefect }
            property("VoiceEnterStateMove", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.voiceEnterStateMove }
            property("VoiceEnterStateMoveToCamp", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.voiceEnterStateMoveToCamp }
            property("VoiceEnterStateMoveToHigherGround", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.voiceEnterStateMoveToHigherGround }
            property("VoiceEnterStateMoveOverWalls", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.voiceEnterStateMoveOverWalls }
            property("VoiceEnterStateMoveWhileAttacking", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.voiceEnterStateMoveWhileAttacking }
            property("VoiceEnterStateAttack", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.voiceEnterStateAttack }
            property("VoiceEnterStateAttackStructure", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.voiceEnterStateAttackStructure }
            property("VoiceEnterStateAttackMachine", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.voiceEnterStateAttackMachine }
            property("VoiceEnterStateAttackCharge", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.voiceEnterStateAttackCharge }
            property("VoiceEnterStateAttackAir", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.voiceEnterStateAttackAir }
            property("VoiceEnterStateRetreatToCastle", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.voiceEnterStateRetreatToCastle }
            property("SoundOnDamaged", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.soundOnDamaged }
            property("SoundOnReallyDamaged", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.soundOnReallyDamaged }
            property("SoundAmbient", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.soundAmbient }
            property("SoundAmbientDamaged", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.soundAmbientDamaged }
            property("SoundAmbientReallyDamaged", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.soundAmbientReallyDamaged }
            property("SoundAmbientBattle", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.soundAmbientBattle }
            property("SoundAmbientRubble", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.soundAmbientRubble }
            property("SoundImpact", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.soundImpact }
            property("SoundImpactCyclonic", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.soundImpactCyclonic }
            property("SoundCrushing", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.soundCrushing }
            property("SoundCreated", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.soundCreated }
            property("SoundMoveStart", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.soundMoveStart }
            property("SoundMoveStartDamaged", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.soundMoveStartDamaged }
            property("SoundMoveLoop", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.soundMoveLoop }
            property("SoundMoveLoopDamaged", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.soundMoveLoopDamaged }
            property("SoundStealthOn", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.soundStealthOn }
            property("SoundStealthOff", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.soundStealthOff }
            property("SoundEnter", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.soundEnter }
            property("SoundExit", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.soundExit }
            property("SoundFallingFromPlane", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.soundFallingFromPlane }
            property("SoundPromotedVeteran", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.soundPromotedVeteran }
            property("SoundPromotedElite", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.soundPromotedElite }
            property("SoundPromotedHero", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section1.soundPromotedHero }
            property("EvaEventDamagedOwner", ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.section1.evaEventDamagedOwner }
            property(
                "EvaEventDamagedByFireOwner",
                ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.section1.evaEventDamagedByFireOwner }
            property(
                "EvaEventDamagedFromShroudedSourceOwner",
                ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.section1.evaEventDamagedFromShroudedSourceOwner }
            property(
                "EvaEventSecondDamageFarFromFirstOwner",
                ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.section1.evaEventSecondDamageFarFromFirstOwner }
            property("EvaEventDieOwner", ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.section1.evaEventDieOwner }
            property("EvaEventDieAlly", ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.section1.evaEventDieAlly }
            // every `Geometry` or `AdditionalGeometry` line starts a new shape that the following geometry properties belong to
            property("Geometry", GeometryType.type) { it.section3.geometry.firstOrNull()?.type }
            property("AdditionalGeometry", ListValue(GeometryType.type)) { it.section3.geometry.drop(1).mapNotNull { shape -> shape.type } }
            property("GeometryName", ListValue(Opaque.type)) { it.section3.geometry.map { shape -> shape.geometryName } }
            property("GeometryMajorRadius", ListValue(FloatValue)) { it.section3.geometry.map { shape -> shape.geometryMajorRadius } }
            property("GeometryMinorRadius", ListValue(FloatValue)) { it.section3.geometry.map { shape -> shape.geometryMinorRadius } }
            property("GeometryHeight", ListValue(FloatValue)) { it.section3.geometry.map { shape -> shape.geometryHeight } }
            property("GeometryFrontAngle", ListValue(FloatValue)) { it.section3.geometry.map { shape -> shape.geometryFrontAngle } }
            property("GeometryActive", ListValue(BooleanValue)) { it.section3.geometry.map { shape -> shape.geometryActive } }
            property("GeometryIsSmall", ListValue(BooleanValue)) { it.section3.geometry.map { shape -> shape.geometryIsSmall } }
            property("GeometryOffset", ListValue(Coords.type)) { it.section3.geometry.map { shape -> shape.geometryOffset } }
            property("EvaEventDieEnemy", ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.section1.evaEventDieEnemy }
            property("EvaEventAmbushed", ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.section1.evaEventAmbushed }
            property(
                "EvaEnemyObjectSightedEvent",
                ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.section1.evaEnemyObjectSightedEvent }
            property(
                "EvaEnemyObjectSightedAfterRespawnEvent",
                ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.section1.evaEnemyObjectSightedAfterRespawnEvent }
            property(
                "EvaOnFirstSightingEventEnemy",
                ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.section1.evaOnFirstSightingEventEnemy }
            property(
                "EvaOnFirstSightingEventNonEnemy",
                ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.section1.evaOnFirstSightingEventNonEnemy }
            property("EvaEventDetectedEnemy", ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.section1.evaEventDetectedEnemy }
            property("EvaEventDetectedAlly", ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.section1.evaEventDetectedAlly }
            property("EvaEventDetectedOwner", ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.section1.evaEventDetectedOwner }
            property("EvaEventSecondDamageFarFromFirstScanRange", IntValue) { it.section1.evaEventSecondDamageFarFromFirstScanRange }
            property("EvaEventSecondDamageFarFromFirstTimeoutMS", IntValue) { it.section1.evaEventSecondDamageFarFromFirstTimeoutMS }
            property("Model", Opaque.type) { it.section1.model }
            property("Scale", FloatValue) { it.section1.scale }
            property("SubObjects", Opaque.type) { it.section1.subObjects }
            property("OrientAngle", FloatValue) { it.section1.orientAngle }
            property("ZOffset", Untyped.type) { it.section1.zOffset }
            property("Browser", StringValue) { it.section1.browser }
            property("VisibleArmySizes", Untyped.type) { it.section1.visibleArmySizes }
            property("FadeMethod", Untyped.type) { it.section1.fadeMethod }
            property("UseHouseColor", BooleanValue) { it.section2.useHouseColor }
            property("Clickable", BooleanValue) { it.section2.clickable }
            property("Pickbox", Opaque.type) { it.section2.pickbox }
            property("DisplayColor", Rgba.type) { it.section2.displayColor }
            property("GeometryOther", ListValue(StringValue)) { it.section2.geometryOther }
            property("DescriptionStrategic", Untyped.type) { it.section2.descriptionStrategic }
            property("DisplayNameStrategic", Untyped.type) { it.section2.displayNameStrategic }
            property("DisplayNameInvisibleForEnemy", Untyped.type) { it.section2.displayNameInvisibleForEnemy }
            property("AutoResolveUnitType", Opaque.type) { it.section2.autoResolveUnitType }
            property("AutoResolveBody", ReferenceValue<AutoResolveBody> { listOf(AutoResolveBody) }) { it.section2.autoResolveBody }
            property("AutoResolveCombatChain", ReferenceValue<AutoResolveCombatChain> { listOf(AutoResolveCombatChain) }) { it.section2.autoResolveCombatChain }
            property("AutoResolveLeadership", ReferenceValue<AutoResolveLeadership> { listOf(AutoResolveLeadership) }) { it.section2.autoResolveLeadership }
            property("WorldMapArmoryUpgradesAllowed", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.section2.worldMapArmoryUpgradesAllowed }
            property("ExperienceScalarTable", Opaque.type) { it.section2.experienceScalarTable }
            property("KeepSelectableWhenDead", BooleanValue) { it.section2.keepSelectableWhenDead }
            property("HideWhenUnhilighted", BooleanValue) { it.section2.hideWhenUnhilighted }
            property("HideWhenUnselected", BooleanValue) { it.section2.hideWhenUnselected }
            property("ShowOnlyForAllies", BooleanValue) { it.section2.showOnlyForAllies }
            property("HideWhenUnderConstruction", BooleanValue) { it.section2.hideWhenUnderConstruction }
            property("HideWhenNotUnderConstruction", BooleanValue) { it.section2.hideWhenNotUnderConstruction }
            property("HideWhenNotProducing", BooleanValue) { it.section2.hideWhenNotProducing }
            property("DisplayAtRallyPoint", BooleanValue) { it.section2.displayAtRallyPoint }
            property("ShowOnlyAfterMoveOrder", BooleanValue) { it.section2.showOnlyAfterMoveOrder }
            property("ShowHealthInSelectionDecal", BooleanValue) { it.section2.showHealthInSelectionDecal }
            property("FadeTypeForHilighting", Untyped.type) { it.section2.fadeTypeForHilighting }
            property("FadeTypeForUnhilighting", Untyped.type) { it.section2.fadeTypeForUnhilighting }
            property("FadeTypeForSelection", Untyped.type) { it.section2.fadeTypeForSelection }
            property("FadeTypeForShowing", Untyped.type) { it.section2.fadeTypeForShowing }
            property("FadeTypeForHiding", Untyped.type) { it.section2.fadeTypeForHiding }
            property("FadeHoldPercent", Opaque.type) { it.section2.fadeHoldPercent }
            property("FadeInTime", IntValue) { it.section2.fadeInTime }
            property("FadeOutTime", IntValue) { it.section2.fadeOutTime }
            property("CrushWeapon", ReferenceValue<Weapon> { listOf(Weapon) }) { it.section2.crushWeapon }
            property("CrushRevengeWeapon", ReferenceValue<Weapon> { listOf(Weapon) }) { it.section2.crushRevengeWeapon }
            property("UseCrushAttack", BooleanValue) { it.section2.useCrushAttack }
            property("CrushOnlyWhileCharging", BooleanValue) { it.section2.crushOnlyWhileCharging }
            property("CrushAllies", BooleanValue) { it.section2.crushAllies }
            property("CrushDecelerationPercent", FloatValue) { it.section2.crushDecelerationPercent }
            property("MinCrushVelocityPercent", FloatValue) { it.section2.minCrushVelocityPercent }
            property("CrushZFactor", FloatValue) { it.section2.crushZFactor }
            property("CrushKnockback", FloatValue) { it.section2.crushKnockback }
            property("MountedCrusherLevel", IntValue) { it.section2.mountedCrusherLevel }
            property("MountedCrushableLevel", IntValue) { it.section2.mountedCrushableLevel }
            property("RamPower", FloatValue) { it.section2.ramPower }
            property("RamZMult", FloatValue) { it.section2.ramZMult }
            property("FormationWidth", IntValue) { it.section2.formationWidth }
            property("FormationDepth", IntValue) { it.section2.formationDepth }
            property("AnimMode", Untyped.type) { it.section2.animMode }
            property("PathfindDiameter", FloatValue) { it.section2.pathfindDiameter }
            property("CamouflageDetectionMultiplier", FloatValue) { it.section2.camouflageDetectionMultiplier }
            property("CommandPointBonus", IntValue) { it.section2.commandPointBonus }
            property("SelectionPriority", IntValue) { it.section2.selectionPriority }
            property("HealthBoxHeightOffset", FloatValue) { it.section2.healthBoxHeightOffset }
            property("HealthBoxScale", FloatValue) { it.section2.healthBoxScale }
            property("UpgradeCameo1", ReferenceValue<Upgrade> { listOf(Upgrade) }) { it.section2.upgradeCameo1 }
            property("ForceLuaRegistration", BooleanValue) { it.section2.forceLuaRegistration }
            property("MaxSimultaneousOfType", IntValue) { it.section2.maxSimultaneousOfType }
            property("IsGrabbable", BooleanValue) { it.section2.isGrabbable }
            property("IsHarvestable", BooleanValue) { it.section2.isHarvestable }
            property("MinZIncreaseForVoiceMoveToHigherGround", FloatValue) { it.section2.minZIncreaseForVoiceMoveToHigherGround }
            property("DeadCollideSize", Untyped.type) { it.section2.deadCollideSize }
            property("LiveCameraOffset", Coords.type) { it.section2.liveCameraOffset }
            property("LiveCameraPitch", FloatValue) { it.section2.liveCameraPitch }
            property("IsAutoBuilt", BooleanValue) { it.section2.isAutoBuilt }
            property("CanPathThroughGates", BooleanValue) { it.section2.canPathThroughGates }
            property("BuildVariations", ListValue(ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) })) { it.section2.buildVariations }
            property("EquivalentTo", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.section2.equivalentTo }
            property("BuildFadeInOnCreateTime", IntValue) { it.section2.buildFadeInOnCreateTime }
            property("BuildFadeInOnCreateList", StringValue) { it.section2.buildFadeInOnCreateList }
            property("Buildable", BooleanValue) { it.section2.buildable }
            property("EnergyProduction", IntValue) { it.section2.energyProduction }
            property("CampnessValueRadius", FloatValue) { it.section2.campnessValueRadius }
            property("RemoveTerrainRadius", FloatValue) { it.section2.removeTerrainRadius }
            property("ShouldClearShotsOnIdle", BooleanValue) { it.section2.shouldClearShotsOnIdle }
            property("DisplayRangedDamage", FloatValue) { it.section2.displayRangedDamage }
            property("EnergyBonus", IntValue) { it.section2.energyBonus }
            property("EnterGuard", BooleanValue) { it.section2.enterGuard }
            property(
                "EvaEnemyUnitSightedEvent",
                ReferenceValue<EvaEventBase> { listOf(NewEvaEvent, PredefinedEvaEvent) }) { it.section2.evaEnemyUnitSightedEvent }
            property("ExperienceRequired", Untyped.type) { it.section2.experienceRequired }
            property("ExperienceValue", Untyped.type) { it.section2.experienceValue }
            property("FactoryExitWidth", IntValue) { it.section2.factoryExitWidth }
            property("FactoryExtraBibWidth", FloatValue) { it.section2.factoryExtraBibWidth }
            property("FenceWidth", FloatValue) { it.section2.fenceWidth }
            property("FenceXOffset", FloatValue) { it.section2.fenceXOffset }
            property("GroupVoiceThreshold", IntValue) { it.section2.groupVoiceThreshold }
            property("HijackGuard", BooleanValue) { it.section2.hijackGuard }
            property("ImmuneToShockwave", BooleanValue) { it.section2.immuneToShockwave }
            property("Locomotor", ListValue(Untyped.type)) { it.section2.locomotor }
            property("MaxSimultaneousLinkKey", StringValue) { it.section2.maxSimultaneousLinkKey }
            property("OverrideableByLikeKind", Untyped.type) { it.section2.overrideableByLikeKind }
            property("Prerequisites", Untyped.type) { it.section2.prerequisites }
            property("ShroudRevealToAllRange", FloatValue) { it.section2.shroudRevealToAllRange }
            property("SoundAmbient2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.soundAmbient2 }
            property("SoundAmbientDamaged2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.soundAmbientDamaged2 }
            property("SoundAmbientReallyDamaged2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.soundAmbientReallyDamaged2 }
            property("SoundAmbientRubble2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.soundAmbientRubble2 }
            property("SoundCrush", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.soundCrush }
            property("SoundDie", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.soundDie }
            property("SoundDieFire", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.soundDieFire }
            property("SoundDieToxin", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.soundDieToxin }
            property("StructureRubbleHeight", IntValue) { it.section2.structureRubbleHeight }
            property("SupplyOverride", IntValue) { it.section2.supplyOverride }
            property("UnitSpecificFX", Untyped.type) { it.section2.unitSpecificFX }
            property("UpgradeCameo2", ReferenceValue<Upgrade> { listOf(Upgrade) }) { it.section2.upgradeCameo2 }
            property("UpgradeCameo3", ReferenceValue<Upgrade> { listOf(Upgrade) }) { it.section2.upgradeCameo3 }
            property("UpgradeCameo4", ReferenceValue<Upgrade> { listOf(Upgrade) }) { it.section2.upgradeCameo4 }
            property("UpgradeCameo5", ReferenceValue<Upgrade> { listOf(Upgrade) }) { it.section2.upgradeCameo5 }
            property("VoiceAlert2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.voiceAlert2 }
            property("VoiceAmbushBlockingRadius", IntValue) { it.section2.voiceAmbushBlockingRadius }
            property("VoiceAmbushTimeout", IntValue) { it.section2.voiceAmbushTimeout }
            property("VoiceAmbushed", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.voiceAmbushed }
            property("VoiceAmbushed2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.voiceAmbushed2 }
            property("VoiceAttack2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.voiceAttack2 }
            property("VoiceAttackAir2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.voiceAttackAir2 }
            property("VoiceAttackAirGroup", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.voiceAttackAirGroup }
            property("VoiceAttackAirGroup2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.voiceAttackAirGroup2 }
            property("VoiceAttackCharge2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.voiceAttackCharge2 }
            property("VoiceAttackChargeGroup", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.voiceAttackChargeGroup }
            property("VoiceAttackChargeGroup2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.voiceAttackChargeGroup2 }
            property("VoiceAttackGroup", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.voiceAttackGroup }
            property("VoiceAttackGroup2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.voiceAttackGroup2 }
            property("VoiceAttackMachine2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.voiceAttackMachine2 }
            property("VoiceAttackMachineGroup", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.voiceAttackMachineGroup }
            property("VoiceAttackMachineGroup2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.voiceAttackMachineGroup2 }
            property("VoiceAttackStructure2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.voiceAttackStructure2 }
            property("VoiceAttackStructureGroup", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.voiceAttackStructureGroup }
            property("VoiceAttackStructureGroup2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.voiceAttackStructureGroup2 }
            property("VoiceCombineWithHorde2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.voiceCombineWithHorde2 }
            property("VoiceCreated2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.voiceCreated2 }
            property("VoiceDefect2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.voiceDefect2 }
            property("VoiceEnter", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.voiceEnter }
            property("VoiceEnterStateAttack2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.voiceEnterStateAttack2 }
            property("VoiceEnterStateAttackAir2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.voiceEnterStateAttackAir2 }
            property("VoiceEnterStateAttackCharge2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.voiceEnterStateAttackCharge2 }
            property("VoiceEnterStateAttackMachine2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.voiceEnterStateAttackMachine2 }
            property("VoiceEnterStateAttackStructure2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.voiceEnterStateAttackStructure2 }
            property("VoiceEnterStateMove2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.voiceEnterStateMove2 }
            property("VoiceEnterStateMoveToCamp2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.voiceEnterStateMoveToCamp2 }
            property("VoiceEnterStateMoveWhileAttacking2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.voiceEnterStateMoveWhileAttacking2 }
            property("VoiceEnterStateRetreatToCastle2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section2.voiceEnterStateRetreatToCastle2 }
            property("VoiceFear2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section3.voiceFear2 }
            property("VoiceFullyCreated2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section3.voiceFullyCreated2 }
            property("VoiceGarrison", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section3.voiceGarrison }
            property("VoiceGroupSelect", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section3.voiceGroupSelect }
            property("VoiceGuard2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section3.voiceGuard2 }
            property("VoiceGuardGroup", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section3.voiceGuardGroup }
            property("VoiceGuardGroup2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section3.voiceGuardGroup2 }
            property("VoiceMeetEnemy", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section3.voiceMeetEnemy }
            property("VoiceMove2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section3.voiceMove2 }
            property("VoiceMoveGroup", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section3.voiceMoveGroup }
            property("VoiceMoveGroup2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section3.voiceMoveGroup2 }
            property("VoiceMoveToCamp2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section3.voiceMoveToCamp2 }
            property("VoiceMoveToCampGroup", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section3.voiceMoveToCampGroup }
            property("VoiceMoveToCampGroup2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section3.voiceMoveToCampGroup2 }
            property("VoiceMoveWhileAttacking2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section3.voiceMoveWhileAttacking2 }
            property("VoiceMoveWhileAttackingGroup", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section3.voiceMoveWhileAttackingGroup }
            property("VoiceMoveWhileAttackingGroup2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section3.voiceMoveWhileAttackingGroup2 }
            property("VoiceRetreatToCastle2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section3.voiceRetreatToCastle2 }
            property("VoiceRetreatToCastleGroup", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section3.voiceRetreatToCastleGroup }
            property("VoiceRetreatToCastleGroup2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section3.voiceRetreatToCastleGroup2 }
            property("VoiceSelect2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section3.voiceSelect2 }
            property("VoiceSelectBattle2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section3.voiceSelectBattle2 }
            property("VoiceSelectBattleGroup", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section3.voiceSelectBattleGroup }
            property("VoiceSelectBattleGroup2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section3.voiceSelectBattleGroup2 }
            property("VoiceSelectElite", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section3.voiceSelectElite }
            property("VoiceSelectGroup", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section3.voiceSelectGroup }
            property("VoiceSelectGroup2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section3.voiceSelectGroup2 }
            property("VoiceTaskComplete2", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section3.voiceTaskComplete2 }
            property("VoiceTaskUnable", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.section3.voiceTaskUnable }
            property("WeaponSet", ListValue(BlockValue<WeaponSet> { listOf(WeaponSet) })) { it.section3.weaponSet }
            property("ArmorSet", ListValue(BlockValue<ArmorSet> { listOf(ArmorSet) })) { it.section3.armorSet }
            property("AutoResolve", ListValue(BlockValue<AutoResolveEntry> { listOf(AutoResolveArmor, AutoResolveWeapon) })) { it.section3.autoResolve }
            property("UnitSpecificSounds", ListValue(BlockValue<UnitSpecificSounds> { listOf(UnitSpecificSounds) })) { it.section3.unitSpecificSounds }
            property("LocomotorSet", ListValue(BlockValue<LocomotorSet> { listOf(LocomotorSet) })) { it.section3.locomotorSet }
            property("Draw", ListValue(BlockValue<SageDraw> { SageIniModel.draws })) { it.section3.draw }
            property("AddModule", ListValue(BlockValue<AddModule> { listOf(AddModule) })) { it.section3.addModule }
            property("ReplaceModule", ListValue(BlockValue<ReplaceModule> { listOf(ReplaceModule) })) { it.section3.replaceModule }
            property("InheritableModule", ListValue(BlockValue<InheritableModule> { listOf(InheritableModule) })) { it.section3.inheritableModule }
            property("RemoveModule", ListValue(Untyped.type)) { it.section3.removeModule }
            property("ThreatBreakdown", ListValue(BlockValue<ThreatBreakdown> { listOf(ThreatBreakdown) })) { it.section3.threatBreakdown }
            property("Flammability", ListValue(BlockValue<Flammability> { listOf(Flammability) })) { it.section3.flammability }
            property(
                "FormationPreviewDecal",
                ListValue(BlockValue<FormationPreviewDecal> { listOf(FormationPreviewDecal, FormationPreviewItemDecal) })
            ) { it.section3.formationPreviewDecal }
            property(
                "FormationPreviewItemDecal",
                ListValue(BlockValue<FormationPreviewItemDecal> { listOf(FormationPreviewItemDecal) })
            ) { it.section3.formationPreviewItemDecal }
            property("Behavior", ListValue(BlockValue<SageBehavior> { SageIniModel.behaviors })) { it.section3.behavior }
            property("Body", ListValue(BlockValue<SageBehavior> { SageIniModel.behaviors })) { it.section3.body }
            property("ClientUpdate", ListValue(BlockValue<SageBehavior> { SageIniModel.behaviors })) { it.section3.clientUpdate }
            property("ClientBehavior", ListValue(BlockValue<SageBehavior> { SageIniModel.behaviors })) { it.section3.clientBehavior }
        },
    )
}
