package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.ObjectCreationList
import de.darkatra.bfme2.ini.model.`object`.Weapon
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.DeathFlags
import de.darkatra.bfme2.ini.model.value.GeometryType
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.PhasedReferences
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SlowDeathPhase

data class ClearanceTestingSlowDeathBehavior(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DeathType") override val deathType: SageFilter? = null,
    @SageIniName("DeathTypes") override val deathTypes: SageFilter? = null,
    @SageIniName("ExemptStatus") override val exemptStatus: ObjectStatus? = null,
    @SageIniName("RequiredStatus") override val requiredStatus: ObjectStatus? = null,
    @SageIniName("DamageAmountRequired") override val damageAmountRequired: Double = 0.0,
    @SageIniName("MinKillerAngle") override val minKillerAngle: Int = 0,
    @SageIniName("MaxKillerAngle") override val maxKillerAngle: Int = 0,
    @SageIniName("SinkRate") override val sinkRate: Double = 0.0,
    @SageIniName("ProbabilityModifier") override val probabilityModifier: Int = 0,
    @SageIniName("ModifierBonusPerOverkillPercent") override val modifierBonusPerOverkillPercent: Double = 0.0,
    @SageIniName("DeathFlags") override val deathFlags: DeathFlags? = null,
    @SageIniName("FadeTime") override val fadeTime: Int = 0,
    @SageIniName("FadeDelay") override val fadeDelay: Int = 0,
    @SageIniName("ShadowWhenDead") override val shadowWhenDead: Boolean = false,
    @SageIniName("SinkDelay") override val sinkDelay: Int = 0,
    @SageIniName("SinkDelayVariance") override val sinkDelayVariance: Int = 0,
    @SageIniName("DestructionDelay") override val destructionDelay: Int = 0,
    @SageIniName("DestructionDelayVariance") override val destructionDelayVariance: Int = 0,
    @SageIniName("DecayBeginTime") override val decayBeginTime: Int = 0,
    @SageIniName("OCL") override val oCL: List<PhasedReferences<SlowDeathPhase, ObjectCreationList>> = emptyList(),
    @SageIniName("Weapon") override val weapon: List<PhasedReferences<SlowDeathPhase, Weapon>> = emptyList(),
    @SageIniName("FX") override val fX: List<PhasedReferences<SlowDeathPhase, FXList>> = emptyList(),
    @SageIniName("Sound") override val sound: List<PhasedReferences<SlowDeathPhase, AudioEvent>> = emptyList(),
    @SageIniName("FlingForce") override val flingForce: Int = 0,
    @SageIniName("FlingForceVariance") override val flingForceVariance: Int = 0,
    @SageIniName("FlingPitch") override val flingPitch: Int = 0,
    @SageIniName("FlingPitchVariance") override val flingPitchVariance: Int = 0,
    @SageIniName("DoNotRandomizeMidpoint") override val doNotRandomizeMidpoint: Boolean = false,
    @SageIniName("ClearanceGeometryMajorRadius") val clearanceGeometryMajorRadius: Double = 0.0,
    @SageIniName("ClearanceGeometryMinorRadius") val clearanceGeometryMinorRadius: Double = 0.0,
    @SageIniName("ClearanceGeometryRotationAnchorOffset") val clearanceGeometryRotationAnchorOffset: Coords? = null,
    @SageIniName("ClearanceGeometryHeight") val clearanceGeometryHeight: Double = 0.0,
    @SageIniName("ClearanceGeometryIsSmall") val clearanceGeometryIsSmall: Boolean = false,
    @SageIniName("ClearanceGeometryOffset") val clearanceGeometryOffset: Coords? = null,
    @SageIniName("ClearanceMaxHeight") val clearanceMaxHeight: Double = 0.0,
    @SageIniName("ClearanceMaxHeightFraction") val clearanceMaxHeightFraction: Double = 0.0,
    @SageIniName("ClearanceMinHeight") val clearanceMinHeight: Double = 0.0,
    @SageIniName("ClearanceMinHeightFraction") val clearanceMinHeightFraction: Double = 0.0,
    @SageIniName("ClearanceGeometry") val clearanceGeometry: GeometryType? = null,
) : SlowDeathBehavior() {

    companion object : SageIniBlockDescriptor<ClearanceTestingSlowDeathBehavior>(
        name = "ClearanceTestingSlowDeathBehavior",
        parent = SlowDeathBehavior,
        properties = {
            property("ClearanceGeometryMajorRadius", FloatValue) { it.clearanceGeometryMajorRadius }
            property("ClearanceGeometryMinorRadius", FloatValue) { it.clearanceGeometryMinorRadius }
            property("ClearanceGeometryRotationAnchorOffset", Coords.type) { it.clearanceGeometryRotationAnchorOffset }
            property("ClearanceGeometryHeight", FloatValue) { it.clearanceGeometryHeight }
            property("ClearanceGeometryIsSmall", BooleanValue) { it.clearanceGeometryIsSmall }
            property("ClearanceGeometryOffset", Coords.type) { it.clearanceGeometryOffset }
            property("ClearanceMaxHeight", FloatValue) { it.clearanceMaxHeight }
            property("ClearanceMaxHeightFraction", FloatValue) { it.clearanceMaxHeightFraction }
            property("ClearanceMinHeight", FloatValue) { it.clearanceMinHeight }
            property("ClearanceMinHeightFraction", FloatValue) { it.clearanceMinHeightFraction }
            property("ClearanceGeometry", GeometryType.type) { it.clearanceGeometry }
        },
    )
}
