package problem.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc738MonotoneIncreasingDigitsTest {

    @Test
    void monotoneIncreasingDigits() {
        assertEquals(999999999,new Lc738MonotoneIncreasingDigits().monotoneIncreasingDigits(1000000000));
        assertEquals(299,new Lc738MonotoneIncreasingDigits().monotoneIncreasingDigits(332));
        assertEquals(99,new Lc738MonotoneIncreasingDigits().monotoneIncreasingDigits(102));
        assertEquals(19,new Lc738MonotoneIncreasingDigits().monotoneIncreasingDigits(20));
        assertEquals(1234,new Lc738MonotoneIncreasingDigits().monotoneIncreasingDigits(1234));
    }
}