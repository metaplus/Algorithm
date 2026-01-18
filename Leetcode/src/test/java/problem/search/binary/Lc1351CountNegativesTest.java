package problem.search.binary;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.*;

class Lc1351CountNegativesTest {

    @Test
    void countNegatives() {
        assertEquals(8, new Lc1351CountNegatives().countNegatives(ArrayParse.parse2DIntArray("[[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]")));
    }

    @Test
    void countNegatives2() {
        assertEquals(16, new Lc1351CountNegatives().countNegatives2(ArrayParse.parse2DIntArray("[[3,-1,-3,-3,-3],[2,-2,-3,-3,-3],[1,-2,-3,-3,-3],[0,-3,-3,-3,-3]]")));
        assertEquals(8, new Lc1351CountNegatives().countNegatives2(ArrayParse.parse2DIntArray("[[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]")));
    }
}