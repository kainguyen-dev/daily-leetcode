package bfs.medium

import java.util.LinkedList


class CourseScheduled2 {

    /**
     * https://leetcode.com/problems/course-schedule-ii/description/
     */

    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val adjList = List(numCourses) { mutableListOf<Int>() }

        for (link in prerequisites) {
            adjList[link[0]].add(link[1])
        }

        val inDegree = IntArray(numCourses)
        val sortResult = mutableListOf<Int>()

        for (i in 0 until numCourses) {
            for (neighbour in adjList[i]) {
                inDegree[neighbour]++
            }
        }

        val queue = LinkedList<Int>()
        for (i in 0 until  numCourses) {
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

        return if (sortResult.size == numCourses) {
            sortResult.reverse()
            sortResult.toIntArray()
        } else {
            intArrayOf()
        }
    }


}