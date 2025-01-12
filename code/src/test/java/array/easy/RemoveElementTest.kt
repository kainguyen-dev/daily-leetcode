package array.easy

import org.junit.jupiter.api.Test

class RemoveElementTest {

    @Test
    fun removeElement_1() {
        val test = RemoveElement()
        val nums = intArrayOf(3, 2, 2, 3)

        val result = test.removeElement(nums, 3)
        println(result)
        println(nums.toList())
    }


    @Test
    fun removeElement_2() {
        val test = RemoveElement()
        val nums = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)

        val result = test.removeElement(nums, 2)
        println(result)
        println(nums.toList())
    }
}