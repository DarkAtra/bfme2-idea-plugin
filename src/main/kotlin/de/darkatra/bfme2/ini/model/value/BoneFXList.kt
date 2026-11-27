package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue

/**
 * An `FXList` played at a bone of a `BoneFXUpdate`, e.g. `Bone:FIRE01 OnlyOnce:Yes 0 0 FXList:FX_Fire`.
 */
data class BoneFXList(
    val bone: String = "",
    val onlyOnce: Boolean = false,
    val delayMin: Int = 0,
    val delayMax: Int = 0,
    val fxList: SageReference<FXList>? = null,
) {

    companion object {

        val type: SageIniValueType<BoneFXList> = StructValue("BoneFXList") {
            component("Bone", StringValue) { it.bone }
            component("OnlyOnce", BooleanValue) { it.onlyOnce }
            component("DelayMin", IntValue) { it.delayMin }
            component("DelayMax", IntValue) { it.delayMax }
            component("FXList", ReferenceValue<FXList> { listOf(FXList) }) { it.fxList }
        }
    }
}
