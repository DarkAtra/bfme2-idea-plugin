package de.darkatra.bfme2.ini.model.nugget

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.DamageFXType
import de.darkatra.bfme2.ini.model.value.DamageType
import de.darkatra.bfme2.ini.model.value.DeathType
import de.darkatra.bfme2.ini.model.value.KindOf
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.ScaledObjectFilter

data class DamageContainedNugget(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialObjectFilter") override val specialObjectFilter: SageFilter? = null,
    @SageIniName("ForbiddenUpgradeNames") override val forbiddenUpgradeNames: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("RequiredUpgradeNames") override val requiredUpgradeNames: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("Damage") override val damage: Double = 0.0,
    @SageIniName("Radius") override val radius: Double = 0.0,
    @SageIniName("DamageFXType") override val damageFXType: DamageFXType? = null,
    @SageIniName("DelayTime") override val delayTime: Double = 0.0,
    @SageIniName("DamageScalar") override val damageScalar: List<ScaledObjectFilter> = emptyList(),
    @SageIniName("DamageArc") override val damageArc: Double = 0.0,
    @SageIniName("FlankingBonus") override val flankingBonus: Double = 0.0,
    @SageIniName("AcceptDamageAdd") override val acceptDamageAdd: Boolean = false,
    @SageIniName("DamageTaperOff") override val damageTaperOff: Double = 0.0,
    @SageIniName("DamageSpeed") override val damageSpeed: Double = 0.0,
    @SageIniName("DamageSubType") override val damageSubType: DamageType? = null,
    @SageIniName("DrainLife") override val drainLife: Boolean = false,
    @SageIniName("DrainLifeMultiplier") override val drainLifeMultiplier: Double = 0.0,
    @SageIniName("CylinderAOE") override val cylinderAOE: Boolean = false,
    @SageIniName("DamageMaxHeight") override val damageMaxHeight: Double = 0.0,
    @SageIniName("DamageArcInverted") override val damageArcInverted: Boolean = false,
    @SageIniName("ForceKillObjectFilter") override val forceKillObjectFilter: SageFilter? = null,
    @SageIniName("DamageMaxHeightAboveTerrain") override val damageMaxHeightAboveTerrain: Double = 0.0,
    @SageIniName("DamageType") override val damageType: DamageType? = null,
    @SageIniName("DeathType") override val deathType: DeathType? = null,
    @SageIniName("MinRadius") override val minRadius: Double = 0.0,
    @SageIniName("LostLeadershipUselessAgainst") override val lostLeadershipUselessAgainst: KindOf? = null,
    @SageIniName("KillCount") val killCount: Double = 0.0,
    @SageIniName("KillKindof") val killKindof: List<KindOf> = emptyList(),
    @SageIniName("KillKindofNot") val killKindofNot: List<KindOf> = emptyList(),
) : DamageNugget() {

    companion object : SageIniBlockDescriptor<DamageContainedNugget>(
        name = "DamageContainedNugget",
        parent = DamageNugget,
        properties = {
            property("KillCount", FloatValue) { it.killCount }
            property("KillKindof", ListValue(KindOf.type)) { it.killKindof }
            property("KillKindofNot", ListValue(KindOf.type)) { it.killKindofNot }
        },
    )
}
