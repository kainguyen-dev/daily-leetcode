package array.easy

class FindAllNumberDisappearInArray {

    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val bitMap = BooleanArray(nums.size)

        for (num in nums) {
            bitMap[num-1] = true
        }


        val result = mutableListOf<Int>()

        for(index in bitMap.indices) {
            if (!bitMap[index]) result.add(index+1)
        }
        return result
    }

}