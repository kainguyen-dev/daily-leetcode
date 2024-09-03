package base

import java.util.*


class TopologySort {

    fun topologicalSort(vertices: Int, adjList: List<List<Int>>): List<Int> {
        val sortResult = mutableListOf<Int>()

        // calculate in degree array
        val inDegree = IntArray(vertices)

        for (i in 0 until vertices) {
            // increase incoming vertex
            for (neighbour in adjList[i]) {
                inDegree[neighbour]++
            }
        }

        val queue = LinkedList<Int>()

        // Add all vertex that have in-degree = 0
        for (i in 0 until vertices) {
            // increase incoming vertex
            if (inDegree[i] == 0) {
                queue.add(i)
            }
        }

        while (queue.isNotEmpty()) {
            val vertex = queue.poll()
            sortResult.add(vertex)

            for (neighbour in adjList[vertex]) {
                inDegree[neighbour]--

                if (inDegree[neighbour] == 0) {
                    queue.add(neighbour)
                }
            }
        }

        require(sortResult.size == vertices) {
            throw IllegalArgumentException("Graph has a cycle, topological sort not possible.")
        }

        return sortResult
    }

}