package bfs.easy

import org.junit.jupiter.api.Test

class AverageLevelsInBinaryTreeTest {

    @Test
    fun averageOfLevels_1() {
        val root = TreeNode(3)
        root.left = TreeNode(9)
        root.right = TreeNode(20)
        root.right!!.left = TreeNode(15)
        root.right!!.right = TreeNode(7)

        val bfs = AverageLevelsInBinaryTree()
        val result = bfs.averageOfLevels(root)
        println(result.contentToString())
    }

    @Test
    fun averageOfLevels_2() {
        val root = TreeNode(3)
        root.left = TreeNode(9)
        root.right = TreeNode(20)
        root.left!!.left = TreeNode(15)
        root.left!!.right = TreeNode(7)

        val bfs = AverageLevelsInBinaryTree()
        val result = bfs.averageOfLevels(root)
        println(result.contentToString())
    }
}