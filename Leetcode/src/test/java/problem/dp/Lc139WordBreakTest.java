package problem.dp;

import org.junit.jupiter.api.Test;
import problem.array.parse.ArrayParse;

import static org.junit.jupiter.api.Assertions.*;

class Lc139WordBreakTest {

    @Test
    void wordBreak() {
        assertTrue(new Lc139WordBreak().wordBreak("aaaaaaa", ArrayParse.parseStringList("[\"aaaa\",\"aaa\"]")));
        assertTrue(new Lc139WordBreak().wordBreak("applepenapple", ArrayParse.parseStringList("[\"apple\", \"pen\"]")));
    }
}