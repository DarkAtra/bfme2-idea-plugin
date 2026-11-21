package de.darkatra.bfme2.ini.model.`object`

import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.FloatValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.value.Opaque
import de.darkatra.bfme2.ini.model.value.SageFilter
import de.darkatra.bfme2.ini.model.value.SageReference

data class FormationAssistant(
    val header: SageBlockHeader = SageBlockHeader(),
    @SageIniName("RowPadding") val rowPadding: Double = 0.0,
    @SageIniName("ColumnPadding") val columnPadding: Double = 0.0,
    @SageIniName("ActivationDragDistance") val activationDragDistance: Double = 0.0,
    @SageIniName("FacingArrowHeadTemplate") val facingArrowHeadTemplate: SageReference<Object>? = null,
    @SageIniName("FacingArrowBodyTemplate") val facingArrowBodyTemplate: SageReference<Object>? = null,
    @SageIniName("FacingArrowBaseTemplate") val facingArrowBaseTemplate: SageReference<Object>? = null,
    @SageIniName("ActivationTime") val activationTime: Double = 0.0,
    @SageIniName("DefaultPreviewObject") val defaultPreviewObject: Opaque? = null,
    @SageIniName("ValidObjectFilter") val validObjectFilter: SageFilter? = null,
    @SageIniName("FormationTemplate") val formationTemplate: List<FormationTemplate> = emptyList(),
    @SageIniName("UnitDefinition") val unitDefinition: List<UnitDefinition> = emptyList(),
    @SageIniName("FormationSelection") val formationSelection: List<FormationSelection> = emptyList(),
) : SageIniObject {

    companion object : SageIniBlockDescriptor<FormationAssistant>(
        name = "FormationAssistant",
        tableKey = "formationassistants",
        properties = {
            property("RowPadding", FloatValue) { it.rowPadding }
            property("ColumnPadding", FloatValue) { it.columnPadding }
            property("ActivationDragDistance", FloatValue) { it.activationDragDistance }
            property("FacingArrowHeadTemplate", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.facingArrowHeadTemplate }
            property("FacingArrowBodyTemplate", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.facingArrowBodyTemplate }
            property("FacingArrowBaseTemplate", ReferenceValue<Object> { listOf(Object, ChildObject, ObjectReskin) }) { it.facingArrowBaseTemplate }
            property("ActivationTime", FloatValue) { it.activationTime }
            property("DefaultPreviewObject", Opaque.type) { it.defaultPreviewObject }
            property("ValidObjectFilter", SageFilter.type) { it.validObjectFilter }
            property("FormationTemplate", ListValue(BlockValue<FormationTemplate> { listOf(FormationTemplate) })) { it.formationTemplate }
            property("UnitDefinition", ListValue(BlockValue<UnitDefinition> { listOf(UnitDefinition) })) { it.unitDefinition }
            property("FormationSelection", ListValue(BlockValue<FormationSelection> { listOf(FormationSelection) })) { it.formationSelection }
        },
    )
}
