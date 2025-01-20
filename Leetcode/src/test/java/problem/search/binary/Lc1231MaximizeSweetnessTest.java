package problem.search.binary;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc1231MaximizeSweetnessTest {

    @Test
    void maximizeSweetness() {
        assertEquals(5, new Lc1231MaximizeSweetness().maximizeSweetness(
                ArrayParse.parseIntArray("[1,2,2,1,2,2,1,2,2]"), 2));
        assertEquals(6, new Lc1231MaximizeSweetness().maximizeSweetness(
                ArrayParse.parseIntArray("[1,2,3,4,5,6,7,8,9]"), 5));
    }
}