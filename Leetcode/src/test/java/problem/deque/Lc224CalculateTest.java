package problem.deque;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc224CalculateTest {

    @Test
    void calculate() {
        assertEquals(3, new Lc224Calculate().calculate("1-(     -2)"));
        assertEquals(2, new Lc224Calculate().calculate("1 + 1"));
        assertEquals(23, new Lc224Calculate().calculate("(1+(4+5+2)-3)+(6+8)"));
        assertEquals(3, new Lc224Calculate().calculate(" 2-1 + 2 "));
    }
}