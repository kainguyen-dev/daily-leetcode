package bfs.medium

import org.junit.jupiter.api.Test

class CourseScheduledTest {

    @Test
    fun `canFinish 0`() {
        val course = CourseScheduled()
        val result = course.canFinish(2, Array(1) { intArrayOf(1, 0) })
        println(result)
    }

    @Test
    fun `canFinish 1`() {
        val course = CourseScheduled()
        val result = course.canFinish(
            2, arrayOf(
                intArrayOf(1, 0),
                intArrayOf(0, 1)
            )
        )
        println(result)
    }
}