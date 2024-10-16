package base

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


}