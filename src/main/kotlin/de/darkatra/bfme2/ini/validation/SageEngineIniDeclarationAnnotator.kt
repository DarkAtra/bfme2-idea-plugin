package de.darkatra.bfme2.ini.validation

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import de.darkatra.bfme2.ini.declarations.SageEngineIniDeclarationLookup
import de.darkatra.bfme2.ini.declarations.SageEngineIniDeclarationSchema
import de.darkatra.bfme2.ini.navigation.propertyAssignmentName
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

class SageEngineIniDeclarationAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.elementType != SageEngineIniTokenTypes.VALUE) {
            return
        }

        val expectedKinds = SageEngineIniDeclarationSchema.expectedKindsForPropertyValue(
            element.propertyAssignmentName(),
            element.text
        )
        if (expectedKinds.isEmpty()) {
            return
        }

        if (SageEngineIniDeclarationLookup.findDeclarations(element.project, element.text, expectedKinds).isNotEmpty()) {
            return
        }

        val actualKinds = SageEngineIniDeclarationLookup.findDeclarationsByName(element.project, element.text)
            .mapNotNull { it.declarationKind }
            .distinct()
            .sorted()

        val message = if (actualKinds.isEmpty()) {
            "Cannot resolve ${expectedKinds.joinToString(" or ")} '${element.text}'"
        } else {
            "Expected ${expectedKinds.joinToString(" or ")}, but '${element.text}' is ${actualKinds.joinToString(" or ")}"
        }

        holder.newAnnotation(HighlightSeverity.WARNING, message).range(element).create()
    }
}