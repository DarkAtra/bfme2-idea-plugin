package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.IntValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.value.LocomotorSetType
import de.darkatra.bfme2.ini.model.value.SageReference

data class LocomotorSet(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Locomotor") val locomotor: SageReference<Locomotor>? = null,
    @SageIniName("Condition") val condition: LocomotorSetType? = null,
    @SageIniName("Speed") val speed: Int = 0,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<LocomotorSet>(
        name = "LocomotorSet",
        properties = {
            property("Locomotor", ReferenceValue<Locomotor> { listOf(Locomotor) }) { it.locomotor }
            property("Condition", LocomotorSetType.type) { it.condition }
            property("Speed", IntValue) { it.speed }
        },
    )
}
