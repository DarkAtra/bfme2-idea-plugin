package de.darkatra.bfme2.ini

import com.intellij.psi.PsiComment
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiErrorElement
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase
import de.darkatra.bfme2.ini.folding.SageEngineIniFoldingBuilder
import de.darkatra.bfme2.ini.psi.SageEngineIniBlock
import de.darkatra.bfme2.ini.psi.SageEngineIniMacroStatement
import de.darkatra.bfme2.ini.psi.SageEngineIniPropertyAssignment
import de.darkatra.bfme2.ini.psi.SageEngineIniScriptBlock
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.nio.charset.StandardCharsets

class SageEngineIniParserTest : LightPlatformCodeInsightFixture4TestCase() {

    @Test
    fun `should create PSI elements for top level statements`() {

        myFixture.configureByText(
            "elvenmallorntree.ini",
            """
            ; Mallorn tree
            #include "includes\StandardBuildingEvaEvents.inc"
            Object ElvenMallornTree
                DisplayName = OBJECT:ElvenMallornTree
            End
            """.trimIndent()
        )

        assertThat(myFixture.file.descendantsOfType(PsiComment::class.java)).extracting<String> { it.text }
            .contains(";", "Mallorn", "tree")
        assertThat(myFixture.file.descendantsOfType(SageEngineIniMacroStatement::class.java)).hasSize(1)
        assertThat(myFixture.file.descendantsOfType(SageEngineIniBlock::class.java)).extracting<String> { it.text.trim() }
            .contains("Object ElvenMallornTree\n    DisplayName = OBJECT:ElvenMallornTree\nEnd")
        assertThat(myFixture.file.descendantsOfType(SageEngineIniPropertyAssignment::class.java)).extracting<String> { it.text.trim() }
            .contains("DisplayName = OBJECT:ElvenMallornTree")
    }

    @Test
    fun `should create a script block PSI element`() {

        myFixture.configureByText(
            "script.ini",
            """
            BeginScript
                if Flag
                then
                    BeginScript
                        nested
                    EndScript
                end
            EndScript
            After = EndScript
            """.trimIndent()
        )

        val scriptBlocks = myFixture.file.descendantsOfType(SageEngineIniScriptBlock::class.java)

        assertThat(scriptBlocks).hasSize(1)
        assertThat(scriptBlocks.single().text.trim()).startsWith("BeginScript")
        assertThat(scriptBlocks.single().text.trim()).endsWith("EndScript")
        assertThat(myFixture.file.descendantsOfType(SageEngineIniPropertyAssignment::class.java)).extracting<String> { it.text.trim() }
            .contains("After = EndScript")
    }

    @Test
    fun `should create folding regions for blocks`() {

        myFixture.configureByText(
            "elvenmallorntree.ini",
            """
            Object ElvenMallornTree
                DisplayName = OBJECT:ElvenMallornTree
            End
            """.trimIndent()
        )

        val document = PsiDocumentManager.getInstance(project).getDocument(myFixture.file)!!
        val descriptors = SageEngineIniFoldingBuilder().buildFoldRegions(myFixture.file, document, false)

        assertThat(descriptors).extracting<String> { it.element.text.trim() }
            .contains("Object ElvenMallornTree\n    DisplayName = OBJECT:ElvenMallornTree\nEnd")
    }

    @Test
    fun `should create folding regions for script blocks`() {

        myFixture.configureByText(
            "script.ini",
            """
            BeginScript
                CurDrawableAllowToContinue()
            EndScript
            """.trimIndent()
        )

        val document = PsiDocumentManager.getInstance(project).getDocument(myFixture.file)!!
        val descriptors = SageEngineIniFoldingBuilder().buildFoldRegions(myFixture.file, document, false)

        assertThat(descriptors).extracting<String> { it.element.text.trim() }
            .contains("BeginScript\n    CurDrawableAllowToContinue()\nEndScript")
    }

    @Test
    fun `should nest blocks that are opened by bare lines`() {

        myFixture.configureByText(
            "elvenmallorntree.ini",
            """
            Object ElvenMallornTree
                ArmorSet
                    Conditions = None
                    Armor      = TreeArmor
                End
                Prerequisites
                    Object = ElvenCastle
                End
                RemoveModule ModuleTag_Death
            End
            """.trimIndent()
        )

        val objectBlock = myFixture.file.descendantsOfType(SageEngineIniBlock::class.java).single { it.declarationKind == "Object" }

        assertThat(objectBlock.childBlocks()).extracting<String?> { it.declarationKind }.containsExactly("ArmorSet", "Prerequisites")
        assertThat(objectBlock.childProperties()).extracting<String?> { it.propertyName }.containsExactly("RemoveModule")
        assertThat(PsiTreeUtil.findChildrenOfType(myFixture.file, PsiErrorElement::class.java)).isEmpty()
    }

    @Test
    fun `should open contextual blocks only inside their parent block`() {

        myFixture.configureByText(
            "fxparticlesystem.ini",
            """
            FXParticleSystem FireSmall
                Color = DefaultColor
                    Color1 = R:255 G:128 B:0 0
                End
                Update = DefaultUpdate
                    SizeRate = 0.1 0.2
                End
            End
            Object Torch
                Draw = W3DModelDraw ModuleTag_Draw
                    Color = R:64 G:64 B:96
                End
            End
            """.trimIndent()
        )

        val particleSystem = myFixture.file.descendantsOfType(SageEngineIniBlock::class.java).single { it.declarationKind == "FXParticleSystem" }
        val draw = myFixture.file.descendantsOfType(SageEngineIniBlock::class.java).single { it.declarationKind == "Draw" }

        assertThat(particleSystem.childBlocks()).extracting<String?> { it.declarationKind }.containsExactly("Color", "Update")
        assertThat(particleSystem.childBlocks().first().name).isEqualTo("DefaultColor")
        assertThat(draw.childProperties()).extracting<String?> { it.propertyName }.containsExactly("Color")
        assertThat(PsiTreeUtil.findChildrenOfType(myFixture.file, PsiErrorElement::class.java)).isEmpty()
    }

    @Test
    fun `should treat contextual bare value keys as properties inside their parent block`() {

        myFixture.configureByText(
            "commandset.ini",
            """
            CommandSet ElvenMallornTreeCommandSet
                1 = Command_ConstructElvenWarrior
            End
            Object ElvenMallornTree
                CommandSet ElvenMallornTreeCommandSet
                DisplayName = OBJECT:ElvenMallornTree
            End
            """.trimIndent()
        )

        val blocks = myFixture.file.descendantsOfType(SageEngineIniBlock::class.java)
        val commandSet = blocks.single { it.declarationKind == "CommandSet" }
        val objectBlock = blocks.single { it.declarationKind == "Object" }

        assertThat(commandSet.childProperties()).extracting<String?> { it.propertyName }.containsExactly("1")
        assertThat(objectBlock.childBlocks()).isEmpty()
        assertThat(objectBlock.childProperties()).extracting<String?> { it.propertyName }.containsExactly("CommandSet", "DisplayName")
        assertThat(PsiTreeUtil.findChildrenOfType(myFixture.file, PsiErrorElement::class.java)).isEmpty()
    }

    @Test
    fun `should report unclosed blocks and stray block ends`() {

        myFixture.configureByText(
            "broken.ini",
            """
            Object ElvenMallornTree
                DisplayName = OBJECT:ElvenMallornTree
            End
            End
            Weapon ElvenBow
                PrimaryDamage = 10
            """.trimIndent()
        )

        assertThat(PsiTreeUtil.findChildrenOfType(myFixture.file, PsiErrorElement::class.java)).extracting<String> { it.errorDescription }
            .containsExactly("'End' without an open block", "Missing 'End' for block 'Weapon'")
    }

    @Test
    fun `should parse real world files without errors`() {

        listOf(
            "attributemodifier.ini",
            "commandbutton.ini",
            "elvenmallorntree.ini",
            "experiencelevels.ini",
            "fxlist.ini",
            "fxparticlesystem.ini",
            "objectcreationlist.ini",
            "replacemodule.ini",
            "scriptblock.ini",
            "specialpower.ini",
            "upgrade.ini",
            "wildhordes.ini",
        ).forEach { fileName ->
            val text = javaClass.getResourceAsStream("/formatting/formatted/$fileName")!!
                .bufferedReader(StandardCharsets.UTF_8).readText()

            myFixture.configureByText(fileName, text)

            assertThat(PsiTreeUtil.findChildrenOfType(myFixture.file, PsiErrorElement::class.java))
                .describedAs(fileName)
                .extracting<String> { it.errorDescription }
                .isEmpty()
        }
    }

    private fun SageEngineIniBlock.childBlocks(): List<SageEngineIniBlock> {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, SageEngineIniBlock::class.java)
    }

    private fun SageEngineIniBlock.childProperties(): List<SageEngineIniPropertyAssignment> {
        return PsiTreeUtil.getChildrenOfTypeAsList(this, SageEngineIniPropertyAssignment::class.java)
    }

    private fun <T : PsiElement> PsiElement.descendantsOfType(type: Class<T>): Collection<T> {
        return PsiTreeUtil.findChildrenOfType(this, type)
    }
}
