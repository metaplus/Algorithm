package problem.deque;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc264NthUglyNumberTest {

    @Test
    void nthUglyNumber() {
        assertEquals(536870912, new Lc264NthUglyNumber().nthUglyNumber(1407));
        assertEquals(12, new Lc264NthUglyNumber().nthUglyNumber(10));
        assertEquals(2, new Lc264NthUglyNumber().nthUglyNumber(2));
    }
}