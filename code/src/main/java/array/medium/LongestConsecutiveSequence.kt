package array.medium

import kotlin.math.max

class LongestConsecutiveSequence {

    // https://leetcode.com/problems/longest-consecutive-sequence/description/
    fun longestConsecutive(nums: IntArray): Int {
        val set = mutableSetOf<Int>()
        for (num in nums) set.add(num)

        var result = 0
        for (num in nums) {
            var leftNum = num - 1
            var rightNum = num + 1
            var leftIndex = 0
            var rightIndex = 0
            while(set.remove(leftNum)) {
                leftIndex--
                leftNum--
            }
            while(set.remove(rightNum)) {
                rightIndex++
                rightNum++
            }
            result = max(rightIndex - leftIndex + 1, result)
            if (set.isEmpty()) return result
        }
        return result
    }
}