package array.medium

class ProductArrayExpectSelf {

    // https://leetcode.com/problems/product-of-array-except-self/
    /**
     * Input: nums = [1, 2, 3, 4]
     *
     * 4   3   2   1
     *
     * Output: [24,12,8,6]
     *
     * 1 = 2 * 3 * 4
     * 2 = 1 * 3 * 4
     * 3 = 1 * 2 * 4
     * 4 = 1 * 2 * 3
     *
     *  1  1  2    6    24
     *
     *  1  4  12  24    24
     *
     *  (24*1) (1*12) (2*4) (6*1)
     */
    fun productExceptSelf(nums: IntArray): IntArray {
        val forwardProduct = mutableListOf<Int>()
        val reverseProduct = mutableListOf<Int>()

        forwardProduct.add(nums[0])
        for (i in 1..<nums.size) {
            forwardProduct.add(nums[i] * forwardProduct[i-1]) // [1, 1, 2, 6, 24]
        }
        nums.reverse()
        reverseProduct.add(nums[0])
        for (i in 1..<nums.size) {
            reverseProduct.add(nums[i] * reverseProduct[i-1]) // [1, 4, 12, 24, 24]  (24*1) (1*12) (2*4) (6*1)
        }
        forwardProduct.add(0, 1)
        reverseProduct.add(0, 1)

        val result = mutableListOf<Int>()
        for(i in nums.indices) {
            result.add(forwardProduct[i] * reverseProduct[nums.size - 1 - i])
        }
        return result.toIntArray()
    }



}