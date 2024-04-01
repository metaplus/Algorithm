package problem.search;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;
import problem.deque.Lc127LadderLength;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc127LadderLengthTest {

    @Test
    void ladderLength() {
        assertEquals(3, new Lc127LadderLength().ladderLength("hot", "dog", ArrayParse.parseStringList("[\"hot\",\"dog\",\"dot\"]")));
        assertEquals(2, new Lc127LadderLength().ladderLength("a", "c", ArrayParse.parseStringList("[\"a\",\"b\",\"c\"]")));
        assertEquals(2, new Lc127LadderLength().ladderLength("a", "c", ArrayParse.parseStringList("[\"a\",\"b\",\"c\"]")));
        assertEquals(5, new Lc127LadderLength().ladderLength("hit", "cog", ArrayParse.parseStringList("[\"hot\",\"dot\",\"dog\",\"lot\",\"log\",\"cog\"]")));
    }
}