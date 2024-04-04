package problem.sort;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Lc75SortColorsTest {

    @Test
    void sortColors() {
        int[] array = ArrayParse.parseIntArray("[2,0,2,1,1,0]");
        new Lc75SortColors().sortColors(array);
        assertArrayEquals(ArrayParse.parseIntArray("[0,0,1,1,2,2]"), array);
    }
}