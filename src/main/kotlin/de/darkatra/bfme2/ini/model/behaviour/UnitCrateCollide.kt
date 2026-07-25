package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.draw.Animation
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.`object`.Science
import de.darkatra.bfme2.ini.model.value.KindOf
import de.darkatra.bfme2.ini.model.value.SageReference

data class UnitCrateCollide(
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
    @SageIniName("UnitCount") val unitCount: Int = 0,
    @SageIniName("UnitName") val unitName: SageReference<Object>? = null,
) : CrateCollide() {

    companion object : SageIniBlockDescriptor<UnitCrateCollide>(
        name = "UnitCrateCollide",
        parent = CrateCollide,
        properties = {
            property("UnitCount", IntValue) { it.unitCount }
            property("UnitName", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.unitName }
        },
    )
}
