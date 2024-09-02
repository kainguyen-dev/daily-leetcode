package bfs.medium

import org.junit.jupiter.api.Test

class PacificOceanAtlanticFlowTest {

    @Test
    fun `pacificAtlantic 1`() {
        val array: Array<IntArray> = arrayOf(
            intArrayOf(1, 2, 2, 3, 5),
            intArrayOf(3, 2, 3, 4, 4),
            intArrayOf(2, 4, 5, 3, 1),
            intArrayOf(6, 7, 1, 4, 5),
            intArrayOf(5, 1, 1, 2, 4)
        )

        val code = PacificOceanAtlanticFlow()
        val result = code.pacificAtlantic(array)
        println("RESULT $result")
        // expect
        // [ [0,4], [1,3], [1,4], [2,2] , [3,0] , [3,1] , [4,0] ]
        // current
        // [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]
    }


    @Test
    fun `pacificAtlantic 2`() {
        val array: Array<IntArray> = arrayOf(
            intArrayOf(1),
        )

        val code = PacificOceanAtlanticFlow()
        val result = code.pacificAtlantic(array)
        println("RESULT $result")
        // expect
        // [ [0,4], [1,3], [1,4], [2,2] , [3,0] , [3,1] , [4,0] ]
        // current
        // [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]]
    }

    @Test
    fun `pacificAtlantic 3`() {
        val array: Array<IntArray> = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(8, 9, 4),
            intArrayOf(7, 6, 5),
        )

        val code = PacificOceanAtlanticFlow()
        val result = code.pacificAtlantic(array)
        println("RESULT $result")
        // expect
        // [[0,2],  [1,0],  [1,1],  [1,2],  [2,0],  [2,1],  [2,2]]
        // current
        // [[0, 2], [1, 0], [1, 1], [1, 2], [2, 0], [2, 2]]
    }

    @Test
    fun `pacificAtlantic 4`() {
        val array: Array<IntArray> = arrayOf(
            intArrayOf(1,2),
            intArrayOf(4,3),
        )

        val code = PacificOceanAtlanticFlow()
        val result = code.pacificAtlantic(array)
        println("RESULT $result")
        // expect
        // [[0,1],[1,0],[1,1]]
    }
}