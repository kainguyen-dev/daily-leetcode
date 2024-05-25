package array.medium

class SetMatrixZeros {

    fun setZeroes(matrix: Array<IntArray>): Unit {
        val totalRow = matrix.size - 1
        val totalCol = matrix[0].size - 1

        val coordinateRowSet = BooleanArray(totalRow + 1)
        val coordinateColSet = BooleanArray(totalCol + 1)

        for (i in 0..totalRow) {
            for (j in 0..totalCol) {
                if (matrix[i][j] == 0) {
                    coordinateRowSet[i] = true
                    coordinateColSet[j] = true
                }
            }
        }

        // Modify matrix
        for (i in 0..totalRow) {
            if (coordinateRowSet[i]) {
                for (j in 0..totalCol) matrix[i][j] = 0

            } else {
                for (j in 0..totalCol) {
                    if (coordinateColSet[j]) {
                        matrix[i][j] = 0
                    }
                }
            }
        }
    }
}