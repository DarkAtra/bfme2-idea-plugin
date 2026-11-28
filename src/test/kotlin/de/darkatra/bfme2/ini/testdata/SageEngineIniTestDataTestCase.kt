package de.darkatra.bfme2.ini.testdata

import com.intellij.openapi.application.runWriteAction
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixture4TestCase
import java.io.File

/**
 * Base class of the file based tests that need the files of a case in the project.
 */
abstract class SageEngineIniTestDataTestCase : LightPlatformCodeInsightFixture4TestCase() {

    /**
     * Adds the input files of [case] to the project, without their `<caret>` markers, so that they can reference each other, and removes them
     * again afterwards, so that the declarations of one case don't leak into the next.
     */
    protected fun <T> withCaseFiles(case: SageEngineIniTestCase, block: (Map<File, VirtualFile>) -> T): T {
        val directory = "cases/${case.name}"
        val files = case.inputs.associateWith { input ->
            myFixture.addFileToProject("$directory/${case.relativePath(input)}", SageEngineIniTestData.text(input).replace(SageEngineIniTestData.CARET, "")).virtualFile
        }
        try {
            return block(files)
        } finally {
            runWriteAction { myFixture.findFileInTempDir(directory)?.delete(this) }
        }
    }

    /**
     * Opens the input file of the case that contains the `<caret>` marker and moves the caret there.
     */
    protected fun openAtCaret(files: Map<File, VirtualFile>): File {
        val (input, virtualFile) = files.entries.singleOrNull { SageEngineIniTestData.text(it.key).contains(SageEngineIniTestData.CARET) }
            ?: throw AssertionError("exactly one file needs a ${SageEngineIniTestData.CARET} marker")
        myFixture.openFileInEditor(virtualFile)
        myFixture.editor.caretModel.moveToOffset(SageEngineIniTestData.text(input).indexOf(SageEngineIniTestData.CARET))
        return input
    }
}
