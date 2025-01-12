package array.easy

import org.junit.jupiter.api.Test

class ApplyOperationToAnArrayTest {

    @Test
    fun applyOperations() {
        val nums = intArrayOf(1, 2, 2, 1, 1, 0)
        val test = ApplyOperationToAnArray()
        val result = test.applyOperations(nums)
        println(result.toList())
    }
}