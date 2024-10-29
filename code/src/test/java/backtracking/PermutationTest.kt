package backtracking

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class PermutationTest {

    @Test
    fun `test case 1`() {
        val test = Permutation()
        val result = test.permute(intArrayOf(1, 2, 3))
        println(result)
    }
}