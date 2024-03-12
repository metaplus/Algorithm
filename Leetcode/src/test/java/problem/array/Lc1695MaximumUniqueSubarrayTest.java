package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc1695MaximumUniqueSubarrayTest {

    @Test
    void maximumUniqueSubarray() {
        assertEquals(8, new Lc1695MaximumUniqueSubarray().maximumUniqueSubarray(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5}));
    }
}