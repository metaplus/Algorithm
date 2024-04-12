package problem.deque;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc71SimplifyPathTest {

    @Test
    void simplifyPath() {
        assertEquals("/home", new Lc71SimplifyPath().simplifyPath("/home/"));
    }
}