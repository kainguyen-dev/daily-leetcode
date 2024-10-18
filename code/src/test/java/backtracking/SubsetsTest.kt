package backtracking

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class SubsetsTest {

    @Test
    fun `test case 1`() {
        val set = Subsets()
        val result = set.subsets(intArrayOf(1, 2, 3))
        println(result)
    }
}