package problem.pointer;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class Lc632SmallestRangeTest {

    @Test
    void smallestRange() {
        assertArrayEquals(ArrayParse.parseIntArray("[20,24]"),
                new Lc632SmallestRange().smallestRange(ArrayParse.parse2DIntList("[[4,10,15,24,26],[0,9,12,20],[5,18,22,30]]" )));
    }
}