package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.TextureFile

open class FormationPreviewDecal(
    open val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Texture") open val texture: TextureFile? = null,
    @SageIniName("Width") open val width: Double = 0.0,
    @SageIniName("Height") open val height: Double = 0.0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<FormationPreviewDecal>(
        name = "FormationPreviewDecal",
        properties = {
            property("Texture", TextureFile.type) { it.texture }
            property("Width", FloatValue) { it.width }
            property("Height", FloatValue) { it.height }
        },
    )
}
