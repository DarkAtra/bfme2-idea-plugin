package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.Dispositions
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class CreateObject(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ObjectNames") val objectNames: List<SageReference<Object>> = emptyList(),
    @SageIniName("IgnoreCommandPointLimit") val ignoreCommandPointLimit: Boolean = false,
    @SageIniName("Disposition") val disposition: List<Dispositions> = emptyList(),
    @SageIniName("Count") val count: Int = 0,
    @SageIniName("UseJustBuiltFlag") val useJustBuiltFlag: Boolean = false,
    @SageIniName("JustBuiltDuration") val justBuiltDuration: Int = 0,
    @SageIniName("StartingBusyTime") val startingBusyTime: Int = 0,
    @SageIniName("ClearRemovables") val clearRemovables: Boolean = false,
    @SageIniName("FadeIn") val fadeIn: Boolean = false,
    @SageIniName("FadeTime") val fadeTime: Int = 0,
    @SageIniName("RequiredUpgrades") val requiredUpgrades: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("Offset") val offset: Coords? = null,
    @SageIniName("DispositionAngle") val dispositionAngle: Double = 0.0,
    @SageIniName("SpreadFormation") val spreadFormation: Boolean = false,
    @SageIniName("MinDistanceAFormation") val minDistanceAFormation: Double = 0.0,
    @SageIniName("MinDistanceBFormation") val minDistanceBFormation: Double = 0.0,
    @SageIniName("MaxDistanceFormation") val maxDistanceFormation: Double = 0.0,
    @SageIniName("OrientInSecondaryDirection") val orientInSecondaryDirection: Boolean = false,
    @SageIniName("OrientationOffset") val orientationOffset: Double = 0.0,
    @SageIniName("IssueMoveAfterCreation") val issueMoveAfterCreation: Boolean = false,
    @SageIniName("IgnoreAllObjects") val ignoreAllObjects: Boolean = false,
    @SageIniName("DispositionIntensity") val dispositionIntensity: Double = 0.0,
    @SageIniName("VelocityScale") val velocityScale: Double = 0.0,
    @SageIniName("InvulnerableTime") val invulnerableTime: Int = 0,
    @SageIniName("InheritAttributesFromSource") val inheritAttributesFromSource: Boolean = false,
    @SageIniName("RequiresLivePlayer") val requiresLivePlayer: Boolean = false,
    @SageIniName("InheritScriptingName") val inheritScriptingName: Boolean = false,
    @SageIniName("OrientInPrimaryDirection") val orientInPrimaryDirection: Boolean = false,
    @SageIniName("OffsetInLocalSpace") val offsetInLocalSpace: Boolean = false,
    @SageIniName("PreserveLayer") val preserveLayer: Boolean = false,
    @SageIniName("MoveUsesStrafeUpdate") val moveUsesStrafeUpdate: Boolean = false,
    @SageIniName("ParticleSystem") val particleSystem: Opaque? = null,
    @SageIniName("ForbiddenUpgrades") val forbiddenUpgrades: List<Opaque> = emptyList(),
    @SageIniName("DestinationPlayer") val destinationPlayer: Opaque? = null,
    @SageIniName("WaypointSpawnPoints") val waypointSpawnPoints: Opaque? = null,
    @SageIniName("VeterancyLevel") val veterancyLevel: Untyped? = null,
    @SageIniName("MinLifetime") val minLifetime: Int = 0,
    @SageIniName("MaxLifetime") val maxLifetime: Int = 0,
    @SageIniName("SkipIfSignificantlyAirborne") val skipIfSignificantlyAirborne: Boolean = false,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<CreateObject>(
        name = "CreateObject",
        properties = {
            property("ObjectNames", ListValue(ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) })) { it.objectNames }
            property("IgnoreCommandPointLimit", BooleanValue) { it.ignoreCommandPointLimit }
            property("Disposition", ListValue(Dispositions.type)) { it.disposition }
            property("Count", IntValue) { it.count }
            property("UseJustBuiltFlag", BooleanValue) { it.useJustBuiltFlag }
            property("JustBuiltDuration", IntValue) { it.justBuiltDuration }
            property("StartingBusyTime", IntValue) { it.startingBusyTime }
            property("ClearRemovables", BooleanValue) { it.clearRemovables }
            property("FadeIn", BooleanValue) { it.fadeIn }
            property("FadeTime", IntValue) { it.fadeTime }
            property("RequiredUpgrades", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.requiredUpgrades }
            property("Offset", Coords.type) { it.offset }
            property("DispositionAngle", FloatValue) { it.dispositionAngle }
            property("SpreadFormation", BooleanValue) { it.spreadFormation }
            property("MinDistanceAFormation", FloatValue) { it.minDistanceAFormation }
            property("MinDistanceBFormation", FloatValue) { it.minDistanceBFormation }
            property("MaxDistanceFormation", FloatValue) { it.maxDistanceFormation }
            property("OrientInSecondaryDirection", BooleanValue) { it.orientInSecondaryDirection }
            property("OrientationOffset", FloatValue) { it.orientationOffset }
            property("IssueMoveAfterCreation", BooleanValue) { it.issueMoveAfterCreation }
            property("IgnoreAllObjects", BooleanValue) { it.ignoreAllObjects }
            property("DispositionIntensity", FloatValue) { it.dispositionIntensity }
            property("VelocityScale", FloatValue) { it.velocityScale }
            property("InvulnerableTime", IntValue) { it.invulnerableTime }
            property("InheritAttributesFromSource", BooleanValue) { it.inheritAttributesFromSource }
            property("RequiresLivePlayer", BooleanValue) { it.requiresLivePlayer }
            property("InheritScriptingName", BooleanValue) { it.inheritScriptingName }
            property("OrientInPrimaryDirection", BooleanValue) { it.orientInPrimaryDirection }
            property("OffsetInLocalSpace", BooleanValue) { it.offsetInLocalSpace }
            property("PreserveLayer", BooleanValue) { it.preserveLayer }
            property("MoveUsesStrafeUpdate", BooleanValue) { it.moveUsesStrafeUpdate }
            property("ParticleSystem", Opaque.type) { it.particleSystem }
            property("ForbiddenUpgrades", ListValue(Opaque.type)) { it.forbiddenUpgrades }
            property("DestinationPlayer", Opaque.type) { it.destinationPlayer }
            property("WaypointSpawnPoints", Opaque.type) { it.waypointSpawnPoints }
            property("VeterancyLevel", Untyped.type) { it.veterancyLevel }
            property("MinLifetime", IntValue) { it.minLifetime }
            property("MaxLifetime", IntValue) { it.maxLifetime }
            property("SkipIfSignificantlyAirborne", BooleanValue) { it.skipIfSignificantlyAirborne }
        },
    )
}
