package array.medium

import org.junit.jupiter.api.Test

class ProductArrayExpectSelfTest {

    @Test
    fun test_product_except_self() {
        val product = ProductArrayExpectSelf()
        product.productExceptSelf(intArrayOf(1,2,3,4))
    }


}