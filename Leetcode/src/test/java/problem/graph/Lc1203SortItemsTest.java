package problem.graph;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Lc1203SortItemsTest {

    @Test
    void sortItems() {
        assertArrayEquals(ArrayParse.parseIntArray("[3,2,4,1,0]"),
                new Lc1203SortItems().sortItems(5, 5,
                        ArrayParse.parseIntArray("[2,0,-1,3,0]"),
                        ArrayParse.parse2DIntList("[[2,1,3],[2,4],[],[],[]]")));
        assertArrayEquals(ArrayParse.parseIntArray("[]"),
                new Lc1203SortItems().sortItems(8, 2,
                        ArrayParse.parseIntArray("[-1,-1,1,0,0,1,0,-1]"),
                        ArrayParse.parse2DIntList("[[],[6],[5],[6],[3],[],[4],[]]")));
        assertArrayEquals(ArrayParse.parseIntArray("[6, 3, 4, 5, 2, 0, 7, 1]"),
                new Lc1203SortItems().sortItems(8, 2,
                        ArrayParse.parseIntArray("[-1,-1,1,0,0,1,0,-1]"),
                        ArrayParse.parse2DIntList("[[],[6],[5],[6],[3,6],[],[],[]]")));
    }
}