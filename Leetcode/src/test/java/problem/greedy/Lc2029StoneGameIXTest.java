package problem.greedy;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.*;

class Lc2029StoneGameIXTest {

    @Test
    void stoneGameIX() {
        assertTrue(new Lc2029StoneGameIX().stoneGameIX(ArrayParse.parseIntArray("[20,3,20,17,2,12,15,17,4]")));
    }
}