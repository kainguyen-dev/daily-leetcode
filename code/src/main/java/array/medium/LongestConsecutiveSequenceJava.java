package array.medium;

import java.util.HashSet;

public class LongestConsecutiveSequenceJava {


    // https://leetcode.com/problems/longest-consecutive-sequence/
    // Input: nums = [100,4,200,1,3,2]
    // Output: 4
    // Explanation: The longest consecutive elements sequence is [1, 2, 3, 4].
    // Therefore, its length is 4.
    public int longestConsecutive(int[] nums) {
        int result = 0;
        var set = new HashSet<Integer>();

        for (int num : nums) {
            set.add(num);
        }

        for (int num : nums) {
            int tempResult = 1;

            // check from the left of num[i]
            var left = num - 1;
            while (set.contains(left)) {
                tempResult++;
                set.remove(left);
                left--;
            }

            // check from the right of num[i]
            var right = num + 1;
            while (set.contains(right)) {
                tempResult++;
                set.remove(right);
                right++;
            }

            result = Math.max(result, tempResult);
            if (set.isEmpty()) return result;
        }
        return result;
    }

    // Solution, briefly
    // Imagine we can divide the array into small non-consecutive part

    // [100,4,200,1,3,2]  become
    //  [ 1 2 3 4 ]      [100]      [200]

    // So the idea is from a single element, we try to span out: meaning we go to left consecutive element count the
    // result
    // and the right consecutive element, and count the result.
    // We then check this result with the max result.

    // We create a set of all element so that the check can be o(1)
    // Say if we get 4.
    // Then we check from the right side = 5 -> No
    // Then we check from the left side = 3 -> yes -> count = 2
    // Check 2 -> yes count = 3 ....

}
