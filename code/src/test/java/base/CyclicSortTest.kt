package base

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class CyclicSortTest {

    @Test
    fun cyclicSort() {
        val nums = intArrayOf(3, 2, 1, 6, 5)
        val sort = CyclicSort()
        sort.cyclicSort(nums)
        println(nums.contentToString())
    }
}