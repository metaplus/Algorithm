package problem.deque;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Lc739DailyTemperaturesTest {

    @Test
    void dailyTemperatures() {
        assertArrayEquals(ArrayParse.parseIntArray("[8,1,5,4,3,2,1,1,0,0]"),
                new Lc739DailyTemperatures().dailyTemperatures(ArrayParse.parseIntArray("[89,62,70,58,47,47,46,76,100,70]")));
          assertArrayEquals(ArrayParse.parseIntArray("[1,1,4,2,1,1,0,0]"),
                new Lc739DailyTemperatures().dailyTemperatures(ArrayParse.parseIntArray("[73,74,75,71,69,72,76,73]")));
    }
}