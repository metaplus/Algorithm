package problem.pointer;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;
import problem.hashmap.Lc560SubarraySum;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc560SubarraySumTest {

    @Test
    void subarraySum() {
        assertEquals(2, new Lc560SubarraySum().subarraySum(ArrayParse.parseIntArray("[1,1,1]"), 2));
        assertEquals(1, new Lc560SubarraySum().subarraySum(ArrayParse.parseIntArray("[-1,-1,1]"), 0));
        assertEquals(0, new Lc560SubarraySum().subarraySum(ArrayParse.parseIntArray("[1]"), 0));
    }
}