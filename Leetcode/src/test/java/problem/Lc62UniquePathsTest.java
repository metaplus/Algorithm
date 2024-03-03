package problem;

import org.junit.jupiter.api.Test;
import problem.dp.Lc62UniquePaths;

import static org.junit.jupiter.api.Assertions.*;

class Lc62UniquePathsTest {

    @Test
    void uniquePaths() {
        assertEquals(new Lc62UniquePaths().uniquePaths(7, 3), 28);
        assertEquals(new Lc62UniquePaths().uniquePaths(3, 2), 3);
    }
}