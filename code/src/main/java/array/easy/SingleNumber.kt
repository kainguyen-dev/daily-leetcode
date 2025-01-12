package array.easy

class
SingleNumber {

    // https://leetcode.com/problems/single-number/description/
    // Use xor here because A XOR A = 0
    fun singleNumber(nums: IntArray): Int {
        var seen = 0
        for (i in nums) {
            seen = seen xor i
        }
        return seen
    }

}