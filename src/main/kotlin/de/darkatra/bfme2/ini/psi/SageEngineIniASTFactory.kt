package de.darkatra.bfme2.ini.psi

import com.intellij.lang.ASTFactory
import com.intellij.psi.ContributedReferenceHost
import com.intellij.psi.PsiReference
import com.intellij.psi.impl.source.resolve.reference.ReferenceProvidersRegistry
import com.intellij.psi.impl.source.tree.LeafElement
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.psi.tree.IElementType

class SageEngineIniASTFactory : ASTFactory() {

    override fun createLeaf(type: IElementType, text: CharSequence): LeafElement? {
        if (type == SageEngineIniTokenTypes.VALUE || type == SageEngineIniTokenTypes.STRING) {
            return SageEngineIniReferenceHostLeaf(type, text)
        }
        return null
    }
}

/**
 * The platform only asks `PsiReferenceContributor`s for the references of elements that implement [ContributedReferenceHost].
 */
class SageEngineIniReferenceHostLeaf(
    type: IElementType,
    text: CharSequence
) : LeafPsiElement(type, text), ContributedReferenceHost {

    override fun getReferences(): Array<PsiReference> {
        return ReferenceProvidersRegistry.getReferencesFromProviders(this)
    }
}
