package problem.search;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.*;

class Lc34SearchRangeTest {

    @Test
    void searchRange() {
        assertArrayEquals(ArrayParse.parseIntArray("[3,4]"),
                new Lc34SearchRange().searchRange(ArrayParse.parseIntArray("[5,7,7,8,8,10]"),8));
    }
}