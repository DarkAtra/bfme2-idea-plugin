package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.Untyped

data class SpawnArmies(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Player") val player: Untyped? = null,
    @SageIniName("Army") val army: List<Untyped> = emptyList(),
    @SageIniName("Armies") val armies: List<Opaque> = emptyList(),
    @SageIniName("Region") val region: Opaque? = null,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<SpawnArmies>(
        name = "SpawnArmies",
        properties = {
            property("Player", Untyped.type) { it.player }
            property("Army", ListValue(Untyped.type)) { it.army }
            property("Armies", ListValue(Opaque.type)) { it.armies }
            property("Region", Opaque.type) { it.region }
        },
    )
}
