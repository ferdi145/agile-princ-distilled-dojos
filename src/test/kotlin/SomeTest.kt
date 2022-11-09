import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SomeTest {
    @Test
    fun `basic numbers`() {
        assertEquals("I", romanNumeral(1))
        assertEquals("V", romanNumeral(5))
        assertEquals("X", romanNumeral(10))
        assertEquals("L", romanNumeral(50))
    }

    @Test
    fun `plus stuff`() {
        assertEquals("II", romanNumeral(2))
        assertEquals("III", romanNumeral(3))
        assertEquals("LX", romanNumeral(60))
    }

    @Test
    fun `minus stuff`() {
        assertEquals("IV", romanNumeral(4))
        assertEquals("IX", romanNumeral(9))
        assertEquals("XL", romanNumeral(40))
    }

    private fun romanNumeral(arabicNumber: Int): String {
        for (key in arabicToRoman.keys) {
            if (key <= arabicNumber) {
                return arabicToRoman.getValue(key) + romanNumeral(arabicNumber - key)
            }
        }

        return ""
    }
}

val arabicToRoman = mapOf(
    50 to "L",
    49 to "XL",
    10 to "X",
    9 to "IX",
    5 to "V",
    4 to "IV",
    1 to "I",
)
