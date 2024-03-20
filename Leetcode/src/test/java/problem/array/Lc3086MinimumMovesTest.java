package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc3086MinimumMovesTest {

    @Test
    void minimumMoves() {
        assertEquals(6, new Lc3086MinimumMoves().minimumMoves(new int[]{1,1,0,0,1}, 4, 1));
        assertEquals(6, new Lc3086MinimumMoves().minimumMoves(new int[]{1, 1, 1, 1}, 5, 4));
        assertEquals(8, new Lc3086MinimumMoves().minimumMoves(new int[]{1, 0, 0, 1}, 5, 5));
        assertEquals(4, new Lc3086MinimumMoves().minimumMoves(new int[]{1, 0, 0}, 3, 4));
        assertEquals(2, new Lc3086MinimumMoves().minimumMoves(new int[]{0, 1}, 2, 1));
        assertEquals(2, new Lc3086MinimumMoves().minimumMoves(new int[]{0, 0}, 1, 1));
        assertEquals(7, new Lc3086MinimumMoves().minimumMoves(new int[]{1, 0, 0, 1}, 4, 2));
        assertEquals(3, new Lc3086MinimumMoves().minimumMoves(new int[]{1, 1, 0, 0, 0, 1, 1, 0, 0, 1}, 3, 1));
        assertEquals(0, new Lc3086MinimumMoves().minimumMoves(new int[]{0, 1}, 1, 0));
        assertEquals(6, new Lc3086MinimumMoves().minimumMoves(new int[]{0, 0}, 3, 3));
        assertEquals(4, new Lc3086MinimumMoves().minimumMoves(new int[]{1, 0, 1}, 3, 2));
    }
}