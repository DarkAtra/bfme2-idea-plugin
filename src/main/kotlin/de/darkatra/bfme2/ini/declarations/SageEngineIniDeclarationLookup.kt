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
            FileBasedIndex.getInstance().getAllKeys(SAGE_ENGINE_INI_DECLARATION_INDEX_ID, project)
                .asSequence()
                .filter { SageEngineIniDeclarationIndexKey.kind(it) in expectedKinds }
                .map { SageEngineIniDeclarationIndexKey.declarationName(it) }
                .distinct()
                .sortedWith(String.CASE_INSENSITIVE_ORDER)
                .toList()
        }
    }

    fun findUseSites(project: Project, kind: String, name: String): List<PsiElement> {
        return ReadAction.computeBlocking<List<PsiElement>, RuntimeException> {
            val result = mutableListOf<PsiElement>()
            val key = SageEngineIniDeclarationUseSiteIndex.key(kind, name)
            val scope = GlobalSearchScope.projectScope(project)

            FileBasedIndex.getInstance().getFilesWithKey(SageEngineIniDeclarationUseSiteIndex.NAME, setOf(key), { virtualFile ->
                PsiManager.getInstance(project).findFile(virtualFile)?.let { file ->
                    result += file.findDeclarationUseSites(kind, name)
                }
                true
            }, scope)

            result
        }
    }

    private fun findDeclarations(project: Project, kind: String, name: String): List<SageEngineIniBlock> {
        return ReadAction.computeBlocking<List<SageEngineIniBlock>, RuntimeException> {
            val result = mutableListOf<SageEngineIniBlock>()
            val key = SageEngineIniDeclarationIndexKey.create(kind, name)
            val scope = GlobalSearchScope.projectScope(project)

            FileBasedIndex.getInstance().getFilesWithKey(SAGE_ENGINE_INI_DECLARATION_INDEX_ID, setOf(key), { virtualFile ->
                PsiManager.getInstance(project).findFile(virtualFile)?.let { file ->
                    result += file.findDeclarationBlocks(kind, name)
                }
                true
            }, scope)

            result
        }
    }

    private fun PsiFile.findDeclarationBlocks(kind: String, name: String): Collection<SageEngineIniBlock> {
        return PsiTreeUtil.findChildrenOfType(this, SageEngineIniBlock::class.java)
            .asSequence()
            .filter { it.declarationKind == kind && it.name == name }
            .toList()
    }

    private fun PsiFile.findDeclarationUseSites(kind: String, name: String): Collection<PsiElement> {
        return PsiTreeUtil.findChildrenOfType(this, PsiElement::class.java)
            .asSequence()
            .filter { it.elementType == SageEngineIniTokenTypes.VALUE }
            .filter { it.text == name }
            .filter { kind in SageEngineIniDeclarationSchema.expectedKindsForProperty(it.propertyAssignmentName()) }
            .toList()
    }
}