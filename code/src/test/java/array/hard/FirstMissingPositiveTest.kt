package array.hard

import org.junit.jupiter.api.Test

class FirstMissingPositiveTest {

    @Test
    fun firstMissingPositive() {
        val result = FirstMissingPositive().firstMissingPositive(intArrayOf(3,4,-1,1))
        println(result)
    }
}