package array.medium

import org.junit.jupiter.api.Test

class SpiralMatrixTest {

    @Test
    fun spiralOrder_1() {

        val test = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )

        val matrix = SpiralMatrix()
        val result = matrix.spiralOrder(test)
        println(result)
    }

    @Test
    fun spiralOrder_2() {

        val test = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12)
        )

        val matrix = SpiralMatrix()
        val result = matrix.spiralOrder(test)
        println(result)
    }
}