import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SomeTest {

    @Test
    fun `basics numbers tests`() {
        assertEquals("I", arabicToRoman(1))
        assertEquals("V", arabicToRoman(5))
        assertEquals("X", arabicToRoman(10))
        assertEquals("L", arabicToRoman(50))
        assertEquals("C", arabicToRoman(100))
    }

    @Test
    fun `in between numbers which are plus 1 to plus 3 to the next lowest are built with trailing I`() {
        assertEquals("VI", arabicToRoman(6))
        assertEquals("VII", arabicToRoman(7))
        assertEquals("VIII", arabicToRoman(8))
        assertEquals("XIII", arabicToRoman(13))
    }

    @Test
    fun `in between numbers which are plus 10 to plus 30 to the next lowest are built with trailing X`() {
        assertEquals("LX", arabicToRoman(60))
        assertEquals("LXX", arabicToRoman(70))
        assertEquals("LXXX", arabicToRoman(80))
    }

    @Test
    fun `in between numbers which are minus 10 to the next higher are built with leading X`() {
        assertEquals("XL", arabicToRoman(40))
        assertEquals("XC", arabicToRoman(90))
    }

    @Test
    fun `numbers with repeating roman signs`() {
        assertEquals("XX", arabicToRoman(20))
        assertEquals("XXX", arabicToRoman(30))
    }

    @Test
    fun `in between numbers which are minus one to the next sign are built with leading I`() {
        assertEquals("IV", arabicToRoman(4))
        assertEquals("IX", arabicToRoman(9))
    }

    @Test
    fun `given hard acceptance test`() {
        assertEquals("DCCCXLVI", arabicToRoman(846))
        assertEquals("MMVIII", arabicToRoman(2008))
        assertEquals("MCMXCIX", arabicToRoman(1999))
    }

    private fun arabicToRoman(givenArabicNumber: Int): String {
        val reversedKeys = arabicToRomanMap.keys.reversed()
        var currentArabicNumber = givenArabicNumber
        var roman = ""
        for (arabicKey in reversedKeys) {
            while (currentArabicNumber >= arabicKey) {
                currentArabicNumber -= arabicKey
                roman += arabicToRomanMap.getValue(arabicKey)
            }
        }

        return roman
    }

    private val arabicToRomanMap = mapOf(
        1 to "I",
        4 to "IV",
        5 to "V",
        9 to "IX",
        10 to "X",
        40 to "XL",
        50 to "L",
        90 to "XC",
        100 to "C",
        400 to "CD",
        500 to "D",
        900 to "CM",
        1000 to "M",
    )
}
