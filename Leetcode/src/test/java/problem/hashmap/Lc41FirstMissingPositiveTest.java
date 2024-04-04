package problem.hashmap;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc41FirstMissingPositiveTest {

    @Test
    void firstMissingPositive() {
        assertEquals(2, new Lc41FirstMissingPositive().firstMissingPositive(ArrayParse.parseIntArray("[1,1]")));
        assertEquals(2, new Lc41FirstMissingPositive().firstMissingPositive(ArrayParse.parseIntArray("[1]")));
        assertEquals(3, new Lc41FirstMissingPositive().firstMissingPositive(ArrayParse.parseIntArray("[1,2,0]")));
    }
}