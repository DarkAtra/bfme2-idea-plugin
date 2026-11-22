package de.darkatra.bfme2.ini.validation

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.Annotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.psi.PsiElement
import com.intellij.psi.util.elementType
import de.darkatra.bfme2.ini.declarations.SageEngineIniDeclarationLookup
import de.darkatra.bfme2.ini.declarations.SageEngineIniModelResolver
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

class SageEngineIniDeclarationAnnotator : Annotator {

    override fun annotate(element: PsiElement, holder: AnnotationHolder) {
        if (element.elementType != SageEngineIniTokenTypes.VALUE) {
            return
        }

        val reference = SageEngineIniModelResolver.valueReference(element) ?: return
        val expectedKinds = reference.kinds
        val name = reference.name(element)

        if (SageEngineIniDeclarationLookup.findDeclarations(element.project, name, expectedKinds).isNotEmpty()) {
            return
        }

        val actualKinds = SageEngineIniDeclarationLookup.findDeclarationsByName(element.project, name)
            .mapNotNull { it.declarationKind }
            .distinct()
            .sorted()

        val message = if (actualKinds.isEmpty()) {
            "Cannot resolve ${expectedKinds.joinToString(" or ")} '$name'"
        } else {
            "Expected ${expectedKinds.joinToString(" or ")}, but '$name' is ${actualKinds.joinToString(" or ")}"
        }

        holder.newAnnotation(HighlightSeverity.WARNING, message).range(reference.range.shiftRight(element.textRange.startOffset)).create()
    }
}