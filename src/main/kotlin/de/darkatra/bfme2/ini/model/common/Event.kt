package de.darkatra.bfme2.ini.model.common

import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class Event(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("EventFX") val eventFX: SageReference<FXList>? = null,
    @SageIniName("HeightOffset") val heightOffset: Untyped? = null,
    @SageIniName("OrientFXToTerrain") val orientFXToTerrain: Boolean = false,
    @SageIniName("PerParticle") val perParticle: Boolean = false,
    @SageIniName("KillAfterEvent") val killAfterEvent: Boolean = false,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<Event>(
        name = "Event",
        keyedByLabel = true,
        properties = {
            property("EventFX", ReferenceValue<FXList> { listOf(FXList) }) { it.eventFX }
            property("HeightOffset", Untyped.type) { it.heightOffset }
            property("OrientFXToTerrain", BooleanValue) { it.orientFXToTerrain }
            property("PerParticle", BooleanValue) { it.perParticle }
            property("KillAfterEvent", BooleanValue) { it.killAfterEvent }
        },
    )
}
