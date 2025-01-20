package problem.array.simulate;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

class Lc100308IsArraySpecialTest {

    @Test
    void isArraySpecial() {
        boolean[] result = new Lc3152IsArraySpecial().isArraySpecial(
                ArrayParse.parseIntArray("[7,10]"),
                ArrayParse.parse2DIntArray("[[1,1],[0,1],[0,1],[0,0]]"));
    }
}