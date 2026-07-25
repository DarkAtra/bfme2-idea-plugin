package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.`object`.LivingWorldAnimObject
import de.darkatra.bfme2.ini.model.value.SageReference

data class EyeTower(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("PupilAnimObject") val pupilAnimObject: SageReference<LivingWorldAnimObject>? = null,
    @SageIniName("PupilBeamAnimObject") val pupilBeamAnimObject: SageReference<LivingWorldAnimObject>? = null,
    @SageIniName("EyeDecalAnimObject") val eyeDecalAnimObject: SageReference<LivingWorldAnimObject>? = null,
    @SageIniName("EyeDecalBeamAnimObject") val eyeDecalBeamAnimObject: SageReference<LivingWorldAnimObject>? = null,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<EyeTower>(
        name = "EyeTower",
        properties = {
            property("PupilAnimObject", ReferenceValue<LivingWorldAnimObject> { listOf(LivingWorldAnimObject) }) { it.pupilAnimObject }
            property("PupilBeamAnimObject", ReferenceValue<LivingWorldAnimObject> { listOf(LivingWorldAnimObject) }) { it.pupilBeamAnimObject }
            property("EyeDecalAnimObject", ReferenceValue<LivingWorldAnimObject> { listOf(LivingWorldAnimObject) }) { it.eyeDecalAnimObject }
            property("EyeDecalBeamAnimObject", ReferenceValue<LivingWorldAnimObject> { listOf(LivingWorldAnimObject) }) { it.eyeDecalBeamAnimObject }
        },
    )
}
