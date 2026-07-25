package de.darkatra.bfme2.ini.model.nugget

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class MetaImpactNugget(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialObjectFilter") override val specialObjectFilter: SageFilter? = null,
    @SageIniName("ForbiddenUpgradeNames") override val forbiddenUpgradeNames: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("RequiredUpgradeNames") override val requiredUpgradeNames: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("AffectHordes") val affectHordes: Boolean = false,
    @SageIniName("HeroResist") val heroResist: Double = 0.0,
    @SageIniName("ShockWaveClearRadius") val shockWaveClearRadius: Boolean = false,
    @SageIniName("ShockWaveClearMult") val shockWaveClearMult: Double = 0.0,
    @SageIniName("ShockWaveClearFlingHeight") val shockWaveClearFlingHeight: Double = 0.0,
    @SageIniName("InvertShockWave") val invertShockWave: Boolean = false,
    @SageIniName("CyclonicFactor") val cyclonicFactor: Double = 0.0,
    @SageIniName("FlipDirection") val flipDirection: Boolean = false,
    @SageIniName("ShockWaveArcInverted") val shockWaveArcInverted: Boolean = false,
    @SageIniName("ShockWaveAmount") val shockWaveAmount: Double = 0.0,
    @SageIniName("ShockWaveRadius") val shockWaveRadius: Double = 0.0,
    @SageIniName("ShockWaveArc") val shockWaveArc: Double = 0.0,
    @SageIniName("ShockWaveTaperOff") val shockWaveTaperOff: Double = 0.0,
    @SageIniName("ShockWaveSpeed") val shockWaveSpeed: Double = 0.0,
    @SageIniName("ShockWaveZMult") val shockWaveZMult: Double = 0.0,
    @SageIniName("KillObjectFilter") val killObjectFilter: SageFilter? = null,
    @SageIniName("OnlyWhenJustDied") val onlyWhenJustDied: Boolean = false,
    @SageIniName("DelayTime") val delayTime: Double = 0.0,
) : WeaponEffectNugget() {

    companion object : SageIniBlockDescriptor<MetaImpactNugget>(
        name = "MetaImpactNugget",
        parent = WeaponEffectNugget,
        properties = {
            property("AffectHordes", BooleanValue) { it.affectHordes }
            property("HeroResist", FloatValue) { it.heroResist }
            property("ShockWaveClearRadius", BooleanValue) { it.shockWaveClearRadius }
            property("ShockWaveClearMult", FloatValue) { it.shockWaveClearMult }
            property("ShockWaveClearFlingHeight", FloatValue) { it.shockWaveClearFlingHeight }
            property("InvertShockWave", BooleanValue) { it.invertShockWave }
            property("CyclonicFactor", FloatValue) { it.cyclonicFactor }
            property("FlipDirection", BooleanValue) { it.flipDirection }
            property("ShockWaveArcInverted", BooleanValue) { it.shockWaveArcInverted }
            property("ShockWaveAmount", FloatValue) { it.shockWaveAmount }
            property("ShockWaveRadius", FloatValue) { it.shockWaveRadius }
            property("ShockWaveArc", FloatValue) { it.shockWaveArc }
            property("ShockWaveTaperOff", FloatValue) { it.shockWaveTaperOff }
            property("ShockWaveSpeed", FloatValue) { it.shockWaveSpeed }
            property("ShockWaveZMult", FloatValue) { it.shockWaveZMult }
            property("KillObjectFilter", SageFilter.type) { it.killObjectFilter }
            property("OnlyWhenJustDied", BooleanValue) { it.onlyWhenJustDied }
            property("DelayTime", FloatValue) { it.delayTime }
        },
    )
}
