package bfs.medium

import org.junit.jupiter.api.Test

class MinimumHeightTest {

    @Test
    fun `findMinHeightTrees 1`() {
        val height = MinimumHeight()
        val result = height.findMinHeightTrees(
            4, arrayOf(
                intArrayOf(1, 0),
                intArrayOf(1, 2),
                intArrayOf(1, 3)
            )
        )
        println("Result $result")
    }
}