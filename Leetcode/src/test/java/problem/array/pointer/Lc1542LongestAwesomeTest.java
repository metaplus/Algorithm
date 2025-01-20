package problem.array.pointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc1542LongestAwesomeTest {

    @Test
    void longestAwesome() {
        assertEquals(6, new Lc1542LongestAwesome().longestAwesome("213123"));
        assertEquals(5, new Lc1542LongestAwesome().longestAwesome("3242415"));
    }
}