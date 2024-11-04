package backtracking

class Permutation {

    // https://leetcode.com/problems/permutations/
    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        fun backTracking(
            current: MutableList<Int>,
        ) {

            // base case
            if (current.size == nums.size) {
                result.add(current.toMutableList())
            } else {
                for (num in nums) {
                    if (!current.contains(num)) {
                        current.add(num)
                        backTracking(current)
                        current.removeAt(current.size - 1)
                    }
                }
            }
        }

        backTracking(mutableListOf())
        return result
    }

}