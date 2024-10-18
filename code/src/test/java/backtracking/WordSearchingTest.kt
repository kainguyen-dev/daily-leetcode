package backtracking

import org.junit.jupiter.api.Test

class WordSearchingTest {

    @Test
    fun `test case 1`() {
        val wordSearching = WordSearching()
        val array = arrayOf(
            charArrayOf('A', 'B', 'C', 'E'),
            charArrayOf('S', 'F', 'C', 'S'),
            charArrayOf('A', 'D', 'E', 'E'),
        )
        val result = wordSearching.exist(array, "ABCCED")
        println(result)
    }

    @Test
    fun `test case 2`() {
        val wordSearching = WordSearching()
        val array = arrayOf(
            charArrayOf('A', 'B', 'C', 'E'),
            charArrayOf('S', 'F', 'C', 'S'),
            charArrayOf('A', 'D', 'E', 'E'),
        )
        val result = wordSearching.exist(array, "SEE")
        println(result)
    }

    @Test
    fun `test case 3`() {
        val wordSearching = WordSearching()
        val array = arrayOf(
            charArrayOf('A', 'B', 'C', 'E'),
            charArrayOf('S', 'F', 'C', 'S'),
            charArrayOf('A', 'D', 'E', 'E'),
        )
        val result = wordSearching.exist(array, "ABCB")
        println(result)
    }

    @Test
    fun `test case 4`() {
        val wordSearching = WordSearching()
        val array = arrayOf(
            charArrayOf('a', 'b'),
            charArrayOf('c', 'd'),
        )
        val result = wordSearching.exist(array, "bacd")
        println(result)
    }

    @Test
    fun `test case 5`() {
        val wordSearching = WordSearching()
        val array = arrayOf(
            charArrayOf('A', 'B', 'C', 'E'),
            charArrayOf('S', 'F', 'C', 'S'),
            charArrayOf('A', 'D', 'E', 'E'),
        )
        // ABCE _ SE_EE _ FS
        // ABCE_SEEEFS
        val result = wordSearching.exist(array, "ABCESEEEFS")
        println(result)
    }
}