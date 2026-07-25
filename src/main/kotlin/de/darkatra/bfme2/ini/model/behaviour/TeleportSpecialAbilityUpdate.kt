package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.SpecialPower
import de.darkatra.bfme2.ini.model.`object`.Weapon
import de.darkatra.bfme2.ini.model.value.SageReference

data class TeleportSpecialAbilityUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("SpecialPowerTemplate") val specialPowerTemplate: SageReference<SpecialPower>? = null,
    @SageIniName("UnpackingVariation") val unpackingVariation: Int = 0,
    @SageIniName("UnpackTime") val unpackTime: Int = 0,
    @SageIniName("PackTime") val packTime: Int = 0,
    @SageIniName("ApproachRequiresLOS") val approachRequiresLOS: Boolean = false,
    @SageIniName("BusyForDuration") val busyForDuration: Int = 0,
    @SageIniName("DestinationWeaponName") val destinationWeaponName: SageReference<Weapon>? = null,
    @SageIniName("PreparationTime") val preparationTime: Int = 0,
    @SageIniName("SourceWeaponName") val sourceWeaponName: SageReference<Weapon>? = null,
    @SageIniName("MaxDistance") val maxDistance: Double = 0.0,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<TeleportSpecialAbilityUpdate>(
        name = "TeleportSpecialAbilityUpdate",
        properties = {
            property("SpecialPowerTemplate", ReferenceValue<SpecialPower> { listOf(SpecialPower) }) { it.specialPowerTemplate }
            property("UnpackingVariation", IntValue) { it.unpackingVariation }
            property("UnpackTime", IntValue) { it.unpackTime }
            property("PackTime", IntValue) { it.packTime }
            property("ApproachRequiresLOS", BooleanValue) { it.approachRequiresLOS }
            property("BusyForDuration", IntValue) { it.busyForDuration }
            property("DestinationWeaponName", ReferenceValue<Weapon> { listOf(Weapon) }) { it.destinationWeaponName }
            property("PreparationTime", IntValue) { it.preparationTime }
            property("SourceWeaponName", ReferenceValue<Weapon> { listOf(Weapon) }) { it.sourceWeaponName }
            property("MaxDistance", FloatValue) { it.maxDistance }
        },
    )
}
