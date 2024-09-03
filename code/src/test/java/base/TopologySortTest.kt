package base

import org.junit.jupiter.api.Test

class TopologySortTest {

    @Test
    fun topologicalSort() {

        // Example graph:
        // 5 vertices (0, 1, 2, 3, 4)
        // Adjacency list representation
        val adjList = List(5) { mutableListOf<Int>() }
        adjList[0].add(1)
        adjList[0].add(2)
        adjList[1].add(3)
        adjList[2].add(3)
        adjList[3].add(4)


        try {
            val topoSort = TopologySort()
            val result = topoSort.topologicalSort(5, adjList)
            println("Topological Sort: $result")
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }

    }
}