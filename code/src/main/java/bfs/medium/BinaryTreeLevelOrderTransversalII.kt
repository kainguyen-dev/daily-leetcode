package bfs.medium

import base.TreeNode
import java.util.*

class BinaryTreeLevelOrderTransversalII {

    // https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
    /**
     * Given the root of a binary tree, return the bottom-up level order traversal of its nodes' values.
     * (i.e., from left to right, level by level from leaf to root).
     *
     */
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()

        var level = 0
        val map = mutableMapOf<Int, List<TreeNode>>()
        val queue: Queue<TreeNode> = LinkedList()

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

            map[level] = currentLevelNode
            level++
        }

//        println("MAP $map")
        val result = mutableListOf<List<Int>>()

        for (i in level downTo 0) {
            map[i]?.map { it.`val` }?.let {
                result.add(it)
            }
        }

//        println("RESULT $result")
        return result
    }
}