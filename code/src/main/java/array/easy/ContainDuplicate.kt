package array.easy

class ContainDuplicate {

    // https://leetcode.com/problems/contains-duplicate/
    //
    //
    // First solution is to use
    // Set
    // Time complexity: O(N)
    // Space complexity: O(N)
    fun containsDuplicate(nums: IntArray): Boolean {
        val set = mutableSetOf<Int>()
        for (i in nums) {
            if (!set.contains(i)) set.add(i)
            else return true
        }
        return false
    }


    // Second solution
    // Sort array, check adjacent elements are equal.
    // Space: O(1)
    // Time: O(N)
    fun containsDuplicateV2(nums: IntArray): Boolean {
        nums.sort()
        var prev = nums[0]

        for (i in 1..<nums.size) {
            if (nums[i] == prev) {
                return true
            }
            prev = nums[i]
        }
        return false
    }


}
