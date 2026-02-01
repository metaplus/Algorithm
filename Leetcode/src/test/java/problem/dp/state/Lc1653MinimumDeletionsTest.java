package problem.dp.state;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc1653MinimumDeletionsTest {

    @Test
    void minimumDeletions() {
        assertEquals(2, new Lc1653MinimumDeletions().minimumDeletions("aababbab"));
    }
}