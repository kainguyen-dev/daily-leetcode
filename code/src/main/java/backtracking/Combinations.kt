package backtracking

class Combinations {


    // https://leetcode.com/problems/combinations/
    fun combine(n: Int, k: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        fun backTracking(start: Int, current: MutableList<Int>) {
            if (current.size == k) {
                result.add(current.toMutableList())
                return
            } else {
                for (i in start until n + 1) {
                    if (current.contains(i)) continue
                    current.add(i)
                    backTracking(i + 1, current)
                    current.removeLast()
                }
            }
        }
        backTracking(1, mutableListOf())
        return result
    }
}