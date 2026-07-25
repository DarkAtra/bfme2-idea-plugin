package de.darkatra.bfme2.ini.model.nugget

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class LuaEventNugget(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialObjectFilter") override val specialObjectFilter: SageFilter? = null,
    @SageIniName("ForbiddenUpgradeNames") override val forbiddenUpgradeNames: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("RequiredUpgradeNames") override val requiredUpgradeNames: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("LuaEvent") val luaEvent: List<Untyped> = emptyList(),
    @SageIniName("Radius") val radius: Double = 0.0,
    @SageIniName("SendToEnemies") val sendToEnemies: Boolean = false,
    @SageIniName("SendToAllies") val sendToAllies: Boolean = false,
    @SageIniName("SendToNeutral") val sendToNeutral: Boolean = false,
) : WeaponEffectNugget() {

    companion object : SageIniBlockDescriptor<LuaEventNugget>(
        name = "LuaEventNugget",
        parent = WeaponEffectNugget,
        properties = {
            property("LuaEvent", ListValue(Untyped.type)) { it.luaEvent }
            property("Radius", FloatValue) { it.radius }
            property("SendToEnemies", BooleanValue) { it.sendToEnemies }
            property("SendToAllies", BooleanValue) { it.sendToAllies }
            property("SendToNeutral", BooleanValue) { it.sendToNeutral }
        },
    )
}
