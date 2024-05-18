package array.easy

class MissingNumber {

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