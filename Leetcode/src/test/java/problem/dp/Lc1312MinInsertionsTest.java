package problem.dp;

import org.junit.jupiter.api.Test;
import problem.dp.sequence.Lc1312MinInsertions;

import static org.junit.jupiter.api.Assertions.*;

class Lc1312MinInsertionsTest {

    @Test
    void minInsertions() {
        assertEquals(2,new Lc1312MinInsertions().minInsertions("mbadm"));
        assertEquals(5,new Lc1312MinInsertions().minInsertions("leetcode"));
    }
}