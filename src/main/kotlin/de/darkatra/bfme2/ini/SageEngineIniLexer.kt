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
                KEYWORDS.contains(text) -> SageEngineIniTokenTypes.KEYWORD
                CONDITIONS.contains(text) -> SageEngineIniTokenTypes.CONDITION
                else -> SageEngineIniTokenTypes.PROPERTY // TODO: parse properties correctly
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

    companion object {
        private val KEYWORDS = mutableSetOf(
            "Object", "ChildObject", "End", "Draw", "Behavior", "Body", "ArmorSet", "WeaponSet",
            "CommandSet", "CommandButton", "LocomotorSet", "ObjectCreationList", "EvaEventDieOwner",
            "DefaultModelConditionState", "ModelConditionState", "AnimationState", "IdleAnimationState",
            "Animation", "BeginScript", "EndScript", "ClientBehavior", "Side", "KindOf",
            "BuildCost", "BuildTime", "DisplayName", "Description", "EditorSorting", "ThreatLevel"
        )

        private val CONDITIONS = mutableSetOf(
            "NONE", "None", "Yes", "No", "SNOW", "DAMAGED", "REALLYDAMAGED", "RUBBLE", "POST_RUBBLE",
            "POST_COLLAPSE", "AWAITING_CONSTRUCTION", "ACTIVELY_BEING_CONSTRUCTED", "PARTIALLY_CONSTRUCTED",
            "BUILD_PLACEMENT_CURSOR", "PHANTOM_STRUCTURE", "MOVING", "ATTACKING", "DYING", "PASSENGER",
            "FREEFALL", "STUNNED", "STUNNED_FLAILING", "STUNNED_STANDING_UP", "BURNINGDEATH",
            "THROWN_PROJECTILE", "FIRING_OR_PREATTACK_A", "FIRING_OR_PREATTACK_B", "EMOTION_TERROR",
            "EMOTION_ALERT", "EMOTION_AFRAID", "EMOTION_UNCONTROLLABLY_AFRAID", "UPGRADE_ECONOMY_BONUS",
            "USER_1", "USER_2", "USER_3", "USER_4", "USER_5", "LOOP", "ONCE", "MANUAL", "RANDOMSTART",
            "RESTART_ANIM_WHEN_COMPLETE", "START_FRAME_FIRST", "FollowBone:Yes"
        )

        private fun isWordStart(c: Char): Boolean {
            return Character.isLetter(c) || c == '_' || c == '$'
        }

        private fun isWordPart(c: Char): Boolean {
            return Character.isLetterOrDigit(c) || c == '_' || c == '.' || c == '-' || c == '$'
        }
    }
}
