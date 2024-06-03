package array.medium

class RotateImage {


    /*
     * clockwise rotate
     * first reverse up to down, then swap the symmetry
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
     * -----------------------------------------------------
     * anticlockwise rotate
     * first reverse left to right, then swap the symmetry
     * 1 2 3     3 2 1     3 6 9
     * 4 5 6  => 6 5 4  => 2 5 8
     * 7 8 9     9 8 7     1 4 7
    */
    fun rotate(matrix: Array<IntArray>): Unit {
        val ROW = matrix.size
        val COL = matrix[0].size
        val visited = Array(ROW) { BooleanArray(COL) }

        /**
         *
         * Symetry swap
         * 00 -> 00
         * 01 -> 10
         * 02 -> 20
         */
        swapUpToDown(matrix)

        for (i in 0 until ROW) {
            for (j in 0 until COL) {
                if (!visited[i][j]) {
                    val temp = matrix[j][i]
                    matrix[j][i] = matrix[i][j]
                    matrix[i][j] = temp
                    visited[i][j] = true
                    visited[j][i] = true
                }
            }
        }
    }

    private fun swapUpToDown(matrix: Array<IntArray>) {
        val ROW = matrix.size
        val COL = matrix[0].size
        for (i in 0 until ROW / 2) {
            for (j in 0 until COL) {
                swapValue(matrix, i, j, ROW - 1 - i, j)
            }
        }
    }

    private fun swapValue(matrix: Array<IntArray>, fromRow: Int, fromCol: Int, toRow: Int, toCol: Int) {
        val temp = matrix[toRow][toCol]
        matrix[toRow][toCol] = matrix[fromRow][fromCol]
        matrix[fromRow][fromCol] = temp
    }


}