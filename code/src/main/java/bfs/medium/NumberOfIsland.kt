package bfs.medium

import java.util.*

class NumberOfIsland {

    /**
     * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water),
     * return the number of islands.
     *
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
     *
     * You may assume all four edges of the grid are all surrounded by water.
     *
     *
     *
     * Example 1:
     *
     * Input: grid = [
     *   ["1","1","1","1","0"],
     *   ["1","1","0","1","0"],
     *   ["1","1","0","0","0"],
     *   ["0","0","0","0","0"]
     * ]
     * Output: 1
     *
     * Example 2:
     *
     * Input: grid = [
     *   ["1","1","0","0","0"],
     *   ["1","1","0","0","0"],
     *   ["0","0","1","0","0"],
     *   ["0","0","0","1","1"]
     * ]
     * Output: 3
     *
     */

    fun numIslands(grid: Array<CharArray>): Int {
        val maxRow = grid.size
        val maxCol = grid[0].size
        var result = 0

        val visited = Array(maxRow) { BooleanArray(maxCol) }

        for (i in 0 until maxRow) {
            for (j in 0 until maxCol) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    bfs(grid, visited, i, j)
                    result++
                }
            }
        }
        return result
    }

    private fun bfs(grid: Array<CharArray>, visited: Array<BooleanArray>, initRow: Int, initCol: Int) {
        val maxRow = grid.size
        val maxCol = grid[0].size

        val queue: Queue<IntArray> = LinkedList()
        queue.add(intArrayOf(initRow, initCol))
        visited[initRow][initCol] = true

        while (queue.isNotEmpty()) {
            val row = queue.peek()[0]
            val col = queue.peek()[1]
            queue.poll()

            for (i in 0 until N_DIR) {
                val newRow = row + ROW_DIR[i]
                val newCol = col + COL_DIR[i]

                if ((newRow >= 0 && newCol >= 0 && newRow < maxRow &&  newCol < maxCol)
                    && !visited[newRow][newCol]
                    && grid[newRow][newCol] == '1'
                ) {
                    queue.add(intArrayOf(newRow, newCol))
                    visited[newRow][newCol] = true
                }
            }
        }
    }

    companion object {
        // 4 DIRECTION
        val ROW_DIR = intArrayOf(1, -1, 0, 0)
        val COL_DIR = intArrayOf(0, 0, 1, -1)
        const val N_DIR = 4
    }

}