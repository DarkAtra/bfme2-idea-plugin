package de.darkatra.bfme2.ini.model.nugget

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class ParalyzeNugget(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialObjectFilter") override val specialObjectFilter: SageFilter? = null,
    @SageIniName("ForbiddenUpgradeNames") override val forbiddenUpgradeNames: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("RequiredUpgradeNames") override val requiredUpgradeNames: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("Radius") val radius: Double = 0.0,
    @SageIniName("Duration") val duration: Double = 0.0,
    @SageIniName("FreezeAnimation") val freezeAnimation: Boolean = false,
    @SageIniName("AffectHordeMembers") val affectHordeMembers: Boolean = false,
    @SageIniName("ParalyzeFX") val paralyzeFX: SageReference<FXList>? = null,
) : WeaponEffectNugget() {

    companion object : SageIniBlockDescriptor<ParalyzeNugget>(
        name = "ParalyzeNugget",
        parent = WeaponEffectNugget,
        properties = {
            property("Radius", FloatValue) { it.radius }
            property("Duration", FloatValue) { it.duration }
            property("FreezeAnimation", BooleanValue) { it.freezeAnimation }
            property("AffectHordeMembers", BooleanValue) { it.affectHordeMembers }
            property("ParalyzeFX", ReferenceValue<FXList> { listOf(FXList) }) { it.paralyzeFX }
        },
    )
}
