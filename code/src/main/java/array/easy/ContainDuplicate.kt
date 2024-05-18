package array.easy

class ContainDuplicate {
    fun containsDuplicate(nums: IntArray): Boolean {
        val set = mutableSetOf<Int>()
        for (i in nums) {
            if (!set.contains(i)) set.add(i)
            else return true
        }
        return false
    }
}
