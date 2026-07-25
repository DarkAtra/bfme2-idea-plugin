package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.value.ModelFile
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.Rgba
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.TextureFile

data class Bridge(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("BridgeScale") val bridgeScale: Double = 0.0,
    @SageIniName("RadarColor") val radarColor: Rgba? = null,
    @SageIniName("BridgeModelName") val bridgeModelName: ModelFile? = null,
    @SageIniName("Texture") val texture: TextureFile? = null,
    @SageIniName("BridgeModelNameDamaged") val bridgeModelNameDamaged: ModelFile? = null,
    @SageIniName("TextureDamaged") val textureDamaged: TextureFile? = null,
    @SageIniName("BridgeModelNameReallyDamaged") val bridgeModelNameReallyDamaged: ModelFile? = null,
    @SageIniName("TextureReallyDamaged") val textureReallyDamaged: TextureFile? = null,
    @SageIniName("BridgeModelNameBroken") val bridgeModelNameBroken: ModelFile? = null,
    @SageIniName("TextureBroken") val textureBroken: TextureFile? = null,
    @SageIniName("TowerObjectNameFromLeft") val towerObjectNameFromLeft: SageReference<Object>? = null,
    @SageIniName("TowerObjectNameFromRight") val towerObjectNameFromRight: SageReference<Object>? = null,
    @SageIniName("TowerObjectNameToLeft") val towerObjectNameToLeft: SageReference<Object>? = null,
    @SageIniName("TowerObjectNameToRight") val towerObjectNameToRight: SageReference<Object>? = null,
    @SageIniName("ScaffoldObjectName") val scaffoldObjectName: Opaque? = null,
    @SageIniName("ScaffoldSupportObjectName") val scaffoldSupportObjectName: Opaque? = null,
    @SageIniName("DamagedToSound") val damagedToSound: Opaque? = null,
    @SageIniName("NumFXPerType") val numFXPerType: Int = 0,
    @SageIniName("RepairedToSound") val repairedToSound: Opaque? = null,
    @SageIniName("TransitionEffectsHeight") val transitionEffectsHeight: Double = 0.0,
    @SageIniName("TransitionToFX") val transitionToFX: SageReference<FXList>? = null,
    @SageIniName("TransitionToOCL") val transitionToOCL: Opaque? = null,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<Bridge>(
        name = "Bridge",
        tableKey = "bridges",
        properties = {
            property("BridgeScale", FloatValue) { it.bridgeScale }
            property("RadarColor", Rgba.type) { it.radarColor }
            property("BridgeModelName", ModelFile.type) { it.bridgeModelName }
            property("Texture", TextureFile.type) { it.texture }
            property("BridgeModelNameDamaged", ModelFile.type) { it.bridgeModelNameDamaged }
            property("TextureDamaged", TextureFile.type) { it.textureDamaged }
            property("BridgeModelNameReallyDamaged", ModelFile.type) { it.bridgeModelNameReallyDamaged }
            property("TextureReallyDamaged", TextureFile.type) { it.textureReallyDamaged }
            property("BridgeModelNameBroken", ModelFile.type) { it.bridgeModelNameBroken }
            property("TextureBroken", TextureFile.type) { it.textureBroken }
            property("TowerObjectNameFromLeft", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.towerObjectNameFromLeft }
            property("TowerObjectNameFromRight", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.towerObjectNameFromRight }
            property("TowerObjectNameToLeft", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.towerObjectNameToLeft }
            property("TowerObjectNameToRight", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.towerObjectNameToRight }
            property("ScaffoldObjectName", Opaque.type) { it.scaffoldObjectName }
            property("ScaffoldSupportObjectName", Opaque.type) { it.scaffoldSupportObjectName }
            property("DamagedToSound", Opaque.type) { it.damagedToSound }
            property("NumFXPerType", IntValue) { it.numFXPerType }
            property("RepairedToSound", Opaque.type) { it.repairedToSound }
            property("TransitionEffectsHeight", FloatValue) { it.transitionEffectsHeight }
            property("TransitionToFX", ReferenceValue<FXList> { listOf(FXList) }) { it.transitionToFX }
            property("TransitionToOCL", Opaque.type) { it.transitionToOCL }
        },
    )
}
