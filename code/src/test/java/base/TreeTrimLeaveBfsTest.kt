package base

import org.junit.jupiter.api.Test

class TreeTrimLeaveBfsTest {

    @Test
    fun sort() {
        val sort = TreeTrimLeaveBfs()
        val result = sort.sort(
            4, arrayOf(
                intArrayOf(1, 0),
                intArrayOf(1, 2),
                intArrayOf(1, 3)
            )
        )
        println("Result: $result")
    }
}