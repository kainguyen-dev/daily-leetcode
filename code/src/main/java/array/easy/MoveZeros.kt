package array.easy

class MoveZeros {


    /**
     * Given an integer array nums, move all 0's to the end of
     * it while maintaining the relative order of the non-zero elements.
     *
     * Note that you must do this in-place without making a copy of the array.
     */

    fun moveZeroes(nums: IntArray) {
        var pivot = 0
        for (i in nums.indices) {
            if (nums[i] != 0) {
                swap(nums, pivot, i)
                pivot++
            }
        }
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}