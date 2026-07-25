package de.darkatra.bfme2.ini.model.nugget

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
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

open class DamageNugget(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialObjectFilter") override val specialObjectFilter: SageFilter? = null,
    @SageIniName("ForbiddenUpgradeNames") override val forbiddenUpgradeNames: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("RequiredUpgradeNames") override val requiredUpgradeNames: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("Damage") open val damage: Double = 0.0,
    @SageIniName("Radius") open val radius: Double = 0.0,
    @SageIniName("DamageFXType") open val damageFXType: DamageFXType? = null,
    @SageIniName("DelayTime") open val delayTime: Double = 0.0,
    @SageIniName("DamageScalar") open val damageScalar: List<ScaledObjectFilter> = emptyList(),
    @SageIniName("DamageArc") open val damageArc: Double = 0.0,
    @SageIniName("FlankingBonus") open val flankingBonus: Double = 0.0,
    @SageIniName("AcceptDamageAdd") open val acceptDamageAdd: Boolean = false,
    @SageIniName("DamageTaperOff") open val damageTaperOff: Double = 0.0,
    @SageIniName("DamageSpeed") open val damageSpeed: Double = 0.0,
    @SageIniName("DamageSubType") open val damageSubType: DamageType? = null,
    @SageIniName("DrainLife") open val drainLife: Boolean = false,
    @SageIniName("DrainLifeMultiplier") open val drainLifeMultiplier: Double = 0.0,
    @SageIniName("CylinderAOE") open val cylinderAOE: Boolean = false,
    @SageIniName("DamageMaxHeight") open val damageMaxHeight: Double = 0.0,
    @SageIniName("DamageArcInverted") open val damageArcInverted: Boolean = false,
    @SageIniName("ForceKillObjectFilter") open val forceKillObjectFilter: SageFilter? = null,
    @SageIniName("DamageMaxHeightAboveTerrain") open val damageMaxHeightAboveTerrain: Double = 0.0,
    @SageIniName("DamageType") open val damageType: DamageType? = null,
    @SageIniName("DeathType") open val deathType: DeathType? = null,
    @SageIniName("MinRadius") open val minRadius: Double = 0.0,
    @SageIniName("LostLeadershipUselessAgainst") open val lostLeadershipUselessAgainst: KindOf? = null,
) : WeaponEffectNugget() {

    companion object : SageIniBlockDescriptor<DamageNugget>(
        name = "DamageNugget",
        parent = WeaponEffectNugget,
        properties = {
            property("Damage", FloatValue) { it.damage }
            property("Radius", FloatValue) { it.radius }
            property("DamageFXType", DamageFXType.type) { it.damageFXType }
            property("DelayTime", FloatValue) { it.delayTime }
            property("DamageScalar", ListValue(ScaledObjectFilter.type)) { it.damageScalar }
            property("DamageArc", FloatValue) { it.damageArc }
            property("FlankingBonus", FloatValue) { it.flankingBonus }
            property("AcceptDamageAdd", BooleanValue) { it.acceptDamageAdd }
            property("DamageTaperOff", FloatValue) { it.damageTaperOff }
            property("DamageSpeed", FloatValue) { it.damageSpeed }
            property("DamageSubType", DamageType.type) { it.damageSubType }
            property("DrainLife", BooleanValue) { it.drainLife }
            property("DrainLifeMultiplier", FloatValue) { it.drainLifeMultiplier }
            property("CylinderAOE", BooleanValue) { it.cylinderAOE }
            property("DamageMaxHeight", FloatValue) { it.damageMaxHeight }
            property("DamageArcInverted", BooleanValue) { it.damageArcInverted }
            property("ForceKillObjectFilter", SageFilter.type) { it.forceKillObjectFilter }
            property("DamageMaxHeightAboveTerrain", FloatValue) { it.damageMaxHeightAboveTerrain }
            property("DamageType", DamageType.type) { it.damageType }
            property("DeathType", DeathType.type) { it.deathType }
            property("MinRadius", FloatValue) { it.minRadius }
            property("LostLeadershipUselessAgainst", KindOf.type) { it.lostLeadershipUselessAgainst }
        },
    )
}
