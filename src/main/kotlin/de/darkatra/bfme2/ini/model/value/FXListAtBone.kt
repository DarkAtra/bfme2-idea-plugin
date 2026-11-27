package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue

/**
 * An `FXList` that is played at a bone, e.g. `FX:GoodLevelUpFX` of an `ExperienceLevel`.
 */
data class FXListAtBone(
    val fx: SageReference<FXList>? = null,
) {

    companion object {

        val type: SageIniValueType<FXListAtBone> = StructValue("FXListAtBone") {
            component("FX", ReferenceValue<FXList> { listOf(FXList) }) { it.fx }
        }
    }
}
