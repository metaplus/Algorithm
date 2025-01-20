package problem.backtrack;

import base.AlgorithmTest;
import base.AlgorithmTestBase;
import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;
import problem.search.dfs.Lc17LetterCombinations;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc17LetterCombinationsTest extends AlgorithmTest {

    @Test
    void letterCombinations() {
        assertSortedEquals(ArrayParse.parseStringList("[\"ad\",\"ae\",\"af\",\"bd\",\"be\",\"bf\",\"cd\",\"ce\",\"cf\"]"), new Lc17LetterCombinations().letterCombinations("23"));
    }
}