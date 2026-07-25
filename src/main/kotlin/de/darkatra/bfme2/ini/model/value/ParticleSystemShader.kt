package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class ParticleSystemShader(override val token: String) : SageIniEnum {
    NONE("NONE"),
    ADDITIVE("ADDITIVE"),
    ALPHA("ALPHA"),
    ALPHA_TEST("ALPHA_TEST"),
    MULTIPLY("MULTIPLY"),
    W3D_EMISSIVE("W3D_EMISSIVE"),
    W3D_ALPHA("W3D_ALPHA"),
    W3D_DIFFUSE("W3D_DIFFUSE");

    companion object {

        val type: EnumValue<ParticleSystemShader> = EnumValue("ParticleSystemShader", entries)
    }
}
