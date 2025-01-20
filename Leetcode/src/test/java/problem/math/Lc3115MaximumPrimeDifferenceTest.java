package problem.math;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc3115MaximumPrimeDifferenceTest {

    @Test
    void maximumPrimeDifference() {
        assertEquals(3, new Lc3115MaximumPrimeDifference().maximumPrimeDifference(ArrayParse.parseIntArray("[4,2,9,5,3]")));
    }
}