package bfs.medium

import base.TreeNode
import java.util.LinkedList
import java.util.Queue

class AllNodesDistanceKInBinaryTree {


    // https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
    /**
     * Given the root of a binary tree, the value of a target node target, and an integer k,
     * return an array of the values of all nodes that have a distance k from the target node.
     *
     * You can return the answer in any order.
     */

    // Solution:
    // Convert a tree to an adjacency list
    // BFS through in adjacency list
    fun distanceK(root: TreeNode?, target: TreeNode?, k: Int): List<Int> {
        val adjacencyList = mutableMapOf<TreeNode, MutableList<TreeNode>>()
        buildAdjacencyList(root, adjacencyList)
        return bfs(target, adjacencyList, k)
    }
    private fun buildAdjacencyList(root: TreeNode?, adjacencyList: MutableMap<TreeNode, MutableList<TreeNode>>) {
        if (root == null) return

        if (adjacencyList[root] == null) {
            adjacencyList[root] = mutableListOf()
        }

        if (root.left != null) {
            adjacencyList[root]?.add(root.left!!)

            if (adjacencyList[root.left] == null) {
                adjacencyList[root.left!!] = mutableListOf()
            }
            adjacencyList[root.left!!]?.add(root)
        }
        if (root.right != null) {
            adjacencyList[root]?.add(root.right!!)
            if (adjacencyList[root.right] == null) {
                adjacencyList[root.right!!] = mutableListOf()
            }
            adjacencyList[root.right!!]?.add(root)
        }

        buildAdjacencyList(root.left, adjacencyList)
        buildAdjacencyList(root.right, adjacencyList)
    }

    // BFS ADJACENCY LIST
    private fun bfs(root: TreeNode?,
                    adjacencyList: MutableMap<TreeNode, MutableList<TreeNode>>,
                    k: Int): List<Int> {
        if (root == null) return emptyList()

        var level = 0
        val result = mutableListOf<Int>()
        val queue: Queue<TreeNode> = LinkedList()
        val visited = mutableSetOf<TreeNode>()

        queue.add(root)
        visited.add(root)

        while (queue.isNotEmpty()) {
            val currentLevelSize = queue.size

            for (i in 0 until currentLevelSize) {
                val node = queue.poll()
                if (adjacencyList[node] != null) {
                    for (neighbourNode in adjacencyList[node]!!) {
                        if (visited.contains(neighbourNode)) continue
                        queue.add(neighbourNode)
                    }
                }
                if (k == level) {
                    result.add(node.`val`)
                }
                visited.add(node)
            }
            if (result.isNotEmpty()) return result
            level++
        }
        return result
    }

}