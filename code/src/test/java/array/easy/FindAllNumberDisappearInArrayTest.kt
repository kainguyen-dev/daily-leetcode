package array.easy

import org.junit.jupiter.api.Test

class FindAllNumberDisappearInArrayTest {

    @Test
    fun findDisappearedNumbersV2() {
        val nums = intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)
        val test = FindAllNumberDisappearInArray()
        test.findDisappearedNumbersV2(nums)
    }
}