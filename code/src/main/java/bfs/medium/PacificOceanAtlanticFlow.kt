package bfs.medium

import java.util.*

class PacificOceanAtlanticFlow {


    /**
     * There is an m x n rectangular island that borders both the Pacific Ocean and Atlantic Ocean.
     * The Pacific Ocean touches the island's left and top edges
     * and the Atlantic Ocean touches the island's right and bottom edges.
     *
     * The island is partitioned into a grid of square cells. You are given an m x n integer matrix
     * heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
     *
     * The island receives a lot of rain, and the rain water can flow to neighboring cells directly
     * north, south, east, and west if the neighboring cell's height is less than or equal to the current cell's height.
     * Water can flow from any cell adjacent to an ocean into the ocean.
     *
     * Return a 2D list of grid coordinates result where result[i] = [ri, ci]
     * denotes that rain water can flow from cell (ri, ci) to both the Pacific and Atlantic oceans.
     */

    /**
     * Idea:
     * From pacific TOP and LEFT wall, bfs to atlantic,
     * From atlantic RIGHT and BOTTOM wall, bfs to pacific
     *
     */


    companion object {
        // 4 DIRECTION
        val ROW_DIR = intArrayOf(1, -1, 0, 0)
        val COL_DIR = intArrayOf(0, 0, 1, -1)
        const val N_DIR = 4
    }

    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val nRow = heights.size
        val nCol = heights[0].size

        val atlanticVisited = Array(nRow) { BooleanArray(nCol) }
        val pacificVisited = Array(nRow) { BooleanArray(nCol) }

        val atlanticQueue = LinkedList<IntArray>()
        val pacificQueue = LinkedList<IntArray>()

        for (i in 0 until nRow) {
            pacificVisited[i][0] = true
            pacificQueue.add(intArrayOf(i, 0))
        }

        for (j in 0 until nCol) {
            pacificVisited[0][j] = true
            pacificQueue.add(intArrayOf(0, j))
        }

        for (i in 0 until nRow) {
            atlanticVisited[i][nCol - 1] = true
            atlanticQueue.add(intArrayOf(i, nCol - 1))
        }

        for (j in 0 until nCol) {
            atlanticVisited[nRow - 1][j] = true
            atlanticQueue.add(intArrayOf(nRow - 1, j))
        }

        bfs(heights, pacificQueue, pacificVisited)
        bfs(heights, atlanticQueue, atlanticVisited)

        val result = mutableListOf<List<Int>>()
        for (i in 0 until nRow) {
            for (j in 0 until nCol) {
                if (pacificVisited[i][j] && atlanticVisited[i][j]) {
                    result.add(listOf(i, j))
                }
            }
        }
        return result
    }

    private fun bfs(heights: Array<IntArray>, queue: LinkedList<IntArray>, visited: Array<BooleanArray>) {
        val nRow = heights.size
        val nCol = heights[0].size

        while (queue.isNotEmpty()) {
            val row = queue.peek()[0]
            val col = queue.peek()[1]
            queue.poll()

            for (i in 0 until N_DIR) {
                val newRow = row + ROW_DIR[i]
                val newCol = col + COL_DIR[i]

                if (newRow >= 0 && newCol >= 0 && newRow < nRow && newCol < nCol // boundary
                    && !visited[newRow][newCol] // not visited
                    && heights[newRow][newCol] >= heights[row][col] // can pass down water
                ) {
                    queue.add(intArrayOf(newRow, newCol))
                    visited[newRow][newCol] = true
                }
            }
        }
    }
}