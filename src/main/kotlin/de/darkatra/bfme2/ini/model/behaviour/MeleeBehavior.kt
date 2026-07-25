package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute

data class MeleeBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("FacingBonus") val facingBonus: Double = 0.0,
    @SageIniName("AngleLimitCos") val angleLimitCos: Double = 0.0,
    @SageIniName("InnerRange") val innerRange: Double = 0.0,
    @SageIniName("OuterRange") val outerRange: Double = 0.0,
    @SageIniName("OuterRangeBuildings") val outerRangeBuildings: Double = 0.0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<MeleeBehavior>(
        name = "MeleeBehavior",
        keyedByLabel = true,
        properties = {
            property("FacingBonus", FloatValue) { it.facingBonus }
            property("AngleLimitCos", FloatValue) { it.angleLimitCos }
            property("InnerRange", FloatValue) { it.innerRange }
            property("OuterRange", FloatValue) { it.outerRange }
            property("OuterRangeBuildings", FloatValue) { it.outerRangeBuildings }
        },
    )
}
