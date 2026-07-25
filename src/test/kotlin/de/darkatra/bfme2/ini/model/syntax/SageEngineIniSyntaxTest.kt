package de.darkatra.bfme2.ini.model.syntax

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SageEngineIniSyntaxTest {

    @Test
    fun `should detect block openers case insensitively`() {

        assertThat(SageEngineIniSyntax.isBlockOpener("ModelConditionState", "DAMAGED")).isTrue()
        assertThat(SageEngineIniSyntax.isBlockOpener("modelconditionstate", null)).isTrue()
        assertThat(SageEngineIniSyntax.isBlockOpener("Radius", "fcurve")).isTrue()
        assertThat(SageEngineIniSyntax.isBlockOpener("AddEmotion", "OVERRIDE")).isTrue()
        assertThat(SageEngineIniSyntax.isBlockOpener("AddEmotion", "Terror_Base")).isFalse()
        assertThat(SageEngineIniSyntax.isBlockOpener("DisplayName", "OBJECT:ElvenMallornTree")).isFalse()
    }

    @Test
    fun `should detect bare value keys case insensitively`() {

        assertThat(SageEngineIniSyntax.isBareValueKey("RemoveModule")).isTrue()
        assertThat(SageEngineIniSyntax.isBareValueKey("clearnuggets")).isTrue()
        assertThat(SageEngineIniSyntax.isBareValueKey("ArmorSet")).isFalse()
    }

    @Test
    fun `should only apply contextual rules inside their parent block`() {

        assertThat(SageEngineIniSyntax.isContextualBlockOpener("FXParticleSystem", "Color")).isTrue()
        assertThat(SageEngineIniSyntax.isContextualBlockOpener("Draw", "Color")).isFalse()
        assertThat(SageEngineIniSyntax.isContextualBlockOpener(null, "Color")).isFalse()

        assertThat(SageEngineIniSyntax.isContextualBareValueKey("Object", "CommandSet")).isTrue()
        assertThat(SageEngineIniSyntax.isContextualBareValueKey(null, "CommandSet")).isFalse()
    }

    @Test
    fun `should share the contextual rules of objects with child objects and reskins`() {

        assertThat(SageEngineIniSyntax.isContextualBareValueKey("ChildObject", "CommandSet")).isTrue()
        assertThat(SageEngineIniSyntax.isContextualBareValueKey("ObjectReskin", "commandset")).isTrue()
    }
}
