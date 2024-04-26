package problem.search;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;
import problem.search.binary.Lc274HIndex;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc274HIndexTest {

    @Test
    void hIndex() {
        assertEquals(3, new Lc274HIndex().hIndex(ArrayParse.parseIntArray("[3,0,6,1,5]")));
        assertEquals(0, new Lc274HIndex().hIndex(ArrayParse.parseIntArray("[0]")));
        assertEquals(1, new Lc274HIndex().hIndex(ArrayParse.parseIntArray("[1]")));
    }
}