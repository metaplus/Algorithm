package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc340LengthOfLongestSubstringKDistinctTest {

    @Test
    void lengthOfLongestSubstringKDistinct() {
        assertEquals(2, new Lc340LengthOfLongestSubstringKDistinct().lengthOfLongestSubstringKDistinct("abee", 1));
    }
}