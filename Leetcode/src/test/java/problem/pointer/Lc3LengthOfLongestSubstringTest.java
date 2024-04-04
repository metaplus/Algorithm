package problem.pointer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc3LengthOfLongestSubstringTest {

    @Test
    void lengthOfLongestSubstring() {
        assertEquals(3,new Lc3LengthOfLongestSubstring().lengthOfLongestSubstring("pwwkew"));
        assertEquals(3,new Lc3LengthOfLongestSubstring().lengthOfLongestSubstring("abcabcbb"));
    }
}