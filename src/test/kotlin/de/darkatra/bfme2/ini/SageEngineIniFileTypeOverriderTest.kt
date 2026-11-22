package de.darkatra.bfme2.ini

import com.intellij.openapi.fileTypes.PlainTextFileType
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase
import com.intellij.util.indexing.FileBasedIndex
import de.darkatra.bfme2.ini.declarations.SAGE_ENGINE_INI_DECLARATION_INDEX_ID
import de.darkatra.bfme2.ini.declarations.SAGE_ENGINE_INI_MACRO_INDEX_ID
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SageEngineIniFileTypeOverriderTest : LightPlatformCodeInsightFixture4TestCase() {

    @Test
    fun `should treat standard ini files with section headers as plain text`() {

        myFixture.configureByText(
            "Enable timer.ini",
            """
            ; launcher release
            [information]
            category=4
            Object ElvenMallornTree
            #define TIMER_SIZE 1

            [enableFiles]
            1\name=!202timer.big
            size=1
            """.trimIndent()
        )

        val file = myFixture.file.virtualFile
        assertThat(file.fileType).isEqualTo(PlainTextFileType.INSTANCE)
        assertThat(myFixture.file.language).isNotEqualTo(SageEngineIniLanguage)
        assertThat(FileBasedIndex.getInstance().getFileData(SAGE_ENGINE_INI_DECLARATION_INDEX_ID, file, project)).isEmpty()
        assertThat(FileBasedIndex.getInstance().getFileData(SAGE_ENGINE_INI_MACRO_INDEX_ID, file, project)).isEmpty()
    }

    @Test
    fun `should keep game ini files that start with comments and macros`() {

        myFixture.configureByText(
            "object.ini",
            """
            ;------------------------------------------------------------------------------
            // Elven buildings
            #define TREE_HEALTH 500
            Object ElvenMallornTree
                Armor = ToughHeroArmor
            End
            """.trimIndent()
        )

        val file = myFixture.file.virtualFile
        assertThat(file.fileType).isEqualTo(SageEngineIniFileType)
        assertThat(FileBasedIndex.getInstance().getFileData(SAGE_ENGINE_INI_DECLARATION_INDEX_ID, file, project).keys)
            .contains("Object elvenmallorntree")
        assertThat(FileBasedIndex.getInstance().getFileData(SAGE_ENGINE_INI_MACRO_INDEX_ID, file, project).keys)
            .containsExactly("tree_health")
    }
}
