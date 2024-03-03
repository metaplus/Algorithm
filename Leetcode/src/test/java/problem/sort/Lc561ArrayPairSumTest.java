package problem.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc561ArrayPairSumTest {

    @Test
    void arrayPairSum() {
        assertEquals(-6093, new Lc561ArrayPairSum().arrayPairSum(new int[]{-470, 66, -4835, -5623}));
        assertEquals(9, new Lc561ArrayPairSum().arrayPairSum(new int[]{6, 2, 6, 5, 1, 2}));
    }
}