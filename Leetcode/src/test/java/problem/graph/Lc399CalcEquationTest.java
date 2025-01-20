package problem.graph;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Lc399CalcEquationTest {

    @Test
    void calcEquation() {
        assertArrayEquals(ArrayParse.parseDoubleArray("[6.00000,0.50000,-1.00000,1.00000,-1.00000]\n"),
                new Lc399CalcEquation().calcEquation(
                        ArrayParse.parse2DStringList("[[\"a\",\"b\"],[\"b\",\"c\"]]\n"),
                        ArrayParse.parseDoubleArray("[2.0,3.0]\n"),
                        ArrayParse.parse2DStringList("[[\"a\",\"c\"],[\"b\",\"a\"],[\"a\",\"e\"],[\"a\",\"a\"],[\"x\",\"x\"]]\n" +
                                "\n")
                ));
    }
}