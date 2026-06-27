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
import de.darkatra.bfme2.ini.psi.SageEngineIniBlock
import de.darkatra.bfme2.ini.psi.SageEngineIniComment
import de.darkatra.bfme2.ini.psi.SageEngineIniElementTypes
import de.darkatra.bfme2.ini.psi.SageEngineIniMacroStatement
import de.darkatra.bfme2.ini.psi.SageEngineIniPropertyAssignment
import de.darkatra.bfme2.ini.psi.SageEngineIniScriptBlock
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
        return when (node.elementType) {
            SageEngineIniElementTypes.BLOCK -> SageEngineIniBlock(node)
            SageEngineIniElementTypes.PROPERTY_ASSIGNMENT -> SageEngineIniPropertyAssignment(node)
            SageEngineIniElementTypes.MACRO_STATEMENT -> SageEngineIniMacroStatement(node)
            SageEngineIniElementTypes.COMMENT -> SageEngineIniComment(node)
            SageEngineIniElementTypes.SCRIPT_BLOCK -> SageEngineIniScriptBlock(node)
            else -> ASTWrapperPsiElement(node)
        }
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return SageEngineIniFile(viewProvider)
    }

    override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode): SpaceRequirements {
        return SpaceRequirements.MAY
    }
}
