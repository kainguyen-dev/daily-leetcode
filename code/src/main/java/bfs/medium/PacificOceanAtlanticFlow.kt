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
     * Froms cell try to find Pacific ocean
     *
     */


    companion object {
        // PACIFIC_DIR
        val WEST = intArrayOf(-1, 0)
        val NORTH = intArrayOf(0, -1)

        // ATLANTIC_DIR
        val EAST = intArrayOf(1, 0)
        val SOUTH = intArrayOf(0, 1)


    }

    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        val maxRow = heights.size - 1
        val maxCol = heights[0].size - 1
        val mapCanReach = mutableMapOf<String, Boolean>()
        val result = mutableListOf<List<Int>>()
        for (i in 0..maxRow) {
            for (j in 0..maxCol) {
                val canReach = transverse(heights, i, j, mapCanReach)
                if (canReach) {
                    mapCanReach["${i}_${j}"] = true
                    result.add(listOf(i, j))
                } else {
                    mapCanReach["${i}_${j}"] = false
                }
            }
        }
        return result
    }

    private fun transverse(heights: Array<IntArray>, row: Int, col: Int, mapCanReach: Map<String, Boolean>): Boolean {

        val maxRow = heights.size - 1
        val maxCol = heights[0].size - 1

        // BFS from current coordinate to Pacific Ocean
        val queue: Queue<IntArray> = LinkedList()
        val visited = mutableSetOf<String>()
        queue.add(intArrayOf(row, col))

        // can reach pacific | can reach atlantic
        var canReachPacific = false
        var canReachAtlantic = false

        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            for (i in 0 until  levelSize) {
                val coor = queue.poll()
                visited.add("${coor[0]}_${coor[1]}")

                if (mapCanReach.containsKey("${coor[0]}_${coor[1]}") && mapCanReach["${coor[0]}_${coor[1]}"] == true) {
                    return true
                }

                if (coor[0] == 0 || coor[1] == 0) {
                    canReachPacific = true
                }

                if (coor[0] == maxRow || coor[1] == maxCol) {
                    canReachAtlantic = true
                }

                // handle west node
                if (coor[0] + WEST[0] >= 0) {
                    val westNode = intArrayOf(coor[0] + WEST[0] , coor[1] + WEST[1])
                    val canTravel = getHeight(heights, coor) >= getHeight(heights, westNode)
                    if (canTravel && !visited.contains("${westNode[0]}_${westNode[1]}")) {
                        queue.add(westNode)
                    }
                }
                // handle north node
                if (coor[1] + NORTH[1] >= 0) {
                    val northNode = intArrayOf(coor[0] + NORTH[0] , coor[1] + NORTH[1])
                    val canTravel = getHeight(heights, coor) >= getHeight(heights, northNode)
                    if (canTravel && !visited.contains("${northNode[0]}_${northNode[1]}")) {
                        queue.add(northNode)
                    }
                }
                // handle east node
                if (coor[0] + EAST[0] <= maxRow) {
                    val eastNode = intArrayOf(coor[0] + EAST[0] , coor[1] + EAST[1])
                    val canTravel = getHeight(heights, coor) >= getHeight(heights, eastNode)
                    if (canTravel && !visited.contains("${eastNode[0]}_${eastNode[1]}")) {
                        queue.add(eastNode)
                    }
                }
                // handle north node
                if (coor[1] + SOUTH[1] <= maxCol) {
                    val southNode = intArrayOf(coor[0] + SOUTH[0] , coor[1] + SOUTH[1])
                    val canTravel = getHeight(heights, coor) >= getHeight(heights, southNode)
                    if (canTravel && !visited.contains("${southNode[0]}_${southNode[1]}")) {
                        queue.add(southNode)
                    }
                }
            }
        }

        return canReachPacific && canReachAtlantic
    }

    private fun getHeight(heights: Array<IntArray>, coor: IntArray): Int {
        return heights[coor[0]][coor[1]]
    }
}