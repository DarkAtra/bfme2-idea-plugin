package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.value.Opaque

data class SkyboxTextureSet(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SkyboxTextureN") val skyboxTextureN: Opaque? = null,
    @SageIniName("SkyboxTextureE") val skyboxTextureE: Opaque? = null,
    @SageIniName("SkyboxTextureS") val skyboxTextureS: Opaque? = null,
    @SageIniName("SkyboxTextureW") val skyboxTextureW: Opaque? = null,
    @SageIniName("SkyboxTextureT") val skyboxTextureT: Opaque? = null,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<SkyboxTextureSet>(
        name = "SkyboxTextureSet",
        tableKey = "skyboxtexturesets",
        properties = {
            property("SkyboxTextureN", Opaque.type) { it.skyboxTextureN }
            property("SkyboxTextureE", Opaque.type) { it.skyboxTextureE }
            property("SkyboxTextureS", Opaque.type) { it.skyboxTextureS }
            property("SkyboxTextureW", Opaque.type) { it.skyboxTextureW }
            property("SkyboxTextureT", Opaque.type) { it.skyboxTextureT }
        },
    )
}
