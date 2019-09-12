package util;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TranslateTest {

    @ParameterizedTest
    @ValueSource(strings = "[\n"
            + "  [0,0,0],\n"
            + "  [0,1,0],\n"
            + "  [0,0,0]\n"
            + "]")
    void grid(String input) {
        int[][] grid = Translate.grid(input);
        assertEquals(grid.length, 3);
        assertArrayEquals(grid[0], new int[] {0, 0, 0});
        assertArrayEquals(grid[1], new int[] {0, 1, 0});
        assertArrayEquals(grid[2], new int[] {0, 0, 0});
    }
}