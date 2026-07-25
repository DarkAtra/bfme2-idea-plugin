package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.Weapon
import de.darkatra.bfme2.ini.model.value.EmotionTypes
import de.darkatra.bfme2.ini.model.value.KindOf
import de.darkatra.bfme2.ini.model.value.SageReference

data class BezierProjectileBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("TumbleRandomly") val tumbleRandomly: Boolean = false,
    @SageIniName("DetonateCallsKill") val detonateCallsKill: Boolean = false,
    @SageIniName("PreLandingEmotionAffectsAllies") val preLandingEmotionAffectsAllies: Boolean = false,
    @SageIniName("OrientToFlightPath") val orientToFlightPath: Boolean = false,
    @SageIniName("FirstHeight") val firstHeight: Double = 0.0,
    @SageIniName("SecondHeight") val secondHeight: Double = 0.0,
    @SageIniName("FirstPercentIndent") val firstPercentIndent: Double = 0.0,
    @SageIniName("SecondPercentIndent") val secondPercentIndent: Double = 0.0,
    @SageIniName("CrushStyle") val crushStyle: Boolean = false,
    @SageIniName("DieOnImpact") val dieOnImpact: Boolean = false,
    @SageIniName("FinalStuckTime") val finalStuckTime: Int = 0,
    @SageIniName("PreLandingStateTime") val preLandingStateTime: Int = 0,
    @SageIniName("BounceCount") val bounceCount: Int = 0,
    @SageIniName("BounceDistance") val bounceDistance: Double = 0.0,
    @SageIniName("BounceFirstHeight") val bounceFirstHeight: Double = 0.0,
    @SageIniName("BounceSecondHeight") val bounceSecondHeight: Double = 0.0,
    @SageIniName("BounceFirstPercentIndent") val bounceFirstPercentIndent: Double = 0.0,
    @SageIniName("BounceSecondPercentIndent") val bounceSecondPercentIndent: Double = 0.0,
    @SageIniName("GarrisonHitKillRequiredKindOf") val garrisonHitKillRequiredKindOf: List<KindOf> = emptyList(),
    @SageIniName("GarrisonHitKillForbiddenKindOf") val garrisonHitKillForbiddenKindOf: List<KindOf> = emptyList(),
    @SageIniName("GarrisonHitKillCount") val garrisonHitKillCount: Int = 0,
    @SageIniName("GroundHitWeapon") val groundHitWeapon: SageReference<Weapon>? = null,
    @SageIniName("GroundBounceWeapon") val groundBounceWeapon: SageReference<Weapon>? = null,
    @SageIniName("FlightPathAdjustDistPerSecond") val flightPathAdjustDistPerSecond: Double = 0.0,
    @SageIniName("IgnoreTerrainHeight") val ignoreTerrainHeight: Boolean = false,
    @SageIniName("FirstPercentHeight") val firstPercentHeight: Double = 0.0,
    @SageIniName("SecondPercentHeight") val secondPercentHeight: Double = 0.0,
    @SageIniName("CurveFlattenMinDist") val curveFlattenMinDist: Double = 0.0,
    @SageIniName("PreLandingEmotion") val preLandingEmotion: EmotionTypes? = null,
    @SageIniName("PreLandingEmotionRadius") val preLandingEmotionRadius: Double = 0.0,
    @SageIniName("InvisibleFrames") val invisibleFrames: Int = 0,
    @SageIniName("FadeInTime") val fadeInTime: Int = 0,
    @SageIniName("PostLandingStateTime") val postLandingStateTime: Int = 0,
    @SageIniName("PostLandingEmotion") val postLandingEmotion: EmotionTypes? = null,
    @SageIniName("PostLandingEmotionRadius") val postLandingEmotionRadius: Double = 0.0,
    @SageIniName("GarrisonHitKillFX") val garrisonHitKillFX: SageReference<FXList>? = null,
    @SageIniName("GroundHitFX") val groundHitFX: SageReference<FXList>? = null,
    @SageIniName("GroundBounceFX") val groundBounceFX: SageReference<FXList>? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<BezierProjectileBehavior>(
        name = "BezierProjectileBehavior",
        properties = {
            property("TumbleRandomly", BooleanValue) { it.tumbleRandomly }
            property("DetonateCallsKill", BooleanValue) { it.detonateCallsKill }
            property("PreLandingEmotionAffectsAllies", BooleanValue) { it.preLandingEmotionAffectsAllies }
            property("OrientToFlightPath", BooleanValue) { it.orientToFlightPath }
            property("FirstHeight", FloatValue) { it.firstHeight }
            property("SecondHeight", FloatValue) { it.secondHeight }
            property("FirstPercentIndent", FloatValue) { it.firstPercentIndent }
            property("SecondPercentIndent", FloatValue) { it.secondPercentIndent }
            property("CrushStyle", BooleanValue) { it.crushStyle }
            property("DieOnImpact", BooleanValue) { it.dieOnImpact }
            property("FinalStuckTime", IntValue) { it.finalStuckTime }
            property("PreLandingStateTime", IntValue) { it.preLandingStateTime }
            property("BounceCount", IntValue) { it.bounceCount }
            property("BounceDistance", FloatValue) { it.bounceDistance }
            property("BounceFirstHeight", FloatValue) { it.bounceFirstHeight }
            property("BounceSecondHeight", FloatValue) { it.bounceSecondHeight }
            property("BounceFirstPercentIndent", FloatValue) { it.bounceFirstPercentIndent }
            property("BounceSecondPercentIndent", FloatValue) { it.bounceSecondPercentIndent }
            property("GarrisonHitKillRequiredKindOf", ListValue(KindOf.type)) { it.garrisonHitKillRequiredKindOf }
            property("GarrisonHitKillForbiddenKindOf", ListValue(KindOf.type)) { it.garrisonHitKillForbiddenKindOf }
            property("GarrisonHitKillCount", IntValue) { it.garrisonHitKillCount }
            property("GroundHitWeapon", ReferenceValue<Weapon> { listOf(Weapon) }) { it.groundHitWeapon }
            property("GroundBounceWeapon", ReferenceValue<Weapon> { listOf(Weapon) }) { it.groundBounceWeapon }
            property("FlightPathAdjustDistPerSecond", FloatValue) { it.flightPathAdjustDistPerSecond }
            property("IgnoreTerrainHeight", BooleanValue) { it.ignoreTerrainHeight }
            property("FirstPercentHeight", FloatValue) { it.firstPercentHeight }
            property("SecondPercentHeight", FloatValue) { it.secondPercentHeight }
            property("CurveFlattenMinDist", FloatValue) { it.curveFlattenMinDist }
            property("PreLandingEmotion", EmotionTypes.type) { it.preLandingEmotion }
            property("PreLandingEmotionRadius", FloatValue) { it.preLandingEmotionRadius }
            property("InvisibleFrames", IntValue) { it.invisibleFrames }
            property("FadeInTime", IntValue) { it.fadeInTime }
            property("PostLandingStateTime", IntValue) { it.postLandingStateTime }
            property("PostLandingEmotion", EmotionTypes.type) { it.postLandingEmotion }
            property("PostLandingEmotionRadius", FloatValue) { it.postLandingEmotionRadius }
            property("GarrisonHitKillFX", ReferenceValue<FXList> { listOf(FXList) }) { it.garrisonHitKillFX }
            property("GroundHitFX", ReferenceValue<FXList> { listOf(FXList) }) { it.groundHitFX }
            property("GroundBounceFX", ReferenceValue<FXList> { listOf(FXList) }) { it.groundBounceFX }
        },
    )
}
