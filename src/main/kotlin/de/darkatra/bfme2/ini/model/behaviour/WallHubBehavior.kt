package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.value.Options
import de.darkatra.bfme2.ini.model.value.SageReference

data class WallHubBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SegmentTemplateName") val segmentTemplateName: List<SageReference<Object>> = emptyList(),
    @SageIniName("DefaultSegmentTemplateName") val defaultSegmentTemplateName: SageReference<Object>? = null,
    @SageIniName("HubCapTemplateName") val hubCapTemplateName: SageReference<Object>? = null,
    @SageIniName("CliffCapTemplateName") val cliffCapTemplateName: SageReference<Object>? = null,
    @SageIniName("ShoreCapTemplateName") val shoreCapTemplateName: SageReference<Object>? = null,
    @SageIniName("BorderCapTemplateName") val borderCapTemplateName: SageReference<Object>? = null,
    @SageIniName("ElevatedSegmentTemplateName") val elevatedSegmentTemplateName: SageReference<Object>? = null,
    @SageIniName("StaggeredBuildFactor") val staggeredBuildFactor: Int = 0,
    @SageIniName("BuilderRadius") val builderRadius: Double = 0.0,
    @SageIniName("MaxBuildoutDistance") val maxBuildoutDistance: Double = 0.0,
    @SageIniName("Options") val options: List<Options> = emptyList(),
) : SageBehavior {

    companion object : SageIniBlockDescriptor<WallHubBehavior>(
        name = "WallHubBehavior",
        properties = {
            property("SegmentTemplateName", ListValue(ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) })) { it.segmentTemplateName }
            property("DefaultSegmentTemplateName", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.defaultSegmentTemplateName }
            property("HubCapTemplateName", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.hubCapTemplateName }
            property("CliffCapTemplateName", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.cliffCapTemplateName }
            property("ShoreCapTemplateName", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.shoreCapTemplateName }
            property("BorderCapTemplateName", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.borderCapTemplateName }
            property("ElevatedSegmentTemplateName", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.elevatedSegmentTemplateName }
            property("StaggeredBuildFactor", IntValue) { it.staggeredBuildFactor }
            property("BuilderRadius", FloatValue) { it.builderRadius }
            property("MaxBuildoutDistance", FloatValue) { it.maxBuildoutDistance }
            property("Options", ListValue(Options.type)) { it.options }
        },
    )
}
