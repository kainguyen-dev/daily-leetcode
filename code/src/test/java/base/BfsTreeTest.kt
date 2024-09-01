package base

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class BfsTreeTest {



    /**
     *     3
     *    / \
     *   9   20
     *      /  \
     *     15   7
     * [3,9,20,null,null,15,7]
     */

    @Test
    fun bfs() {
        val root = TreeNode(3)
        root.left = TreeNode(9)
        root.right = TreeNode(20)
        root.right!!.left = TreeNode(15)
        root.right!!.right = TreeNode(7)

        val bsf = BfsTree()
        bsf.bfs(root)
    }
}