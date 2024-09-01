package bfs.easy

import java.util.*


class MinimumDepthOfBinaryTree {


    /**
     * Given a binary tree, find its minimum depth.
     *
     * The minimum depth is the number of nodes along the
     * shortest path from the root node down to the nearest leaf node.
     *
     * Note: A leaf is a node with no children.
     *
     *
     * Input: root = [3,9,20,null,null,15,7]
     * Output: 2
     *
     * Example 2:
     *
     * Input: root = [2,null,3,null,4,null,5,null,6]
     * Output: 5
     *
     *
     */

    fun minDepth(root: TreeNode?): Int {
        if (root == null) return 0
        if (root.left == null && root.right == null) return 1

        var level = 0
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)

        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            for (i in 0 until levelSize) {
                val node = queue.poll()

                if (node.left == null && node.right == null) {
                    return level + 1
                }

                if (node?.left != null) {
                    queue.add(node.left)
                }

                if (node?.right != null) {
                    queue.add(node.right)
                }
            }
            level ++
        }
        return level + 1
    }
}