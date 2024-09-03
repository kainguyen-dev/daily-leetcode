package bfs.medium

import java.util.*

class CourseScheduled {

    /**
     * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
     * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that
     * you must take course bi first if you want to take course ai.
     *
     * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
     *
     * Return true if you can finish all courses. Otherwise, return false.
     *
     *
     * Example 1:
     *
     * Input: numCourses = 2, prerequisites = [[1,0]]
     * Output: true
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0. So it is possible.
     *
     * Example 2:
     *
     * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
     * Output: false
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1.
     * So it is impossible.
     *
     * Constraints:
     *
     *     1 <= numCourses <= 2000
     *     0 <= prerequisites.length <= 5000
     *     prerequisites[i].length == 2
     *     0 <= ai, bi < numCourses
     *     All the pairs prerequisites[i] are unique.
     */

    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val adjList = List(numCourses) { mutableListOf<Int>() }

        for (link in prerequisites) {
            adjList[link[0]].add(link[1])
        }

        // handle topology sort
        val inDegree = IntArray(numCourses)
        val sortResult = mutableListOf<Int>()

        for (i in 0 until numCourses) {
            for (neighbour in adjList[i]) {
                inDegree[neighbour]++
            }
        }

        val queue = LinkedList<Int>()
        for (i in 0 until numCourses) {
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

        return sortResult.size == numCourses
    }


}