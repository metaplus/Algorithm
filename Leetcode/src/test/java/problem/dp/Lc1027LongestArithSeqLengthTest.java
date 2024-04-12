package problem.dp;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.*;

class Lc1027LongestArithSeqLengthTest {

    @Test
    void longestArithSeqLength() {
        assertEquals(4,new Lc1027LongestArithSeqLength().longestArithSeqLength(ArrayParse.parseIntArray("[20,1,15,3,10,5,8]")));
        assertEquals(4,new Lc1027LongestArithSeqLength().longestArithSeqLength(ArrayParse.parseIntArray("[3,6,9,12]")));
    }
}