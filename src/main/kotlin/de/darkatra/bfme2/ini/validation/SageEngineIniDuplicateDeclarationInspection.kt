package de.darkatra.bfme2.ini.validation

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import com.intellij.psi.PsiFile
import de.darkatra.bfme2.ini.declarations.SageEngineIniDeclarationLookup
import de.darkatra.bfme2.ini.declarations.SageEngineIniDeclarationSchema
import de.darkatra.bfme2.ini.model.SageIniModel
import de.darkatra.bfme2.ini.psi.SageEngineIniBlock

/**
 * Reports declarations whose name is declared again with the same kind in the same source, e.g. two `Object ElvenMallornTree` in a mod.
 * Declarations that override others on purpose are fine: those of a mod that override the base game, those of the files in `default`
 * directories, which the engine reads before the files that override them, and those of a map's `map.ini`.
 */
class SageEngineIniDuplicateDeclarationInspection : LocalInspectionTool() {

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PsiElementVisitor() {

            override fun visitElement(element: PsiElement) {
                if (element !is SageEngineIniBlock || element.parent !is PsiFile || isOverridable(element.containingFile)) {
                    return
                }

                val kind = element.declarationKind ?: return
                if (!SageEngineIniDeclarationSchema.isDeclarationKind(kind) || SageIniModel.block(kind)?.uniqueName == false) {
                    return
                }

                val name = element.name ?: return
                // most names are declared once, which the index tells without reading the declarations of other files
                val ownFile = element.containingFile.virtualFile
                if (ownFile != null &&
                    SageEngineIniDeclarationLookup.declaringFiles(element.project, name, kind) == listOf(ownFile) &&
                    SageEngineIniDeclarationLookup.declarationsInFile(element.containingFile, kind, name).size < 2
                ) {
                    return
                }

                val declarations = SageEngineIniDeclarationLookup.findDeclarations(element.project, name, setOf(kind))
                    .filter { it.parent is PsiFile && !isOverridable(it.containingFile) }
                // declarations of a source with a lower priority are overridden
                if (element !in declarations) {
                    return
                }

                val others = declarations.filter { it != element }
                if (others.isNotEmpty()) {
                    val locations = others.map { location(element, it) }.distinct().joinToString()
                    holder.registerProblem(element.nameIdentifier ?: element.firstChild, "'$name' is declared more than once, also in $locations")
                }
            }
        }
    }

    private fun isOverridable(file: PsiFile): Boolean {
        return file.name.equals("map.ini", ignoreCase = true) || file.virtualFile?.parent?.name.equals("default", ignoreCase = true)
    }

    private fun location(element: SageEngineIniBlock, other: SageEngineIniBlock): String {
        val file = other.containingFile
        val document = file.viewProvider.document ?: return file.name
        val line = document.getLineNumber(other.textOffset) + 1
        return if (file == element.containingFile) "line $line" else "${file.name}:$line"
    }
}
