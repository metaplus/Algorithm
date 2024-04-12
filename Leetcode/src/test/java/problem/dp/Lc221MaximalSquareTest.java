package problem.dp;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc221MaximalSquareTest {

    @Test
    void maximalSquare() {
        assertEquals(9, new Lc221MaximalSquare().maximalSquare(ArrayParse.parse2DCharArray("[[\"0\",\"1\",\"1\",\"0\",\"1\"],[\"1\",\"1\",\"0\",\"1\",\"0\"],[\"0\",\"1\",\"1\",\"1\",\"0\"],[\"1\",\"1\",\"1\",\"1\",\"0\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"0\",\"0\",\"0\",\"0\",\"0\"]]")));
        assertEquals(1, new Lc221MaximalSquare().maximalSquare(ArrayParse.parse2DCharArray("[[\"0\",\"0\",\"0\",\"1\",\"0\",\"1\",\"1\",\"1\"],[\"0\",\"1\",\"1\",\"0\",\"0\",\"1\",\"0\",\"1\"],[\"1\",\"0\",\"1\",\"1\",\"1\",\"1\",\"0\",\"1\"],[\"0\",\"0\",\"0\",\"1\",\"0\",\"0\",\"0\",\"0\"],[\"0\",\"0\",\"1\",\"0\",\"0\",\"0\",\"1\",\"0\"],[\"1\",\"1\",\"1\",\"0\",\"0\",\"1\",\"1\",\"1\"],[\"1\",\"0\",\"0\",\"1\",\"1\",\"0\",\"0\",\"1\"],[\"0\",\"1\",\"0\",\"0\",\"1\",\"1\",\"0\",\"0\"],[\"1\",\"0\",\"0\",\"1\",\"0\",\"0\",\"0\",\"0\"]]")));
        assertEquals(4, new Lc221MaximalSquare().maximalSquare(ArrayParse.parse2DCharArray("[[\"1\",\"0\",\"1\",\"0\",\"0\"],[\"1\",\"0\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"0\",\"0\",\"1\",\"0\"]]")));
        assertEquals(16, new Lc221MaximalSquare().maximalSquare(ArrayParse.parse2DCharArray("[[\"1\",\"1\",\"1\",\"1\",\"0\"],[\"1\",\"1\",\"1\",\"1\",\"0\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"0\",\"0\",\"1\",\"1\",\"1\"]]")));
        assertEquals(4, new Lc221MaximalSquare().maximalSquare(ArrayParse.parse2DCharArray("[[\"1\",\"1\"],[\"1\",\"1\"]]")));
        assertEquals(1, new Lc221MaximalSquare().maximalSquare(ArrayParse.parse2DCharArray("[[\"0\",\"1\"],[\"1\",\"0\"]]")));
    }
}