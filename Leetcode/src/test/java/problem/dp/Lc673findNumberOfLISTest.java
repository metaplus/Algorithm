package problem.dp;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc673findNumberOfLISTest {

    @Test
    void findNumberOfLIS() {
        assertEquals(3, new Lc673findNumberOfLIS().findNumberOfLIS(ArrayParse.parseIntArray("[1,2,4,3,5,4,7,2]")));
        assertEquals(5, new Lc673findNumberOfLIS().findNumberOfLIS(ArrayParse.parseIntArray("[2,2,2,2,2]")));
        assertEquals(2, new Lc673findNumberOfLIS().findNumberOfLIS(ArrayParse.parseIntArray("[1,3,5,4,7]")));
    }
}