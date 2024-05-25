package array.medium

// https://leetcode.com/problems/spiral-matrix/
class SpiralMatrix {

    companion object {
        val dirOrder = arrayOf(Dir.RIGHT, Dir.DOWN, Dir.LEFT, Dir.TOP)
        var dirCount = 0
    }

    enum class Dir {
        RIGHT, LEFT, TOP, DOWN,
    }

    private fun nextStep(
        cur: Pair<Int, Int>,
        curDir: Dir,
        visited: Array<BooleanArray>,
        nRow: Int,
        nCol: Int,
    ): Pair<Int, Int> {

        var newCoordinate: Pair<Int, Int> = when (curDir) {
            Dir.RIGHT -> Pair(cur.first, cur.second + 1)
            Dir.LEFT -> Pair(cur.first, cur.second - 1)
            Dir.TOP -> Pair(cur.first - 1, cur.second)
            Dir.DOWN -> Pair(cur.first + 1, cur.second)
        }

        // check if change direction is need
        // four corner
        if (newCoordinate.first == 0 && newCoordinate.second == nCol - 1) {
            dirCount = (dirCount + 1) % 4
            return newCoordinate
        } else if (newCoordinate.first == nRow -1 && newCoordinate.second == nCol - 1) {
            dirCount = (dirCount + 1) % 4
            return newCoordinate
        } else if (newCoordinate.first == nRow - 1 && newCoordinate.second == 0) {
            dirCount = (dirCount + 1) % 4
            return newCoordinate
        } else if (visited[newCoordinate.first][newCoordinate.second]) {
            dirCount = (dirCount + 1) % 4
            newCoordinate = when (dirOrder[dirCount]) {
                Dir.RIGHT -> Pair(cur.first, cur.second + 1)
                Dir.LEFT -> Pair(cur.first, cur.second - 1)
                Dir.TOP -> Pair(cur.first - 1, cur.second)
                Dir.DOWN -> Pair(cur.first + 1, cur.second)
            }
            return newCoordinate
        } else {
            return newCoordinate
        }
    }

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val nRow: Int = matrix.size
        val nCol: Int = matrix[0].size
        val total = nCol * nRow
        var count = 0
        var curDir: Dir

        val result = mutableListOf<Int>()
        val visited: Array<BooleanArray> = Array(nRow) { BooleanArray(nCol) }
        var curCoordinate = Pair(0, 0)

        while (count < total) {
            println("Print cor: $curCoordinate")
            curDir = dirOrder[dirCount]
            result.add(matrix[curCoordinate.first][curCoordinate.second])
            visited[curCoordinate.first][curCoordinate.second] = true
            curCoordinate = nextStep(curCoordinate, curDir, visited, nRow , nCol )
            count++
        }

        return result
    }


}