package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.Untyped

data class LivingWorldAnimObject(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Model") val model: Opaque? = null,
    @SageIniName("Pos") val pos: Coords? = null,
    @SageIniName("Shadow") val shadow: Untyped? = null,
    @SageIniName("HasAnim") val hasAnim: Boolean = false,
    @SageIniName("Xfer") val xfer: Boolean = false,
    @SageIniName("Frame") val frame: Double = 0.0,
    @SageIniName("OrientAngle") val orientAngle: Double = 0.0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<LivingWorldAnimObject>(
        name = "LivingWorldAnimObject",
        tableKey = "livingworldanimobjects",
        properties = {
            property("Model", Opaque.type) { it.model }
            property("Pos", Coords.type) { it.pos }
            property("Shadow", Untyped.type) { it.shadow }
            property("HasAnim", BooleanValue) { it.hasAnim }
            property("Xfer", BooleanValue) { it.xfer }
            property("Frame", FloatValue) { it.frame }
            property("OrientAngle", FloatValue) { it.orientAngle }
        },
    )
}
