package problem.pointer;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;
import problem.prefix.Lc2908MinimumSum;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc2908MinimumSumTest {

    @Test
    void minimumSum() {
        assertEquals(13, new Lc2908MinimumSum().minimumSum(ArrayParse.parseIntArray("[5,4,8,7,10,2]")));
    }
}