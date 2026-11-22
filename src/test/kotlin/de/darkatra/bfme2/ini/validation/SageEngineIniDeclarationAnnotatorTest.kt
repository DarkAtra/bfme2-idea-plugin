package de.darkatra.bfme2.ini.validation

import com.intellij.lang.LanguageAnnotators
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase
import de.darkatra.bfme2.ini.SageEngineIniLanguage
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class SageEngineIniDeclarationAnnotatorTest : LightPlatformCodeInsightFixture4TestCase() {

    // the annotator isn't registered in the plugin.xml yet
    @Before
    fun registerAnnotator() {
        LanguageAnnotators.INSTANCE.addExplicitExtension(SageEngineIniLanguage, SageEngineIniDeclarationAnnotator(), myFixture.testRootDisposable)
    }

    @Test
    fun `should highlight unresolved declaration reference`() {

        myFixture.configureByText("commandbutton.ini", "CommandButton Command_Athelas\n    SpecialPower = MissingSpecialPower\nEnd")

        val warnings = myFixture.doHighlighting().filter { it.severity == HighlightSeverity.WARNING }

        assertThat(warnings).extracting<String> { it.description }.contains("Cannot resolve SpecialPower 'MissingSpecialPower'")
    }

    @Test
    fun `should highlight declaration reference with wrong kind`() {

        myFixture.addFileToProject("data/object.ini", "Object ElvenMallornTree\nEnd")
        myFixture.configureByText("commandbutton.ini", "CommandButton Command_Athelas\n    SpecialPower = ElvenMallornTree\nEnd")

        val warnings = myFixture.doHighlighting().filter { it.severity == HighlightSeverity.WARNING }

        assertThat(warnings).extracting<String> { it.description }.contains("Expected SpecialPower, but 'ElvenMallornTree' is Object")
    }

    @Test
    fun `should only check the words of values that reference declarations`() {

        myFixture.addFileToProject("data/fxparticlesystem.ini", "FXParticleSystem LightningCharge\nEnd")
        myFixture.addFileToProject("data/objectcreationlist.ini", "ObjectCreationList OCL_RohirrimSpawnDeadRider\nEnd")
        myFixture.configureByText(
            "object.ini",
            """
            Object RohirrimArcher
                Draw = W3DScriptedModelDraw ModuleTag_Draw
                    DefaultModelConditionState
                        ParticleSysBone = B_SWORDBONE LightningCharge FollowBone:Yes
                    End
                End
                Behavior = DetachableRiderUpdate ModuleTag_Rider
                    DeathEntry = AnimState:DEATH_2 AnimTime:3000 RiderOCL:<warning descr="Cannot resolve ObjectCreationList 'OCL_Missing'">OCL_Missing</warning>
                    DeathEntry = AnimState:DEATH_2 AnimTime:3000 RiderOCL:OCL_RohirrimSpawnDeadRider
                End
                Behavior = StructureCollapseUpdate ModuleTag_Collapse
                    OCL = INITIAL <warning descr="Cannot resolve ObjectCreationList 'OCL_StructureRubblePileLarge'">OCL_StructureRubblePileLarge</warning>
                End
                ArmorSet
                    Conditions = None
                    Armor = None
                End
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }
}
