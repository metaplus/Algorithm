package problem.dp;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc918MaxSubarraySumCircularTest {

    @Test
    void maxSubarraySumCircular() {
        assertEquals(-2, new Lc918MaxSubarraySumCircular().maxSubarraySumCircular(ArrayParse.parseIntArray("[-3,-2,-3]")));
        assertEquals(3, new Lc918MaxSubarraySumCircular().maxSubarraySumCircular(ArrayParse.parseIntArray("[1,-2,3,-2]")));
        assertEquals(16, new Lc918MaxSubarraySumCircular().maxSubarraySumCircular(ArrayParse.parseIntArray("[0,5,8,-9,9,-7,3,-2]")));
        assertEquals(10, new Lc918MaxSubarraySumCircular().maxSubarraySumCircular(ArrayParse.parseIntArray("[5,-3,5]")));
    }
}