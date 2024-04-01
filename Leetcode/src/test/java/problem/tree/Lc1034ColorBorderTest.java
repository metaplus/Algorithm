package problem.tree;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Lc1034ColorBorderTest {

    @Test
    void colorBorder() {
        assertArrayEquals(ArrayParse.parse2DIntArray("[[1,1,1,1,1,2],[1,2,1,1,1,2],[1,1,1,1,1,2]]"),
                new Lc1034ColorBorder().colorBorder(ArrayParse.parse2DIntArray("[[1,2,1,2,1,2],[2,2,2,2,1,2],[1,2,2,2,1,2]]"),
                        1, 3, 1));
        assertArrayEquals(ArrayParse.parse2DIntArray("[[2,2,2],[2,1,2],[2,2,2]]"),
                new Lc1034ColorBorder().colorBorder(ArrayParse.parse2DIntArray("[[1,1,1],[1,1,1],[1,1,1]]"),
                        1, 1, 2));

        assertArrayEquals(ArrayParse.parse2DIntArray("[[1,3,3],[2,3,3]]"),
                new Lc1034ColorBorder().colorBorder(ArrayParse.parse2DIntArray("[[1,2,2],[2,3,2]]"),
                        0, 1, 3));




        assertArrayEquals(ArrayParse.parse2DIntArray("[[3,3],[3,2]]"),
                new Lc1034ColorBorder().colorBorder(ArrayParse.parse2DIntArray("[[1,1],[1,2]]"),
                        0, 0, 3));
    }
}