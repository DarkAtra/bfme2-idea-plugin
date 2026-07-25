package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.FXParticleSystem
import de.darkatra.bfme2.ini.model.`object`.ObjectCreationList
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class TransitionDamageFX(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DamageFXTypes") val damageFXTypes: SageFilter? = null,
    @SageIniName("DamageOCLTypes") val damageOCLTypes: SageFilter? = null,
    @SageIniName("DamageParticleTypes") val damageParticleTypes: SageFilter? = null,
    @SageIniName("DamagedOCL1") val damagedOCL1: SageReference<ObjectCreationList>? = null,
    @SageIniName("DamagedOCL2") val damagedOCL2: SageReference<ObjectCreationList>? = null,
    @SageIniName("DamagedOCL3") val damagedOCL3: SageReference<ObjectCreationList>? = null,
    @SageIniName("DamagedOCL4") val damagedOCL4: SageReference<ObjectCreationList>? = null,
    @SageIniName("DamagedOCL5") val damagedOCL5: SageReference<ObjectCreationList>? = null,
    @SageIniName("DamagedOCL6") val damagedOCL6: SageReference<ObjectCreationList>? = null,
    @SageIniName("DamagedOCL7") val damagedOCL7: SageReference<ObjectCreationList>? = null,
    @SageIniName("DamagedOCL8") val damagedOCL8: SageReference<ObjectCreationList>? = null,
    @SageIniName("DamagedOCL9") val damagedOCL9: SageReference<ObjectCreationList>? = null,
    @SageIniName("DamagedOCL10") val damagedOCL10: SageReference<ObjectCreationList>? = null,
    @SageIniName("DamagedOCL11") val damagedOCL11: SageReference<ObjectCreationList>? = null,
    @SageIniName("DamagedOCL12") val damagedOCL12: SageReference<ObjectCreationList>? = null,
    @SageIniName("ReallyDamagedOCL1") val reallyDamagedOCL1: SageReference<ObjectCreationList>? = null,
    @SageIniName("ReallyDamagedOCL2") val reallyDamagedOCL2: SageReference<ObjectCreationList>? = null,
    @SageIniName("ReallyDamagedOCL3") val reallyDamagedOCL3: SageReference<ObjectCreationList>? = null,
    @SageIniName("ReallyDamagedOCL4") val reallyDamagedOCL4: SageReference<ObjectCreationList>? = null,
    @SageIniName("ReallyDamagedOCL5") val reallyDamagedOCL5: SageReference<ObjectCreationList>? = null,
    @SageIniName("ReallyDamagedOCL6") val reallyDamagedOCL6: SageReference<ObjectCreationList>? = null,
    @SageIniName("ReallyDamagedOCL7") val reallyDamagedOCL7: SageReference<ObjectCreationList>? = null,
    @SageIniName("ReallyDamagedOCL8") val reallyDamagedOCL8: SageReference<ObjectCreationList>? = null,
    @SageIniName("ReallyDamagedOCL9") val reallyDamagedOCL9: SageReference<ObjectCreationList>? = null,
    @SageIniName("ReallyDamagedOCL10") val reallyDamagedOCL10: SageReference<ObjectCreationList>? = null,
    @SageIniName("ReallyDamagedOCL11") val reallyDamagedOCL11: SageReference<ObjectCreationList>? = null,
    @SageIniName("ReallyDamagedOCL12") val reallyDamagedOCL12: SageReference<ObjectCreationList>? = null,
    @SageIniName("RubbleOCL1") val rubbleOCL1: SageReference<ObjectCreationList>? = null,
    @SageIniName("RubbleOCL2") val rubbleOCL2: SageReference<ObjectCreationList>? = null,
    @SageIniName("RubbleOCL3") val rubbleOCL3: SageReference<ObjectCreationList>? = null,
    @SageIniName("RubbleOCL4") val rubbleOCL4: SageReference<ObjectCreationList>? = null,
    @SageIniName("RubbleOCL5") val rubbleOCL5: SageReference<ObjectCreationList>? = null,
    @SageIniName("RubbleOCL6") val rubbleOCL6: SageReference<ObjectCreationList>? = null,
    @SageIniName("RubbleOCL7") val rubbleOCL7: SageReference<ObjectCreationList>? = null,
    @SageIniName("RubbleOCL8") val rubbleOCL8: SageReference<ObjectCreationList>? = null,
    @SageIniName("RubbleOCL9") val rubbleOCL9: SageReference<ObjectCreationList>? = null,
    @SageIniName("RubbleOCL10") val rubbleOCL10: SageReference<ObjectCreationList>? = null,
    @SageIniName("RubbleOCL11") val rubbleOCL11: SageReference<ObjectCreationList>? = null,
    @SageIniName("RubbleOCL12") val rubbleOCL12: SageReference<ObjectCreationList>? = null,
    @SageIniName("PristineShowSubObject") val pristineShowSubObject: List<Opaque> = emptyList(),
    @SageIniName("PristineHideSubObject") val pristineHideSubObject: List<Opaque> = emptyList(),
    @SageIniName("DamagedShowSubObject") val damagedShowSubObject: List<Opaque> = emptyList(),
    @SageIniName("DamagedHideSubObject") val damagedHideSubObject: List<Opaque> = emptyList(),
    @SageIniName("ReallyDamagedShowSubObject") val reallyDamagedShowSubObject: List<Opaque> = emptyList(),
    @SageIniName("ReallyDamagedHideSubObject") val reallyDamagedHideSubObject: List<Opaque> = emptyList(),
    @SageIniName("RubbleShowSubObject") val rubbleShowSubObject: List<Opaque> = emptyList(),
    @SageIniName("RubbleHideSubObject") val rubbleHideSubObject: List<Opaque> = emptyList(),
    @SageIniName("DamagedFXList1") val damagedFXList1: SageReference<FXList>? = null,
    @SageIniName("DamagedFXList2") val damagedFXList2: SageReference<FXList>? = null,
    @SageIniName("DamagedFXList3") val damagedFXList3: SageReference<FXList>? = null,
    @SageIniName("DamagedFXList4") val damagedFXList4: SageReference<FXList>? = null,
    @SageIniName("DamagedFXList5") val damagedFXList5: SageReference<FXList>? = null,
    @SageIniName("DamagedFXList6") val damagedFXList6: SageReference<FXList>? = null,
    @SageIniName("DamagedFXList7") val damagedFXList7: SageReference<FXList>? = null,
    @SageIniName("DamagedFXList8") val damagedFXList8: SageReference<FXList>? = null,
    @SageIniName("DamagedFXList9") val damagedFXList9: SageReference<FXList>? = null,
    @SageIniName("DamagedFXList10") val damagedFXList10: SageReference<FXList>? = null,
    @SageIniName("DamagedFXList11") val damagedFXList11: SageReference<FXList>? = null,
    @SageIniName("DamagedFXList12") val damagedFXList12: SageReference<FXList>? = null,
    @SageIniName("ReallyDamagedFXList1") val reallyDamagedFXList1: SageReference<FXList>? = null,
    @SageIniName("ReallyDamagedFXList2") val reallyDamagedFXList2: SageReference<FXList>? = null,
    @SageIniName("ReallyDamagedFXList3") val reallyDamagedFXList3: SageReference<FXList>? = null,
    @SageIniName("ReallyDamagedFXList4") val reallyDamagedFXList4: SageReference<FXList>? = null,
    @SageIniName("ReallyDamagedFXList5") val reallyDamagedFXList5: SageReference<FXList>? = null,
    @SageIniName("ReallyDamagedFXList6") val reallyDamagedFXList6: SageReference<FXList>? = null,
    @SageIniName("ReallyDamagedFXList7") val reallyDamagedFXList7: SageReference<FXList>? = null,
    @SageIniName("ReallyDamagedFXList8") val reallyDamagedFXList8: SageReference<FXList>? = null,
    @SageIniName("ReallyDamagedFXList9") val reallyDamagedFXList9: SageReference<FXList>? = null,
    @SageIniName("ReallyDamagedFXList10") val reallyDamagedFXList10: SageReference<FXList>? = null,
    @SageIniName("ReallyDamagedFXList11") val reallyDamagedFXList11: SageReference<FXList>? = null,
    @SageIniName("ReallyDamagedFXList12") val reallyDamagedFXList12: SageReference<FXList>? = null,
    @SageIniName("RubbleFXList1") val rubbleFXList1: SageReference<FXList>? = null,
    @SageIniName("RubbleFXList2") val rubbleFXList2: SageReference<FXList>? = null,
    @SageIniName("RubbleFXList3") val rubbleFXList3: SageReference<FXList>? = null,
    @SageIniName("RubbleFXList4") val rubbleFXList4: SageReference<FXList>? = null,
    @SageIniName("RubbleFXList5") val rubbleFXList5: SageReference<FXList>? = null,
    @SageIniName("RubbleFXList6") val rubbleFXList6: SageReference<FXList>? = null,
    @SageIniName("RubbleFXList7") val rubbleFXList7: SageReference<FXList>? = null,
    @SageIniName("RubbleFXList8") val rubbleFXList8: SageReference<FXList>? = null,
    @SageIniName("RubbleFXList9") val rubbleFXList9: SageReference<FXList>? = null,
    @SageIniName("RubbleFXList10") val rubbleFXList10: SageReference<FXList>? = null,
    @SageIniName("RubbleFXList11") val rubbleFXList11: SageReference<FXList>? = null,
    @SageIniName("RubbleFXList12") val rubbleFXList12: SageReference<FXList>? = null,
    @SageIniName("DamagedParticleSystem1") val damagedParticleSystem1: SageReference<FXParticleSystem>? = null,
    @SageIniName("DamagedParticleSystem2") val damagedParticleSystem2: SageReference<FXParticleSystem>? = null,
    @SageIniName("DamagedParticleSystem3") val damagedParticleSystem3: SageReference<FXParticleSystem>? = null,
    @SageIniName("DamagedParticleSystem4") val damagedParticleSystem4: SageReference<FXParticleSystem>? = null,
    @SageIniName("DamagedParticleSystem5") val damagedParticleSystem5: SageReference<FXParticleSystem>? = null,
    @SageIniName("DamagedParticleSystem6") val damagedParticleSystem6: SageReference<FXParticleSystem>? = null,
    @SageIniName("DamagedParticleSystem7") val damagedParticleSystem7: SageReference<FXParticleSystem>? = null,
    @SageIniName("DamagedParticleSystem8") val damagedParticleSystem8: SageReference<FXParticleSystem>? = null,
    @SageIniName("DamagedParticleSystem9") val damagedParticleSystem9: SageReference<FXParticleSystem>? = null,
    @SageIniName("DamagedParticleSystem10") val damagedParticleSystem10: SageReference<FXParticleSystem>? = null,
    @SageIniName("DamagedParticleSystem11") val damagedParticleSystem11: SageReference<FXParticleSystem>? = null,
    @SageIniName("DamagedParticleSystem12") val damagedParticleSystem12: SageReference<FXParticleSystem>? = null,
    @SageIniName("ReallyDamagedParticleSystem1") val reallyDamagedParticleSystem1: SageReference<FXParticleSystem>? = null,
    @SageIniName("ReallyDamagedParticleSystem2") val reallyDamagedParticleSystem2: SageReference<FXParticleSystem>? = null,
    @SageIniName("ReallyDamagedParticleSystem3") val reallyDamagedParticleSystem3: SageReference<FXParticleSystem>? = null,
    @SageIniName("ReallyDamagedParticleSystem4") val reallyDamagedParticleSystem4: SageReference<FXParticleSystem>? = null,
    @SageIniName("ReallyDamagedParticleSystem5") val reallyDamagedParticleSystem5: SageReference<FXParticleSystem>? = null,
    @SageIniName("ReallyDamagedParticleSystem6") val reallyDamagedParticleSystem6: SageReference<FXParticleSystem>? = null,
    @SageIniName("ReallyDamagedParticleSystem7") val reallyDamagedParticleSystem7: SageReference<FXParticleSystem>? = null,
    @SageIniName("ReallyDamagedParticleSystem8") val reallyDamagedParticleSystem8: SageReference<FXParticleSystem>? = null,
    @SageIniName("ReallyDamagedParticleSystem9") val reallyDamagedParticleSystem9: SageReference<FXParticleSystem>? = null,
    @SageIniName("ReallyDamagedParticleSystem10") val reallyDamagedParticleSystem10: SageReference<FXParticleSystem>? = null,
    @SageIniName("ReallyDamagedParticleSystem11") val reallyDamagedParticleSystem11: SageReference<FXParticleSystem>? = null,
    @SageIniName("ReallyDamagedParticleSystem12") val reallyDamagedParticleSystem12: SageReference<FXParticleSystem>? = null,
    @SageIniName("RubbleParticleSystem1") val rubbleParticleSystem1: SageReference<FXParticleSystem>? = null,
    @SageIniName("RubbleParticleSystem2") val rubbleParticleSystem2: SageReference<FXParticleSystem>? = null,
    @SageIniName("RubbleParticleSystem3") val rubbleParticleSystem3: SageReference<FXParticleSystem>? = null,
    @SageIniName("RubbleParticleSystem4") val rubbleParticleSystem4: SageReference<FXParticleSystem>? = null,
    @SageIniName("RubbleParticleSystem5") val rubbleParticleSystem5: SageReference<FXParticleSystem>? = null,
    @SageIniName("RubbleParticleSystem6") val rubbleParticleSystem6: SageReference<FXParticleSystem>? = null,
    @SageIniName("RubbleParticleSystem7") val rubbleParticleSystem7: SageReference<FXParticleSystem>? = null,
    @SageIniName("RubbleParticleSystem8") val rubbleParticleSystem8: SageReference<FXParticleSystem>? = null,
    @SageIniName("RubbleParticleSystem9") val rubbleParticleSystem9: SageReference<FXParticleSystem>? = null,
    @SageIniName("RubbleParticleSystem10") val rubbleParticleSystem10: SageReference<FXParticleSystem>? = null,
    @SageIniName("RubbleParticleSystem11") val rubbleParticleSystem11: SageReference<FXParticleSystem>? = null,
    @SageIniName("RubbleParticleSystem12") val rubbleParticleSystem12: SageReference<FXParticleSystem>? = null,
    @SageIniName("RubbleNeighbor") val rubbleNeighbor: Untyped? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<TransitionDamageFX>(
        name = "TransitionDamageFX",
        properties = {
            property("DamageFXTypes", SageFilter.type) { it.damageFXTypes }
            property("DamageOCLTypes", SageFilter.type) { it.damageOCLTypes }
            property("DamageParticleTypes", SageFilter.type) { it.damageParticleTypes }
            property("DamagedOCL1", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.damagedOCL1 }
            property("DamagedOCL2", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.damagedOCL2 }
            property("DamagedOCL3", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.damagedOCL3 }
            property("DamagedOCL4", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.damagedOCL4 }
            property("DamagedOCL5", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.damagedOCL5 }
            property("DamagedOCL6", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.damagedOCL6 }
            property("DamagedOCL7", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.damagedOCL7 }
            property("DamagedOCL8", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.damagedOCL8 }
            property("DamagedOCL9", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.damagedOCL9 }
            property("DamagedOCL10", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.damagedOCL10 }
            property("DamagedOCL11", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.damagedOCL11 }
            property("DamagedOCL12", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.damagedOCL12 }
            property("ReallyDamagedOCL1", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.reallyDamagedOCL1 }
            property("ReallyDamagedOCL2", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.reallyDamagedOCL2 }
            property("ReallyDamagedOCL3", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.reallyDamagedOCL3 }
            property("ReallyDamagedOCL4", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.reallyDamagedOCL4 }
            property("ReallyDamagedOCL5", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.reallyDamagedOCL5 }
            property("ReallyDamagedOCL6", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.reallyDamagedOCL6 }
            property("ReallyDamagedOCL7", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.reallyDamagedOCL7 }
            property("ReallyDamagedOCL8", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.reallyDamagedOCL8 }
            property("ReallyDamagedOCL9", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.reallyDamagedOCL9 }
            property("ReallyDamagedOCL10", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.reallyDamagedOCL10 }
            property("ReallyDamagedOCL11", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.reallyDamagedOCL11 }
            property("ReallyDamagedOCL12", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.reallyDamagedOCL12 }
            property("RubbleOCL1", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.rubbleOCL1 }
            property("RubbleOCL2", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.rubbleOCL2 }
            property("RubbleOCL3", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.rubbleOCL3 }
            property("RubbleOCL4", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.rubbleOCL4 }
            property("RubbleOCL5", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.rubbleOCL5 }
            property("RubbleOCL6", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.rubbleOCL6 }
            property("RubbleOCL7", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.rubbleOCL7 }
            property("RubbleOCL8", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.rubbleOCL8 }
            property("RubbleOCL9", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.rubbleOCL9 }
            property("RubbleOCL10", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.rubbleOCL10 }
            property("RubbleOCL11", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.rubbleOCL11 }
            property("RubbleOCL12", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.rubbleOCL12 }
            property("PristineShowSubObject", ListValue(Opaque.type)) { it.pristineShowSubObject }
            property("PristineHideSubObject", ListValue(Opaque.type)) { it.pristineHideSubObject }
            property("DamagedShowSubObject", ListValue(Opaque.type)) { it.damagedShowSubObject }
            property("DamagedHideSubObject", ListValue(Opaque.type)) { it.damagedHideSubObject }
            property("ReallyDamagedShowSubObject", ListValue(Opaque.type)) { it.reallyDamagedShowSubObject }
            property("ReallyDamagedHideSubObject", ListValue(Opaque.type)) { it.reallyDamagedHideSubObject }
            property("RubbleShowSubObject", ListValue(Opaque.type)) { it.rubbleShowSubObject }
            property("RubbleHideSubObject", ListValue(Opaque.type)) { it.rubbleHideSubObject }
            property("DamagedFXList1", ReferenceValue<FXList> { listOf(FXList) }) { it.damagedFXList1 }
            property("DamagedFXList2", ReferenceValue<FXList> { listOf(FXList) }) { it.damagedFXList2 }
            property("DamagedFXList3", ReferenceValue<FXList> { listOf(FXList) }) { it.damagedFXList3 }
            property("DamagedFXList4", ReferenceValue<FXList> { listOf(FXList) }) { it.damagedFXList4 }
            property("DamagedFXList5", ReferenceValue<FXList> { listOf(FXList) }) { it.damagedFXList5 }
            property("DamagedFXList6", ReferenceValue<FXList> { listOf(FXList) }) { it.damagedFXList6 }
            property("DamagedFXList7", ReferenceValue<FXList> { listOf(FXList) }) { it.damagedFXList7 }
            property("DamagedFXList8", ReferenceValue<FXList> { listOf(FXList) }) { it.damagedFXList8 }
            property("DamagedFXList9", ReferenceValue<FXList> { listOf(FXList) }) { it.damagedFXList9 }
            property("DamagedFXList10", ReferenceValue<FXList> { listOf(FXList) }) { it.damagedFXList10 }
            property("DamagedFXList11", ReferenceValue<FXList> { listOf(FXList) }) { it.damagedFXList11 }
            property("DamagedFXList12", ReferenceValue<FXList> { listOf(FXList) }) { it.damagedFXList12 }
            property("ReallyDamagedFXList1", ReferenceValue<FXList> { listOf(FXList) }) { it.reallyDamagedFXList1 }
            property("ReallyDamagedFXList2", ReferenceValue<FXList> { listOf(FXList) }) { it.reallyDamagedFXList2 }
            property("ReallyDamagedFXList3", ReferenceValue<FXList> { listOf(FXList) }) { it.reallyDamagedFXList3 }
            property("ReallyDamagedFXList4", ReferenceValue<FXList> { listOf(FXList) }) { it.reallyDamagedFXList4 }
            property("ReallyDamagedFXList5", ReferenceValue<FXList> { listOf(FXList) }) { it.reallyDamagedFXList5 }
            property("ReallyDamagedFXList6", ReferenceValue<FXList> { listOf(FXList) }) { it.reallyDamagedFXList6 }
            property("ReallyDamagedFXList7", ReferenceValue<FXList> { listOf(FXList) }) { it.reallyDamagedFXList7 }
            property("ReallyDamagedFXList8", ReferenceValue<FXList> { listOf(FXList) }) { it.reallyDamagedFXList8 }
            property("ReallyDamagedFXList9", ReferenceValue<FXList> { listOf(FXList) }) { it.reallyDamagedFXList9 }
            property("ReallyDamagedFXList10", ReferenceValue<FXList> { listOf(FXList) }) { it.reallyDamagedFXList10 }
            property("ReallyDamagedFXList11", ReferenceValue<FXList> { listOf(FXList) }) { it.reallyDamagedFXList11 }
            property("ReallyDamagedFXList12", ReferenceValue<FXList> { listOf(FXList) }) { it.reallyDamagedFXList12 }
            property("RubbleFXList1", ReferenceValue<FXList> { listOf(FXList) }) { it.rubbleFXList1 }
            property("RubbleFXList2", ReferenceValue<FXList> { listOf(FXList) }) { it.rubbleFXList2 }
            property("RubbleFXList3", ReferenceValue<FXList> { listOf(FXList) }) { it.rubbleFXList3 }
            property("RubbleFXList4", ReferenceValue<FXList> { listOf(FXList) }) { it.rubbleFXList4 }
            property("RubbleFXList5", ReferenceValue<FXList> { listOf(FXList) }) { it.rubbleFXList5 }
            property("RubbleFXList6", ReferenceValue<FXList> { listOf(FXList) }) { it.rubbleFXList6 }
            property("RubbleFXList7", ReferenceValue<FXList> { listOf(FXList) }) { it.rubbleFXList7 }
            property("RubbleFXList8", ReferenceValue<FXList> { listOf(FXList) }) { it.rubbleFXList8 }
            property("RubbleFXList9", ReferenceValue<FXList> { listOf(FXList) }) { it.rubbleFXList9 }
            property("RubbleFXList10", ReferenceValue<FXList> { listOf(FXList) }) { it.rubbleFXList10 }
            property("RubbleFXList11", ReferenceValue<FXList> { listOf(FXList) }) { it.rubbleFXList11 }
            property("RubbleFXList12", ReferenceValue<FXList> { listOf(FXList) }) { it.rubbleFXList12 }
            property("DamagedParticleSystem1", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.damagedParticleSystem1 }
            property("DamagedParticleSystem2", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.damagedParticleSystem2 }
            property("DamagedParticleSystem3", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.damagedParticleSystem3 }
            property("DamagedParticleSystem4", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.damagedParticleSystem4 }
            property("DamagedParticleSystem5", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.damagedParticleSystem5 }
            property("DamagedParticleSystem6", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.damagedParticleSystem6 }
            property("DamagedParticleSystem7", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.damagedParticleSystem7 }
            property("DamagedParticleSystem8", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.damagedParticleSystem8 }
            property("DamagedParticleSystem9", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.damagedParticleSystem9 }
            property("DamagedParticleSystem10", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.damagedParticleSystem10 }
            property("DamagedParticleSystem11", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.damagedParticleSystem11 }
            property("DamagedParticleSystem12", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.damagedParticleSystem12 }
            property("ReallyDamagedParticleSystem1", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.reallyDamagedParticleSystem1 }
            property("ReallyDamagedParticleSystem2", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.reallyDamagedParticleSystem2 }
            property("ReallyDamagedParticleSystem3", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.reallyDamagedParticleSystem3 }
            property("ReallyDamagedParticleSystem4", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.reallyDamagedParticleSystem4 }
            property("ReallyDamagedParticleSystem5", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.reallyDamagedParticleSystem5 }
            property("ReallyDamagedParticleSystem6", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.reallyDamagedParticleSystem6 }
            property("ReallyDamagedParticleSystem7", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.reallyDamagedParticleSystem7 }
            property("ReallyDamagedParticleSystem8", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.reallyDamagedParticleSystem8 }
            property("ReallyDamagedParticleSystem9", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.reallyDamagedParticleSystem9 }
            property("ReallyDamagedParticleSystem10", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.reallyDamagedParticleSystem10 }
            property("ReallyDamagedParticleSystem11", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.reallyDamagedParticleSystem11 }
            property("ReallyDamagedParticleSystem12", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.reallyDamagedParticleSystem12 }
            property("RubbleParticleSystem1", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.rubbleParticleSystem1 }
            property("RubbleParticleSystem2", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.rubbleParticleSystem2 }
            property("RubbleParticleSystem3", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.rubbleParticleSystem3 }
            property("RubbleParticleSystem4", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.rubbleParticleSystem4 }
            property("RubbleParticleSystem5", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.rubbleParticleSystem5 }
            property("RubbleParticleSystem6", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.rubbleParticleSystem6 }
            property("RubbleParticleSystem7", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.rubbleParticleSystem7 }
            property("RubbleParticleSystem8", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.rubbleParticleSystem8 }
            property("RubbleParticleSystem9", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.rubbleParticleSystem9 }
            property("RubbleParticleSystem10", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.rubbleParticleSystem10 }
            property("RubbleParticleSystem11", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.rubbleParticleSystem11 }
            property("RubbleParticleSystem12", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.rubbleParticleSystem12 }
            property("RubbleNeighbor", Untyped.type) { it.rubbleNeighbor }
        },
    )
}
