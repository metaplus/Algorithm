package problem.array.substring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc3144MinimumSubstringsInPartitionTest {

    @Test
    void minimumSubstringsInPartition() {
        assertEquals(3, new Lc3144MinimumSubstringsInPartition().minimumSubstringsInPartition("fabccddg"));
        assertEquals(2, new Lc3144MinimumSubstringsInPartition().minimumSubstringsInPartition("abababaccddb"));
    }
}