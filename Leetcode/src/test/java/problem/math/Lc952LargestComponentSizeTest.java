package problem.math;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc952LargestComponentSizeTest {

    @Test
    void largestComponentSize() {
        assertEquals(4, new Lc952LargestComponentSize().largestComponentSize(ArrayParse.parseIntArray("[4,6,15,35]")));
    }
}