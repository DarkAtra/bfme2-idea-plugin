package de.darkatra.bfme2.ini.formatting

import com.intellij.openapi.editor.impl.TrailingSpacesStripper
import com.intellij.psi.PsiDocumentManager
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.nio.charset.StandardCharsets

class SageEngineIniFormatterTest : LightPlatformCodeInsightFixture4TestCase() {

    @Test
    fun `should align properties and indent blocks`() {

        myFixture.configureByText(
            "test.ini",
            """
            ;//${'\t'}Animation state for build placement cursor
            Object ElvenMallornTreeStatue

            ; *** ART Parameters ***
                Draw  =         W3DScriptedModelDraw ModuleTag_01
        OkToChangeModelColor  = Yes
                        StaticModelLODMode             = yes
                    UseStandardModelNames= Yes

                    ExtraPublicBone   =   ARCHER01

                        DefaultModelConditionState
                Model = EBMalTreeStatu

                            ParticleSysBone = FireFlyBone FireFlies02 FollowBone:Yes
                            WeaponLaunchBone = PRIMARY ARCHER01
                End
                End

                DisplayName=          OBJECT:Statue
                Side              = Elves
                EditorSorting                   = STRUCTURE

            KindOf                       = IMMOBILE NO_COLLIDE OPTIMIZED_PROP CLEARED_BY_BUILD
                Shadow        = SHADOW_VOLUME
            End
            """.trimIndent(),
        )

        myFixture.performEditorAction("ReformatCode")

        assertThat(myFixture.file.text).isEqualToNormalizingNewlines(
            """
            ;// Animation state for build placement cursor
            Object ElvenMallornTreeStatue

                ; *** ART Parameters ***
                Draw = W3DScriptedModelDraw ModuleTag_01
                    OkToChangeModelColor  = Yes
                    StaticModelLODMode    = yes
                    UseStandardModelNames = Yes

                    ExtraPublicBone = ARCHER01

                    DefaultModelConditionState
                        Model = EBMalTreeStatu

                        ParticleSysBone  = FireFlyBone FireFlies02 FollowBone:Yes
                        WeaponLaunchBone = PRIMARY ARCHER01
                    End
                End

                DisplayName   = OBJECT:Statue
                Side          = Elves
                EditorSorting = STRUCTURE

                KindOf = IMMOBILE NO_COLLIDE OPTIMIZED_PROP CLEARED_BY_BUILD
                Shadow = SHADOW_VOLUME
            End
            """.trimIndent()
        )
    }

    @Test
    fun `should keep correctly formatted file unchanged`() {

        val correctlyFormattedFile = javaClass.getResourceAsStream("/formatting/formatted/elvenmallorntree.ini")!!
            .bufferedReader(StandardCharsets.UTF_8).readText()

        myFixture.configureByText("test.ini", correctlyFormattedFile)

        myFixture.performEditorAction("ReformatCode")

        assertThat(myFixture.file.text).isEqualToNormalizingNewlines(correctlyFormattedFile)
    }

    @Test
    fun `should format complex file correctly`() {

        val incorrectlyFormattedFile = javaClass.getResourceAsStream("/formatting/dirty/elvenmallorntree.ini")!!
            .bufferedReader(StandardCharsets.UTF_8).readText()
        val correctlyFormattedFile = javaClass.getResourceAsStream("/formatting/formatted/elvenmallorntree.ini")!!
            .bufferedReader(StandardCharsets.UTF_8).readText()

        myFixture.configureByText("test.ini", incorrectlyFormattedFile)

        myFixture.performEditorAction("ReformatCode")

        // strip trailing whitespace - this is usually done when saving the file
        @Suppress("UnstableApiUsage")
        TrailingSpacesStripper.strip(myFixture.editor.document, false, false)
        PsiDocumentManager.getInstance(myFixture.project).commitDocument(myFixture.editor.document)

        assertThat(myFixture.file.text).isEqualToNormalizingNewlines(correctlyFormattedFile)
    }

    @Test
    fun `should format very complex file correctly`() {

        val incorrectlyFormattedFile = javaClass.getResourceAsStream("/formatting/dirty/wildhordes.ini")!!
            .bufferedReader(StandardCharsets.UTF_8).readText()
        val correctlyFormattedFile = javaClass.getResourceAsStream("/formatting/formatted/wildhordes.ini")!!
            .bufferedReader(StandardCharsets.UTF_8).readText()

        myFixture.configureByText("test.ini", incorrectlyFormattedFile)

        myFixture.performEditorAction("ReformatCode")

        // strip trailing whitespace - this is usually done when saving the file
        @Suppress("UnstableApiUsage")
        TrailingSpacesStripper.strip(myFixture.editor.document, false, false)
        PsiDocumentManager.getInstance(myFixture.project).commitDocument(myFixture.editor.document)

        assertThat(myFixture.file.text).isEqualToNormalizingNewlines(correctlyFormattedFile)
    }

    @Test
    fun `should format block with optional block start correctly and should use correct whitespace character`() {

        myFixture.configureByText(
            "test.ini",
            """
            Behavior   = EmotionTrackerUpdate Module_EmotionTracker${'\t'}

            ${'\t'}TauntAndPointDistance    = INFANTRY_TAUNT_POINT_RADIUS; 350${'\t'}${'\t'}; max distance to taunted/pointed objet
                TauntAndPointUpdateDelay = 1000${'\t'}; how often scan (milliseconds)
                ${'\t'}${'\t'}TauntAndPointExcluded    = NONE
            AfraidOf                 = EMOTION_AFRAIDOF_OBJECTFILTER
                AlwaysAfraidOf               = EMOTION_ALWAYS_AFRAIDOF_OBJECTFILTER
                PointAt                   =   EMOTION_POINTAT_OBJECTFILTER
                HeroScanDistance          = 150
                FearScanDistance         = INFANTRY_FEAR_SCAN_RADIUS ;250

               AddEmotion${'\t'}= Terror_Base
                AddEmotion = Doom_Base
               AddEmotion = BraceForBeingCrushed_Base
               AddEmotion = UncontrollableFear_Base_Evil
               AddEmotion = FearIdle_Base
             AddEmotion = FearBusy_Base
               AddEmotion =${'\t'}Point_Base

             AddEmotion = OVERRIDE Taunt_Base
                            AttributeModifier = GondorFighterTaunt
        End

                ${'\t'}AddEmotion = CheerIdle_Base
            AddEmotion   = CheerBusy_Base
            ${'\t'}AddEmotion =   HeroCheerIdle_Base
            AddEmotion  = HeroCheerBusy_Base
                AddEmotion  = Alert_Base
        End
            """.trimIndent(),
        )

        myFixture.performEditorAction("ReformatCode")

        assertThat(myFixture.file.text).isEqualToNormalizingNewlines(
            """
            Behavior = EmotionTrackerUpdate Module_EmotionTracker

                TauntAndPointDistance    = INFANTRY_TAUNT_POINT_RADIUS ; 350 ; max distance to taunted/pointed objet
                TauntAndPointUpdateDelay = 1000 ; how often scan (milliseconds)
                TauntAndPointExcluded    = NONE
                AfraidOf                 = EMOTION_AFRAIDOF_OBJECTFILTER
                AlwaysAfraidOf           = EMOTION_ALWAYS_AFRAIDOF_OBJECTFILTER
                PointAt                  = EMOTION_POINTAT_OBJECTFILTER
                HeroScanDistance         = 150
                FearScanDistance         = INFANTRY_FEAR_SCAN_RADIUS ; 250

                AddEmotion = Terror_Base
                AddEmotion = Doom_Base
                AddEmotion = BraceForBeingCrushed_Base
                AddEmotion = UncontrollableFear_Base_Evil
                AddEmotion = FearIdle_Base
                AddEmotion = FearBusy_Base
                AddEmotion = Point_Base

                AddEmotion = OVERRIDE Taunt_Base
                    AttributeModifier = GondorFighterTaunt
                End

                AddEmotion = CheerIdle_Base
                AddEmotion = CheerBusy_Base
                AddEmotion = HeroCheerIdle_Base
                AddEmotion = HeroCheerBusy_Base
                AddEmotion = Alert_Base
            End
            """.trimIndent(),
        )
    }

    @Test
    fun `should remove empty comments`() {

        myFixture.configureByText(
            "test.ini",
            """
            ;
            Object TestObject ;
                //${'\t'}
                DisplayName = OBJECT:TestObject
                --
            End --
            ; Valid comment
            """.trimIndent(),
        )

        myFixture.performEditorAction("ReformatCode")

        assertThat(myFixture.file.text).isEqualToNormalizingNewlines(
            """
            ;
            Object TestObject
                //
                DisplayName = OBJECT:TestObject
                --
            End
            ; Valid comment
            """.trimIndent(),
        )
    }

    @Test
    fun `should format comment correctly`() {

        val inputToExpectedOutput = mapOf(
            ";*** AUDIO Parameters ***;" to "; *** AUDIO Parameters *** ;",
            ";,;    ;//--- NEW CHARGE ABILITY ---" to ";,;;//--- NEW CHARGE ABILITY ---",
        )

        inputToExpectedOutput.forEach { (input, expected) ->

            myFixture.configureByText("test.ini", input)

            myFixture.performEditorAction("ReformatCode")

            assertThat(myFixture.file.text).isEqualToNormalizingNewlines(expected)
        }
    }

    @Test
    fun `should format script blocks correctly`() {

        val incorrectlyFormattedFile = javaClass.getResourceAsStream("/formatting/dirty/scriptblock.ini")!!
            .bufferedReader(StandardCharsets.UTF_8).readText()
        val correctlyFormattedFile = javaClass.getResourceAsStream("/formatting/formatted/scriptblock.ini")!!
            .bufferedReader(StandardCharsets.UTF_8).readText()

        myFixture.configureByText("test.ini", incorrectlyFormattedFile)

        myFixture.performEditorAction("ReformatCode")

        // strip trailing whitespace - this is usually done when saving the file
        @Suppress("UnstableApiUsage")
        TrailingSpacesStripper.strip(myFixture.editor.document, false, false)
        PsiDocumentManager.getInstance(myFixture.project).commitDocument(myFixture.editor.document)

        assertThat(myFixture.file.text).isEqualToNormalizingNewlines(correctlyFormattedFile)
    }

    @Test
    fun `should format fxlist correctly`() {

        val incorrectlyFormattedFile = javaClass.getResourceAsStream("/formatting/dirty/fxlist.ini")!!
            .bufferedReader(StandardCharsets.UTF_8).readText()
        val correctlyFormattedFile = javaClass.getResourceAsStream("/formatting/formatted/fxlist.ini")!!
            .bufferedReader(StandardCharsets.UTF_8).readText()

        myFixture.configureByText("test.ini", incorrectlyFormattedFile)

        myFixture.performEditorAction("ReformatCode")

        // strip trailing whitespace - this is usually done when saving the file
        @Suppress("UnstableApiUsage")
        TrailingSpacesStripper.strip(myFixture.editor.document, false, false)
        PsiDocumentManager.getInstance(myFixture.project).commitDocument(myFixture.editor.document)

        assertThat(myFixture.file.text).isEqualToNormalizingNewlines(correctlyFormattedFile)
    }

    @Test
    fun `should format fxparticlesystem correctly`() {

        val incorrectlyFormattedFile = javaClass.getResourceAsStream("/formatting/dirty/fxparticlesystem.ini")!!
            .bufferedReader(StandardCharsets.UTF_8).readText()
        val correctlyFormattedFile = javaClass.getResourceAsStream("/formatting/formatted/fxparticlesystem.ini")!!
            .bufferedReader(StandardCharsets.UTF_8).readText()

        myFixture.configureByText("test.ini", incorrectlyFormattedFile)

        myFixture.performEditorAction("ReformatCode")

        // strip trailing whitespace - this is usually done when saving the file
        @Suppress("UnstableApiUsage")
        TrailingSpacesStripper.strip(myFixture.editor.document, false, false)
        PsiDocumentManager.getInstance(myFixture.project).commitDocument(myFixture.editor.document)

        assertThat(myFixture.file.text).isEqualToNormalizingNewlines(correctlyFormattedFile)
    }

    @Test
    fun `should format experiencelevels correctly`() {

        val incorrectlyFormattedFile = javaClass.getResourceAsStream("/formatting/dirty/experiencelevels.ini")!!
            .bufferedReader(StandardCharsets.UTF_8).readText()
        val correctlyFormattedFile = javaClass.getResourceAsStream("/formatting/formatted/experiencelevels.ini")!!
            .bufferedReader(StandardCharsets.UTF_8).readText()

        myFixture.configureByText("test.ini", incorrectlyFormattedFile)

        myFixture.performEditorAction("ReformatCode")

        // strip trailing whitespace - this is usually done when saving the file
        @Suppress("UnstableApiUsage")
        TrailingSpacesStripper.strip(myFixture.editor.document, false, false)
        PsiDocumentManager.getInstance(myFixture.project).commitDocument(myFixture.editor.document)

        assertThat(myFixture.file.text).isEqualToNormalizingNewlines(correctlyFormattedFile)
    }

    @Test
    fun `should format attributemodifier correctly`() {

        val incorrectlyFormattedFile = javaClass.getResourceAsStream("/formatting/dirty/attributemodifier.ini")!!
            .bufferedReader(StandardCharsets.UTF_8).readText()
        val correctlyFormattedFile = javaClass.getResourceAsStream("/formatting/formatted/attributemodifier.ini")!!
            .bufferedReader(StandardCharsets.UTF_8).readText()

        myFixture.configureByText("test.ini", incorrectlyFormattedFile)

        myFixture.performEditorAction("ReformatCode")

        // strip trailing whitespace - this is usually done when saving the file
        @Suppress("UnstableApiUsage")
        TrailingSpacesStripper.strip(myFixture.editor.document, false, false)
        PsiDocumentManager.getInstance(myFixture.project).commitDocument(myFixture.editor.document)

        assertThat(myFixture.file.text).isEqualToNormalizingNewlines(correctlyFormattedFile)
    }

    @Test
    fun `should format commandbutton correctly`() {

        val incorrectlyFormattedFile = javaClass.getResourceAsStream("/formatting/dirty/commandbutton.ini")!!
            .bufferedReader(StandardCharsets.UTF_8).readText()
        val correctlyFormattedFile = javaClass.getResourceAsStream("/formatting/formatted/commandbutton.ini")!!
            .bufferedReader(StandardCharsets.UTF_8).readText()

        myFixture.configureByText("test.ini", incorrectlyFormattedFile)

        myFixture.performEditorAction("ReformatCode")

        // strip trailing whitespace - this is usually done when saving the file
        @Suppress("UnstableApiUsage")
        TrailingSpacesStripper.strip(myFixture.editor.document, false, false)
        PsiDocumentManager.getInstance(myFixture.project).commitDocument(myFixture.editor.document)

        assertThat(myFixture.file.text).isEqualToNormalizingNewlines(correctlyFormattedFile)
    }

    @Test
    fun `should format objectcreationlist correctly`() {

        val incorrectlyFormattedFile = javaClass.getResourceAsStream("/formatting/dirty/objectcreationlist.ini")!!
            .bufferedReader(StandardCharsets.UTF_8).readText()
        val correctlyFormattedFile = javaClass.getResourceAsStream("/formatting/formatted/objectcreationlist.ini")!!
            .bufferedReader(StandardCharsets.UTF_8).readText()

        myFixture.configureByText("test.ini", incorrectlyFormattedFile)

        myFixture.performEditorAction("ReformatCode")

        // strip trailing whitespace - this is usually done when saving the file
        @Suppress("UnstableApiUsage")
        TrailingSpacesStripper.strip(myFixture.editor.document, false, false)
        PsiDocumentManager.getInstance(myFixture.project).commitDocument(myFixture.editor.document)

        assertThat(myFixture.file.text).isEqualToNormalizingNewlines(correctlyFormattedFile)
    }

    @Test
    fun `should format specialpower correctly`() {

        val incorrectlyFormattedFile = javaClass.getResourceAsStream("/formatting/dirty/specialpower.ini")!!
            .bufferedReader(StandardCharsets.UTF_8).readText()
        val correctlyFormattedFile = javaClass.getResourceAsStream("/formatting/formatted/specialpower.ini")!!
            .bufferedReader(StandardCharsets.UTF_8).readText()

        myFixture.configureByText("test.ini", incorrectlyFormattedFile)

        myFixture.performEditorAction("ReformatCode")

        // strip trailing whitespace - this is usually done when saving the file
        @Suppress("UnstableApiUsage")
        TrailingSpacesStripper.strip(myFixture.editor.document, false, false)
        PsiDocumentManager.getInstance(myFixture.project).commitDocument(myFixture.editor.document)

        assertThat(myFixture.file.text).isEqualToNormalizingNewlines(correctlyFormattedFile)
    }

    @Test
    fun `should format upgrade correctly`() {

        val incorrectlyFormattedFile = javaClass.getResourceAsStream("/formatting/dirty/upgrade.ini")!!
            .bufferedReader(StandardCharsets.UTF_8).readText()
        val correctlyFormattedFile = javaClass.getResourceAsStream("/formatting/formatted/upgrade.ini")!!
            .bufferedReader(StandardCharsets.UTF_8).readText()

        myFixture.configureByText("test.ini", incorrectlyFormattedFile)

        myFixture.performEditorAction("ReformatCode")

        // strip trailing whitespace - this is usually done when saving the file
        @Suppress("UnstableApiUsage")
        TrailingSpacesStripper.strip(myFixture.editor.document, false, false)
        PsiDocumentManager.getInstance(myFixture.project).commitDocument(myFixture.editor.document)

        assertThat(myFixture.file.text).isEqualToNormalizingNewlines(correctlyFormattedFile)
    }

    @Test
    fun `should format replacemodule correctly`() {

        val incorrectlyFormattedFile = javaClass.getResourceAsStream("/formatting/dirty/replacemodule.ini")!!
            .bufferedReader(StandardCharsets.UTF_8).readText()
        val correctlyFormattedFile = javaClass.getResourceAsStream("/formatting/formatted/replacemodule.ini")!!
            .bufferedReader(StandardCharsets.UTF_8).readText()

        myFixture.configureByText("test.ini", incorrectlyFormattedFile)

        myFixture.performEditorAction("ReformatCode")

        // strip trailing whitespace - this is usually done when saving the file
        @Suppress("UnstableApiUsage")
        TrailingSpacesStripper.strip(myFixture.editor.document, false, false)
        PsiDocumentManager.getInstance(myFixture.project).commitDocument(myFixture.editor.document)

        assertThat(myFixture.file.text).isEqualToNormalizingNewlines(correctlyFormattedFile)
    }
}
