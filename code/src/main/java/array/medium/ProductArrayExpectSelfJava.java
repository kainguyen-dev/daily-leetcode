package array.medium;

import java.util.Arrays;

public class ProductArrayExpectSelfJava {

    // https://leetcode.com/problems/product-of-array-except-self/

    /**
     * Input: nums = [1, 2, 3, 4]
     * <p>
     * 4   3   2   1
     * <p>
     * Output: [24,12,8,6]
     * <p>
     * 1 = 2 * 3 * 4
     * 2 = 1 * 3 * 4
     * 3 = 1 * 2 * 4
     * 4 = 1 * 2 * 3
     * <p>
     * 1  1  2   6
     * <p>
     * 1  4  12  24
     * <p>
     * (24*1) (1*12) (2*4) (6*1)
     */
    public int[] productExceptSelf(int[] nums) {

        // here we store res.
        // the value of res at index i th is the product of all element except itself from the left.
        int[] res = new int[nums.length];
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i - 1] * nums[i - 1];
        }

        // for array [1, 2, 3, 4]
        // res will be [1, 1, 2, 6]

        // now we go reverse, we move from the right.
        // We already know the res from 0 -> n - 1
        // we just need to go backward
        // But we also need to keep track of the right hand side

        // [1, 1, 2, 6], --> the result of last element is 6, because it is the product from 0 -> n -1,
        // result = [1, 1, 2, 6]
        // Now we calculate right hand side: right = right * num[n-1]
        //

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] *= right;
            right *= nums[i];
        }
        return res;
    }

}
