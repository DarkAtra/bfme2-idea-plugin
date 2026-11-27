package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue

@SageIniName("WaitForLeader")
data class WaitForLeaderMeleeBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("FollowLeader") val followLeader: Boolean = false,
    @SageIniName("DistanceToActiveLeader") val distanceToActiveLeader: Double = 0.0,
    @SageIniName("DistanceToPassiveLeader") val distanceToPassiveLeader: Double = 0.0,
) : MeleeBehavior {

    companion object : SageIniBlockDescriptor<WaitForLeaderMeleeBehavior>(
        name = "WaitForLeader",
        properties = {
            property("FollowLeader", BooleanValue) { it.followLeader }
            property("DistanceToActiveLeader", FloatValue) { it.distanceToActiveLeader }
            property("DistanceToPassiveLeader", FloatValue) { it.distanceToPassiveLeader }
        },
    )
}
