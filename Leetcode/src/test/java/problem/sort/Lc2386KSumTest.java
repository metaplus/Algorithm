package problem.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc2386KSumTest {

    @Test
    void kSum() {
        assertEquals(10, new Lc2386KSum().kSum(new int[]{1, -2, 3, 4, -10, 12}, 16));
        assertEquals(2, new Lc2386KSum().kSum(new int[]{2, 4, -2}, 5));
    }
}