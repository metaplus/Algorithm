package problem.search.binary;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc1283SmallestDivisorTest {

    @Test
    void smallestDivisor() {
        assertEquals(5, new Lc1283SmallestDivisor().smallestDivisor(
                ArrayParse.parseIntArray("[1,2,5,9]"), 6));
    }
}