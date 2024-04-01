package problem.greedy;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc410SplitArrayTest {

    @Test
    void splitArray() {
        assertEquals(18, new Lc410SplitArray().splitArray(ArrayParse.parseIntArray("[7,2,5,10,8]"), 2));
        assertEquals(25, new Lc410SplitArray().splitArray(ArrayParse.parseIntArray("[10,5,13,4,8,4,5,11,14,9,16,10,20,8]"), 8));
    }
}