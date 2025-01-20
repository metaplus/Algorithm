package problem.deque;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc84LargestRectangleAreaTest {

    @Test
    void largestRectangleArea() {
        assertEquals(9, new Lc84LargestRectangleArea().largestRectangleArea(ArrayParse.parseIntArray("[1,2,3,4,5]")));
        assertEquals(3, new Lc84LargestRectangleArea().largestRectangleArea(ArrayParse.parseIntArray("[2,1,2]")));
        assertEquals(9, new Lc84LargestRectangleArea().largestRectangleArea(ArrayParse.parseIntArray("[0,9]")));
        assertEquals(10, new Lc84LargestRectangleArea().largestRectangleArea(ArrayParse.parseIntArray("[2,1,5,6,2,3]")));
    }
}