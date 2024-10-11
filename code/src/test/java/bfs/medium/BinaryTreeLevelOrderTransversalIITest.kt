package bfs.medium

import base.TreeNode
import org.junit.jupiter.api.Test

class BinaryTreeLevelOrderTransversalIITest {

    @Test
    fun levelOrderBottom() {
        val root = TreeNode(3)
        root.left = TreeNode(9)
        root.right = TreeNode(20)
        root.right!!.left = TreeNode(15)
        root.right!!.right = TreeNode(7)
        val cal = BinaryTreeLevelOrderTransversalII()
        val result = cal.levelOrderBottom(root)
        println("Result $result")
    }
}