package problem.search;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;
import problem.search.binary.Lc162FindPeakElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc162FindPeakElementTest {

    @Test
    void findPeakElement() {
        assertEquals(1, new Lc162FindPeakElement().findPeakElement(ArrayParse.parseIntArray("[1,3,2,1]")));
        assertEquals(1, new Lc162FindPeakElement().findPeakElement(ArrayParse.parseIntArray("[1,2]")));
        assertEquals(5, new Lc162FindPeakElement().findPeakElement(ArrayParse.parseIntArray("[1,2,1,3,5,6,4]")));
        assertEquals(2, new Lc162FindPeakElement().findPeakElement(ArrayParse.parseIntArray("[1,2,3,1]")));
    }
}