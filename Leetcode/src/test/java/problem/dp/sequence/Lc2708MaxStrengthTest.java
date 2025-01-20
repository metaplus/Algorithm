package problem.dp.sequence;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc2708MaxStrengthTest {

    @Test
    void maxStrength() {
        assertEquals(463050, new Lc2708MaxStrength().maxStrength(ArrayParse.parseIntArray("[-1,-7,-5,7,7,0,9,0,-5,-6]")));
        assertEquals(1350, new Lc2708MaxStrength().maxStrength(ArrayParse.parseIntArray("[3,-1,-5,2,5,-9]")));
    }
}