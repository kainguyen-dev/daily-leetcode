package backtracking

class Subsets {


    // https://leetcode.com/problems/subsets/description/
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        result.add(emptyList())

        fun backTracking(
            i: Int,
            current: MutableList<Int>
        ) {
            // If solution ( escape case )
            if (i == nums.size) {
                return
            }
            current.add(nums[i])
            result.add(current.toMutableList())
            for (j in i + 1 until nums.size) {
                backTracking(j, current)
            }
            if (current.isNotEmpty()) {
                println("Current at index $i , value = $current remove last node")
                current.removeLast()
            }
        }

        for (i in nums.indices) {
            println("-----------------------")
            backTracking(i, mutableListOf())
        }
        return result
    }

}