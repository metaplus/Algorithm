package problem.dp;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc312MaxCoinsTest {

    @Test
    void maxCoins() {
//        assertEquals(167, new Lc312MaxCoins().maxCoins2(ArrayParse.parseIntArray("[3,1,5,8]\n")));
        assertEquals(167, new Lc312MaxCoins().maxCoins(ArrayParse.parseIntArray("[3,1,5,8]\n")));
        assertEquals(10, new Lc312MaxCoins().maxCoins(ArrayParse.parseIntArray("[1,5]\n")));
    }
}