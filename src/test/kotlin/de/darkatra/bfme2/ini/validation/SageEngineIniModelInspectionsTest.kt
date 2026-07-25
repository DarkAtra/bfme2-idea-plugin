package de.darkatra.bfme2.ini.validation

import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase
import org.junit.Test

class SageEngineIniModelInspectionsTest : LightPlatformCodeInsightFixture4TestCase() {

    @Test
    fun `should report unknown properties of known blocks`() {

        myFixture.enableInspections(SageEngineIniUnknownPropertyInspection())
        myFixture.configureByText(
            "object.ini",
            """
            Object ElvenMallornTree
                BuildCost = 100
                buildcost = 100
                <warning descr="Unknown property 'BuildCots' in 'Object'">BuildCots</warning> = 100
                Behavior = AutoHealBehavior ModuleTag_Heal
                    HealingAmount = 5
                    <warning descr="Unknown property 'BuildCost' in 'AutoHealBehavior'">BuildCost</warning> = 5
                End
            End
            CommandSet ElvenMallornTreeCommandSet
                1 = Command_ConstructElvenWarrior
            End
            UnknownBlock Foo
                Whatever = 1
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should report unknown blocks and modules`() {

        myFixture.enableInspections(SageEngineIniUnknownBlockInspection())
        myFixture.configureByText(
            "object.ini",
            """
            Object ElvenMallornTree
                ArmorSet
                    Armor = TreeArmor
                End
                <warning descr="Unknown block 'ArmorSett' in 'Object'">ArmorSett</warning>
                End
                Behavior = AutoHealBehavior ModuleTag_Heal
                End
                Behavior = <warning descr="Unknown module 'AutoHealBehaviour' for 'Behavior'">AutoHealBehaviour</warning> ModuleTag_Heal
                End
                Draw = W3DModelDraw ModuleTag_Draw
                    ModelConditionState = DAMAGED
                    End
                End
            End
            <warning descr="Unknown block 'Objekt'">Objekt</warning> Foo
                Unknown
                End
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should not report top level blocks of included files`() {

        myFixture.enableInspections(SageEngineIniUnknownBlockInspection())
        myFixture.configureByText(
            "productionbuilding.inc",
            """
            Behavior = AutoHealBehavior ModuleTag_Heal
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should report repeated properties`() {

        myFixture.enableInspections(SageEngineIniRepeatedPropertyInspection())
        myFixture.configureByText(
            "object.ini",
            """
            Object ElvenMallornTree
                <warning descr="'BuildCost' is set again later, only the last value takes effect">BuildCost</warning> = 100
                buildcost = 200
                KindOf = STRUCTURE
                KindOf = IMMOBILE
                GeometryContactPoint = X:0 Y:0 Z:0 Swoop
                GeometryContactPoint = X:10 Y:0 Z:0 Swoop
                ShadowTexture = ShadowA
                ShadowTexture = ShadowB
                Unknown = 1
                Unknown = 2
                Behavior = AutoHealBehavior ModuleTag_Heal
                    HealingAmount = 5
                End
                Behavior = AutoHealBehavior ModuleTag_Heal2
                    HealingAmount = 5
                End
            End
            CommandSet ElvenMallornTreeCommandSet
                <warning descr="'1' is set again later, only the last value takes effect">1</warning> = Command_ConstructElvenWarrior
                1 = Command_ConstructElvenArcher
                2 = Command_ConstructElvenWarrior
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should report spurious block labels`() {

        myFixture.enableInspections(SageEngineIniSpuriousBlockLabelInspection())
        myFixture.configureByText(
            "object.ini",
            """
            Object ElvenMallornTree
                ThreatBreakdown ElvenMallornTree_ThreatBreakdown
                End
                ThreatBreakdown <warning descr="'ThreatBreakdown' takes a plain header, the engine ignores the '='">=</warning> ElvenMallornTree_ThreatBreakdown
                End
                Draw = W3DModelDraw ModuleTag_Draw
                    ModelConditionState = DAMAGED
                    End
                End
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should report invalid values`() {

        myFixture.enableInspections(SageEngineIniInvalidValueInspection())
        myFixture.configureByText(
            "object.ini",
            """
            #define MALLORN_COST 100
            #define MALLORN_KINDOF STRUCTURE IMMOBILE
            Object ElvenMallornTree
                BuildCost = 100
                BuildCost = -5
                BuildCost = 50%
                BuildCost = 1.5
                BuildCost = 8.07921e+33
                BuildCost = MALLORN_COST
                BuildCost = MACRO_OF_THE_BASE_GAME
                BuildCost = #MULTIPLY( MALLORN_COST 2 )
                BuildCost = <warning descr="Expected a number but found '12abc'">12abc</warning>
                BuildCost = <warning descr="Expected a number but found '1.2.3'">1.2.3</warning>
                KindOf = STRUCTURE IMMOBILE ; a comment
                KindOf = MALLORN_KINDOF SELECTABLE
                KindOf = mallorn_kindof
                KindOf = NONE
                KindOf = STRUCTURE <warning descr="Unknown KindOf 'STRUCTUR'">STRUCTUR</warning>
                Behavior = AutoHealBehavior ModuleTag_Heal
                    SingleBurst = yes
                    SingleBurst = <warning descr="Expected Yes or No but found '1'">1</warning>
                End
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }
}
