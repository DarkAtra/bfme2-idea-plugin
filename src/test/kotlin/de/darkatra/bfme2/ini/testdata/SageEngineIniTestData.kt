package de.darkatra.bfme2.ini.testdata

import java.io.File

/**
 * A case of the file based tests: input files and the files with their expected output next to them. A case is either a single file of a
 * feature directory, e.g. `syntax/object.ini` with the expected output `syntax/object.tokens.txt`, or a directory with several input
 * files that reference each other, e.g. `inspections/SageEngineIniModuleTag/inheritance`, whose expected output is
 * `inheritance/expected.txt`.
 */
class SageEngineIniTestCase(val name: String, private val directory: File, val inputs: List<File>, private val isDirectory: Boolean) {

    fun expected(suffix: String): File {
        return when (isDirectory) {
            true -> File(directory, "expected$suffix")
            false -> File(directory, inputs.single().nameWithoutExtension + suffix)
        }
    }

    /**
     * The expected content of [input] after a change, e.g. `object.after.ini` for `object.ini`.
     */
    fun expectedAfter(input: File): File {
        return File(input.parentFile, "${input.nameWithoutExtension}.after.${input.extension}")
    }

    fun relativePath(input: File): String {
        return input.relativeTo(directory).invariantSeparatorsPath
    }

    override fun toString(): String {
        return name
    }
}

object SageEngineIniTestData {

    const val CARET = "<caret>"

    private val root = File("src/test/resources")

    fun cases(feature: String): List<SageEngineIniTestCase> {
        val directory = File(root, feature)
        val entries = directory.listFiles().orEmpty().sortedBy { it.name }
        val singleFiles = entries.filter { it.isFile && isInput(it) }.map { SageEngineIniTestCase("$feature/${it.name}", directory, listOf(it), false) }
        val directories = entries.filter { it.isDirectory }.map { caseDirectory ->
            val inputs = caseDirectory.walkTopDown().filter { it.isFile && isInput(it) }.sortedBy { it.path }.toList()
            SageEngineIniTestCase("$feature/${caseDirectory.name}", caseDirectory, inputs, true)
        }
        return singleFiles + directories
    }

    fun features(parent: String): List<String> {
        return File(root, parent).listFiles().orEmpty().filter { it.isDirectory }.map { "$parent/${it.name}" }.sorted()
    }

    fun text(input: File): String {
        return input.readText().replace("\r\n", "\n")
    }

    /**
     * Compares [actual] with the content of [expected]. A missing file is created with [actual], so that new cases only need their input,
     * but the test fails until the created file was reviewed.
     */
    fun assertExpected(expected: File, actual: String) {
        if (!expected.exists()) {
            expected.writeText(actual)
            throw AssertionError("${expected.path} didn't exist and was created, review it and run the test again")
        }
        val expectedText = text(expected)
        if (expectedText != actual) {
            throw AssertionError("${expected.path} differs from the actual output:\n--- expected\n$expectedText\n--- actual\n$actual")
        }
    }

    /**
     * Runs [check] for every case and reports the failures of all cases at once.
     */
    fun runCases(cases: List<SageEngineIniTestCase>, check: (SageEngineIniTestCase) -> Unit) {
        if (cases.isEmpty()) {
            throw AssertionError("there are no cases")
        }
        val failures = cases.mapNotNull { case ->
            runCatching { check(case) }.exceptionOrNull()?.let { "${case.name}: ${it.message ?: it}" }
        }
        if (failures.isNotEmpty()) {
            throw AssertionError("${failures.size} of ${cases.size} cases failed:\n\n" + failures.joinToString("\n\n"))
        }
    }

    private fun isInput(file: File): Boolean {
        return file.extension.lowercase() in setOf("ini", "inc") && !file.nameWithoutExtension.endsWith(".after")
    }
}
