package de.darkatra.bfme2.ini.model

import de.darkatra.bfme2.ini.model.behaviour.AutoHealBehavior
import de.darkatra.bfme2.ini.model.behaviour.HordeContain
import de.darkatra.bfme2.ini.model.behaviour.RebuildHoleBehavior
import de.darkatra.bfme2.ini.model.behaviour.UpgradeBehavior
import de.darkatra.bfme2.ini.model.common.FCurve
import de.darkatra.bfme2.ini.model.common.SageIniValueType.BlockValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ListValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.ReferenceValue
import de.darkatra.bfme2.ini.model.common.SageIniValueType.StructValue
import de.darkatra.bfme2.ini.model.common.elementType
import de.darkatra.bfme2.ini.model.draw.W3DModelDraw
import de.darkatra.bfme2.ini.model.nugget.ClearNuggets
import de.darkatra.bfme2.ini.model.nugget.DamageNugget
import de.darkatra.bfme2.ini.model.`object`.AIBase
import de.darkatra.bfme2.ini.model.`object`.Armor
import de.darkatra.bfme2.ini.model.`object`.ArmorSet
import de.darkatra.bfme2.ini.model.`object`.AudioEvent
import de.darkatra.bfme2.ini.model.`object`.CommandButton
import de.darkatra.bfme2.ini.model.`object`.CommandSet
import de.darkatra.bfme2.ini.model.`object`.FXList
import de.darkatra.bfme2.ini.model.`object`.Object
import de.darkatra.bfme2.ini.model.`object`.ObjectSection1
import de.darkatra.bfme2.ini.model.`object`.ThreatBreakdown
import de.darkatra.bfme2.ini.model.`object`.WeaponSet
import de.darkatra.bfme2.ini.model.particle.ParticleSystem
import de.darkatra.bfme2.ini.model.value.DamageType
import de.darkatra.bfme2.ini.model.value.KindOf
import de.darkatra.bfme2.ini.model.value.SageReference
import de.darkatra.bfme2.ini.model.value.SlotTypes
import de.darkatra.bfme2.ini.model.value.WeaponSlot
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SageIniModelDescriptorTest {

    @Test
    fun `should describe every model block with unique property names`() {

        assertThat(SageIniModel.blocks).hasSizeGreaterThan(650)
        SageIniModel.blocks.forEach { block ->
            assertThat(block.properties.map { it.name.lowercase() })
                .describedAs(block.name)
                .doesNotHaveDuplicates()
        }
    }

    @Test
    fun `should resolve all reference targets and nested block candidates`() {

        SageIniModel.blocks.flatMap { it.properties }.forEach { property ->
            when (val type = property.type.elementType()) {
                is ReferenceValue<*> -> assertThat(type.targets).describedAs(property.name).isNotEmpty()
                is BlockValue<*> -> assertThat(type.candidates).describedAs(property.name).isNotEmpty()
                else -> Unit
            }
        }
    }

    @Test
    fun `should expose the block metadata of the engine`() {

        assertThat(Object.tableKey).isEqualTo("objects")
        assertThat(Object.headerArity).isEqualTo(2)
        assertThat((CommandSet.numberedSlots!!.type as ReferenceValue<*>).targets).containsExactly(CommandButton)
        assertThat(ThreatBreakdown.keyedByLabel).isTrue()
        assertThat(ThreatBreakdown.equalsIsSpurious).isTrue()
        assertThat(ClearNuggets.bareDirective).isTrue()
        assertThat(AIBase.uniqueName).isFalse()
    }

    @Test
    fun `should read property values of data classes through their descriptors`() {

        val armorSet = ArmorSet(armor = SageReference("TreeArmor"))
        val armor = ArmorSet.property("armor")!!

        assertThat(armor.name).isEqualTo("Armor")
        assertThat(armor.get(armorSet)).isEqualTo(SageReference<Armor>("TreeArmor"))
        assertThat((armor.type as ReferenceValue<*>).targets).containsExactly(Armor)
    }

    @Test
    fun `should describe numbered slots`() {

        val commandSet = CommandSet(slots = mapOf(1 to SageReference("Command_ConstructElvenWarrior")))
        val slot = CommandSet.property("1")!!

        assertThat(slot.get(commandSet)).isEqualTo(SageReference<CommandButton>("Command_ConstructElvenWarrior"))
        assertThat(CommandSet.property("2")!!.get(commandSet)).isNull()
    }

    @Test
    fun `should describe the geometry marker group of objects`() {

        assertThat(Object.property("Geometry")).isNotNull
        assertThat(Object.property("AdditionalGeometry")).isNotNull
        assertThat(Object.property("GeometryMajorRadius")!!.type).isInstanceOf(ListValue::class.java)
    }

    @Test
    fun `should read properties of split blocks through their sections`() {

        val obj = Object(section1 = ObjectSection1(buildCost = 1200))

        assertThat(Object.property("BuildCost")!!.get(obj)).isEqualTo(1200)
    }

    @Test
    fun `should inherit the properties of base classes`() {

        assertThat(AutoHealBehavior.parent).isSameAs(UpgradeBehavior)
        assertThat(AutoHealBehavior.property("TriggeredBy")).isSameAs(UpgradeBehavior.property("TriggeredBy"))
        assertThat(AutoHealBehavior.property("HealingAmount")!!.get(AutoHealBehavior(healingAmount = 5))).isEqualTo(5)
        assertThat(AutoHealBehavior.isSubtypeOf(UpgradeBehavior)).isTrue()
    }

    @Test
    fun `should allow references to declarations of several kinds`() {

        val triggeredBy = UpgradeBehavior.property("TriggeredBy")!!.type.elementType() as ReferenceValue<*>
        assertThat(triggeredBy.targets.map { it.name }).containsExactlyInAnyOrder("Upgrade", "Science")

        val unitHealPulseFx = AutoHealBehavior.property("UnitHealPulseFX")!!.type as ReferenceValue<*>
        assertThat(unitHealPulseFx.targets).containsExactly(FXList)
    }

    @Test
    fun `should describe nested blocks and module slots`() {

        val behaviors = Object.property("Behavior")!!.type.elementType() as BlockValue<*>
        assertThat(behaviors.candidates).contains(AutoHealBehavior).hasSize(SageIniModel.behaviors.size)

        val modelConditionStates = W3DModelDraw.property("ModelConditionState")!!.type.elementType() as BlockValue<*>
        assertThat(modelConditionStates.candidates.map { it.name }).contains("ModelConditionState")

        assertThat(FXList.property("ParticleSystem")!!.type.elementType()).isInstanceOf(BlockValue::class.java)
        assertThat((FXList.property("ParticleSystem")!!.type.elementType() as BlockValue<*>).candidates).containsExactly(ParticleSystem)
    }

    @Test
    fun `should describe structured values by their components`() {

        val weapon = WeaponSet.property("Weapon")!!
        val slot = (weapon.type as ListValue<*>).element as StructValue<*>

        assertThat(slot.components.map { it.name }).containsExactly("Slot", "Weapon")
        assertThat(weapon.get(WeaponSet(weapon = listOf(WeaponSlot(slot = SlotTypes.PRIMARY))))).isEqualTo(listOf(WeaponSlot(slot = SlotTypes.PRIMARY)))
    }

    @Test
    fun `should collect every line of values that the engine accumulates`() {

        assertThat(AudioEvent.property("VolumeSliderMultiplier")!!.type).isInstanceOf(ListValue::class.java)
        assertThat(DamageNugget.property("DamageScalar")!!.type).isInstanceOf(ListValue::class.java)
        assertThat(Object.property("GeometryContactPoint")!!.type).isInstanceOf(ListValue::class.java)
        assertThat(HordeContain.property("RankInfo")!!.type).isInstanceOf(ListValue::class.java)
        assertThat(FCurve.property("Key")!!.type).isInstanceOf(ListValue::class.java)
    }

    @Test
    fun `should resolve enum tokens case-insensitively`() {

        assertThat(KindOf.type.entry("obstacle")).isEqualTo(KindOf.OBSTACLE)
        assertThat(DamageType.type.entry("+FORCE")).isEqualTo(DamageType.FORCE)
        assertThat(KindOf.type.entry("NotARealKindOf")).isNull()
    }

    @Test
    fun `should use the INI token of properties whose name is not a valid identifier`() {

        assertThat(RebuildHoleBehavior.property("HoleHealthRegen%PerSecond")).isNotNull
    }

    @Test
    fun `should find blocks by name case-insensitively`() {

        assertThat(SageIniModel.block("w3dmodeldraw")).isSameAs(W3DModelDraw)
        assertThat(SageIniModel.block("_DefeatCondition")).isNull()
        assertThat(SageIniModel.declarations).contains(Object, Armor).doesNotContain(ArmorSet)
    }
}
