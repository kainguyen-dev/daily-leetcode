package backtracking

class CombinationSum {

    //    Example 1:
    //    Input: candidates = [2,3,6,7], target = 7
    //    Output: [[2,2,3],[7]]
    //    Explanation:
    //    2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
    //    7 is a candidate, and 7 = 7.
    //    These are the only two combinations.
    //
    //    Example 2:
    //    Input: candidates = [2,3,5], target = 8
    //    Output: [[2,2,2,2],[2,3,3],[3,5]]
    //
    //    Example 3:
    //    Input: candidates = [2], target = 1
    //    Output: []
    //    https://leetcode.com/problems/combination-sum/
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        fun backTracking(start: Int, current: MutableList<Int>) {
            val sum = current.sum()
            if (sum == target) {
                result.add(current.toMutableList())
                return
            } else if (sum > target) {
                return
            } else {
                for (i in start until candidates.size) {
                    current.add(candidates[i])
                    backTracking(i, current)
                    current.removeLast()
                }
            }
        }
        backTracking(0, mutableListOf())
        return result
    }
}