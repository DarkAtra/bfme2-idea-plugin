package de.darkatra.bfme2.ini.validation

import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase
import org.junit.Test

class SageEngineIniDeclarationInspectionsTest : LightPlatformCodeInsightFixture4TestCase() {

    @Test
    fun `should report unresolved references and references to other kinds`() {

        myFixture.enableInspections(SageEngineIniUnresolvedReferenceInspection())
        myFixture.addFileToProject("data/object.ini", "Object ElvenMallornTree\nEnd")
        myFixture.addFileToProject("data/macros.ini", "#define ATHELAS_POWER SpecialAbilityAragornAthelas")
        myFixture.configureByText(
            "commandbutton.ini",
            """
            CommandButton Command_Athelas
                SpecialPower = <warning descr="Cannot resolve SpecialPower 'MissingSpecialPower'">MissingSpecialPower</warning>
            End
            CommandButton Command_Mallorn
                SpecialPower = <warning descr="Expected SpecialPower, but 'ElvenMallornTree' is Object">ElvenMallornTree</warning>
            End
            CommandButton Command_Macro
                SpecialPower = ATHELAS_POWER
            End
            CommandButton Command_Unknown
                UnknownProperty = MissingSpecialPower
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should only report the words of values that reference declarations`() {

        myFixture.enableInspections(SageEngineIniUnresolvedReferenceInspection())
        myFixture.addFileToProject("data/fxparticlesystem.ini", "FXParticleSystem LightningCharge\nEnd")
        myFixture.addFileToProject("data/fxlist.ini", "FXList FX_BasicSevereScreenShake\nEnd\nFXList GoodLevelUpFX\nEnd")
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
                Behavior = TransitionDamageFX ModuleTag_DamageFX
                    ReallyDamagedFXList1 = Loc: X:0 Y:0 Z:0 FXList:FX_BasicSevereScreenShake
                    ReallyDamagedParticleSystem1 = Bone:None RandomBone:No PSys:<warning descr="Cannot resolve FXParticleSystem or ParticleSystem 'FireBuildingLarge'">FireBuildingLarge</warning>
                End
                Behavior = CastleBehavior ModuleTag_Castle
                    CastleToUnpackForFaction = Men gondor_castle 5000
                End
                ArmorSet
                    Conditions = None
                    Armor = None
                End
            End
            ExperienceLevel GoodLevel2
                LevelUpFx = FX:GoodLevelUpFX
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should report references whose casing differs from their declaration`() {

        myFixture.enableInspections(SageEngineIniReferenceCasingInspection())
        myFixture.addFileToProject("data/specialpower.ini", "SpecialPower SpecialAbilityAragornAthelas\nEnd")
        myFixture.configureByText(
            "commandbutton.ini",
            """
            CommandButton Command_Athelas
                SpecialPower = <weak_warning descr="'specialabilityaragornathelas' is declared as 'SpecialAbilityAragornAthelas'">specialability<caret>aragornathelas</weak_warning>
            End
            CommandButton Command_AthelasAgain
                SpecialPower = SpecialAbilityAragornAthelas
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, true)
        myFixture.launchAction(myFixture.findSingleIntention("Change to 'SpecialAbilityAragornAthelas'"))
        myFixture.checkResult(
            """
            CommandButton Command_Athelas
                SpecialPower = SpecialAbilityAragornAthelas
            End
            CommandButton Command_AthelasAgain
                SpecialPower = SpecialAbilityAragornAthelas
            End
            """.trimIndent()
        )
    }

    @Test
    fun `should report declarations that are declared more than once`() {

        myFixture.enableInspections(SageEngineIniDuplicateDeclarationInspection())
        myFixture.addFileToProject("data/weapon.ini", "Weapon ElvenBow\nEnd")
        myFixture.addFileToProject("data/default/armor.ini", "Armor TreeArmor\nEnd")
        myFixture.addFileToProject("maps/map mp fords of isen/map.ini", "Object ElvenMallornTree\nEnd")
        myFixture.configureByText(
            "object.ini",
            """
            Object <warning descr="'ElvenMallornTree' is declared more than once, also in line 3">ElvenMallornTree</warning>
            End
            Object <warning descr="'ElvenMallornTree' is declared more than once, also in line 1">ElvenMallornTree</warning>
            End
            Weapon <warning descr="'ElvenBow' is declared more than once, also in weapon.ini:1">ElvenBow</warning>
            End
            Armor TreeArmor
            End
            FXList ElvenBow
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should report module tags that are used more than once in an object`() {

        myFixture.enableInspections(SageEngineIniModuleTagInspection())
        myFixture.addFileToProject("includes/heal.inc", "Behavior = AutoHealBehavior ModuleTag_Heal\nEnd")
        myFixture.configureByText(
            "object.ini",
            """
            Object ElvenMallornTree
                Behavior = AutoHealBehavior ModuleTag_Heal
                End
                Body = ActiveBody ModuleTag_Body
                End
                Draw = W3DScriptedModelDraw <warning descr="ModuleTag 'ModuleTag_Body' is used more than once in 'ElvenMallornTree'">ModuleTag_Body</warning>
                End
                #include <warning descr="ModuleTag 'ModuleTag_Heal' is used more than once in 'ElvenMallornTree'">"includes/heal.inc"</warning>
            End
            Object ElvenWarrior
                Behavior = AutoHealBehavior ModuleTag_Heal
                End
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should report removed and replaced module tags that the parent object doesn't have`() {

        myFixture.enableInspections(SageEngineIniModuleTagInspection())
        myFixture.addFileToProject("includes/death.inc", "Behavior = SlowDeathBehavior ModuleTag_Death\nEnd")
        myFixture.addFileToProject(
            "data/gondor.ini",
            """
            Object GondorSoldier
                Behavior = AutoHealBehavior ModuleTag_Heal
                End
                #include "../includes/death.inc"
            End
            ChildObject GondorSoldierVeteran GondorSoldier
                Draw = W3DScriptedModelDraw ModuleTag_Draw
                End
            End
            Object GondorKnight
                #include "missing.inc"
            End
            """.trimIndent()
        )
        myFixture.configureByText(
            "object.ini",
            """
            ChildObject GondorSoldierElite GondorSoldierVeteran
                RemoveModule <warning descr="Unknown ModuleTag 'ModuleTag_Own', 'GondorSoldierVeteran' has no module with this tag">ModuleTag_Own</warning>
                Behavior = AutoHealBehavior ModuleTag_Own
                End
                RemoveModule ModuleTag_Own
                RemoveModule ModuleTag_Death
                RemoveModule <warning descr="Unknown ModuleTag 'ModuleTag_Missing', 'GondorSoldierVeteran' has no module with this tag">ModuleTag_Missing</warning>
                ReplaceModule ModuleTag_Draw
                    Draw = W3DScriptedModelDraw ModuleTag_Draw
                    End
                End
                ReplaceModule <warning descr="Unknown ModuleTag 'ModuleTag_Body', 'GondorSoldierVeteran' has no module with this tag">ModuleTag_Body</warning>
                    Body = ActiveBody ModuleTag_Body
                    End
                End
            End
            ChildObject GondorSoldierUnknownParent MissingObject
                RemoveModule ModuleTag_Missing
            End
            ChildObject GondorSoldierUnresolvedInclude GondorKnight
                RemoveModule ModuleTag_Missing
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should stop at include and inheritance cycles`() {

        myFixture.enableInspections(SageEngineIniModuleTagInspection())
        myFixture.addFileToProject("includes/a.inc", "#include \"b.inc\"\nBehavior = AutoHealBehavior ModuleTag_Heal\nEnd")
        myFixture.addFileToProject("includes/b.inc", "#include \"a.inc\"")
        myFixture.configureByText(
            "object.ini",
            """
            Object GondorSoldier
                #include "includes/a.inc"
            End
            ChildObject GondorSoldierVeteran GondorSoldierElite
                RemoveModule ModuleTag_Missing
            End
            ChildObject GondorSoldierElite GondorSoldierVeteran
                RemoveModule ModuleTag_Missing
            End
            ChildObject GondorSoldierCaptain GondorSoldier
                RemoveModule ModuleTag_Missing
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should only warn about blocks that an included file closes`() {

        myFixture.enableInspections(SageEngineIniIncludedBlockEndInspection())
        myFixture.addFileToProject(
            "rangeranims.inc",
            """
            #include "rangeranimstates.inc"
            <warning descr="'End' closes a block of the file that includes this one, close it in the file that opens it">End</warning>
            """.trimIndent()
        )
        myFixture.addFileToProject("rangeranimstates.inc", "#include \"rangeranims.inc\"\nAnimationState = IDLE\nEnd")
        myFixture.configureByText(
            "ranger.ini",
            """
            Object GondorRanger
                Draw = W3DScriptedModelDraw ModuleTag_Draw
                    #include "rangeranims.inc"
            End
            Object GondorSoldier
                Draw = W3DScriptedModelDraw ModuleTag_Draw
                End<EOLError descr="Missing 'End' for block 'Object'"></EOLError>
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
        myFixture.openFileInEditor(myFixture.findFileInTempDir("rangeranims.inc"))
        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should report includes that include the including file again`() {

        myFixture.enableInspections(SageEngineIniIncludeCycleInspection())
        myFixture.addFileToProject("includes/b.inc", "#include \"c.inc\"")
        myFixture.addFileToProject("includes/c.inc", "#include \"../a.inc\"")
        myFixture.addFileToProject("includes/d.inc", "#include \"c.inc\"")
        myFixture.addFileToProject("includes/e.inc", "")
        myFixture.configureByText(
            "a.inc",
            """
            #include <warning descr="'includes/b.inc' includes this file again, so the includes never end">"includes/b.inc"</warning>
            #include <warning descr="'a.inc' includes this file again, so the includes never end">"a.inc"</warning>
            #include "includes/e.inc"
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should report includes of files that don't exist`() {

        myFixture.enableInspections(SageEngineIniUnresolvedIncludeInspection())
        myFixture.addFileToProject("includes/capturebuilding.inc", "")
        myFixture.configureByText(
            "object.ini",
            """
            #include "Includes/CaptureBuilding.inc"
            #include <warning descr="Cannot resolve file 'includes/missing.inc'">"includes/missing.inc"</warning>
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }

    @Test
    fun `should report macros that aren't defined`() {

        myFixture.enableInspections(SageEngineIniUnresolvedMacroInspection())
        myFixture.addFileToProject("data/macros.ini", "#define MALLORN_COST 200")
        myFixture.configureByText(
            "object.ini",
            """
            #define HERO_COST 1000 (with 10% discount)
            Object ElvenMallornTree
                BuildCost = MALLORN_COST
                BuildTime = <warning descr="Cannot resolve macro 'MALLORN_TIME'">MALLORN_TIME</warning>
                VisionRange = #MULTIPLY( MALLORN_COST <warning descr="Cannot resolve macro 'VISION_FACTOR'">VISION_FACTOR</warning> )
                DisplayName = OBJECT:ElvenMallornTree
            End
            """.trimIndent()
        )

        myFixture.checkHighlighting(true, false, false)
    }
}
