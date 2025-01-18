package array.hard;

import java.util.Arrays;

public class FirstMissingPositiveJava {

    /**
     * https://leetcode.com/problems/first-missing-positive/description/
     * <p>
     * Given an unsorted integer array nums. Return the smallest positive integer
     * that is not present in nums.
     * <p>
     * You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.
     * <p>
     * Example 1:
     * Input: nums = [1,2,0]
     * Output: 3
     * Explanation: The numbers in the range [1,2] are all in the array.
     * <p>
     * Example 2:
     * <p>
     * Input: nums = [3,4,-1,1]
     * Output: 2
     * Explanation: 1 is in the array but 2 is missing.
     * <p>
     * Example 3:
     * Input: nums = [7,8,9,11,12]
     * Output: 1
     * Explanation: The smallest positive integer 1 is missing.
     */


    // Solution:
    // Remember that:
    // The result we want always have to be:
    // between 1 ... and N-1 where N is array length.
    //
    // So the problems become:
    // FROM 1 TO N first the first value that don't exist in the array.
    // The solution can be simply solve by but all elements in to a SET. HOWEVER:
    //
    // The constraint is:
    // Time O(N)
    // Space O(1)
    //
    // THIS MAKE SET SOLUTION DON'T WORK
    //
    //
    // ALTERNATIVE IDEA:
    // We use original array to "mark" which value exist
    // We use "negative" a way to mark value exist in array.
    // For example with array [3, 4, -1, 1]
    // We have 1 .. 3 .. 4 ..
    // So let mark array index 0 .. 2 .. 3 as NEGATIVE, indicate that 1 3 and 4 exist in our array.
    // We also have to force negative number ( -1 ) to be zeros.
    // So in essence we use, array as a map with: index is key, and element as value.

    public int firstMissingPositive(int[] nums) {
        int size = nums.length;

        var contain1 = false;
        for (int num : nums) {
            if (num == 1) {
                contain1 = true;
                break;
            }
        }

        if (!contain1) {
            return 1;
        }

        for (int i = 0; i < size; i++) {
            // offset negative number to zero
            if (nums[i] <= 0) {
                nums[i] = 1;
            }
        }
        System.out.println(Arrays.toString(nums));

        // Original array: [3, 4, -1, 1]
        // [3, 4, 0, 1]

        // Now let "flag" our array.
        for (int i = 0; i < size; i++) {
            var index = Math.abs(nums[i]) - 1;
            if (index >= 0 && index < nums.length) {
                if (nums[index] > 0) {
                    nums[index] = -1 * nums[index];
                }
            }
        }
        System.out.println(Arrays.toString(nums));

        // Suppose:     [1, 2, 3, 4]
        // Original:    [3, 4, -1, 1]
        // Real:        [-1, 4, -1, -1]

        for (int i = 0; i < size; i++) {
            var valueNotExist = nums[i] > 0;
            if (valueNotExist) {
                return i + 1;
            }
        }

        return size + 1;
    }

}
