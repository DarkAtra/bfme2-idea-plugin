package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.value.ObjectCount
import de.darkatra.bfme2.ini.model.value.TextureFile
import de.darkatra.bfme2.ini.model.value.Untyped

data class Terrain(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Texture") val texture: TextureFile? = null,
    @SageIniName("Class") val `class`: Untyped? = null,
    @SageIniName("BlendEdges") val blendEdges: Boolean = false,
    @SageIniName("RestrictConstruction") val restrictConstruction: Boolean = false,
    @SageIniName("TerrainObject") val terrainObject: List<ObjectCount> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<Terrain>(
        name = "Terrain",
        tableKey = "terrains",
        properties = {
            property("Texture", TextureFile.type) { it.texture }
            property("Class", Untyped.type) { it.`class` }
            property("BlendEdges", BooleanValue) { it.blendEdges }
            property("RestrictConstruction", BooleanValue) { it.restrictConstruction }
            property("TerrainObject", ListValue(ObjectCount.type)) { it.terrainObject }
        },
    )
}
