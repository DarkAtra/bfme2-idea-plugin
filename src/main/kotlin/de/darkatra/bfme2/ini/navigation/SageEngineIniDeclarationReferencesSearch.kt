package de.darkatra.bfme2.ini.navigation

import com.intellij.openapi.application.ReadAction
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiReference
import com.intellij.psi.search.searches.ReferencesSearch
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.util.Processor
import com.intellij.util.QueryExecutor
import de.darkatra.bfme2.ini.declarations.SageEngineIniDeclarationLookup
import de.darkatra.bfme2.ini.declarations.SageEngineIniDeclarationSchema
import de.darkatra.bfme2.ini.psi.SageEngineIniBlock

class SageEngineIniDeclarationReferencesSearch : QueryExecutor<PsiReference, ReferencesSearch.SearchParameters> {

    override fun execute(queryParameters: ReferencesSearch.SearchParameters, consumer: Processor<in PsiReference>): Boolean {
        val searchRequest = ReadAction.computeBlocking<SearchRequest?, RuntimeException> {
            val declaration = queryParameters.elementToSearch.declarationBlock() ?: return@computeBlocking null
            val declarationKind = declaration.declarationKind ?: return@computeBlocking null
            val declarationName = declaration.name ?: return@computeBlocking null

            if (!SageEngineIniDeclarationSchema.isDeclarationKind(declarationKind)) {
                return@computeBlocking null
            }

            SearchRequest(declaration.project, declarationKind, declarationName)
        } ?: return true

        return ReadAction.computeBlocking<Boolean, RuntimeException> {
            SageEngineIniDeclarationLookup.findUseSites(searchRequest.project, searchRequest.declarationKind, searchRequest.declarationName)
                .all { useSite ->
                    val reference = SageEngineIniDeclarationReference(useSite, setOf(searchRequest.declarationKind))
                    consumer.process(reference)
                }
        }
    }

    private data class SearchRequest(
        val project: Project,
        val declarationKind: String,
        val declarationName: String
    )

    private fun PsiElement.declarationBlock(): SageEngineIniBlock? {
        return when (this) {
            is SageEngineIniBlock -> this
            else -> PsiTreeUtil.getParentOfType(this, SageEngineIniBlock::class.java, false)
        }
    }
}