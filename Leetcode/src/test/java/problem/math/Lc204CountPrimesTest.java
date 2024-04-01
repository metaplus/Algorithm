package problem.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc204CountPrimesTest {

    @Test
    void countPrimes() {
        assertEquals(4, new Lc204CountPrimes().countPrimes(499979));
        assertEquals(4, new Lc204CountPrimes().countPrimes(10));
    }
}