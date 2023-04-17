import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SomeTest {

    @Test
    fun `input number string returns number`() {
        // given
        val input = "1"

        // when
        val result: Int = calculate(input)

        // then
        assertEquals(1, result)
    }

    @Test
    fun `input negative number string returns negative number`() {
        // given
        val input = "-1"

        // when
        val result: Int = calculate(input)

        // then
        assertEquals(-1, result)
    }

    @Test
    fun `input addition calculation string returns sum of numbers`() {
        assertEquals(2, calculate("1+1"))
        assertEquals(3, calculate("1+2"))
        assertEquals(1, calculate("-1+2"))
    }

    private fun calculate(input: String): Int {
        if (input.contains("+")) {
            return input
                .split("+")
                .sumOf { it.toInt() }
        }

        return input.toInt()
    }
}


