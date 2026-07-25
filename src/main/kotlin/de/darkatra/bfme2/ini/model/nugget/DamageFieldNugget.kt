package de.darkatra.bfme2.ini.model.nugget

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.`object`.Weapon
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class DamageFieldNugget(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialObjectFilter") override val specialObjectFilter: SageFilter? = null,
    @SageIniName("ForbiddenUpgradeNames") override val forbiddenUpgradeNames: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("RequiredUpgradeNames") override val requiredUpgradeNames: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("WeaponTemplateName") val weaponTemplateName: SageReference<Weapon>? = null,
    @SageIniName("Duration") val duration: Double = 0.0,
) : WeaponEffectNugget() {

    companion object : SageIniBlockDescriptor<DamageFieldNugget>(
        name = "DamageFieldNugget",
        parent = WeaponEffectNugget,
        properties = {
            property("WeaponTemplateName", ReferenceValue<Weapon> { listOf(Weapon) }) { it.weaponTemplateName }
            property("Duration", FloatValue) { it.duration }
        },
    )
}
