package array.medium

class FindAllDuplicateInArr {

    fun findDuplicates(nums: IntArray): List<Int> {
        val bitmap = BooleanArray(nums.size)
        val result = mutableListOf<Int>()
        for (i in nums) {
            if (!bitmap[i - 1]) {
                bitmap[i - 1] = true
            } else {
                bitmap[i-1] = false
                result.add(i)
            }
        }
        return result
    }

}