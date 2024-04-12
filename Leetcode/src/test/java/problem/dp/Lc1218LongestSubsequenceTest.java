package problem.dp;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc1218LongestSubsequenceTest {

    @Test
    void longestSubsequence() {
        assertEquals(4, new Lc1218LongestSubsequence().longestSubsequence(ArrayParse.parseIntArray("[1,5,7,8,5,3,4,2,1]"), -2));
        assertEquals(4, new Lc1218LongestSubsequence().longestSubsequence(ArrayParse.parseIntArray("[1,2,3,4]"), 1));
    }
}