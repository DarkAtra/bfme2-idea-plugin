package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Untyped

data class Attack(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("AnimationName") val animationName: Untyped? = null,
    @SageIniName("AnimationMode") val animationMode: Untyped? = null,
    @SageIniName("AnimationBlendTime") val animationBlendTime: Int = 0,
    @SageIniName("UseWeaponTiming") val useWeaponTiming: Boolean = false,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<Attack>(
        name = "Attack",
        properties = {
            property("AnimationName", Untyped.type) { it.animationName }
            property("AnimationMode", Untyped.type) { it.animationMode }
            property("AnimationBlendTime", IntValue) { it.animationBlendTime }
            property("UseWeaponTiming", BooleanValue) { it.useWeaponTiming }
        },
    )
}
