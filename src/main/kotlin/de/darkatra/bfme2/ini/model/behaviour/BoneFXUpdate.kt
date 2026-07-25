package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.FXParticleSystem
import de.darkatra.bfme2.ini.model.`object`.ObjectCreationList
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class BoneFXUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DamageFXTypes") val damageFXTypes: SageFilter? = null,
    @SageIniName("RubbleFXList1") val rubbleFXList1: SageReference<FXList>? = null,
    @SageIniName("DamageParticleTypes") val damageParticleTypes: SageFilter? = null,
    @SageIniName("PristineParticleSystem1") val pristineParticleSystem1: SageReference<FXParticleSystem>? = null,
    @SageIniName("RubbleParticleSystem1") val rubbleParticleSystem1: SageReference<FXParticleSystem>? = null,
    @SageIniName("PristineParticleSystem2") val pristineParticleSystem2: SageReference<FXParticleSystem>? = null,
    @SageIniName("PristineParticleSystem3") val pristineParticleSystem3: SageReference<FXParticleSystem>? = null,
    @SageIniName("PristineParticleSystem4") val pristineParticleSystem4: SageReference<FXParticleSystem>? = null,
    @SageIniName("PristineParticleSystem5") val pristineParticleSystem5: SageReference<FXParticleSystem>? = null,
    @SageIniName("PristineParticleSystem6") val pristineParticleSystem6: SageReference<FXParticleSystem>? = null,
    @SageIniName("DamageOCLTypes") val damageOCLTypes: SageFilter? = null,
    @SageIniName("PristineOCL1") val pristineOCL1: SageReference<ObjectCreationList>? = null,
    @SageIniName("PristineOCL2") val pristineOCL2: SageReference<ObjectCreationList>? = null,
    @SageIniName("PristineOCL3") val pristineOCL3: SageReference<ObjectCreationList>? = null,
    @SageIniName("PristineOCL4") val pristineOCL4: SageReference<ObjectCreationList>? = null,
    @SageIniName("PristineOCL5") val pristineOCL5: SageReference<ObjectCreationList>? = null,
    @SageIniName("PristineOCL6") val pristineOCL6: SageReference<ObjectCreationList>? = null,
    @SageIniName("PristineOCL7") val pristineOCL7: SageReference<ObjectCreationList>? = null,
    @SageIniName("PristineOCL8") val pristineOCL8: SageReference<ObjectCreationList>? = null,
    @SageIniName("DamagedOCL1") val damagedOCL1: SageReference<ObjectCreationList>? = null,
    @SageIniName("DamagedOCL2") val damagedOCL2: SageReference<ObjectCreationList>? = null,
    @SageIniName("DamagedOCL3") val damagedOCL3: SageReference<ObjectCreationList>? = null,
    @SageIniName("DamagedOCL4") val damagedOCL4: SageReference<ObjectCreationList>? = null,
    @SageIniName("DamagedOCL5") val damagedOCL5: SageReference<ObjectCreationList>? = null,
    @SageIniName("DamagedOCL6") val damagedOCL6: SageReference<ObjectCreationList>? = null,
    @SageIniName("DamagedOCL7") val damagedOCL7: SageReference<ObjectCreationList>? = null,
    @SageIniName("DamagedOCL8") val damagedOCL8: SageReference<ObjectCreationList>? = null,
    @SageIniName("ReallyDamagedOCL1") val reallyDamagedOCL1: SageReference<ObjectCreationList>? = null,
    @SageIniName("ReallyDamagedOCL2") val reallyDamagedOCL2: SageReference<ObjectCreationList>? = null,
    @SageIniName("ReallyDamagedOCL3") val reallyDamagedOCL3: SageReference<ObjectCreationList>? = null,
    @SageIniName("ReallyDamagedOCL4") val reallyDamagedOCL4: SageReference<ObjectCreationList>? = null,
    @SageIniName("ReallyDamagedOCL5") val reallyDamagedOCL5: SageReference<ObjectCreationList>? = null,
    @SageIniName("ReallyDamagedOCL6") val reallyDamagedOCL6: SageReference<ObjectCreationList>? = null,
    @SageIniName("ReallyDamagedOCL7") val reallyDamagedOCL7: SageReference<ObjectCreationList>? = null,
    @SageIniName("ReallyDamagedOCL8") val reallyDamagedOCL8: SageReference<ObjectCreationList>? = null,
    @SageIniName("RubbleOCL1") val rubbleOCL1: SageReference<ObjectCreationList>? = null,
    @SageIniName("RubbleOCL2") val rubbleOCL2: SageReference<ObjectCreationList>? = null,
    @SageIniName("RubbleOCL3") val rubbleOCL3: SageReference<ObjectCreationList>? = null,
    @SageIniName("RubbleOCL4") val rubbleOCL4: SageReference<ObjectCreationList>? = null,
    @SageIniName("RubbleOCL5") val rubbleOCL5: SageReference<ObjectCreationList>? = null,
    @SageIniName("RubbleOCL6") val rubbleOCL6: SageReference<ObjectCreationList>? = null,
    @SageIniName("RubbleOCL7") val rubbleOCL7: SageReference<ObjectCreationList>? = null,
    @SageIniName("RubbleOCL8") val rubbleOCL8: SageReference<ObjectCreationList>? = null,
    @SageIniName("PristineFXList1") val pristineFXList1: SageReference<FXList>? = null,
    @SageIniName("PristineFXList2") val pristineFXList2: SageReference<FXList>? = null,
    @SageIniName("PristineFXList3") val pristineFXList3: SageReference<FXList>? = null,
    @SageIniName("PristineFXList4") val pristineFXList4: SageReference<FXList>? = null,
    @SageIniName("PristineFXList5") val pristineFXList5: SageReference<FXList>? = null,
    @SageIniName("PristineFXList6") val pristineFXList6: SageReference<FXList>? = null,
    @SageIniName("PristineFXList7") val pristineFXList7: SageReference<FXList>? = null,
    @SageIniName("PristineFXList8") val pristineFXList8: SageReference<FXList>? = null,
    @SageIniName("DamagedFXList1") val damagedFXList1: SageReference<FXList>? = null,
    @SageIniName("DamagedFXList2") val damagedFXList2: SageReference<FXList>? = null,
    @SageIniName("DamagedFXList3") val damagedFXList3: SageReference<FXList>? = null,
    @SageIniName("DamagedFXList4") val damagedFXList4: SageReference<FXList>? = null,
    @SageIniName("DamagedFXList5") val damagedFXList5: SageReference<FXList>? = null,
    @SageIniName("DamagedFXList6") val damagedFXList6: SageReference<FXList>? = null,
    @SageIniName("DamagedFXList7") val damagedFXList7: SageReference<FXList>? = null,
    @SageIniName("DamagedFXList8") val damagedFXList8: SageReference<FXList>? = null,
    @SageIniName("ReallyDamagedFXList1") val reallyDamagedFXList1: SageReference<FXList>? = null,
    @SageIniName("ReallyDamagedFXList2") val reallyDamagedFXList2: SageReference<FXList>? = null,
    @SageIniName("ReallyDamagedFXList3") val reallyDamagedFXList3: SageReference<FXList>? = null,
    @SageIniName("ReallyDamagedFXList4") val reallyDamagedFXList4: SageReference<FXList>? = null,
    @SageIniName("ReallyDamagedFXList5") val reallyDamagedFXList5: SageReference<FXList>? = null,
    @SageIniName("ReallyDamagedFXList6") val reallyDamagedFXList6: SageReference<FXList>? = null,
    @SageIniName("ReallyDamagedFXList7") val reallyDamagedFXList7: SageReference<FXList>? = null,
    @SageIniName("ReallyDamagedFXList8") val reallyDamagedFXList8: SageReference<FXList>? = null,
    @SageIniName("RubbleFXList2") val rubbleFXList2: SageReference<FXList>? = null,
    @SageIniName("RubbleFXList3") val rubbleFXList3: SageReference<FXList>? = null,
    @SageIniName("RubbleFXList4") val rubbleFXList4: SageReference<FXList>? = null,
    @SageIniName("RubbleFXList5") val rubbleFXList5: SageReference<FXList>? = null,
    @SageIniName("RubbleFXList6") val rubbleFXList6: SageReference<FXList>? = null,
    @SageIniName("RubbleFXList7") val rubbleFXList7: SageReference<FXList>? = null,
    @SageIniName("RubbleFXList8") val rubbleFXList8: SageReference<FXList>? = null,
    @SageIniName("PristineParticleSystem7") val pristineParticleSystem7: SageReference<FXParticleSystem>? = null,
    @SageIniName("PristineParticleSystem8") val pristineParticleSystem8: SageReference<FXParticleSystem>? = null,
    @SageIniName("DamagedParticleSystem1") val damagedParticleSystem1: SageReference<FXParticleSystem>? = null,
    @SageIniName("DamagedParticleSystem2") val damagedParticleSystem2: SageReference<FXParticleSystem>? = null,
    @SageIniName("DamagedParticleSystem3") val damagedParticleSystem3: SageReference<FXParticleSystem>? = null,
    @SageIniName("DamagedParticleSystem4") val damagedParticleSystem4: SageReference<FXParticleSystem>? = null,
    @SageIniName("DamagedParticleSystem5") val damagedParticleSystem5: SageReference<FXParticleSystem>? = null,
    @SageIniName("DamagedParticleSystem6") val damagedParticleSystem6: SageReference<FXParticleSystem>? = null,
    @SageIniName("DamagedParticleSystem7") val damagedParticleSystem7: SageReference<FXParticleSystem>? = null,
    @SageIniName("DamagedParticleSystem8") val damagedParticleSystem8: SageReference<FXParticleSystem>? = null,
    @SageIniName("ReallyDamagedParticleSystem1") val reallyDamagedParticleSystem1: SageReference<FXParticleSystem>? = null,
    @SageIniName("ReallyDamagedParticleSystem2") val reallyDamagedParticleSystem2: SageReference<FXParticleSystem>? = null,
    @SageIniName("ReallyDamagedParticleSystem3") val reallyDamagedParticleSystem3: SageReference<FXParticleSystem>? = null,
    @SageIniName("ReallyDamagedParticleSystem4") val reallyDamagedParticleSystem4: SageReference<FXParticleSystem>? = null,
    @SageIniName("ReallyDamagedParticleSystem5") val reallyDamagedParticleSystem5: SageReference<FXParticleSystem>? = null,
    @SageIniName("ReallyDamagedParticleSystem6") val reallyDamagedParticleSystem6: SageReference<FXParticleSystem>? = null,
    @SageIniName("ReallyDamagedParticleSystem7") val reallyDamagedParticleSystem7: SageReference<FXParticleSystem>? = null,
    @SageIniName("ReallyDamagedParticleSystem8") val reallyDamagedParticleSystem8: SageReference<FXParticleSystem>? = null,
    @SageIniName("RubbleParticleSystem2") val rubbleParticleSystem2: SageReference<FXParticleSystem>? = null,
    @SageIniName("RubbleParticleSystem3") val rubbleParticleSystem3: SageReference<FXParticleSystem>? = null,
    @SageIniName("RubbleParticleSystem4") val rubbleParticleSystem4: SageReference<FXParticleSystem>? = null,
    @SageIniName("RubbleParticleSystem5") val rubbleParticleSystem5: SageReference<FXParticleSystem>? = null,
    @SageIniName("RubbleParticleSystem6") val rubbleParticleSystem6: SageReference<FXParticleSystem>? = null,
    @SageIniName("RubbleParticleSystem7") val rubbleParticleSystem7: SageReference<FXParticleSystem>? = null,
    @SageIniName("RubbleParticleSystem8") val rubbleParticleSystem8: SageReference<FXParticleSystem>? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<BoneFXUpdate>(
        name = "BoneFXUpdate",
        properties = {
            property("DamageFXTypes", SageFilter.type) { it.damageFXTypes }
            property("RubbleFXList1", ReferenceValue<FXList> { listOf(FXList) }) { it.rubbleFXList1 }
            property("DamageParticleTypes", SageFilter.type) { it.damageParticleTypes }
            property("PristineParticleSystem1", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.pristineParticleSystem1 }
            property("RubbleParticleSystem1", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.rubbleParticleSystem1 }
            property("PristineParticleSystem2", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.pristineParticleSystem2 }
            property("PristineParticleSystem3", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.pristineParticleSystem3 }
            property("PristineParticleSystem4", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.pristineParticleSystem4 }
            property("PristineParticleSystem5", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.pristineParticleSystem5 }
            property("PristineParticleSystem6", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.pristineParticleSystem6 }
            property("DamageOCLTypes", SageFilter.type) { it.damageOCLTypes }
            property("PristineOCL1", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.pristineOCL1 }
            property("PristineOCL2", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.pristineOCL2 }
            property("PristineOCL3", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.pristineOCL3 }
            property("PristineOCL4", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.pristineOCL4 }
            property("PristineOCL5", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.pristineOCL5 }
            property("PristineOCL6", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.pristineOCL6 }
            property("PristineOCL7", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.pristineOCL7 }
            property("PristineOCL8", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.pristineOCL8 }
            property("DamagedOCL1", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.damagedOCL1 }
            property("DamagedOCL2", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.damagedOCL2 }
            property("DamagedOCL3", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.damagedOCL3 }
            property("DamagedOCL4", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.damagedOCL4 }
            property("DamagedOCL5", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.damagedOCL5 }
            property("DamagedOCL6", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.damagedOCL6 }
            property("DamagedOCL7", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.damagedOCL7 }
            property("DamagedOCL8", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.damagedOCL8 }
            property("ReallyDamagedOCL1", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.reallyDamagedOCL1 }
            property("ReallyDamagedOCL2", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.reallyDamagedOCL2 }
            property("ReallyDamagedOCL3", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.reallyDamagedOCL3 }
            property("ReallyDamagedOCL4", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.reallyDamagedOCL4 }
            property("ReallyDamagedOCL5", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.reallyDamagedOCL5 }
            property("ReallyDamagedOCL6", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.reallyDamagedOCL6 }
            property("ReallyDamagedOCL7", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.reallyDamagedOCL7 }
            property("ReallyDamagedOCL8", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.reallyDamagedOCL8 }
            property("RubbleOCL1", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.rubbleOCL1 }
            property("RubbleOCL2", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.rubbleOCL2 }
            property("RubbleOCL3", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.rubbleOCL3 }
            property("RubbleOCL4", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.rubbleOCL4 }
            property("RubbleOCL5", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.rubbleOCL5 }
            property("RubbleOCL6", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.rubbleOCL6 }
            property("RubbleOCL7", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.rubbleOCL7 }
            property("RubbleOCL8", ReferenceValue<ObjectCreationList> { listOf(ObjectCreationList) }) { it.rubbleOCL8 }
            property("PristineFXList1", ReferenceValue<FXList> { listOf(FXList) }) { it.pristineFXList1 }
            property("PristineFXList2", ReferenceValue<FXList> { listOf(FXList) }) { it.pristineFXList2 }
            property("PristineFXList3", ReferenceValue<FXList> { listOf(FXList) }) { it.pristineFXList3 }
            property("PristineFXList4", ReferenceValue<FXList> { listOf(FXList) }) { it.pristineFXList4 }
            property("PristineFXList5", ReferenceValue<FXList> { listOf(FXList) }) { it.pristineFXList5 }
            property("PristineFXList6", ReferenceValue<FXList> { listOf(FXList) }) { it.pristineFXList6 }
            property("PristineFXList7", ReferenceValue<FXList> { listOf(FXList) }) { it.pristineFXList7 }
            property("PristineFXList8", ReferenceValue<FXList> { listOf(FXList) }) { it.pristineFXList8 }
            property("DamagedFXList1", ReferenceValue<FXList> { listOf(FXList) }) { it.damagedFXList1 }
            property("DamagedFXList2", ReferenceValue<FXList> { listOf(FXList) }) { it.damagedFXList2 }
            property("DamagedFXList3", ReferenceValue<FXList> { listOf(FXList) }) { it.damagedFXList3 }
            property("DamagedFXList4", ReferenceValue<FXList> { listOf(FXList) }) { it.damagedFXList4 }
            property("DamagedFXList5", ReferenceValue<FXList> { listOf(FXList) }) { it.damagedFXList5 }
            property("DamagedFXList6", ReferenceValue<FXList> { listOf(FXList) }) { it.damagedFXList6 }
            property("DamagedFXList7", ReferenceValue<FXList> { listOf(FXList) }) { it.damagedFXList7 }
            property("DamagedFXList8", ReferenceValue<FXList> { listOf(FXList) }) { it.damagedFXList8 }
            property("ReallyDamagedFXList1", ReferenceValue<FXList> { listOf(FXList) }) { it.reallyDamagedFXList1 }
            property("ReallyDamagedFXList2", ReferenceValue<FXList> { listOf(FXList) }) { it.reallyDamagedFXList2 }
            property("ReallyDamagedFXList3", ReferenceValue<FXList> { listOf(FXList) }) { it.reallyDamagedFXList3 }
            property("ReallyDamagedFXList4", ReferenceValue<FXList> { listOf(FXList) }) { it.reallyDamagedFXList4 }
            property("ReallyDamagedFXList5", ReferenceValue<FXList> { listOf(FXList) }) { it.reallyDamagedFXList5 }
            property("ReallyDamagedFXList6", ReferenceValue<FXList> { listOf(FXList) }) { it.reallyDamagedFXList6 }
            property("ReallyDamagedFXList7", ReferenceValue<FXList> { listOf(FXList) }) { it.reallyDamagedFXList7 }
            property("ReallyDamagedFXList8", ReferenceValue<FXList> { listOf(FXList) }) { it.reallyDamagedFXList8 }
            property("RubbleFXList2", ReferenceValue<FXList> { listOf(FXList) }) { it.rubbleFXList2 }
            property("RubbleFXList3", ReferenceValue<FXList> { listOf(FXList) }) { it.rubbleFXList3 }
            property("RubbleFXList4", ReferenceValue<FXList> { listOf(FXList) }) { it.rubbleFXList4 }
            property("RubbleFXList5", ReferenceValue<FXList> { listOf(FXList) }) { it.rubbleFXList5 }
            property("RubbleFXList6", ReferenceValue<FXList> { listOf(FXList) }) { it.rubbleFXList6 }
            property("RubbleFXList7", ReferenceValue<FXList> { listOf(FXList) }) { it.rubbleFXList7 }
            property("RubbleFXList8", ReferenceValue<FXList> { listOf(FXList) }) { it.rubbleFXList8 }
            property("PristineParticleSystem7", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.pristineParticleSystem7 }
            property("PristineParticleSystem8", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.pristineParticleSystem8 }
            property("DamagedParticleSystem1", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.damagedParticleSystem1 }
            property("DamagedParticleSystem2", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.damagedParticleSystem2 }
            property("DamagedParticleSystem3", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.damagedParticleSystem3 }
            property("DamagedParticleSystem4", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.damagedParticleSystem4 }
            property("DamagedParticleSystem5", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.damagedParticleSystem5 }
            property("DamagedParticleSystem6", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.damagedParticleSystem6 }
            property("DamagedParticleSystem7", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.damagedParticleSystem7 }
            property("DamagedParticleSystem8", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.damagedParticleSystem8 }
            property("ReallyDamagedParticleSystem1", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.reallyDamagedParticleSystem1 }
            property("ReallyDamagedParticleSystem2", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.reallyDamagedParticleSystem2 }
            property("ReallyDamagedParticleSystem3", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.reallyDamagedParticleSystem3 }
            property("ReallyDamagedParticleSystem4", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.reallyDamagedParticleSystem4 }
            property("ReallyDamagedParticleSystem5", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.reallyDamagedParticleSystem5 }
            property("ReallyDamagedParticleSystem6", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.reallyDamagedParticleSystem6 }
            property("ReallyDamagedParticleSystem7", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.reallyDamagedParticleSystem7 }
            property("ReallyDamagedParticleSystem8", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.reallyDamagedParticleSystem8 }
            property("RubbleParticleSystem2", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.rubbleParticleSystem2 }
            property("RubbleParticleSystem3", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.rubbleParticleSystem3 }
            property("RubbleParticleSystem4", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.rubbleParticleSystem4 }
            property("RubbleParticleSystem5", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.rubbleParticleSystem5 }
            property("RubbleParticleSystem6", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.rubbleParticleSystem6 }
            property("RubbleParticleSystem7", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.rubbleParticleSystem7 }
            property("RubbleParticleSystem8", ReferenceValue<FXParticleSystem> { listOf(FXParticleSystem) }) { it.rubbleParticleSystem8 }
        },
    )
}
