package problem.dp;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc646FindLongestChainTest {

    @Test
    void findLongestChain() {
        assertEquals(3, new Lc646FindLongestChain().findLongestChain(ArrayParse.parse2DIntArray("[[1,2],[7,8],[4,5]]")));
    }
}