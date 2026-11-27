package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.value.FXListAtLocation
import de.darkatra.bfme2.ini.model.value.OCLAtLocation
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.ParticleSystemAtBone
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.Untyped

data class TransitionDamageFX(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DamageFXTypes") val damageFXTypes: SageFilter? = null,
    @SageIniName("DamageOCLTypes") val damageOCLTypes: SageFilter? = null,
    @SageIniName("DamageParticleTypes") val damageParticleTypes: SageFilter? = null,
    @SageIniName("DamagedOCL1") val damagedOCL1: OCLAtLocation? = null,
    @SageIniName("DamagedOCL2") val damagedOCL2: OCLAtLocation? = null,
    @SageIniName("DamagedOCL3") val damagedOCL3: OCLAtLocation? = null,
    @SageIniName("DamagedOCL4") val damagedOCL4: OCLAtLocation? = null,
    @SageIniName("DamagedOCL5") val damagedOCL5: OCLAtLocation? = null,
    @SageIniName("DamagedOCL6") val damagedOCL6: OCLAtLocation? = null,
    @SageIniName("DamagedOCL7") val damagedOCL7: OCLAtLocation? = null,
    @SageIniName("DamagedOCL8") val damagedOCL8: OCLAtLocation? = null,
    @SageIniName("DamagedOCL9") val damagedOCL9: OCLAtLocation? = null,
    @SageIniName("DamagedOCL10") val damagedOCL10: OCLAtLocation? = null,
    @SageIniName("DamagedOCL11") val damagedOCL11: OCLAtLocation? = null,
    @SageIniName("DamagedOCL12") val damagedOCL12: OCLAtLocation? = null,
    @SageIniName("ReallyDamagedOCL1") val reallyDamagedOCL1: OCLAtLocation? = null,
    @SageIniName("ReallyDamagedOCL2") val reallyDamagedOCL2: OCLAtLocation? = null,
    @SageIniName("ReallyDamagedOCL3") val reallyDamagedOCL3: OCLAtLocation? = null,
    @SageIniName("ReallyDamagedOCL4") val reallyDamagedOCL4: OCLAtLocation? = null,
    @SageIniName("ReallyDamagedOCL5") val reallyDamagedOCL5: OCLAtLocation? = null,
    @SageIniName("ReallyDamagedOCL6") val reallyDamagedOCL6: OCLAtLocation? = null,
    @SageIniName("ReallyDamagedOCL7") val reallyDamagedOCL7: OCLAtLocation? = null,
    @SageIniName("ReallyDamagedOCL8") val reallyDamagedOCL8: OCLAtLocation? = null,
    @SageIniName("ReallyDamagedOCL9") val reallyDamagedOCL9: OCLAtLocation? = null,
    @SageIniName("ReallyDamagedOCL10") val reallyDamagedOCL10: OCLAtLocation? = null,
    @SageIniName("ReallyDamagedOCL11") val reallyDamagedOCL11: OCLAtLocation? = null,
    @SageIniName("ReallyDamagedOCL12") val reallyDamagedOCL12: OCLAtLocation? = null,
    @SageIniName("RubbleOCL1") val rubbleOCL1: OCLAtLocation? = null,
    @SageIniName("RubbleOCL2") val rubbleOCL2: OCLAtLocation? = null,
    @SageIniName("RubbleOCL3") val rubbleOCL3: OCLAtLocation? = null,
    @SageIniName("RubbleOCL4") val rubbleOCL4: OCLAtLocation? = null,
    @SageIniName("RubbleOCL5") val rubbleOCL5: OCLAtLocation? = null,
    @SageIniName("RubbleOCL6") val rubbleOCL6: OCLAtLocation? = null,
    @SageIniName("RubbleOCL7") val rubbleOCL7: OCLAtLocation? = null,
    @SageIniName("RubbleOCL8") val rubbleOCL8: OCLAtLocation? = null,
    @SageIniName("RubbleOCL9") val rubbleOCL9: OCLAtLocation? = null,
    @SageIniName("RubbleOCL10") val rubbleOCL10: OCLAtLocation? = null,
    @SageIniName("RubbleOCL11") val rubbleOCL11: OCLAtLocation? = null,
    @SageIniName("RubbleOCL12") val rubbleOCL12: OCLAtLocation? = null,
    @SageIniName("PristineShowSubObject") val pristineShowSubObject: List<Opaque> = emptyList(),
    @SageIniName("PristineHideSubObject") val pristineHideSubObject: List<Opaque> = emptyList(),
    @SageIniName("DamagedShowSubObject") val damagedShowSubObject: List<Opaque> = emptyList(),
    @SageIniName("DamagedHideSubObject") val damagedHideSubObject: List<Opaque> = emptyList(),
    @SageIniName("ReallyDamagedShowSubObject") val reallyDamagedShowSubObject: List<Opaque> = emptyList(),
    @SageIniName("ReallyDamagedHideSubObject") val reallyDamagedHideSubObject: List<Opaque> = emptyList(),
    @SageIniName("RubbleShowSubObject") val rubbleShowSubObject: List<Opaque> = emptyList(),
    @SageIniName("RubbleHideSubObject") val rubbleHideSubObject: List<Opaque> = emptyList(),
    @SageIniName("DamagedFXList1") val damagedFXList1: FXListAtLocation? = null,
    @SageIniName("DamagedFXList2") val damagedFXList2: FXListAtLocation? = null,
    @SageIniName("DamagedFXList3") val damagedFXList3: FXListAtLocation? = null,
    @SageIniName("DamagedFXList4") val damagedFXList4: FXListAtLocation? = null,
    @SageIniName("DamagedFXList5") val damagedFXList5: FXListAtLocation? = null,
    @SageIniName("DamagedFXList6") val damagedFXList6: FXListAtLocation? = null,
    @SageIniName("DamagedFXList7") val damagedFXList7: FXListAtLocation? = null,
    @SageIniName("DamagedFXList8") val damagedFXList8: FXListAtLocation? = null,
    @SageIniName("DamagedFXList9") val damagedFXList9: FXListAtLocation? = null,
    @SageIniName("DamagedFXList10") val damagedFXList10: FXListAtLocation? = null,
    @SageIniName("DamagedFXList11") val damagedFXList11: FXListAtLocation? = null,
    @SageIniName("DamagedFXList12") val damagedFXList12: FXListAtLocation? = null,
    @SageIniName("ReallyDamagedFXList1") val reallyDamagedFXList1: FXListAtLocation? = null,
    @SageIniName("ReallyDamagedFXList2") val reallyDamagedFXList2: FXListAtLocation? = null,
    @SageIniName("ReallyDamagedFXList3") val reallyDamagedFXList3: FXListAtLocation? = null,
    @SageIniName("ReallyDamagedFXList4") val reallyDamagedFXList4: FXListAtLocation? = null,
    @SageIniName("ReallyDamagedFXList5") val reallyDamagedFXList5: FXListAtLocation? = null,
    @SageIniName("ReallyDamagedFXList6") val reallyDamagedFXList6: FXListAtLocation? = null,
    @SageIniName("ReallyDamagedFXList7") val reallyDamagedFXList7: FXListAtLocation? = null,
    @SageIniName("ReallyDamagedFXList8") val reallyDamagedFXList8: FXListAtLocation? = null,
    @SageIniName("ReallyDamagedFXList9") val reallyDamagedFXList9: FXListAtLocation? = null,
    @SageIniName("ReallyDamagedFXList10") val reallyDamagedFXList10: FXListAtLocation? = null,
    @SageIniName("ReallyDamagedFXList11") val reallyDamagedFXList11: FXListAtLocation? = null,
    @SageIniName("ReallyDamagedFXList12") val reallyDamagedFXList12: FXListAtLocation? = null,
    @SageIniName("RubbleFXList1") val rubbleFXList1: FXListAtLocation? = null,
    @SageIniName("RubbleFXList2") val rubbleFXList2: FXListAtLocation? = null,
    @SageIniName("RubbleFXList3") val rubbleFXList3: FXListAtLocation? = null,
    @SageIniName("RubbleFXList4") val rubbleFXList4: FXListAtLocation? = null,
    @SageIniName("RubbleFXList5") val rubbleFXList5: FXListAtLocation? = null,
    @SageIniName("RubbleFXList6") val rubbleFXList6: FXListAtLocation? = null,
    @SageIniName("RubbleFXList7") val rubbleFXList7: FXListAtLocation? = null,
    @SageIniName("RubbleFXList8") val rubbleFXList8: FXListAtLocation? = null,
    @SageIniName("RubbleFXList9") val rubbleFXList9: FXListAtLocation? = null,
    @SageIniName("RubbleFXList10") val rubbleFXList10: FXListAtLocation? = null,
    @SageIniName("RubbleFXList11") val rubbleFXList11: FXListAtLocation? = null,
    @SageIniName("RubbleFXList12") val rubbleFXList12: FXListAtLocation? = null,
    @SageIniName("DamagedParticleSystem1") val damagedParticleSystem1: ParticleSystemAtBone? = null,
    @SageIniName("DamagedParticleSystem2") val damagedParticleSystem2: ParticleSystemAtBone? = null,
    @SageIniName("DamagedParticleSystem3") val damagedParticleSystem3: ParticleSystemAtBone? = null,
    @SageIniName("DamagedParticleSystem4") val damagedParticleSystem4: ParticleSystemAtBone? = null,
    @SageIniName("DamagedParticleSystem5") val damagedParticleSystem5: ParticleSystemAtBone? = null,
    @SageIniName("DamagedParticleSystem6") val damagedParticleSystem6: ParticleSystemAtBone? = null,
    @SageIniName("DamagedParticleSystem7") val damagedParticleSystem7: ParticleSystemAtBone? = null,
    @SageIniName("DamagedParticleSystem8") val damagedParticleSystem8: ParticleSystemAtBone? = null,
    @SageIniName("DamagedParticleSystem9") val damagedParticleSystem9: ParticleSystemAtBone? = null,
    @SageIniName("DamagedParticleSystem10") val damagedParticleSystem10: ParticleSystemAtBone? = null,
    @SageIniName("DamagedParticleSystem11") val damagedParticleSystem11: ParticleSystemAtBone? = null,
    @SageIniName("DamagedParticleSystem12") val damagedParticleSystem12: ParticleSystemAtBone? = null,
    @SageIniName("ReallyDamagedParticleSystem1") val reallyDamagedParticleSystem1: ParticleSystemAtBone? = null,
    @SageIniName("ReallyDamagedParticleSystem2") val reallyDamagedParticleSystem2: ParticleSystemAtBone? = null,
    @SageIniName("ReallyDamagedParticleSystem3") val reallyDamagedParticleSystem3: ParticleSystemAtBone? = null,
    @SageIniName("ReallyDamagedParticleSystem4") val reallyDamagedParticleSystem4: ParticleSystemAtBone? = null,
    @SageIniName("ReallyDamagedParticleSystem5") val reallyDamagedParticleSystem5: ParticleSystemAtBone? = null,
    @SageIniName("ReallyDamagedParticleSystem6") val reallyDamagedParticleSystem6: ParticleSystemAtBone? = null,
    @SageIniName("ReallyDamagedParticleSystem7") val reallyDamagedParticleSystem7: ParticleSystemAtBone? = null,
    @SageIniName("ReallyDamagedParticleSystem8") val reallyDamagedParticleSystem8: ParticleSystemAtBone? = null,
    @SageIniName("ReallyDamagedParticleSystem9") val reallyDamagedParticleSystem9: ParticleSystemAtBone? = null,
    @SageIniName("ReallyDamagedParticleSystem10") val reallyDamagedParticleSystem10: ParticleSystemAtBone? = null,
    @SageIniName("ReallyDamagedParticleSystem11") val reallyDamagedParticleSystem11: ParticleSystemAtBone? = null,
    @SageIniName("ReallyDamagedParticleSystem12") val reallyDamagedParticleSystem12: ParticleSystemAtBone? = null,
    @SageIniName("RubbleParticleSystem1") val rubbleParticleSystem1: ParticleSystemAtBone? = null,
    @SageIniName("RubbleParticleSystem2") val rubbleParticleSystem2: ParticleSystemAtBone? = null,
    @SageIniName("RubbleParticleSystem3") val rubbleParticleSystem3: ParticleSystemAtBone? = null,
    @SageIniName("RubbleParticleSystem4") val rubbleParticleSystem4: ParticleSystemAtBone? = null,
    @SageIniName("RubbleParticleSystem5") val rubbleParticleSystem5: ParticleSystemAtBone? = null,
    @SageIniName("RubbleParticleSystem6") val rubbleParticleSystem6: ParticleSystemAtBone? = null,
    @SageIniName("RubbleParticleSystem7") val rubbleParticleSystem7: ParticleSystemAtBone? = null,
    @SageIniName("RubbleParticleSystem8") val rubbleParticleSystem8: ParticleSystemAtBone? = null,
    @SageIniName("RubbleParticleSystem9") val rubbleParticleSystem9: ParticleSystemAtBone? = null,
    @SageIniName("RubbleParticleSystem10") val rubbleParticleSystem10: ParticleSystemAtBone? = null,
    @SageIniName("RubbleParticleSystem11") val rubbleParticleSystem11: ParticleSystemAtBone? = null,
    @SageIniName("RubbleParticleSystem12") val rubbleParticleSystem12: ParticleSystemAtBone? = null,
    @SageIniName("RubbleNeighbor") val rubbleNeighbor: Untyped? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<TransitionDamageFX>(
        name = "TransitionDamageFX",
        properties = {
            property("DamageFXTypes", SageFilter.type) { it.damageFXTypes }
            property("DamageOCLTypes", SageFilter.type) { it.damageOCLTypes }
            property("DamageParticleTypes", SageFilter.type) { it.damageParticleTypes }
            property("DamagedOCL1", OCLAtLocation.type) { it.damagedOCL1 }
            property("DamagedOCL2", OCLAtLocation.type) { it.damagedOCL2 }
            property("DamagedOCL3", OCLAtLocation.type) { it.damagedOCL3 }
            property("DamagedOCL4", OCLAtLocation.type) { it.damagedOCL4 }
            property("DamagedOCL5", OCLAtLocation.type) { it.damagedOCL5 }
            property("DamagedOCL6", OCLAtLocation.type) { it.damagedOCL6 }
            property("DamagedOCL7", OCLAtLocation.type) { it.damagedOCL7 }
            property("DamagedOCL8", OCLAtLocation.type) { it.damagedOCL8 }
            property("DamagedOCL9", OCLAtLocation.type) { it.damagedOCL9 }
            property("DamagedOCL10", OCLAtLocation.type) { it.damagedOCL10 }
            property("DamagedOCL11", OCLAtLocation.type) { it.damagedOCL11 }
            property("DamagedOCL12", OCLAtLocation.type) { it.damagedOCL12 }
            property("ReallyDamagedOCL1", OCLAtLocation.type) { it.reallyDamagedOCL1 }
            property("ReallyDamagedOCL2", OCLAtLocation.type) { it.reallyDamagedOCL2 }
            property("ReallyDamagedOCL3", OCLAtLocation.type) { it.reallyDamagedOCL3 }
            property("ReallyDamagedOCL4", OCLAtLocation.type) { it.reallyDamagedOCL4 }
            property("ReallyDamagedOCL5", OCLAtLocation.type) { it.reallyDamagedOCL5 }
            property("ReallyDamagedOCL6", OCLAtLocation.type) { it.reallyDamagedOCL6 }
            property("ReallyDamagedOCL7", OCLAtLocation.type) { it.reallyDamagedOCL7 }
            property("ReallyDamagedOCL8", OCLAtLocation.type) { it.reallyDamagedOCL8 }
            property("ReallyDamagedOCL9", OCLAtLocation.type) { it.reallyDamagedOCL9 }
            property("ReallyDamagedOCL10", OCLAtLocation.type) { it.reallyDamagedOCL10 }
            property("ReallyDamagedOCL11", OCLAtLocation.type) { it.reallyDamagedOCL11 }
            property("ReallyDamagedOCL12", OCLAtLocation.type) { it.reallyDamagedOCL12 }
            property("RubbleOCL1", OCLAtLocation.type) { it.rubbleOCL1 }
            property("RubbleOCL2", OCLAtLocation.type) { it.rubbleOCL2 }
            property("RubbleOCL3", OCLAtLocation.type) { it.rubbleOCL3 }
            property("RubbleOCL4", OCLAtLocation.type) { it.rubbleOCL4 }
            property("RubbleOCL5", OCLAtLocation.type) { it.rubbleOCL5 }
            property("RubbleOCL6", OCLAtLocation.type) { it.rubbleOCL6 }
            property("RubbleOCL7", OCLAtLocation.type) { it.rubbleOCL7 }
            property("RubbleOCL8", OCLAtLocation.type) { it.rubbleOCL8 }
            property("RubbleOCL9", OCLAtLocation.type) { it.rubbleOCL9 }
            property("RubbleOCL10", OCLAtLocation.type) { it.rubbleOCL10 }
            property("RubbleOCL11", OCLAtLocation.type) { it.rubbleOCL11 }
            property("RubbleOCL12", OCLAtLocation.type) { it.rubbleOCL12 }
            property("PristineShowSubObject", ListValue(Opaque.type)) { it.pristineShowSubObject }
            property("PristineHideSubObject", ListValue(Opaque.type)) { it.pristineHideSubObject }
            property("DamagedShowSubObject", ListValue(Opaque.type)) { it.damagedShowSubObject }
            property("DamagedHideSubObject", ListValue(Opaque.type)) { it.damagedHideSubObject }
            property("ReallyDamagedShowSubObject", ListValue(Opaque.type)) { it.reallyDamagedShowSubObject }
            property("ReallyDamagedHideSubObject", ListValue(Opaque.type)) { it.reallyDamagedHideSubObject }
            property("RubbleShowSubObject", ListValue(Opaque.type)) { it.rubbleShowSubObject }
            property("RubbleHideSubObject", ListValue(Opaque.type)) { it.rubbleHideSubObject }
            property("DamagedFXList1", FXListAtLocation.type) { it.damagedFXList1 }
            property("DamagedFXList2", FXListAtLocation.type) { it.damagedFXList2 }
            property("DamagedFXList3", FXListAtLocation.type) { it.damagedFXList3 }
            property("DamagedFXList4", FXListAtLocation.type) { it.damagedFXList4 }
            property("DamagedFXList5", FXListAtLocation.type) { it.damagedFXList5 }
            property("DamagedFXList6", FXListAtLocation.type) { it.damagedFXList6 }
            property("DamagedFXList7", FXListAtLocation.type) { it.damagedFXList7 }
            property("DamagedFXList8", FXListAtLocation.type) { it.damagedFXList8 }
            property("DamagedFXList9", FXListAtLocation.type) { it.damagedFXList9 }
            property("DamagedFXList10", FXListAtLocation.type) { it.damagedFXList10 }
            property("DamagedFXList11", FXListAtLocation.type) { it.damagedFXList11 }
            property("DamagedFXList12", FXListAtLocation.type) { it.damagedFXList12 }
            property("ReallyDamagedFXList1", FXListAtLocation.type) { it.reallyDamagedFXList1 }
            property("ReallyDamagedFXList2", FXListAtLocation.type) { it.reallyDamagedFXList2 }
            property("ReallyDamagedFXList3", FXListAtLocation.type) { it.reallyDamagedFXList3 }
            property("ReallyDamagedFXList4", FXListAtLocation.type) { it.reallyDamagedFXList4 }
            property("ReallyDamagedFXList5", FXListAtLocation.type) { it.reallyDamagedFXList5 }
            property("ReallyDamagedFXList6", FXListAtLocation.type) { it.reallyDamagedFXList6 }
            property("ReallyDamagedFXList7", FXListAtLocation.type) { it.reallyDamagedFXList7 }
            property("ReallyDamagedFXList8", FXListAtLocation.type) { it.reallyDamagedFXList8 }
            property("ReallyDamagedFXList9", FXListAtLocation.type) { it.reallyDamagedFXList9 }
            property("ReallyDamagedFXList10", FXListAtLocation.type) { it.reallyDamagedFXList10 }
            property("ReallyDamagedFXList11", FXListAtLocation.type) { it.reallyDamagedFXList11 }
            property("ReallyDamagedFXList12", FXListAtLocation.type) { it.reallyDamagedFXList12 }
            property("RubbleFXList1", FXListAtLocation.type) { it.rubbleFXList1 }
            property("RubbleFXList2", FXListAtLocation.type) { it.rubbleFXList2 }
            property("RubbleFXList3", FXListAtLocation.type) { it.rubbleFXList3 }
            property("RubbleFXList4", FXListAtLocation.type) { it.rubbleFXList4 }
            property("RubbleFXList5", FXListAtLocation.type) { it.rubbleFXList5 }
            property("RubbleFXList6", FXListAtLocation.type) { it.rubbleFXList6 }
            property("RubbleFXList7", FXListAtLocation.type) { it.rubbleFXList7 }
            property("RubbleFXList8", FXListAtLocation.type) { it.rubbleFXList8 }
            property("RubbleFXList9", FXListAtLocation.type) { it.rubbleFXList9 }
            property("RubbleFXList10", FXListAtLocation.type) { it.rubbleFXList10 }
            property("RubbleFXList11", FXListAtLocation.type) { it.rubbleFXList11 }
            property("RubbleFXList12", FXListAtLocation.type) { it.rubbleFXList12 }
            property("DamagedParticleSystem1", ParticleSystemAtBone.type) { it.damagedParticleSystem1 }
            property("DamagedParticleSystem2", ParticleSystemAtBone.type) { it.damagedParticleSystem2 }
            property("DamagedParticleSystem3", ParticleSystemAtBone.type) { it.damagedParticleSystem3 }
            property("DamagedParticleSystem4", ParticleSystemAtBone.type) { it.damagedParticleSystem4 }
            property("DamagedParticleSystem5", ParticleSystemAtBone.type) { it.damagedParticleSystem5 }
            property("DamagedParticleSystem6", ParticleSystemAtBone.type) { it.damagedParticleSystem6 }
            property("DamagedParticleSystem7", ParticleSystemAtBone.type) { it.damagedParticleSystem7 }
            property("DamagedParticleSystem8", ParticleSystemAtBone.type) { it.damagedParticleSystem8 }
            property("DamagedParticleSystem9", ParticleSystemAtBone.type) { it.damagedParticleSystem9 }
            property("DamagedParticleSystem10", ParticleSystemAtBone.type) { it.damagedParticleSystem10 }
            property("DamagedParticleSystem11", ParticleSystemAtBone.type) { it.damagedParticleSystem11 }
            property("DamagedParticleSystem12", ParticleSystemAtBone.type) { it.damagedParticleSystem12 }
            property("ReallyDamagedParticleSystem1", ParticleSystemAtBone.type) { it.reallyDamagedParticleSystem1 }
            property("ReallyDamagedParticleSystem2", ParticleSystemAtBone.type) { it.reallyDamagedParticleSystem2 }
            property("ReallyDamagedParticleSystem3", ParticleSystemAtBone.type) { it.reallyDamagedParticleSystem3 }
            property("ReallyDamagedParticleSystem4", ParticleSystemAtBone.type) { it.reallyDamagedParticleSystem4 }
            property("ReallyDamagedParticleSystem5", ParticleSystemAtBone.type) { it.reallyDamagedParticleSystem5 }
            property("ReallyDamagedParticleSystem6", ParticleSystemAtBone.type) { it.reallyDamagedParticleSystem6 }
            property("ReallyDamagedParticleSystem7", ParticleSystemAtBone.type) { it.reallyDamagedParticleSystem7 }
            property("ReallyDamagedParticleSystem8", ParticleSystemAtBone.type) { it.reallyDamagedParticleSystem8 }
            property("ReallyDamagedParticleSystem9", ParticleSystemAtBone.type) { it.reallyDamagedParticleSystem9 }
            property("ReallyDamagedParticleSystem10", ParticleSystemAtBone.type) { it.reallyDamagedParticleSystem10 }
            property("ReallyDamagedParticleSystem11", ParticleSystemAtBone.type) { it.reallyDamagedParticleSystem11 }
            property("ReallyDamagedParticleSystem12", ParticleSystemAtBone.type) { it.reallyDamagedParticleSystem12 }
            property("RubbleParticleSystem1", ParticleSystemAtBone.type) { it.rubbleParticleSystem1 }
            property("RubbleParticleSystem2", ParticleSystemAtBone.type) { it.rubbleParticleSystem2 }
            property("RubbleParticleSystem3", ParticleSystemAtBone.type) { it.rubbleParticleSystem3 }
            property("RubbleParticleSystem4", ParticleSystemAtBone.type) { it.rubbleParticleSystem4 }
            property("RubbleParticleSystem5", ParticleSystemAtBone.type) { it.rubbleParticleSystem5 }
            property("RubbleParticleSystem6", ParticleSystemAtBone.type) { it.rubbleParticleSystem6 }
            property("RubbleParticleSystem7", ParticleSystemAtBone.type) { it.rubbleParticleSystem7 }
            property("RubbleParticleSystem8", ParticleSystemAtBone.type) { it.rubbleParticleSystem8 }
            property("RubbleParticleSystem9", ParticleSystemAtBone.type) { it.rubbleParticleSystem9 }
            property("RubbleParticleSystem10", ParticleSystemAtBone.type) { it.rubbleParticleSystem10 }
            property("RubbleParticleSystem11", ParticleSystemAtBone.type) { it.rubbleParticleSystem11 }
            property("RubbleParticleSystem12", ParticleSystemAtBone.type) { it.rubbleParticleSystem12 }
            property("RubbleNeighbor", Untyped.type) { it.rubbleNeighbor }
        },
    )
}
