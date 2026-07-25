package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.Weapon
import de.darkatra.bfme2.ini.model.value.ObjectStatus
import de.darkatra.bfme2.ini.model.value.SageReference

data class FireWeaponCollide(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("CollideWeapon") val collideWeapon: SageReference<Weapon>? = null,
    @SageIniName("FireOnce") val fireOnce: Boolean = false,
    @SageIniName("RequiredStatus") val requiredStatus: ObjectStatus? = null,
    @SageIniName("ForbiddenStatus") val forbiddenStatus: ObjectStatus? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<FireWeaponCollide>(
        name = "FireWeaponCollide",
        properties = {
            property("CollideWeapon", ReferenceValue<Weapon> { listOf(Weapon) }) { it.collideWeapon }
            property("FireOnce", BooleanValue) { it.fireOnce }
            property("RequiredStatus", ObjectStatus.type) { it.requiredStatus }
            property("ForbiddenStatus", ObjectStatus.type) { it.forbiddenStatus }
        },
    )
}
