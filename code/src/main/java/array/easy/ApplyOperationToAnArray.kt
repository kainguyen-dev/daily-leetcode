package array.easy

class
ApplyOperationToAnArray {

    // https://leetcode.com/problems/apply-operations-to-an-array/description/
    // Similar to
    /**
     * @see MoveZeros
     */
    fun applyOperations(nums: IntArray): IntArray {
        // Do the operation first
        for (i in nums.indices) {
            if (i < nums.size - 1 && nums[i] == nums[i + 1]) {
                nums[i] = 2 * nums[i]
                nums[i + 1] = 0
            }
        }

        // shift zeros to the end of the array
        var pivot = 0
        for (i in nums.indices) {
            if (nums[i] != 0) {
                swap(nums, i, pivot)
                pivot++
            }
        }

        return nums
    }


    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}