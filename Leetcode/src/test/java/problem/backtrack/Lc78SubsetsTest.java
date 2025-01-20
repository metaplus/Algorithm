package problem.backtrack;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;
import problem.search.dfs.Lc78Subsets;

import static org.junit.jupiter.api.Assertions.*;

class Lc78SubsetsTest {

    @Test
    void subsets() {
        assertEquals(ArrayParse.parse2DIntList("[[], [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]]"),
                new Lc78Subsets().subsets(ArrayParse.parseIntArray("[1,2,3]")));
    }
}