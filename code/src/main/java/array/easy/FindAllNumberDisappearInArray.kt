package array.easy

class FindAllNumberDisappearInArray {

    // https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/description/
    //
    // First solution
    // Make a bit map from 0 -> N
    // Loop through all element and "flag" the bit map to 1
    // Check the bit map again
    //
    // Time: O(2N) = O(N)
    // Space: O(N)
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val bitMap = BooleanArray(nums.size)

        for (num in nums) {
            bitMap[num-1] = true
        }

        val result = mutableListOf<Int>()

        for(index in bitMap.indices) {
            if (!bitMap[index]) result.add(index+1)
        }
        return result
    }


    // Solution 2:
    // Sort the array using cyclic sort.
    // Time: O(N)
    // Space: O(1)
    //
    fun findDisappearedNumbersV2(nums: IntArray): List<Int> {
        cyclicSort(nums)
        val result = mutableListOf<Int>()
        for (i in nums.indices) {
            if (i + 1 != nums[i]) {
                result.add(i + 1)
            }
        }
        return result
    }

    private fun cyclicSort(nums: IntArray) {
        var pivot = 0
        val size = nums.size

        fun isInRange(): Boolean {
            return pivot in 0..<size
        }

        fun swap(nums: IntArray, i: Int, j: Int) {
            val temp = nums[i]
            nums[i] = nums[j]
            nums[j] = temp
        }

        while (pivot < size) {
            // Where thing "should" be
            val correctIndex = nums[pivot] -1 // -1 here because of base index 0
            val correctValue = nums[correctIndex]

            // What is current have
            val currentValue = nums[pivot]

            // Check range first before making stupid mistake.
            if (isInRange() && currentValue != correctValue) {
                swap(nums, correctIndex, pivot)
            } else {
                pivot++
            }
        }
    }
}