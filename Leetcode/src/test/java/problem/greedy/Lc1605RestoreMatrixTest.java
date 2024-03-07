package problem.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc1605RestoreMatrixTest {

    @Test
    void restoreMatrix() {
        assertArrayEquals(new int[][]{
                new int[]{0, 5, 0},
                new int[]{6, 1, 0},
                new int[]{2, 0, 8},
        }, new Lc1605RestoreMatrix()
                .restoreMatrix(new int[]{5, 7, 10}, new int[]{8, 6, 8}));
    }
}