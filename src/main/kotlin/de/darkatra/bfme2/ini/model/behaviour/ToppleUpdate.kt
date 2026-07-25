package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.value.SageReference

data class ToppleUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ToppleFX") val toppleFX: SageReference<FXList>? = null,
    @SageIniName("BounceFX") val bounceFX: SageReference<FXList>? = null,
    @SageIniName("KillWhenStartToppling") val killWhenStartToppling: Boolean = false,
    @SageIniName("KillWhenFinishedToppling") val killWhenFinishedToppling: Boolean = false,
    @SageIniName("KillStumpWhenToppled") val killStumpWhenToppled: Boolean = false,
    @SageIniName("ToppleLeftOrRightOnly") val toppleLeftOrRightOnly: Boolean = false,
    @SageIniName("ReorientToppledRubble") val reorientToppledRubble: Boolean = false,
    @SageIniName("BounceVelocityPercent") val bounceVelocityPercent: Double = 0.0,
    @SageIniName("InitialAccelPercent") val initialAccelPercent: Double = 0.0,
    @SageIniName("StumpName") val stumpName: SageReference<Object>? = null,
    @SageIniName("InitialVelocityPercent") val initialVelocityPercent: Double = 0.0,
    @SageIniName("MinimumToppleSpeed") val minimumToppleSpeed: Double = 0.0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<ToppleUpdate>(
        name = "ToppleUpdate",
        properties = {
            property("ToppleFX", ReferenceValue<FXList> { listOf(FXList) }) { it.toppleFX }
            property("BounceFX", ReferenceValue<FXList> { listOf(FXList) }) { it.bounceFX }
            property("KillWhenStartToppling", BooleanValue) { it.killWhenStartToppling }
            property("KillWhenFinishedToppling", BooleanValue) { it.killWhenFinishedToppling }
            property("KillStumpWhenToppled", BooleanValue) { it.killStumpWhenToppled }
            property("ToppleLeftOrRightOnly", BooleanValue) { it.toppleLeftOrRightOnly }
            property("ReorientToppledRubble", BooleanValue) { it.reorientToppledRubble }
            property("BounceVelocityPercent", FloatValue) { it.bounceVelocityPercent }
            property("InitialAccelPercent", FloatValue) { it.initialAccelPercent }
            property("StumpName", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.stumpName }
            property("InitialVelocityPercent", FloatValue) { it.initialVelocityPercent }
            property("MinimumToppleSpeed", FloatValue) { it.minimumToppleSpeed }
        },
    )
}
