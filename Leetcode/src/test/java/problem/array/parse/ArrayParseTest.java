package problem.array.parse;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ArrayParseTest {

    @Test
    void parse2DArray() {
        int[][] array = ArrayParse.parse2DIntArray("[[0,1],[1,2],[3,4]]");
        assertNotNull(array);
    }

    @Test
    void parse2DStringArray() {
        String[][] strings = ArrayParse.parse2DStringArray("[[\"E\",\"E\",\"E\",\"E\",\"E\"],[\"E\",\"E\",\"M\",\"E\",\"E\"],[\"E\",\"E\",\"E\",\"E\",\"E\"],[\"E\",\"E\",\"E\",\"E\",\"E\"]]");
        char[][] chars = ArrayParse.parse2DCharArray("[[\"E\",\"E\",\"E\",\"E\",\"E\"],[\"E\",\"E\",\"M\",\"E\",\"E\"],[\"E\",\"E\",\"E\",\"E\",\"E\"],[\"E\",\"E\",\"E\",\"E\",\"E\"]]");
        assertNotNull(strings);
        assertNotNull(chars);
    }

    @Test
    void parseIntArray() {
        int[] ints = ArrayParse.parseIntArray("[3,0]");
        assertNotNull(ints);
    }

    @Test
    void parse2DIntList() {
        List<List<Integer>> lists = ArrayParse.parse2DIntList("[[1,1],[1,1]]");
        assertEquals(2, lists.size());
    }
}