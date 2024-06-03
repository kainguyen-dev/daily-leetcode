package array.medium

import org.junit.jupiter.api.Test

class RotateImageTest {

    @Test
    fun test_1() {
        val test = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )

        val matrix = RotateImage()
        matrix.rotate(test)
        test.forEach { it ->
            run {
                it.forEach { print("$it ") }
                println()
            }
        }
    }

}