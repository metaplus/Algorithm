package problem.tree;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;
import problem.dp.Lc322CoinChange;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc322CoinChangeTest {

    @Test
    void coinChange() {
        assertEquals(24, new Lc322CoinChange().coinChange(ArrayParse.parseIntArray("[411,412,413,414,415,416,417,418,419,420,421,422]"), 9864));
        assertEquals(3, new Lc322CoinChange().coinChange(ArrayParse.parseIntArray("[1,2,5]"), 11));
        assertEquals(-1, new Lc322CoinChange().coinChange(ArrayParse.parseIntArray("[2]"), 3));
    }
}