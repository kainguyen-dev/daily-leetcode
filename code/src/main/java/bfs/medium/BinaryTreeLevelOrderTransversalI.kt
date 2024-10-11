package bfs.medium

import base.TreeNode
import java.util.*

class BinaryTreeLevelOrderTransversalI {

    // https://leetcode.com/problems/binary-tree-level-order-traversal/description/
    /**
     * Given the root of a binary tree, return the level order traversal of its nodes' values.
     * (i.e., from left to right, level by level).
     *
     */
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()

        var level = 0
        val queue: Queue<TreeNode> = LinkedList()
        val result = mutableListOf<List<Int>>()

        queue.add(root)

        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            val currentLevelNode = LinkedList<TreeNode>()
            for (i in 0 until levelSize) {
                val node = queue.poll()
                currentLevelNode.add(node)

                if (node.left != null) {
                    queue.add(node.left)
                }

                if (node.right != null) {
                    queue.add(node.right)
                }
            }
            result.add(currentLevelNode.map { it.`val` })
            level++
        }
        return result
    }
}