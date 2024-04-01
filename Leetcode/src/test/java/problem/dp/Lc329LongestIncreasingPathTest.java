package problem.dp;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc329LongestIncreasingPathTest {

    @Test
    void longestIncreasingPath() {
        assertEquals(4, new Lc329LongestIncreasingPath().longestIncreasingPath(ArrayParse.parse2DIntArray("[[7,7,5],[2,4,6],[8,2,0]]")));
        assertEquals(4, new Lc329LongestIncreasingPath().longestIncreasingPath(ArrayParse.parse2DIntArray("[[9,9,4],[6,6,8],[2,1,1]]")));
    }
}