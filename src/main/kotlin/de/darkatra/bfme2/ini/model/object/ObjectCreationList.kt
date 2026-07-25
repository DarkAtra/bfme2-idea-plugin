package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.fx.ApplyRandomForce
import de.darkatra.bfme2.ini.model.fx.CreateDebris
import de.darkatra.bfme2.ini.model.fx.FireWeapon

data class ObjectCreationList(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("CreateObject") val createObject: List<CreateObject> = emptyList(),
    @SageIniName("CreateDebris") val createDebris: List<CreateDebris> = emptyList(),
    @SageIniName("FireWeapon") val fireWeapon: List<FireWeapon> = emptyList(),
    @SageIniName("ApplyRandomForce") val applyRandomForce: List<ApplyRandomForce> = emptyList(),
    @SageIniName("Attack") val attack: List<Attack> = emptyList(),
    @SageIniName("DeliverPayload") val deliverPayload: List<DeliverPayload> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<ObjectCreationList>(
        name = "ObjectCreationList",
        tableKey = "objectcreationlists",
        properties = {
            property("CreateObject", ListValue(BlockValue<CreateObject> { listOf(CreateObject) })) { it.createObject }
            property("CreateDebris", ListValue(BlockValue<CreateDebris> { listOf(CreateDebris) })) { it.createDebris }
            property("FireWeapon", ListValue(BlockValue<FireWeapon> { listOf(FireWeapon) })) { it.fireWeapon }
            property("ApplyRandomForce", ListValue(BlockValue<ApplyRandomForce> { listOf(ApplyRandomForce) })) { it.applyRandomForce }
            property("Attack", ListValue(BlockValue<Attack> { listOf(Attack) })) { it.attack }
            property("DeliverPayload", ListValue(BlockValue<DeliverPayload> { listOf(DeliverPayload) })) { it.deliverPayload }
        },
    )
}
