package backtracking

import org.junit.jupiter.api.Test

class PermutationIITest {

    @Test
    fun permuteUnique() {
        val array = intArrayOf(1, 1, 2)
        val test = PermutationII()
        val result = test.permuteUnique(array)
        println(result)
        val map = array.groupBy { it }.mapValues { it.value.size }
        println(map)

    }
}