package bfs.medium

class MinimumHeight {

    /**
     * https://leetcode.com/problems/minimum-height-trees/
     */
    fun findMinHeightTrees(n: Int, edges: Array<IntArray>): List<Int> {
        if (n == 1) return listOf(0)

        val adjList = List(n) { mutableListOf<Int>() }
        for (edge in edges) {
            adjList[edge[0]].add(edge[1])
            adjList[edge[1]].add(edge[0])
        }

        var leaves = mutableListOf<Int>()
        for (i in 0 until n) {
            if (adjList[i].size == 1) {
                leaves.add(i)
            }
        }
        
        var remainingNodes = n
        while (remainingNodes > 2) {
            remainingNodes -= leaves.size
            val newLeaves = mutableListOf<Int>()

            for (leaf in leaves) {
                // trim out leave from adj list
                val neighbour = adjList[leaf].first()
                adjList[neighbour].remove(leaf)

                if (adjList[neighbour].size == 1) {
                    newLeaves.add(neighbour)
                }
            }
            leaves = newLeaves
        }
        return leaves
    }

}