package problem.dp.bag;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc377CombinationSum4Test {

    @Test
    void combinationSum4() {
        assertEquals(7, new Lc377CombinationSum4().combinationSum4(ArrayParse.parseIntArray("[1,2,3]"), 4));
    }
}