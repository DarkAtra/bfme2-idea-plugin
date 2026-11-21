package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.MappedImage
import de.darkatra.bfme2.ini.model.`object`.MusicTrack
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.`object`.Video
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class Mission(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Map") val map: Untyped? = null,
    @SageIniName("IntroMovie") val introMovie: SageReference<Video>? = null,
    @SageIniName("LoadScreenImage") val loadScreenImage: SageReference<MappedImage>? = null,
    @SageIniName("LoadScreenMusicTrack") val loadScreenMusicTrack: SageReference<MusicTrack>? = null,
    @SageIniName("DelayCarryoverSpawningOf") val delayCarryoverSpawningOf: List<SageReference<Object>> = emptyList(),
    @SageIniName("MillisecondsAfterStartToStartFadeUp") val millisecondsAfterStartToStartFadeUp: Int = 0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<Mission>(
        name = "Mission",
        properties = {
            property("Map", Untyped.type) { it.map }
            property("IntroMovie", ReferenceValue<Video> { listOf(Video) }) { it.introMovie }
            property("LoadScreenImage", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.loadScreenImage }
            property("LoadScreenMusicTrack", ReferenceValue<MusicTrack> { listOf(MusicTrack) }) { it.loadScreenMusicTrack }
            property(
                "DelayCarryoverSpawningOf",
                ListValue(ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) })
            ) { it.delayCarryoverSpawningOf }
            property("MillisecondsAfterStartToStartFadeUp", IntValue) { it.millisecondsAfterStartToStartFadeUp }
        },
    )
}
