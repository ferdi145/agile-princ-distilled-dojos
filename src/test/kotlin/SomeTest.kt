import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SomeTest {

    @Test
    fun `fizzBuzz`() {
        assertEquals("1", fizzBuzz(1))
        assertEquals("2", fizzBuzz(2))
        assertEquals("Fizz", fizzBuzz(3))
        assertEquals("Fizz", fizzBuzz(6))
        assertEquals("Buzz", fizzBuzz(5))
        assertEquals("Buzz", fizzBuzz(10))
        assertEquals("FizzBuzz", fizzBuzz(15))
    }

    private fun fizzBuzz(number: Int): String {
        if (number.dividableBy(3) && number.dividableBy(5)) return "FizzBuzz"
        if (number.dividableBy(3)) return "Fizz"
        if (number.dividableBy(5)) return "Buzz"
        return number.toString()
    }

    private fun Int.dividableBy(divider: Int) = this % divider == 0
}


