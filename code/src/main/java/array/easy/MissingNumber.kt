package array.easy

class MissingNumber {

    // https://leetcode.com/problems/missing-number/description/
    // First idea is to calculate "expect" total
    // And actual total
    // Missing number = expect - actual
    fun missingNumber(nums: IntArray): Int {
        val size = nums.size
        val expectTotal = (size * (size + 1)) / 2

        var realTotal = 0
        for (i in nums) {
            realTotal += i
        }
        return expectTotal - realTotal
    }
}