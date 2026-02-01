package problem.search.dfs;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc3417MaximumAmountTest {

    @Test
    void maximumAmount() {
        assertEquals(-14, new Lc3417MaximumAmount().maximumAmount(ArrayParse.parse2DIntArray("[[-16,-18],[-18,-14]]")));
        assertEquals(60, new Lc3417MaximumAmount().maximumAmount(ArrayParse.parse2DIntArray("[[-7,12,12,13],[-6,19,19,-6],[9,-2,-10,16],[-4,14,-10,-9]]")));
        assertEquals(40, new Lc3417MaximumAmount().maximumAmount(ArrayParse.parse2DIntArray("[[10,10,10],[10,10,10]]")));
    }
}