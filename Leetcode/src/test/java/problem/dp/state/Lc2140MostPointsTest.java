package problem.dp.state;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc2140MostPointsTest {

    @Test
    void mostPoints() {
        assertEquals(79, new Lc2140MostPoints().mostPoints(ArrayParse.parse2DIntArray("[[12,46],[78,19],[63,15],[79,62],[13,10]]")));
        assertEquals(5, new Lc2140MostPoints().mostPoints(ArrayParse.parse2DIntArray("[[3,2],[4,3],[4,4],[2,5]]")));
        assertEquals(7, new Lc2140MostPoints().mostPoints(ArrayParse.parse2DIntArray("[[1,1],[2,2],[3,3],[4,4],[5,5]]")));
    }
}