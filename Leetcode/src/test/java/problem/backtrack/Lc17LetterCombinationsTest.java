package problem.backtrack;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc17LetterCombinationsTest {

    @Test
    void letterCombinations() {
        assertEquals(ArrayParse.parseStringList("[\"ad\",\"ae\",\"af\",\"bd\",\"be\",\"bf\",\"cd\",\"ce\",\"cf\"]"), new Lc17LetterCombinations().letterCombinations("23"));
    }
}