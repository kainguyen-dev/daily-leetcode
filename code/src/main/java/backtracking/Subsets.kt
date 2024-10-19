package backtracking

class Subsets {


    // https://leetcode.com/problems/subsets/description/
    /**
     * Time: O(N * 2^N) since the recurrence is T(N) = 2T(N - 1) and we also spend at most O(N) time within a call.
     * Space: O(N * 2^N) since there are 2^N subsets. If we only print the result, we just need O(N) space.
     */
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        result.add(emptyList())

        fun backTracking(
            i: Int,
            current: MutableList<Int>
        ) {
            println("Index $i current = $current result = $result")
            // If solution ( escape case )
            if (i == nums.size) {
                return
            }
            // Pick
            current.add(nums[i])
            backTracking(i + 1, current)

            // add to result
            result.add(current.toMutableList())

            // not pick
            if (current.isNotEmpty()) current.removeLast()
            backTracking(i + 1, current)
        }

        backTracking(0, mutableListOf())
        return result
    }

}