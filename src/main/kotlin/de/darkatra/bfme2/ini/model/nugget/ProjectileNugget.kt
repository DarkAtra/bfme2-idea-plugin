package de.darkatra.bfme2.ini.model.nugget

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.`object`.Weapon
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class ProjectileNugget(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialObjectFilter") override val specialObjectFilter: SageFilter? = null,
    @SageIniName("ForbiddenUpgradeNames") override val forbiddenUpgradeNames: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("RequiredUpgradeNames") override val requiredUpgradeNames: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("WarheadTemplateName") val warheadTemplateName: SageReference<Weapon>? = null,
    @SageIniName("WeaponLaunchBoneSlotOverride") val weaponLaunchBoneSlotOverride: Untyped? = null,
    @SageIniName("ProjectileTemplateName") val projectileTemplateName: SageReference<Object>? = null,
    @SageIniName("AlwaysAttackHereOffset") val alwaysAttackHereOffset: Coords? = null,
    @SageIniName("UseAlwaysAttackOffset") val useAlwaysAttackOffset: Boolean = false,
) : WeaponEffectNugget() {

    companion object : SageIniBlockDescriptor<ProjectileNugget>(
        name = "ProjectileNugget",
        parent = WeaponEffectNugget,
        properties = {
            property("WarheadTemplateName", ReferenceValue<Weapon> { listOf(Weapon) }) { it.warheadTemplateName }
            property("WeaponLaunchBoneSlotOverride", Untyped.type) { it.weaponLaunchBoneSlotOverride }
            property("ProjectileTemplateName", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.projectileTemplateName }
            property("AlwaysAttackHereOffset", Coords.type) { it.alwaysAttackHereOffset }
            property("UseAlwaysAttackOffset", BooleanValue) { it.useAlwaysAttackOffset }
        },
    )
}
