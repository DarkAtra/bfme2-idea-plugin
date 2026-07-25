package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.`object`.LivingWorldPlayerTemplate
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class AddPlayer(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("PlayerTemplate") val playerTemplate: SageReference<LivingWorldPlayerTemplate>? = null,
    @SageIniName("BaseRegion") val baseRegion: Untyped? = null,
    @SageIniName("MP_SlotColorIndex") val mPSlotColorIndex: Int = 0,
    @SageIniName("TeamNumber") val teamNumber: Int = 0,
    @SageIniName("AITemplate") val aITemplate: Untyped? = null,
    @SageIniName("IsDumb") val isDumb: Boolean = false,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<AddPlayer>(
        name = "AddPlayer",
        properties = {
            property("PlayerTemplate", ReferenceValue<LivingWorldPlayerTemplate> { listOf(LivingWorldPlayerTemplate) }) { it.playerTemplate }
            property("BaseRegion", Untyped.type) { it.baseRegion }
            property("MP_SlotColorIndex", IntValue) { it.mPSlotColorIndex }
            property("TeamNumber", IntValue) { it.teamNumber }
            property("AITemplate", Untyped.type) { it.aITemplate }
            property("IsDumb", BooleanValue) { it.isDumb }
        },
    )
}
