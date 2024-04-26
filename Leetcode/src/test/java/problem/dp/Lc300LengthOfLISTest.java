package problem.dp;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;
import problem.dp.sequence.Lc300LengthOfLIS;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc300LengthOfLISTest {

    @Test
    void lengthOfLIS() {
        assertEquals(3, new Lc300LengthOfLIS().lengthOfLIS(ArrayParse.parseIntArray("[4,10,4,3,8,9]")));
        assertEquals(2, new Lc300LengthOfLIS().lengthOfLIS(ArrayParse.parseIntArray("[3,1,2]")));
        assertEquals(1, new Lc300LengthOfLIS().lengthOfLIS(ArrayParse.parseIntArray("[7,7,7,7,7,7,7]")));
        assertEquals(4, new Lc300LengthOfLIS().lengthOfLIS(ArrayParse.parseIntArray("[10,9,2,5,3,7,101,18]")));
    }
}