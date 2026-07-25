package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class AutoResolveWeapon(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Weapon") val weapon: Untyped? = null,
    @SageIniName("RequiredUpgrades") val requiredUpgrades: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("ExcludedUpgrades") val excludedUpgrades: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("DamagePerRound") val damagePerRound: Opaque? = null,
    @SageIniName("LevelBonus") val levelBonus: Opaque? = null,
    @SageIniName("MissPercentChance") val missPercentChance: Int = 0,
    @SageIniName("ReduceAttackWhenHurt") val reduceAttackWhenHurt: Boolean = false,
) : SageIniObject, AutoResolveEntry {

    companion object : SageIniBlockDescriptor<AutoResolveWeapon>(
        name = "AutoResolveWeapon",
        properties = {
            property("Weapon", Untyped.type) { it.weapon }
            property("RequiredUpgrades", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.requiredUpgrades }
            property("ExcludedUpgrades", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.excludedUpgrades }
            property("DamagePerRound", Opaque.type) { it.damagePerRound }
            property("LevelBonus", Opaque.type) { it.levelBonus }
            property("MissPercentChance", IntValue) { it.missPercentChance }
            property("ReduceAttackWhenHurt", BooleanValue) { it.reduceAttackWhenHurt }
        },
    )
}
