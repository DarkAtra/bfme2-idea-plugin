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

        if (isInsideComment(tokenStart)) {
            if (isCommentSpacerPrefix(tokenStart) || startsComment(tokenStart)) {
                tokenEnd = tokenStart + 1
                while (tokenEnd < endOffset && isCommentSpacer(buffer[tokenEnd])) {
                    tokenEnd++
                }
                tokenType = SageEngineIniTokenTypes.COMMENT_SPACER
                return
            }

            tokenEnd = tokenStart + 1
            while (tokenEnd < endOffset && !Character.isWhitespace(buffer[tokenEnd]) && !startsComment(tokenEnd)) {
                tokenEnd++
            }
            tokenType = SageEngineIniTokenTypes.COMMENT_WORD
            return
        }

        if (currentChar == ';' || startsWith("//") || startsWith("--")) {
            tokenEnd = tokenStart + if (currentChar == ';') 1 else 2
            tokenType = SageEngineIniTokenTypes.COMMENT_START
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

        if (isPropertyValueStart() && startsNumberWithLetterSuffix()) {
            tokenEnd = tokenStart + 1
            while (tokenEnd < endOffset &&
                buffer[tokenEnd] != '\n' &&
                buffer[tokenEnd] != '\r' &&
                !Character.isWhitespace(buffer[tokenEnd]) &&
                !startsComment(tokenEnd)
            ) {
                tokenEnd++
            }
            tokenType = SageEngineIniTokenTypes.VALUE
            return
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

        if (isPropertyValueStart()) {
            tokenEnd = tokenStart + 1
            while (tokenEnd < endOffset &&
                buffer[tokenEnd] != '\n' &&
                buffer[tokenEnd] != '\r' &&
                !Character.isWhitespace(buffer[tokenEnd]) &&
                !startsComment(tokenEnd) &&
                !isCoordinateSeparator(tokenEnd)
            ) {
                tokenEnd++
            }
            tokenType = SageEngineIniTokenTypes.VALUE
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
                isPossibleBlockStart() -> SageEngineIniTokenTypes.BLOCK_START
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

    private fun isPossibleBlockStart(): Boolean {

        val words = textUntilLineEndIgnoringComments().split(Regex("\\s+"))

        return POSSIBLY_BLOCK_STARTS.any { it.matches(words) }
    }

    private fun textUntilLineEndIgnoringComments(): String {

        var lineEndOffset = tokenStart
        while (lineEndOffset < endOffset && buffer[lineEndOffset] != '\n' && buffer[lineEndOffset] != '\r') {
            if (startsComment(lineEndOffset)) {
                break
            }
            lineEndOffset++
        }

        return buffer.substring(tokenStart, lineEndOffset).trim()
    }

    private fun isPropertyValueStart(): Boolean {
        var currentOffset = tokenStart - 1
        while (currentOffset >= startOffset && (buffer[currentOffset] == ' ' || buffer[currentOffset] == '\t')) {
            currentOffset--
        }
        return currentOffset >= startOffset && buffer[currentOffset] == '='
    }

    private fun isCoordinateSeparator(offset: Int): Boolean {
        return buffer[offset] == ':' && offset + 1 < endOffset && Character.isDigit(buffer[offset + 1])
    }

    private fun startsNumberWithLetterSuffix(): Boolean {
        if (!Character.isDigit(buffer[tokenStart]) && buffer[tokenStart] != '.') {
            return false
        }
        var currentOffset = tokenStart
        while (currentOffset < endOffset && (Character.isDigit(buffer[currentOffset]) || buffer[currentOffset] == '.')) {
            currentOffset++
        }
        return currentOffset < endOffset && Character.isLetter(buffer[currentOffset])
    }

    private fun startsComment(offset: Int): Boolean {
        return buffer[offset] == ';' || startsWith(offset, "//") || startsWith(offset, "--")
    }

    private fun isInsideComment(offset: Int): Boolean {

        var currentOffset = offset - 1
        while (currentOffset >= startOffset && buffer[currentOffset] != '\n' && buffer[currentOffset] != '\r') {
            if (buffer[currentOffset] == ';' || startsWith(currentOffset, "//") || startsWith(currentOffset, "--")) {
                return true
            }
            currentOffset--
        }

        return false
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

    private fun isCommentSpacer(c: Char): Boolean {
        return c == '/' || c == '-' || c == ',' || c == ';'
    }

    private fun isCommentSpacerPrefix(offset: Int): Boolean {

        if (!isCommentSpacer(buffer[offset])) {
            return false
        }

        var currentOffset = offset - 1
        while (currentOffset >= startOffset && buffer[currentOffset] != '\n' && buffer[currentOffset] != '\r') {
            if (buffer[currentOffset] == ';') {
                return true
            }
            if (currentOffset > startOffset &&
                ((buffer[currentOffset - 1] == '/' && buffer[currentOffset] == '/') ||
                    (buffer[currentOffset - 1] == '-' && buffer[currentOffset] == '-'))
            ) {
                return true
            }
            if (!isCommentSpacer(buffer[currentOffset])) {
                return false
            }
            currentOffset--
        }

        return false
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
            "UnitSpecificSounds",
            "ThreatBreakdown",
            "MeleeBehavior",
            "AutoResolveArmor",
            "AutoResolveWeapon",
            "FormationPreviewItemDecal",
            "FireWeaponNugget",
            "TransitionState",
            "PredefinedEvaEvent",
            "SideSound",
            "NewEvaEvent",
            "ParticleSystem",
            "ViewShake",
            "CameraShakerVolume",
            "DynamicDecal",
            "TerrainScorch",
            "BuffNugget",
            "TintDrawable",
            "FXParticleSystem",
            "System",
            "Update",
            "Physics",
            "EmissionVelocity",
            "EmissionVolume",
            "Alpha",
            "Wind",
            "HouseColor",
            "InGameUI",
            "RadiusCursorTemplate",
            "LivingWorldMapInfo",
            "EyeTower",
            "LivingWorldArmyIcon",
            "LivingWorldAnimObject",
            "LivingWorldSound",
            "LivingWorldObject",
            "LivingWorldBuilding",
            "BuildingNugget",
            "ArmyToSpawn",
            "PlayerTemplate",
            "AudioEvent",
            "Multisound",
            "Stance",
            "ProjectileNugget",
            "DamageNugget",
            "MetaImpactNugget",
            "WeaponOCLNugget",
            "AttributeModifierNugget",
            "StealMoneyNugget",
            "ClientUpdate",
        )
        private val POSSIBLY_BLOCK_STARTS: Set<SageEngineIniPossibleBlockMatcher> = setOf(
            SageEngineIniPossibleBlockMatcher { words -> words.take(3) == listOf("AddEmotion", "=", "OVERRIDE") },
            SageEngineIniPossibleBlockMatcher { words -> words == listOf("Color", "=", "DefaultColor") },
            SageEngineIniPossibleBlockMatcher { words -> words.size == 2 && words.first() == "Locomotor" },
            SageEngineIniPossibleBlockMatcher { words -> words.size == 1 && words.first() == "AutoResolveBody" },
            SageEngineIniPossibleBlockMatcher { words -> words.size == 2 && words.first() == "FXList" },
            SageEngineIniPossibleBlockMatcher { words -> words.size == 2 && words.first() == "StanceTemplate" },
            SageEngineIniPossibleBlockMatcher { words -> words.size == 2 && words.first() == "Weapon" },
            SageEngineIniPossibleBlockMatcher { words -> words.size == 1 && words.first() == "Sound" },
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
