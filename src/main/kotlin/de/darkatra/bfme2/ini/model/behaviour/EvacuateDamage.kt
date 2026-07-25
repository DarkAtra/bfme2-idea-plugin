package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.Weapon
import de.darkatra.bfme2.ini.model.value.DamageType
import de.darkatra.bfme2.ini.model.value.SageReference

data class EvacuateDamage(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("WeaponThatCausesEvacuation") val weaponThatCausesEvacuation: SageReference<Weapon>? = null,
    @SageIniName("DamageTypeToTrack") val damageTypeToTrack: DamageType? = null,
    @SageIniName("DamageToPanicThreshold") val damageToPanicThreshold: Double = 0.0,
    @SageIniName("TrackingTimeSpan") val trackingTimeSpan: Int = 0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<EvacuateDamage>(
        name = "EvacuateDamage",
        properties = {
            property("WeaponThatCausesEvacuation", ReferenceValue<Weapon> { listOf(Weapon) }) { it.weaponThatCausesEvacuation }
            property("DamageTypeToTrack", DamageType.type) { it.damageTypeToTrack }
            property("DamageToPanicThreshold", FloatValue) { it.damageToPanicThreshold }
            property("TrackingTimeSpan", IntValue) { it.trackingTimeSpan }
        },
    )
}
