package problem.greedy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc45JumpTest {

    @Test
    void jump() {
        assertEquals(2, new Lc45Jump().jump(new int[]{2, 3, 1, 1, 4}));
    }
}