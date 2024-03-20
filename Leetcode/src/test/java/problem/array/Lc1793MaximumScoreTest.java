package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc1793MaximumScoreTest {

    @Test
    void maximumScore() {
        assertEquals(9014, new Lc1793MaximumScore().maximumScore(new int[]{8182, 1273, 9847, 6230, 52, 1467, 6062, 726, 4852, 4507, 2460, 2041, 500, 1025, 5524}, 8));
    }
}