package problem.dp;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc1143LongestCommonSubsequenceTest {

    @Test
    void longestCommonSubsequence() {
        assertEquals(3, new Lc1143LongestCommonSubsequence().longestCommonSubsequence("abcde", "ace"));
    }
}