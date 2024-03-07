package problem.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc861MatrixScoreTest {

    @Test
    void matrixScore() {
        assertEquals(39, new Lc861MatrixScore()
                .matrixScore(new int[][]{
                        new int[]{0, 0, 1, 1},
                        new int[]{1, 0, 1, 0},
                        new int[]{1, 1, 0, 0},
                }));
    }
}