package de.darkatra.bfme2.ini.declarations

import com.intellij.openapi.application.ReadAction
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.PsiManager
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.psi.util.elementType
import com.intellij.util.indexing.FileBasedIndex
import de.darkatra.bfme2.ini.navigation.propertyAssignmentName
import de.darkatra.bfme2.ini.psi.SageEngineIniBlock
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

object SageEngineIniDeclarationLookup {

    fun findDeclarations(project: Project, name: String, expectedKinds: Set<String>): List<SageEngineIniBlock> {
        return expectedKinds.flatMap { kind -> findDeclarations(project, kind, name) }
    }

    fun findDeclarationsByName(project: Project, name: String): List<SageEngineIniBlock> {
        return SageEngineIniDeclarationSchema.declarationKinds.flatMap { kind -> findDeclarations(project, kind, name) }
    }

    fun allDeclarationNames(project: Project, expectedKinds: Set<String>): List<String> {
        return ReadAction.computeBlocking<List<String>, RuntimeException> {
            val fileBasedIndex = FileBasedIndex.getInstance()
            val scope = GlobalSearchScope.projectScope(project)

            fileBasedIndex.getAllKeys(SAGE_ENGINE_INI_DECLARATION_INDEX_ID, project)
                .asSequence()
                .filter { SageEngineIniDeclarationIndexKey.kind(it) in expectedKinds }
                .flatMap { key -> fileBasedIndex.getValues(SAGE_ENGINE_INI_DECLARATION_INDEX_ID, key, scope) }
                .filter { it.mask and SageEngineIniDeclarationIndexKey.DECLARATION != 0 }
                .map { it.displayName }
                .distinct()
                .sortedWith(String.CASE_INSENSITIVE_ORDER)
                .toList()
        }
    }

    fun findUseSites(project: Project, kind: String, name: String): List<PsiElement> {
        return withIndexedFiles(project, kind, name, SageEngineIniDeclarationIndexKey.USE_SITE) { file ->
            file.findDeclarationUseSites(kind, name)
        }
    }

    private fun findDeclarations(project: Project, kind: String, name: String): List<SageEngineIniBlock> {
        return withIndexedFiles(project, kind, name, SageEngineIniDeclarationIndexKey.DECLARATION) { file ->
            file.findDeclarationBlocks(kind, name)
        }
    }

    private fun <T : PsiElement> withIndexedFiles(
        project: Project,
        kind: String,
        name: String,
        occurrence: Int,
        collect: (PsiFile) -> Collection<T>
    ): List<T> {
        return ReadAction.computeBlocking<List<T>, RuntimeException> {
            val result = mutableListOf<T>()
            val scope = GlobalSearchScope.projectScope(project)
            val fileBasedIndex = FileBasedIndex.getInstance()

            // The key is lowercased, so a single case-insensitive lookup resolves to exactly one index key.
            val key = SageEngineIniDeclarationIndexKey.create(kind, name)

            fileBasedIndex.getFilesWithKey(SAGE_ENGINE_INI_DECLARATION_INDEX_ID, setOf(key), { virtualFile ->
                val hasOccurrence = fileBasedIndex.getFileData(SAGE_ENGINE_INI_DECLARATION_INDEX_ID, virtualFile, project)[key]
                    ?.let { it.mask and occurrence != 0 }
                    ?: false
                if (hasOccurrence) {
                    PsiManager.getInstance(project).findFile(virtualFile)?.let { file ->
                        result += collect(file)
                    }
                }
                true
            }, scope)

            result
        }
    }

    private fun PsiFile.findDeclarationBlocks(kind: String, name: String): Collection<SageEngineIniBlock> {
        return PsiTreeUtil.findChildrenOfType(this, SageEngineIniBlock::class.java)
            .asSequence()
            .filter { it.declarationKind == kind && it.name.equals(name, ignoreCase = true) }
            .toList()
    }

    private fun PsiFile.findDeclarationUseSites(kind: String, name: String): Collection<PsiElement> {
        return PsiTreeUtil.findChildrenOfType(this, PsiElement::class.java)
            .asSequence()
            .filter { it.elementType == SageEngineIniTokenTypes.VALUE }
            .filter { it.text.equals(name, ignoreCase = true) }
            .filter {
                kind in SageEngineIniDeclarationSchema.expectedKindsForPropertyValue(
                    it.propertyAssignmentName(),
                    it.text
                )
            }
            .toList()
    }
}
