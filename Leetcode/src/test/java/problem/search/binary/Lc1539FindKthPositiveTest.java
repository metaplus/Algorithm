package problem.search.binary;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc1539FindKthPositiveTest {

    @Test
    void findKthPositive() {
        assertEquals(2, new Lc1539FindKthPositive().findKthPositive(ArrayParse.parseIntArray("[3,10]"), 2));
        assertEquals(1, new Lc1539FindKthPositive().findKthPositive(ArrayParse.parseIntArray("[2]"), 1));
        assertEquals(9, new Lc1539FindKthPositive().findKthPositive(ArrayParse.parseIntArray("[2,3,4,7,11]"), 5));
    }
}