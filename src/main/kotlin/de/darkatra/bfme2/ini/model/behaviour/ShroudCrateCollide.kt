package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.draw.Animation
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.Science
import de.darkatra.bfme2.ini.model.value.KindOf
import de.darkatra.bfme2.ini.model.value.SageReference

data class ShroudCrateCollide(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("BuildingPickup") val buildingPickup: Boolean = false,
    @SageIniName("ExecuteAnimation") val executeAnimation: SageReference<Animation>? = null,
    @SageIniName("ExecuteAnimationFades") val executeAnimationFades: Boolean = true,
    @SageIniName("ExecuteAnimationTime") val executeAnimationTime: Double = 0.0,
    @SageIniName("ExecuteAnimationZRise") val executeAnimationZRise: Double = 0.0,
    @SageIniName("ExecuteFX") val executeFX: SageReference<FXList>? = null,
    @SageIniName("ForbiddenKindOf") val forbiddenKindOf: List<KindOf> = emptyList(),
    @SageIniName("ForbidOwnerPlayer") val forbidOwnerPlayer: Boolean = false,
    @SageIniName("HumanOnly") val humanOnly: Boolean = false,
    @SageIniName("PickupScience") val pickupScience: SageReference<Science>? = null,
    @SageIniName("RequiredKindOf") val requiredKindOf: List<KindOf> = emptyList(),
) : SageBehavior {

    companion object : SageIniBlockDescriptor<ShroudCrateCollide>(
        name = "ShroudCrateCollide",
        properties = {
            property("BuildingPickup", BooleanValue) { it.buildingPickup }
            property("ExecuteAnimation", ReferenceValue<Animation> { listOf(Animation) }) { it.executeAnimation }
            property("ExecuteAnimationFades", BooleanValue) { it.executeAnimationFades }
            property("ExecuteAnimationTime", FloatValue) { it.executeAnimationTime }
            property("ExecuteAnimationZRise", FloatValue) { it.executeAnimationZRise }
            property("ExecuteFX", ReferenceValue<FXList> { listOf(FXList) }) { it.executeFX }
            property("ForbiddenKindOf", ListValue(KindOf.type)) { it.forbiddenKindOf }
            property("ForbidOwnerPlayer", BooleanValue) { it.forbidOwnerPlayer }
            property("HumanOnly", BooleanValue) { it.humanOnly }
            property("PickupScience", ReferenceValue<Science> { listOf(Science) }) { it.pickupScience }
            property("RequiredKindOf", ListValue(KindOf.type)) { it.requiredKindOf }
        },
    )
}
