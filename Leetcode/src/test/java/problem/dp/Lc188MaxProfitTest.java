package problem.dp;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc188MaxProfitTest {

    @Test
    void maxProfit() {
        assertEquals(7, new Lc188MaxProfit().maxProfit(2, ArrayParse.parseIntArray("[3,2,6,5,0,3]")));
    }
}