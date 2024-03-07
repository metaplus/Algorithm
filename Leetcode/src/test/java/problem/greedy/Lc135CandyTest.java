package problem.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc135CandyTest {

    @Test
    void candy() {
        assertEquals(5, new Lc135Candy().candy(new int[]{1, 0, 2}));
    }
}