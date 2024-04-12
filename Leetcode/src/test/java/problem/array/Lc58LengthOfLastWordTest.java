package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc58LengthOfLastWordTest {

    @Test
    void lengthOfLastWord() {
        assertEquals(1, new Lc58LengthOfLastWord().lengthOfLastWord("a "));
        assertEquals(5, new Lc58LengthOfLastWord().lengthOfLastWord("Hello World"));
    }

}