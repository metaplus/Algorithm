package problem.search.binary;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.*;

class Lc1351CountNegativesTest {

    @Test
    void countNegatives() {
        assertEquals(8, new Lc1351CountNegatives().countNegatives(ArrayParse.parse2DIntArray("[[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]")));
    }
}