package bfs.medium

import base.TreeNode
import java.util.*

class BinaryTreeZigzagLevelOrderTraversal {

    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()

        var dir = true
        val queue: Queue<TreeNode> = LinkedList()
        val result = mutableListOf<List<Int>>()

        queue.add(root)

        while (queue.isNotEmpty()) {
            val currentLevelSize = queue.size
            val currentLevelNodes = mutableListOf<Int>()

            for (i in 0 until  currentLevelSize) {
                val node = queue.poll()
                currentLevelNodes.add(node.`val`)

                if (node.left != null) {
                    queue.add(node.left)
                }

                if (node.right != null) {
                    queue.add(node.right)
                }
            }
            if (dir) {
                result.add(currentLevelNodes)
            } else {
                result.add(currentLevelNodes.reversed())
            }
            dir = !dir
        }
        return result
    }

}