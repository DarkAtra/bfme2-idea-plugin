package de.darkatra.bfme2.ini.model.ui

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Untyped

data class Window(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("WinName") val winName: Untyped? = null,
    @SageIniName("FrameDelay") val frameDelay: Int = 0,
    @SageIniName("Transition") val transition: List<Transition> = emptyList(),
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<Window>(
        name = "Window",
        properties = {
            property("WinName", Untyped.type) { it.winName }
            property("FrameDelay", IntValue) { it.frameDelay }
            property("Transition", ListValue(BlockValue<Transition> { listOf(Transition) })) { it.transition }
        },
    )
}
