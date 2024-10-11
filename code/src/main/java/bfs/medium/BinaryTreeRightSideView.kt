package bfs.medium

import base.TreeNode
import java.util.LinkedList
import java.util.Queue

class BinaryTreeRightSideView {

    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()

        val queue: Queue<TreeNode> = LinkedList()
        val result = mutableListOf<Int>()

        queue.add(root)

        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            val levelNodes = mutableListOf<TreeNode>()

            for (i in 0 until levelSize) {
                val node = queue.poll()
                levelNodes.add(node)

                if (node.left != null) {
                    queue.add(node.left)
                }

                if (node.right != null) {
                    queue.add(node.right)
                }

            }
            if (levelNodes.size >= 1) {
                result.add(levelNodes.last().`val`)
            }
        }

        return result
    }

}