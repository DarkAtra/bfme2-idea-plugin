package de.darkatra.bfme2.ini.formatting

import com.intellij.lang.ASTNode
import com.intellij.openapi.util.TextRange
import com.intellij.psi.impl.source.codeStyle.PreFormatProcessor
import de.darkatra.bfme2.ini.SageEngineIniFileType

class SageEngineIniPreFormatProcessor : PreFormatProcessor {

    override fun process(element: ASTNode, range: TextRange): TextRange {
        if (element.psi?.containingFile?.fileType != SageEngineIniFileType) {
            return range
        }
        return SageEngineIniEmptyCommentRemover.removeEmptyCommentsAtEndOfLine(element.psi.containingFile, range)
    }
}
