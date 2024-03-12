package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc1423MaxScoreTest {

    @Test
    void maxScore() {
        assertEquals(12, new Lc1423MaxScore().maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
    }
}