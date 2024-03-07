package problem.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc402RemoveKdigitsTest {

    @Test
    void removeKdigits() {
        assertEquals("123", new Lc402RemoveKdigits().removeKdigits("12345", 2));
        assertEquals("33", new Lc402RemoveKdigits().removeKdigits("5337", 2));
        assertEquals("11", new Lc402RemoveKdigits().removeKdigits("112", 1));
    }
}