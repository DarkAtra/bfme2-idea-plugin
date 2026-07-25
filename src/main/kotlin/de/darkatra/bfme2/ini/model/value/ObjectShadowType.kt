package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniEnum
import de.darkatra.bfme2.ini.model.common.SageIniValueType.EnumValue

enum class ObjectShadowType(override val token: String) : SageIniEnum {
    NONE("NONE"),
    SHADOW_VOLUME("SHADOW_VOLUME"),
    SHADOW_DECAL("SHADOW_DECAL"),
    SHADOW_VOLUME_NON_SELF_1("SHADOW_VOLUME_NON_SELF_1"),
    SHADOW_VOLUME_NON_SELF_2("SHADOW_VOLUME_NON_SELF_2"),
    SHADOW_VOLUME_NEW("SHADOW_VOLUME_NEW"),
    SHADOW_ADDITIVE_DECAL("SHADOW_ADDITIVE_DECAL"),
    SHADOW_ADDITIVE_DECAL_DYNAMIC("SHADOW_ADDITIVE_DECAL_DYNAMIC"),
    SHADOW_VOLUME_NON_SELF_3("SHADOW_VOLUME_NON_SELF_3"),
    SHADOW_ALPHA_DECAL_DYNAMIC("SHADOW_ALPHA_DECAL_DYNAMIC"),
    SHADOW_ALPHA_DECAL("SHADOW_ALPHA_DECAL");

    companion object {

        val type: EnumValue<ObjectShadowType> = EnumValue("ObjectShadowType", entries)
    }
}
