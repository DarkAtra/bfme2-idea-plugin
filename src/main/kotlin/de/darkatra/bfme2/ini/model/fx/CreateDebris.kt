package de.darkatra.bfme2.ini.model.fx

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.value.Coords
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class CreateDebris(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("ModelNames") val modelNames: Untyped? = null,
    @SageIniName("Count") val count: Int = 0,
    @SageIniName("Disposition") val disposition: Untyped? = null,
    @SageIniName("Offset") val offset: Coords? = null,
    @SageIniName("MinForceMagnitude") val minForceMagnitude: Double = 0.0,
    @SageIniName("MaxForceMagnitude") val maxForceMagnitude: Double = 0.0,
    @SageIniName("MinForcePitch") val minForcePitch: Double = 0.0,
    @SageIniName("MaxForcePitch") val maxForcePitch: Double = 0.0,
    @SageIniName("DispositionIntensity") val dispositionIntensity: Double = 0.0,
    @SageIniName("AnimationSet") val animationSet: Untyped? = null,
    @SageIniName("FXFinal") val fxFinal: SageReference<FXList>? = null,
    @SageIniName("OkToChangeModelColor") val okToChangeModelColor: Boolean = false,
    @SageIniName("Shadow") val shadow: Untyped? = null,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<CreateDebris>(
        name = "CreateDebris",
        properties = {
            property("ModelNames", Untyped.type) { it.modelNames }
            property("Count", IntValue) { it.count }
            property("Disposition", Untyped.type) { it.disposition }
            property("Offset", Coords.type) { it.offset }
            property("MinForceMagnitude", FloatValue) { it.minForceMagnitude }
            property("MaxForceMagnitude", FloatValue) { it.maxForceMagnitude }
            property("MinForcePitch", FloatValue) { it.minForcePitch }
            property("MaxForcePitch", FloatValue) { it.maxForcePitch }
            property("DispositionIntensity", FloatValue) { it.dispositionIntensity }
            property("AnimationSet", Untyped.type) { it.animationSet }
            property("FXFinal", ReferenceValue<FXList> { listOf(FXList) }) { it.fxFinal }
            property("OkToChangeModelColor", BooleanValue) { it.okToChangeModelColor }
            property("Shadow", Untyped.type) { it.shadow }
        },
    )
}
