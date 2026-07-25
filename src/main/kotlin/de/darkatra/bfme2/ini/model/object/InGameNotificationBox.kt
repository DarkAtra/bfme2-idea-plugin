package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.Rgba
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class InGameNotificationBox(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DefaultMessageFont") val defaultMessageFont: Untyped? = null,
    @SageIniName("DefaultMessageColor") val defaultMessageColor: Rgba? = null,
    @SageIniName("DefaultOpenAudio") val defaultOpenAudio: SageReference<AudioEvent>? = null,
    @SageIniName("Font") val font: Opaque? = null,
    @SageIniName("NotificationType") val notificationType: List<NotificationType> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<InGameNotificationBox>(
        name = "InGameNotificationBox",
        tableKey = "ingamenotificationboxs",
        properties = {
            property("DefaultMessageFont", Untyped.type) { it.defaultMessageFont }
            property("DefaultMessageColor", Rgba.type) { it.defaultMessageColor }
            property("DefaultOpenAudio", ReferenceValue<AudioEvent> { listOf(AudioEvent) }) { it.defaultOpenAudio }
            property("Font", Opaque.type) { it.font }
            property("NotificationType", ListValue(BlockValue<NotificationType> { listOf(NotificationType) })) { it.notificationType }
        },
    )
}
