package bfs.easy

import org.junit.jupiter.api.Test

class MinimumDepthOfBinaryTreeTest {

    @Test
    fun minDepth_1() {

        val root = TreeNode(3)
        root.left = TreeNode(9)
        root.right = TreeNode(20)
        root.right!!.left = TreeNode(15)
        root.right!!.right = TreeNode(7)

        val minDepth = MinimumDepthOfBinaryTree()
        val result = minDepth.minDepth(root)
        println(result)
    }

    @Test
    fun minDepth_2() {

        val root = TreeNode(3)
        root.right = TreeNode(20)
        root.right!!.right = TreeNode(15)
        root.right!!.right!!.right = TreeNode(25)

        val minDepth = MinimumDepthOfBinaryTree()
        val result = minDepth.minDepth(root)
        println(result)
    }
}