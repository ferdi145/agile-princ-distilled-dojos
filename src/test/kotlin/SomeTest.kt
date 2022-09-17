import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import kotlin.test.assertEquals

class SomeTest {

    @Test
    fun `calculate minimum value`() {
        assertEquals(1, Calculator(listOf(2, 1, 3, 4)).minimumValue)
    }

    @Test
    fun `calculate minimum value negative value`() {
        assertEquals(-3, Calculator(listOf(2, 1, -3, 4)).minimumValue)
    }

    @Test
    fun `calculate maximum value positive numbers`() {
        assertEquals(4, Calculator(listOf(2, 1, 4, 3)).maximumValue)
    }

    @Test
    fun `calculate maximum value negative numbers`() {
        assertEquals(3, Calculator(listOf(2, 1, -4, 3)).maximumValue)
    }

    @Test
    fun `calculate input sequence length`() {
        assertEquals(4, Calculator(listOf(2, 1, -4, 3)).sequenceLength)
    }

    @Test
    fun `calculate average value`() {
        assertEquals(0.5, Calculator(listOf(2, 1, -4, 3)).averageValue)
    }

    @Test
    fun `CalculatorInput can't be empty list`() {
        assertThrows<IllegalArgumentException> { Calculator(listOf()) }
    }
}

data class Calculator(val values: List<Int>) {
    init {
        require(values.isNotEmpty()) { "needs input" }
    }

    val sequenceLength get() = values.size
    val minimumValue get() = values.minOrNull()!!
    val maximumValue get() = values.maxOrNull()!!
    val averageValue get() = values.average()
}


