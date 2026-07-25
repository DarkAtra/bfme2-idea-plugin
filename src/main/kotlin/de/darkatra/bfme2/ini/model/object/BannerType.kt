package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageReference

data class BannerType(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("FlagObj") val flagObj: Opaque? = null,
    @SageIniName("GlowObj") val glowObj: SageReference<Object>? = null,
    @SageIniName("Icon") val icon: SageReference<MappedImage>? = null,
    @SageIniName("WipeFrame") val wipeFrame: Int = 0,
    @SageIniName("WipeMovie") val wipeMovie: Opaque? = null,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<BannerType>(
        name = "BannerType",
        tableKey = "bannertypes",
        properties = {
            property("FlagObj", Opaque.type) { it.flagObj }
            property("GlowObj", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.glowObj }
            property("Icon", ReferenceValue<MappedImage> { listOf(MappedImage) }) { it.icon }
            property("WipeFrame", IntValue) { it.wipeFrame }
            property("WipeMovie", Opaque.type) { it.wipeMovie }
        },
    )
}
