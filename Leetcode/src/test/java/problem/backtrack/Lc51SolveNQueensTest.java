package problem.backtrack;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;
import problem.search.dfs.Lc51SolveNQueens;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc51SolveNQueensTest {

    @Test
    void solveNQueens() {
        assertEquals(ArrayParse.parse2DStringList("[[\".Q..\",\"...Q\",\"Q...\",\"..Q.\"],[\"..Q.\",\"Q...\",\"...Q\",\".Q..\"]]"), new Lc51SolveNQueens().solveNQueens(4));
    }
}