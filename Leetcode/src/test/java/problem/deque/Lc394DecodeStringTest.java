package problem.deque;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lc394DecodeStringTest {

    @Test
    void decodeString() {
        assertEquals("abccdcdcdxyz",new Lc394DecodeString().decodeString("abc3[cd]xyz"));
        assertEquals("abcabccdcdcdef",new Lc394DecodeString().decodeString("2[abc]3[cd]ef"));
        assertEquals("accaccacc",new Lc394DecodeString().decodeString("3[a2[c]]"));
    }
}