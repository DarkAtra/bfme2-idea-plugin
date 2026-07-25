package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute

data class FormationSelection(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("MaxDragLength") val maxDragLength: Double = 0.0,
    @SageIniName("MaxUnitsSelected") val maxUnitsSelected: Int = 0,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<FormationSelection>(
        name = "FormationSelection",
        properties = {
            property("MaxDragLength", FloatValue) { it.maxDragLength }
            property("MaxUnitsSelected", IntValue) { it.maxUnitsSelected }
        },
    )
}
