package problem.backtrack;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc46PermuteTest {

    @Test
    void permute() {
        assertEquals(ArrayParse.parse2DIntList("[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]"), new Lc46Permute().permute(ArrayParse.parseIntArray("[1,2,3]")));
    }
}