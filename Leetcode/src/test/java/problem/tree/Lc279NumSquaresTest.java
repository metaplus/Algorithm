package problem.tree;

import org.junit.jupiter.api.Test;
import problem.dp.Lc279NumSquares;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc279NumSquaresTest {

    @Test
    void numSquares() {
        assertEquals(3, new Lc279NumSquares().numSquares(43));
        assertEquals(1, new Lc279NumSquares().numSquares(1));
    }
}