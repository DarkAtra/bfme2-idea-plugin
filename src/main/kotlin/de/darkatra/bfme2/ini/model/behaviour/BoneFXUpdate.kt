package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.value.BoneFXList
import de.darkatra.bfme2.ini.model.value.BoneOCL
import de.darkatra.bfme2.ini.model.value.BoneParticleSystem
import de.darkatra.bfme2.ini.model.value.SageFilter

data class BoneFXUpdate(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("DamageFXTypes") val damageFXTypes: SageFilter? = null,
    @SageIniName("RubbleFXList1") val rubbleFXList1: BoneFXList? = null,
    @SageIniName("DamageParticleTypes") val damageParticleTypes: SageFilter? = null,
    @SageIniName("PristineParticleSystem1") val pristineParticleSystem1: BoneParticleSystem? = null,
    @SageIniName("RubbleParticleSystem1") val rubbleParticleSystem1: BoneParticleSystem? = null,
    @SageIniName("PristineParticleSystem2") val pristineParticleSystem2: BoneParticleSystem? = null,
    @SageIniName("PristineParticleSystem3") val pristineParticleSystem3: BoneParticleSystem? = null,
    @SageIniName("PristineParticleSystem4") val pristineParticleSystem4: BoneParticleSystem? = null,
    @SageIniName("PristineParticleSystem5") val pristineParticleSystem5: BoneParticleSystem? = null,
    @SageIniName("PristineParticleSystem6") val pristineParticleSystem6: BoneParticleSystem? = null,
    @SageIniName("DamageOCLTypes") val damageOCLTypes: SageFilter? = null,
    @SageIniName("PristineOCL1") val pristineOCL1: BoneOCL? = null,
    @SageIniName("PristineOCL2") val pristineOCL2: BoneOCL? = null,
    @SageIniName("PristineOCL3") val pristineOCL3: BoneOCL? = null,
    @SageIniName("PristineOCL4") val pristineOCL4: BoneOCL? = null,
    @SageIniName("PristineOCL5") val pristineOCL5: BoneOCL? = null,
    @SageIniName("PristineOCL6") val pristineOCL6: BoneOCL? = null,
    @SageIniName("PristineOCL7") val pristineOCL7: BoneOCL? = null,
    @SageIniName("PristineOCL8") val pristineOCL8: BoneOCL? = null,
    @SageIniName("DamagedOCL1") val damagedOCL1: BoneOCL? = null,
    @SageIniName("DamagedOCL2") val damagedOCL2: BoneOCL? = null,
    @SageIniName("DamagedOCL3") val damagedOCL3: BoneOCL? = null,
    @SageIniName("DamagedOCL4") val damagedOCL4: BoneOCL? = null,
    @SageIniName("DamagedOCL5") val damagedOCL5: BoneOCL? = null,
    @SageIniName("DamagedOCL6") val damagedOCL6: BoneOCL? = null,
    @SageIniName("DamagedOCL7") val damagedOCL7: BoneOCL? = null,
    @SageIniName("DamagedOCL8") val damagedOCL8: BoneOCL? = null,
    @SageIniName("ReallyDamagedOCL1") val reallyDamagedOCL1: BoneOCL? = null,
    @SageIniName("ReallyDamagedOCL2") val reallyDamagedOCL2: BoneOCL? = null,
    @SageIniName("ReallyDamagedOCL3") val reallyDamagedOCL3: BoneOCL? = null,
    @SageIniName("ReallyDamagedOCL4") val reallyDamagedOCL4: BoneOCL? = null,
    @SageIniName("ReallyDamagedOCL5") val reallyDamagedOCL5: BoneOCL? = null,
    @SageIniName("ReallyDamagedOCL6") val reallyDamagedOCL6: BoneOCL? = null,
    @SageIniName("ReallyDamagedOCL7") val reallyDamagedOCL7: BoneOCL? = null,
    @SageIniName("ReallyDamagedOCL8") val reallyDamagedOCL8: BoneOCL? = null,
    @SageIniName("RubbleOCL1") val rubbleOCL1: BoneOCL? = null,
    @SageIniName("RubbleOCL2") val rubbleOCL2: BoneOCL? = null,
    @SageIniName("RubbleOCL3") val rubbleOCL3: BoneOCL? = null,
    @SageIniName("RubbleOCL4") val rubbleOCL4: BoneOCL? = null,
    @SageIniName("RubbleOCL5") val rubbleOCL5: BoneOCL? = null,
    @SageIniName("RubbleOCL6") val rubbleOCL6: BoneOCL? = null,
    @SageIniName("RubbleOCL7") val rubbleOCL7: BoneOCL? = null,
    @SageIniName("RubbleOCL8") val rubbleOCL8: BoneOCL? = null,
    @SageIniName("PristineFXList1") val pristineFXList1: BoneFXList? = null,
    @SageIniName("PristineFXList2") val pristineFXList2: BoneFXList? = null,
    @SageIniName("PristineFXList3") val pristineFXList3: BoneFXList? = null,
    @SageIniName("PristineFXList4") val pristineFXList4: BoneFXList? = null,
    @SageIniName("PristineFXList5") val pristineFXList5: BoneFXList? = null,
    @SageIniName("PristineFXList6") val pristineFXList6: BoneFXList? = null,
    @SageIniName("PristineFXList7") val pristineFXList7: BoneFXList? = null,
    @SageIniName("PristineFXList8") val pristineFXList8: BoneFXList? = null,
    @SageIniName("DamagedFXList1") val damagedFXList1: BoneFXList? = null,
    @SageIniName("DamagedFXList2") val damagedFXList2: BoneFXList? = null,
    @SageIniName("DamagedFXList3") val damagedFXList3: BoneFXList? = null,
    @SageIniName("DamagedFXList4") val damagedFXList4: BoneFXList? = null,
    @SageIniName("DamagedFXList5") val damagedFXList5: BoneFXList? = null,
    @SageIniName("DamagedFXList6") val damagedFXList6: BoneFXList? = null,
    @SageIniName("DamagedFXList7") val damagedFXList7: BoneFXList? = null,
    @SageIniName("DamagedFXList8") val damagedFXList8: BoneFXList? = null,
    @SageIniName("ReallyDamagedFXList1") val reallyDamagedFXList1: BoneFXList? = null,
    @SageIniName("ReallyDamagedFXList2") val reallyDamagedFXList2: BoneFXList? = null,
    @SageIniName("ReallyDamagedFXList3") val reallyDamagedFXList3: BoneFXList? = null,
    @SageIniName("ReallyDamagedFXList4") val reallyDamagedFXList4: BoneFXList? = null,
    @SageIniName("ReallyDamagedFXList5") val reallyDamagedFXList5: BoneFXList? = null,
    @SageIniName("ReallyDamagedFXList6") val reallyDamagedFXList6: BoneFXList? = null,
    @SageIniName("ReallyDamagedFXList7") val reallyDamagedFXList7: BoneFXList? = null,
    @SageIniName("ReallyDamagedFXList8") val reallyDamagedFXList8: BoneFXList? = null,
    @SageIniName("RubbleFXList2") val rubbleFXList2: BoneFXList? = null,
    @SageIniName("RubbleFXList3") val rubbleFXList3: BoneFXList? = null,
    @SageIniName("RubbleFXList4") val rubbleFXList4: BoneFXList? = null,
    @SageIniName("RubbleFXList5") val rubbleFXList5: BoneFXList? = null,
    @SageIniName("RubbleFXList6") val rubbleFXList6: BoneFXList? = null,
    @SageIniName("RubbleFXList7") val rubbleFXList7: BoneFXList? = null,
    @SageIniName("RubbleFXList8") val rubbleFXList8: BoneFXList? = null,
    @SageIniName("PristineParticleSystem7") val pristineParticleSystem7: BoneParticleSystem? = null,
    @SageIniName("PristineParticleSystem8") val pristineParticleSystem8: BoneParticleSystem? = null,
    @SageIniName("DamagedParticleSystem1") val damagedParticleSystem1: BoneParticleSystem? = null,
    @SageIniName("DamagedParticleSystem2") val damagedParticleSystem2: BoneParticleSystem? = null,
    @SageIniName("DamagedParticleSystem3") val damagedParticleSystem3: BoneParticleSystem? = null,
    @SageIniName("DamagedParticleSystem4") val damagedParticleSystem4: BoneParticleSystem? = null,
    @SageIniName("DamagedParticleSystem5") val damagedParticleSystem5: BoneParticleSystem? = null,
    @SageIniName("DamagedParticleSystem6") val damagedParticleSystem6: BoneParticleSystem? = null,
    @SageIniName("DamagedParticleSystem7") val damagedParticleSystem7: BoneParticleSystem? = null,
    @SageIniName("DamagedParticleSystem8") val damagedParticleSystem8: BoneParticleSystem? = null,
    @SageIniName("ReallyDamagedParticleSystem1") val reallyDamagedParticleSystem1: BoneParticleSystem? = null,
    @SageIniName("ReallyDamagedParticleSystem2") val reallyDamagedParticleSystem2: BoneParticleSystem? = null,
    @SageIniName("ReallyDamagedParticleSystem3") val reallyDamagedParticleSystem3: BoneParticleSystem? = null,
    @SageIniName("ReallyDamagedParticleSystem4") val reallyDamagedParticleSystem4: BoneParticleSystem? = null,
    @SageIniName("ReallyDamagedParticleSystem5") val reallyDamagedParticleSystem5: BoneParticleSystem? = null,
    @SageIniName("ReallyDamagedParticleSystem6") val reallyDamagedParticleSystem6: BoneParticleSystem? = null,
    @SageIniName("ReallyDamagedParticleSystem7") val reallyDamagedParticleSystem7: BoneParticleSystem? = null,
    @SageIniName("ReallyDamagedParticleSystem8") val reallyDamagedParticleSystem8: BoneParticleSystem? = null,
    @SageIniName("RubbleParticleSystem2") val rubbleParticleSystem2: BoneParticleSystem? = null,
    @SageIniName("RubbleParticleSystem3") val rubbleParticleSystem3: BoneParticleSystem? = null,
    @SageIniName("RubbleParticleSystem4") val rubbleParticleSystem4: BoneParticleSystem? = null,
    @SageIniName("RubbleParticleSystem5") val rubbleParticleSystem5: BoneParticleSystem? = null,
    @SageIniName("RubbleParticleSystem6") val rubbleParticleSystem6: BoneParticleSystem? = null,
    @SageIniName("RubbleParticleSystem7") val rubbleParticleSystem7: BoneParticleSystem? = null,
    @SageIniName("RubbleParticleSystem8") val rubbleParticleSystem8: BoneParticleSystem? = null,
) : SageBehavior {

    companion object : SageIniBlockDescriptor<BoneFXUpdate>(
        name = "BoneFXUpdate",
        properties = {
            property("DamageFXTypes", SageFilter.type) { it.damageFXTypes }
            property("RubbleFXList1", BoneFXList.type) { it.rubbleFXList1 }
            property("DamageParticleTypes", SageFilter.type) { it.damageParticleTypes }
            property("PristineParticleSystem1", BoneParticleSystem.type) { it.pristineParticleSystem1 }
            property("RubbleParticleSystem1", BoneParticleSystem.type) { it.rubbleParticleSystem1 }
            property("PristineParticleSystem2", BoneParticleSystem.type) { it.pristineParticleSystem2 }
            property("PristineParticleSystem3", BoneParticleSystem.type) { it.pristineParticleSystem3 }
            property("PristineParticleSystem4", BoneParticleSystem.type) { it.pristineParticleSystem4 }
            property("PristineParticleSystem5", BoneParticleSystem.type) { it.pristineParticleSystem5 }
            property("PristineParticleSystem6", BoneParticleSystem.type) { it.pristineParticleSystem6 }
            property("DamageOCLTypes", SageFilter.type) { it.damageOCLTypes }
            property("PristineOCL1", BoneOCL.type) { it.pristineOCL1 }
            property("PristineOCL2", BoneOCL.type) { it.pristineOCL2 }
            property("PristineOCL3", BoneOCL.type) { it.pristineOCL3 }
            property("PristineOCL4", BoneOCL.type) { it.pristineOCL4 }
            property("PristineOCL5", BoneOCL.type) { it.pristineOCL5 }
            property("PristineOCL6", BoneOCL.type) { it.pristineOCL6 }
            property("PristineOCL7", BoneOCL.type) { it.pristineOCL7 }
            property("PristineOCL8", BoneOCL.type) { it.pristineOCL8 }
            property("DamagedOCL1", BoneOCL.type) { it.damagedOCL1 }
            property("DamagedOCL2", BoneOCL.type) { it.damagedOCL2 }
            property("DamagedOCL3", BoneOCL.type) { it.damagedOCL3 }
            property("DamagedOCL4", BoneOCL.type) { it.damagedOCL4 }
            property("DamagedOCL5", BoneOCL.type) { it.damagedOCL5 }
            property("DamagedOCL6", BoneOCL.type) { it.damagedOCL6 }
            property("DamagedOCL7", BoneOCL.type) { it.damagedOCL7 }
            property("DamagedOCL8", BoneOCL.type) { it.damagedOCL8 }
            property("ReallyDamagedOCL1", BoneOCL.type) { it.reallyDamagedOCL1 }
            property("ReallyDamagedOCL2", BoneOCL.type) { it.reallyDamagedOCL2 }
            property("ReallyDamagedOCL3", BoneOCL.type) { it.reallyDamagedOCL3 }
            property("ReallyDamagedOCL4", BoneOCL.type) { it.reallyDamagedOCL4 }
            property("ReallyDamagedOCL5", BoneOCL.type) { it.reallyDamagedOCL5 }
            property("ReallyDamagedOCL6", BoneOCL.type) { it.reallyDamagedOCL6 }
            property("ReallyDamagedOCL7", BoneOCL.type) { it.reallyDamagedOCL7 }
            property("ReallyDamagedOCL8", BoneOCL.type) { it.reallyDamagedOCL8 }
            property("RubbleOCL1", BoneOCL.type) { it.rubbleOCL1 }
            property("RubbleOCL2", BoneOCL.type) { it.rubbleOCL2 }
            property("RubbleOCL3", BoneOCL.type) { it.rubbleOCL3 }
            property("RubbleOCL4", BoneOCL.type) { it.rubbleOCL4 }
            property("RubbleOCL5", BoneOCL.type) { it.rubbleOCL5 }
            property("RubbleOCL6", BoneOCL.type) { it.rubbleOCL6 }
            property("RubbleOCL7", BoneOCL.type) { it.rubbleOCL7 }
            property("RubbleOCL8", BoneOCL.type) { it.rubbleOCL8 }
            property("PristineFXList1", BoneFXList.type) { it.pristineFXList1 }
            property("PristineFXList2", BoneFXList.type) { it.pristineFXList2 }
            property("PristineFXList3", BoneFXList.type) { it.pristineFXList3 }
            property("PristineFXList4", BoneFXList.type) { it.pristineFXList4 }
            property("PristineFXList5", BoneFXList.type) { it.pristineFXList5 }
            property("PristineFXList6", BoneFXList.type) { it.pristineFXList6 }
            property("PristineFXList7", BoneFXList.type) { it.pristineFXList7 }
            property("PristineFXList8", BoneFXList.type) { it.pristineFXList8 }
            property("DamagedFXList1", BoneFXList.type) { it.damagedFXList1 }
            property("DamagedFXList2", BoneFXList.type) { it.damagedFXList2 }
            property("DamagedFXList3", BoneFXList.type) { it.damagedFXList3 }
            property("DamagedFXList4", BoneFXList.type) { it.damagedFXList4 }
            property("DamagedFXList5", BoneFXList.type) { it.damagedFXList5 }
            property("DamagedFXList6", BoneFXList.type) { it.damagedFXList6 }
            property("DamagedFXList7", BoneFXList.type) { it.damagedFXList7 }
            property("DamagedFXList8", BoneFXList.type) { it.damagedFXList8 }
            property("ReallyDamagedFXList1", BoneFXList.type) { it.reallyDamagedFXList1 }
            property("ReallyDamagedFXList2", BoneFXList.type) { it.reallyDamagedFXList2 }
            property("ReallyDamagedFXList3", BoneFXList.type) { it.reallyDamagedFXList3 }
            property("ReallyDamagedFXList4", BoneFXList.type) { it.reallyDamagedFXList4 }
            property("ReallyDamagedFXList5", BoneFXList.type) { it.reallyDamagedFXList5 }
            property("ReallyDamagedFXList6", BoneFXList.type) { it.reallyDamagedFXList6 }
            property("ReallyDamagedFXList7", BoneFXList.type) { it.reallyDamagedFXList7 }
            property("ReallyDamagedFXList8", BoneFXList.type) { it.reallyDamagedFXList8 }
            property("RubbleFXList2", BoneFXList.type) { it.rubbleFXList2 }
            property("RubbleFXList3", BoneFXList.type) { it.rubbleFXList3 }
            property("RubbleFXList4", BoneFXList.type) { it.rubbleFXList4 }
            property("RubbleFXList5", BoneFXList.type) { it.rubbleFXList5 }
            property("RubbleFXList6", BoneFXList.type) { it.rubbleFXList6 }
            property("RubbleFXList7", BoneFXList.type) { it.rubbleFXList7 }
            property("RubbleFXList8", BoneFXList.type) { it.rubbleFXList8 }
            property("PristineParticleSystem7", BoneParticleSystem.type) { it.pristineParticleSystem7 }
            property("PristineParticleSystem8", BoneParticleSystem.type) { it.pristineParticleSystem8 }
            property("DamagedParticleSystem1", BoneParticleSystem.type) { it.damagedParticleSystem1 }
            property("DamagedParticleSystem2", BoneParticleSystem.type) { it.damagedParticleSystem2 }
            property("DamagedParticleSystem3", BoneParticleSystem.type) { it.damagedParticleSystem3 }
            property("DamagedParticleSystem4", BoneParticleSystem.type) { it.damagedParticleSystem4 }
            property("DamagedParticleSystem5", BoneParticleSystem.type) { it.damagedParticleSystem5 }
            property("DamagedParticleSystem6", BoneParticleSystem.type) { it.damagedParticleSystem6 }
            property("DamagedParticleSystem7", BoneParticleSystem.type) { it.damagedParticleSystem7 }
            property("DamagedParticleSystem8", BoneParticleSystem.type) { it.damagedParticleSystem8 }
            property("ReallyDamagedParticleSystem1", BoneParticleSystem.type) { it.reallyDamagedParticleSystem1 }
            property("ReallyDamagedParticleSystem2", BoneParticleSystem.type) { it.reallyDamagedParticleSystem2 }
            property("ReallyDamagedParticleSystem3", BoneParticleSystem.type) { it.reallyDamagedParticleSystem3 }
            property("ReallyDamagedParticleSystem4", BoneParticleSystem.type) { it.reallyDamagedParticleSystem4 }
            property("ReallyDamagedParticleSystem5", BoneParticleSystem.type) { it.reallyDamagedParticleSystem5 }
            property("ReallyDamagedParticleSystem6", BoneParticleSystem.type) { it.reallyDamagedParticleSystem6 }
            property("ReallyDamagedParticleSystem7", BoneParticleSystem.type) { it.reallyDamagedParticleSystem7 }
            property("ReallyDamagedParticleSystem8", BoneParticleSystem.type) { it.reallyDamagedParticleSystem8 }
            property("RubbleParticleSystem2", BoneParticleSystem.type) { it.rubbleParticleSystem2 }
            property("RubbleParticleSystem3", BoneParticleSystem.type) { it.rubbleParticleSystem3 }
            property("RubbleParticleSystem4", BoneParticleSystem.type) { it.rubbleParticleSystem4 }
            property("RubbleParticleSystem5", BoneParticleSystem.type) { it.rubbleParticleSystem5 }
            property("RubbleParticleSystem6", BoneParticleSystem.type) { it.rubbleParticleSystem6 }
            property("RubbleParticleSystem7", BoneParticleSystem.type) { it.rubbleParticleSystem7 }
            property("RubbleParticleSystem8", BoneParticleSystem.type) { it.rubbleParticleSystem8 }
        },
    )
}
