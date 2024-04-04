package problem.greedy;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Lc55CanJumpTest {

    @Test
    void canJump() {
        assertTrue(new Lc55CanJump().canJump(ArrayParse.parseIntArray("[2,3,1,1,4]")));
        assertTrue(new Lc55CanJump().canJump(new int[]{2, 0}));
        assertTrue(new Lc55CanJump().canJump(new int[]{1, 2}));
        assertFalse(new Lc55CanJump().canJump(new int[]{1, 0, 1, 0}));
        assertFalse(new Lc55CanJump().canJump(new int[]{3, 2, 1, 0, 4}));
    }
}