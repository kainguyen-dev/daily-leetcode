package bfs.medium

import org.junit.jupiter.api.Test

class NumberOfIslandTest {

    @Test
    fun `numIslands 1`() {

        val island = NumberOfIsland()
        val result = island.numIslands(
            arrayOf(
                charArrayOf('1', '1', '1', '1', '0'),
                charArrayOf('1', '1', '0', '1', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '0', '0', '0')
            )
        )
        println("Result $result")
    }
}