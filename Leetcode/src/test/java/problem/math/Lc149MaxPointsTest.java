package problem.math;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.*;

class Lc149MaxPointsTest {

    @Test
    void maxPoints() {
        assertEquals(3,new Lc149MaxPoints().maxPoints(ArrayParse.parse2DIntArray("[[1,1],[2,2],[3,3]]")));
    }
}