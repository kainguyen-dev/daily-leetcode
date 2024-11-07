package backtracking

class CombinationSumII {


    //    Example 1:
    //    Input: candidates = [10,1,2,7,6,1,5], target = 8
    //    Output:
    //    [
    //    [1,1,6],
    //    [1,2,5],
    //    [1,7],
    //    [2,6]
    //    ]
    //
    //    Example 2:
    //    Input: candidates = [2,5,2,1,2], target = 5
    //    Output:
    //    [
    //    [1,2,2],
    //    [5]
    //    ]
    //    https://leetcode.com/problems/combination-sum-ii/
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        candidates.sort()
        fun backTracking(start: Int, current: MutableList<Int>) {
            val sum = current.sum()
            if (sum == target) {
                result.add(current.toMutableList())
                return
            } else if (sum > target) {
                return
            } else {
                var prev = -1
                for (i in start until candidates.size) {
                    if (candidates[i] == prev) continue
                    current.add(candidates[i])
                    backTracking(i + 1, current)
                    current.removeLast()
                    prev = candidates[i]
                }
            }
        }
        backTracking(0, mutableListOf())
        return result
    }
}