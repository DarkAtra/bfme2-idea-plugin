package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.`object`.ObjectCreationList
import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StringValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue

/**
 * An `ObjectCreationList` created at a bone of a `BoneFXUpdate`, e.g. `Bone:FIRE01 OnlyOnce:Yes 0 0 OCL:OCL_Debris`.
 */
data class BoneOCL(
    val bone: String = "",
    val onlyOnce: Boolean = false,
    val delayMin: Int = 0,
    val delayMax: Int = 0,
    val ocl: SageReference<ObjectCreationList>? = null,
) {

    companion object {

        val type: SageIniValueType<BoneOCL> = StructValue("BoneOCL") {
            component("Bone", StringValue) { it.bone }
            component("OnlyOnce", BooleanValue) { it.onlyOnce }
            component("DelayMin", IntValue) { it.delayMin }
            component("DelayMax", IntValue) { it.delayMax }
            component("OCL", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.ocl }
        }
    }
}
