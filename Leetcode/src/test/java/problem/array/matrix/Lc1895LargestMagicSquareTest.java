package problem.array.matrix;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc1895LargestMagicSquareTest {

    @Test
    void largestMagicSquare() {
        assertEquals(3, new Lc1895LargestMagicSquare().largestMagicSquare(
                ArrayParse.parse2DIntArray("[[7,1,4,5,6],[2,5,1,6,4],[1,5,4,3,2],[1,2,7,3,4]]")));
    }
}