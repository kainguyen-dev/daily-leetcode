package backtracking

class WordSearching {


    // https://leetcode.com/problems/word-search/description/
    /**
     * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
     *
     * The word can be constructed from letters of sequentially adjacent cells,
     * where adjacent cells are horizontally or vertically neighboring.
     *
     * The same letter cell may not be used more than once.
     */
    fun exist(board: Array<CharArray>, word: String): Boolean {
        return process(board, word)
    }

    private fun process(board: Array<CharArray>, word: String): Boolean {


        val ROW = board.size
        val COL = board[0].size

        fun backtracking(
            node: Pair<Int, Int>,
            wordIndex: Int,
            visited: MutableSet<Pair<Int, Int>>
        ): Boolean {
            // Base case
            if (word[wordIndex] != board[node.first][node.second]) {
                return false
            }

            // If solution
            if (wordIndex + 1 == word.length) {
                return true
            }

            visited.add(node)
            val neighbours = getNeighbour(node, ROW, COL, visited)
            for (neighbour in neighbours) {
                if (backtracking(neighbour, wordIndex + 1, visited)) {
                    return true
                }
            }

            // If it comes to here, meaning that all neighbours node is useless. Remove visited, go to another node.
            visited.remove(node)
            return false
        }

        for (i in 0 until ROW) {
            for (j in 0 until COL) {
                val visited = mutableSetOf<Pair<Int, Int>>()
                val result = backtracking(Pair(i, j), 0, visited)
                if (result) return true
            }
        }
        return false
    }

    private fun getNeighbour(node: Pair<Int, Int>, ROW: Int, COL: Int, visited: MutableSet<Pair<Int, Int>>): List<Pair<Int, Int>> {
        val result = mutableListOf<Pair<Int, Int>>()

        if (node.first + 1 < ROW && !visited.contains(Pair(node.first + 1, node.second))) {
            result.add(Pair(node.first + 1, node.second))
        }

        if (node.second + 1 < COL && !visited.contains(Pair(node.first, node.second + 1))) {
            result.add(Pair(node.first, node.second + 1))
        }

        if (node.first - 1 >= 0 && !visited.contains(Pair(node.first - 1, node.second))) {
            result.add(Pair(node.first - 1, node.second))
        }

        if (node.second - 1 >= 0 && !visited.contains(Pair(node.first, node.second - 1))) {
            result.add(Pair(node.first, node.second - 1))
        }

        return result
    }
}