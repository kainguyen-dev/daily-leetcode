package base

import java.util.*


class BackTracking {

    // General algorithm for backtracking
    // From a list, we generate another list.
    // Back tracking algorithm
    // Check condition we want,

    // If yes, do something with it
    // If no, perform backtracking, with current solution and mark used list

    fun <T> process(list: List<T>): List<List<T>> {
        val result = mutableListOf<List<T>>()

        fun backtrack(
            solution: MutableList<T>,
            used: MutableSet<T>,
        ) {
            if (solution.size == list.size) {
                result.add(ArrayList(solution))  // Use a copy of the solution
            } else {
                for (element in list) {
                    if (!used.contains(element)) {
                        // Choose the element (not used yet)
                        solution.add(element)
                        used.add(element)

                        // Explore further
                        backtrack(solution, used)

                        // Undo the choice (backtrack)
                        solution.removeAt(solution.size - 1)
                        used.remove(element)
                    }
                }
            }
        }

        // Start backtracking with an empty solution and an empty set of used elements
        backtrack(mutableListOf(), mutableSetOf())
        return result
    }


    /**
     * Permutation & Subsets
     */

    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        fun backtrack(temp: MutableList<Int>, nums: IntArray, index: Int) {
            result.add(temp)

            for (i in index until nums.size) {
                temp.add(nums[i])
                backtrack(temp, nums, i + 1)
                temp.removeAt(temp.size - 1)
            }
        }
        Arrays.sort(nums)
        backtrack(mutableListOf(), nums, 0)
        return result
    }

    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()

        fun backtrack(temp: MutableList<Int>, nums: IntArray, start: Int) {
            result.add(temp)

            for (i in start until nums.size) {
                if (i > start && nums[i] == nums[i - 1]) continue  // skip duplicates
                temp.add(nums[i])
                backtrack(temp, nums, i + 1)
                temp.removeAt(temp.size - 1)
            }
        }

        Arrays.sort(nums)
        backtrack(mutableListOf(), nums, 0)
        return result
    }

    fun permute(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()

        fun backtrack(temp: MutableList<Int>, nums: IntArray) {

            if (temp.size == nums.size) {
                result.add(temp)
            } else {
                for (i in nums.indices) {
                    if (temp.contains(nums[i])) continue  // element already exists, skip
                    temp.add(nums[i])
                    backtrack(temp, nums)
                    temp.removeAt(temp.size - 1)
                }
            }
        }

        // Arrays.sort(nums); // not necessary
        backtrack(mutableListOf(), nums)
        return result
    }

}