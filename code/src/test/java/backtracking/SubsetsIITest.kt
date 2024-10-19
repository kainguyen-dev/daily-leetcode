package backtracking

import org.junit.jupiter.api.Test

class SubsetsIITest {

    @Test
    fun `test case 1`() {
        val subSet = SubsetsII()
        val result = subSet.subsetsWithDup(intArrayOf(1, 2, 2))
        println(result)
    }

    @Test
    fun `test case 2`() {
        val subSet = SubsetsII()
        val result = subSet.subsetsWithDup(intArrayOf(1, 2, 3))
        println(result)
    }
}