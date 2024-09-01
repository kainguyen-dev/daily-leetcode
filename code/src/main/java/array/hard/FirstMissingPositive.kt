package array.hard

class FirstMissingPositive {

    /**
     * Given an unsorted integer array nums. Return the smallest positive integer
     * that is not present in nums.
     *
     * You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
     *
     * Example 1:
     * Input: nums = [1,2,0]
     * Output: 3
     * Explanation: The numbers in the range [1,2] are all in the array.
     *
     * Example 2:
     *
     * Input: nums = [3,4,-1,1]
     * Output: 2
     * Explanation: 1 is in the array but 2 is missing.
     *
     * Example 3:
     *
     * Input: nums = [7,8,9,11,12]
     * Output: 1
     * Explanation: The smallest positive integer 1 is missing.
     *
     */
    // Solution note:
    // Do the cyclic sort
    // Loop through
    fun firstMissingPositive(nums: IntArray): Int {
        if (nums.size == 1) {
            return if (nums[0] == 1) 2
            else 1
        }

        cycleSort(nums)
        println("After sort ${nums.contentToString()}")
        for (i in nums.indices) {
            // correct index is not belong to the value, return the index + 1
            if (nums[i] - 1  != i) {
                return i + 1
            }
        }
        return nums.size
    }

    /**
     * Fastest way to sort a [1 --> N] array
     */
    private fun cycleSort(nums: IntArray) {
        var pivot = 0
        val size = nums.size
        while (pivot < size) {
            val correctIdx = nums[pivot] - 1
            val currentVal = nums[pivot]
            // Checking in range in order to avoid outOfBound error
            if (isInRange(correctIdx, size) && nums[correctIdx] != currentVal) {
                swap(nums, pivot, correctIdx)
            } else {
                pivot++
            }
        }
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }

    private fun isInRange(num: Int, max: Int): Boolean {
        return num in 0..<max
    }
}