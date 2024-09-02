package array.easy

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MoveZerosTest {

    @Test
    fun moveZeroes() {
        val nums = intArrayOf(1, 2, 0, 1, 9, 0, 11)
        val move = MoveZeros()
        move.moveZeroes(nums)
        println("Result " + nums.contentToString())
    }
}