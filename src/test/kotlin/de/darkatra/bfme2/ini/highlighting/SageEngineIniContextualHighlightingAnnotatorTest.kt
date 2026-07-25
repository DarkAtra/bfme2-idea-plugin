package de.darkatra.bfme2.ini.highlighting

import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SageEngineIniContextualHighlightingAnnotatorTest : LightPlatformCodeInsightFixture4TestCase() {

    @Test
    fun `should highlight contextual block openers as blocks`() {

        myFixture.configureByText(
            "fxparticlesystem.ini",
            """
            FXParticleSystem FireSmall
                Color = DefaultColor
                    Color1 = R:255 G:128 B:0 0
                End
            End
            """.trimIndent()
        )

        val highlights = myFixture.doHighlighting().filter { it.forcedTextAttributesKey == SageEngineIniSyntaxHighlighter.BLOCK }

        assertThat(highlights).extracting<String> { it.text }.containsExactly("Color")
    }

    @Test
    fun `should highlight contextual bare value keys as properties`() {

        myFixture.configureByText(
            "elvenmallorntree.ini",
            """
            Object ElvenMallornTree
                CommandSet ElvenMallornTreeCommandSet
            End
            """.trimIndent()
        )

        val highlights = myFixture.doHighlighting().filter { it.forcedTextAttributesKey == SageEngineIniSyntaxHighlighter.IDENTIFIER }

        assertThat(highlights).extracting<String> { it.text }.containsExactly("CommandSet")
    }

    @Test
    fun `should not add highlighting for tokens the lexer already classified correctly`() {

        myFixture.configureByText(
            "elvenmallorntree.ini",
            """
            Object ElvenMallornTree
                DisplayName = OBJECT:ElvenMallornTree
                ArmorSet
                    Conditions = None
                End
            End
            """.trimIndent()
        )

        val highlights = myFixture.doHighlighting().filter { it.forcedTextAttributesKey != null }

        assertThat(highlights).isEmpty()
    }
}
