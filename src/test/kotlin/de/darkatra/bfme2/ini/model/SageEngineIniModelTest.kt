package de.darkatra.bfme2.ini.model

import de.darkatra.bfme2.ini.model.audio.SoundSet
import de.darkatra.bfme2.ini.model.behaviour.ArmorUpgrade
import de.darkatra.bfme2.ini.model.behaviour.PhysicsBehavior
import de.darkatra.bfme2.ini.model.behaviour.UpgradeBehavior
import de.darkatra.bfme2.ini.model.common.SageBehavior
import de.darkatra.bfme2.ini.model.common.SageBlockHeader
import de.darkatra.bfme2.ini.model.common.SageDraw
import de.darkatra.bfme2.ini.model.common.SageIniName
import de.darkatra.bfme2.ini.model.common.SageIniObject
import de.darkatra.bfme2.ini.model.common.SageModule
import de.darkatra.bfme2.ini.model.common.SageNestedAttribute
import de.darkatra.bfme2.ini.model.common.SageNugget
import de.darkatra.bfme2.ini.model.draw.Animation
import de.darkatra.bfme2.ini.model.draw.W3DModelDraw
import de.darkatra.bfme2.ini.model.fx.CreateDebris
import de.darkatra.bfme2.ini.model.livingworld.DefeatCondition
import de.darkatra.bfme2.ini.model.livingworld.PlayerDefeatCondition
import de.darkatra.bfme2.ini.model.livingworld.TeamDefeatCondition
import de.darkatra.bfme2.ini.model.nugget.ClearNuggets
import de.darkatra.bfme2.ini.model.nugget.DOTNugget
import de.darkatra.bfme2.ini.model.nugget.DamageNugget
import de.darkatra.bfme2.ini.model.nugget.ParalyzeNugget
import de.darkatra.bfme2.ini.model.nugget.WeaponEffectNugget
import de.darkatra.bfme2.ini.model.nugget.WeaponOCLNugget
import de.darkatra.bfme2.ini.model.`object`.Armor
import de.darkatra.bfme2.ini.model.`object`.CommandSet
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.Flammability
import de.darkatra.bfme2.ini.model.`object`.GameData
import de.darkatra.bfme2.ini.model.`object`.GameDataSection1
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectCreationList
import de.darkatra.bfme2.ini.model.`object`.ObjectSection1
import de.darkatra.bfme2.ini.model.`object`.ObjectSection2
import de.darkatra.bfme2.ini.model.`object`.Upgrade
import de.darkatra.bfme2.ini.model.`object`.Weapon
import de.darkatra.bfme2.ini.model.particle.ParticleSystem
import de.darkatra.bfme2.ini.model.ui.Window
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.Untyped
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.full.findAnnotation

/**
 * Verifies representative slices of the strongly-typed model after the idiomatic refactor: one case
 * per structural flavour (top-level table, behaviour, draw, nugget, nested attribute), plus the
 * cross-cutting concerns the model has to get right (idiomatic lowerCamelCase properties preserving
 * their upstream token via [SageIniName], Kotlin inheritance replacing the previous embedded-base
 * composition, repeatable list fields, typed references, defaults, section-splitting of oversized
 * blocks, empty blocks with headers, and the retirement of the generic `nested` package).
 */
class SageEngineIniModelTest {

    @Test
    fun `should model a top-level table block as a constructible data class with typed properties`() {

        val armor = Armor()

        assertThat(armor).isInstanceOf(SageIniObject::class.java)
        val armorScalars: List<Untyped> = armor.armor
        assertThat(armorScalars).isEmpty()
        assertThat(armor.flankedPenalty).isEqualTo(0.0)
    }

    @Test
    fun `should preserve upstream defaults including non-zero ones`() {

        assertThat(Armor().damageScalar).isEqualTo(1.0)
        assertThat(DamageNugget().damage).isEqualTo(0.0)
    }

    @Test
    fun `should keep idiomatic property names mapped to their exact upstream INI token`() {

        val flankedPenalty = Armor::class.declaredMemberProperties.single { it.name == "flankedPenalty" }
        assertThat(flankedPenalty.findAnnotation<SageIniName>()?.value).isEqualTo("FlankedPenalty")

        // An inherited property carries the annotation on the concrete overriding declaration too.
        val specialObjectFilter = DamageNugget::class.declaredMemberProperties.single { it.name == "specialObjectFilter" }
        assertThat(specialObjectFilter.findAnnotation<SageIniName>()?.value).isEqualTo("SpecialObjectFilter")
    }

    @Test
    fun `should keep the exact upstream token for classes renamed to idiomatic style`() {

        // `_DefeatCondition` was renamed to DefeatCondition; the original token is recorded.
        assertThat(DefeatCondition::class.java.getAnnotation(SageIniName::class.java).value)
            .isEqualTo("_DefeatCondition")
    }

    @Test
    fun `should model behaviours and draws as modules via marker interfaces`() {

        assertThat(PhysicsBehavior()).isInstanceOf(SageBehavior::class.java)
        assertThat(PhysicsBehavior()).isInstanceOf(SageModule::class.java)
        assertThat(W3DModelDraw()).isInstanceOf(SageDraw::class.java)
        assertThat(W3DModelDraw()).isInstanceOf(SageModule::class.java)
    }

    @Test
    fun `should model nuggets and inheritance through Kotlin subclassing`() {

        val damageNugget = DamageNugget()

        assertThat(damageNugget).isInstanceOf(SageNugget::class.java)
        // Single-level inheritance: the concrete leaf extends its field-bearing base.
        assertThat(damageNugget).isInstanceOf(WeaponEffectNugget::class.java)
        // Multi-level inheritance: DOTNugget -> DamageNugget -> WeaponEffectNugget.
        assertThat(DOTNugget()).isInstanceOf(DamageNugget::class.java)
        assertThat(DOTNugget()).isInstanceOf(WeaponEffectNugget::class.java)

        // Inherited state is reachable directly and can be set through the constructor.
        val forbidden = DamageNugget(forbiddenUpgradeNames = listOf(SageReference("Upgrade_Foo")))
        assertThat(forbidden.forbiddenUpgradeNames.single().raw).isEqualTo("Upgrade_Foo")
    }

    @Test
    fun `should replace embedded-base composition for helper bases and behaviours with inheritance`() {

        // DefeatCondition is an open base; the Player/Team variants inherit it instead of embedding it.
        assertThat(PlayerDefeatCondition()).isInstanceOf(DefeatCondition::class.java)
        assertThat(TeamDefeatCondition()).isInstanceOf(DefeatCondition::class.java)
        val condition = PlayerDefeatCondition(loseIfCapitalLost = true)
        assertThat(condition.loseIfCapitalLost).isTrue()

        // Representative behaviour base/subclass relationship.
        assertThat(ArmorUpgrade()).isInstanceOf(UpgradeBehavior::class.java)
        assertThat(ArmorUpgrade()).isInstanceOf(SageBehavior::class.java)
    }

    @Test
    fun `should model nested attribute blocks in their owning domain package`() {

        val flammability = Flammability()

        assertThat(flammability).isInstanceOf(SageNestedAttribute::class.java)
        assertThat(flammability.fuel).isEqualTo(0)
    }

    @Test
    fun `should represent repeatable fields as lists and references as typed reference values`() {

        val oclNugget = WeaponOCLNugget(weaponOCLName = listOf(SageReference("GondorArcher")))
        assertThat(oclNugget.weaponOCLName.single().raw).isEqualTo("GondorArcher")

        assertThat(ParalyzeNugget().paralyzeFX).isNull()
        val paralyze = ParalyzeNugget(paralyzeFX = SageReference("FX_Paralyze"))
        assertThat(paralyze.paralyzeFX?.raw).isEqualTo("FX_Paralyze")
    }

    @Test
    fun `should model keyed-table-typed fields as typed cross-references not embedded blocks`() {

        // Object.CommandSet is a cross-reference to the commandsets table, so it is a typed SageReference.
        val cmdSetRef: SageReference<CommandSet>? = ObjectSection1().commandSet
        assertThat(cmdSetRef).isNull()
        val obj = Object(section1 = ObjectSection1(commandSet = SageReference("GondorCommandSet")))
        assertThat(obj.section1.commandSet?.raw).isEqualTo("GondorCommandSet")

        // WeaponOCLNugget.weaponOCLName preserves its ObjectCreationList target as a list.
        val ocl: List<SageReference<ObjectCreationList>> =
            WeaponOCLNugget(weaponOCLName = listOf(SageReference("OCL_Foo"))).weaponOCLName
        assertThat(ocl.single().raw).isEqualTo("OCL_Foo")

        // Representative scalar reference (Weapon.FireOCL -> objectcreationlists).
        val fireOcl: SageReference<ObjectCreationList>? = Weapon(fireOCL = SageReference("OCL_Fire")).fireOCL
        assertThat(fireOcl?.raw).isEqualTo("OCL_Fire")

        // Representative repeated reference (WeaponEffectNugget.ForbiddenUpgradeNames -> upgrades).
        val forbidden: List<SageReference<Upgrade>> =
            WeaponEffectNugget(forbiddenUpgradeNames = listOf(SageReference("Upgrade_Foo"))).forbiddenUpgradeNames
        assertThat(forbidden.single().raw).isEqualTo("Upgrade_Foo")
    }

    @Test
    fun `should carry a typed header so empty upstream blocks are still data classes with state`() {

        // ClearNuggets has no body properties upstream, yet it is a data class with a header.
        val clear = ClearNuggets(header = SageBlockHeader(name = "ClearNuggets"))
        assertThat(clear).isInstanceOf(SageNugget::class.java)
        assertThat(clear.header.name).isEqualTo("ClearNuggets")
        // copy() proves it is a data class, not an ordinary class.
        assertThat(clear.copy()).isEqualTo(clear)
    }

    @Test
    fun `should expose target-typed references in a type-safe way`() {

        val fxRef: SageReference<FXList> = SageReference("FX_Foo")
        val oclRefs: List<SageReference<ObjectCreationList>> = listOf(SageReference("OCL_Bar"))
        assertThat(fxRef.raw).isEqualTo("FX_Foo")
        assertThat(oclRefs.single().raw).isEqualTo("OCL_Bar")
    }

    @Test
    fun `should split oversized upstream blocks into typed sections`() {

        val obj = Object()
        assertThat(obj).isInstanceOf(SageIniObject::class.java)
        assertThat(obj.section1).isInstanceOf(ObjectSection1::class.java)
        assertThat(obj.section2).isInstanceOf(ObjectSection2::class.java)

        assertThat(GameData().section1).isInstanceOf(GameDataSection1::class.java)
    }

    @Test
    fun `should retire the generic nested package by moving types to their owning domain`() {

        // Every former `nested` type now lives in a concrete domain package, never `nested`.
        assertThat(Animation::class.java.`package`.name).endsWith(".draw")
        assertThat(ParticleSystem::class.java.`package`.name).endsWith(".particle")
        assertThat(CreateDebris::class.java.`package`.name).endsWith(".fx")
        assertThat(DefeatCondition::class.java.`package`.name).endsWith(".livingworld")
        assertThat(Window::class.java.`package`.name).endsWith(".ui")
        assertThat(SoundSet::class.java.`package`.name).endsWith(".audio")

        val packages = listOf(Animation::class, ParticleSystem::class, CreateDebris::class, Window::class)
        assertThat(packages.map { it.java.`package`.name }).noneMatch { it.endsWith(".nested") }
    }
}
