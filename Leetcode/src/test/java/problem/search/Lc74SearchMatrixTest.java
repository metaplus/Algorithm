package problem.search;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.*;

class Lc74SearchMatrixTest {

    @Test
    void searchMatrix() {
        assertFalse(new Lc74SearchMatrix().searchMatrix(ArrayParse.parse2DIntArray("[[1]]"),0));
    }
}