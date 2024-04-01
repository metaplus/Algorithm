package problem.array;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc2580CountWaysTest {

    @Test
    void countWays() {
        assertEquals(4, new Lc2580CountWays().countWays(ArrayParse.parse2DIntArray("[[1,3],[10,20],[2,5],[4,8]]")));
    }
}