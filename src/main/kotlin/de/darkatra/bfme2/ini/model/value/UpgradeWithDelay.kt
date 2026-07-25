package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue
import de.darkatra.bfme2.ini.model.`object`.Upgrade

/**
 * Upgrades that are granted together, optionally after a delay in milliseconds (`Upgrade_A Upgrade_B Delay:1000`).
 */
data class UpgradeWithDelay(val upgrades: List<SageReference<Upgrade>> = emptyList(), val delay: Int? = null) {

    companion object {

        val type: SageIniValueType<UpgradeWithDelay> = StructValue("UpgradeWithDelay") {
            component("Upgrades", ListValue(ReferenceValue<Upgrade> { listOf(Upgrade) })) { it.upgrades }
            component("Delay", IntValue) { it.delay }
        }
    }
}
