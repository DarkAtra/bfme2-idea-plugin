package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue

data class ToggleHiddenSpecialAbilityUpdate(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ShowPalantirTimer") val showPalantirTimer: Boolean = false,
) : SpecialAbilityUpdate() {

    companion object : SageIniBlockDescriptor<ToggleHiddenSpecialAbilityUpdate>(
        name = "ToggleHiddenSpecialAbilityUpdate",
        parent = SpecialAbilityUpdate,
        properties = {
            property("ShowPalantirTimer", BooleanValue) { it.showPalantirTimer }
        },
    )
}
