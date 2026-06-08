package de.darkatra.bfme2.ini.formatting

import com.intellij.formatting.FormattingContext
import com.intellij.formatting.FormattingModel
import com.intellij.formatting.FormattingModelBuilder
import com.intellij.formatting.FormattingModelProvider
import com.intellij.formatting.Indent

class SageEngineIniFormattingModelBuilder : FormattingModelBuilder {

    override fun createModel(formattingContext: FormattingContext): FormattingModel {

        val block = SageEngineIniFormattingBlock(
            formattingContext.node,
            formattingContext.codeStyleSettings,
            Indent.getNoneIndent(),
            null,
        )

        return FormattingModelProvider.createFormattingModelForPsiFile(
            formattingContext.containingFile,
            block,
            formattingContext.codeStyleSettings,
        )
    }
}

