package problem.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc45JumpTest {

    @Test
    void jump() {
        assertEquals(2, new Lc45Jump().jump(new int[]{1, 2, 3}));
        assertEquals(1, new Lc45Jump().jump(new int[]{3,2,1}));
        assertEquals(1, new Lc45Jump().jump(new int[]{1, 2}));
        assertEquals(2, new Lc45Jump().jump(new int[]{2, 3, 1, 1, 4}));
        assertEquals(0, new Lc45Jump().jump(new int[]{0}));
    }
}