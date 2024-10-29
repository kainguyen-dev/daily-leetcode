package backtracking

class PermutationII {


    // IDEA is to instead count array
    // We map a map of element -> frequency
    // We only count on keys

    // https://leetcode.com/problems/permutations-ii/
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val map = nums.groupBy { it }.mapValues { it.value.size }.toMutableMap()

        fun backTracking(temp: MutableList<Int>) {
            if (temp.size == nums.size) {
                result.add(temp.toMutableList())
            } else {
                for (key in map.keys) {
                    if (map[key]!! > 0) {
                        temp.add(key)
                        map[key] = map[key]!! - 1
                        backTracking(temp)
                        map[key] = map[key]!! + 1
                        temp.removeLast()
                    }
                }
            }
        }
        backTracking(mutableListOf())
        return result
    }

}