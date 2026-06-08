package de.darkatra.bfme2.ini

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.psi.tree.IElementType

class SageEngineIniParser : PsiParser {

    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {

        val file = builder.mark()
        while (!builder.eof()) {
            builder.advanceLexer()
        }
        file.done(root)

        return builder.treeBuilt
    }
}
