package de.darkatra.bfme2.ini

import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import de.darkatra.bfme2.ini.psi.SageEngineIniTokenTypes
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class SageEngineIniLexerTest {

    @Test
    fun `should lex simple property`() {

        assertTokens(
            "SelectPortrait = KUMilPortrait",
            SageEngineIniTokenTypes.PROPERTY to "SelectPortrait",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.EQUALS to "=",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "KUMilPortrait",
        )
    }

    @Test
    fun `should lex property with numbers`() {

        assertTokens(
            "Alpha1 = 1 1 0",
            SageEngineIniTokenTypes.PROPERTY to "Alpha1",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.EQUALS to "=",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.NUMBER to "1",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.NUMBER to "1",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.NUMBER to "0",
        )
    }

    @Test
    fun `should stop lexing properties at line end`() {

        assertTokens(
            """
            Behavior = HordeContain ModuleTag_HordeContain
                FrontAngle              = 270
                ObjectStatusOfContained =
                InitialPayload          = WildBabyDrake 3
            End
            """.trimIndent(),
            SageEngineIniTokenTypes.BLOCK_START to "Behavior",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.EQUALS to "=",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "HordeContain",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "ModuleTag_HordeContain",
            TokenType.WHITE_SPACE to "\n    ",
            SageEngineIniTokenTypes.PROPERTY to "FrontAngle",
            TokenType.WHITE_SPACE to "              ",
            SageEngineIniTokenTypes.EQUALS to "=",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.NUMBER to "270",
            TokenType.WHITE_SPACE to "\n    ",
            SageEngineIniTokenTypes.PROPERTY to "ObjectStatusOfContained",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.EQUALS to "=",
            TokenType.WHITE_SPACE to "\n    ",
            SageEngineIniTokenTypes.PROPERTY to "InitialPayload",
            TokenType.WHITE_SPACE to "          ",
            SageEngineIniTokenTypes.EQUALS to "=",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "WildBabyDrake",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.NUMBER to "3",
            TokenType.WHITE_SPACE to "\n",
            SageEngineIniTokenTypes.BLOCK_END to "End",
        )
    }

    @Test
    fun `should lex comments correctly`() {

        assertTokens(
            ";// some words //;",
            SageEngineIniTokenTypes.COMMENT_START to ";",
            SageEngineIniTokenTypes.COMMENT_SPACER to "//",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.COMMENT_WORD to "some",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.COMMENT_WORD to "words",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.COMMENT_SPACER to "//;",
        )

        assertTokens(
            "; *** AUDIO Parameters *** ;",
            SageEngineIniTokenTypes.COMMENT_START to ";",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.COMMENT_WORD to "***",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.COMMENT_WORD to "AUDIO",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.COMMENT_WORD to "Parameters",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.COMMENT_WORD to "***",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.COMMENT_SPACER to ";",
        )

        assertTokens(
            ";,, decorative header //;",
            SageEngineIniTokenTypes.COMMENT_START to ";",
            SageEngineIniTokenTypes.COMMENT_SPACER to ",,",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.COMMENT_WORD to "decorative",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.COMMENT_WORD to "header",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.COMMENT_SPACER to "//;",
        )
    }

    @Test
    fun `should lex property value with operators correctly`() {

        assertTokens(
            "Query\t\t= 1 NONE\t +HERO ALLIES",
            SageEngineIniTokenTypes.PROPERTY to "Query",
            TokenType.WHITE_SPACE to "\t\t",
            SageEngineIniTokenTypes.EQUALS to "=",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.NUMBER to "1",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "NONE",
            TokenType.WHITE_SPACE to "\t ",
            SageEngineIniTokenTypes.OPERATOR to "+",
            SageEngineIniTokenTypes.VALUE to "HERO",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "ALLIES",
        )
    }

    @Test
    fun `should lex property value with colons correctly`() {

        assertTokens(
            "GeometryOffset = X:50 Y:0 Z:0",
            SageEngineIniTokenTypes.PROPERTY to "GeometryOffset",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.EQUALS to "=",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "X",
            SageEngineIniTokenTypes.COLON to ":",
            SageEngineIniTokenTypes.NUMBER to "50",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "Y",
            SageEngineIniTokenTypes.COLON to ":",
            SageEngineIniTokenTypes.NUMBER to "0",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "Z",
            SageEngineIniTokenTypes.COLON to ":",
            SageEngineIniTokenTypes.NUMBER to "0",
        )
    }

    @Test
    fun `should lex coordinate separators and numeric suffixes`() {

        assertTokens(
            "Offset = X:-0.5 Y:+10.0 Z:25h",
            SageEngineIniTokenTypes.PROPERTY to "Offset",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.EQUALS to "=",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "X:-0.5",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "Y:+10.0",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "Z",
            SageEngineIniTokenTypes.COLON to ":",
            SageEngineIniTokenTypes.VALUE to "25h",
        )
    }

    @Test
    fun `should lex known keywords as properties when followed by equals`() {

        assertTokens(
            "BuildCost = ANGMAR_MILL_BUILDCOST",
            SageEngineIniTokenTypes.PROPERTY to "BuildCost",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.EQUALS to "=",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "ANGMAR_MILL_BUILDCOST",
        )
    }

    @Test
    fun `should lex macro directives`() {

        assertTokens(
            "#include \"data\\ini\\object.ini\"",
            SageEngineIniTokenTypes.MACRO to "#include",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.STRING to "\"data\\ini\\object.ini\"",
        )

        assertTokens(
            "#define DEFAULT_SPEED 50",
            SageEngineIniTokenTypes.MACRO to "#define",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "DEFAULT_SPEED",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.NUMBER to "50",
        )
    }

    @Test
    fun `should preserve quoted strings in property values`() {

        assertTokens(
            "DisplayName = \"OBJECT:ElvenMallornTree\"",
            SageEngineIniTokenTypes.PROPERTY to "DisplayName",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.EQUALS to "=",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.STRING to "\"OBJECT:ElvenMallornTree\"",
        )
    }

    @Test
    fun `should lex ambiguous block and property names by equals sign`() {

        assertTokens(
            "Object = ElvenMallornTree",
            SageEngineIniTokenTypes.PROPERTY to "Object",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.EQUALS to "=",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "ElvenMallornTree",
        )

        assertTokens(
            "Object ElvenMallornTree",
            SageEngineIniTokenTypes.BLOCK_START to "Object",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "ElvenMallornTree",
        )
    }

    @Test
    fun `should lex bare lines as block starts unless they are bare value keys`() {

        assertTokens(
            "ArmorSet",
            SageEngineIniTokenTypes.BLOCK_START to "ArmorSet",
        )

        assertTokens(
            "Prerequisites ; requires a castle",
            SageEngineIniTokenTypes.BLOCK_START to "Prerequisites",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.COMMENT_START to ";",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.COMMENT_WORD to "requires",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.COMMENT_WORD to "a",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.COMMENT_WORD to "castle",
        )

        assertTokens(
            "ChildObject ElvenMallornTreeLarge ElvenMallornTree",
            SageEngineIniTokenTypes.BLOCK_START to "ChildObject",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "ElvenMallornTreeLarge",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "ElvenMallornTree",
        )

        assertTokens(
            "RemoveModule ModuleTag_Death",
            SageEngineIniTokenTypes.PROPERTY to "RemoveModule",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "ModuleTag_Death",
        )

        assertTokens(
            "ClearNuggets",
            SageEngineIniTokenTypes.PROPERTY to "ClearNuggets",
        )
    }

    @Test
    fun `should lex block opening keywords followed by equals as block starts`() {

        assertTokens(
            "ModelConditionState = DAMAGED",
            SageEngineIniTokenTypes.BLOCK_START to "ModelConditionState",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.EQUALS to "=",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "DAMAGED",
        )
    }

    @Test
    fun `should lex properties with curve values as block starts`() {

        assertTokens(
            "Radius = FCurve",
            SageEngineIniTokenTypes.BLOCK_START to "Radius",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.EQUALS to "=",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "FCurve",
        )
    }

    @Test
    fun `should lex conditional value openers by their marker value`() {

        assertTokens(
            "AddEmotion = OVERRIDE Taunt_Base",
            SageEngineIniTokenTypes.BLOCK_START to "AddEmotion",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.EQUALS to "=",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "OVERRIDE",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "Taunt_Base",
        )

        assertTokens(
            "AddEmotion = Terror_Base",
            SageEngineIniTokenTypes.PROPERTY to "AddEmotion",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.EQUALS to "=",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "Terror_Base",
        )
    }

    @Test
    fun `should lex property names that are not plain words`() {

        assertTokens(
            "1 = Command_ConstructElvenWarrior",
            SageEngineIniTokenTypes.PROPERTY to "1",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.EQUALS to "=",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "Command_ConstructElvenWarrior",
        )

        assertTokens(
            "Allow_Upgrade = Yes",
            SageEngineIniTokenTypes.PROPERTY to "Allow_Upgrade",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.EQUALS to "=",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "Yes",
        )

        assertTokens(
            "HoleHealthRegen%PerSecond = 10%",
            SageEngineIniTokenTypes.PROPERTY to "HoleHealthRegen%PerSecond",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.EQUALS to "=",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.NUMBER to "10",
            SageEngineIniTokenTypes.PERCENT to "%",
        )
    }

    @Test
    fun `should lex statements following End on the same line`() {

        assertTokens(
            "End StateName = Sword",
            SageEngineIniTokenTypes.BLOCK_END to "End",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.PROPERTY to "StateName",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.EQUALS to "=",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "Sword",
        )
    }

    @Test
    fun `should not lex macro arguments as block starts`() {

        assertTokens(
            "#define ELVEN_TREE_HEALTH 500",
            SageEngineIniTokenTypes.MACRO to "#define",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "ELVEN_TREE_HEALTH",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.NUMBER to "500",
        )
    }

    @Test
    fun `should stop property value at inline comment`() {

        assertTokens(
            "StaticModelLODMode = yes ; Will append M or L",
            SageEngineIniTokenTypes.PROPERTY to "StaticModelLODMode",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.EQUALS to "=",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "yes",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.COMMENT_START to ";",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.COMMENT_WORD to "Will",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.COMMENT_WORD to "append",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.COMMENT_WORD to "M",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.COMMENT_WORD to "or",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.COMMENT_WORD to "L",
        )
    }

    @Test
    fun `should strip trailing whitespace from property value before line end`() {

        assertTokens(
            "DisplayName = CONTROLBAR:ConstructMenPorter  ",
            SageEngineIniTokenTypes.PROPERTY to "DisplayName",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.EQUALS to "=",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.VALUE to "CONTROLBAR:ConstructMenPorter",
            TokenType.WHITE_SPACE to "  ",
        )
    }

    @Test
    fun `should only close script blocks with EndScript`() {

        assertTokens(
            """
            BeginScript
                PrevState = CurDrawablePrevAnimationState()
                if PrevState == "STATE_1"
                then
                    CurDrawableAllowToContinue()
                elseif PrevState == "STATE_2"
                then
                    CurDrawableSetTransitionAnimState("TRANS_1_2")
                end
            EndScript
            """.trimIndent(),
            SageEngineIniTokenTypes.BLOCK_START to "BeginScript",
            TokenType.WHITE_SPACE to "\n    ",
            SageEngineIniTokenTypes.SCRIPT_BODY to "PrevState",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.SCRIPT_BODY to "=",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.SCRIPT_BODY to "CurDrawablePrevAnimationState()",
            TokenType.WHITE_SPACE to "\n    ",
            SageEngineIniTokenTypes.SCRIPT_BODY to "if",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.SCRIPT_BODY to "PrevState",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.SCRIPT_BODY to "==",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.SCRIPT_BODY to "\"STATE_1\"",
            TokenType.WHITE_SPACE to "\n    ",
            SageEngineIniTokenTypes.SCRIPT_BODY to "then",
            TokenType.WHITE_SPACE to "\n        ",
            SageEngineIniTokenTypes.SCRIPT_BODY to "CurDrawableAllowToContinue()",
            TokenType.WHITE_SPACE to "\n    ",
            SageEngineIniTokenTypes.SCRIPT_BODY to "elseif",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.SCRIPT_BODY to "PrevState",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.SCRIPT_BODY to "==",
            TokenType.WHITE_SPACE to " ",
            SageEngineIniTokenTypes.SCRIPT_BODY to "\"STATE_2\"",
            TokenType.WHITE_SPACE to "\n    ",
            SageEngineIniTokenTypes.SCRIPT_BODY to "then",
            TokenType.WHITE_SPACE to "\n        ",
            SageEngineIniTokenTypes.SCRIPT_BODY to "CurDrawableSetTransitionAnimState(\"TRANS_1_2\")",
            TokenType.WHITE_SPACE to "\n    ",
            SageEngineIniTokenTypes.SCRIPT_BODY to "end",
            TokenType.WHITE_SPACE to "\n",
            SageEngineIniTokenTypes.BLOCK_END to "EndScript",
        )
    }

    @Test
    fun `should resume lexing from captured states`() {

        assertCanRestartAtEveryToken(
            """
            ;,, comment words //;
            DoubleSlash = value // comment
            DashDash = value -- comment
            Number = 10h
            GeometryOffset = X:50 Y:0 Z:0
            Next = value
            #define ELVEN_TREE_HEALTH 500
            Object ElvenMallornTree
                ArmorSet
                    Conditions = None
                End StateName = Sword
                RemoveModule ModuleTag_Death
                1 = Command_ConstructElvenWarrior
            End
            BeginScript
                PrevState = CurDrawablePrevAnimationState()
                BeginScript
                    nested
                EndScript
                CurDrawableAllowToContinue()
            EndScript
            After = EndScript
            """.trimIndent()
        )
    }

    private fun assertTokens(text: String, vararg expectedTokens: Pair<IElementType, String>) {

        val lexer = SageEngineIniLexer()
        lexer.start(text, 0, text.length, 0)

        val actualTokens = mutableListOf<Pair<IElementType, String>>()
        while (lexer.tokenType != null) {
            actualTokens += lexer.tokenType!! to text.substring(lexer.tokenStart, lexer.tokenEnd)
            lexer.advance()
        }

        assertThat(actualTokens).isEqualTo(expectedTokens.toList())
    }

    private fun assertCanRestartAtEveryToken(text: String) {

        val fullTokens = lex(text)

        fullTokens.forEachIndexed { index, token ->
            val restartedTokens = lex(text, token.start, token.state)

            assertThat(restartedTokens.map { it.type to text.substring(it.start, it.end) })
                .isEqualTo(fullTokens.drop(index).map { it.type to text.substring(it.start, it.end) })
        }
    }

    private fun lex(text: String, startOffset: Int = 0, initialState: Int = 0): List<LexerToken> {

        val lexer = SageEngineIniLexer()
        lexer.start(text, startOffset, text.length, initialState)

        val tokens = mutableListOf<LexerToken>()
        while (lexer.tokenType != null) {
            tokens += LexerToken(lexer.tokenType!!, lexer.tokenStart, lexer.tokenEnd, lexer.state)
            lexer.advance()
        }

        return tokens
    }

    private data class LexerToken(
        val type: IElementType,
        val start: Int,
        val end: Int,
        val state: Int,
    )
}
