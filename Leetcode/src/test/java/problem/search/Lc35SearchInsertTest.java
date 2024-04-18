package problem.search;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;
import problem.search.binary.Lc35SearchInsert;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc35SearchInsertTest {

    @Test
    void searchInsert() {
        assertEquals(1, new Lc35SearchInsert().searchInsert(ArrayParse.parseIntArray("[1,3,5,6]"), 2));
        assertEquals(4, new Lc35SearchInsert().searchInsert(ArrayParse.parseIntArray("[1,3,5,6]"), 7));
        assertEquals(2, new Lc35SearchInsert().searchInsert(ArrayParse.parseIntArray("[1,3,5,6]"), 5));
    }
}