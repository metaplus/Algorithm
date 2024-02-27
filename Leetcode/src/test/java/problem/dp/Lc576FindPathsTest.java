package problem.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc576FindPathsTest {

    @Test
    void findPaths() {
        assertEquals(102984580, new Lc576FindPaths().findPaths(8, 7, 16, 1, 5));
        assertEquals(12, new Lc576FindPaths().findPaths(1, 3, 3, 0, 1));
        assertEquals(6, new Lc576FindPaths().findPaths(2, 2, 2, 0, 0));
    }
}