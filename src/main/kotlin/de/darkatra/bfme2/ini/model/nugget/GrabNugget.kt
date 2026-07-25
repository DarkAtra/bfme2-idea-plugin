package de.darkatra.bfme2.ini.model.nugget

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class GrabNugget(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialObjectFilter") override val specialObjectFilter: SageFilter? = null,
    @SageIniName("ForbiddenUpgradeNames") override val forbiddenUpgradeNames: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("RequiredUpgradeNames") override val requiredUpgradeNames: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("RemoveTargetFromOtherContain") val removeTargetFromOtherContain: Boolean = false,
    @SageIniName("ContainTargetOnEffect") val containTargetOnEffect: Boolean = false,
    @SageIniName("ImpactTargetOnEffect") val impactTargetOnEffect: Boolean = false,
    @SageIniName("ShockWaveAmount") val shockWaveAmount: Double = 0.0,
    @SageIniName("ShockWaveRadius") val shockWaveRadius: Double = 0.0,
    @SageIniName("ShockWaveTaperOff") val shockWaveTaperOff: Double = 0.0,
    @SageIniName("ShockWaveZMult") val shockWaveZMult: Double = 0.0,
) : WeaponEffectNugget() {

    companion object : SageIniBlockDescriptor<GrabNugget>(
        name = "GrabNugget",
        parent = WeaponEffectNugget,
        properties = {
            property("RemoveTargetFromOtherContain", BooleanValue) { it.removeTargetFromOtherContain }
            property("ContainTargetOnEffect", BooleanValue) { it.containTargetOnEffect }
            property("ImpactTargetOnEffect", BooleanValue) { it.impactTargetOnEffect }
            property("ShockWaveAmount", FloatValue) { it.shockWaveAmount }
            property("ShockWaveRadius", FloatValue) { it.shockWaveRadius }
            property("ShockWaveTaperOff", FloatValue) { it.shockWaveTaperOff }
            property("ShockWaveZMult", FloatValue) { it.shockWaveZMult }
        },
    )
}
