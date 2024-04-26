package problem.search.binary;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc441ArrangeCoinsTest {

    @Test
    void arrangeCoins() {
        assertEquals(3, new Lc441ArrangeCoins().arrangeCoins(8));
        assertEquals(2, new Lc441ArrangeCoins().arrangeCoins(3));
        assertEquals(65535, new Lc441ArrangeCoins().arrangeCoins(2147483647));
        assertEquals(1, new Lc441ArrangeCoins().arrangeCoins(1));
        assertEquals(2, new Lc441ArrangeCoins().arrangeCoins(5));
    }
}