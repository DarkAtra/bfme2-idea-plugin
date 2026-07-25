package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.ui.Window

data class WindowTransition(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("FireOnce") val fireOnce: Boolean = false,
    @SageIniName("Window") val window: List<Window> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<WindowTransition>(
        name = "WindowTransition",
        tableKey = "windowtransitions",
        properties = {
            property("FireOnce", BooleanValue) { it.fireOnce }
            property("Window", ListValue(BlockValue<Window> { listOf(Window) })) { it.window }
        },
    )
}
