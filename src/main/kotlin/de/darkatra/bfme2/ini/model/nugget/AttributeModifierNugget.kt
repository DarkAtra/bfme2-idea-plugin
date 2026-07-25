package de.darkatra.bfme2.ini.model.nugget

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.ModifierList
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.DamageFXType
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class AttributeModifierNugget(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialObjectFilter") override val specialObjectFilter: SageFilter? = null,
    @SageIniName("ForbiddenUpgradeNames") override val forbiddenUpgradeNames: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("RequiredUpgradeNames") override val requiredUpgradeNames: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("AttributeModifier") val attributeModifier: SageReference<ModifierList>? = null,
    @SageIniName("AntiCategories") val antiCategories: Untyped? = null,
    @SageIniName("Radius") val radius: Double = 0.0,
    @SageIniName("DamageFXType") val damageFXType: DamageFXType? = null,
    @SageIniName("AffectHordeMembers") val affectHordeMembers: Boolean = false,
) : WeaponEffectNugget() {

    companion object : SageIniBlockDescriptor<AttributeModifierNugget>(
        name = "AttributeModifierNugget",
        parent = WeaponEffectNugget,
        properties = {
            property("AttributeModifier", ReferenceValue<ModifierList> { listOf(ModifierList) }) { it.attributeModifier }
            property("AntiCategories", Untyped.type) { it.antiCategories }
            property("Radius", FloatValue) { it.radius }
            property("DamageFXType", DamageFXType.type) { it.damageFXType }
            property("AffectHordeMembers", BooleanValue) { it.affectHordeMembers }
        },
    )
}
