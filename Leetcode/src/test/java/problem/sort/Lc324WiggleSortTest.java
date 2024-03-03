package problem.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc324WiggleSortTest {

    @Test
    void wiggleSort() {
        {
            int[] ints = {1, 5, 1, 1, 6, 4};
            new Lc324WiggleSort().wiggleSort(ints);
            assertArrayEquals(new int[]{1, 5, 1, 6, 1, 4}, ints);
        }
        {
            int[] ints = {1, 1, 2, 1, 2, 2, 1};
            new Lc324WiggleSort().wiggleSort(ints);
            assertArrayEquals(new int[]{1, 2, 1, 2, 1, 2, 1}, ints);
        }

    }
}