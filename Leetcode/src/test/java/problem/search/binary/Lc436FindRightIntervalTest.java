package problem.search.binary;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Lc436FindRightIntervalTest {

    @Test
    void findRightInterval() {
        assertArrayEquals(ArrayParse.parseIntArray("[-1,2,-1]"), new Lc436FindRightInterval().findRightInterval(
                ArrayParse.parse2DIntArray("[[1,4],[2,3],[3,4]]")));
    }
}