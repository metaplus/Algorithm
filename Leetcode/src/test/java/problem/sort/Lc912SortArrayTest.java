package problem.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc912SortArrayTest {

    @Test
    void sortArray() {
        assertArrayEquals(new int[]{0, 0, 1, 1, 2, 5}, new Lc912SortArray().sortArray(new int[]{5, 1, 1, 2, 0, 0}));
        assertArrayEquals(new int[]{1, 2, 3, 5}, new Lc912SortArray().sortArray(new int[]{5, 2, 3, 1}));
    }
}