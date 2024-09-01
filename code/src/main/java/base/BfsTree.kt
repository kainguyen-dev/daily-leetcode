package base

import java.util.*

data class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}


class BfsTree {

    fun bfs(root: TreeNode?) {
        if (root == null) return

        var level = 0
        val map = mutableMapOf<Int, List<TreeNode>>()
        val queue: Queue<TreeNode> = LinkedList()

        queue.add(root)

        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            val currentLevelNodes = LinkedList<TreeNode>()

            for (i in 0 until  levelSize) {
                val node = queue.poll()
                currentLevelNodes.add(node)

                if (node?.left != null) {
                    queue.add(node.left)
                }

                if (node?.right != null) {
                    queue.add(node.right)
                }
            }
            // Finish current level loop
            map[level] = currentLevelNodes
            level++
        }

        println("MAP $map")
    }
}