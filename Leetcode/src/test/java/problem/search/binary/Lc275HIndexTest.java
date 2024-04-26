package problem.search.binary;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc275HIndexTest {

    @Test
    void hIndex() {
        assertEquals(1, new Lc275HIndex().hIndex(ArrayParse.parseIntArray("[1]")));
        assertEquals(3, new Lc275HIndex().hIndex(ArrayParse.parseIntArray("[0,1,3,5,6]")));
    }
}