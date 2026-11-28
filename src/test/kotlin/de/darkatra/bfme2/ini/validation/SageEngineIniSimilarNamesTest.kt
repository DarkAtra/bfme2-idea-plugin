package de.darkatra.bfme2.ini.validation

import com.intellij.util.text.EditDistance
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import kotlin.random.Random

class SageEngineIniSimilarNamesTest {

    @Test
    fun `should compute the same distance as the platform up to the maximum`() {

        val random = Random(42)
        repeat(20_000) {
            val a = randomWord(random)
            val b = randomWord(random)
            val max = random.nextInt(0, 5)
            val distance = EditDistance.optimalAlignment(a, b, false)

            assertThat(boundedDistance(a, b, max)).describedAs("'$a' and '$b' within $max").isEqualTo(distance.takeIf { it <= max })
        }
    }

    @Test
    fun `should suggest the most similar names`() {

        assertThat(similarNames("ElvenMalornTree", listOf("ElvenMallornTree", "ElvenMallornTreeStatue", "DwarvenMallornTree", "elvenmallorntree")))
            .containsExactly("ElvenMallornTree", "elvenmallorntree")
    }

    private fun randomWord(random: Random): String {
        return (0 until random.nextInt(0, 9)).map { "abAB_"[random.nextInt(5)] }.joinToString("")
    }
}
