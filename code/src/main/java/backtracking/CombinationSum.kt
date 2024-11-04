package backtracking

class CombinationSum {


    // https://leetcode.com/problems/combination-sum/
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