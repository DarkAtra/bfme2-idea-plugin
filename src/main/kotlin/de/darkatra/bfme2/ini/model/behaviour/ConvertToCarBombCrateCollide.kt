package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.draw.Animation
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.Science
import de.darkatra.bfme2.ini.model.value.KindOf
import de.darkatra.bfme2.ini.model.value.SageReference

data class ConvertToCarBombCrateCollide(
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
) : CrateCollide() {

    companion object : SageIniBlockDescriptor<ConvertToCarBombCrateCollide>(
        name = "ConvertToCarBombCrateCollide",
        parent = CrateCollide,
    )
}
