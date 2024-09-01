package base

class CyclicSort {

    fun cyclicSort(nums: IntArray) {
        var pivot = 0
        val size = nums.size

        while (pivot < size) {
            val correctIdx = nums[pivot] - 1
            val currentVal = nums[pivot]
            if (inInRange(correctIdx, size) && nums[correctIdx] != currentVal) {
                swap(nums, pivot, correctIdx)
            } else {
                pivot ++
            }
        }
    }

    private fun inInRange(pivot: Int, size: Int): Boolean {
        return pivot in 0..<size
    }

    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}