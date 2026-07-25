package de.darkatra.bfme2.ini.model.livingworld

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BooleanValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.value.Opaque

data class LivingWorldIconObject(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("Model") val model: Opaque? = null,
    @SageIniName("SubObjects") val subObjects: Opaque? = null,
    @SageIniName("AnimMode") val animMode: Opaque? = null,
    @SageIniName("ZOffset") val zOffset: Double = 0.0,
    @SageIniName("OrientAngle") val orientAngle: Double = 0.0,
    @SageIniName("Scale") val scale: Double = 0.0,
    @SageIniName("Clickable") val clickable: Boolean = false,
    @SageIniName("Pickbox") val pickbox: Opaque? = null,
    @SageIniName("Shadow") val shadow: Opaque? = null,
    @SageIniName("HideWhenUnderConstruction") val hideWhenUnderConstruction: Boolean = false,
    @SageIniName("HideWhenNotUnderConstruction") val hideWhenNotUnderConstruction: Boolean = false,
    @SageIniName("HideWhenUnhilighted") val hideWhenUnhilighted: Boolean = false,
    @SageIniName("HideWhenUnselected") val hideWhenUnselected: Boolean = false,
    @SageIniName("HideWhenNotProducing") val hideWhenNotProducing: Boolean = false,
    @SageIniName("ShowOnlyForAllies") val showOnlyForAllies: Boolean = false,
    @SageIniName("FadeMethod") val fadeMethod: Opaque? = null,
    @SageIniName("FadeTypeForHilighting") val fadeTypeForHilighting: Opaque? = null,
    @SageIniName("FadeTypeForUnhilighting") val fadeTypeForUnhilighting: Opaque? = null,
    @SageIniName("FadeTypeForSelection") val fadeTypeForSelection: Opaque? = null,
    @SageIniName("FadeTypeForShowing") val fadeTypeForShowing: Opaque? = null,
    @SageIniName("FadeTypeForHiding") val fadeTypeForHiding: Opaque? = null,
    @SageIniName("FadeHoldPercent") val fadeHoldPercent: Double = 0.0,
    @SageIniName("FadeInTime") val fadeInTime: Double = 0.0,
    @SageIniName("FadeOutTime") val fadeOutTime: Double = 0.0,
    @SageIniName("DisplayAtRallyPoint") val displayAtRallyPoint: Boolean = false,
    @SageIniName("ShowOnlyAfterMoveOrder") val showOnlyAfterMoveOrder: Boolean = false,
    @SageIniName("UseHouseColor") val useHouseColor: Boolean = false,
    @SageIniName("VisibleArmySizes") val visibleArmySizes: Opaque? = null,
) : SageNestedAttribute {

    companion object : SageIniBlockDescriptor<LivingWorldIconObject>(
        name = "LivingWorldIconObject",
        properties = {
            property("Model", Opaque.type) { it.model }
            property("SubObjects", Opaque.type) { it.subObjects }
            property("AnimMode", Opaque.type) { it.animMode }
            property("ZOffset", FloatValue) { it.zOffset }
            property("OrientAngle", FloatValue) { it.orientAngle }
            property("Scale", FloatValue) { it.scale }
            property("Clickable", BooleanValue) { it.clickable }
            property("Pickbox", Opaque.type) { it.pickbox }
            property("Shadow", Opaque.type) { it.shadow }
            property("HideWhenUnderConstruction", BooleanValue) { it.hideWhenUnderConstruction }
            property("HideWhenNotUnderConstruction", BooleanValue) { it.hideWhenNotUnderConstruction }
            property("HideWhenUnhilighted", BooleanValue) { it.hideWhenUnhilighted }
            property("HideWhenUnselected", BooleanValue) { it.hideWhenUnselected }
            property("HideWhenNotProducing", BooleanValue) { it.hideWhenNotProducing }
            property("ShowOnlyForAllies", BooleanValue) { it.showOnlyForAllies }
            property("FadeMethod", Opaque.type) { it.fadeMethod }
            property("FadeTypeForHilighting", Opaque.type) { it.fadeTypeForHilighting }
            property("FadeTypeForUnhilighting", Opaque.type) { it.fadeTypeForUnhilighting }
            property("FadeTypeForSelection", Opaque.type) { it.fadeTypeForSelection }
            property("FadeTypeForShowing", Opaque.type) { it.fadeTypeForShowing }
            property("FadeTypeForHiding", Opaque.type) { it.fadeTypeForHiding }
            property("FadeHoldPercent", FloatValue) { it.fadeHoldPercent }
            property("FadeInTime", FloatValue) { it.fadeInTime }
            property("FadeOutTime", FloatValue) { it.fadeOutTime }
            property("DisplayAtRallyPoint", BooleanValue) { it.displayAtRallyPoint }
            property("ShowOnlyAfterMoveOrder", BooleanValue) { it.showOnlyAfterMoveOrder }
            property("UseHouseColor", BooleanValue) { it.useHouseColor }
            property("VisibleArmySizes", Opaque.type) { it.visibleArmySizes }
        },
    )
}
