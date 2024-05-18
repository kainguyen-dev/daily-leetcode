package array.easy

class SingleNumber {

    fun singleNumber(nums: IntArray): Int {
        var seen = 0
        for (i in nums) {
            seen = seen xor i
        }
        return seen
    }

}