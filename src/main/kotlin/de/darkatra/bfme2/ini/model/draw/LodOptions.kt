package de.darkatra.bfme2.ini.model.draw

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute

data class LodOptions(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("AllowMultipleModels") val allowMultipleModels: Boolean = false,
    @SageIniName("MaxRandomTextures") val maxRandomTextures: Int = 0,
    @SageIniName("MaxRandomAnimations") val maxRandomAnimations: Int = 0,
    @SageIniName("MaxAnimFrameDelta") val maxAnimFrameDelta: Int = 0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<LodOptions>(
        name = "LodOptions",
        keyedByLabel = true,
        properties = {
            property("AllowMultipleModels", BooleanValue) { it.allowMultipleModels }
            property("MaxRandomTextures", IntValue) { it.maxRandomTextures }
            property("MaxRandomAnimations", IntValue) { it.maxRandomAnimations }
            property("MaxAnimFrameDelta", IntValue) { it.maxAnimFrameDelta }
        },
    )
}
