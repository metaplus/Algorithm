package problem.search;

import org.junit.jupiter.api.Test;
import problem.search.binary.Lc69MySqrt;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc69MySqrtTest {

    @Test
    void mySqrt() {
        assertEquals(1, new Lc69MySqrt().mySqrt(1));
        assertEquals(0, new Lc69MySqrt().mySqrt(0));
        assertEquals(46340, new Lc69MySqrt().mySqrt(2147483647));
        assertEquals(46339, new Lc69MySqrt().mySqrt(2147395599));
        assertEquals(2, new Lc69MySqrt().mySqrt(8));
    }
}