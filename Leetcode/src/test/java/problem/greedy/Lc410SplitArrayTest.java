package problem.greedy;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;
import problem.search.binary.Lc410SplitArray;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc410SplitArrayTest {

    @Test
    void splitArray() {
        assertEquals(9, new Lc410SplitArray().splitArray(ArrayParse.parseIntArray("[1,2,3,4,5]"), 2));
        assertEquals(18, new Lc410SplitArray().splitArray(ArrayParse.parseIntArray("[7,2,5,10,8]"), 2));
        assertEquals(25, new Lc410SplitArray().splitArray(ArrayParse.parseIntArray("[10,5,13,4,8,4,5,11,14,9,16,10,20,8]"), 8));
    }
}