package bfs.easy

import java.util.*


data class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class AverageLevelsInBinaryTree {

    /**
     * Given the root of a binary tree, return the average
     * value of the nodes on each level in the form of an array.
     * Answers within 10-5 of the actual answer will be accepted.
     *
     *
     */

    /**
     * Example 1:
     *
     * Input: root = [3,9,20,null,null,15,7]
     *
     * Output: [3.00000,14.50000,11.00000]
     * Explanation: The average value of nodes on level 0 is 3, on level 1 is 14.5, and on level 2 is 11.
     * Hence, return [3, 14.5, 11].
     *
     * Example 2:
     *
     * Input: root = [3,9,20,15,7]
     * Output: [3.00000,14.50000,11.00000]
     */

    fun averageOfLevels(root: TreeNode?): DoubleArray {
        if (root == null) return DoubleArray(0)
        val avg = mutableListOf<Double>()

        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            var levelSum = 0.0

            for (i in 0 until levelSize) {
                val node = queue.poll()
                levelSum += node.`val`

                if (node?.left != null) {
                    queue.add(node.left)
                }

                if (node?.right != null) {
                    queue.add(node.right)
                }
            }
            avg.add(levelSum / levelSize)
        }

        return avg.toDoubleArray()
    }
}