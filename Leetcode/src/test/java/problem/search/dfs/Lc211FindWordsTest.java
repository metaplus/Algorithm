package problem.search.dfs;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc211FindWordsTest {

    @Test
    void findWords() {
        assertEquals(ArrayParse.parseStringList("[\"oath\",\"eat\"]"),
                new Lc211FindWords().findWords(ArrayParse.parse2DCharArray("[[\"o\",\"a\",\"a\",\"n\"],[\"e\",\"t\",\"a\",\"e\"],[\"i\",\"h\",\"k\",\"r\"],[\"i\",\"f\",\"l\",\"v\"]]"),
                        ArrayParse.parseStringArray("[\"oath\",\"pea\",\"eat\",\"rain\"]")));
    }
}