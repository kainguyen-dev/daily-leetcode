package array.medium

import org.junit.jupiter.api.Test

class LongestConsecutiveSequenceTest {

    @Test
    fun longestConsecutive() {
        val test = LongestConsecutiveSequence()
        println("RESULT ${test.longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2))}")
        println("RESULT ${test.longestConsecutive(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1))}")
    }
}