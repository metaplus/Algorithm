package problem.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc1400CanConstructTest {

    @Test
    void canConstruct() {
        assertTrue(new Lc1400CanConstruct().canConstruct("qlkzenwmmnpkopu", 15));
        assertFalse(new Lc1400CanConstruct().canConstruct("leetcode", 3));
        assertTrue(new Lc1400CanConstruct().canConstruct("yzyzyzyzyzyzyzy", 2));
        assertTrue(new Lc1400CanConstruct().canConstruct("annabelle", 2));
    }
}