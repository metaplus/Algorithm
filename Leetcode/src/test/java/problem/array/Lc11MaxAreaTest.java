package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc11MaxAreaTest {

    @Test
    void maxArea() {
        assertEquals(24, new Lc11MaxArea().maxArea(new int[]{1, 3, 2, 5, 25, 24, 5}));
    }
}