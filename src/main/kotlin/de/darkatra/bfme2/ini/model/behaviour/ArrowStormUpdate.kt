package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.Weapon
import de.darkatra.bfme2.ini.model.value.SageReference

data class ArrowStormUpdate(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("WeaponTemplate") val weaponTemplate: SageReference<Weapon>? = null,
    @SageIniName("TargetRadius") val targetRadius: Double = 0.0,
    @SageIniName("ShotsPerTarget") val shotsPerTarget: Int = 0,
    @SageIniName("ShotsPerBurst") val shotsPerBurst: Int = 0,
    @SageIniName("MaxShots") val maxShots: Int = 0,
    @SageIniName("CanShootEmptyGround") val canShootEmptyGround: Boolean = false,
) : SpecialAbilityUpdate() {

    companion object : SageIniBlockDescriptor<ArrowStormUpdate>(
        name = "ArrowStormUpdate",
        parent = SpecialAbilityUpdate,
        properties = {
            property("WeaponTemplate", ReferenceValue<Weapon> { listOf(Weapon) }) { it.weaponTemplate }
            property("TargetRadius", FloatValue) { it.targetRadius }
            property("ShotsPerTarget", IntValue) { it.shotsPerTarget }
            property("ShotsPerBurst", IntValue) { it.shotsPerBurst }
            property("MaxShots", IntValue) { it.maxShots }
            property("CanShootEmptyGround", BooleanValue) { it.canShootEmptyGround }
        },
    )
}
