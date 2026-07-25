package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.ChildObject
import de.darkatra.bfme2.ini.model.`object`.CommandButton
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectReskin
import de.darkatra.bfme2.ini.model.value.SageReference

data class SpawnUnitBehavior(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("UnitName") val unitName: SageReference<Object>? = null,
    @SageIniName("UnitCommand") val unitCommand: SageReference<CommandButton>? = null,
    @SageIniName("SpawnOnce") val spawnOnce: Boolean = false,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<SpawnUnitBehavior>(
        name = "SpawnUnitBehavior",
        properties = {
            property("UnitName", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.unitName }
            property("UnitCommand", ReferenceValue<CommandButton> { listOf(CommandButton) }) { it.unitCommand }
            property("SpawnOnce", BooleanValue) { it.spawnOnce }
        },
    )
}
