package problem.dp;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc121MaxProfitTest {

    @Test
    void maxProfit() {
        assertEquals(5, new Lc121MaxProfit().maxProfit(ArrayParse.parseIntArray("[7,1,5,3,6,4]")));
    }
}