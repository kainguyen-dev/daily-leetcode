package array.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ProductArrayExpectSelfJavaTest {

    @Test
    void productExceptSelf() {
        var test = new ProductArrayExpectSelfJava();
        var result = test.productExceptSelf(new int[] {1,2,3,4});
        System.out.println(Arrays.toString(result));
    }
}