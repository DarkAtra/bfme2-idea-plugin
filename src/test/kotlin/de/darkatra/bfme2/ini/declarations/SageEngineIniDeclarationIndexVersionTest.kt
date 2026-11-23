package de.darkatra.bfme2.ini.declarations

import de.darkatra.bfme2.ini.model.SageIniModel
import de.darkatra.bfme2.ini.model.syntax.SageEngineIniSyntax
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.security.MessageDigest

class SageEngineIniDeclarationIndexVersionTest {

    @Test
    fun `should bump the index version when the rules the index is built from change`() {

        val version = SageEngineIniDeclarationIndex().version
        val fingerprint = indexedRulesFingerprint()

        assertThat(version to fingerprint)
            .withFailMessage(
                "The declaration index has version $version and rules $fingerprint, but INDEXED_RULES records $INDEXED_RULES. " +
                    "If the rules changed, bump SageEngineIniDeclarationIndex.getVersion() and record the new version and rules in INDEXED_RULES."
            )
            .isEqualTo(INDEXED_RULES)
    }

    private fun indexedRulesFingerprint(): String {

        val propertyNames = buildList {
            SageIniModel.blocks.flatMapTo(this) { block -> block.declaredProperties.map { it.name } }
            addAll(SageEngineIniSyntax.topLevelKeys)
            add("1")
        }
        val prefixes = SageIniModel.blocks.flatMap { it.prefixedProperties }.map { it.prefix }
        val bareValueKeys = SageEngineIniSyntax.bareValueKeys + SageEngineIniSyntax.contextualBareValueKeys.values.flatten()

        val rules = buildList {
            SageEngineIniDeclarationSchema.declarationKinds.forEach { add("declaration $it") }
            propertyNames.forEach { add("property $it -> ${SageEngineIniDeclarationSchema.expectedKindsForProperty(it).sorted()}") }
            prefixes.forEach { prefix ->
                val name = prefix + "Suffix"
                val suffixKinds = SageEngineIniDeclarationSchema.prefixedNameReference(name)?.let { (length, kinds) -> length to kinds.sorted() }
                add("prefix $prefix -> $suffixKinds ${SageEngineIniDeclarationSchema.expectedKindsForProperty(name).sorted()}")
            }
            bareValueKeys.forEach { add("bare $it") }
            SageEngineIniDeclarationSchema.declarationKinds.filter { SageEngineIniDeclarationSchema.isLabeledDeclarationKind(it) }.forEach { add("labeled $it") }
        }.distinct().sorted()

        return MessageDigest.getInstance("SHA-256").digest(rules.joinToString("\n").toByteArray()).joinToString("") { "%02x".format(it) }
    }

    private companion object {
        val INDEXED_RULES = 28 to "e578fc5ec80316486422b844a37e1e76355c2443b4bbe54a4a70e8f41b5fe8a4"
    }
}
