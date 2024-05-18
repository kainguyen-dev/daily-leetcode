package array.easy

class MoveZeros {

    fun moveZeroes(nums: IntArray): Unit {
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