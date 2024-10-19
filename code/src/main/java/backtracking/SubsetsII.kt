package backtracking

class SubsetsII {


    // https://leetcode.com/problems/subsets-ii/description/
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        result.add(emptyList())

        // The idea is that,
        // By observation, a duplicate list occurs when offset >= 1
        // (when offset = 0, duplicate cannot occur) and nums[offset - 1] == nums[offset]
        // and in the previous step we did not pick nums[offset - 1].
        //
        // The information of whether it picks or not could be passed down by a boolean parameter isPicked.
        //
        // If the above condition is satisfied:
        //
        //    Do not add the list to the result list.
        //    Do not do the subproblem after picking the current element.
        //    Only do the subproblem after not picking the current element.
        fun backTracking(
            i: Int,
            current: MutableList<Int>,
            isPicked: Boolean,
        ) {
            // is solution
            if (i == nums.size) {
                return
            }

            // Picked
            if (i == 0 || nums[i - 1] != nums[i] || isPicked) {
                // picked
                current.add(nums[i])
                val toBeAdd = current.toMutableList()
                result.add(toBeAdd)
                backTracking(i + 1, current, true)

                if (current.isNotEmpty()) {
                    current.removeLast()
                }
            }

            // Not picked
            backTracking(i + 1, current, false)
        }
        nums.sort()
        backTracking(0, mutableListOf(), true)
        return result.toList()
    }

}