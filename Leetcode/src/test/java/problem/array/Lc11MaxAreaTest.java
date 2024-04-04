package problem.array;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc11MaxAreaTest {

    @Test
    void maxArea() {
        assertEquals(49, new Lc11MaxArea().maxArea(ArrayParse.parseIntArray("[1,8,6,2,5,4,8,3,7]")));
        assertEquals(24, new Lc11MaxArea().maxArea(new int[]{1, 3, 2, 5, 25, 24, 5}));
    }
}