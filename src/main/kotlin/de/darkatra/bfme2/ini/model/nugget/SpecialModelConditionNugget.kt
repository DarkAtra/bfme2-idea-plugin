package de.darkatra.bfme2.ini.model.nugget

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.ModelCondition
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class SpecialModelConditionNugget(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialObjectFilter") override val specialObjectFilter: SageFilter? = null,
    @SageIniName("ForbiddenUpgradeNames") override val forbiddenUpgradeNames: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("RequiredUpgradeNames") override val requiredUpgradeNames: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("ModelConditionNames") val modelConditionNames: List<ModelCondition> = emptyList(),
    @SageIniName("ModelConditionDuration") val modelConditionDuration: Double = 0.0,
) : WeaponEffectNugget() {

    companion object : SageIniBlockDescriptor<SpecialModelConditionNugget>(
        name = "SpecialModelConditionNugget",
        parent = WeaponEffectNugget,
        properties = {
            property("ModelConditionNames", ListValue(ModelCondition.type)) { it.modelConditionNames }
            property("ModelConditionDuration", FloatValue) { it.modelConditionDuration }
        },
    )
}
