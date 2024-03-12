package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc992SubArraysWithKDistinctTest {

    @Test
    void subarraysWithKDistinct() {
        assertEquals(8, new Lc992SubArraysWithKDistinct().subarraysWithKDistinct(new int[]{2,1,1,1,2}, 1));
        assertEquals(7, new Lc992SubArraysWithKDistinct().subarraysWithKDistinct(new int[]{1, 2, 1, 2, 3}, 2));
    }
}