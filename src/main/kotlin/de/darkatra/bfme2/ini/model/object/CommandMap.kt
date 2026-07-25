package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.value.Untyped

data class CommandMap(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Key") val key: Untyped? = null,
    @SageIniName("Transition") val transition: Untyped? = null,
    @SageIniName("Modifiers") val modifiers: Untyped? = null,
    @SageIniName("UseableIn") val useableIn: Untyped? = null,
    @SageIniName("Category") val category: Untyped? = null,
    @SageIniName("Description") val description: String = "",
    @SageIniName("DisplayName") val displayName: String = "",
) : SageIniObject {

    companion object : SageIniBlockDescriptor<CommandMap>(
        name = "CommandMap",
        tableKey = "commandmaps",
        properties = {
            property("Key", Untyped.type) { it.key }
            property("Transition", Untyped.type) { it.transition }
            property("Modifiers", Untyped.type) { it.modifiers }
            property("UseableIn", Untyped.type) { it.useableIn }
            property("Category", Untyped.type) { it.category }
            property("Description", StringValue) { it.description }
            property("DisplayName", StringValue) { it.displayName }
        },
    )
}
