package problem.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc72MinDistanceTest {

    @Test
    void minDistance() {
        assertEquals(5, new Lc72MinDistance().minDistance("intention", "execution"));
        assertEquals(3, new Lc72MinDistance().minDistance("horse", "ros"));
    }
}