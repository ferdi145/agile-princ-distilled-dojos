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
        assertEquals("MMVIII", arabicToRoman(2008))
        assertEquals("DCCCXLVI", arabicToRoman(846))
//        assertEquals("MCMXCIX", arabicToRoman(1999))
    }

    private fun arabicToRoman(givenArabicNumber: Int): String {
        if (isSimpleRomanNumber(givenArabicNumber)) return getRoman(givenArabicNumber)

        arabicNumbersWithRomanRepresentation().firstOrNull { arabicNumberWithRomanRepresentation ->
            isSimpleRomanNumber(givenArabicNumber + arabicNumberWithRomanRepresentation)
        }
            ?.let { numberAddedToGivenNumberEqualsRomanEquivalent ->
                return getRoman(numberAddedToGivenNumberEqualsRomanEquivalent) +
                        getRoman(givenArabicNumber + numberAddedToGivenNumberEqualsRomanEquivalent)
            }

        return numberSmallerThanOneOfNearestSign(givenArabicNumber)
    }

    private fun isSimpleRomanNumber(givenArabicNumber: Int) = arabicToRomanMap.containsKey(givenArabicNumber)

    private fun numberSmallerThanOneOfNearestSign(givenArabicNumber: Int): String {
        val arabicNumbersWithExistingRomanSign = arabicNumbersWithRomanRepresentation().toList().reversed()
        val firstSmallerArabicNumber = arabicNumbersWithExistingRomanSign
            .find { arabicNumberWithRomanSign -> arabicNumberWithRomanSign < givenArabicNumber }

        return getRoman(firstSmallerArabicNumber!!) + arabicToRoman(givenArabicNumber - firstSmallerArabicNumber)
    }

    private fun arabicNumbersWithRomanRepresentation() = arabicToRomanMap.keys

    private fun getRoman(givenArabicNumber: Int) = arabicToRomanMap.getValue(givenArabicNumber)

    private val arabicToRomanMap = mapOf(
        1 to "I",
        5 to "V",
        10 to "X",
        50 to "L",
        100 to "C",
        500 to "D",
        1000 to "M",
    )
}
