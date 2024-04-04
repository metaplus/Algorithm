package problem.dp;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc740DeleteAndEarnTest {

    @Test
    void deleteAndEarn() {
        assertEquals(9, new Lc740DeleteAndEarn().deleteAndEarn(ArrayParse.parseIntArray("[2,2,3,3,3,4]")));
    }
}