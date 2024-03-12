package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Lc977SortedSquaresTest {

    @Test
    void sortedSquares() {
        assertArrayEquals(new int[]{25},
                new Lc977SortedSquares().sortedSquares(new int[]{5}));
        assertArrayEquals(new int[]{0,1,9,16,100},
                new Lc977SortedSquares().sortedSquares(new int[]{-4, -1, 0, 3, 10}));

        ;
    }
}