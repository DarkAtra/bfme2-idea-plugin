package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.value.Untyped

data class BridgeBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("BridgeDieFX") val bridgeDieFX: Untyped? = null,
    @SageIniName("BridgeDieOCL") val bridgeDieOCL: Untyped? = null,
    @SageIniName("LateralScaffoldSpeed") val lateralScaffoldSpeed: Double = 0.0,
    @SageIniName("VerticalScaffoldSpeed") val verticalScaffoldSpeed: Double = 0.0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<BridgeBehavior>(
        name = "BridgeBehavior",
        properties = {
            property("BridgeDieFX", Untyped.type) { it.bridgeDieFX }
            property("BridgeDieOCL", Untyped.type) { it.bridgeDieOCL }
            property("LateralScaffoldSpeed", FloatValue) { it.lateralScaffoldSpeed }
            property("VerticalScaffoldSpeed", FloatValue) { it.verticalScaffoldSpeed }
        },
    )
}
