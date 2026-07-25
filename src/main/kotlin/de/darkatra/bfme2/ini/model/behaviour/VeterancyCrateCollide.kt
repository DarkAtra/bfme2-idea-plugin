package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.draw.Animation
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.Science
import de.darkatra.bfme2.ini.model.value.KindOf
import de.darkatra.bfme2.ini.model.value.SageReference

data class VeterancyCrateCollide(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("RequiredKindOf") override val requiredKindOf: List<KindOf> = emptyList(),
    @SageIniName("ForbiddenKindOf") override val forbiddenKindOf: List<KindOf> = emptyList(),
    @SageIniName("ForbidOwnerPlayer") override val forbidOwnerPlayer: Boolean = false,
    @SageIniName("BuildingPickup") override val buildingPickup: Boolean = false,
    @SageIniName("HumanOnly") override val humanOnly: Boolean = false,
    @SageIniName("FXList") override val fXList: SageReference<FXList>? = null,
    @SageIniName("PickupScience") override val pickupScience: SageReference<Science>? = null,
    @SageIniName("ExecuteFX") override val executeFX: SageReference<FXList>? = null,
    @SageIniName("ExecuteAnimation") override val executeAnimation: SageReference<Animation>? = null,
    @SageIniName("ExecuteAnimationTime") override val executeAnimationTime: Double = 0.0,
    @SageIniName("ExecuteAnimationZRise") override val executeAnimationZRise: Double = 0.0,
    @SageIniName("ExecuteAnimationFades") override val executeAnimationFades: Boolean = false,
    @SageIniName("EffectRange") val effectRange: Int = 0,
    @SageIniName("AddsOwnerVeterancy") val addsOwnerVeterancy: Boolean = false,
    @SageIniName("IsPilot") val isPilot: Boolean = false,
    @SageIniName("AffectsUpToLevel") val affectsUpToLevel: Int = 0,
) : CrateCollide() {

    companion object : SageIniBlockDescriptor<VeterancyCrateCollide>(
        name = "VeterancyCrateCollide",
        parent = CrateCollide,
        properties = {
            property("EffectRange", IntValue) { it.effectRange }
            property("AddsOwnerVeterancy", BooleanValue) { it.addsOwnerVeterancy }
            property("IsPilot", BooleanValue) { it.isPilot }
            property("AffectsUpToLevel", IntValue) { it.affectsUpToLevel }
        },
    )
}
