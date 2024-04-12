package problem.array;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc581FindUnsortedSubarrayTest {

    @Test
    void findUnsortedSubarray() {
        assertEquals(3, new Lc581FindUnsortedSubarray().findUnsortedSubarray(ArrayParse.parseIntArray("[1,2,4,5,3]")));
        assertEquals(4, new Lc581FindUnsortedSubarray().findUnsortedSubarray(ArrayParse.parseIntArray("[1,3,2,2,2]")));
    }
}