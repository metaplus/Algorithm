package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc42TrapTest {

    @Test
    void trap() {
        assertEquals(3, new Lc42Trap().trap(new int[]{9, 6, 8, 8, 5, 6, 3}));
        assertEquals(12, new Lc42Trap().trap(new int[]{2, 8, 5, 5, 6, 1, 7, 4, 5}));
        assertEquals(7, new Lc42Trap().trap(new int[]{0, 7, 1, 4, 6}));
        assertEquals(1, new Lc42Trap().trap(new int[]{5, 4, 1, 2}));
        assertEquals(6, new Lc42Trap().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        assertEquals(9, new Lc42Trap().trap(new int[]{4, 2, 0, 3, 2, 5}));
    }
}