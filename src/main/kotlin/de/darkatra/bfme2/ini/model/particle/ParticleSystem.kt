package de.darkatra.bfme2.ini.model.particle

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.`object`.FXParticleSystem
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class ParticleSystem(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Name") val name: SageReference<FXParticleSystem>? = null,
    @SageIniName("Count") val count: Int = 0,
    @SageIniName("Offset") val offset: Coords? = null,
    @SageIniName("Height") val height: Double = 0.0,
    @SageIniName("Radius") val radius: Double = 0.0,
    @SageIniName("InitialDelay") val initialDelay: Untyped? = null,
    @SageIniName("OrientToObject") val orientToObject: Boolean = false,
    @SageIniName("OnlyIfOnLand") val onlyIfOnLand: Boolean = false,
    @SageIniName("OnlyIfOnWater") val onlyIfOnWater: Boolean = false,
    @SageIniName("Ricochet") val ricochet: Boolean = false,
    @SageIniName("AttachToObject") val attachToObject: Boolean = false,
    @SageIniName("CreateBoneOverride") val createBoneOverride: Opaque? = null,
    @SageIniName("TargetBoneOverride") val targetBoneOverride: Opaque? = null,
    @SageIniName("UseTargetOffset") val useTargetOffset: Boolean = false,
    @SageIniName("TargetOffset") val targetOffset: Coords? = null,
    @SageIniName("SetTargetMatrix") val setTargetMatrix: Boolean = false,
    @SageIniName("CreateAtGroundHeight") val createAtGroundHeight: Boolean = false,
    @SageIniName("AttachToBone") val attachToBone: Opaque? = null,
    @SageIniName("ObjectFilter") val objectFilter: SageFilter? = null,
    @SageIniName("Weather") val weather: Untyped? = null,
    @SageIniName("TargetCoeff") val targetCoeff: Double = 0.0,
    @SageIniName("SystemLife") val systemLife: Int = 0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<ParticleSystem>(
        name = "ParticleSystem",
        properties = {
            property("Name", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.name }
            property("Count", IntValue) { it.count }
            property("Offset", Coords.type) { it.offset }
            property("Height", FloatValue) { it.height }
            property("Radius", FloatValue) { it.radius }
            property("InitialDelay", Untyped.type) { it.initialDelay }
            property("OrientToObject", BooleanValue) { it.orientToObject }
            property("OnlyIfOnLand", BooleanValue) { it.onlyIfOnLand }
            property("OnlyIfOnWater", BooleanValue) { it.onlyIfOnWater }
            property("Ricochet", BooleanValue) { it.ricochet }
            property("AttachToObject", BooleanValue) { it.attachToObject }
            property("CreateBoneOverride", Opaque.type) { it.createBoneOverride }
            property("TargetBoneOverride", Opaque.type) { it.targetBoneOverride }
            property("UseTargetOffset", BooleanValue) { it.useTargetOffset }
            property("TargetOffset", Coords.type) { it.targetOffset }
            property("SetTargetMatrix", BooleanValue) { it.setTargetMatrix }
            property("CreateAtGroundHeight", BooleanValue) { it.createAtGroundHeight }
            property("AttachToBone", Opaque.type) { it.attachToBone }
            property("ObjectFilter", SageFilter.type) { it.objectFilter }
            property("Weather", Untyped.type) { it.weather }
            property("TargetCoeff", FloatValue) { it.targetCoeff }
            property("SystemLife", IntValue) { it.systemLife }
        },
    )
}
