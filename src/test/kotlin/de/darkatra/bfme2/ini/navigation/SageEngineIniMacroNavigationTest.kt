package de.darkatra.bfme2.ini.navigation

import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SageEngineIniMacroNavigationTest : LightPlatformCodeInsightFixture4TestCase() {

    @Test
    fun `should navigate from macro usages to their definition`() {

        myFixture.addFileToProject(
            "data/macros.ini",
            """
            #define MALLORN_COST 100
            #define MALLORN_HEALTH 500
            """.trimIndent()
        )
        myFixture.configureByText(
            "object.ini",
            """
            Object ElvenMallornTree
                BuildCost = mallorn_cost
                BuildTime = #MULTIPLY( MALLORN_HEALTH 2 )
            End
            """.trimIndent()
        )

        val handler = SageEngineIniMacroGotoDeclarationHandler()

        assertThat(targets(handler, "mallorn_cost")).containsExactly("MALLORN_COST")
        assertThat(targets(handler, "MALLORN_HEALTH")).containsExactly("MALLORN_HEALTH")
        assertThat(targets(handler, "ElvenMallornTree")).isEmpty()
    }

    @Test
    fun `should not navigate from macro definitions`() {

        myFixture.configureByText(
            "macros.ini",
            """
            #define MALLORN_COST 100
            """.trimIndent()
        )

        assertThat(targets(SageEngineIniMacroGotoDeclarationHandler(), "MALLORN_COST")).isEmpty()
    }

    @Test
    fun `should complete macros for numbers and booleans`() {

        myFixture.addFileToProject(
            "data/macros.ini",
            """
            #define MALLORN_COST 100
            #define MALLORN_HEALTH 500
            """.trimIndent()
        )
        myFixture.configureByText(
            "object.ini",
            """
            Object ElvenMallornTree
                BuildCost = MALL<caret>
            End
            """.trimIndent()
        )

        myFixture.completeBasic()

        assertThat(myFixture.lookupElementStrings).contains("MALLORN_COST", "MALLORN_HEALTH")
    }

    @Test
    fun `should not complete macros for references`() {

        myFixture.addFileToProject(
            "data/macros.ini",
            """
            #define MALLORN_COST 100
            #define MALLORN_HEALTH 500
            """.trimIndent()
        )
        myFixture.configureByText(
            "object.ini",
            """
            Object ElvenMallornTree
                ArmorSet
                    Armor = MALL<caret>
                End
            End
            """.trimIndent()
        )

        myFixture.completeBasic()

        assertThat(myFixture.lookupElementStrings.orEmpty()).doesNotContain("MALLORN_COST", "MALLORN_HEALTH")
    }

    private fun targets(handler: SageEngineIniMacroGotoDeclarationHandler, text: String): List<String> {
        val offset = myFixture.file.text.indexOf(text)
        val element = myFixture.file.findElementAt(offset)
        return handler.getGotoDeclarationTargets(element, offset, myFixture.editor).orEmpty().map { it.text }
    }
}
