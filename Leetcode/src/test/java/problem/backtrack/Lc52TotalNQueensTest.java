package problem.backtrack;

import org.junit.jupiter.api.Test;
import problem.search.dfs.Lc52TotalNQueens;

import static org.junit.jupiter.api.Assertions.*;

class Lc52TotalNQueensTest {

    @Test
    void totalNQueens() {
        assertEquals(2,new Lc52TotalNQueens().totalNQueens(4));
    }
}