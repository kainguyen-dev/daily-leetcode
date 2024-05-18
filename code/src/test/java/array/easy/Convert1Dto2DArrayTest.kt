package array.easy

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class Convert1Dto2DArrayTest {

    @Test
    fun construct2DArray1() {
        val test = Convert1Dto2DArray()
        val result = test.construct2DArray(intArrayOf(1,2,3,4), 2 ,2 )
        for (i in result) {
            for (j in i) {
                print(" $j")
            }
            println()
        }
    }

    @Test
    fun construct2DArray2() {
        val test = Convert1Dto2DArray()
        val result = test.construct2DArray(intArrayOf(1,2), 1,1)
        for (i in result) {
            for (j in i) {
                print(" $j")
            }
            println()
        }
    }
}