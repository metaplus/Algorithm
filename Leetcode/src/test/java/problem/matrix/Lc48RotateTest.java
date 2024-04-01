package problem.matrix;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Lc48RotateTest {

    @Test
    void rotate() {
        int[][] array = ArrayParse.parse2DIntArray("[[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]");
        new Lc48Rotate().rotate(array);
        assertArrayEquals(ArrayParse.parse2DIntArray("[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]"), array);
    }
}