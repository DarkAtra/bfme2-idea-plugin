package de.darkatra.bfme2.ini.model.nugget

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class HordeAttackNugget(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialObjectFilter") override val specialObjectFilter: SageFilter? = null,
    @SageIniName("ForbiddenUpgradeNames") override val forbiddenUpgradeNames: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("RequiredUpgradeNames") override val requiredUpgradeNames: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("LockWeaponSlot") val lockWeaponSlot: Untyped? = null,
    @SageIniName("ClosestMemberOnly") val closestMemberOnly: Boolean = false,
) : WeaponEffectNugget() {

    companion object : SageIniBlockDescriptor<HordeAttackNugget>(
        name = "HordeAttackNugget",
        parent = WeaponEffectNugget,
        properties = {
            property("LockWeaponSlot", Untyped.type) { it.lockWeaponSlot }
            property("ClosestMemberOnly", BooleanValue) { it.closestMemberOnly }
        },
    )
}
