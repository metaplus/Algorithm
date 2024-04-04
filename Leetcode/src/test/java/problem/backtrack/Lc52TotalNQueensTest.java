package problem.backtrack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc52TotalNQueensTest {

    @Test
    void totalNQueens() {
        assertEquals(2,new Lc52TotalNQueens().totalNQueens(4));
    }
}