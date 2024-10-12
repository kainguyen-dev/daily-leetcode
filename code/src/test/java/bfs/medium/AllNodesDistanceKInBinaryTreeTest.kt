package bfs.medium

import base.TreeNode
import org.junit.jupiter.api.Test

class AllNodesDistanceKInBinaryTreeTest {

    @Test
    fun test() {

        val root = TreeNode(3)

        // Left subtree
        root.left = TreeNode(5)
        root.left?.left = TreeNode(6)
        root.left?.right = TreeNode(2)
        root.left?.right?.left = TreeNode(7)
        root.left?.right?.right = TreeNode(4)

        // Right subtree
        root.right = TreeNode(1)
        root.right?.left = TreeNode(0)
        root.right?.right = TreeNode(8)


        val test = AllNodesDistanceKInBinaryTree()
        val result = test.distanceK(root, root.left, 2)
        println(result)
    }


}