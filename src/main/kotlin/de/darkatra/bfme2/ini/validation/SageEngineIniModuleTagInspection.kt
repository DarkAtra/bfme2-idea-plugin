package de.darkatra.bfme2.ini.validation

import com.intellij.codeInspection.LocalInspectionTool
import com.intellij.codeInspection.LocalQuickFix
import com.intellij.codeInspection.ProblemsHolder
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiElementVisitor
import de.darkatra.bfme2.ini.declarations.SageEngineIniModuleTags
import de.darkatra.bfme2.ini.psi.SageEngineIniBlock
import de.darkatra.bfme2.ini.psi.SageEngineIniPropertyAssignment

/**
 * Reports module tags that are used more than once in an object, and tags of a `RemoveModule` or `ReplaceModule` that a `ChildObject`
 * or `ObjectReskin` doesn't have at that point, e.g. because a parent object removed them. The modules of included files are part of an
 * object, and tags are only reported as unknown if all parent objects and their included files can be resolved. The module of a
 * `ReplaceModule` needs the type of the module it replaces and a new tag, otherwise the engine doesn't load the object.
 */
class SageEngineIniModuleTagInspection : LocalInspectionTool() {

    override fun buildVisitor(holder: ProblemsHolder, isOnTheFly: Boolean): PsiElementVisitor {
        return object : PsiElementVisitor() {

            override fun visitElement(element: PsiElement) {
                if (element !is SageEngineIniBlock || element.declarationKind !in SageEngineIniModuleTags.objectKinds) {
                    return
                }

                reportRepeatedTags(element, holder)
                reportReusedReplacedTags(element, holder)
                reportTagRemovals(element, holder)
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

    private fun reportReusedReplacedTags(objectBlock: SageEngineIniBlock, holder: ProblemsHolder) {
        generateSequence(objectBlock.firstChild) { it.nextSibling }
            .filterIsInstance<SageEngineIniBlock>()
            .filter { it.declarationKind == "ReplaceModule" }
            .forEach { replaceModule ->
                val replacedTag = SageEngineIniModuleTags.headerValues(replaceModule).firstOrNull()?.text ?: return@forEach
                SageEngineIniModuleTags.modules(replaceModule)
                    .mapNotNull { SageEngineIniModuleTags.headerValues(it).getOrNull(1) }
                    .filter { it.text == replacedTag }
                    .forEach { tag ->
                        holder.registerProblem(tag, "ModuleTag '$replacedTag' is the tag of the replaced module, the module of a 'ReplaceModule' needs a new tag")
                    }
            }
    }

    private fun reportTagRemovals(objectBlock: SageEngineIniBlock, holder: ProblemsHolder) {
        val parentName = SageEngineIniModuleTags.parentName(objectBlock) ?: return
        val changes = SageEngineIniModuleTags.ownTagChanges(objectBlock) ?: return
        if (changes.none { it is SageEngineIniModuleTags.TagRemoval }) {
            return
        }

        // the engine applies them to the modules read so far, so the object's own earlier modules and removals count as well
        var knownTags = SageEngineIniModuleTags.parentTags(objectBlock) ?: return
        changes.forEach { change ->
            when (change) {
                is SageEngineIniModuleTags.Tag -> knownTags = knownTags + (change.name to change.type)
                is SageEngineIniModuleTags.TagRemoval -> {
                    // unlike most values, the engine compares module tags case-sensitively
                    if (change.name !in knownTags) {
                        holder.registerProblem(
                            change.element,
                            change.range,
                            "Unknown ModuleTag '${change.name}', '$parentName' has no module with this tag",
                            *fixes(change.element, change.name, knownTags.keys)
                        )
                    } else if (change.replaceModule != null) {
                        reportOtherModuleTypes(change.replaceModule, change.name, knownTags[change.name], holder)
                    }
                    knownTags = knownTags - change.name
                }
            }
        }
    }

    private fun reportOtherModuleTypes(replaceModule: SageEngineIniBlock, replacedTag: String, replacedType: String?, holder: ProblemsHolder) {
        if (replacedType == null) {
            return
        }
        SageEngineIniModuleTags.modules(replaceModule)
            .mapNotNull { SageEngineIniModuleTags.headerValues(it).firstOrNull() }
            .filter { it.text != replacedType }
            .forEach { type ->
                holder.registerProblem(
                    type,
                    "'${type.text}' can't replace the '$replacedType' with ModuleTag '$replacedTag', the module of a 'ReplaceModule' needs the same type"
                )
            }
    }

    private fun fixes(element: PsiElement, name: String, knownTags: Collection<String>): Array<LocalQuickFix> {
        // removing a module that doesn't exist has no effect, unless the line removes other modules as well
        val removeFix = SageEngineIniRemoveAssignmentQuickFix("Remove 'RemoveModule'")
            .takeIf { element is SageEngineIniPropertyAssignment && element.valueWords().size == 1 }
        return replaceWithSimilarNameFixes(name, knownTags) + listOfNotNull(removeFix)
    }
}
