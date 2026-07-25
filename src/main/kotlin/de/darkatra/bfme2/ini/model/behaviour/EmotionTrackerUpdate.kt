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
import de.darkatra.bfme2.ini.model.`object`.EmotionNugget
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class EmotionTrackerUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("TauntAndPointDistance") val tauntAndPointDistance: Double = 0.0,
    @SageIniName("TauntAndPointUpdateDelay") val tauntAndPointUpdateDelay: Int = 0,
    @SageIniName("TauntAndPointExcluded") val tauntAndPointExcluded: SageFilter? = null,
    @SageIniName("AfraidOf") val afraidOf: SageFilter? = null,
    @SageIniName("AlwaysAfraidOf") val alwaysAfraidOf: SageFilter? = null,
    @SageIniName("PointAt") val pointAt: SageFilter? = null,
    @SageIniName("HeroScanDistance") val heroScanDistance: Double = 0.0,
    @SageIniName("FearScanDistance") val fearScanDistance: Double = 0.0,
    @SageIniName("QuarrelProbability") val quarrelProbability: Double = 0.0,
    @SageIniName("IgnoreVeterancy") val ignoreVeterancy: Boolean = false,
    @SageIniName("ImmuneToFearLevel") val immuneToFearLevel: Int = 0,
    @SageIniName("AddEmotion") val addEmotion: List<SageReference<EmotionNugget>> = emptyList(),
) : SageBehavior {

    companion object : SageIniBlockDescriptor<EmotionTrackerUpdate>(
        name = "EmotionTrackerUpdate",
        properties = {
            property("TauntAndPointDistance", FloatValue) { it.tauntAndPointDistance }
            property("TauntAndPointUpdateDelay", IntValue) { it.tauntAndPointUpdateDelay }
            property("TauntAndPointExcluded", SageFilter.type) { it.tauntAndPointExcluded }
            property("AfraidOf", SageFilter.type) { it.afraidOf }
            property("AlwaysAfraidOf", SageFilter.type) { it.alwaysAfraidOf }
            property("PointAt", SageFilter.type) { it.pointAt }
            property("HeroScanDistance", FloatValue) { it.heroScanDistance }
            property("FearScanDistance", FloatValue) { it.fearScanDistance }
            property("QuarrelProbability", FloatValue) { it.quarrelProbability }
            property("IgnoreVeterancy", BooleanValue) { it.ignoreVeterancy }
            property("ImmuneToFearLevel", IntValue) { it.immuneToFearLevel }
            property("AddEmotion", ListValue(ReferenceValue<EmotionNugget> { listOf(EmotionNugget) })) { it.addEmotion }
        },
    )
}
