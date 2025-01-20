package problem.greedy;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc2589FindMinimumTimeTest {

    @Test
    void findMinimumTime() {
        assertEquals(5, new Lc2589FindMinimumTime().findMinimumTime(ArrayParse.parse2DIntArray("[[1,18,5],[3,15,1]]")));
    }
}