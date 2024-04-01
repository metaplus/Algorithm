package problem.graph;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc797AllPathsSourceTargetTest {

    @Test
    void allPathsSourceTarget() {
        assertEquals(ArrayParse.parse2DIntList("[[0,1,3],[0,2,3]]"), new Lc797AllPathsSourceTarget()
                .allPathsSourceTarget(ArrayParse.parse2DIntArray("[[1,2],[3],[3],[]]")));
    }
}