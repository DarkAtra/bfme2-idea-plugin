package de.darkatra.bfme2.ini.model.behaviour

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.`object`.UpgradeTrigger
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped

data class GeometryUpgrade(
    override val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("TriggeredBy") override val triggeredBy: List<SageReference<UpgradeTrigger>> = emptyList(),
    @SageIniName("ConflictsWith") override val conflictsWith: List<SageReference<Upgrade>> = emptyList(),
    @SageIniName("RequiresAllTriggers") override val requiresAllTriggers: Boolean = false,
    @SageIniName("RequiresAllConflictingTriggers") override val requiresAllConflictingTriggers: Boolean = false,
    @SageIniName("StartsActive") override val startsActive: Boolean = false,
    @SageIniName("Description") override val description: String = "",
    @SageIniName("ActiveDuringConstruction") override val activeDuringConstruction: Boolean = false,
    @SageIniName("CustomAnimAndDuration") override val customAnimAndDuration: Map<String, String> = emptyMap(),
    @SageIniName("Permanent") override val permanent: Boolean = false,
    @SageIniName("ShowGeometry") val showGeometry: List<Untyped> = emptyList(),
    @SageIniName("HideGeometry") val hideGeometry: List<Untyped> = emptyList(),
    @SageIniName("WallBoundsMesh") val wallBoundsMesh: Opaque? = null,
    @SageIniName("RampMesh1") val rampMesh1: Opaque? = null,
    @SageIniName("RampMesh2") val rampMesh2: Opaque? = null,
) : UpgradeBehavior() {

    companion object : SageIniBlockDescriptor<GeometryUpgrade>(
        name = "GeometryUpgrade",
        parent = UpgradeBehavior,
        properties = {
            property("ShowGeometry", ListValue(Untyped.type)) { it.showGeometry }
            property("HideGeometry", ListValue(Untyped.type)) { it.hideGeometry }
            property("WallBoundsMesh", Opaque.type) { it.wallBoundsMesh }
            property("RampMesh1", Opaque.type) { it.rampMesh1 }
            property("RampMesh2", Opaque.type) { it.rampMesh2 }
        },
    )
}
