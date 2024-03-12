package problem.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc1208EqualSubstringTest {

    @Test
    void equalSubstring() {
        assertEquals(2, new Lc1208EqualSubstring().equalSubstring(
                "krrgw", "zjxss", 19));
    }
}