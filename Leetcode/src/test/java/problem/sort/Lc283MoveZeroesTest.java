package problem.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc283MoveZeroesTest {

    @Test
    void moveZeroes() {
        {
            int[] ints = {0};
            new Lc283MoveZeroes().moveZeroes(ints);
            assertArrayEquals(new int[]{0}, ints);
        }
        {
            int[] ints = {0, 1, 0, 3, 12};
            new Lc283MoveZeroes().moveZeroes(ints);
            assertArrayEquals(new int[]{1, 3, 12, 0, 0}, ints);
        }
    }
}