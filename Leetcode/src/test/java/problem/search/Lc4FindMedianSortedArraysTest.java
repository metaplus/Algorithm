package problem.search;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc4FindMedianSortedArraysTest {

    @Test
    void findMedianSortedArrays() {
        assertEquals(1, new Lc4FindMedianSortedArrays()
                .findMedianSortedArrays(ArrayParse.parseIntArray("[1,1]"), ArrayParse.parseIntArray("[1,2]")));
           assertEquals(1.5, new Lc4FindMedianSortedArrays()
                .findMedianSortedArrays(ArrayParse.parseIntArray("[1,2]"), ArrayParse.parseIntArray("[-1,3]")));
        assertEquals(3, new Lc4FindMedianSortedArrays()
                .findMedianSortedArrays(ArrayParse.parseIntArray("[2,2,4,4]"), ArrayParse.parseIntArray("[2,2,4,4]")));
        assertEquals(-1, new Lc4FindMedianSortedArrays()
                .findMedianSortedArrays(ArrayParse.parseIntArray("[3]"), ArrayParse.parseIntArray("[-2,-1]")));
        assertEquals(2.5, new Lc4FindMedianSortedArrays()
                .findMedianSortedArrays(ArrayParse.parseIntArray("[1,2]"), ArrayParse.parseIntArray("[3,4]")));
        assertEquals(2, new Lc4FindMedianSortedArrays()
                .findMedianSortedArrays(ArrayParse.parseIntArray("[1,3]"), ArrayParse.parseIntArray("[2]")));
    }
}