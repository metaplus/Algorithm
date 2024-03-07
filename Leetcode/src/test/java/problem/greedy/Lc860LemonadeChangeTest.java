package problem.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc860LemonadeChangeTest {

    @Test
    void lemonadeChange() {
        assertTrue(new Lc860LemonadeChange().lemonadeChange(new int[]{5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5}));
        assertFalse(new Lc860LemonadeChange().lemonadeChange(new int[]{5, 5, 10, 10, 20}));
    }
}