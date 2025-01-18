package array.hard;

import org.junit.jupiter.api.Test;

class FirstMissingPositiveJavaTest {

    @Test
    void test_first_missing_positive_1() {
        var test = new FirstMissingPositiveJava();
        var nums = new int[]{3, 4, -1, 1};

        var value = test.firstMissingPositive(nums);
        System.out.println("result " + value);
    }

    @Test
    void test_first_missing_positive_2() {
        var test = new FirstMissingPositiveJava();

        var nums = new int[]{1, 2, 0};
        var value = test.firstMissingPositive(nums);
        System.out.println("result " + value);
    }

    @Test
    void test_first_missing_positive_3() {
        var test = new FirstMissingPositiveJava();

        var nums = new int[]{100000, 3, 4000, 2, 15, 1, 99999};
        //

        var value = test.firstMissingPositive(nums);
        System.out.println("result " + value);
    }

    @Test
    void test_first_missing_positive_4() {
        var test = new FirstMissingPositiveJava();

        var nums = new int[]{-1, -2, -60, 40, 43};
        //

        var value = test.firstMissingPositive(nums);
        System.out.println("result " + value);
    }
}