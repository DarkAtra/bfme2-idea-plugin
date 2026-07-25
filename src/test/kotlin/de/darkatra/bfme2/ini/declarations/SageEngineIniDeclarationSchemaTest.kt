package de.darkatra.bfme2.ini.declarations

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SageEngineIniDeclarationSchemaTest {

    @Test
    fun `should return declaration kinds referenced by property`() {

        assertThat(SageEngineIniDeclarationSchema.expectedKindsForProperty("Armor"))
            .containsExactly("Armor")
        assertThat(SageEngineIniDeclarationSchema.expectedKindsForProperty("TriggeredBy"))
            .containsExactlyInAnyOrder("Upgrade", "Science")
    }

    @Test
    fun `should return no declaration kinds for unknown or missing property`() {

        assertThat(SageEngineIniDeclarationSchema.expectedKindsForProperty("UnknownProperty")).isEmpty()
        assertThat(SageEngineIniDeclarationSchema.expectedKindsForProperty(null)).isEmpty()
    }

    @Test
    fun `should recognize declaration kinds`() {

        assertThat(SageEngineIniDeclarationSchema.isDeclarationKind("Weapon")).isTrue()
        assertThat(SageEngineIniDeclarationSchema.isDeclarationKind("Object")).isTrue()
        assertThat(SageEngineIniDeclarationSchema.isDeclarationKind("NotARealDeclarationKind")).isFalse()
    }

    @Test
    fun `should preserve the existing weapon slot value exclusion`() {

        assertThat(SageEngineIniDeclarationSchema.expectedKindsForPropertyValue("Weapon", "PRIMARY")).isEmpty()
        assertThat(SageEngineIniDeclarationSchema.expectedKindsForPropertyValue("Weapon", "SomeWeaponName"))
            .containsExactly("Weapon")
    }

    @Test
    fun `should derive references from the model`() {

        assertThat(SageEngineIniDeclarationSchema.expectedKindsForProperty("ButtonImageName")).containsExactly("MappedImage")
        assertThat(SageEngineIniDeclarationSchema.expectedKindsForProperty("UpgradeObject")).contains("ObjectCreationList")
        assertThat(SageEngineIniDeclarationSchema.expectedKindsForProperty("InitialPayload")).containsExactlyInAnyOrder("Object", "ChildObject", "ObjectReskin")
        assertThat(SageEngineIniDeclarationSchema.expectedKindsForProperty("RadiusCursorType")).containsExactly("RadiusCursorTemplate")
        assertThat(SageEngineIniDeclarationSchema.expectedKindsForProperty("EvaEventDieOwner")).containsExactlyInAnyOrder("NewEvaEvent", "PredefinedEvaEvent")
    }

    @Test
    fun `should reference command buttons from numbered command set slots`() {

        assertThat(SageEngineIniDeclarationSchema.expectedKindsForProperty("1")).containsExactly("CommandButton")
    }

    @Test
    fun `should match property names case-insensitively`() {

        assertThat(SageEngineIniDeclarationSchema.expectedKindsForProperty("armor")).containsExactly("Armor")
    }

    @Test
    fun `should not reference declarations with enum tokens of structured values`() {

        assertThat(SageEngineIniDeclarationSchema.expectedKindsForPropertyValue("Weapon", "secondary")).isEmpty()
    }

    @Test
    fun `should not treat non-declaration blocks as declaration kinds`() {

        assertThat(SageEngineIniDeclarationSchema.isDeclarationKind("ParticleSystem")).isFalse()
        assertThat(SageEngineIniDeclarationSchema.isDeclarationKind("Sound")).isFalse()
        assertThat(SageEngineIniDeclarationSchema.isDeclarationKind("ArmorSet")).isFalse()
        assertThat(SageEngineIniDeclarationSchema.isDeclarationKind("Animation")).isFalse()
        assertThat(SageEngineIniDeclarationSchema.isDeclarationKind("ChildObject")).isTrue()
    }
}
