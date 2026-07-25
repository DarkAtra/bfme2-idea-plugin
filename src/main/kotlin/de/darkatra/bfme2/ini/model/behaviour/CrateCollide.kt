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

open class CrateCollide(
    open val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("RequiredKindOf") open val requiredKindOf: List<KindOf> = emptyList(),
    @SageIniName("ForbiddenKindOf") open val forbiddenKindOf: List<KindOf> = emptyList(),
    @SageIniName("ForbidOwnerPlayer") open val forbidOwnerPlayer: Boolean = false,
    @SageIniName("BuildingPickup") open val buildingPickup: Boolean = false,
    @SageIniName("HumanOnly") open val humanOnly: Boolean = false,
    @SageIniName("FXList") open val fXList: SageReference<FXList>? = null,
    @SageIniName("PickupScience") open val pickupScience: SageReference<Science>? = null,
    @SageIniName("ExecuteFX") open val executeFX: SageReference<FXList>? = null,
    @SageIniName("ExecuteAnimation") open val executeAnimation: SageReference<Animation>? = null,
    @SageIniName("ExecuteAnimationTime") open val executeAnimationTime: Double = 0.0,
    @SageIniName("ExecuteAnimationZRise") open val executeAnimationZRise: Double = 0.0,
    @SageIniName("ExecuteAnimationFades") open val executeAnimationFades: Boolean = false,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<CrateCollide>(
        name = "CrateCollide",
        properties = {
            property("RequiredKindOf", ListValue(KindOf.type)) { it.requiredKindOf }
            property("ForbiddenKindOf", ListValue(KindOf.type)) { it.forbiddenKindOf }
            property("ForbidOwnerPlayer", BooleanValue) { it.forbidOwnerPlayer }
            property("BuildingPickup", BooleanValue) { it.buildingPickup }
            property("HumanOnly", BooleanValue) { it.humanOnly }
            property("FXList", ReferenceValue<FXList> { listOf(FXList) }) { it.fXList }
            property("PickupScience", ReferenceValue<Science> { listOf(Science) }) { it.pickupScience }
            property("ExecuteFX", ReferenceValue<FXList> { listOf(FXList) }) { it.executeFX }
            property("ExecuteAnimation", ReferenceValue<Animation> { listOf(Animation) }) { it.executeAnimation }
            property("ExecuteAnimationTime", FloatValue) { it.executeAnimationTime }
            property("ExecuteAnimationZRise", FloatValue) { it.executeAnimationZRise }
            property("ExecuteAnimationFades", BooleanValue) { it.executeAnimationFades }
        },
    )
}
