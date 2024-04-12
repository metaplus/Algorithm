package problem.dp;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc123MaxProfitTest {

    @Test
    void maxProfit() {
        assertEquals(4, new Lc123MaxProfit().maxProfit(ArrayParse.parseIntArray("[1,2,3,4,5]")));
        assertEquals(6, new Lc123MaxProfit().maxProfit(ArrayParse.parseIntArray("[3,3,5,0,0,3,1,4]")));
    }
}