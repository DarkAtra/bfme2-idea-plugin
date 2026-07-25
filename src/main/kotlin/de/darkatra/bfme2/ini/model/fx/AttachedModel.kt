package de.darkatra.bfme2.ini.model.fx

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Untyped

data class AttachedModel(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Modelname") val modelname: Untyped? = null,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<AttachedModel>(
        name = "AttachedModel",
        properties = {
            property("Modelname", Untyped.type) { it.modelname }
        },
    )
}
