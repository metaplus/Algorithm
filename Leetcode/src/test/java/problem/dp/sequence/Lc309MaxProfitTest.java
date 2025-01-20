package problem.dp.sequence;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;
import problem.dp.state.Lc309MaxProfit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc309MaxProfitTest {

    @Test
    void maxProfit() {
        assertEquals(0, new Lc309MaxProfit().maxProfit(ArrayParse.parseIntArray("[4,2,1]")));
        assertEquals(3, new Lc309MaxProfit().maxProfit(ArrayParse.parseIntArray("[1,2,4]")));
        assertEquals(0, new Lc309MaxProfit().maxProfit(ArrayParse.parseIntArray("[2,1]")));
        assertEquals(3, new Lc309MaxProfit().maxProfit(ArrayParse.parseIntArray("[1,2,3,0,2]")));
    }
}