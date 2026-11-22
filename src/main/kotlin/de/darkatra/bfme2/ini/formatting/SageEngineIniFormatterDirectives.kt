package de.darkatra.bfme2.ini.formatting

/**
 * Formatting options that comments set for the lines below them, e.g. `; @formatter:align=all` or `; @formatter:align-column=65`.
 *
 * @param alignAllDefines whether the values of all defines are aligned, not just the ones of consecutive defines
 * @param defineValueColumn the 1-based column the values of defines start at the earliest
 */
data class SageEngineIniFormatterDirectives(val alignAllDefines: Boolean = false, val defineValueColumn: Int = 1) {

    /**
     * The options below a comment with the [commentText], or `null` if the comment sets none.
     */
    fun applying(commentText: String): SageEngineIniFormatterDirectives? {
        val align = ALIGN.find(commentText)?.groupValues?.get(1)
        val column = ALIGN_COLUMN.find(commentText)?.groupValues?.get(1)?.toIntOrNull()
        if (align == null && column == null) {
            return null
        }
        return copy(
            alignAllDefines = align?.equals("all", ignoreCase = true) ?: alignAllDefines,
            defineValueColumn = column ?: defineValueColumn,
        )
    }

    private companion object {
        val ALIGN = Regex("@formatter:align\\s*=\\s*(all|group)\\b", RegexOption.IGNORE_CASE)
        val ALIGN_COLUMN = Regex("@formatter:align-column\\s*=\\s*(\\d+)", RegexOption.IGNORE_CASE)
    }
}
