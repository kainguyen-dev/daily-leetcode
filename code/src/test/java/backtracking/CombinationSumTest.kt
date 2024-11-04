package backtracking

import org.junit.jupiter.api.Test

class CombinationSumTest {

    @Test
    fun `test case 1`() {
        val test = CombinationSum()
        val result = test.combinationSum(intArrayOf(2, 3, 6, 7), 7)
        println(result)
    }
}