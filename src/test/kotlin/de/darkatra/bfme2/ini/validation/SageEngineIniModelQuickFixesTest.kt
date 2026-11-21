package de.darkatra.bfme2.ini.validation

import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SageEngineIniModelQuickFixesTest : LightPlatformCodeInsightFixture4TestCase() {

    @Test
    fun `should suggest known property names for unknown properties`() {

        myFixture.enableInspections(SageEngineIniUnknownPropertyInspection())
        myFixture.configureByText(
            "object.ini",
            """
            Object ElvenMallornTree
                BuildCots<caret> = 100
            End
            """.trimIndent()
        )

        myFixture.launchAction(myFixture.findSingleIntention("Change to 'BuildCost'"))

        myFixture.checkResult(
            """
            Object ElvenMallornTree
                BuildCost = 100
            End
            """.trimIndent()
        )
    }

    @Test
    fun `should fix the casing of block keywords`() {

        myFixture.enableInspections(SageEngineIniUnknownBlockInspection())
        myFixture.configureByText("object.ini", "obj<caret>ect ElvenMallornTree\nEnd")

        myFixture.launchAction(myFixture.findSingleIntention("Change to 'Object'"))

        myFixture.checkResult("Object ElvenMallornTree\nEnd")
    }

    @Test
    fun `should fix the casing of property names`() {

        myFixture.enableInspections(SageEngineIniUnknownPropertyInspection())
        myFixture.configureByText("object.ini", "Object ElvenMallornTree\n    build<caret>cost = 100\nEnd")

        myFixture.launchAction(myFixture.findSingleIntention("Change to 'BuildCost'"))

        myFixture.checkResult("Object ElvenMallornTree\n    BuildCost = 100\nEnd")
    }

    @Test
    fun `should suggest known modules for unknown modules`() {

        myFixture.enableInspections(SageEngineIniUnknownBlockInspection())
        myFixture.configureByText(
            "object.ini",
            """
            Object ElvenMallornTree
                Behavior = AutoHealBehaviour<caret> ModuleTag_Heal
                End
            End
            """.trimIndent()
        )

        myFixture.launchAction(myFixture.findSingleIntention("Change to 'AutoHealBehavior'"))

        myFixture.checkResult(
            """
            Object ElvenMallornTree
                Behavior = AutoHealBehavior ModuleTag_Heal
                End
            End
            """.trimIndent()
        )
    }

    @Test
    fun `should insert missing equals signs`() {

        myFixture.enableInspections(SageEngineIniEqualsSignInspection())
        myFixture.configureByText(
            "object.ini",
            """
            Object IsengardUrukCrossbow
                Command<caret>Set IsengardUrukCrossbowCommandSet
            End
            """.trimIndent()
        )

        myFixture.launchAction(myFixture.findSingleIntention("Insert '='"))

        myFixture.checkResult(
            """
            Object IsengardUrukCrossbow
                CommandSet = IsengardUrukCrossbowCommandSet
            End
            """.trimIndent()
        )
    }

    @Test
    fun `should remove forbidden equals signs`() {

        myFixture.enableInspections(SageEngineIniEqualsSignInspection())
        myFixture.configureByText(
            "object.ini",
            """
            ChildObject CaveTroll_Huge CaveTroll
                RemoveModule <caret>= ModuleTag_Death
            End
            """.trimIndent()
        )

        myFixture.launchAction(myFixture.findSingleIntention("Remove '='"))

        myFixture.checkResult(
            """
            ChildObject CaveTroll_Huge CaveTroll
                RemoveModule ModuleTag_Death
            End
            """.trimIndent()
        )
    }

    @Test
    fun `should remove properties with empty value lists`() {

        myFixture.enableInspections(SageEngineIniEmptyValueListInspection())
        myFixture.configureByText(
            "object.ini",
            """
            Object AngmarHallOfTwilight
                Kind<caret>Of =
                DisplayName = OBJECT:AngmarHallOfTwilight
            End
            """.trimIndent()
        )

        myFixture.launchAction(myFixture.findSingleIntention("Remove property"))

        myFixture.checkResult(
            """
            Object AngmarHallOfTwilight
                DisplayName = OBJECT:AngmarHallOfTwilight
            End
            """.trimIndent()
        )
    }

    @Test
    fun `should suggest known blocks for unknown blocks`() {

        myFixture.enableInspections(SageEngineIniUnknownBlockInspection())
        myFixture.configureByText(
            "object.ini",
            """
            Object ElvenMallornTree
                ArmorSett<caret>
                End
            End
            Objekt ElvenMallornTree
            End
            """.trimIndent()
        )

        myFixture.launchAction(myFixture.findSingleIntention("Change to 'ArmorSet'"))
        myFixture.editor.caretModel.moveToOffset(myFixture.editor.document.text.indexOf("Objekt"))
        myFixture.launchAction(myFixture.findSingleIntention("Change to 'Object'"))

        myFixture.checkResult(
            """
            Object ElvenMallornTree
                ArmorSet
                End
            End
            Object ElvenMallornTree
            End
            """.trimIndent()
        )
    }

    @Test
    fun `should suggest known enum tokens for unknown tokens`() {

        myFixture.enableInspections(SageEngineIniInvalidValueInspection())
        myFixture.configureByText(
            "object.ini",
            """
            Object ElvenMallornTree
                KindOf = STRUCTURE -IMOBILE<caret>
            End
            """.trimIndent()
        )

        myFixture.launchAction(myFixture.findSingleIntention("Change to '-IMMOBILE'"))

        myFixture.checkResult(
            """
            Object ElvenMallornTree
                KindOf = STRUCTURE -IMMOBILE
            End
            """.trimIndent()
        )
    }

    @Test
    fun `should not suggest names that are not similar`() {

        myFixture.enableInspections(SageEngineIniUnknownPropertyInspection())
        myFixture.configureByText(
            "object.ini",
            """
            Object ElvenMallornTree
                Completely<caret>Different = 100
            End
            """.trimIndent()
        )

        assertThat(myFixture.filterAvailableIntentions("Change to")).isEmpty()
    }

    @Test
    fun `should remove repeated properties`() {

        myFixture.enableInspections(SageEngineIniRepeatedPropertyInspection())
        myFixture.configureByText(
            "object.ini",
            """
            Object ElvenMallornTree
                BuildCost<caret> = 100
                BuildTime = 10
                BuildCost = 200
            End
            """.trimIndent()
        )

        myFixture.launchAction(myFixture.findSingleIntention("Remove overridden assignment"))

        myFixture.checkResult(
            """
            Object ElvenMallornTree
                BuildTime = 10
                BuildCost = 200
            End
            """.trimIndent()
        )
    }

    @Test
    fun `should remove spurious equals signs`() {

        myFixture.enableInspections(SageEngineIniSpuriousBlockLabelInspection())
        myFixture.configureByText(
            "object.ini",
            """
            Object ElvenMallornTree
                ThreatBreakdown =<caret> ElvenMallornTree_ThreatBreakdown
                End
            End
            """.trimIndent()
        )

        myFixture.launchAction(myFixture.findSingleIntention("Remove '='"))

        myFixture.checkResult(
            """
            Object ElvenMallornTree
                ThreatBreakdown ElvenMallornTree_ThreatBreakdown
                End
            End
            """.trimIndent()
        )
    }
}
