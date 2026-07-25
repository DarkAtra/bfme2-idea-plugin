package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Untyped

data class NotificationType(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Title") val title: Untyped? = null,
    @SageIniName("Icon") val icon: Untyped? = null,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<NotificationType>(
        name = "NotificationType",
        properties = {
            property("Title", Untyped.type) { it.title }
            property("Icon", Untyped.type) { it.icon }
        },
    )
}
