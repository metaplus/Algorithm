package problem.math.bit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc762CountPrimeSetBitsTest {

    @Test
    void countPrimeSetBits() {
        assertEquals(5, new Lc762CountPrimeSetBits().countPrimeSetBits(10, 15));
        assertEquals(4, new Lc762CountPrimeSetBits().countPrimeSetBits(6, 10));
    }
}