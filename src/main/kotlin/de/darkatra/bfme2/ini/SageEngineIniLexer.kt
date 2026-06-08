package de.darkatra.bfme2.ini

import com.intellij.lexer.LexerBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes

class SageEngineIniLexer : LexerBase() {

    private var buffer: CharSequence = ""
    private var startOffset = 0
    private var endOffset = 0
    private var tokenStart = 0
    private var tokenEnd = 0
    private var tokenType: IElementType? = null

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        this.buffer = buffer
        this.startOffset = startOffset
        this.endOffset = endOffset
        this.tokenStart = startOffset
        locateToken()
    }

    override fun getState(): Int {
        return 0
    }

    override fun getTokenType(): IElementType? {
        return tokenType
    }

    override fun getTokenStart(): Int {
        return tokenStart
    }

    override fun getTokenEnd(): Int {
        return tokenEnd
    }

    override fun advance() {
        tokenStart = tokenEnd
        locateToken()
    }

    override fun getBufferSequence(): CharSequence {
        return buffer
    }

    override fun getBufferEnd(): Int {
        return endOffset
    }

    private fun locateToken() {

        if (tokenStart >= endOffset) {
            tokenType = null
            tokenEnd = tokenStart
            return
        }

        val currentChar = buffer[tokenStart]

        if (Character.isWhitespace(currentChar)) {
            tokenEnd = tokenStart + 1
            while (tokenEnd < endOffset && Character.isWhitespace(buffer[tokenEnd])) {
                tokenEnd++
            }
            tokenType = TokenType.WHITE_SPACE
            return
        }

        if (currentChar == ';' || startsWith("//") || startsWith("--")) {
            tokenEnd = tokenStart + 1
            while (tokenEnd < endOffset && buffer[tokenEnd] != '\n' && buffer[tokenEnd] != '\r') {
                tokenEnd++
            }
            tokenType = SageEngineIniTokenTypes.COMMENT
            return
        }

        if (isPropertyValueStart()) {
            tokenEnd = tokenStart + 1
            while (tokenEnd < endOffset && buffer[tokenEnd] != '\n' && buffer[tokenEnd] != '\r' && !startsComment(tokenEnd)) {
                tokenEnd++
            }
            while (tokenEnd > tokenStart && (buffer[tokenEnd - 1] == ' ' || buffer[tokenEnd - 1] == '\t')) {
                tokenEnd--
            }
            tokenType = SageEngineIniTokenTypes.VALUE
            return
        }

        if (currentChar == '#') {
            tokenEnd = tokenStart + 1
            while (tokenEnd < endOffset && Character.isLetter(buffer[tokenEnd])) { // TODO: macro name must match: [a-zA-Z]+
                tokenEnd++
            }
            tokenType = SageEngineIniTokenTypes.MACRO
            return
        }

        if (currentChar == '"') {
            tokenEnd = tokenStart + 1
            var escaped = false
            while (tokenEnd < endOffset && buffer[tokenEnd] != '\n' && buffer[tokenEnd] != '\r') {
                val ch = buffer[tokenEnd++]
                if (ch == '"' && !escaped) {
                    break
                }
                escaped = ch == '\\' && !escaped
                if (ch != '\\') {
                    escaped = false
                }
            }
            tokenType = SageEngineIniTokenTypes.STRING
            return
        }

        when (currentChar) {
            '=' -> {
                tokenEnd = tokenStart + 1
                tokenType = SageEngineIniTokenTypes.EQUALS
                return
            }

            ':' -> {
                tokenEnd = tokenStart + 1
                tokenType = SageEngineIniTokenTypes.COLON
                return
            }

            ',' -> {
                tokenEnd = tokenStart + 1
                tokenType = SageEngineIniTokenTypes.COMMA
                return
            }

            '%' -> {
                tokenEnd = tokenStart + 1
                tokenType = SageEngineIniTokenTypes.PERCENT
                return
            }

            '(' -> {
                tokenEnd = tokenStart + 1
                tokenType = SageEngineIniTokenTypes.LPAREN
                return
            }

            ')' -> {
                tokenEnd = tokenStart + 1
                tokenType = SageEngineIniTokenTypes.RPAREN
                return
            }

            '{' -> {
                tokenEnd = tokenStart + 1
                tokenType = SageEngineIniTokenTypes.LBRACE
                return
            }

            '}' -> {
                tokenEnd = tokenStart + 1
                tokenType = SageEngineIniTokenTypes.RBRACE
                return
            }

            '+', '-', '*', '/', '<', '>', '!' -> {
                tokenEnd = tokenStart + 1
                tokenType = SageEngineIniTokenTypes.OPERATOR
                return
            }
        }

        if (Character.isDigit(currentChar) || (currentChar == '.' && tokenStart + 1 < endOffset && Character.isDigit(buffer[tokenStart + 1]))) {
            tokenEnd = tokenStart + 1
            while (tokenEnd < endOffset) {
                val ch = buffer[tokenEnd]
                if (!Character.isDigit(ch) && ch != '.') break
                tokenEnd++
            }
            tokenType = SageEngineIniTokenTypes.NUMBER
            return
        }

        if (isWordStart(currentChar)) {
            tokenEnd = tokenStart + 1
            while (tokenEnd < endOffset && isWordPart(buffer[tokenEnd])) {
                tokenEnd++
            }
            val text = buffer.subSequence(tokenStart, tokenEnd).toString()
            tokenType = when {
                BLOCK_STARTS.any { it.equals(text, true) } -> SageEngineIniTokenTypes.BLOCK_START
                BLOCK_ENDS.any { it.equals(text, true) } -> SageEngineIniTokenTypes.BLOCK_END
                isPropertyKey(tokenEnd) -> SageEngineIniTokenTypes.PROPERTY
                else -> SageEngineIniTokenTypes.VALUE
            }
            return
        }

        tokenEnd = tokenStart + 1
        tokenType = TokenType.BAD_CHARACTER
    }

    private fun startsWith(text: String): Boolean {
        if (tokenStart + text.length > endOffset) {
            return false
        }
        for (i in text.indices) {
            if (buffer[tokenStart + i] != text[i]) {
                return false
            }
        }
        return true
    }

    private fun isPropertyKey(offset: Int): Boolean {
        if (!isOnlyLetters(tokenStart, offset)) {
            return false
        }
        var currentOffset = offset
        while (currentOffset < endOffset && (buffer[currentOffset] == ' ' || buffer[currentOffset] == '\t')) {
            currentOffset++
        }
        return currentOffset < endOffset && buffer[currentOffset] == '='
    }

    private fun isPropertyValueStart(): Boolean {
        var currentOffset = tokenStart - 1
        while (currentOffset >= startOffset && (buffer[currentOffset] == ' ' || buffer[currentOffset] == '\t')) {
            currentOffset--
        }
        return currentOffset >= startOffset && buffer[currentOffset] == '='
    }

    private fun startsComment(offset: Int): Boolean {
        return buffer[offset] == ';' || startsWith(offset, "//") || startsWith(offset, "--")
    }

    private fun startsWith(offset: Int, text: String): Boolean {
        if (offset + text.length > endOffset) {
            return false
        }
        for (i in text.indices) {
            if (buffer[offset + i] != text[i]) {
                return false
            }
        }
        return true
    }

    private fun isOnlyLetters(start: Int, end: Int): Boolean {
        for (i in start until end) {
            if (!Character.isLetter(buffer[i])) {
                return false
            }
        }
        return true
    }

    companion object {
        private val BLOCK_STARTS = setOf(
            "Object",
            "ChildObject",
            "Draw",
            "Behavior",
            "Body",
            "ArmorSet",
            "WeaponSet",
            "LocomotorSet",
            "DefaultModelConditionState",
            "ModelConditionState",
            "AnimationState",
            "IdleAnimationState",
            "Animation",
            "BeginScript",
            "ClientBehavior",
            "Flammability",
            "UnitSpecificSounds"
        )
        private val BLOCK_ENDS = setOf(
            "End",
            "EndScript"
        )

        private fun isWordStart(c: Char): Boolean {
            return Character.isLetter(c) || c == '_' || c == '$'
        }

        private fun isWordPart(c: Char): Boolean {
            return Character.isLetterOrDigit(c) || c == '_' || c == '.' || c == '-' || c == '$'
        }
    }
}
