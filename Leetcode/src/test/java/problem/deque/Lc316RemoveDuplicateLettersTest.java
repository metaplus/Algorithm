package problem.deque;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc316RemoveDuplicateLettersTest {

    @Test
    void removeDuplicateLetters() {
        assertEquals("abc", new Lc316RemoveDuplicateLetters().removeDuplicateLetters("abacb"));
        assertEquals("acb", new Lc316RemoveDuplicateLetters().removeDuplicateLetters("ccacbaba"));
        assertEquals("acdb", new Lc316RemoveDuplicateLetters().removeDuplicateLetters("cbacdcbc"));
        assertEquals("abc", new Lc316RemoveDuplicateLetters().removeDuplicateLetters("bcabc"));
    }
}