package de.darkatra.bfme2.ini.model.nugget

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNugget
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

open class WeaponEffectNugget(
    open val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialObjectFilter") open val specialObjectFilter: SageFilter? = null,
    @SageIniName("ForbiddenUpgradeNames") open val forbiddenUpgradeNames: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("RequiredUpgradeNames") open val requiredUpgradeNames: List<SageReference<Upgrade>> = emptyList(),
) : SageNugget {

    companion object : SageIniBlockDescriptor<WeaponEffectNugget>(
        name = "WeaponEffectNugget",
        properties = {
            property("SpecialObjectFilter", SageFilter.type) { it.specialObjectFilter }
            property("ForbiddenUpgradeNames", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.forbiddenUpgradeNames }
            property("RequiredUpgradeNames", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.requiredUpgradeNames }
        },
    )
}
