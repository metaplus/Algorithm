package problem.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc921MinAddToMakeValidTest {

    @Test
    void minAddToMakeValid() {
        assertEquals(4, new Lc921MinAddToMakeValid().minAddToMakeValid("()))(("));
        assertEquals(3, new Lc921MinAddToMakeValid().minAddToMakeValid("((("));
        assertEquals(1, new Lc921MinAddToMakeValid().minAddToMakeValid("())"));
    }
}