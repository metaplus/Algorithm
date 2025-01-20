package problem.array.matrix;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc3148MaxScoreTest {

    @Test
    void maxScore() {

        assertEquals(9, new Lc3148MaxScore()
                .maxScore(ArrayParse.parse2DIntList("[[9,5,7,3],[8,9,6,1],[6,7,14,3],[2,5,3,1]]")));
        assertEquals(-1, new Lc3148MaxScore()
                .maxScore(ArrayParse.parse2DIntList("[[4,3,2],[3,2,1]]")));
    }
}