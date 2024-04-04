package problem;

import org.junit.jupiter.api.Test;
import problem.array.Lc14LongestCommonPrefix;

import static org.junit.jupiter.api.Assertions.*;

class Lc14LongestCommonPrefixTest {

    @Test
    void longestCommonPrefix() {
        assertEquals("", new Lc14LongestCommonPrefix().longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        assertEquals("fl", new Lc14LongestCommonPrefix().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }
}