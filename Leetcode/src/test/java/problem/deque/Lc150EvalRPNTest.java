package problem.deque;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.*;

class Lc150EvalRPNTest {

    @Test
    void evalRPN() {
        assertEquals(6,new Lc150EvalRPN().evalRPN(ArrayParse.parseStringArray("[\"4\",\"13\",\"5\",\"/\",\"+\"]")));
    }
}