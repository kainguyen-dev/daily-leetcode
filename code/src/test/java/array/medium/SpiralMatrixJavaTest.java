package array.medium;

import org.junit.jupiter.api.Test;

class SpiralMatrixJavaTest {

    @Test
    void spiralOrder() {
        var test = new SpiralMatrixJava();
        var result = test.spiralOrder(new int[][] {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        });
        System.out.println(result);
    }
}