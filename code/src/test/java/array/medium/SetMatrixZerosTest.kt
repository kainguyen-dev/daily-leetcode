package array.medium

import org.junit.jupiter.api.Test

class SetMatrixZerosTest {

    @Test
    fun test_1() {
        val test = arrayOf(
            intArrayOf(0, 1, 2, 0),
            intArrayOf(3, 4, 5, 2),
            intArrayOf(1, 3, 1, 5)
        )

        val matrix = SetMatrixZeros()
        matrix.setZeroes(test)
        test.forEach { it ->
            run {
                it.forEach { print("$it ") }
                println()
            }
        }
    }

    @Test
    fun test_2() {
        val test = arrayOf(
            intArrayOf(1, 0, 2, 1),
            intArrayOf(3, 4, 0, 2),
            intArrayOf(1, 3, 1, 5)
        )

        val matrix = SetMatrixZeros()
        matrix.setZeroes(test)
        test.forEach { it ->
            run {
                it.forEach { print("$it ") }
                println()
            }
        }
    }

}