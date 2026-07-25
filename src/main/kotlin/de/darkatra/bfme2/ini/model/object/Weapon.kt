package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.SageIniModel
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.common.SageNugget
import de.darkatra.bfme2.ini.model.value.DamageType
import de.darkatra.bfme2.ini.model.value.DeathType
import de.darkatra.bfme2.ini.model.value.FakeToken
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.RangeDuration
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.TimedPosition
import de.darkatra.bfme2.ini.model.value.Untyped
import de.darkatra.bfme2.ini.model.value.WeaponCollideTypes
import de.darkatra.bfme2.ini.model.value.WeaponPrefireType
import de.darkatra.bfme2.ini.model.value.WeaponReloadType

data class Weapon(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("AttackRange") val attackRange: Double = 0.0,
    @SageIniName("ScatterTargetScalar") val scatterTargetScalar: Double = 0.0,
    @SageIniName("ScatterTarget") val scatterTarget: List<Untyped> = emptyList(),
    @SageIniName("WeaponBonus") val weaponBonus: List<List<String>> = emptyList(),
    @SageIniName("RangeBonusMinHeight") val rangeBonusMinHeight: Double = 0.0,
    @SageIniName("RangeBonus") val rangeBonus: Double = 0.0,
    @SageIniName("RangeBonusPerFoot") val rangeBonusPerFoot: Double = 0.0,
    @SageIniName("WeaponSpeed") val weaponSpeed: Double = 0.0,
    @SageIniName("MinWeaponSpeed") val minWeaponSpeed: Double = 0.0,
    @SageIniName("MaxWeaponSpeed") val maxWeaponSpeed: Double = 0.0,
    @SageIniName("FireFX") val fireFX: SageReference<FXList>? = null,
    @SageIniName("ScaleWeaponSpeed") val scaleWeaponSpeed: Boolean = false,
    @SageIniName("HitPercentage") val hitPercentage: Double = 0.0,
    @SageIniName("ScatterRadius") val scatterRadius: Double = 0.0,
    @SageIniName("AcceptableAimDelta") val acceptableAimDelta: Double = 0.0,
    @SageIniName("DelayBetweenShots") val delayBetweenShots: RangeDuration? = null,
    @SageIniName("PreAttackDelay") val preAttackDelay: Double = 0.0,
    @SageIniName("PreAttackType") val preAttackType: WeaponPrefireType? = null,
    @SageIniName("FiringDuration") val firingDuration: Double = 0.0,
    @SageIniName("ClipSize") val clipSize: Double = 0.0,
    @SageIniName("AutoReloadsClip") val autoReloadsClip: WeaponReloadType? = null,
    @SageIniName("AutoReloadWhenIdle") val autoReloadWhenIdle: Double = 0.0,
    @SageIniName("ClipReloadTime") val clipReloadTime: RangeDuration? = null,
    @SageIniName("ContinuousFireOne") val continuousFireOne: Double = 0.0,
    @SageIniName("ContinuousFireCoast") val continuousFireCoast: Double = 0.0,
    @SageIniName("AntiAirborneVehicle") val antiAirborneVehicle: Boolean = false,
    @SageIniName("AntiAirborneMonster") val antiAirborneMonster: Boolean = false,
    @SageIniName("CanFireWhileMoving") val canFireWhileMoving: Boolean = false,
    @SageIniName("ProjectileCollidesWith") val projectileCollidesWith: List<WeaponCollideTypes> = emptyList(),
    @SageIniName("RadiusDamageAffects") val radiusDamageAffects: SageFilter? = null,
    @SageIniName("HitStoredTarget") val hitStoredTarget: Boolean = false,
    @SageIniName("PreferredTargetBone") val preferredTargetBone: Opaque? = null,
    @SageIniName("LeechRangeWeapon") val leechRangeWeapon: Boolean = false,
    @SageIniName("MeleeWeapon") val meleeWeapon: Boolean = false,
    @SageIniName("DamageDealtAtSelfPosition") val damageDealtAtSelfPosition: Boolean = false,
    @SageIniName("PreAttackFX") val preAttackFX: SageReference<FXList>? = null,
    @SageIniName("ShouldPlayUnderAttackEvaEvent") val shouldPlayUnderAttackEvaEvent: Boolean = false,
    @SageIniName("FireFlankFX") val fireFlankFX: SageReference<FXList>? = null,
    @SageIniName("InstantLoadClipOnActivate") val instantLoadClipOnActivate: Boolean = false,
    @SageIniName("IdleAfterFiringDelay") val idleAfterFiringDelay: Double = 0.0,
    @SageIniName("MinimumAttackRange") val minimumAttackRange: Double = 0.0,
    @SageIniName("ProjectileSelf") val projectileSelf: Boolean = false,
    @SageIniName("PreAttackRandomAmount") val preAttackRandomAmount: Double = 0.0,
    @SageIniName("HitPassengerPercentage") val hitPassengerPercentage: Double = 0.0,
    @SageIniName("CanBeDodged") val canBeDodged: Boolean = false,
    @SageIniName("NoVictimNeeded") val noVictimNeeded: Boolean = false,
    @SageIniName("BombardType") val bombardType: Boolean = false,
    @SageIniName("OverrideVoiceAttackSound") val overrideVoiceAttackSound: SageReference<AudioEvent>? = null,
    @SageIniName("OverrideVoiceEnterStateAttackSound") val overrideVoiceEnterStateAttackSound: SageReference<AudioEvent>? = null,
    @SageIniName("RequireFollowThru") val requireFollowThru: Boolean = false,
    @SageIniName("FinishAttackOnceStarted") val finishAttackOnceStarted: Boolean = false,
    @SageIniName("HoldDuringReload") val holdDuringReload: Boolean = false,
    @SageIniName("IsAimingWeapon") val isAimingWeapon: Boolean = false,
    @SageIniName("HoldAfterFiringDelay") val holdAfterFiringDelay: Double = 0.0,
    @SageIniName("ProjectileFilterInContainer") val projectileFilterInContainer: SageFilter? = null,
    @SageIniName("AntiStructure") val antiStructure: Boolean = false,
    @SageIniName("AntiGround") val antiGround: Boolean = false,
    @SageIniName("ScatterRadiusVsInfantry") val scatterRadiusVsInfantry: Double = 0.0,
    @SageIniName("ScatterIndependently") val scatterIndependently: Boolean = false,
    @SageIniName("PlayFXWhenStealthed") val playFXWhenStealthed: Boolean = false,
    @SageIniName("AimDirection") val aimDirection: Double = 0.0,
    @SageIniName("FXTrigger") val fXTrigger: Untyped? = null,
    @SageIniName("ShareTimers") val shareTimers: Boolean = false,
    @SageIniName("DisableScatterForTargetsOnWall") val disableScatterForTargetsOnWall: Boolean = false,
    @SageIniName("DamageType") val damageType: DamageType? = null,
    @SageIniName("CanSwoop") val canSwoop: Boolean = false,
    @SageIniName("PassengerProportionalAttack") val passengerProportionalAttack: Boolean = false,
    @SageIniName("MaxAttackPassengers") val maxAttackPassengers: Double = 0.0,
    @SageIniName("ChaseWeapon") val chaseWeapon: Boolean = false,
    @SageIniName("CanFireWhileCharging") val canFireWhileCharging: Boolean = false,
    @SageIniName("IgnoreLinearFirstTarget") val ignoreLinearFirstTarget: Boolean = false,
    @SageIniName("LinearTarget") val linearTarget: List<TimedPosition> = emptyList(),
    @SageIniName("ForceDisplayPercentReady") val forceDisplayPercentReady: Boolean = false,
    @SageIniName("AntiAirborneInfantry") val antiAirborneInfantry: Boolean = false,
    @SageIniName("LockWhenUsing") val lockWhenUsing: Boolean = false,
    @SageIniName("ProjectileStreamName") val projectileStreamName: SageReference<Object>? = null,
    @SageIniName("UseInnateAttributes") val useInnateAttributes: Boolean = false,
    @SageIniName("PrimaryDamage") val primaryDamage: Double = 0.0,
    @SageIniName("PrimaryDamageRadius") val primaryDamageRadius: Double = 0.0,
    @SageIniName("SecondaryDamage") val secondaryDamage: Double = 0.0,
    @SageIniName("SecondaryDamageRadius") val secondaryDamageRadius: Double = 0.0,
    @SageIniName("ShockWaveAmount") val shockWaveAmount: Double = 0.0,
    @SageIniName("ShockWaveRadius") val shockWaveRadius: Double = 0.0,
    @SageIniName("ShockWaveTaperOff") val shockWaveTaperOff: Double = 0.0,
    @SageIniName("DeathType") val deathType: DeathType? = null,
    @SageIniName("DamageStatusType") val damageStatusType: FakeToken? = null,
    @SageIniName("ProjectileObject") val projectileObject: SageReference<Object>? = null,
    @SageIniName("ProjectileDetonationFX") val projectileDetonationFX: SageReference<FXList>? = null,
    @SageIniName("ProjectileDetonationOCL") val projectileDetonationOCL: SageReference<ObjectCreationList>? = null,
    @SageIniName("ProjectileExhaust") val projectileExhaust: Opaque? = null,
    @SageIniName("VeterancyProjectileExhaust") val veterancyProjectileExhaust: Opaque? = null,
    @SageIniName("VeterancyFireFX") val veterancyFireFX: SageReference<FXList>? = null,
    @SageIniName("FireOCL") val fireOCL: SageReference<ObjectCreationList>? = null,
    @SageIniName("FireSound") val fireSound: SageReference<AudioEvent>? = null,
    @SageIniName("FireSoundLoopTime") val fireSoundLoopTime: Int = 0,
    @SageIniName("LaserName") val laserName: Opaque? = null,
    @SageIniName("LaserBoneName") val laserBoneName: Opaque? = null,
    @SageIniName("HistoricBonusWeapon") val historicBonusWeapon: SageReference<Weapon>? = null,
    @SageIniName("HistoricBonusCount") val historicBonusCount: Int = 0,
    @SageIniName("HistoricBonusRadius") val historicBonusRadius: Int = 0,
    @SageIniName("HistoricBonusTime") val historicBonusTime: Int = 0,
    @SageIniName("ContinueAttackRange") val continueAttackRange: Int = 0,
    @SageIniName("ContinuousFireTwo") val continuousFireTwo: Int = 0,
    @SageIniName("RequestAssistRange") val requestAssistRange: Int = 0,
    @SageIniName("MaxTargetPitch") val maxTargetPitch: Int = 0,
    @SageIniName("MinTargetPitch") val minTargetPitch: Int = 0,
    @SageIniName("ShotsPerBarrel") val shotsPerBarrel: Int = 0,
    @SageIniName("WeaponRecoil") val weaponRecoil: Int = 0,
    @SageIniName("SuspendFXDelay") val suspendFXDelay: Int = 0,
    @SageIniName("AllowAttackGarrisonedBldgs") val allowAttackGarrisonedBldgs: Boolean = false,
    @SageIniName("CapableOfFollowingWaypoints") val capableOfFollowingWaypoints: Boolean = false,
    @SageIniName("MissileCallsOnDie") val missileCallsOnDie: Boolean = false,
    @SageIniName("RotatingTurret") val rotatingTurret: Boolean = false,
    @SageIniName("ShowsAmmoPips") val showsAmmoPips: Boolean = false,
    @SageIniName("AntiBallisticMissile") val antiBallisticMissile: Boolean = false,
    @SageIniName("AntiMine") val antiMine: Boolean = false,
    @SageIniName("AntiProjectile") val antiProjectile: Boolean = false,
    @SageIniName("AntiSmallMissile") val antiSmallMissile: Boolean = false,
    @SageIniName("AntiMask") val antiMask: Untyped? = null,
    @SageIniName("Nuggets") val nuggets: List<SageNugget> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<Weapon>(
        name = "Weapon",
        tableKey = "weapons",
        properties = {
            property("AttackRange", FloatValue) { it.attackRange }
            property("ScatterTargetScalar", FloatValue) { it.scatterTargetScalar }
            property("ScatterTarget", ListValue(Untyped.type)) { it.scatterTarget }
            property("WeaponBonus", ListValue(ListValue(StringValue))) { it.weaponBonus }
            property("RangeBonusMinHeight", FloatValue) { it.rangeBonusMinHeight }
            property("RangeBonus", FloatValue) { it.rangeBonus }
            property("RangeBonusPerFoot", FloatValue) { it.rangeBonusPerFoot }
            property("WeaponSpeed", FloatValue) { it.weaponSpeed }
            property("MinWeaponSpeed", FloatValue) { it.minWeaponSpeed }
            property("MaxWeaponSpeed", FloatValue) { it.maxWeaponSpeed }
            property("FireFX", ReferenceValue<FXList> { listOf(FXList) }) { it.fireFX }
            property("ScaleWeaponSpeed", BooleanValue) { it.scaleWeaponSpeed }
            property("HitPercentage", FloatValue) { it.hitPercentage }
            property("ScatterRadius", FloatValue) { it.scatterRadius }
            property("AcceptableAimDelta", FloatValue) { it.acceptableAimDelta }
            property("DelayBetweenShots", RangeDuration.type) { it.delayBetweenShots }
            property("PreAttackDelay", FloatValue) { it.preAttackDelay }
            property("PreAttackType", WeaponPrefireType.type) { it.preAttackType }
            property("FiringDuration", FloatValue) { it.firingDuration }
            property("ClipSize", FloatValue) { it.clipSize }
            property("AutoReloadsClip", WeaponReloadType.type) { it.autoReloadsClip }
            property("AutoReloadWhenIdle", FloatValue) { it.autoReloadWhenIdle }
            property("ClipReloadTime", RangeDuration.type) { it.clipReloadTime }
            property("ContinuousFireOne", FloatValue) { it.continuousFireOne }
            property("ContinuousFireCoast", FloatValue) { it.continuousFireCoast }
            property("AntiAirborneVehicle", BooleanValue) { it.antiAirborneVehicle }
            property("AntiAirborneMonster", BooleanValue) { it.antiAirborneMonster }
            property("CanFireWhileMoving", BooleanValue) { it.canFireWhileMoving }
            property("ProjectileCollidesWith", ListValue(WeaponCollideTypes.type)) { it.projectileCollidesWith }
            property("RadiusDamageAffects", SageFilter.type) { it.radiusDamageAffects }
            property("HitStoredTarget", BooleanValue) { it.hitStoredTarget }
            property("PreferredTargetBone", Opaque.type) { it.preferredTargetBone }
            property("LeechRangeWeapon", BooleanValue) { it.leechRangeWeapon }
            property("MeleeWeapon", BooleanValue) { it.meleeWeapon }
            property("DamageDealtAtSelfPosition", BooleanValue) { it.damageDealtAtSelfPosition }
            property("PreAttackFX", ReferenceValue<FXList> { listOf(FXList) }) { it.preAttackFX }
            property("ShouldPlayUnderAttackEvaEvent", BooleanValue) { it.shouldPlayUnderAttackEvaEvent }
            property("FireFlankFX", ReferenceValue<FXList> { listOf(FXList) }) { it.fireFlankFX }
            property("InstantLoadClipOnActivate", BooleanValue) { it.instantLoadClipOnActivate }
            property("IdleAfterFiringDelay", FloatValue) { it.idleAfterFiringDelay }
            property("MinimumAttackRange", FloatValue) { it.minimumAttackRange }
            property("ProjectileSelf", BooleanValue) { it.projectileSelf }
            property("PreAttackRandomAmount", FloatValue) { it.preAttackRandomAmount }
            property("HitPassengerPercentage", FloatValue) { it.hitPassengerPercentage }
            property("CanBeDodged", BooleanValue) { it.canBeDodged }
            property("NoVictimNeeded", BooleanValue) { it.noVictimNeeded }
            property("BombardType", BooleanValue) { it.bombardType }
            property("OverrideVoiceAttackSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.overrideVoiceAttackSound }
            property("OverrideVoiceEnterStateAttackSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.overrideVoiceEnterStateAttackSound }
            property("RequireFollowThru", BooleanValue) { it.requireFollowThru }
            property("FinishAttackOnceStarted", BooleanValue) { it.finishAttackOnceStarted }
            property("HoldDuringReload", BooleanValue) { it.holdDuringReload }
            property("IsAimingWeapon", BooleanValue) { it.isAimingWeapon }
            property("HoldAfterFiringDelay", FloatValue) { it.holdAfterFiringDelay }
            property("ProjectileFilterInContainer", SageFilter.type) { it.projectileFilterInContainer }
            property("AntiStructure", BooleanValue) { it.antiStructure }
            property("AntiGround", BooleanValue) { it.antiGround }
            property("ScatterRadiusVsInfantry", FloatValue) { it.scatterRadiusVsInfantry }
            property("ScatterIndependently", BooleanValue) { it.scatterIndependently }
            property("PlayFXWhenStealthed", BooleanValue) { it.playFXWhenStealthed }
            property("AimDirection", FloatValue) { it.aimDirection }
            property("FXTrigger", Untyped.type) { it.fXTrigger }
            property("ShareTimers", BooleanValue) { it.shareTimers }
            property("DisableScatterForTargetsOnWall", BooleanValue) { it.disableScatterForTargetsOnWall }
            property("DamageType", DamageType.type) { it.damageType }
            property("CanSwoop", BooleanValue) { it.canSwoop }
            property("PassengerProportionalAttack", BooleanValue) { it.passengerProportionalAttack }
            property("MaxAttackPassengers", FloatValue) { it.maxAttackPassengers }
            property("ChaseWeapon", BooleanValue) { it.chaseWeapon }
            property("CanFireWhileCharging", BooleanValue) { it.canFireWhileCharging }
            property("IgnoreLinearFirstTarget", BooleanValue) { it.ignoreLinearFirstTarget }
            property("LinearTarget", ListValue(TimedPosition.type)) { it.linearTarget }
            property("ForceDisplayPercentReady", BooleanValue) { it.forceDisplayPercentReady }
            property("AntiAirborneInfantry", BooleanValue) { it.antiAirborneInfantry }
            property("LockWhenUsing", BooleanValue) { it.lockWhenUsing }
            property("ProjectileStreamName", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.projectileStreamName }
            property("UseInnateAttributes", BooleanValue) { it.useInnateAttributes }
            property("PrimaryDamage", FloatValue) { it.primaryDamage }
            property("PrimaryDamageRadius", FloatValue) { it.primaryDamageRadius }
            property("SecondaryDamage", FloatValue) { it.secondaryDamage }
            property("SecondaryDamageRadius", FloatValue) { it.secondaryDamageRadius }
            property("ShockWaveAmount", FloatValue) { it.shockWaveAmount }
            property("ShockWaveRadius", FloatValue) { it.shockWaveRadius }
            property("ShockWaveTaperOff", FloatValue) { it.shockWaveTaperOff }
            property("DeathType", DeathType.type) { it.deathType }
            property("DamageStatusType", FakeToken.type) { it.damageStatusType }
            property("ProjectileObject", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.projectileObject }
            property("ProjectileDetonationFX", ReferenceValue<FXList> { listOf(FXList) }) { it.projectileDetonationFX }
            property("ProjectileDetonationOCL", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.projectileDetonationOCL }
            property("ProjectileExhaust", Opaque.type) { it.projectileExhaust }
            property("VeterancyProjectileExhaust", Opaque.type) { it.veterancyProjectileExhaust }
            property("VeterancyFireFX", ReferenceValue<FXList> { listOf(FXList) }) { it.veterancyFireFX }
            property("FireOCL", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.fireOCL }
            property("FireSound", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.fireSound }
            property("FireSoundLoopTime", IntValue) { it.fireSoundLoopTime }
            property("LaserName", Opaque.type) { it.laserName }
            property("LaserBoneName", Opaque.type) { it.laserBoneName }
            property("HistoricBonusWeapon", ReferenceValue<Weapon> { listOf(Weapon) }) { it.historicBonusWeapon }
            property("HistoricBonusCount", IntValue) { it.historicBonusCount }
            property("HistoricBonusRadius", IntValue) { it.historicBonusRadius }
            property("HistoricBonusTime", IntValue) { it.historicBonusTime }
            property("ContinueAttackRange", IntValue) { it.continueAttackRange }
            property("ContinuousFireTwo", IntValue) { it.continuousFireTwo }
            property("RequestAssistRange", IntValue) { it.requestAssistRange }
            property("MaxTargetPitch", IntValue) { it.maxTargetPitch }
            property("MinTargetPitch", IntValue) { it.minTargetPitch }
            property("ShotsPerBarrel", IntValue) { it.shotsPerBarrel }
            property("WeaponRecoil", IntValue) { it.weaponRecoil }
            property("SuspendFXDelay", IntValue) { it.suspendFXDelay }
            property("AllowAttackGarrisonedBldgs", BooleanValue) { it.allowAttackGarrisonedBldgs }
            property("CapableOfFollowingWaypoints", BooleanValue) { it.capableOfFollowingWaypoints }
            property("MissileCallsOnDie", BooleanValue) { it.missileCallsOnDie }
            property("RotatingTurret", BooleanValue) { it.rotatingTurret }
            property("ShowsAmmoPips", BooleanValue) { it.showsAmmoPips }
            property("AntiBallisticMissile", BooleanValue) { it.antiBallisticMissile }
            property("AntiMine", BooleanValue) { it.antiMine }
            property("AntiProjectile", BooleanValue) { it.antiProjectile }
            property("AntiSmallMissile", BooleanValue) { it.antiSmallMissile }
            property("AntiMask", Untyped.type) { it.antiMask }
            property("Nuggets", ListValue(BlockValue<SageNugget> { SageIniModel.nuggets })) { it.nuggets }
        },
    )
}
