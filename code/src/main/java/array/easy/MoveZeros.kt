package array.easy

class MoveZeros {


    /**
     * Given an integer array nums, move all 0's to the end of
     * it while maintaining the relative order of the non-zero elements.
     *
     * Note that you must do this in-place without making a copy of the array.
     */

    // https://leetcode.com/problems/move-zeroes/description/

    // The idea here is to use a pivot as marker.
    // When we detect desirable number, we swap the desire number and the pivot.
    // By doing this, pivot is "stuck" with "undesirable" number, and will be swap next iteration
    fun moveZeroes(nums: IntArray) {
        var pivot = 0
        for (i in nums.indices) {

            println()
            println("NUMS ${nums.contentToString()}")
            println("PIVOT $pivot")
            println()

            if (nums[i] != 0) {
                swap(nums, pivot, i)
                pivot++
                // Number is OK, nothing to do here.
            }
        }
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}