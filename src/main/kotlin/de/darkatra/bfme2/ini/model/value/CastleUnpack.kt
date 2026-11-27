package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue

/**
 * The base a `CastleBehavior` unpacks for a faction. The castle names a base layout (`.bse` file) rather than an object.
 */
data class CastleUnpack(val faction: String = "", val castle: String = "") {

    companion object {

        val type: SageIniValueType<CastleUnpack> = StructValue("CastleUnpack") {
            component("Faction", StringValue) { it.faction }
            component("Castle", StringValue) { it.castle }
        }
    }
}
