package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc995MinKBitFlipsTest {

    @Test
    void minKBitFlips() {
        assertEquals(-1, new Lc995MinKBitFlips().minKBitFlips(new int[]{0, 1, 1}, 2));
    }
}