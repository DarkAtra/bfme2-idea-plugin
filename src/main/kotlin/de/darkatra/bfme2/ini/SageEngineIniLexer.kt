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
    private var state = STATE_DEFAULT
    private var tokenState = STATE_DEFAULT

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        this.buffer = buffer
        this.startOffset = startOffset
        this.endOffset = endOffset
        this.tokenStart = startOffset
        this.state = initialState
        locateToken()
    }

    override fun getState(): Int {
        return tokenState
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

        tokenState = state

        if (tokenStart >= endOffset) {
            tokenType = null
            tokenEnd = tokenStart
            return
        }

        val currentChar = buffer[tokenStart]

        if (isScriptState(tokenState)) {
            locateScriptToken(currentChar)
            return
        }

        if (isWhitespace(currentChar)) {
            finishToken(scanWhile(tokenStart + 1, ::isWhitespace), TokenType.WHITE_SPACE)
            return
        }

        if (isCommentState(tokenState)) {
            locateCommentToken(currentChar)
            return
        }

        if (currentChar == ';' || startsWith("//") || startsWith("--")) {
            finishToken(tokenStart + if (currentChar == ';') 1 else 2, SageEngineIniTokenTypes.COMMENT_START)
            return
        }

        if (currentChar == '#') {
            finishToken(scanWhile(tokenStart + 1, ::isMacroNamePart), SageEngineIniTokenTypes.MACRO)
            return
        }

        if (currentChar == '"') {
            finishToken(scanStringEnd(), SageEngineIniTokenTypes.STRING)
            return
        }

        when (currentChar) {
            '=' -> {
                finishToken(tokenStart + 1, SageEngineIniTokenTypes.EQUALS)
                return
            }

            ':' -> {
                finishToken(tokenStart + 1, SageEngineIniTokenTypes.COLON)
                return
            }

            ',' -> {
                finishToken(tokenStart + 1, SageEngineIniTokenTypes.COMMA)
                return
            }

            '%' -> {
                finishToken(tokenStart + 1, SageEngineIniTokenTypes.PERCENT)
                return
            }

            '(' -> {
                finishToken(tokenStart + 1, SageEngineIniTokenTypes.LPAREN)
                return
            }

            ')' -> {
                finishToken(tokenStart + 1, SageEngineIniTokenTypes.RPAREN)
                return
            }

            '{' -> {
                finishToken(tokenStart + 1, SageEngineIniTokenTypes.LBRACE)
                return
            }

            '}' -> {
                finishToken(tokenStart + 1, SageEngineIniTokenTypes.RBRACE)
                return
            }

            '+', '-', '*', '/', '<', '>', '!' -> {
                finishToken(tokenStart + 1, SageEngineIniTokenTypes.OPERATOR)
                return
            }
        }

        if (tokenState == STATE_PROPERTY_VALUE && startsNumberWithLetterSuffix()) {
            finishToken(scanPropertyValueEnd(stopAtCoordinateSeparator = false), SageEngineIniTokenTypes.VALUE)
            return
        }

        if (Character.isDigit(currentChar) || (currentChar == '.' && tokenStart + 1 < endOffset && Character.isDigit(buffer[tokenStart + 1]))) {
            finishToken(scanNumberEnd(), SageEngineIniTokenTypes.NUMBER)
            return
        }

        if (tokenState == STATE_PROPERTY_VALUE) {
            finishToken(scanPropertyValueEnd(stopAtCoordinateSeparator = true), SageEngineIniTokenTypes.VALUE)
            return
        }

        if (isWordStart(currentChar)) {
            tokenEnd = tokenStart + 1
            while (tokenEnd < endOffset && isWordPart(buffer[tokenEnd])) {
                tokenEnd++
            }
            val text = buffer.subSequence(tokenStart, tokenEnd).toString()
            finishToken(
                tokenEnd, when {
                BLOCK_STARTS.any { it.equals(text, true) } -> SageEngineIniTokenTypes.BLOCK_START
                BLOCK_ENDS.any { it.equals(text, true) } -> SageEngineIniTokenTypes.BLOCK_END
                isPossibleBlockStart() -> SageEngineIniTokenTypes.BLOCK_START
                isPropertyKey(tokenEnd) -> SageEngineIniTokenTypes.PROPERTY
                else -> SageEngineIniTokenTypes.VALUE
            })
            return
        }

        finishToken(tokenStart + 1, TokenType.BAD_CHARACTER)
    }

    private fun locateScriptToken(currentChar: Char) {
        if (startsWord(tokenStart, END_SCRIPT)) {
            finishToken(tokenStart + END_SCRIPT.length, SageEngineIniTokenTypes.BLOCK_END)
            return
        }

        if (isWhitespace(currentChar)) {
            finishToken(scanScriptTokenEnd { isWhitespace(it) }, TokenType.WHITE_SPACE)
            return
        }

        finishToken(scanScriptTokenEnd { !isWhitespace(it) }, SageEngineIniTokenTypes.SCRIPT_BODY)
    }

    private fun locateCommentToken(currentChar: Char) {
        if ((tokenState == STATE_COMMENT_SPACER && isCommentSpacer(currentChar)) || startsComment(tokenStart)) {
            finishToken(scanWhile(tokenStart + 1, ::isCommentSpacer), SageEngineIniTokenTypes.COMMENT_SPACER)
            return
        }

        finishToken(scanCommentWordEnd(), SageEngineIniTokenTypes.COMMENT_WORD)
    }

    private fun scanScriptTokenEnd(predicate: (Char) -> Boolean): Int {
        var currentOffset = tokenStart + 1
        while (currentOffset < endOffset && predicate(buffer[currentOffset]) && !startsWord(currentOffset, END_SCRIPT)) {
            currentOffset++
        }
        return currentOffset
    }

    private fun scanCommentWordEnd(): Int {
        var currentOffset = tokenStart + 1
        while (currentOffset < endOffset && !isWhitespace(buffer[currentOffset]) && !startsComment(currentOffset)) {
            currentOffset++
        }
        return currentOffset
    }

    private fun scanStringEnd(): Int {
        var currentOffset = tokenStart + 1
        var escaped = false
        while (currentOffset < endOffset && buffer[currentOffset] != '\n' && buffer[currentOffset] != '\r') {
            val ch = buffer[currentOffset++]
            if (ch == '"' && !escaped) {
                break
            }
            escaped = ch == '\\' && !escaped
            if (ch != '\\') {
                escaped = false
            }
        }
        return currentOffset
    }

    private fun scanNumberEnd(): Int {
        var currentOffset = tokenStart + 1
        while (currentOffset < endOffset) {
            val ch = buffer[currentOffset]
            if (!Character.isDigit(ch) && ch != '.') {
                break
            }
            currentOffset++
        }
        return currentOffset
    }

    private fun scanPropertyValueEnd(stopAtCoordinateSeparator: Boolean): Int {
        var currentOffset = tokenStart + 1
        while (currentOffset < endOffset &&
            !isLineBreak(buffer[currentOffset]) &&
            !isWhitespace(buffer[currentOffset]) &&
            !startsComment(currentOffset) &&
            (!stopAtCoordinateSeparator || !isCoordinateSeparator(currentOffset))
        ) {
            currentOffset++
        }
        return currentOffset
    }

    private fun scanWhile(offset: Int, predicate: (Char) -> Boolean): Int {
        var currentOffset = offset
        while (currentOffset < endOffset && predicate(buffer[currentOffset])) {
            currentOffset++
        }
        return currentOffset
    }

    private fun finishToken(end: Int, type: IElementType) {
        tokenEnd = end
        tokenType = type
        state = nextState(type)
    }

    private fun nextState(type: IElementType): Int {
        if (isScriptState(tokenState)) {
            return when {
                type === SageEngineIniTokenTypes.BLOCK_END && tokenTextEquals(END_SCRIPT) -> decreaseScriptState(tokenState)
                type === SageEngineIniTokenTypes.SCRIPT_BODY && tokenTextEquals(BEGIN_SCRIPT) -> tokenState + 1
                else -> tokenState
            }
        }

        if (tokenContainsLineBreak()) {
            return STATE_DEFAULT
        }

        if (type === SageEngineIniTokenTypes.COMMENT_START) {
            return STATE_COMMENT_SPACER
        }

        if (isCommentState(tokenState)) {
            return if (type === SageEngineIniTokenTypes.COMMENT_SPACER) STATE_COMMENT_SPACER else STATE_COMMENT
        }

        if (type === SageEngineIniTokenTypes.EQUALS) {
            return STATE_PROPERTY_VALUE
        }

        if (tokenState == STATE_PROPERTY_VALUE) {
            return STATE_PROPERTY_VALUE
        }

        if (type === SageEngineIniTokenTypes.BLOCK_START && tokenTextEquals(BEGIN_SCRIPT)) {
            return STATE_SCRIPT_BASE + 1
        }

        return STATE_DEFAULT
    }

    private fun decreaseScriptState(state: Int): Int {
        return if (state > STATE_SCRIPT_BASE + 1) state - 1 else STATE_DEFAULT
    }

    private fun tokenTextEquals(text: String): Boolean {
        return tokenEnd - tokenStart == text.length && startsWord(tokenStart, text)
    }

    private fun tokenContainsLineBreak(): Boolean {
        for (i in tokenStart until tokenEnd) {
            if (isLineBreak(buffer[i])) {
                return true
            }
        }
        return false
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
        while (lineEndOffset < endOffset && !isLineBreak(buffer[lineEndOffset])) {
            if (startsComment(lineEndOffset)) {
                break
            }
            lineEndOffset++
        }

        return buffer.substring(tokenStart, lineEndOffset).trim()
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

    private fun isWhitespace(c: Char): Boolean {
        return Character.isWhitespace(c)
    }

    private fun isLineBreak(c: Char): Boolean {
        return c == '\n' || c == '\r'
    }

    private fun isMacroNamePart(c: Char): Boolean {
        return c in 'A'..'Z' || c in 'a'..'z'
    }

    private fun isCommentSpacerPrefix(offset: Int): Boolean {

        if (!isCommentSpacer(buffer[offset])) {
            return false
        }

        var currentOffset = offset - 1
        while (currentOffset >= startOffset && !isLineBreak(buffer[currentOffset])) {
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

    private fun startsWord(offset: Int, text: String): Boolean {
        if (offset > startOffset && isWordPart(buffer[offset - 1])) {
            return false
        }
        if (offset + text.length > endOffset) {
            return false
        }
        for (i in text.indices) {
            if (!buffer[offset + i].equals(text[i], true)) {
                return false
            }
        }
        return offset + text.length >= endOffset || !isWordPart(buffer[offset + text.length])
    }

    companion object {
        private const val STATE_DEFAULT = 0
        private const val STATE_COMMENT = 1
        private const val STATE_PROPERTY_VALUE = 2
        private const val STATE_COMMENT_SPACER = 3
        private const val STATE_SCRIPT_BASE = 100
        private const val BEGIN_SCRIPT = "BeginScript"
        private const val END_SCRIPT = "EndScript"

        private fun isCommentState(state: Int): Boolean {
            return state == STATE_COMMENT || state == STATE_COMMENT_SPACER
        }

        private fun isScriptState(state: Int): Boolean {
            return state >= STATE_SCRIPT_BASE
        }

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
            "HordeAttackNugget",
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
