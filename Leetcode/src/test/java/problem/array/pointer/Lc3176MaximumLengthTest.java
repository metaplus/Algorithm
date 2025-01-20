package problem.array.pointer;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc3176MaximumLengthTest {

    @Test
    void maximumLength() {
        assertEquals(2, new Lc3176MaximumLength().maximumLength(ArrayParse.parseIntArray("[13,9,13]"), 1));
        assertEquals(3, new Lc3176MaximumLength().maximumLength(ArrayParse.parseIntArray("[10,5,7]"), 2));
        assertEquals(2, new Lc3176MaximumLength().maximumLength(ArrayParse.parseIntArray("[5,4]"), 1));
        assertEquals(4, new Lc3176MaximumLength().maximumLength(ArrayParse.parseIntArray("[1,2,1,1,3]"), 2));
    }
}