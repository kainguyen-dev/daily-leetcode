package base

/**
 * Working only with DAG ( Directed Acyclic Graph )
 */
class TreeTrimLeaveBfs {

    fun sort(n: Int, edges: Array<IntArray>): List<Int> {
        if (n == 1) return listOf(0)

        // Initialize adjacency list and in-degree array
        val adjList = List(n) { mutableListOf<Int>() }

        // Build the adjacency list and fill in-degree array
        for (edge in edges) {
            val u = edge[0]
            val v = edge[1]
            adjList[u].add(v)
            adjList[v].add(u)
        }

        println("Adj List $adjList")

        // Collect all the initial leaves
        var leaves = mutableListOf<Int>()

        for (i in 0 until n) {
            if (adjList[i].size == 1) {
                leaves.add(i)
            }
        }


        // Trim the leaves until we are left with 1 or 2 nodes
        var remainingNodes = n
        while (remainingNodes > 2) {
            remainingNodes -= leaves.size
            val newLeaves = mutableListOf<Int>()

            for (leaf in leaves) {
                val neighbor = adjList[leaf].first()
                adjList[neighbor].remove(leaf)

                if (adjList[neighbor].size == 1) {
                    newLeaves.add(neighbor)
                }
            }
            leaves = newLeaves
        }

        return leaves
    }

}