package problem.search.binary;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc1870MinSpeedOnTimeTest {

    @Test
    void minSpeedOnTime() {
        assertEquals(10000000, new Lc1870MinSpeedOnTime()
                .minSpeedOnTime(ArrayParse.parseIntArray("[1,1,100000]"), 2.01));
        assertEquals(3, new Lc1870MinSpeedOnTime()
                .minSpeedOnTime(ArrayParse.parseIntArray("[1,3,2]"), 2.7));
    }
}