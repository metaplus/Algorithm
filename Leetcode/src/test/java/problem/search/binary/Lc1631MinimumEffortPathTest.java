package problem.search.binary;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc1631MinimumEffortPathTest {

    @Test
    void minimumEffortPath() {
        assertEquals(2, new Lc1631MinimumEffortPath().minimumEffortPath(
                ArrayParse.parse2DIntArray("[[1,2,2],[3,8,2],[5,3,5]]")));
    }
}