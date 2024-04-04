package problem.hashmap;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc128LongestConsecutiveTest {

    @Test
    void longestConsecutive() {
        assertEquals(4, new Lc128LongestConsecutive().longestConsecutive(ArrayParse.parseIntArray("[100,4,200,1,3,2]")));
    }
}