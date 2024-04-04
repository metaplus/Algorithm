package problem.deque;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc373KSmallestPairsTest {

    @Test
    void kSmallestPairs() {
        assertEquals(ArrayParse.parse2DIntList("[[1,1],[1,1]]"), new Lc373KSmallestPairs()
                .kSmallestPairs(ArrayParse.parseIntArray("[1,1,2]"),
                        ArrayParse.parseIntArray("[1,2,3]"), 2));
        assertEquals(ArrayParse.parse2DIntList("[[1, 6], [1, 4], [1, 2]]"), new Lc373KSmallestPairs()
                .kSmallestPairs(ArrayParse.parseIntArray("[1,7,11]"),
                        ArrayParse.parseIntArray("[2,4,6]"), 3));
    }
}