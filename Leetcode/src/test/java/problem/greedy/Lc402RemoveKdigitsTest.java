package problem.greedy;

import org.junit.jupiter.api.Test;
import problem.deque.Lc402RemoveKdigits;

import static org.junit.jupiter.api.Assertions.*;

class Lc402RemoveKdigitsTest {

    @Test
    void removeKdigits() {
        assertEquals("0", new Lc402RemoveKdigits().removeKdigits("10001", 4));
        assertEquals("0", new Lc402RemoveKdigits().removeKdigits("10", 2));
        assertEquals("200", new Lc402RemoveKdigits().removeKdigits("10200", 1));
        assertEquals("1219", new Lc402RemoveKdigits().removeKdigits("1432219", 3));
        assertEquals("33", new Lc402RemoveKdigits().removeKdigits("5337", 2));
        assertEquals("123", new Lc402RemoveKdigits().removeKdigits("12345", 2));
        assertEquals("11", new Lc402RemoveKdigits().removeKdigits("112", 1));
    }
}