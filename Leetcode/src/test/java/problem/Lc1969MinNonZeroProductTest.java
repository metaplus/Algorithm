package problem;

import org.junit.jupiter.api.Test;
import problem.greedy.Lc1969MinNonZeroProduct;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc1969MinNonZeroProductTest {

    @Test
    void minNonZeroProduct() {
        assertEquals(505517599, new Lc1969MinNonZeroProduct().minNonZeroProduct(32));
        assertEquals(202795991, new Lc1969MinNonZeroProduct().minNonZeroProduct(5));
        assertEquals(581202553, new Lc1969MinNonZeroProduct().minNonZeroProduct(4));
        assertEquals(6, new Lc1969MinNonZeroProduct().minNonZeroProduct(2));
        assertEquals(1512, new Lc1969MinNonZeroProduct().minNonZeroProduct(3));

    }
}