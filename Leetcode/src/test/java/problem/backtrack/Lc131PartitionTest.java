package problem.backtrack;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Lc131PartitionTest {

    @Test
    void partition() {
        assertEquals(ArrayParse.parse2DStringList("[[\"a\",\"a\",\"b\"],[\"aa\",\"b\"]]"), new Lc131Partition().partition("aab"));
    }
}