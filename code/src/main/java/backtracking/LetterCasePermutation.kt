package backtracking

class LetterCasePermutation {

    // https://leetcode.com/problems/letter-case-permutation/description/
    fun letterCasePermutation(s: String): List<String> {
        val result = mutableListOf<String>()

        fun backTracking(
            wordIdx: Int,
            current: MutableList<Char>
        ) {
            // If solution
            if (wordIdx == s.length) {
                val toString = current.joinToString("")
                result.add(toString)
                return
            }

            // BackTracking
            if (s[wordIdx].isLetter()) {
                backTracking(wordIdx + 1, (current + s[wordIdx].lowercaseChar()).toMutableList())
                backTracking(wordIdx + 1, (current + s[wordIdx].uppercaseChar()).toMutableList())
            } else {
                backTracking(wordIdx + 1, (current + s[wordIdx]).toMutableList())
            }

            if (current.isNotEmpty()) {
                current.removeLast()
            }
        }
        backTracking(0, mutableListOf())
        return result
    }
}