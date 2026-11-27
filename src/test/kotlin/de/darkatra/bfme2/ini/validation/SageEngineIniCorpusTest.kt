package de.darkatra.bfme2.ini.validation

import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.application.runWriteAction
import com.intellij.openapi.vfs.PersistentFSConstants
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase
import org.assertj.core.api.Assertions.assertThat
import org.junit.Assume.assumeTrue
import org.junit.Test
import java.io.File

/**
 * Runs the model inspections over real INI files to find false positives, e.g. the base game files.
 * Opt-in because the files aren't part of the repository: set `BFME2_INI_CORPUS` to one or more
 * directories separated by `File.pathSeparator`.
 */
class SageEngineIniCorpusTest : LightPlatformCodeInsightFixture4TestCase() {

    @Test
    fun `should not report problems in the INI files of the corpus`() {

        val directories = System.getenv(CORPUS_VARIABLE)?.split(File.pathSeparator)?.filter { it.isNotBlank() }.orEmpty()
        assumeTrue("$CORPUS_VARIABLE isn't set", directories.isNotEmpty())

        myFixture.enableInspections(
            SageEngineIniUnknownBlockInspection(),
            SageEngineIniUnknownPropertyInspection(),
            SageEngineIniInvalidValueInspection(),
        )

        // files like the voice.ini of mods are larger than the IDE's default limit, above which they aren't parsed
        val maxFileSize = PersistentFSConstants.getMaxIntellisenseFileSize()
        PersistentFSConstants.setMaxIntellisenseFileSize(MAX_FILE_SIZE)
        val problems = try {
            directories.map(::File).flatMap(::problems)
        } finally {
            PersistentFSConstants.setMaxIntellisenseFileSize(maxFileSize)
        }

        val knownProblems = knownProblems()
        assertThat(problems.filterNot { it.replace(LINE_NUMBER, ":") in knownProblems }).isEmpty()
    }

    // problems of the base game and Age of the Ring files themselves, e.g. typos and blocks closed in an included file
    private fun knownProblems(): Set<String> {
        return javaClass.getResource("/corpus/known-problems.txt")!!.readText().lines().filter { it.isNotBlank() }.toSet()
    }

    // the whole corpus is part of the project, like in the IDE, so that macros and declarations of other files resolve
    private fun problems(directory: File): List<String> {

        val root = myFixture.tempDirFixture.copyAll(directory.path, directory.name)
        val problems = directory.walkTopDown()
            .filter { it.isFile && it.extension.lowercase() in EXTENSIONS }
            .map { it.relativeTo(directory).invariantSeparatorsPath }
            .sorted()
            .flatMap { path -> problems("${directory.name}/$path") }
            .toList()
        runWriteAction { root.delete(this) }
        return problems
    }

    private fun problems(path: String): List<String> {

        myFixture.configureFromTempProjectFile(path)
        val document = myFixture.editor.document
        return myFixture.doHighlighting(HighlightSeverity.WEAK_WARNING).map { info ->
            "$path:${document.getLineNumber(info.startOffset) + 1}: ${info.description}"
        }
    }

    private companion object {
        const val CORPUS_VARIABLE = "BFME2_INI_CORPUS"
        val EXTENSIONS = setOf("ini", "inc")
        const val MAX_FILE_SIZE = 16 * 1024 * 1024
        val LINE_NUMBER = Regex(":\\d+:")
    }
}
