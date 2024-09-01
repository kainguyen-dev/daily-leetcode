package array.medium

class FindDuplicateNumber {

    /**
     * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
     *
     * There is only one repeated number in nums, return this repeated number.
     *
     * You must solve the problem without modifying the array nums and uses only constant extra space.
     */

    fun findDuplicateV1(nums: IntArray): Int {
        nums.sort()
        for (i in 1..nums.size) {
            if (nums[i] == nums[i-1]) return nums[i]
        }
        return -1
    }

    fun findDuplicateV2(nums: IntArray): Int {
        cyclicSort(nums)
        for (i in nums.indices) {
            if (nums[i] - 1 != i) return nums[i]
        }
        return -1
    }


    private fun cyclicSort(nums: IntArray) {
        var pivot = 0
        val size = nums.size
        while (pivot < size) {
            val correctIdx = nums[pivot] - 1
            val currentVal = nums[pivot]
            if (correctIdx in 0..size && nums[correctIdx] != currentVal) {
                swap(nums, pivot, correctIdx)
            } else {
                pivot++
            }
        }
        println("After sort ${nums.contentToString()} ")
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}