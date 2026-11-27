package de.darkatra.bfme2.ini.validation

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import de.darkatra.bfme2.ini.declarations.SageEngineIniModuleTags
import de.darkatra.bfme2.ini.psi.SageEngineIniBlock
import de.darkatra.bfme2.ini.psi.SageEngineIniPropertyAssignment

/**
 * Reports module tags that are used more than once in an object, and tags of a `RemoveModule` or `ReplaceModule` that a `ChildObject`
 * or `ObjectReskin` doesn't inherit. The modules of included files are part of an object, and tags are only reported as unknown if all
 * parent objects and their included files can be resolved.
 */
class SageEngineIniModuleTagInspection : LocalInspectionTool() {

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PsiElementVisitor() {

            override fun visitElement(element: PsiElement) {
                if (element !is SageEngineIniBlock || element.declarationKind !in SageEngineIniModuleTags.objectKinds) {
                    return
                }

                reportRepeatedTags(element, holder)
                reportUnknownTags(element, holder)
            }
        }
    }

    private fun reportRepeatedTags(objectBlock: SageEngineIniBlock, holder: ProblemsHolder) {
        SageEngineIniModuleTags.ownTags(objectBlock).tags
            .groupBy { it.name }
            .filterValues { it.size > 1 }
            .forEach { (name, tags) ->
                tags.drop(1).map { it.anchor }.distinct().forEach { anchor ->
                    holder.registerProblem(anchor, "ModuleTag '$name' is used more than once in '${objectBlock.name}'")
                }
            }
    }

    private fun reportUnknownTags(objectBlock: SageEngineIniBlock, holder: ProblemsHolder) {
        val parentName = SageEngineIniModuleTags.parentName(objectBlock) ?: return
        val references = tagReferences(objectBlock)
        if (references.isEmpty()) {
            return
        }

        val parentTags = SageEngineIniModuleTags.parentTags(objectBlock) ?: return
        val ownTags = SageEngineIniModuleTags.ownTags(objectBlock).tags
        references.forEach { (element, range, name) ->
            // the engine applies them to the modules read so far, so the object's own earlier modules count as well
            val offset = element.textRange.startOffset + range.startOffset
            val known = name.lowercase() in parentTags || ownTags.any { it.anchor.textRange.startOffset < offset && it.name.equals(name, ignoreCase = true) }
            if (!known) {
                holder.registerProblem(element, range, "Unknown ModuleTag '$name', '$parentName' has no module with this tag")
            }
        }
    }

    // e.g. `RemoveModule ModuleTag_Death` and `ReplaceModule ModuleTag_Draw`
    private fun tagReferences(objectBlock: SageEngineIniBlock): List<Triple<PsiElement, TextRange, String>> {
        return generateSequence(objectBlock.firstChild) { it.nextSibling }.flatMap { child ->
            when {
                child is SageEngineIniPropertyAssignment && child.propertyName == "RemoveModule" -> {
                    child.valueWords().map { Triple(child, it.range, it.text) }
                }

                child is SageEngineIniBlock && child.declarationKind == "ReplaceModule" -> {
                    SageEngineIniModuleTags.headerValues(child).take(1).map { Triple(it, TextRange(0, it.textLength), it.text) }
                }

                else -> emptyList()
            }
        }.toList()
    }
}
