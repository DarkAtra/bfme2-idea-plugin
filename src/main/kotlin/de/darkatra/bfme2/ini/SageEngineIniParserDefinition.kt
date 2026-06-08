package de.darkatra.bfme2.ini

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.ParserDefinition.SpaceRequirements
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenSets

private val FILE_ELEMENT_TYPE = IFileElementType(SageEngineIniLanguage)

class SageEngineIniParserDefinition : ParserDefinition {

    override fun createLexer(project: Project): Lexer {
        return SageEngineIniLexer()
    }

    override fun createParser(project: Project): PsiParser {
        return SageEngineIniParser()
    }

    override fun getFileNodeType(): IFileElementType {
        return FILE_ELEMENT_TYPE
    }

    override fun getCommentTokens(): TokenSet {
        return SageEngineIniTokenSets.COMMENTS
    }

    override fun getStringLiteralElements(): TokenSet {
        return SageEngineIniTokenSets.STRINGS
    }

    override fun createElement(node: ASTNode): PsiElement {
        return ASTWrapperPsiElement(node)
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return SageEngineIniFile(viewProvider)
    }

    override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode): SpaceRequirements {
        return SpaceRequirements.MAY
    }
}
