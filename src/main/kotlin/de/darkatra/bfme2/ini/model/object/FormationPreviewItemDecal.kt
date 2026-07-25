package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.value.TextureFile

data class FormationPreviewItemDecal(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Texture") override val texture: TextureFile? = null,
    @SageIniName("Width") override val width: Double = 0.0,
    @SageIniName("Height") override val height: Double = 0.0,
) : FormationPreviewDecal() {

    companion object : SageIniBlockDescriptor<FormationPreviewItemDecal>(
        name = "FormationPreviewItemDecal",
        parent = FormationPreviewDecal,
    )
}
