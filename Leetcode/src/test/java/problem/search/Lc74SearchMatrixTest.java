package problem.search;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;
import problem.search.binary.Lc74SearchMatrix;

import static org.junit.jupiter.api.Assertions.*;

class Lc74SearchMatrixTest {

    @Test
    void searchMatrix() {
        assertFalse(new Lc74SearchMatrix().searchMatrix(ArrayParse.parse2DIntArray("[[1],[3]]"),2));
        assertTrue(new Lc74SearchMatrix().searchMatrix(ArrayParse.parse2DIntArray("[[1]]"),1));
        assertFalse(new Lc74SearchMatrix().searchMatrix(ArrayParse.parse2DIntArray("[[1]]"),0));
    }
}