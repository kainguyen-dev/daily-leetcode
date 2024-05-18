package array.easy



class Convert1Dto2DArray {

    fun construct2DArray(original: IntArray, m: Int, n: Int): Array<IntArray> {
        if (m * m < original.size) return emptyArray()

        val array = Array(m) { IntArray(n) }
        var colCount = 0
        var rowCount = 0

        for (i in original.indices) {
            array[colCount][rowCount] = original[i]
            colCount ++
            if (colCount == n) {
                colCount = 0
                rowCount ++
            }
        }

        return array
    }

}