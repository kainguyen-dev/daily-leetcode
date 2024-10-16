package backtracking

import base.TreeNode


class BinaryTreePaths {

    // https://leetcode.com/problems/binary-tree-paths/
    // Given the root of a binary tree, return all root-to-leaf paths in any order.
    //
    // A leaf is a node with no children.
    fun binaryTreePaths(root: TreeNode?): List<String> {
        return process(root)
    }

    private fun process(root: TreeNode?): List<String> {
        val result = mutableListOf<String>()
        fun backTracking(
            node: TreeNode?,             // The current node
            path: MutableList<TreeNode>  // The current path from the root to this node
        ) {

            // Base action
            if (node == null) return
            path.add(node)

            // isSolution == true
            if (node.left == null && node.right == null) {
                val pathStr = path.joinToString("->") { it.`val`.toString() }
                result.add(pathStr)
            } else {
                // Do backtracking
                backTracking(node.left, path)
                backTracking(node.right, path)
            }
            path.removeLast()
        }
        backTracking(root, mutableListOf())
        return result
    }

}