package array.easy

class
RemoveElement {

    // https://leetcode.com/problems/remove-element/description/
    // Similar to
    /**
     * @see MoveZeros
     */
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var pivot = 0
        for (i in nums.indices) {
            // By doing this, pivot is stuck with index of 'val' and will be push to thwe end of list
            if (nums[i] != `val`) {
                swap(nums, pivot, i)
                pivot++
            }
        }
        return pivot
    }


    private fun swap(nums: IntArray, i: Int, j: Int) {
        val temp = nums[i]
        nums[i] = nums[j]
        nums[j] = temp
    }
}