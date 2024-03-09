package problem.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc2834MinimumPossibleSumTest {

    @Test
    void minimumPossibleSum() {
        assertEquals(750000042, new Lc2834MinimumPossibleSum().minimumPossibleSum(1000000000, 1000000000));
        assertEquals(136, new Lc2834MinimumPossibleSum().minimumPossibleSum(16, 32));
        assertEquals(8, new Lc2834MinimumPossibleSum().minimumPossibleSum(3, 3));
        assertEquals(162, new Lc2834MinimumPossibleSum().minimumPossibleSum(16, 6));
    }
}