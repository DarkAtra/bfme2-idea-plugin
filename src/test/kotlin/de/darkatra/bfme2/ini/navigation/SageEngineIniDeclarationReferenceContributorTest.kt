package de.darkatra.bfme2.ini.navigation

import com.intellij.codeInsight.TargetElementUtil
import com.intellij.codeInsight.navigation.actions.GotoDeclarationAction
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.application.ReadAction
import com.intellij.openapi.command.WriteCommandAction
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.impl.source.tree.LeafPsiElement
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.search.searches.ReferencesSearch
import com.intellij.psi.util.PsiTreeUtil
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase
import de.darkatra.bfme2.ini.declarations.SageEngineIniDeclarationLookup
import de.darkatra.bfme2.ini.psi.SageEngineIniBlock
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SageEngineIniDeclarationReferenceContributorTest : LightPlatformCodeInsightFixture4TestCase() {

    @Test
    fun `should expose declaration kind and name from block PSI`() {

        myFixture.configureByText(
            "specialpower.ini",
            """
            SpecialPower SpecialAbilityAragornAthelas
                Enum = SPECIAL_ATHELAS
            End
            """.trimIndent()
        )

        val block = PsiTreeUtil.findChildOfType(myFixture.file, SageEngineIniBlock::class.java)!!

        assertThat(block.declarationKind).isEqualTo("SpecialPower")
        assertThat(block.name).isEqualTo("SpecialAbilityAragornAthelas")
        assertThat(block.nameIdentifier?.text).isEqualTo("SpecialAbilityAragornAthelas")
        assertThat(block.textOffset).isEqualTo(block.nameIdentifier!!.textOffset)
        assertThat(
            SageEngineIniDeclarationTargetElementEvaluator().adjustTargetElement(
                myFixture.editor,
                block.textOffset,
                TargetElementUtil.ELEMENT_NAME_ACCEPTED,
                block
            )
        ).isSameAs(block.nameIdentifier)
    }

    @Test
    fun `should find declarations again after the declaring file changes`() {

        val file = myFixture.addFileToProject("specialpower.ini", "SpecialPower SpecialAbilityAragornAthelas\nEnd\n")

        assertThat(SageEngineIniDeclarationLookup.findDeclarations(project, "SpecialAbilityAragornAthelas", setOf("SpecialPower"))).hasSize(1)

        myFixture.configureFromExistingVirtualFile(file.virtualFile)
        WriteCommandAction.runWriteCommandAction(project) {
            myFixture.editor.document.setText("SpecialPower SpecialAbilityAragornRenamed\nEnd\n")
        }
        PsiDocumentManager.getInstance(project).commitAllDocuments()

        assertThat(SageEngineIniDeclarationLookup.findDeclarations(project, "SpecialAbilityAragornAthelas", setOf("SpecialPower"))).isEmpty()
        assertThat(SageEngineIniDeclarationLookup.findDeclarations(project, "SpecialAbilityAragornRenamed", setOf("SpecialPower")))
            .extracting<String?> { it.name }
            .containsExactly("SpecialAbilityAragornRenamed")
    }

    @Test
    fun `should not treat first property value as block name`() {

        listOf(
            """
            WeaponSet
                Conditions = WEAPONSET_TOGGLE_<caret>1
                Weapon = PRIMARY ElvenEliteArcherSword
            End
            """,
            """
            ArmorSet
                Conditions = No<caret>ne
                Armor = ToughHeroArmor
            End
            """
        ).forEach { content ->
            myFixture.configureByText("test.ini", content.trimIndent())

            val block = PsiTreeUtil.findChildOfType(myFixture.file, SageEngineIniBlock::class.java)!!
            val target = TargetElementUtil.findTargetElement(
                myFixture.editor,
                TargetElementUtil.ELEMENT_NAME_ACCEPTED or TargetElementUtil.REFERENCED_ELEMENT_ACCEPTED
            )

            assertThat(block.nameIdentifier).isNull()
            assertThat(target).isNull()
        }
    }

    @Test
    fun `should not expose non-declaration block keywords as navigation targets`() {

        listOf("<caret>ParticleSystem", "<caret>Sound").forEach { nestedBlock ->
            myFixture.configureByText(
                "fxlist.ini",
                """
                FXList FX_GaladrielTerribleFuryFearBlast
                    $nestedBlock
                        Name = GaladrielFearBlast
                    End
                End
                """.trimIndent()
            )

            val target = TargetElementUtil.findTargetElement(
                myFixture.editor,
                TargetElementUtil.ELEMENT_NAME_ACCEPTED or TargetElementUtil.REFERENCED_ELEMENT_ACCEPTED
            )
            val blockKeyword = PsiTreeUtil.findChildrenOfType(myFixture.file, SageEngineIniBlock::class.java)
                .single { it.declarationKind in setOf("ParticleSystem", "Sound") }
                .firstChild
            val adjustedTarget = SageEngineIniDeclarationTargetElementEvaluator().adjustTargetElement(
                myFixture.editor,
                blockKeyword.textOffset,
                TargetElementUtil.ELEMENT_NAME_ACCEPTED,
                blockKeyword
            )
            val ctrlMouseData = GotoDeclarationAction().getCtrlMouseData(
                myFixture.editor,
                myFixture.file,
                myFixture.caretOffset
            )

            assertThat(target).isNull()
            assertThat(adjustedTarget).isNull()
            assertThat(ctrlMouseData).isNull()
        }
    }

    @Test
    fun `should not expose non-declaration block names as navigation targets`() {

        myFixture.configureByText(
            "animation.ini",
            """
            Animation = <caret>Moving
                AnimationName = MuDrmTroll_TRNL
                AnimationMode = LOOP
                AnimationBlendTime = 10
            End
            """.trimIndent()
        )

        val ctrlMouseData = GotoDeclarationAction().getCtrlMouseData(
            myFixture.editor,
            myFixture.file,
            myFixture.caretOffset
        )

        assertThat(ctrlMouseData).isNull()
    }

    @Test
    fun `should only reference the entity value in qualified weapon assignments`() {

        myFixture.addFileToProject("data/weapon.ini", "Weapon ElvenEliteArcherSword\nEnd")
        myFixture.configureByText(
            "object.ini",
            """
            WeaponSet
                Weapon = PRI<caret>MARY ElvenEliteArcherSword
            End
            """.trimIndent()
        )

        val values = PsiTreeUtil.findChildrenOfType(myFixture.file, LeafPsiElement::class.java)
        val qualifier = values.single { it.text == "PRIMARY" }
        val weapon = values.single { it.text == "ElvenEliteArcherSword" }
        val handler = SageEngineIniDeclarationGotoDeclarationHandler()

        assertThat(handler.getGotoDeclarationTargets(qualifier, qualifier.textOffset, myFixture.editor)).isNull()
        assertThat(handler.getGotoDeclarationTargets(weapon, weapon.textOffset, myFixture.editor))
            .extracting<String> { it.text }
            .containsExactly("ElvenEliteArcherSword")
    }

    @Test
    fun `should reference an unqualified weapon assignment`() {

        myFixture.addFileToProject("data/weapon.ini", "Weapon AutoResolve_GoblinWarriorWeapon\nEnd")
        myFixture.configureByText("object.ini", "Weapon = AutoResolve_Goblin<caret>WarriorWeapon")

        val weapon = myFixture.file.findElementAt(myFixture.caretOffset)
        val targets = SageEngineIniDeclarationGotoDeclarationHandler().getGotoDeclarationTargets(
            weapon,
            myFixture.caretOffset,
            myFixture.editor
        )

        assertThat(targets).extracting<String> { it.text }.containsExactly("AutoResolve_GoblinWarriorWeapon")
    }

    @Test
    fun `should only reference declarations if the property of the enclosing block is a reference`() {

        myFixture.addFileToProject("data/mappedimage.ini", "MappedImage SunRays\nEnd")
        myFixture.configureByText(
            "object.ini",
            """
            Object ElvenMallornTree
                Draw = W3DStreakDraw ModuleTag_Draw
                    Texture = SunRays
                End
                Behavior = PartTheHeavensUpdate ModuleTag_PartTheHeavens
                    Texture = SunRays
                End
            End
            """.trimIndent()
        )

        val (textureFile, mappedImage) = PsiTreeUtil.findChildrenOfType(myFixture.file, LeafPsiElement::class.java)
            .filter { it.text == "SunRays" }
        val handler = SageEngineIniDeclarationGotoDeclarationHandler()

        assertThat(handler.getGotoDeclarationTargets(textureFile, textureFile.textOffset, myFixture.editor)).isNull()
        assertThat(handler.getGotoDeclarationTargets(mappedImage, mappedImage.textOffset, myFixture.editor))
            .extracting<String> { it.text }
            .containsExactly("SunRays")
        assertThat(SageEngineIniDeclarationLookup.findUseSites(project, "MappedImage", "SunRays")).containsExactly(mappedImage)
    }

    @Test
    fun `should navigate to declaration from property value`() {

        myFixture.addFileToProject(
            "data/specialpower.ini",
            """
            SpecialPower SpecialAbilityAragornAthelas
            End
            """.trimIndent()
        )
        myFixture.configureByText(
            "commandbutton.ini",
            "SpecialPower = SpecialAbility<caret>AragornAthelas"
        )

        val sourceElement = myFixture.file.findElementAt(myFixture.caretOffset)
        val targets = SageEngineIniDeclarationGotoDeclarationHandler().getGotoDeclarationTargets(
            sourceElement,
            myFixture.caretOffset,
            myFixture.editor
        )

        assertThat(targets).extracting<String> { it.text }.containsExactly("SpecialAbilityAragornAthelas")
    }

    @Test
    fun `should navigate to declaration whose name starts with a digit`() {

        myFixture.addFileToProject(
            "data/attributemodifier.ini",
            """
            ModifierList 8PlayerModeAttributeModifier
            End
            """.trimIndent()
        )
        myFixture.configureByText(
            "upgrade.ini",
            "AttributeModifier = 8PlayerMode<caret>AttributeModifier"
        )

        val sourceElement = myFixture.file.findElementAt(myFixture.caretOffset)
        val targets = SageEngineIniDeclarationGotoDeclarationHandler().getGotoDeclarationTargets(
            sourceElement,
            myFixture.caretOffset,
            myFixture.editor
        )

        assertThat(targets).extracting<String> { it.text }.containsExactly("8PlayerModeAttributeModifier")
    }

    @Test
    fun `should navigate to use-sites from declaration`() {

        myFixture.addFileToProject(
            "data/test.ini",
            "SpecialPowerTemplate = SpecialAbilityAragornAthelas"
        )
        myFixture.configureByText(
            "specialpower.ini",
            """
            SpecialPower SpecialAbility<caret>AragornAthelas
            End
            """.trimIndent()
        )

        val sourceElement = TargetElementUtil.findTargetElement(
            myFixture.editor,
            TargetElementUtil.ELEMENT_NAME_ACCEPTED or TargetElementUtil.REFERENCED_ELEMENT_ACCEPTED
        )!!
        val usages = myFixture.findUsages(sourceElement)

        assertThat(sourceElement.text).isEqualTo("SpecialAbilityAragornAthelas")
        assertThat(usages).extracting<String> { it.element!!.text }.containsExactly("SpecialAbilityAragornAthelas")
        assertThat(usages).extracting<String> { (it.element!!.parent.firstChild as LeafPsiElement).text }.containsExactly("SpecialPowerTemplate")
        assertThat(usages).extracting<String> { it.element!!.containingFile.virtualFile.path }.containsExactly("/src/data/test.ini")
    }

    @Test
    fun `should only find use-sites inside the search scope`() {

        myFixture.addFileToProject(
            "data/test.ini",
            "SpecialPowerTemplate = SpecialAbilityAragornAthelas"
        )
        myFixture.configureByText(
            "specialpower.ini",
            """
            SpecialPower SpecialAbility<caret>AragornAthelas
            End
            """.trimIndent()
        )

        val sourceElement = TargetElementUtil.findTargetElement(
            myFixture.editor,
            TargetElementUtil.ELEMENT_NAME_ACCEPTED or TargetElementUtil.REFERENCED_ELEMENT_ACCEPTED
        )!!

        assertThat(ReferencesSearch.search(sourceElement, GlobalSearchScope.fileScope(myFixture.file)).findAll()).isEmpty()
        assertThat(ReferencesSearch.search(sourceElement, GlobalSearchScope.projectScope(project)).findAll())
            .extracting<String> { it.element.containingFile.name }
            .containsExactly("test.ini")
    }

    @Test
    fun `should find use-sites written without equals sign`() {

        myFixture.addFileToProject(
            "data/stances.ini",
            """
            StanceTemplate FighterHorde
                Stance Aggressive
                    AttributeModifier   FighterHordeStanceAggressive
                End
            End
            """.trimIndent()
        )
        myFixture.configureByText(
            "attributemodifier.ini",
            """
            ModifierList FighterHordeStance<caret>Aggressive
            End
            """.trimIndent()
        )

        val sourceElement = TargetElementUtil.findTargetElement(
            myFixture.editor,
            TargetElementUtil.ELEMENT_NAME_ACCEPTED or TargetElementUtil.REFERENCED_ELEMENT_ACCEPTED
        )!!
        val usages = myFixture.findUsages(sourceElement)

        assertThat(usages).extracting<String> { it.element!!.text }.containsExactly("FighterHordeStanceAggressive")
        assertThat(usages).extracting<String> { it.element!!.containingFile.name }.containsExactly("stances.ini")
    }

    @Test
    fun `should find image use-sites written without equals sign`() {

        myFixture.addFileToProject(
            "data/controlbarscheme.ini",
            """
            ControlBarScheme Mordor
                ImagePart
                    Position X:0 Y:520
                    ImageName SMCommandBar
                End
            End
            """.trimIndent()
        )
        myFixture.configureByText(
            "mappedimage.ini",
            """
            MappedImage SMCommand<caret>Bar
            End
            """.trimIndent()
        )

        val sourceElement = TargetElementUtil.findTargetElement(
            myFixture.editor,
            TargetElementUtil.ELEMENT_NAME_ACCEPTED or TargetElementUtil.REFERENCED_ELEMENT_ACCEPTED
        )!!
        val usages = myFixture.findUsages(sourceElement)

        assertThat(usages).extracting<String> { it.element!!.containingFile.name }.containsExactly("controlbarscheme.ini")
    }

    @Test
    fun `should navigate from eva event forward references to their declaration`() {

        myFixture.addFileToProject(
            "data/evaevents.ini",
            """
            NewEvaEvent DiscoveredRing
            End
            """.trimIndent()
        )
        myFixture.configureByText("eva.ini", "EvaEventForwardReference Discovered<caret>Ring")

        val sourceElement = myFixture.file.findElementAt(myFixture.caretOffset)
        val targets = SageEngineIniDeclarationGotoDeclarationHandler().getGotoDeclarationTargets(
            sourceElement,
            myFixture.caretOffset,
            myFixture.editor
        )

        assertThat(targets).extracting<String> { it.text }.containsExactly("DiscoveredRing")
    }

    @Test
    fun `should find eva event forward references as use-sites`() {

        myFixture.addFileToProject("data/eva.ini", "EvaEventForwardReference DiscoveredRing")
        myFixture.configureByText(
            "evaevents.ini",
            """
            NewEvaEvent Discovered<caret>Ring
            End
            """.trimIndent()
        )

        val sourceElement = TargetElementUtil.findTargetElement(
            myFixture.editor,
            TargetElementUtil.ELEMENT_NAME_ACCEPTED or TargetElementUtil.REFERENCED_ELEMENT_ACCEPTED
        )!!
        val usages = myFixture.findUsages(sourceElement)

        assertThat(usages).extracting<String> { (it.element!!.parent.firstChild as LeafPsiElement).text }.containsExactly("EvaEventForwardReference")
    }

    @Test
    fun `should find eva events that block other eva events as use-sites`() {

        myFixture.addFileToProject(
            "data/eva.ini",
            """
            NewEvaEvent UnitUnderAttackFromShroudedUnit
                OtherEvaEventsToBlock = UnitUnderAttack  DiscoveredRing ; This counts as a "damage" event
            End
            """.trimIndent()
        )
        myFixture.configureByText(
            "evaevents.ini",
            """
            NewEvaEvent Discovered<caret>Ring
            End
            """.trimIndent()
        )

        val sourceElement = TargetElementUtil.findTargetElement(
            myFixture.editor,
            TargetElementUtil.ELEMENT_NAME_ACCEPTED or TargetElementUtil.REFERENCED_ELEMENT_ACCEPTED
        )!!
        val usages = myFixture.findUsages(sourceElement)

        assertThat(usages).extracting<String> { (it.element!!.parent.firstChild as LeafPsiElement).text }.containsExactly("OtherEvaEventsToBlock")
    }

    @Test
    fun `should navigate to object creation list use-sites from declaration`() {

        myFixture.addFileToProject(
            "data/test.ini",
            """
            Behavior = OCLSpecialPower ModuleTag_SummonDrumsInTheDeep
                SpecialPowerTemplate		= SpecialAbilityDrumsInTheDeep
                OCL							= OCL_SpawnDrumsInTheDeepEgg
                CreateLocation				= CREATE_AT_LOCATION
                StartsPaused				= Yes
                SetModelCondition			= ModelConditionState:PACKING_TYPE_1
                SetModelConditionTime		= 8.1
                TriggerFX					= FX_SummonWildmen
            End
            """.trimIndent()
        )
        myFixture.configureByText(
            "objectcreationlist.ini",
            """
            ObjectCreationList OCL_Spawn<caret>DrumsInTheDeepEgg
                CreateObject
                    ObjectNames = DrumsInTheDeepEgg
                    Count       = 1
                    Disposition = LIKE_EXISTING
                End
            End
            """.trimIndent()
        )

        val sourceElement = TargetElementUtil.findTargetElement(
            myFixture.editor,
            TargetElementUtil.ELEMENT_NAME_ACCEPTED or TargetElementUtil.REFERENCED_ELEMENT_ACCEPTED
        )!!
        val usages = myFixture.findUsages(sourceElement)

        assertThat(sourceElement.text).isEqualTo("OCL_SpawnDrumsInTheDeepEgg")
        assertThat(usages).extracting<String> { it.element!!.text }.containsExactly("OCL_SpawnDrumsInTheDeepEgg")
        assertThat(usages).extracting<String> { (it.element!!.parent.firstChild as LeafPsiElement).text }.containsExactly("OCL")
        assertThat(usages).extracting<String> { it.element!!.containingFile.virtualFile.path }.containsExactly("/src/data/test.ini")
    }

    @Test
    fun `should find use-sites that are not the first value on a multi-value line`() {

        myFixture.addFileToProject(
            "data/experiencelevels.ini",
            "TargetNames = ARAGORN LEGOLAS"
        )
        myFixture.configureByText(
            "object.ini",
            """
            Object Lego<caret>las
            End
            """.trimIndent()
        )

        val sourceElement = TargetElementUtil.findTargetElement(
            myFixture.editor,
            TargetElementUtil.ELEMENT_NAME_ACCEPTED or TargetElementUtil.REFERENCED_ELEMENT_ACCEPTED
        )!!
        val usages = myFixture.findUsages(sourceElement)

        assertThat(sourceElement.text).isEqualTo("Legolas")
        assertThat(usages).extracting<String> { it.element!!.text }.containsExactly("LEGOLAS")
        assertThat(usages).extracting<String> { it.element!!.containingFile.virtualFile.path }.containsExactly("/src/data/experiencelevels.ini")
    }

    @Test
    fun `should navigate to declaration when use-site casing differs from the declaration`() {

        myFixture.addFileToProject(
            "data/object.ini",
            """
            Object ElvenMallornTree
            End
            """.trimIndent()
        )
        myFixture.configureByText(
            "commandbutton.ini",
            "ObjectNames = elven<caret>mallorntree"
        )

        val sourceElement = myFixture.file.findElementAt(myFixture.caretOffset)
        val targets = SageEngineIniDeclarationGotoDeclarationHandler().getGotoDeclarationTargets(
            sourceElement,
            myFixture.caretOffset,
            myFixture.editor
        )

        assertThat(targets).extracting<String> { it.text }.containsExactly("ElvenMallornTree")
    }

    @Test
    fun `should find use-sites when the use-site casing differs from the declaration`() {

        myFixture.addFileToProject(
            "data/test.ini",
            "ObjectNames = ELVENMALLORNTREE"
        )
        myFixture.configureByText(
            "object.ini",
            """
            Object Elven<caret>MallornTree
            End
            """.trimIndent()
        )

        val sourceElement = TargetElementUtil.findTargetElement(
            myFixture.editor,
            TargetElementUtil.ELEMENT_NAME_ACCEPTED or TargetElementUtil.REFERENCED_ELEMENT_ACCEPTED
        )!!
        val usages = myFixture.findUsages(sourceElement)

        assertThat(sourceElement.text).isEqualTo("ElvenMallornTree")
        assertThat(usages).extracting<String> { it.element!!.text }.containsExactly("ELVENMALLORNTREE")
        assertThat(usages).extracting<String> { it.element!!.containingFile.virtualFile.path }.containsExactly("/src/data/test.ini")
    }

    @Test
    fun `should complete declarations for expected property kind`() {

        myFixture.addFileToProject("data/object.ini", "Object ElvenMallornTree\nEnd")
        myFixture.addFileToProject("data/specialpower.ini", "SpecialPower SpecialAbilityAragornAthelas\nEnd")
        myFixture.configureByText("commandbutton.ini", "SpecialPower = <caret>")

        val lookups = myFixture.completeBasic().map { it.lookupString }

        assertThat(lookups).contains("SpecialAbilityAragornAthelas")
        assertThat(lookups).doesNotContain("ElvenMallornTree")
    }

    @Test
    fun `should complete each declaration only once`() {

        myFixture.addFileToProject(
            "data/specialpower.ini",
            """
            SpecialPower SpecialAbilityAragornAthelas
            End
            SpecialPower SpecialAbilityAragornElendil
            End
            """.trimIndent()
        )
        myFixture.configureByText("commandbutton.ini", "SpecialPower = SpecialAbility<caret>")

        val lookups = myFixture.completeBasic().map { it.lookupString }

        assertThat(lookups).containsOnlyOnce("SpecialAbilityAragornAthelas", "SpecialAbilityAragornElendil")
    }

    @Test
    fun `should provide a declaration reference on property values`() {

        myFixture.addFileToProject("data/specialpower.ini", "SpecialPower SpecialAbilityAragornAthelas\nEnd")
        myFixture.configureByText("commandbutton.ini", "SpecialPower = SpecialAbility<caret>AragornAthelas")

        val reference = myFixture.file.findReferenceAt(myFixture.caretOffset)

        assertThat(reference).isInstanceOf(SageEngineIniDeclarationReference::class.java)
        assertThat(reference!!.resolve()?.text).isEqualTo("SpecialAbilityAragornAthelas")
    }

    @Test
    fun `should only index declarations with a correctly cased keyword but match their names in any case`() {

        myFixture.addFileToProject("data/object.ini", "object LowercaseKeyword\nEnd\nObject MixedCaseName\nEnd")

        assertThat(SageEngineIniDeclarationLookup.findDeclarations(project, "LowercaseKeyword", setOf("Object"))).isEmpty()
        assertThat(SageEngineIniDeclarationLookup.findDeclarations(project, "mixedcasename", setOf("Object")))
            .extracting<String?> { it.name }
            .containsExactly("MixedCaseName")
    }

    @Test
    fun `should navigate from fx lists to top level particle system definitions`() {

        myFixture.addFileToProject("data/particlesystem.ini", "ParticleSystem RainOfFireImpactLight\nEnd")
        myFixture.configureByText("fxlist.ini", "FXList FX_RainOfFireImpact\n    ParticleSystem\n        Name = RainOfFire<caret>ImpactLight\n    End\nEnd")

        val sourceElement = myFixture.file.findElementAt(myFixture.caretOffset)
        val targets = SageEngineIniDeclarationGotoDeclarationHandler().getGotoDeclarationTargets(sourceElement, myFixture.caretOffset, myFixture.editor)

        assertThat(targets).extracting<String> { it.containingFile.name }.containsExactly("particlesystem.ini")
    }

    @Test
    fun `should resolve the object of unit specific voice names`() {

        myFixture.addFileToProject("data/azog.ini", "Object WildAzog\nEnd")
        myFixture.configureByText(
            "lugthemauled.ini",
            """
            Object WildLugTheMauled
                UnitSpecificSounds
                    VoiceAttackUnitWild<caret>Azog = LugVoiceAttackBolgAzog
                End
            End
            """.trimIndent()
        )

        val reference = myFixture.file.findReferenceAt(myFixture.caretOffset)!!

        assertThat(reference.rangeInElement.substring(reference.element.text)).isEqualTo("WildAzog")
        assertThat(reference.resolve()?.containingFile?.name).isEqualTo("azog.ini")
    }

    @Test
    fun `should find unit specific voice names and values as use-sites`() {

        myFixture.addFileToProject(
            "data/lugthemauled.ini",
            """
            Object WildLugTheMauled
                UnitSpecificSounds
                    VoiceAttackUnitWildAzog = LugVoiceAttackBolgAzog
                End
            End
            """.trimIndent()
        )
        myFixture.configureByText("azog.ini", "Object Wild<caret>Azog\nEnd\nAudioEvent LugVoiceAttackBolgAzog\nEnd")

        val objectUsages = myFixture.findUsages(TargetElementUtil.findTargetElement(myFixture.editor, TargetElementUtil.ELEMENT_NAME_ACCEPTED)!!)
        myFixture.editor.caretModel.moveToOffset(myFixture.file.text.indexOf("LugVoiceAttackBolgAzog") + 3)
        val soundUsages = myFixture.findUsages(TargetElementUtil.findTargetElement(myFixture.editor, TargetElementUtil.ELEMENT_NAME_ACCEPTED)!!)

        assertThat(objectUsages).extracting<String> { it.element!!.text }.containsExactly("VoiceAttackUnitWildAzog")
        assertThat(soundUsages).extracting<String> { it.element!!.text }.containsExactly("LugVoiceAttackBolgAzog")
    }

    @Test
    fun `should complete unit specific voice names with object names`() {

        myFixture.addFileToProject("data/azog.ini", "Object WildAzog\nEnd")
        myFixture.configureByText(
            "lugthemauled.ini",
            """
            Object WildLugTheMauled
                UnitSpecificSounds
                    VoiceAttackUnitWi<caret>
                End
            End
            """.trimIndent()
        )

        val lookups = myFixture.completeBasic()?.map { it.lookupString }

        if (lookups == null) {
            assertThat(myFixture.editor.document.text).contains("VoiceAttackUnitWildAzog")
        } else {
            assertThat(lookups).contains("VoiceAttackUnitWildAzog")
        }
    }

    @Test
    fun `should list declaration names from project index`() {

        myFixture.addFileToProject("data/object.ini", "Object ElvenMallornTree\nEnd")
        myFixture.addFileToProject("data/specialpower.inc", "SpecialPower SpecialAbilityAragornAthelas\nEnd")

        val names = SageEngineIniDeclarationLookup.allDeclarationNames(project, setOf("SpecialPower"))

        assertThat(names).contains("SpecialAbilityAragornAthelas")
        assertThat(names).doesNotContain("ElvenMallornTree")
    }

    @Test
    fun `should keep declarations and use-sites distinct within the unified index`() {

        myFixture.addFileToProject("data/declaration.ini", "SpecialPower DeclarationOnly\nEnd")
        myFixture.addFileToProject("data/usage.ini", "SpecialPower = UseSiteOnly")

        val declarationNames = SageEngineIniDeclarationLookup.allDeclarationNames(project, setOf("SpecialPower"))
        val useSitesForDeclaration = SageEngineIniDeclarationLookup.findUseSites(project, "SpecialPower", "DeclarationOnly")
        val declarationsForUseSite = SageEngineIniDeclarationLookup.findDeclarations(project, "UseSiteOnly", setOf("SpecialPower"))

        assertThat(declarationNames).contains("DeclarationOnly")
        assertThat(declarationNames).doesNotContain("UseSiteOnly")
        assertThat(useSitesForDeclaration).isEmpty()
        assertThat(declarationsForUseSite).isEmpty()
    }

    @Test
    fun `should find declaration use-sites from background thread`() {

        myFixture.addFileToProject("data/usage.ini", "SpecialPower = SpecialAbilityAragornAthelas")

        val useSites = ApplicationManager.getApplication().executeOnPooledThread<List<String>> {
            SageEngineIniDeclarationLookup.findUseSites(project, "SpecialPower", "SpecialAbilityAragornAthelas")
                .map { it.text }
        }.get()

        assertThat(useSites).containsExactly("SpecialAbilityAragornAthelas")
    }

    @Test
    fun `should search declaration references from background thread`() {

        myFixture.addFileToProject(
            "data/test.ini",
            "SpecialPowerTemplate = SpecialAbilityAragornAthelas"
        )
        myFixture.configureByText(
            "specialpower.ini",
            """
            SpecialPower SpecialAbility<caret>AragornAthelas
            End
            """.trimIndent()
        )

        val sourceElement = TargetElementUtil.findTargetElement(
            myFixture.editor,
            TargetElementUtil.ELEMENT_NAME_ACCEPTED or TargetElementUtil.REFERENCED_ELEMENT_ACCEPTED
        )!!
        val usages = ApplicationManager.getApplication().executeOnPooledThread<List<String>> {
            val references = ReferencesSearch.search(sourceElement).findAll()
            ReadAction.computeBlocking<List<String>, RuntimeException> {
                references.map { it.element.text }
            }
        }.get()

        assertThat(usages).containsExactly("SpecialAbilityAragornAthelas")
    }

    @Test
    fun `should resolve and find the referenced part of keyed values`() {

        myFixture.addFileToProject("data/objectcreationlist.ini", "ObjectCreationList OCL_RohirrimSpawnDeadRider\nEnd")
        myFixture.configureByText(
            "object.ini",
            """
            Object RohirrimArcher
                Behavior = DetachableRiderUpdate ModuleTag_Rider
                    DeathEntry = AnimState:DEATH_2 AnimTime:3000 RiderOCL:OCL_Rohirrim<caret>SpawnDeadRider
                End
            End
            """.trimIndent()
        )

        val reference = myFixture.getReferenceAtCaretPositionWithAssertion()
        val declaration = PsiTreeUtil.getParentOfType(reference.resolve(), SageEngineIniBlock::class.java)!!

        assertThat(reference.rangeInElement.substring(reference.element.text)).isEqualTo("OCL_RohirrimSpawnDeadRider")
        assertThat(declaration.name).isEqualTo("OCL_RohirrimSpawnDeadRider")
        assertThat(ReferencesSearch.search(declaration.nameIdentifier!!).findAll().map { it.element.text })
            .containsExactly("RiderOCL:OCL_RohirrimSpawnDeadRider")
    }

    @Test
    fun `should resolve radius cursors that the in game ui declares by label`() {

        myFixture.addFileToProject(
            "data/ingameui.ini",
            """
            InGameUI
                RadiusCursorTemplate = RainOfFireRadiusCursor
                    Texture = SCCRainOfFire
                End
            End
            """.trimIndent()
        )
        myFixture.configureByText(
            "commandbutton.ini",
            """
            CommandButton Command_RainOfFire
                RadiusCursorType = RainOfFire<caret>RadiusCursor
            End
            """.trimIndent()
        )

        val declaration = PsiTreeUtil.getParentOfType(myFixture.getReferenceAtCaretPositionWithAssertion().resolve(), SageEngineIniBlock::class.java)

        assertThat(declaration?.name).isEqualTo("RainOfFireRadiusCursor")
    }

    @Test
    fun `should resolve declarations whose names contain apostrophes`() {

        myFixture.addFileToProject("data/heroui.ini", "MappedImage HPTheodenKing'sFavor\nEnd")
        myFixture.configureByText(
            "commandbutton.ini",
            """
            CommandButton Command_TheodensFavor
                ButtonImage = HPTheodenKing'sFa<caret>vor
            End
            """.trimIndent()
        )

        val declaration = PsiTreeUtil.getParentOfType(myFixture.getReferenceAtCaretPositionWithAssertion().resolve(), SageEngineIniBlock::class.java)

        assertThat(declaration?.name).isEqualTo("HPTheodenKing'sFavor")
    }

    @Test
    fun `should not highlight unrelated sections`() {

        myFixture.configureByText(
            "specialpower.ini",
            """
            Upgrade Upgrade_Dolguldur<caret>WallHub
                DisplayName = UPGRADE:Upgrade_IsengardWallHub
                Type        = OBJECT
                BuildTime   = ELVEN_CASTLE_WALLHUB_BUILDTIME
                BuildCost   = ELVEN_CASTLE_WALLHUB_BUILDCOST
            End

            Upgrade Upgrade_DolguldurWallHub1
                DisplayName = UPGRADE:Upgrade_IsengardWallHub
                Type        = OBJECT
                BuildTime   = ELVEN_CASTLE_WALLHUB_BUILDTIME
                BuildCost   = ELVEN_CASTLE_WALLHUB_BUILDCOST
            End

            Upgrade Upgrade_DolguldurWallHub2
                DisplayName = UPGRADE:Upgrade_IsengardWallHub
                Type        = OBJECT
                BuildTime   = ELVEN_CASTLE_WALLHUB_BUILDTIME
                BuildCost   = ELVEN_CASTLE_WALLHUB_BUILDCOST
            End
            """.trimIndent()
        )

        val sourceElement = TargetElementUtil.findTargetElement(
            myFixture.editor,
            TargetElementUtil.ELEMENT_NAME_ACCEPTED or TargetElementUtil.REFERENCED_ELEMENT_ACCEPTED
        )!!
        val usages = myFixture.findUsages(sourceElement)
        val highlightedRanges = myFixture.testHighlightUsages("specialpower.ini")
            .map { it.textRange }
        val highlightedTexts = highlightedRanges.map { myFixture.file.text.substring(it.startOffset, it.endOffset) }
        val unrelatedValue = PsiTreeUtil.findChildrenOfType(myFixture.file, LeafPsiElement::class.java)
            .first { it.elementType == SageEngineIniTokenTypes.VALUE && it.text == "ELVEN_CASTLE_WALLHUB_BUILDCOST" }
        val unrelatedReferences = ReferencesSearch.search(unrelatedValue).findAll()
        val unrelatedProperty = PsiTreeUtil.findChildrenOfType(myFixture.file, LeafPsiElement::class.java)
            .first { it.elementType == SageEngineIniTokenTypes.PROPERTY && it.text == "BuildCost" }

        assertThat(sourceElement.text).isEqualTo("Upgrade_DolguldurWallHub")
        assertThat(sourceElement.textRange).isEqualTo(
            PsiTreeUtil.getParentOfType(sourceElement, SageEngineIniBlock::class.java)!!.nameIdentifier!!.textRange
        )
        assertThat(usages).isEmpty()
        assertThat(highlightedTexts).containsExactly(sourceElement.text)
        assertThat(highlightedRanges).doesNotContain(unrelatedValue.textRange, unrelatedProperty.textRange)
        assertThat(unrelatedReferences).isEmpty()
    }

    @Test
    fun `should only reference the name of eva events in sound values`() {

        myFixture.addFileToProject(
            "data/object.ini",
            """
            Object ElvenBarracks
                VoiceFullyCreated = EVA:GenericBuildingComplete-Builder-Elf
            End
            """.trimIndent()
        )
        myFixture.configureByText(
            "evaevents.ini",
            """
            NewEvaEvent GenericBuildingComplete-Builder-Elf
            End
            """.trimIndent()
        )

        val nameIdentifier = PsiTreeUtil.findChildOfType(myFixture.file, SageEngineIniBlock::class.java)!!.nameIdentifier!!
        val references = ReferencesSearch.search(nameIdentifier).findAll()

        assertThat(references).extracting<String> { it.rangeInElement.substring(it.element.text) }
            .containsExactly("GenericBuildingComplete-Builder-Elf")
        assertThat(references).allMatch { it.isReferenceTo(nameIdentifier) }
    }
}
