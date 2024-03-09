package problem.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc202IsHappyTest {

    @Test
    void isHappy() {
        assertFalse(new Lc202IsHappy().isHappy(2));
        assertTrue(new Lc202IsHappy().isHappy(19));
    }
}