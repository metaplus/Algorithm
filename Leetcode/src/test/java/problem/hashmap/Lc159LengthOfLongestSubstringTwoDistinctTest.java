package problem.hashmap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc159LengthOfLongestSubstringTwoDistinctTest {

    @Test
    void lengthOfLongestSubstringTwoDistinct() {
        assertEquals(5, new Lc159LengthOfLongestSubstringTwoDistinct().lengthOfLongestSubstringTwoDistinct("ccaabbb"));
        assertEquals(3, new Lc159LengthOfLongestSubstringTwoDistinct().lengthOfLongestSubstringTwoDistinct("eceba"));
    }
}