package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.value.KindOf
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.VeterancyLevel

data class CrateData(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("CrateObject") val crateObject: Opaque? = null,
    @SageIniName("CreationChance") val creationChance: Double = 0.0,
    @SageIniName("KilledByType") val killedByType: KindOf? = null,
    @SageIniName("KillerScience") val killerScience: Opaque? = null,
    @SageIniName("OwnedByMaker") val ownedByMaker: Boolean = false,
    @SageIniName("VeterancyLevel") val veterancyLevel: VeterancyLevel? = null,
) : SageIniObject {

    companion object : SageIniBlockDescriptor<CrateData>(
        name = "CrateData",
        properties = {
            property("CrateObject", Opaque.type) { it.crateObject }
            property("CreationChance", FloatValue) { it.creationChance }
            property("KilledByType", KindOf.type) { it.killedByType }
            property("KillerScience", Opaque.type) { it.killerScience }
            property("OwnedByMaker", BooleanValue) { it.ownedByMaker }
            property("VeterancyLevel", VeterancyLevel.type) { it.veterancyLevel }
        },
    )
}
