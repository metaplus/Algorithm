package problem.array;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.*;

class Lc1590MinSubarrayTest {

    @Test
    void minSubarray() {
        assertEquals(1,new Lc1590MinSubarray().minSubarray(ArrayParse.parseIntArray("[3,1,4,2]"),6));
        assertEquals(0,new Lc1590MinSubarray().minSubarray(ArrayParse.parseIntArray("[1000000000,1000000000,1000000000]"),3));
    }
}