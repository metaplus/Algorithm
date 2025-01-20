package problem.array;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;
import problem.array.simulate.Lc100310IsArraySpecial;

import static org.junit.jupiter.api.Assertions.assertFalse;

class Lc100310IsArraySpecialTest {

    @Test
    void isArraySpecial() {
        assertFalse(new Lc100310IsArraySpecial().isArraySpecial(ArrayParse.parseIntArray("[2,1,4]")));
    }
}