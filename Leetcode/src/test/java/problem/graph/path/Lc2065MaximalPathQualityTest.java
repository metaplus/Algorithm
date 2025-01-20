package problem.graph.path;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc2065MaximalPathQualityTest {

    @Test
    void maximalPathQuality() {
        assertEquals(75, new Lc2065MaximalPathQuality()
                .maximalPathQuality(ArrayParse.parseIntArray("[0,32,10,43]"),
                        ArrayParse.parse2DIntArray("[[0,1,10],[1,2,15],[0,3,10]]"), 49));
    }
}