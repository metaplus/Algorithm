package problem.deque;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.*;

class Lc85MaximalRectangleTest {

    @Test
    void maximalRectangle() {
        assertEquals(6,new Lc85MaximalRectangle().maximalRectangle(ArrayParse.parse2DCharArray("[[\"1\",\"0\",\"1\",\"0\",\"0\"],[\"1\",\"0\",\"1\",\"1\",\"1\"],[\"1\",\"1\",\"1\",\"1\",\"1\"],[\"1\",\"0\",\"0\",\"1\",\"0\"]]\n" +
                "\n")));
    }
}