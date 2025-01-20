package problem.search;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;
import problem.search.binary.Lc33Search;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc33SearchTest {

    @Test
    void search() {
        assertEquals(1, new Lc33Search().search(ArrayParse.parseIntArray("[5,1,2,3,4]"), 1));
        assertEquals(4, new Lc33Search().search(ArrayParse.parseIntArray("[4,5,6,7,8,1,2,3]"), 8));
        assertEquals(4, new Lc33Search().search(ArrayParse.parseIntArray("[4,5,6,7,0,1,2]"), 0));
        assertEquals(1, new Lc33Search().search(ArrayParse.parseIntArray("[1,3]"), 3));
        assertEquals(-1, new Lc33Search().search(ArrayParse.parseIntArray("[1,3]"), 2));
        assertEquals(-1, new Lc33Search().search(ArrayParse.parseIntArray("[4,5,6,7,0,1,2]"), 3));
        assertEquals(-1, new Lc33Search().search(ArrayParse.parseIntArray("[1]"), 2));
    }
}