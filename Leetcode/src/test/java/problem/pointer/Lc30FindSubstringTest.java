package problem.pointer;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc30FindSubstringTest {

    @Test
    void findSubstring() {
        assertEquals(ArrayParse.parseIntList("[8]"), new Lc30FindSubstring().findSubstring("wordgoodgoodgoodbestword", ArrayParse.parseStringArray("[\"word\",\"good\",\"best\",\"good\"]")));
    }
}