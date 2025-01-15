package array.medium;

import org.junit.jupiter.api.Test;

class LongestConsecutiveSequenceJavaTest {

    @Test
    void test_longest_consecutive() {
        var nums = new int[]{100, 4, 200, 1, 3, 2};
        var test = new LongestConsecutiveSequenceJava();
        var result = test.longestConsecutive(nums);

        System.out.println(result);
    }
}