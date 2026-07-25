package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute

data class ViewInfo(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("FarPitch") val farPitch: Double = 0.0,
    @SageIniName("FarZoom") val farZoom: Double = 0.0,
    @SageIniName("FarFloor") val farFloor: Double = 0.0,
    @SageIniName("FarDist") val farDist: Double = 0.0,
    @SageIniName("FarShift") val farShift: Double = 0.0,
    @SageIniName("NearPitch") val nearPitch: Double = 0.0,
    @SageIniName("NearZoom") val nearZoom: Double = 0.0,
    @SageIniName("NearFloor") val nearFloor: Double = 0.0,
    @SageIniName("NearDist") val nearDist: Double = 0.0,
    @SageIniName("NearShift") val nearShift: Double = 0.0,
    @SageIniName("CloseUpPitch") val closeUpPitch: Double = 0.0,
    @SageIniName("CloseUpZoom") val closeUpZoom: Double = 0.0,
    @SageIniName("CloseUpFloor") val closeUpFloor: Double = 0.0,
    @SageIniName("CloseUpDist") val closeUpDist: Double = 0.0,
    @SageIniName("CloseUpShift") val closeUpShift: Double = 0.0,
    @SageIniName("PortraitPitch") val portraitPitch: Double = 0.0,
    @SageIniName("PortraitZoom") val portraitZoom: Double = 0.0,
    @SageIniName("PortraitFloor") val portraitFloor: Double = 0.0,
    @SageIniName("PortraitDist") val portraitDist: Double = 0.0,
    @SageIniName("PortraitShift") val portraitShift: Double = 0.0,
    @SageIniName("CameraAngle") val cameraAngle: Double = 0.0,
    @SageIniName("MapLocation") val mapLocation: Int = 0,
    @SageIniName("NormalCam") val normalCam: Double = 0.0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<ViewInfo>(
        name = "ViewInfo",
        properties = {
            property("FarPitch", FloatValue) { it.farPitch }
            property("FarZoom", FloatValue) { it.farZoom }
            property("FarFloor", FloatValue) { it.farFloor }
            property("FarDist", FloatValue) { it.farDist }
            property("FarShift", FloatValue) { it.farShift }
            property("NearPitch", FloatValue) { it.nearPitch }
            property("NearZoom", FloatValue) { it.nearZoom }
            property("NearFloor", FloatValue) { it.nearFloor }
            property("NearDist", FloatValue) { it.nearDist }
            property("NearShift", FloatValue) { it.nearShift }
            property("CloseUpPitch", FloatValue) { it.closeUpPitch }
            property("CloseUpZoom", FloatValue) { it.closeUpZoom }
            property("CloseUpFloor", FloatValue) { it.closeUpFloor }
            property("CloseUpDist", FloatValue) { it.closeUpDist }
            property("CloseUpShift", FloatValue) { it.closeUpShift }
            property("PortraitPitch", FloatValue) { it.portraitPitch }
            property("PortraitZoom", FloatValue) { it.portraitZoom }
            property("PortraitFloor", FloatValue) { it.portraitFloor }
            property("PortraitDist", FloatValue) { it.portraitDist }
            property("PortraitShift", FloatValue) { it.portraitShift }
            property("CameraAngle", FloatValue) { it.cameraAngle }
            property("MapLocation", IntValue) { it.mapLocation }
            property("NormalCam", FloatValue) { it.normalCam }
        },
    )
}
