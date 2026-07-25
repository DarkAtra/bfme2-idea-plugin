package de.darkatra.bfme2.ini.model.nugget

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.EmotionTypes
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class EmotionWeaponNugget(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialObjectFilter") override val specialObjectFilter: SageFilter? = null,
    @SageIniName("ForbiddenUpgradeNames") override val forbiddenUpgradeNames: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("RequiredUpgradeNames") override val requiredUpgradeNames: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("EmotionType") val emotionType: EmotionTypes? = null,
    @SageIniName("Radius") val radius: Double = 0.0,
    @SageIniName("Duration") val duration: Double = 0.0,
) : WeaponEffectNugget() {

    companion object : SageIniBlockDescriptor<EmotionWeaponNugget>(
        name = "EmotionWeaponNugget",
        parent = WeaponEffectNugget,
        properties = {
            property("EmotionType", EmotionTypes.type) { it.emotionType }
            property("Radius", FloatValue) { it.radius }
            property("Duration", FloatValue) { it.duration }
        },
    )
}
