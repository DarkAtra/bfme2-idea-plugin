package de.darkatra.bfme2.ini.model.syntax

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SageEngineIniSyntaxTest {

    @Test
    fun `should detect block openers by their exact keyword`() {

        assertThat(SageEngineIniSyntax.isBlockOpener("ModelConditionState", "DAMAGED")).isTrue()
        assertThat(SageEngineIniSyntax.isBlockOpener("modelconditionstate", null)).isFalse()
        assertThat(SageEngineIniSyntax.isBlockOpener("Radius", "fcurve")).isTrue()
        assertThat(SageEngineIniSyntax.isBlockOpener("AddEmotion", "OVERRIDE")).isTrue()
        assertThat(SageEngineIniSyntax.isBlockOpener("AddEmotion", "Terror_Base")).isFalse()
        assertThat(SageEngineIniSyntax.isBlockOpener("DisplayName", "OBJECT:ElvenMallornTree")).isFalse()
    }

    @Test
    fun `should detect bare value keys by their exact key`() {

        assertThat(SageEngineIniSyntax.isBareValueKey("RemoveModule")).isTrue()
        assertThat(SageEngineIniSyntax.isBareValueKey("clearnuggets")).isFalse()
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
        assertThat(SageEngineIniSyntax.isContextualBareValueKey("ObjectReskin", "CommandSet")).isTrue()
        assertThat(SageEngineIniSyntax.isContextualBareValueKey("ObjectReskin", "commandset")).isFalse()
    }
}
