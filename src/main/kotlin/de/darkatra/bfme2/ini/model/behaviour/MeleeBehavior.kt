package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute

/**
 * A `MeleeBehavior = <type>` block, whose properties depend on its type.
 */
interface MeleeBehavior : SageNestedAttribute {

    companion object {

        val types: List<SageIniBlockDescriptor<out MeleeBehavior>> by lazy {
            listOf(SwarmMeleeBehavior, WaitForLeaderMeleeBehavior, HoldGroundMeleeBehavior, AmoebaMeleeBehavior)
        }
    }
}
