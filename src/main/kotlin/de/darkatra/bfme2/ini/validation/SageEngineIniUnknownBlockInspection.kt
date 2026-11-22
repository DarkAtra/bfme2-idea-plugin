package de.darkatra.bfme2.ini.validation

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import de.darkatra.bfme2.ini.declarations.SageEngineIniDeclarationSchema
import de.darkatra.bfme2.ini.declarations.SageEngineIniModelResolver
import de.darkatra.bfme2.ini.model.common.SageIniBlockDescriptor
import de.darkatra.bfme2.ini.model.common.SageIniValueType
import de.darkatra.bfme2.ini.model.common.elementType
import de.darkatra.bfme2.ini.psi.SageEngineIniBlock

/**
 * Reports blocks and modules that aren't part of the model, and blocks outside the only file they are allowed in, e.g. a `MapCache` outside
 * of `mapcache.ini`. Blocks inside unknown blocks are ignored.
 */
class SageEngineIniUnknownBlockInspection : LocalInspectionTool() {

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PsiElementVisitor() {

            override fun visitElement(element: PsiElement) {
                if (element !is SageEngineIniBlock) {
                    return
                }

                val kind = element.declarationKind ?: return
                val descriptor = SageEngineIniModelResolver.descriptor(element)
                if (descriptor != null) {
                    val fileName = descriptor.fileName
                    if (fileName != null && !element.containingFile.name.equals(fileName, ignoreCase = true)) {
                        holder.registerProblem(element.firstChild, "'$kind' is only allowed in $fileName")
                    }
                    return
                }

                val parentBlock = element.parent as? SageEngineIniBlock
                if (parentBlock == null) {
                    // `.inc` files are included into other blocks, so their top level blocks can be modules like `Behavior`
                    if (!element.containingFile.name.endsWith(".inc", ignoreCase = true)) {
                        holder.registerProblem(
                            element.firstChild,
                            "Unknown block '$kind'",
                            *replaceWithSimilarNameFixes(kind, SageEngineIniDeclarationSchema.declarationKinds)
                        )
                    }
                    return
                }

                val parentDescriptor = SageEngineIniModelResolver.descriptor(parentBlock) ?: return
                val typeToken = element.nameIdentifier
                val modules = SageEngineIniModelResolver.childBlockCandidates(parentDescriptor, kind)
                if (typeToken != null && modules.isNotEmpty()) {
                    holder.registerProblem(
                        typeToken,
                        "Unknown module '${typeToken.text}' for '$kind'",
                        *replaceWithSimilarNameFixes(typeToken.text, modules.filterNot { it.isAbstract }.map { it.name })
                    )
                    return
                }

                holder.registerProblem(
                    element.firstChild,
                    "Unknown block '$kind' in '${parentDescriptor.name}'",
                    *replaceWithSimilarNameFixes(kind, childBlockNames(parentDescriptor))
                )
            }
        }
    }

    /**
     * The names that open a block inside [parent]: slots like `ArmorSet` as well as group members like the `DamageNugget` of a `Weapon`.
     */
    private fun childBlockNames(parent: SageIniBlockDescriptor<*>): List<String> {
        return parent.properties.flatMap { property ->
            val blockValue = property.type.elementType() as? SageIniValueType.BlockValue<*> ?: return@flatMap emptyList()
            listOf(property.name) + blockValue.candidates.filterNot { it.isAbstract }.map { it.name }
        }
    }
}
