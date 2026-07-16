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
}