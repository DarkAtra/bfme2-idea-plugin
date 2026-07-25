package de.darkatra.bfme2.ini.navigation

import com.intellij.psi.util.PsiTreeUtil
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase
import de.darkatra.bfme2.ini.declarations.SageEngineIniModelResolver
import de.darkatra.bfme2.ini.model.behaviour.AutoHealBehavior
import de.darkatra.bfme2.ini.model.draw.ModelConditionState
import de.darkatra.bfme2.ini.model.nugget.DamageNugget
import de.darkatra.bfme2.ini.model.`object`.ArmorSet
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.psi.SageEngineIniBlock
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SageEngineIniModelCompletionContributorTest : LightPlatformCodeInsightFixture4TestCase() {

    @Test
    fun `should resolve the descriptors of nested blocks and modules`() {

        myFixture.configureByText(
            "elvenmallorntree.ini",
            """
            Object ElvenMallornTree
                ArmorSet
                    Armor = TreeArmor
                End
                Behavior = AutoHealBehavior ModuleTag_Heal
                    HealingAmount = 5
                End
                Draw = W3DModelDraw ModuleTag_Draw
                    ModelConditionState = DAMAGED
                        Model = ElvenTree_D
                    End
                End
            End
            Weapon ElvenSword
                DamageNugget
                    Damage = 10
                End
            End
            """.trimIndent()
        )

        val descriptors = PsiTreeUtil.findChildrenOfType(myFixture.file, SageEngineIniBlock::class.java)
            .associate { it.declarationKind to SageEngineIniModelResolver.descriptor(it) }

        assertThat(descriptors["Object"]).isSameAs(Object)
        assertThat(descriptors["ArmorSet"]).isSameAs(ArmorSet)
        assertThat(descriptors["Behavior"]).isSameAs(AutoHealBehavior)
        assertThat(descriptors["ModelConditionState"]).isSameAs(ModelConditionState)
        assertThat(descriptors["DamageNugget"]).isSameAs(DamageNugget)
    }

    @Test
    fun `should complete property names of the enclosing block`() {

        myFixture.configureByText(
            "elvenmallorntree.ini",
            """
            Object ElvenMallornTree
                Behavior = AutoHealBehavior ModuleTag_Heal
                    Healing<caret>
                End
            End
            """.trimIndent()
        )

        assertThat(myFixture.completeBasic().map { it.lookupString }).contains("HealingAmount", "HealingDelay").doesNotContain("BuildCost")
    }

    @Test
    fun `should complete property names of top level declarations`() {

        myFixture.configureByText(
            "elvenmallorntree.ini",
            """
            Object ElvenMallornTree
                BuildCo<caret>
            End
            """.trimIndent()
        )

        assertThat(myFixture.completeBasic().map { it.lookupString }).contains("BuildCost")
    }

    @Test
    fun `should complete enum tokens`() {

        myFixture.configureByText(
            "elvenmallorntree.ini",
            """
            Object ElvenMallornTree
                KindOf = STRUCTURE <caret>
            End
            """.trimIndent()
        )

        assertThat(myFixture.completeBasic().map { it.lookupString }).contains("IMMOBILE")
    }

    @Test
    fun `should complete boolean values`() {

        myFixture.configureByText(
            "elvenmallorntree.ini",
            """
            Object ElvenMallornTree
                Behavior = AutoHealBehavior ModuleTag_Heal
                    SingleBurst = <caret>
                End
            End
            """.trimIndent()
        )

        assertThat(myFixture.completeBasic().map { it.lookupString }).containsExactlyInAnyOrder("Yes", "No")
    }
}
