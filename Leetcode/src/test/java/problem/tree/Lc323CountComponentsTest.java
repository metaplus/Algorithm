package problem.tree;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc323CountComponentsTest {

    @Test
    void countComponents() {
        assertEquals(2, new Lc323CountComponents().countComponents(5, ArrayParse.parse2DIntArray("[[0,1],[1,2],[3,4]]")));
    }
}