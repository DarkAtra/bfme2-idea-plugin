package de.darkatra.bfme2.ini.model.value

import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue
import de.darkatra.bfme2.ini.model.`object`.ObjectCreationList

data class DamageCreation(
    val objectCreationList: SageReference<ObjectCreationList>? = null,
    val damageType: FakeToken? = null,
    val modelCondition: FakeToken? = null,
) {

    companion object {

        val type: SageIniValueType<DamageCreation> = StructValue("DamageCreation") {
            component("ObjectCreationList", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.objectCreationList }
            component("DamageType", FakeToken.type) { it.damageType }
            component("ModelCondition", FakeToken.type) { it.modelCondition }
        }
    }
}
